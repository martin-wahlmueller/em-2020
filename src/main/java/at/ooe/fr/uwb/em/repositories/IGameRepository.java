package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface IGameRepository extends CrudRepository<Game, Integer> {
}
