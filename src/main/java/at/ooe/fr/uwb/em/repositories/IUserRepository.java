package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
