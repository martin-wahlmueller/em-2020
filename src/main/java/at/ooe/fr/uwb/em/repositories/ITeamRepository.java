package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends CrudRepository<Team, Integer> {

}
