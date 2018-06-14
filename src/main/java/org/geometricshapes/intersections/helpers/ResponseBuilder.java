package org.geometricshapes.intersections.helpers;

import java.util.ArrayList;
import java.util.List;

import org.geometricshapes.intersections.entities.ApiResource;
import org.geometricshapes.intersections.entities.ErrorResponse;
import org.geometricshapes.intersections.entities.ProcessedIntersections;
import org.geometricshapes.intersections.entities.ProcessedIntersectionsResponse;
import org.geometricshapes.intersections.entities.ResourceTypes;
import org.geometricshapes.intersections.entities.ShapesIntersections;
import org.geometricshapes.intersections.entities.ShapesIntersectionsResponse;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ResponseBuilder {

	public ShapesIntersectionsResponse buildShapesIntersErrorResponse(
			String errorCode, String errorTitle, String errorMsg) {
		ErrorResponse sqlError = new ErrorResponse(errorCode, errorTitle, errorMsg);
		List<ErrorResponse> errors = new ArrayList<>();
		errors.add(sqlError);
		return new ShapesIntersectionsResponse(errors);
	}
	
	public ShapesIntersectionsResponse buildShapesIntersResponse(
			ShapesIntersections shapesIntersects) {
		
		ApiResource<ShapesIntersections> apiResource = new ApiResource<>(
				ResourceTypes.INTERSECTIONS.getName(), shapesIntersects);
		
		return new ShapesIntersectionsResponse(apiResource);
	}
	
	public ProcessedIntersectionsResponse buildProcessedIntersResponse(
			String errorCode, String errorTitle, String errorMsg) {
		ErrorResponse sqlError = new ErrorResponse(errorCode, errorTitle, errorMsg);
		List<ErrorResponse> errors = new ArrayList<>();
		errors.add(sqlError);
		return new ProcessedIntersectionsResponse(errors);
	}
	
	public ProcessedIntersectionsResponse buildProcessedIntersResponse(
			ProcessedIntersections processedInters) {
		
		ApiResource<ProcessedIntersections> apiResource = new ApiResource<>(
				ResourceTypes.PROCESSEDINTERS.getName(), processedInters);
		
		return new ProcessedIntersectionsResponse(apiResource);
		
	}
	
}
