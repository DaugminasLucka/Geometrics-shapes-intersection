package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class IntersectingShapes {
	private ShapeCoordinates line;
	private ShapeCoordinates square;
	
	public ShapeCoordinates getLine() {
		return line;
	}
	@JsonProperty(required=true)
	public void setLine(ShapeCoordinates line) {
		this.line = line;
	}
	public ShapeCoordinates getSquare() {
		return square;
	}
	@JsonProperty(required=true)
	public void setSquare(ShapeCoordinates square) {
		this.square = square;
	}
}
