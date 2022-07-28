package app.controller.user;

import app.controller.user.security.JwtProvider;
import app.controller.user.model.AuthRequestJSON;
import app.controller.user.model.UserJSON;
import app.repository.user.model.UserEntity;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/users")
    public ResponseEntity getById() {
        return ResponseEntity.ok(userService.getById());
    }

    @PutMapping("/users")
    public ResponseEntity update(@RequestBody UserJSON json){
        Integer userId = userService.updateUser(json);
        Object obj = new Object(){
            {
                setId(userId);
            }

            private Integer id;

            public void setId(Integer id){
                this.id = id;
            }

            public Integer getId(){
                return this.id;
            }
        };
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/users/register")
    public ResponseEntity registerUser(@RequestBody UserJSON user) {
        Integer userId = userService.create(user);
        Object obj = new Object(){
            {
                setId(userId);
            }

            private Integer id;

            public void setId(Integer id){
                this.id = id;
            }

            public Integer getId(){
                return this.id;
            }
        };
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/activation/{token}")
    public ResponseEntity activate(@PathVariable String token){
        try{
            userService.activate(token);
            return ResponseEntity.ok().build();
        }catch (Exception exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/users/auth")
    public ResponseEntity auth(@RequestBody AuthRequestJSON request) {
        UserEntity u;
        try {
            u = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            if (u == null) {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
        String email = u.getPerson().getEmailAddresses().get(0);
        if (!userService.isActivated(email)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String generatedToken = jwtProvider.generateToken(u.getUsername());
        Object obj = new Object(){
            {
                setToken(generatedToken);
            }

            private String token;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        };
        return ResponseEntity.ok(obj);
    }
}
