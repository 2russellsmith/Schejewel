package excursions.daos;

import excursions.daos.interfaces.CompanyDao;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCompanyDao implements CompanyDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}
    //Todo: This needs to be implemented
}
