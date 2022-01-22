package app.service.advertisemnt.utils;

import app.controller.model.AdvertisementJSON;
import app.repository.advertisement.model.AdvertisementEntity;

public interface AdvertisementUtils {

    AdvertisementEntity toEntity(AdvertisementJSON json);

    AdvertisementJSON toJSON(AdvertisementEntity entity);
}
