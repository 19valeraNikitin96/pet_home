package app.service.user.utils;

import app.controller.user.model.NotificationJSON;
import app.controller.user.model.UserJSON;
import app.repository.user.model.NotificationEntity;
import app.repository.user.model.UserEntity;

public interface UserUtils {
    UserEntity toEntity(UserJSON json);
    NotificationEntity toEntity(NotificationJSON json);
}
