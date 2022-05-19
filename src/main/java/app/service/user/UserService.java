package app.service.user;

import app.controller.user.security.CustomUserDetails;
import app.controller.user.model.UserJSON;
import app.repository.user.model.UserEntity;

public interface UserService {
    Integer create(UserJSON json);

    UserJSON getById(Integer id);
    Integer updateUser(Integer id, UserJSON json);

    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);

    CustomUserDetails loadUserByUsername(String username);

    Integer getCurrentUserId();
}
