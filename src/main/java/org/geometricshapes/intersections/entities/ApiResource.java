package org.geometricshapes.intersections.entities;

/**
 * 
 * @author Mindaugas Lucka
 *
 * @param <T>
 */
public class ApiResource<T> {
	private String type;
	private T attributes;
	
	public ApiResource() {}
	
	public ApiResource(String type, T attributes) {
		this.type = type;
		this.attributes = attributes;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public T getAttributes() {
		return attributes;
	}
	public void setAttributes(T attributes) {
		this.attributes = attributes;
	}
}
