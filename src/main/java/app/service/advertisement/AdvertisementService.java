package app.service.advertisement;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.AdvertisementRequestJSON;

import java.util.List;

public interface AdvertisementService {

    Integer create(AdvertisementJSON json);

    List<Integer> getAdvertisementIds(AdvertisementRequestJSON json);

    AdvertisementJSON getBy(Integer advertisementId);

    void deleteBy(Integer advertisementId);

    List<AdvertisementJSON> getAll();

    Integer updateBy(Integer advertisementId, AdvertisementJSON json);
}
