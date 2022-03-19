package app.repository.advertisement;

import app.repository.advertisement.model.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Integer> {

    AdvertisementEntity save(AdvertisementEntity persisted);

    Optional<AdvertisementEntity> findById(Integer id);

    void delete(AdvertisementEntity entity);

    List<AdvertisementEntity> findAll();
}
