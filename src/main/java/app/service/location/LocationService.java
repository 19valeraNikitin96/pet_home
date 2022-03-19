package app.service.location;

import app.repository.location.model.LocationEntity;

public interface LocationService {

    Integer create(LocationEntity entity);
}
