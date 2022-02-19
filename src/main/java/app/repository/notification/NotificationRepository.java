package app.repository.notification;

import app.repository.user.model.NotificationEntity;

public interface NotificationRepository {
    Integer create(NotificationEntity entity);
}
