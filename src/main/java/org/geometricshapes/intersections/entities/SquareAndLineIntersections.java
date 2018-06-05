package org.geometricshapes.intersections.entities;

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
	private Integer lineCoordinateX;
	@Column(nullable = false)
	private Integer lineCoordinateY;
	@Column(nullable = false)
	private Integer squareCoordinateX;
	@Column(nullable = false)
	private Integer squareCoordinateY;
	@Column(nullable = false)
	private Integer squareWidth;
	@Column(nullable = false)
	private Integer squareHeight;
	@Column(nullable = false)
	private Boolean isIntersecting;
	@Column(nullable = true)
	private Integer intersectionPointOne;
	@Column(nullable = true)
	private Integer intersectionPointTwo;
	@Column(nullable = false)
	private Date intersProcDate;
	
	public Integer getLineCoordinateX() {
		return lineCoordinateX;
	}
	public void setLineCoordinateX(Integer lineCoordinateX) {
		this.lineCoordinateX = lineCoordinateX;
	}
	public Integer getLineCoordinateY() {
		return lineCoordinateY;
	}
	public void setLineCoordinateY(Integer lineCoordinateY) {
		this.lineCoordinateY = lineCoordinateY;
	}
	public Integer getSquareCoordinateX() {
		return squareCoordinateX;
	}
	public void setSquareCoordinateX(Integer squareCoordinateX) {
		this.squareCoordinateX = squareCoordinateX;
	}
	public Integer getSquareCoordinateY() {
		return squareCoordinateY;
	}
	public void setSquareCoordinateY(Integer squareCoordinateY) {
		this.squareCoordinateY = squareCoordinateY;
	}
	public Boolean getIsIntersecting() {
		return isIntersecting;
	}
	public void setIsIntersecting(Boolean isIntersecting) {
		this.isIntersecting = isIntersecting;
	}
	public Integer getIntersectionPointOne() {
		return intersectionPointOne;
	}
	public void setIntersectionPointOne(Integer intersectionPointOne) {
		this.intersectionPointOne = intersectionPointOne;
	}
	public Integer getIntersectionPointTwo() {
		return intersectionPointTwo;
	}
	public void setIntersectionPointTwo(Integer intersectionPointTwo) {
		this.intersectionPointTwo = intersectionPointTwo;
	}
	public Integer getSquareWidth() {
		return squareWidth;
	}
	public void setSquareWidth(Integer squareWidth) {
		this.squareWidth = squareWidth;
	}
	public Integer getSquareHeight() {
		return squareHeight;
	}
	public void setSquareHeight(Integer squareHeight) {
		this.squareHeight = squareHeight;
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
	
	
}
