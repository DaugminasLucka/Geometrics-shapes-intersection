package org.geometricshapes.intersections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.geometricshapes.intersections.entities.ApiResource;
import org.geometricshapes.intersections.entities.ErrorResponse;
import org.geometricshapes.intersections.entities.IntersectingShapesRequest;
import org.geometricshapes.intersections.entities.IntersectionPoints;
import org.geometricshapes.intersections.entities.ProcessedIntersections;
import org.geometricshapes.intersections.entities.ProcessedIntersectionsResponse;
import org.geometricshapes.intersections.entities.ResourceTypes;
import org.geometricshapes.intersections.entities.ShapesIntersections;
import org.geometricshapes.intersections.entities.ShapesIntersectionsResponse;
import org.geometricshapes.intersections.entities.SquareAndLineIntersections;
import org.geometricshapes.intersections.entities.User;
import org.h2.jdbc.JdbcSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Shapes intersections service implementation.
 * 
 * @author Mindaugas Lucka
 *
 */
@Component("service")
public class ShapesIntersectionsServiceImpl implements ShapesIntersectionsService {
	
	@Autowired ShapesIntersectionsRepository respository;
	@Autowired UserRepository userRepository;
	
	@Override
	public ShapesIntersectionsResponse calculateSquareAndLineInters(IntersectingShapesRequest interShapes) {
		ShapesIntersections shapesIntersects = new ShapesIntersections();
		
		shapesIntersects.setInterShapes(interShapes.getData().getAttributes());
		shapesIntersects.setInterPoints(new IntersectionPoints());
		shapesIntersects.setIsIntersecting(false);
		
		try {
			saveProcessedIntersections(shapesIntersects);
		} catch (Exception e) {
			return buildShapesIntersErrorResponse("ERR1", "Error occured in database", e.getMessage());
		}
		
		return buildShapesIntersResponse(shapesIntersects);
	}
	
	@Override
	public ProcessedIntersectionsResponse retrieveSquareAndLineInters(HttpServletRequest request) {
		ProcessedIntersections processedInters = null;
		
		try {
			checkLoginDetails(request);
		} catch (Exception e) {
			return buildProcessedIntersResponse("ERR5", "Error occured in authenticating user", e.getMessage());
		}
		
		try {
			processedInters = retrieveProcessedIntersections();
		} catch (Exception e) {
			return buildProcessedIntersResponse("ERR1", "Error occured in database", e.getMessage());
		}
		
		return buildProcessedIntersResponse(processedInters);
	}

	private void checkLoginDetails(HttpServletRequest request) throws Exception {
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new Exception("Username and password should be provided in a request's headers");
		}
		
		User loginUser = userRepository.findByUsername(username);
		
		if(loginUser == null) {
			throw new Exception("No user found by the provided username " + username);
		}
		
		if(!loginUser.getPassword().equals(password)) {
			throw new Exception("Provided password is incorrect for the username " + username);
		}
	}
	
	private ProcessedIntersections retrieveProcessedIntersections() throws JdbcSQLException {
		ProcessedIntersections processedInters = new ProcessedIntersections();

		processedInters.setNumberOfProcessedInters(respository.count());
		Iterable<SquareAndLineIntersections> intersIterable = respository.findAll();
		List<SquareAndLineIntersections> listOfInters = new ArrayList<>();
		intersIterable.forEach(i -> listOfInters.add(i));
		processedInters.setProcessedInters(listOfInters);
		
		return processedInters;
	}
	
	private ShapesIntersectionsResponse buildShapesIntersErrorResponse(
			String errorCode, String errorTitle, String errorMsg) {
		ErrorResponse sqlError = new ErrorResponse(errorCode, errorTitle, errorMsg);
		List<ErrorResponse> errors = new ArrayList<>();
		errors.add(sqlError);
		return new ShapesIntersectionsResponse(errors);
	}
	
	private ShapesIntersectionsResponse buildShapesIntersResponse(
			ShapesIntersections shapesIntersects) {
		
		ApiResource<ShapesIntersections> apiResource = new ApiResource<>(
				ResourceTypes.INTERSECTIONS.getName(), shapesIntersects);
		
		return new ShapesIntersectionsResponse(apiResource);
	}
	
	private  ProcessedIntersectionsResponse buildProcessedIntersResponse(
			String errorCode, String errorTitle, String errorMsg) {
		ErrorResponse sqlError = new ErrorResponse(errorCode, errorTitle, errorMsg);
		List<ErrorResponse> errors = new ArrayList<>();
		errors.add(sqlError);
		return new  ProcessedIntersectionsResponse(errors);
	}
	
	private ProcessedIntersectionsResponse buildProcessedIntersResponse(
			ProcessedIntersections processedInters) {
		
		ApiResource<ProcessedIntersections> apiResource = new ApiResource<>(
				ResourceTypes.PROCESSEDINTERS.getName(), processedInters);
		
		return new ProcessedIntersectionsResponse(apiResource);
		
	}
	
	private void saveProcessedIntersections(ShapesIntersections shapesIntersects) throws JdbcSQLException {
		SquareAndLineIntersections inters = new SquareAndLineIntersections();
		
		inters.setLineCoordinateX(shapesIntersects.getInterShapes().getLine().getCoordinateX());
		inters.setLineCoordinateY(shapesIntersects.getInterShapes().getLine().getCoordinateY());
		inters.setSquareCoordinateX(shapesIntersects.getInterShapes().getSquare().getCoordinateX());
		inters.setSquareCoordinateY(shapesIntersects.getInterShapes().getSquare().getCoordinateY());
		inters.setSquareHeight(shapesIntersects.getInterShapes().getSquare().getHeight());
		inters.setSquareWidth(shapesIntersects.getInterShapes().getSquare().getWidth());
		inters.setIsIntersecting(shapesIntersects.getIsIntersecting());
		inters.setIntersectionPointOne(shapesIntersects.getInterPoints().getIntersectionPointOne());
		inters.setIntersectionPointTwo(shapesIntersects.getInterPoints().getIntersectionPointTwo());
		inters.setIntersProcDate(new Date());
		
		respository.save(inters);

	}
	
}
