package excursions.controllers;

import excursions.daos.JdbcTourGroupDao;
import excursions.daos.interfaces.TourGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TourGroupController {
    @Autowired
    private TourGroupDao tourGroupDao = new JdbcTourGroupDao();
}
