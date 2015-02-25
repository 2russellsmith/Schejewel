package excursions.daos;

import excursions.daos.interfaces.ResourceDao;
import excursions.models.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcResourceDao implements ResourceDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public void setDataSource(DataSource ds) {
        jdbc = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<Resource> getResources(int companyId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyId", companyId);
        String sql = "SELECT * FROM resource WHERE companyid = :companyId";
        List<Resource> resources = jdbc.queryForList(sql, params, Resource.class);
        return resources;
    }

    @Override
    public Resource getResource(int resourceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", resourceId);
        String sql = "SELECT * FROM resource WHERE id = :id";

        Resource resource = jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(Resource.class));
        return resource;
    }

    @Override
    public Resource updateResource(Resource toUpdate) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(toUpdate);
        String sql = "UPDATE resource SET name = :name, capacity = :capacity WHERE id = :id";
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
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(toCreate);
        String sql = "INSERT INTO resource(id,name,capacity,owner_id) VALUES(:id,:name,:capacity,:owner_id)";
        jdbc.update(sql, params);
        return toCreate;
    }

	@Override
	public List<Resource> getResources(int companyId, long startTime, long endTime) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyId", companyId);
        params.addValue("startTime", startTime);//TODO: convert this to something that MySQL will recognize
        params.addValue("endTime", endTime);//TODO: convert this to something that MySQL will recognize
        String sql = "SELECT * FROM resource WHERE companyid = :companyId";//TODO:and startTime < booked < endTime
        List<Resource> resources = jdbc.queryForList(sql, params, Resource.class);
        return resources;

	}
}
