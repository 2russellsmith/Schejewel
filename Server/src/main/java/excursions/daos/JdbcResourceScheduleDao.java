
package excursions.daos;

import excursions.daos.interfaces.ResourceScheduleDao;
import excursions.models.ResourceSchedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcResourceScheduleDao implements ResourceScheduleDao {
	@Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public ResourceSchedule createResourceSchedule(ResourceSchedule resourceSchedule) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resource_id", resourceSchedule.getResourceId());
		params.addValue("tour_id", resourceSchedule.getTourId());
		params.addValue("start", resourceSchedule.getStartTimeSQL());
		params.addValue("duration", resourceSchedule.getDuration());
		params.addValue("status", resourceSchedule.getStatusId());
		String sql = "INSERT INTO resource_schedule (resource_id, tour_id, start, duration, status)"
			+ " VALUES(:resource_id, :tour_id, :start, :duration, :status)";
		jdbc.update(sql, params);
		return resourceSchedule;
	}

	@Override
	public List<ResourceSchedule> getResourceSchedulesByResourceId(int resourceId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resource_id", resourceId);
        String sql = "SELECT * FROM resource_schedule WHERE resource_id = :resource_id";
        List<ResourceSchedule> resourceSchedules = jdbc.query(sql, params, new ResourceScheduleRowMapper());
        return resourceSchedules;
	}

	@Override
	public List<ResourceSchedule> getResourceSchedulesByTourId(int tourId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tour_id", tourId);
        String sql = "SELECT * FROM resource_schedule WHERE tour_id = :tour_id";
        List<ResourceSchedule> resourceSchedules = jdbc.query(sql, params, new ResourceScheduleRowMapper());
        return resourceSchedules;
	}

	@Override
	public void deleteResourceSchedule(ResourceSchedule resourceSchedule) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("resource_id", resourceSchedule.getResourceId());
		params.addValue("tour_id", resourceSchedule.getTourId());
		params.addValue("start", resourceSchedule.getStartTimeSQL());
		params.addValue("duration", resourceSchedule.getDuration());
		params.addValue("status", resourceSchedule.getStatusId());
		String sql = "DELETE FROM resource_schedule WHERE resource_id=:resource_id AND "
			+ "tour_id=:tour_id AND start=:start AND duration=:duration AND status=:status";
		jdbc.update(sql, params);
	}
	
	public class ResourceScheduleRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResourceSchedule resourceSchedule = new ResourceSchedule();
			resourceSchedule.setResourceId(rs.getInt("resource_id"));
			resourceSchedule.setTourId(rs.getInt("tour_id"));
			resourceSchedule.setStartTimeSQL(rs.getTimestamp("start"));
			resourceSchedule.setDuration(rs.getInt("duration"));
			resourceSchedule.setStatusId(rs.getInt("status"));
			return resourceSchedule;
		}
	}
}
