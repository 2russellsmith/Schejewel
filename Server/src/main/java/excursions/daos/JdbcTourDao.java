package excursions.daos;

import com.mysql.jdbc.PreparedStatement;
import excursions.daos.interfaces.TourDao;
import excursions.models.Tour;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
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
		List<Tour> tours = jdbc.queryForList(sql, params, Tour.class);
		return tours;
	}

	@Override
	public Tour getTour(int tourid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",tourid);
        String sql = "SELECT * FROM tour WHERE id = :id";
        Tour tour = jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(Tour.class));
        return tour;
	}

	@Override
	public Tour updateTour(Tour tour) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_id",tour.getOwnerId());
		params.addValue("start_time", tour.getStartDate());
		params.addValue("end_time", tour.getEndDate());
		params.addValue("tour_type_id", tour.getTourTypes());
		String sql = "UPDATE tour SET owner_id=:owner_id, start_time=:start_time, end_time=:end_time, "
			+ "tour_type_id=:tour_type_id WHERE id=:id";
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
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_id",tour.getOwnerId());
		cal.setTimeInMillis(tour.getStartDate());
		System.out.println(sdf.format(cal.getTime()));
		params.addValue("start_time", sdf.format(cal.getTime()));
		cal.setTimeInMillis(tour.getEndDate());
		params.addValue("end_time", sdf.format(cal.getTime()));
		params.addValue("tour_type_id", tour.getTourTypes());
		String sql = "INSERT INTO tour(owner_id, start_time, end_time, tour_type_id)"
			+ " VALUES(:owner_id, :start_time, :end_time, :tour_type_id)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		tour.setTourId(kh.getKey().intValue());
		return tour;
	}
}
