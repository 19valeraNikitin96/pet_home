package app.repository.activation;

import app.repository.activation.model.ActivationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivationRepository extends JpaRepository<ActivationEntity, Integer> {
    ActivationEntity save(ActivationEntity persisted);

    Optional<ActivationEntity> findById(Integer id);

    Optional<ActivationEntity> findByEmail(String email);

    Optional<ActivationEntity> findByToken(String token);

    void delete(ActivationEntity entity);

    List<ActivationEntity> findAll();
}
