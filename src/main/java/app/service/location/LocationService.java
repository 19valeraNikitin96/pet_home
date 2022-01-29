package app.service.location;

import app.repository.location.model.LocationEntity;

public interface LocationService {
    Integer find(LocationEntity entity);

    Integer create(LocationEntity entity);

    LocationEntity get(Integer id);
}
