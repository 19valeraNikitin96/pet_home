package app.service.advertisemnt.utils.impl;

import app.controller.model.AdvertisementJSON;
import app.repository.advertisement.model.AdvertisementEntity;
import app.service.advertisemnt.utils.AdvertisementUtils;

public class AdvertisementsUtilsImpl implements AdvertisementUtils {
    @Override
    public AdvertisementEntity toEntity(AdvertisementJSON json) {
        AdvertisementEntity res = new AdvertisementEntity();
        res.setPetName(json.getPetName());
        res.setAge(json.getAge());
        res.setId(json.getId());
        //TODO add setting of other fields
        return res;
    }

    @Override
    public AdvertisementJSON toJSON(AdvertisementEntity entity) {
        AdvertisementJSON res = new AdvertisementJSON();
        res.setPetName(entity.getPetName());
        res.setAge(entity.getAge());
        res.setId(entity.getId());
        //TODO add setting of other fields
        return res;
    }
}
