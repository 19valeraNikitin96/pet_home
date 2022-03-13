package app.repository.person;

import app.repository.user.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    PersonEntity save(PersonEntity persisted);

    Optional<PersonEntity> findById(Integer id);

    void delete(PersonEntity id);

    List<PersonEntity> findAll();
}
