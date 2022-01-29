package app.service.location.utils;

import app.controller.model.LocationJSON;
import app.repository.location.model.LocationEntity;

public class LocationUtilsImpl implements LocationUtils {

    @Override
    public LocationEntity toEntity(LocationJSON json) {
        LocationEntity entity = new LocationEntity();
        entity.setId(json.getId());
        entity.setCity(json.getCity());
        entity.setDistrict(json.getDistrict());
        entity.setStreet(json.getStreet());
        return entity;
    }

    @Override
    public LocationJSON toJSON(LocationEntity entity) {
        LocationJSON json = new LocationJSON();
        json.setId(entity.getId());
        json.setCity(entity.getCity());
        json.setDistrict(entity.getDistrict());
        json.setStreet(entity.getStreet());
        return json;
    }
}
