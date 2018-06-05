package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class SquareCoordinates extends ShapeCoordinates {
	
	private Integer width;
	private Integer height;
	
	public Integer getWidth() {
		return width;
	}
	@JsonProperty(required=true)
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	@JsonProperty(required=true)
	public void setHeight(Integer height) {
		this.height = height;
	}
}
