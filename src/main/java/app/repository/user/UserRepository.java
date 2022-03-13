package app.repository.user;

import app.repository.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity save(UserEntity persisted);

    Optional<UserEntity> findById(Integer id);

    void delete(UserEntity id);

    List<UserEntity> findAll();
}