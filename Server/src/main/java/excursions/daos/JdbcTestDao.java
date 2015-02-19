/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excursions.daos;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTestDao {
	private final String[] tableNames = new String[] { "user_privileges", "tour", "tour_type_resource",
		"resource", "tour_group", "tour_type", "portage", "cruise_ship", "cruise_line",
		"privilege", "user", "company"};
    private NamedParameterJdbcTemplate jdbc;
	
	public JdbcTestDao(DataSource ds) {
		jdbc = new NamedParameterJdbcTemplate(ds);
	}

    public void clearDataBase(){
		MapSqlParameterSource params = new MapSqlParameterSource();
        for (int i = 0; i < tableNames.length; i++) {
			String sql = "DELETE FROM " + tableNames[i];
			jdbc.update(sql, params);
		}
    }
}
