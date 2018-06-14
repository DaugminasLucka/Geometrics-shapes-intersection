package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ShapeCoordinates {
	private CoordinatePoint pointOne;
	private CoordinatePoint pointTwo;
	
	public CoordinatePoint getPointOne() {
		return pointOne;
	}
	@JsonProperty(required=true)
	public void setPointOne(CoordinatePoint pointOne) {
		this.pointOne = pointOne;
	}
	public CoordinatePoint getPointTwo() {
		return pointTwo;
	}
	@JsonProperty(required=true)
	public void setPointTwo(CoordinatePoint pointTwo) {
		this.pointTwo = pointTwo;
	}
}
