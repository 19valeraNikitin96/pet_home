package app.service.advertisement;

import app.controller.model.AdvertisementJSON;

public interface AdvertisementService {

    Integer create(AdvertisementJSON json);
}
