package excursions.daos;

import excursions.daos.interfaces.PortageDao;
import excursions.models.Portage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class JdbcPortageDao implements PortageDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public Portage createPortage(Portage portage) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cruise_ship_id", portage.getCruiseShipId());
        params.addValue("arrival", portage.getArrivalSQL());
		params.addValue("departure", portage.getDepartureSQL());
		params.addValue("name", portage.getName());
		params.addValue("passengers", portage.getPassengerCount());
		params.addValue("AA", portage.getAllAboardSQL());
		params.addValue("dock", portage.getDock());
		params.addValue("voyage", portage.getVoyage());
		String sql = "INSERT INTO portage(cruise_ship_id, arrival, departure, name, passengers, AA, dock, voyage)"
			+ " VALUES(:cruise_ship_id, :arrival, :departure, :name, :passengers, :AA, :dock, :voyage)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		portage.setPortageId(kh.getKey().intValue());
		return portage;
	}

	@Override
	public Portage getPortage(int portageId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",portageId);
        String sql = "SELECT * FROM portage WHERE id = :id";
        Portage portage = (Portage)jdbc.queryForObject(sql, params, new PortageRowMapper());
        return portage;
	}

	@Override
	public List<Portage> getPortageByCruiseShipId(int cruiseShipId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cruise_ship_id",cruiseShipId);
		String sql = "SELECT * FROM portage WHERE cruise_ship_id = :cruise_ship_id";
		List<Portage> portages = jdbc.query(sql, params, new PortageRowMapper());
		return portages;
	}

	@Override
	public List<Portage> getPortageByCruiseLineId(int cruiseLineId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cruise_line_id",cruiseLineId);
		String sql = "SELECT * FROM portage JOIN cruise_ship ON portage.cruise_ship_id=cruise_ship.id "
			+ "WHERE cruise_line_id=:cruise_line_id";
		List<Portage> portages = jdbc.query(sql, params, new PortageRowMapper());
		return portages;
	}

	@Override
	public List<Portage> getPortageByArrivalRange(long beginDate, long endDate) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("begin",new Timestamp(beginDate));
		params.addValue("end", new Timestamp(endDate));
		String sql = "SELECT * FROM portage WHERE arrival BETWEEN :begin AND :end";
		List<Portage> portages = jdbc.query(sql, params, new PortageRowMapper());
		return portages;
	}

	@Override
	public Portage updatePortage(Portage portage) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", portage.getPortageId());
		params.addValue("cruise_ship_id", portage.getCruiseShipId());
        params.addValue("arrival", portage.getArrivalSQL());
		params.addValue("departure", portage.getDepartureSQL());
		params.addValue("name", portage.getName());
		params.addValue("passengers", portage.getPassengerCount());
		params.addValue("AA", portage.getAllAboardSQL());
		params.addValue("dock", portage.getDock());
		params.addValue("voyage", portage.getVoyage());
		String sql = "UPDATE portage SET cruise_ship_id=:cruise_ship_id, arrival=:arrival, "
			+ "departure=:departure, name=:name, passengers=:passengers, AA=:AA, dock=:dock,"
			+ "voyage=:voyage WHERE id=:id";
		jdbc.update(sql, params);
		return portage;
	}

	@Override
	public void deletePortage(int portageId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",portageId);
		String sql = "DELETE FROM portage WHERE id=:id";
		jdbc.update(sql, params);
	}
	
    public class PortageRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Portage portage = new Portage();
			portage.setPortageId(rs.getInt("id"));
			portage.setCruiseShipId(rs.getInt("cruise_ship_id"));
			portage.setArrivalSQL(rs.getTimestamp("arrival"));
			portage.setDepartureSQL(rs.getTimestamp("departure"));
			portage.setName(rs.getString("name"));
			
			//deal with columns that may be null
			int passengerCount = rs.getInt("passengers");
			if (rs.wasNull())
				portage.setPassengerCount(null);
			else
				portage.setPassengerCount(passengerCount);
			
			Timestamp ts = rs.getTimestamp("AA");
			if (rs.wasNull())
				portage.setAllAboardSQL(null);
			else
				portage.setAllAboardSQL(ts);
			
			int dock = rs.getInt("dock");
			if (rs.wasNull())
				portage.setDock(null);
			else
				portage.setDock(dock);
			
			String voyage = rs.getString("voyage");
			if (rs.wasNull())
				portage.setVoyage(null);
			else
				portage.setVoyage(voyage);
			
			return portage;
		}
	}
}
