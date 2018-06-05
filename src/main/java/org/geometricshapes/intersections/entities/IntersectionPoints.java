package org.geometricshapes.intersections.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntersectionPoints {
	
	private Integer intersectionPointOne;
	private Integer intersectionPointTwo;
	
	public Integer getIntersectionPointOne() {
		return intersectionPointOne;
	}
	@JsonProperty(required=false)
	public void setIntersectionPointOne(Integer intersectionPointOne) {
		this.intersectionPointOne = intersectionPointOne;
	}
	public Integer getIntersectionPointTwo() {
		return intersectionPointTwo;
	}
	@JsonProperty(required=false)
	public void setIntersectionPointTwo(Integer intersectionPointTwo) {
		this.intersectionPointTwo = intersectionPointTwo;
	}
	
}
