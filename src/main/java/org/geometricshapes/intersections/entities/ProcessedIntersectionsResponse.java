package org.geometricshapes.intersections.entities;

import java.util.List;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ProcessedIntersectionsResponse {

	private ApiResource<ProcessedIntersections> data;
	private List<ErrorResponse> errors;
	
	public ProcessedIntersectionsResponse() {}
	
	public ProcessedIntersectionsResponse(
			ApiResource<ProcessedIntersections> data) {
		this.data = data;
	}
	
	public ProcessedIntersectionsResponse(List<ErrorResponse> errors) {
		this.errors = errors;
	}
	
	public ApiResource<ProcessedIntersections> getData() {
		return data;
	}

	public void setData(ApiResource<ProcessedIntersections> data) {
		this.data = data;
	}

	public List<ErrorResponse> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponse> errors) {
		this.errors = errors;
	}
	
}
