package app.repository.date;

import app.repository.date.model.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, Integer> {
    DateEntity save(DateEntity persisted);

    Optional<DateEntity> findById(Integer id);

    void delete(DateEntity id);

    List<DateEntity> findAll();
}