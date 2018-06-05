package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class IntersectingShapes {
	private ShapeCoordinates line;
	private SquareCoordinates square;
	
	public ShapeCoordinates getLine() {
		return line;
	}
	@JsonProperty(required=true)
	public void setLine(ShapeCoordinates line) {
		this.line = line;
	}
	public SquareCoordinates getSquare() {
		return square;
	}
	@JsonProperty(required=true)
	public void setSquare(SquareCoordinates square) {
		this.square = square;
	}
}
