package app.repository.messenger;

import app.repository.messenger.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

    MessageEntity save(MessageEntity persisted);

    Optional<MessageEntity> findById(Integer id);

    void delete(MessageEntity entity);

    List<MessageEntity> findAll();
}
