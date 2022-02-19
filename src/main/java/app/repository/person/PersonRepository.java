package app.repository.person;

import app.repository.user.model.PersonEntity;

public interface PersonRepository {
    Integer create(PersonEntity entity);
}
