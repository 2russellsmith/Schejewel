package excursions.daos;

import excursions.daos.interfaces.CruiseLineDao;
import excursions.models.CruiseLine;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCruiseLineDao implements CruiseLineDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public CruiseLine getCruiseLine(int cruiseLineId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",cruiseLineId);
        String sql = "SELECT * FROM cruise_line WHERE id = :id";
        CruiseLine cruiseLine = jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(CruiseLine.class));
		cruiseLine.setCruiseLineId(cruiseLineId);
        return cruiseLine;
	}

	@Override
	public CruiseLine updateCruiseLine(CruiseLine cruiseLine) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id",cruiseLine.getCruiseLineId());
        params.addValue("name",cruiseLine.getName());
		String sql = "UPDATE cruise_line SET name=:name WHERE id=:id";
		jdbc.update(sql, params);
		return cruiseLine;
	}

	@Override
	public void deleteCruiseLine(int cruiseLineId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",cruiseLineId);
		String sql = "DELETE FROM cruise_line WHERE id=:id";
		jdbc.update(sql, params);
	}

	@Override
	public CruiseLine createCruiseLine(CruiseLine cruiseLine) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", cruiseLine.getName());
		String sql = "INSERT INTO cruise_line(name)"
			+ " VALUES(:name)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		cruiseLine.setCruiseLineId(kh.getKey().intValue());
		return cruiseLine;
	}
}
