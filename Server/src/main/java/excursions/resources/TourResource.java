package excursions.resources;

import excursions.controllers.TourController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourResource {
    @Autowired
    private TourController tourController = new TourController();
}
