package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ShapesIntersections {

	private Boolean isIntersecting;
	private IntersectionPoints interPoints;
	
	public Boolean getIsIntersecting() {
		return isIntersecting;
	}
	@JsonProperty(required=true)
	public void setIsIntersecting(Boolean isIntersecting) {
		this.isIntersecting = isIntersecting;
	}

	public IntersectionPoints getInterPoints() {
		return interPoints;
	}
	@JsonProperty(required=true)
	public void setInterPoints(IntersectionPoints interPoints) {
		this.interPoints = interPoints;
	}
	
}
