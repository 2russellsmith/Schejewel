package excursions.controllers;

import excursions.daos.JdbcResourceDao;
import excursions.daos.interfaces.ResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResourceController {
    @Autowired
    private ResourceDao resourceDao = new JdbcResourceDao();
}
