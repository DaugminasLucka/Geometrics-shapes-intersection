package org.geometricshapes.intersections.services;

import javax.servlet.http.HttpServletRequest;

import org.geometricshapes.intersections.entities.IntersectingShapesRequest;
import org.geometricshapes.intersections.entities.ProcessedIntersectionsResponse;
import org.geometricshapes.intersections.entities.ShapesIntersectionsResponse;

/**
 * Shapes intersections service.
 * 
 * @author Mindaugas Lucka
 *
 */
public interface ShapesIntersectionsService {

	ShapesIntersectionsResponse calculateSquareAndLineInters(IntersectingShapesRequest requestPayload);

	ProcessedIntersectionsResponse retrieveSquareAndLineInters(HttpServletRequest request);

}
