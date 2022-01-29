package app.service.advertisement.utils;

import app.controller.model.AdvertisementJSON;
import app.controller.model.DateJSON;
import app.repository.DateEntity;
import app.repository.advertisement.model.AdvertisementEntity;

public interface AdvertisementUtils {

    AdvertisementEntity toEntity(AdvertisementJSON json);

    AdvertisementJSON toJSON(AdvertisementEntity entity);

    DateEntity toEntity(DateJSON json);

    DateJSON toJSON(DateEntity entity);
}
