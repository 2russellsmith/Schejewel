package excursions.daos;

import excursions.models.Resource;
import excursions.models.Tour;
import excursions.models.TourGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTourDao implements TourDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Tour> getTours(int companyId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyId",companyId);
        String sql = "SELECT id, owner_id AS ownerId, start_date AS startDate, start_time AS startTime, tour_type_id AS tourTypeId, status AS statusId FROM tour WHERE owner_id = :companyId";
        List<Tour> tours = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Tour.class));

        sql = "SELECT id, name, start_time AS startTime, start_date AS startDate, capacity, owner_id AS ownerId, tour_id AS tourId, duration, status AS statusId " +
                "FROM resource r, resource_schedule rs WHERE r.id = rs.resource_id AND r.owner_id = :companyId";
        List<Resource> resources = jdbc.query(sql, params, new BeanPropertyRowMapper<>(Resource.class));

        sql = "SELECT id, portage_id AS portageId, tour_id AS tourId, group_size AS groupSize, settled FROM tour_group WHERE id IN(SELECT id FROM tour WHERE owner_id = :companyId)";
        List<TourGroup> tourGroups = jdbc.query(sql, params, new BeanPropertyRowMapper<>(TourGroup.class));

        for(Tour tour : tours){
            //Assign resources to tours
            for(Resource resource : resources){
                if(resource.getTourId() == tour.getId()){
                    tour.addResource(resource);
                }
            }

            //Assign tour groups to tours
            for(TourGroup tourGroup : tourGroups){
                if(tourGroup.getTourId() == tour.getId()){
                    tour.addTourGroup(tourGroup);
                }
            }
        }

        return tours;
    }
}
