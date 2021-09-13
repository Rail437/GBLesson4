package gb.spring.lesson4.repository;

import gb.spring.lesson4.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepo extends CrudRepository<PersonEntity, Long> {

    Optional<PersonEntity> findById(Long id);
    PersonEntity findByName(String name);
}
