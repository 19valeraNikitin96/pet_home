package app.repository.user;

import app.repository.user.model.UserEntity;

public interface UserRepository {
    Integer create(UserEntity entity);
}
