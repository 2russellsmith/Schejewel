package excursions.resources;

import excursions.controllers.TourController;
import excursions.models.Tour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourResource {
    @Autowired
    private final TourController tourController = new TourController();
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.GET)
    public ResponseEntity<List<Tour>> getTours(){
        return new ResponseEntity<List<Tour>>(tourController.getTours(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.GET)
    public ResponseEntity<Tour> getTour(@RequestParam(value="tourid")int tourid){
        return new ResponseEntity<Tour>(tourController.getTour(tourid), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.PUT)
    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour){
        return new ResponseEntity<Tour>(tourController.updateTour(tour), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/tour/{tourid}", method = RequestMethod.DELETE)
    public HttpStatus deleteTour(@RequestParam(value="tourid") int tourid){
		tourController.deleteTour(tourid);
        return HttpStatus.OK;
    }
	
	@RequestMapping(value = "/api/tour", method = RequestMethod.POST)
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour){
        return new ResponseEntity<Tour>(tourController.createTour(tour), HttpStatus.CREATED);
    }
}
