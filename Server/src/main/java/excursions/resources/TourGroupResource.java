package excursions.resources;

import excursions.controllers.TourGroupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourGroupResource {
    @Autowired
    private TourGroupController tourGroupController = new TourGroupController();
}
