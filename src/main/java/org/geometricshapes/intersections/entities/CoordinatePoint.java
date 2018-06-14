package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinatePoint {
	
	private Integer coordinateX;
	private Integer coordinateY;
	
	public CoordinatePoint(Integer coordinateX, Integer coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
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
