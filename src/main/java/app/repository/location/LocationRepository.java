package app.repository.location;

import app.repository.location.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    LocationEntity save(LocationEntity persisted);

    Optional<LocationEntity> findById(Integer id);

    void delete(LocationEntity id);

    List<LocationEntity> findAll();
}
