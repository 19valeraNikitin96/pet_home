package app.service.user;

import app.controller.user.model.UserJSON;

public interface UserService {
    Integer create(UserJSON json);

    UserJSON getById(Integer id);

    Integer updateUser(Integer id, UserJSON json);
}
