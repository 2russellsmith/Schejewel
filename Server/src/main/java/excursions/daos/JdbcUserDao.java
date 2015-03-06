package excursions.daos;

import excursions.daos.interfaces.UserDao;
import excursions.models.Tour;
import excursions.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDao implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
	
	//set DataSource when testing
	@Override
	public void setDataSource(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
    @Override
    public User findUserByUsername(String username) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username",username);
        String sql = "SELECT * FROM user WHERE username = :username";
        User user = (User)jdbc.queryForObject(sql, params, new UserRowMapper());
        return user;
    }

    public User createUser(User user){
        //Create a hash from the users password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        //Set params attributes from user and execute the sql
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
        String sql = "INSERT INTO user(username,password,company_id) VALUES(:username,:password,:companyId)";
		KeyHolder kh = new GeneratedKeyHolder();
		jdbc.update(sql, params, kh);
		user.setId(kh.getKey().intValue());
        return user;
    }

	@Override
	public User getUser(int userid) {
		MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",userid);
        String sql = "SELECT * FROM user WHERE id = :id";
        User user = (User)jdbc.queryForObject(sql, params, new UserRowMapper());
        return user;
	}

	@Override
	public List<User> getUsers(int companyid) {
		return null;
	}

	@Override
	public void deleteUser(int userid) {
		
	}

	@Override
	public User updateUser(User user) {
		return null;
	}
	
	public class UserRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setCompanyId(rs.getInt("company_id"));
			return user;
		}
	}
}
