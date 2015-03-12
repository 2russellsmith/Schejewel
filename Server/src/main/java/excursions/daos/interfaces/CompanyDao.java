package excursions.daos.interfaces;

import excursions.models.Company;
import javax.sql.DataSource;
import java.util.List;

public interface CompanyDao {
	public void setDataSource(DataSource ds);
	public Company getCompany(int companyid);
	public Company updateCompany(Company company);
	public void deleteCompany(int companyid);
	public Company createCompany(Company company);
    public List<Company> getCompanies();
}
