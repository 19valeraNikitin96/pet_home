package app.repository.advertisement;

import app.repository.advertisement.model.AdvertisementEntity;

import java.util.List;

public interface AdvertisementRepository {

    Integer create(AdvertisementEntity entity);

    void update(AdvertisementEntity entity);

    AdvertisementEntity get(Integer id);

    void delete(Integer id);

    List<AdvertisementEntity> getAll();
}
