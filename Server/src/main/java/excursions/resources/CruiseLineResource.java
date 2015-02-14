package excursions.resources;

import excursions.controllers.CruiseLineController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CruiseLineResource {
    @Autowired
    private CruiseLineController cruiseLineController = new CruiseLineController();
}
