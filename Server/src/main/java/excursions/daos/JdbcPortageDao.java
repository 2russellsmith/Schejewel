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
        String sql = "SELECT p.id, s.name, p.cruise_ship_id AS cruiseShipId, p.arrival_date AS arrivalDate, p.arrival_time AS arrivalTime, p.departure_date AS departureDate, " +
                "p.departure_time AS departureTime, p.passengers AS passengerCount, p.aa AS allAboard, p.dock, p.voyage, p.location FROM portage p, cruise_ship s WHERE " +
                "s.id = p.cruise_ship_id";
        List<Portage> portages = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Portage.class));
        return portages;
    }
}
