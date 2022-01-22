package app.repository.advertisement;

import app.repository.advertisement.model.AdvertisementEntity;

public interface AdvertisementRepository {

    Integer create(AdvertisementEntity entity);

    void update(AdvertisementEntity entity);

    AdvertisementEntity get(Integer id);

    void delete(Integer id);
}
