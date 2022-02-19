package app.service.advertisement.utils.impl;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.DateJSON;
import app.repository.DateEntity;
import app.repository.advertisement.model.AdvertisementEntity;
import app.repository.location.model.LocationEntity;
import app.service.advertisement.utils.AdvertisementUtils;
import app.service.location.LocationService;
import app.service.location.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvertisementUtilsImpl implements AdvertisementUtils {

    @Autowired
    private LocationUtils locationUtils;
    @Autowired
    private LocationService locationService;

    @Override
    public AdvertisementEntity toEntity(AdvertisementJSON json) {
        AdvertisementEntity res = new AdvertisementEntity();
        res.setPetName(json.getPetName());
        res.setAge(json.getAge());
        res.setId(json.getId());
        res.setOwnerId(json.getOwnerId());
        res.setSigns(json.getSigns());
        res.setType(json.getType());
        {
            LocationEntity location = locationUtils.toEntity(json.getLocation());
            Integer locationId;
            try {
                locationId = locationService.find(location);
            } catch (RuntimeException e) {
                locationId = locationService.create(location);
            }
            res.setLocationId(locationId);
        }
        res.setDate(this.toEntity(json.getDate()));
        return res;
    }

    @Override
    public AdvertisementJSON toJSON(AdvertisementEntity entity) {
        AdvertisementJSON json = new AdvertisementJSON();
        json.setPetName(json.getPetName());
        json.setAge(json.getAge());
        json.setId(json.getId());
        json.setOwnerId(json.getOwnerId());
        json.setSigns(json.getSigns());
        json.setType(json.getType());
        {
            LocationEntity location = locationService.get(entity.getLocationId());
            json.setLocation(locationUtils.toJSON(location));
        }
        json.setDate(this.toJSON(entity.getDate()));
        return json;
    }

    @Override
    public DateEntity toEntity(DateJSON json) {
        DateEntity entity = new DateEntity();
        entity.setDay(json.getDay());
        entity.setMonth(json.getMonth());
        entity.setYear(json.getYear());
        return entity;
    }

    @Override
    public DateJSON toJSON(DateEntity entity) {
        DateJSON json = new DateJSON();
        json.setDay(entity.getDay());
        json.setMonth(entity.getMonth());
        json.setYear(entity.getYear());
        return json;
    }
}
