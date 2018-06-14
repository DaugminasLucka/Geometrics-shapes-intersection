package org.geometricshapes.intersections.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@Entity
public class SquareAndLineIntersections {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(nullable = false)
	private Boolean isIntersecting;
	@Column(nullable = true)
	private Integer intersectPointOneCoordX;
	@Column(nullable = true)
	private Integer intersectPointOneCoordY;
	@Column(nullable = true)
	private Integer intersectPointTwoCoordX;
	@Column(nullable = true)
	private Integer intersectPointTwoCoordY;
	@Column(nullable = false)
	private Date intersProcDate;
	
	public Boolean getIsIntersecting() {
		return isIntersecting;
	}
	public void setIsIntersecting(Boolean isIntersecting) {
		this.isIntersecting = isIntersecting;
	}
	public long getId() {
		return id;
	}
	public Date getIntersProcDate() {
		return intersProcDate;
	}
	public void setIntersProcDate(Date intersProcDate) {
		this.intersProcDate = intersProcDate;
	}
	public Integer getIntersectPointOneCoordX() {
		return intersectPointOneCoordX;
	}
	public void setIntersectPointOneCoordX(Integer intersectPointOneCoordX) {
		this.intersectPointOneCoordX = intersectPointOneCoordX;
	}
	public Integer getIntersectPointOneCoordY() {
		return intersectPointOneCoordY;
	}
	public void setIntersectPointOneCoordY(Integer intersectPointOneCoordY) {
		this.intersectPointOneCoordY = intersectPointOneCoordY;
	}
	public Integer getIntersectPointTwoCoordX() {
		return intersectPointTwoCoordX;
	}
	public void setIntersectPointTwoCoordX(Integer intersectPointTwoCoordX) {
		this.intersectPointTwoCoordX = intersectPointTwoCoordX;
	}
	public Integer getIntersectPointTwoCoordY() {
		return intersectPointTwoCoordY;
	}
	public void setIntersectPointTwoCoordY(Integer intersectPointTwoCoordY) {
		this.intersectPointTwoCoordY = intersectPointTwoCoordY;
	}

}
