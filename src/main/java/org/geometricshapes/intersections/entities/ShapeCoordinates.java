package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ShapeCoordinates {
	private Integer coordinateX;
	private Integer coordinateY;
	
	public Integer getCoordinateX() {
		return coordinateX;
	}
	@JsonProperty(required=true)
	public void setCoordinateX(Integer xCoordinate) {
		this.coordinateX = xCoordinate;
	}
	public Integer getCoordinateY() {
		return coordinateY;
	}
	@JsonProperty(required=true)
	public void setCoordinateY(Integer coordinateY) {
		this.coordinateY = coordinateY;
	}
}
