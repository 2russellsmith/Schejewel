package excursions.controllers;

import excursions.daos.JdbcCruiseLineDao;
import excursions.daos.interfaces.CruiseLineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CruiseLineController {
    @Autowired
    private CruiseLineDao cruiseLineDao = new JdbcCruiseLineDao();
}
