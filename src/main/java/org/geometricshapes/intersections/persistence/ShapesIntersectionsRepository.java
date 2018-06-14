package org.geometricshapes.intersections.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@Repository
public interface ShapesIntersectionsRepository extends CrudRepository<SquareAndLineIntersections, Long> {

}
