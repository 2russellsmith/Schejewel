package excursions.controllers;

import excursions.daos.JdbcPortageDao;
import excursions.daos.interfaces.PortageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PortageController {
    @Autowired
    private PortageDao portageDao = new JdbcPortageDao();
}
