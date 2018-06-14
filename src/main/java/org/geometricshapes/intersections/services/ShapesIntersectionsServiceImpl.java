package org.geometricshapes.intersections.services;

import javax.servlet.http.HttpServletRequest;

import org.geometricshapes.intersections.entities.IntersectingShapesRequest;
import org.geometricshapes.intersections.entities.ProcessedIntersections;
import org.geometricshapes.intersections.entities.ProcessedIntersectionsResponse;
import org.geometricshapes.intersections.entities.ShapesIntersections;
import org.geometricshapes.intersections.entities.ShapesIntersectionsResponse;
import org.geometricshapes.intersections.helpers.IntersectionsHelper;
import org.geometricshapes.intersections.helpers.PersistenceHelper;
import org.geometricshapes.intersections.helpers.ResponseBuilder;
import org.geometricshapes.intersections.persistence.ShapesIntersectionsRepository;
import org.geometricshapes.intersections.persistence.UserRepository;
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
		
		IntersectionsHelper intersectionsHelper = new IntersectionsHelper();
		PersistenceHelper persistenceHelper = new PersistenceHelper(respository, userRepository);
		ResponseBuilder responseBuilder = new ResponseBuilder();
		
		ShapesIntersections shapesIntersects = intersectionsHelper.calculateShapesIntersections(
				interShapes.getData().getAttributes());
		
		try {
			persistenceHelper.saveProcessedIntersections(shapesIntersects);
		} catch (Exception e) {
			return responseBuilder.buildShapesIntersErrorResponse("ERR1", "Error occured in database", e.getMessage());
		}
		
		return responseBuilder.buildShapesIntersResponse(shapesIntersects);
	}
	
	@Override
	public ProcessedIntersectionsResponse retrieveSquareAndLineInters(HttpServletRequest request) {
		ProcessedIntersections processedInters = null;
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		ResponseBuilder responseBuilder = new ResponseBuilder();
		PersistenceHelper persistenceHelper = new PersistenceHelper(respository, userRepository);
		
		try {
			if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
				throw new Exception("Username and password should be provided in a request's headers");
			}
			
			persistenceHelper.checkLoginUser(username, password);
			
		} catch (Exception e) {
			return responseBuilder.buildProcessedIntersResponse("ERR5", "Error occured in authenticating user", e.getMessage());
		}
		
		try {
			processedInters = persistenceHelper.retrieveProcessedIntersections();
		} catch (Exception e) {
			return responseBuilder.buildProcessedIntersResponse("ERR1", "Error occured in database", e.getMessage());
		}
		
		return responseBuilder.buildProcessedIntersResponse(processedInters);
	}
	
}
