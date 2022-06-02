package app.controller.user;

import app.controller.user.security.JwtProvider;
import app.controller.user.model.AuthRequestJSON;
import app.controller.user.model.UserJSON;
import app.repository.user.model.UserEntity;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody UserJSON json) {
        Integer userId = userService.create(json);
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

    @GetMapping("/users/{userId}")
    public ResponseEntity getById(@PathVariable("userId") Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity updateById(@RequestBody UserJSON json, @PathVariable("userId") Integer id){
        Integer userId = userService.updateUser(id, json);
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
