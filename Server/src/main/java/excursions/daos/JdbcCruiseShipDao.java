package excursions.daos;

import excursions.daos.interfaces.CruiseShipDao;
import excursions.models.CruiseShip;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCruiseShipDao implements CruiseShipDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public CruiseShip getCruiseShip(int cruiseShipId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",cruiseShipId);
        String sql = "SELECT * FROM cruise_ship WHERE id = :id";
        CruiseShip cruiseShip = (CruiseShip)jdbc.queryForObject(sql, params, new CruiseShipRowMapper());
        return cruiseShip;
	}

	@Override
	public CruiseShip getCruiseShipByName(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name",name);
        String sql = "SELECT * FROM cruise_ship WHERE name = :name";
        CruiseShip cruiseShip = (CruiseShip)jdbc.queryForObject(sql, params, new CruiseShipRowMapper());
        return cruiseShip;
	}

	@Override
	public List<CruiseShip> getCruiseShips(int cruiseLineId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cruise_line_id",cruiseLineId);
        String sql = "SELECT * FROM cruise_ship WHERE cruise_line_id=:cruise_line_id";
        List<CruiseShip> cruiseShips = jdbc.query(sql, params, new CruiseShipRowMapper());
        return cruiseShips;
	}

	@Override
	public CruiseShip updateCruiseShip(CruiseShip cruiseShip) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id",cruiseShip.getCruiseShipId());
        params.addValue("name",cruiseShip.getName());
		params.addValue("capacity", cruiseShip.getCapacity());
		params.addValue("cruise_line_id", cruiseShip.getCruiseLineId());
		String sql = "UPDATE cruise_ship SET name=:name, capacity=:capacity, cruise_line_id=:cruise_line_id WHERE id=:id";
		jdbc.update(sql, params);
		return cruiseShip;
	}

	@Override
	public void deleteCruiseShip(int cruiseShipId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",cruiseShipId);
		String sql = "DELETE FROM cruise_ship WHERE id=:id";
		jdbc.update(sql, params);
	}

	@Override
	public CruiseShip createCruiseShip(CruiseShip cruiseShip) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name",cruiseShip.getName());
		params.addValue("capacity", cruiseShip.getCapacity());
		params.addValue("cruise_line_id", cruiseShip.getCruiseLineId());
		String sql = "INSERT INTO cruise_ship(name, capacity, cruise_line_id)"
			+ " VALUES(:name, :capacity, :cruise_line_id)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		cruiseShip.setCruiseShipId(kh.getKey().intValue());
		return cruiseShip;
	}
	
    public class CruiseShipRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			CruiseShip cruiseShip = new CruiseShip();
			cruiseShip.setCruiseShipId(rs.getInt("id"));
			cruiseShip.setName(rs.getString("name"));
			cruiseShip.setCapacity(rs.getInt("capacity"));
			cruiseShip.setCruiseLineId(rs.getInt("cruise_line_id"));
			return cruiseShip;
		}
	}
}
