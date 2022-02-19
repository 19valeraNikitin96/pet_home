package app.repository.person.impl;

import app.repository.person.PersonRepository;
import app.repository.user.model.NotificationEntity;
import app.repository.user.model.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PersonRepositoryImpl implements PersonRepository {
    private Integer id = 1;
    private HashMap<Integer, PersonEntity> db = new HashMap<>();

    @Override
    public Integer create(PersonEntity entity) {
        //TODO check owner entity existence
        db.put(id, entity);
        entity.setId(this.id);
        this.id++;
        return entity.getId();
    }
}
