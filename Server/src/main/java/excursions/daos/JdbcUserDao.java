package excursions.daos;

import excursions.daos.interfaces.UserDao;
import excursions.models.User;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
        String sql = "SELECT username,password FROM user WHERE username = :username";

        User user = jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public User createUser(User user){
        //Create a hash from the users password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        //Set params attributes from user and execute the sql
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
        String sql = "INSERT INTO user(username,password) VALUES(:username,:password)";

        jdbc.update(sql,params);
        return user;
    }
}
