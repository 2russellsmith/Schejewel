package excursions.daos;

import excursions.daos.interfaces.ResourceDao;
import excursions.models.Resource;
import excursions.models.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class JdbcResourceDao implements ResourceDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

	@Override
    public void setDataSource(DataSource ds) {
        jdbc = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<Resource> getResources(int companyId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyId", companyId);
        String sql = "SELECT * FROM resource WHERE owner_id = :companyId";
        List<Resource> resources = jdbc.query(sql, params, new ResourceRowMapper());
        return resources;
    }

    @Override
    public Resource getResource(int resourceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", resourceId);
        String sql = "SELECT * FROM resource WHERE id = :id";
        Resource resource = (Resource)jdbc.queryForObject(sql, params, new ResourceRowMapper());
        return resource;
    }

    @Override
    public Resource updateResource(Resource toUpdate) {
        MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", toUpdate.getResourceId());
		params.addValue("name", toUpdate.getName());
		params.addValue("capacity", toUpdate.getCapacity());
        params.addValue("owner_id", toUpdate.getOwnerId());
        String sql = "UPDATE resource SET name = :name, capacity = :capacity, owner_id = :owner_id"
			+ " WHERE id = :id";
        jdbc.update(sql, params);
        return toUpdate;
    }

    @Override
    public Resource deleteResource(int resourceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", resourceId);
        String sql = "DELETE FROM resource WHERE id = :id";
        jdbc.update(sql, params);
        return null;
    }

    @Override
    public Resource createResource(Resource toCreate) {
        MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", toCreate.getName());
		params.addValue("capacity", toCreate.getCapacity());
        params.addValue("owner_id", toCreate.getOwnerId());
        String sql = "INSERT INTO resource(name,capacity,owner_id) VALUES(:name,:capacity,:owner_id)";
		
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		toCreate.setResourceId(kh.getKey().intValue());
		return toCreate;
    }

	@Override
    //Todo: change the startTime to startDate and remove endTime
	public List<Resource> getResources(int companyId, long startTime, long endTime) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = format1.format(startTime);
		String endDate = format1.format(endTime);
		
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyId", companyId);
        params.addValue("startTime", startDate);
        params.addValue("endTime", endDate);
        String sql = "SELECT * FROM resource WHERE companyid = :companyId";//TODO:and startTime < booked < endTime
        List<Resource> resources = jdbc.queryForList(sql, params, Resource.class);
        return resources;
	}
	
	public class ResourceRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Resource resource = new Resource();
			resource.setResourceId(rs.getInt("id"));
			resource.setName(rs.getString("name"));
			int capacity = rs.getInt("capacity");
			if (rs.wasNull())
				resource.setCapacity(null);
			else
				resource.setCapacity(capacity);
			resource.setOwnerId(rs.getInt("owner_id"));
			return resource;
		}
	}
}
