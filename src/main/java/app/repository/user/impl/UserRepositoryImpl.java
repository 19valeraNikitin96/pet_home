package app.repository.user.impl;

import app.repository.location.model.LocationEntity;
import app.repository.notification.NotificationRepository;
import app.repository.person.PersonRepository;
import app.repository.user.UserRepository;
import app.repository.user.model.NotificationEntity;
import app.repository.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserRepositoryImpl implements UserRepository {

    private Integer id = 1;
    private HashMap<Integer, UserEntity> db = new HashMap<>();

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Integer create(UserEntity entity) {
        //TODO check owner entity existence
        for (NotificationEntity notificationEntity : entity.getNotifications()){
            notificationRepository.create(notificationEntity);
        }
        personRepository.create(entity.getPersonEntity());
        db.put(id, entity);
        entity.setId(this.id);
        this.id++;
        return entity.getId();
    }
}
