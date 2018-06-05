package org.geometricshapes.intersections.entities;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public enum ResourceTypes {
	COORDINATES("coordinates"), 
	INTERSECTIONS("intersections"),
	PROCESSEDINTERS("processedInters");
	
	private ResourceTypes(String name) {
		this.name = name;
	}

	private final String name;
	
	public String getName() {
		return name;
	}

}
