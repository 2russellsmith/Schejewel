package excursions.resources;

import excursions.controllers.PortageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortageResource {
    @Autowired
    private PortageController portageController = new PortageController();
}
