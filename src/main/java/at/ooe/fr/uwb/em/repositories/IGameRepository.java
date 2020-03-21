package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends CrudRepository<Game, Integer> {
}
