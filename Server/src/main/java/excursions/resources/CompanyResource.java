package excursions.resources;

import excursions.controllers.CompanyController;
import excursions.models.Company;
import excursions.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyResource {
    @Autowired
    private CompanyController companyController = new CompanyController();

    @RequestMapping(value = "/api/company", method = RequestMethod.GET)
    public @ResponseBody List<Company> getCompanies(){
        return companyController.getCompanies();
    }

    @RequestMapping(value = "/api/company/{companyid}", method = RequestMethod.GET)
    public @ResponseBody Company getCompany(@RequestParam(value="companyid")int companyid){
        return companyController.getCompany(companyid);
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.PUT)
    public @ResponseBody Tour updateCompany(@RequestBody Company company){
        return companyController.updateCompany(company);
    }

    @RequestMapping(value = "/api/company/{companyid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCompany(@RequestParam(value="companyid") int companyid){
        companyController.deleteCompany(companyid);
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.POST)
    public @ResponseBody Tour createCompany(@RequestBody Company company){
        return companyController.createCompany(company);
    }
}
