package excursions.daos;

import excursions.models.Portage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPortageDao implements PortageDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Portage> getPortages() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "SELECT id, cruise_ship_id AS cruiseShipId, arrival_date AS arrivalDate, arrival_time AS arrivalTime, departure_date AS departureDate, " +
        "departure_time AS departureTime, passengers AS passengerCount, aa AS allAboard, dock, voyage, location FROM portage";
        List<Portage> portages = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Portage.class));
        return portages;
    }
}
