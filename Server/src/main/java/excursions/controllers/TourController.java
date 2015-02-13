package excursions.controllers;

import excursions.daos.JdbcTourDao;
import excursions.daos.interfaces.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TourController {
    @Autowired
    private TourDao tourDao = new JdbcTourDao();
}
