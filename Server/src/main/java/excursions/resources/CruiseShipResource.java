package excursions.resources;

import excursions.controllers.CruiseShipController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CruiseShipResource {
    @Autowired
    private CruiseShipController cruiseShipController = new CruiseShipController();
}
