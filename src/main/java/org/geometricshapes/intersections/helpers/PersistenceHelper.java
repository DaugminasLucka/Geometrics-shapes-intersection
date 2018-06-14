package org.geometricshapes.intersections.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.geometricshapes.intersections.entities.CoordinatePoint;
import org.geometricshapes.intersections.entities.IntersectionPoints;
import org.geometricshapes.intersections.entities.Points;
import org.geometricshapes.intersections.entities.Positions;
import org.geometricshapes.intersections.entities.ProcessedIntersections;
import org.geometricshapes.intersections.entities.ShapesIntersections;
import org.geometricshapes.intersections.persistence.ShapesIntersectionsRepository;
import org.geometricshapes.intersections.persistence.SquareAndLineIntersections;
import org.geometricshapes.intersections.persistence.User;
import org.geometricshapes.intersections.persistence.UserRepository;
import org.h2.jdbc.JdbcSQLException;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
public class PersistenceHelper {
	
	private ShapesIntersectionsRepository respository;
	private UserRepository userRepository;
	
	public PersistenceHelper(ShapesIntersectionsRepository respository, UserRepository userRepository) {
		this.respository = respository;
		this.userRepository = userRepository;
	}

	public void checkLoginUser(String username, String password) throws Exception {
		User loginUser = userRepository.findByUsername(username);
		
		if(loginUser == null) {
			throw new Exception("No user found by the provided username " + username);
		}
		
		if(!loginUser.getPassword().equals(password)) {
			throw new Exception("Provided password is incorrect for the username " + username);
		}
	}
	
	
	public ProcessedIntersections retrieveProcessedIntersections() throws JdbcSQLException {
		ProcessedIntersections processedInters = new ProcessedIntersections();

		processedInters.setNumberOfProcessedInters(respository.count());
		Iterable<SquareAndLineIntersections> intersIterable = respository.findAll();
		List<SquareAndLineIntersections> listOfInters = new ArrayList<>();
		intersIterable.forEach(i -> listOfInters.add(i));
		processedInters.setProcessedInters(listOfInters);
		
		return processedInters;
	}
	
	public void saveProcessedIntersections(ShapesIntersections shapesIntersects) throws JdbcSQLException {
		SquareAndLineIntersections inters = new SquareAndLineIntersections();
		
		inters.setIsIntersecting(shapesIntersects.getIsIntersecting());
		inters.setIntersectPointOneCoordX(
				retrieveCoordinatePointPosition(shapesIntersects.getInterPoints(),Points.ONE,Positions.X));
		inters.setIntersectPointOneCoordY(
				retrieveCoordinatePointPosition(shapesIntersects.getInterPoints(),Points.ONE,Positions.Y));
		inters.setIntersectPointTwoCoordX(
				retrieveCoordinatePointPosition(shapesIntersects.getInterPoints(),Points.TWO,Positions.X));
		inters.setIntersectPointTwoCoordY(
				retrieveCoordinatePointPosition(shapesIntersects.getInterPoints(),Points.TWO,Positions.Y));
		inters.setIntersProcDate(new Date());
		
		respository.save(inters);

	}
	
	private Integer retrieveCoordinatePointPosition(IntersectionPoints intersectPoints, Points point, Positions position) {
		
		if(intersectPoints!=null) {
			if(point.equals(Points.ONE)) {
				if(intersectPoints.getIntersectionPointOne()!=null) {
					return retrieveCoordinatePosition(intersectPoints.getIntersectionPointOne(), position);
				} else {
					return null;	
				}
	
			} else if(point.equals(Points.TWO)) {
				if(intersectPoints.getIntersectionPointTwo()!=null) {
					return retrieveCoordinatePosition(intersectPoints.getIntersectionPointTwo(), position);
				} else {
					return null;	
				}
			}
		}
		
		return null;
		
	}
	
	private Integer retrieveCoordinatePosition(CoordinatePoint coordinatePoint, Positions position) {
		Integer coordinatePosition = null;
		
		if(coordinatePoint!=null) {
			switch(position) {
				case X: 
					coordinatePosition = coordinatePoint.getCoordinateX();
					break;
				case Y:
					coordinatePosition = coordinatePoint.getCoordinateY();
			}
		}
		
		return coordinatePosition;
	}
}
