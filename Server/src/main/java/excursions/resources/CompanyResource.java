package excursions.resources;

import excursions.controllers.CompanyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyResource {
    @Autowired
    private CompanyController companyController = new CompanyController();
}
