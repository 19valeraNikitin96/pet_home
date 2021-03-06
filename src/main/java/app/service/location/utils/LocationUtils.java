package app.service.location.utils;

import app.controller.advertisement.model.LocationJSON;
import app.repository.location.model.LocationEntity;

public interface LocationUtils {

    LocationEntity toEntity(LocationJSON json);

    LocationJSON toJSON(LocationEntity entity);
}
