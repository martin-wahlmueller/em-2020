package at.ooe.fr.uwb.em.repositories;

import at.ooe.fr.uwb.em.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends CrudRepository<Group, Integer> {

}
