package excursions.daos;

import excursions.daos.interfaces.ResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcResourceDao implements ResourceDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    //Todo: This needs to be implemented
}
