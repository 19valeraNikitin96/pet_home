package app.controller.user;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.AdvertisementRequestJSON;
import app.controller.user.model.UserJSON;
import app.service.advertisement.AdvertisementService;
import app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

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
}
