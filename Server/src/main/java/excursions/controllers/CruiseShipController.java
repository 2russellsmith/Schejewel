package excursions.controllers;

import excursions.daos.JdbcCruiseShipDao;
import excursions.daos.interfaces.CruiseShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CruiseShipController {
    @Autowired
    private CruiseShipDao cruiseShipDao = new JdbcCruiseShipDao();
}
