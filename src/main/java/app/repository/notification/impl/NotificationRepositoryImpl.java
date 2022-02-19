package app.repository.notification.impl;

import app.repository.notification.NotificationRepository;
import app.repository.user.model.NotificationEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class NotificationRepositoryImpl implements NotificationRepository {

    private Integer id = 1;
    private HashMap<Integer, NotificationEntity> db = new HashMap<>();

    @Override
    public Integer create(NotificationEntity entity) {
        //TODO check owner entity existence
        db.put(id, entity);
        entity.setId(this.id);
        this.id++;
        return entity.getId();
    }
}
