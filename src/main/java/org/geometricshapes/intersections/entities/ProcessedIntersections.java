package org.geometricshapes.intersections.entities;

import java.util.List;

import org.geometricshapes.intersections.persistence.SquareAndLineIntersections;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class ProcessedIntersections {
	private Long numberOfProcessedInters;
	private List<SquareAndLineIntersections> processedInters;
	
	
	public Long getNumberOfProcessedInters() {
		return numberOfProcessedInters;
	}

	public void setNumberOfProcessedInters(Long numberOfProcessedInters) {
		this.numberOfProcessedInters = numberOfProcessedInters;
	}

	public List<SquareAndLineIntersections> getProcessedInters() {
		return processedInters;
	}

	public void setProcessedInters(List<SquareAndLineIntersections> processedInters) {
		this.processedInters = processedInters;
	}
}
