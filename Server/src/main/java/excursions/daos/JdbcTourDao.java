package excursions.daos;

import excursions.daos.interfaces.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTourDao implements TourDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    //Todo: This needs to be implemented
}
