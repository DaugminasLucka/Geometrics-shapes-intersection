package org.geometricshapes.intersections.helpers;

import org.geometricshapes.intersections.entities.CoordinatePoint;
import org.geometricshapes.intersections.entities.ShapeCoordinates;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class SquareCoordinatesBuilder {
	
	private CoordinatePoint cornerOne; 
	private CoordinatePoint cornerTwo; 
	private CoordinatePoint cornerThree; 
	private CoordinatePoint cornerFour; 
	private CoordinatePoint centerPoint; 
	private Integer sideLength;
	private ShapeCoordinates horisontalSideOne;
	private ShapeCoordinates horisontalSideTwo;
	private ShapeCoordinates verticalSideOne;
	private ShapeCoordinates verticalSideTwo;
	
	public SquareCoordinatesBuilder(CoordinatePoint cornerOne, CoordinatePoint cornerTwo) {
		this.cornerOne = cornerOne;
		this.cornerTwo = cornerTwo;
		this.centerPoint = retrieveSquareCenterPoint();
		CoordinatePoint halfDiagonal = retrieveSquareHalfDiagonal();
		this.cornerThree = retrieveSquareThirdCorner(halfDiagonal);
		this.cornerFour = retrieveSquareFourCorner(halfDiagonal);
		this.horisontalSideOne = retrieveHorisontalSideOneCorrdinates();
		this.horisontalSideTwo = retrieveHorisontalSideTwoCorrdinates();
		this.verticalSideOne = retrieveVerticalSideOneCorrdinates();
		this.verticalSideTwo = retrieveVerticalSideTwoCorrdinates();
	}

	/**
	 * xc = (x1 + x2)/2;  yc = (y1 + y2)/2;
	 * 
	 * @return central point coordinates
	 */
	private CoordinatePoint retrieveSquareCenterPoint() {

		Integer coordinateX = Math.round((cornerOne.getCoordinateX()+cornerTwo.getCoordinateX())/2);
		Integer coordinateY = Math.round((cornerOne.getCoordinateY()+cornerTwo.getCoordinateY())/2);
		
		CoordinatePoint centerPoint = new CoordinatePoint(coordinateX, coordinateY);
		
		return centerPoint;
	}
	
	/**
	 * xd = (x1 - x2)/2;  yd = (y1 - y2)/2;
	 * 
	 * @return half diagonal coordinates
	 */
	private CoordinatePoint retrieveSquareHalfDiagonal() {
		Integer coordinateX = Math.round((cornerOne.getCoordinateX()-cornerTwo.getCoordinateX())/2);
		Integer coordinateY = Math.round((cornerOne.getCoordinateY()-cornerTwo.getCoordinateY())/2);
		
		CoordinatePoint centerPoint = new CoordinatePoint(coordinateX, coordinateY);
		
		return centerPoint;
	}
	
	/**
	 * x3 = xc - yd;  y3 = yc + xd; 
	 * 
	 * @param half diagonal
	 * @return third corner coordinates
	 */
	private CoordinatePoint retrieveSquareThirdCorner(CoordinatePoint halfDiagonal) {
		
		Integer coordinateX = centerPoint.getCoordinateX()-halfDiagonal.getCoordinateY();
		Integer coordinateY = centerPoint.getCoordinateY()+halfDiagonal.getCoordinateX();
		
		CoordinatePoint thirdCorner = new CoordinatePoint(coordinateX, coordinateY);
		
		return thirdCorner;
		
	}
	
	/**
	 * x4 = xc + yd;  y4 = yc - xd;
	 * 
	 * @param half diagonal
	 * @return fourth point coordinates
	 */
	private CoordinatePoint retrieveSquareFourCorner(CoordinatePoint halfDiagonal) {
		
		Integer coordinateX = centerPoint.getCoordinateX()+halfDiagonal.getCoordinateY();
		Integer coordinateY = centerPoint.getCoordinateY()-halfDiagonal.getCoordinateX();
		
		CoordinatePoint fourthCorner = new CoordinatePoint(coordinateX, coordinateY);
		
		return fourthCorner;
		
	}

	private ShapeCoordinates retrieveHorisontalSideOneCorrdinates() {
		ShapeCoordinates shapeCoordinates = new ShapeCoordinates();
		shapeCoordinates.setPointOne(cornerOne); 
		shapeCoordinates.setPointTwo(cornerFour); 
		
		return shapeCoordinates;
	}
	
	private ShapeCoordinates retrieveHorisontalSideTwoCorrdinates() {
		ShapeCoordinates shapeCoordinates = new ShapeCoordinates();
		shapeCoordinates.setPointOne(cornerThree); 
		shapeCoordinates.setPointTwo(cornerTwo); 
		
		return shapeCoordinates;
	}
	
	private ShapeCoordinates retrieveVerticalSideOneCorrdinates() {
		ShapeCoordinates shapeCoordinates = new ShapeCoordinates();
		shapeCoordinates.setPointOne(cornerOne); 
		shapeCoordinates.setPointTwo(cornerThree); 
		
		return shapeCoordinates;
	}

	private ShapeCoordinates retrieveVerticalSideTwoCorrdinates() {
		ShapeCoordinates shapeCoordinates = new ShapeCoordinates();
		shapeCoordinates.setPointOne(cornerFour); 
		shapeCoordinates.setPointTwo(cornerTwo); 
		
		return shapeCoordinates;
	}
	
	/** the first lower corner */
	public CoordinatePoint getCornerOne() {
		return cornerOne;
	}

	/** the first upper corner opposite to the first lower corner */
	public CoordinatePoint getCornerTwo() {
		return cornerTwo;
	}

	/** the second upper corner 
	 * opposite to the corner four (the second lower corner) */
	public CoordinatePoint getCornerThree() {
		return cornerThree;
	}

	/** the second lower corner  */
	public CoordinatePoint getCornerFour() {
		return cornerFour;
	}

	/** square center point  */ 
	public CoordinatePoint getCenterPoint() {
		return centerPoint;
	}

	public Integer getSideLength() {
		return sideLength;
	}

	public ShapeCoordinates getHorisontalSideOne() {
		return horisontalSideOne;
	}

	public ShapeCoordinates getHorisontalSideTwo() {
		return horisontalSideTwo;
	}

	public ShapeCoordinates getVerticalSideOne() {
		return verticalSideOne;
	}

	public ShapeCoordinates getVerticalSideTwo() {
		return verticalSideTwo;
	}
}
