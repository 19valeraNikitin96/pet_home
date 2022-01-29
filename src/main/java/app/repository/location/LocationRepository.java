package app.repository.location;

import app.repository.location.model.LocationEntity;

public interface LocationRepository {

    Integer create(LocationEntity entity);

    void update(LocationEntity entity);

    LocationEntity get(Integer id);

    void delete(Integer id);

    Integer find(LocationEntity entity);
}
