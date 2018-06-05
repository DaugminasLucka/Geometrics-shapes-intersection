package org.geometricshapes.intersections;

import org.geometricshapes.intersections.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
