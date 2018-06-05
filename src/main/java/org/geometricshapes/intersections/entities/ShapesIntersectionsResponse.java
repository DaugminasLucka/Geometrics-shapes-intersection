package org.geometricshapes.intersections.entities;

import java.util.List;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ShapesIntersectionsResponse {
	
	private ApiResource<ShapesIntersections> data;
	private List<ErrorResponse> errors;
	
	public ShapesIntersectionsResponse(ApiResource<ShapesIntersections> data) {
		this.data = data;
	}
	
	public ShapesIntersectionsResponse(List<ErrorResponse> errors) {
		this.errors = errors;
	}
	
	public ShapesIntersectionsResponse() {}
	
	public ApiResource<ShapesIntersections> getData() {
		return data;
	}

	public void setData(ApiResource<ShapesIntersections> data) {
		this.data = data;
	}

	public List<ErrorResponse> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponse> errors) {
		this.errors = errors;
	}
	
}
