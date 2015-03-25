package excursions.resources;

import excursions.controllers.CompanyController;
import excursions.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompanyResource {
    @Autowired
    private CompanyController companyController = new CompanyController();

    @RequestMapping(value = "/api/company/{companyid}", method = RequestMethod.GET)
    public @ResponseBody Company getCompany(@PathVariable(value="companyid")int companyid){
        return companyController.getCompany(companyid);
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.PUT)
    public @ResponseBody Company updateCompany(@RequestBody Company company){
        return companyController.updateCompany(company);
    }

    @RequestMapping(value = "/api/company/{companyid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCompany(@PathVariable(value="companyid") int companyid){
        companyController.deleteCompany(companyid);
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.POST)
    public @ResponseBody Company createCompany(@RequestBody Company company){
        return companyController.createCompany(company);
    }
}
