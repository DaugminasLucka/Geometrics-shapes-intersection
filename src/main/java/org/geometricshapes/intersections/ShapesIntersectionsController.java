package org.geometricshapes.intersections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.geometricshapes.intersections.entities.IntersectingShapesRequest;
import org.geometricshapes.intersections.entities.ProcessedIntersectionsResponse;
import org.geometricshapes.intersections.entities.ShapesIntersectionsResponse;
import org.geometricshapes.intersections.services.ShapesIntersectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Shapes intersections controller.
 * 
 * @author Mindaugas Lucka
 *
 */
@RestController
public class ShapesIntersectionsController {
	
	@Autowired
	ShapesIntersectionsService service;
	
	/**
	 * Accepts as an input information about a square and a line. 
	 * Returns information where and if these two objects intersect.
	 * 
	 * @param requestPayload
	 * @param response
	 * @return ShapesIntersectionsResponse
	 */
	@RequestMapping(value="/squareAndLineInters", method = RequestMethod.POST)
	public ShapesIntersectionsResponse calculateSquareAndLineIntersecs(
			@RequestBody IntersectingShapesRequest requestPayload, 
			HttpServletResponse response) {
		
		ShapesIntersectionsResponse shapesInters = 
				service.calculateSquareAndLineInters(requestPayload);
		response.setStatus(shapesInters.getErrors()!=null ? 400 : 200);
		
		return shapesInters;
		
	}
	
	/**
	 * Retrieves information about how many requests are currently being 
	 * processed by the application
	 * 
	 * @param request
	 * @param response
	 * @return ProcessedIntersectionsResponse
	 */
	@RequestMapping(value="/squareAndLineInters", method = RequestMethod.GET)
	public ProcessedIntersectionsResponse retrieveSquareAndLineIntersecs(
			HttpServletRequest request, HttpServletResponse response) {
		
		ProcessedIntersectionsResponse processedInters = 
				service.retrieveSquareAndLineInters(request);
		response.setStatus(processedInters.getErrors()!=null ? 400 : 200);

		return processedInters;
		
	}
	
}
