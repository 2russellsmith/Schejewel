package excursions.controllers;

import excursions.daos.JdbcCompanyDao;
import excursions.daos.interfaces.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CompanyController {
    @Autowired
    private CompanyDao companyDao = new JdbcCompanyDao();
}
