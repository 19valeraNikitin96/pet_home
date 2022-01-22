package app.repository.advertisement.impl;

import app.repository.advertisement.AdvertisementRepository;
import app.repository.advertisement.model.AdvertisementEntity;

import java.util.HashMap;

public class AdvertisementRepositoryImpl implements AdvertisementRepository {

    private Integer id = 1;
    private HashMap<Integer, AdvertisementEntity> db = new HashMap<>();

    @Override
    public Integer create(AdvertisementEntity entity) {
        db.put(id, entity);
        entity.setId(this.id);
        this.id++;
        return entity.getId();
    }

    @Override
    public void update(AdvertisementEntity entity) {
        AdvertisementEntity dbEntity = this.db.get(entity.getId());
        if (entity.getAge() != null) {
            dbEntity.setAge(entity.getAge());
        }
        if (entity.getPetName() != null) {
            dbEntity.setPetName(entity.getPetName());
        }
        //TODO rewrite rest of fields
    }

    @Override
    public AdvertisementEntity get(Integer id) {
        return db.get(id);
    }

    @Override
    public void delete(Integer id) {
        db.remove(id);
    }
}
