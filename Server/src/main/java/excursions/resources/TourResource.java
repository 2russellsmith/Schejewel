package excursions.resources;

import excursions.controllers.TourController;
import excursions.models.Tour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TourResource {
    @Autowired
    private final TourController tourController = new TourController();
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.GET)
    public @ResponseBody List<Tour> getTours(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return tourController.getTours(token);
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.GET)
    public @ResponseBody Tour getTour(@PathVariable(value="tourid")int tourId){
        return tourController.getTour(tourId);
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.PUT)
    public @ResponseBody Tour updateTour(@RequestBody Tour tour){
        return tourController.updateTour(tour);
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTour(@PathVariable(value="tourid") int tourId){
		tourController.deleteTour(tourId);
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.POST)
    public @ResponseBody Tour createTour(@RequestBody Tour tour){
        return tourController.createTour(tour);
    }
}
