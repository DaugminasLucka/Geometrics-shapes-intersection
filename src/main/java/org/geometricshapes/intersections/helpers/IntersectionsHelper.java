package org.geometricshapes.intersections.helpers;

import java.util.ArrayList;
import java.util.List;

import org.geometricshapes.intersections.entities.CoordinatePoint;
import org.geometricshapes.intersections.entities.IntersectingShapes;
import org.geometricshapes.intersections.entities.IntersectionPoints;
import org.geometricshapes.intersections.entities.ShapeCoordinates;
import org.geometricshapes.intersections.entities.ShapesIntersections;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class IntersectionsHelper {

	public ShapesIntersections calculateShapesIntersections(IntersectingShapes intersectShapes) {
		
		SquareCoordinatesBuilder squareCoordBuilder = new SquareCoordinatesBuilder(
				intersectShapes.getSquare().getPointOne(), intersectShapes.getSquare().getPointTwo());
		
		ShapesIntersections shapesIntersects = new ShapesIntersections();
		
		IntersectionPoints intersectPoints = new IntersectionPoints();

		List<CoordinatePoint> intersections = new ArrayList<>();
		
		intersections.add(findIntersection(squareCoordBuilder.getHorisontalSideOne(), intersectShapes.getLine()));
		intersections.add(findIntersection(squareCoordBuilder.getHorisontalSideTwo(), intersectShapes.getLine()));
		intersections.add(findIntersection(squareCoordBuilder.getVerticalSideOne(), intersectShapes.getLine()));
		intersections.add(findIntersection(squareCoordBuilder.getVerticalSideTwo(), intersectShapes.getLine()));

		shapesIntersects.setIsIntersecting(false);
		
		for(CoordinatePoint intersectPoint : intersections) {
			if(intersectPoint!=null) {
				shapesIntersects.setIsIntersecting(true);
				if(intersectPoints.getIntersectionPointOne()==null) {
					intersectPoints.setIntersectionPointOne(intersectPoint);
				} else if(intersectPoints.getIntersectionPointTwo()==null) {
					intersectPoints.setIntersectionPointTwo(intersectPoint);
					break;
				}
			}
		}
		
		shapesIntersects.setInterPoints(intersectPoints);
		
		return shapesIntersects;
		
	}
	
	private CoordinatePoint findIntersection(ShapeCoordinates squareSide, ShapeCoordinates line) {
		
		Integer point1X = squareSide.getPointOne().getCoordinateX();
		Integer point1Y = squareSide.getPointOne().getCoordinateY();
		Integer point2X = squareSide.getPointTwo().getCoordinateX();
		Integer point2Y = squareSide.getPointTwo().getCoordinateY();
		
		Integer point3X = line.getPointOne().getCoordinateX();
		Integer point3Y = line.getPointOne().getCoordinateY();
		Integer point4X = line.getPointTwo().getCoordinateX();
		Integer point4Y = line.getPointTwo().getCoordinateY();
		
		Integer pointA1 = point2Y-point1Y;
		Integer pointB1 = point2X-point1X;
		Integer pointC1 = pointA1*point2X+pointB1*point2Y;
		
		Integer pointA2 = point4Y-point3Y;
		Integer pointB2 = point4X-point3X;
		Integer pointC2 = pointA2*point4X+pointB2*point4Y;
		
		Integer delta = pointA1*pointB2 - pointA2*pointB1;
		
		Integer intPointX = Math.round((pointB2*pointC1-pointB1*pointC2)/delta);
		Integer intPointY = Math.round((pointA1*pointC2-pointA2*pointC1)/delta);
		
		CoordinatePoint intCorrdinates = new CoordinatePoint(intPointX, intPointY);
		
		return intCorrdinates;
		
	}
	
}
