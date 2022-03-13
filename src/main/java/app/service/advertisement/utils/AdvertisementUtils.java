package app.service.advertisement.utils;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.DateJSON;
import app.repository.date.model.DateEntity;
import app.repository.advertisement.model.AdvertisementEntity;

public interface AdvertisementUtils {

    AdvertisementEntity toEntity(AdvertisementJSON json);

    AdvertisementJSON toJSON(AdvertisementEntity entity);

    DateEntity toEntity(DateJSON json);

    DateJSON toJSON(DateEntity entity);
}
