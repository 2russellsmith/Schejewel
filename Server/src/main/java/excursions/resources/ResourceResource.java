package excursions.resources;

import excursions.controllers.ResourceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceResource {
    @Autowired
    private ResourceController resourceController = new ResourceController();
}
