package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class IntersectionPoints {
	
	private CoordinatePoint intersectionPointOne;
	private CoordinatePoint intersectionPointTwo;
	
	public CoordinatePoint getIntersectionPointOne() {
		return intersectionPointOne;
	}
	@JsonProperty(required=false)
	public void setIntersectionPointOne(CoordinatePoint intersectionPointOne) {
		this.intersectionPointOne = intersectionPointOne;
	}
	public CoordinatePoint getIntersectionPointTwo() {
		return intersectionPointTwo;
	}
	@JsonProperty(required=false)
	public void setIntersectionPointTwo(CoordinatePoint intersectionPointTwo) {
		this.intersectionPointTwo = intersectionPointTwo;
	}
	
}
