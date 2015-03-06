package excursions.daos;

import excursions.daos.interfaces.TourDao;
import excursions.models.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTourDao implements TourDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<Tour> getTours(int companyid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_id",companyid);
		String sql = "SELECT * FROM tour WHERE owner_id = :owner_id";
		List<Tour> tours = jdbc.query(sql, params, new TourRowMapper());
		return tours;
	}
	
	@Override
	public List<Tour> getToursByDateRange(int companyid, long beginDate, long endDate) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_id",companyid);
		params.addValue("begin",beginDate);
		params.addValue("end", endDate);
		String sql = "SELECT * FROM tour WHERE owner_id = :owner_id AND start_time BETWEEN "
			+ ":begin AND :end";
		List<Tour> tours = jdbc.query(sql, params, new TourRowMapper());
		return tours;
	}

	@Override
	public Tour getTour(int tourid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",tourid);
        String sql = "SELECT * FROM tour WHERE id = :id";
        Tour tour = (Tour)jdbc.queryForObject(sql, params, new TourRowMapper());
		tour.setTourId(tourid);
        return tour;
	}

	@Override
	public Tour updateTour(Tour tour) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", tour.getTourId());
        params.addValue("owner_id",tour.getOwnerId());
		params.addValue("start_time", tour.getStartTime());
		params.addValue("tour_type_id", tour.getTourTypeId());
		params.addValue("status_id", tour.getStatusId());
		String sql = "UPDATE tour SET owner_id=:owner_id, start_time=:start_time, "
			+ "tour_type_id=:tour_type_id, status_id=:status_id WHERE id=:id";
		jdbc.update(sql, params);
		return tour;
	}

	@Override
	public void deleteTour(int tourid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",tourid);
		String sql = "DELETE FROM tour WHERE id=:id";
		jdbc.update(sql, params);
	}

	@Override
	public Tour createTour(Tour tour) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", tour.getTourId());
        params.addValue("owner_id",tour.getOwnerId());
		params.addValue("start_time", tour.getStartTime());
		params.addValue("tour_type_id", tour.getTourTypeId());
		params.addValue("status_id", tour.getStatusId());
		String sql = "INSERT INTO tour(owner_id, start_time, tour_type_id, status_id)"
			+ " VALUES(:owner_id, :start_time, :tour_type_id, :status_id)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		tour.setTourId(kh.getKey().intValue());
		return tour;
	}
	
	public class TourRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tour tour = new Tour();
			tour.setTourId(rs.getInt("id"));
			tour.setOwnerId(rs.getInt("owner_id"));
			tour.setStartTime(rs.getLong("start_time"));
			tour.setTourTypeId(rs.getInt("tour_type_id"));
			tour.setStatusId(rs.getInt("status_id"));
			return tour;
		}
	}
}
