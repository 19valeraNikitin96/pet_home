package app.repository.location.impl;

import app.repository.location.LocationRepository;
import app.repository.location.model.LocationEntity;

import java.util.HashMap;
import java.util.Map;

public class LocationRepositoryImpl implements LocationRepository {

    private Integer id = 1;
    private HashMap<Integer, LocationEntity> db = new HashMap<>();

    @Override
    public Integer create(LocationEntity entity) {
        db.put(id, entity);
        entity.setId(this.id);
        this.id++;
        return entity.getId();
    }

    @Override
    public void update(LocationEntity entity) {
        LocationEntity dbEntity = this.db.get(entity.getId());
        if (entity.getCity() != null) {
            dbEntity.setCity(entity.getCity());
        }
        if (entity.getStreet() != null) {
            dbEntity.setStreet(entity.getStreet());
        }
        if (entity.getDistrict() != null) {
            dbEntity.setDistrict(entity.getDistrict());
        }
    }

    @Override
    public LocationEntity get(Integer id) {
        return db.get(id);
    }

    @Override
    public void delete(Integer id) {
        db.remove(id);
    }

    @Override
    public Integer find(LocationEntity entity) {
        for (Map.Entry<Integer, LocationEntity> entry : this.db.entrySet()){
            LocationEntity dbEntity = entry.getValue();
            if (!dbEntity.equals(entity)){
                continue;
            }
            return entry.getKey();
        }
        throw new RuntimeException("Entry is not found");
    }
}
