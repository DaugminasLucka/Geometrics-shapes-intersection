package org.geometricshapes.intersections.persistence;

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
