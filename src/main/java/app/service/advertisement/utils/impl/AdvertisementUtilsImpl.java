package app.service.advertisement.utils.impl;

import app.controller.advertisement.model.AdvertisementJSON;
import app.controller.advertisement.model.DateJSON;
import app.repository.date.model.DateEntity;
import app.repository.advertisement.model.AdvertisementEntity;
import app.repository.location.model.LocationEntity;
import app.repository.user.UserRepository;
import app.service.advertisement.utils.AdvertisementUtils;
import app.service.location.LocationService;
import app.service.location.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvertisementUtilsImpl implements AdvertisementUtils {

    @Autowired
    private LocationUtils locationUtils;
    @Autowired
    private UserRepository userRepository;

    @Override
    public AdvertisementEntity toEntity(AdvertisementJSON json) {
        AdvertisementEntity res = new AdvertisementEntity();
        res.setPetName(json.getPetName());
        res.setAge(json.getAge());
        res.setId(json.getId());
        // TODO fix warning
        res.setOwner(userRepository.findById(json.getOwnerId()).get());
        res.setSigns(json.getSigns());
        res.setType(json.getType());
        {
            LocationEntity location = locationUtils.toEntity(json.getLocation());
            res.setLocation(location);
        }
        res.setDate(this.toEntity(json.getDate()));
        return res;
    }

    @Override
    public AdvertisementJSON toJSON(AdvertisementEntity entity) {
        AdvertisementJSON json = new AdvertisementJSON();
        json.setPetName(entity.getPetName());
        json.setAge(entity.getAge());
        json.setId(entity.getId());
        json.setOwnerId(entity.getOwner().getId());
        json.setSigns(entity.getSigns());
        json.setType(entity.getType());
        {
            LocationEntity location = entity.getLocation();
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
