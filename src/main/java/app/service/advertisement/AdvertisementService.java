package app.service.advertisement;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.AdvertisementRequestJSON;

import java.util.List;

public interface AdvertisementService {

    Integer create(AdvertisementJSON json);

    List<Integer> getAdvertisementIds(AdvertisementRequestJSON json);
}
