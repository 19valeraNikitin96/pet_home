package app.service.user;

import app.controller.user.security.CustomUserDetails;
import app.controller.user.model.UserJSON;
import app.repository.user.model.UserEntity;

public interface UserService {
    Integer create(UserJSON json);

    UserJSON getById();
    Integer updateUser(UserJSON json);

    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);

    CustomUserDetails loadUserByUsername(String username);

    Integer getCurrentUserId();

    void activate(String token);

    boolean isActivated(String email);
}
