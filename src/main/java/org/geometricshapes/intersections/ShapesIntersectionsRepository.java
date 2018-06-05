package org.geometricshapes.intersections;

import org.geometricshapes.intersections.entities.SquareAndLineIntersections;
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
