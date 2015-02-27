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
    public @ResponseBody List<Tour> getTours(){
        return tourController.getTours();
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.GET)
    public @ResponseBody Tour getTour(@RequestParam(value="tourid")int tourid){
        return tourController.getTour(tourid);
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.PUT)
    public @ResponseBody Tour updateTour(@RequestBody Tour tour){
        return tourController.updateTour(tour);
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTour(@RequestParam(value="tourid") int tourid){
		tourController.deleteTour(tourid);
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.POST)
    public @ResponseBody Tour createTour(@RequestBody Tour tour){
        return tourController.createTour(tour);
    }
}
