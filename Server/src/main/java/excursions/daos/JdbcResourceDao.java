package excursions.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import excursions.daos.interfaces.ResourceDao;
import excursions.models.Resource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcResourceDao implements ResourceDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<Resource> getResources() {
		List<Resource> resources = new ArrayList<>();
		
		String sql = "SELECT id,name,capacity,owner_id FROM resource";
		SqlParameterSource paramSource = null;//TODO: does this work?
		List<Map<String, Object>> rows = jdbc.queryForList(sql, paramSource );
		
		for (Map<String, Object> row : rows) {
			Resource resource = new Resource();
			resource.setId((Integer)(row.get("ID")));
			resource.setName((String)row.get("NAME"));
			resource.setCapacity((Integer)row.get("CAPACITY"));
			resource.setOwner_id((Integer)row.get("OWNER_ID"));
			resources.add(resource);
		}
		return resources;
	}

	@Override
	public Resource getResource(int ResourceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",ResourceId);
        String sql = "SELECT id,name,capacity,owner_id FROM resource WHERE id = :id";

        Resource resource = jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(Resource.class));
        return resource;
	}

	@Override
	public boolean updateResource(Resource toUpdate) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(toUpdate);
        String sql = "UPDATE resource SET name = :name, capacity = :capacity WHERE id = :id";

        jdbc.update(sql,params);
        //if(error) return false;
		return true;
	}

	@Override
	public boolean deleteResource(int ResourceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",ResourceId);
        String sql = "DELETE FROM resource WHERE id = :id";

        jdbc.update(sql,params);
        //if(error) return false;
		return true;
	}

	@Override
	public boolean createResource(Resource toCreate) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(toCreate);
        String sql = "INSERT INTO resource(id,name,capacity,owner_id) VALUES(:id,:name,:capacity,:owner_id)";

        jdbc.update(sql,params);
        //if(error) return false;
		return true;
	}
}
