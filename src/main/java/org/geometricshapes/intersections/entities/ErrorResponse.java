package org.geometricshapes.intersections.entities;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ErrorResponse {
	private String code;
	private String title;
	private String details;
	
	public ErrorResponse(String code, String title, String details) {
		this.code = code;
		this.title = title;
		this.details = details;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
