package excursions.controllers;

import excursions.daos.JdbcCompanyDao;
import excursions.daos.interfaces.CompanyDao;
import excursions.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyDao companyDao = new JdbcCompanyDao();

    public List<Company> getCompanies(){
        return companyDao.getCompanies();
    }

    public Company getCompany(int companyId){
        return companyDao.getCompany(companyId);
    }

    public Company updateCompany(Company company){
        return companyDao.updateCompany(company);
    }

    public void deleteCompany(int companyId){
        companyDao.deleteCompany(companyId);
    }

    public Company createCompany(Company company){
        return companyDao.createCompany(company);
    }
}
