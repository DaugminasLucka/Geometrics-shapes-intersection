package org.geometricshapes.intersections.entities;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class IntersectingShapesRequest {
	private ApiResource<IntersectingShapes> data;

	public ApiResource<IntersectingShapes> getData() {
		return data;
	}

	public void setData(ApiResource<IntersectingShapes> data) {
		this.data = data;
	}
}
