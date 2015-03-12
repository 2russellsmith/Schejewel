package excursions.controllers;

import excursions.daos.JdbcTourGroupDao;
import excursions.daos.interfaces.TourGroupDao;
import excursions.models.TourGroup;
import excursions.models.User;
import excursions.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TourGroupController {
    @Autowired
    private TourGroupDao tourGroupDao = new JdbcTourGroupDao();

    public List<TourGroup> getTourGroups(String token){
        User user = Converter.fromJSON(Converter.fromBase64(token));
        return tourGroupDao.getTourGroups(user.getCompanyId());
    }

    public TourGroup getTourGroup(int tourGroupId){
        return tourGroupDao.getTourGroup(tourGroupId);
    }

    public TourGroup updateTourGroup(TourGroup tourGroup){
        return tourGroupDao.updateTourGroup(tourGroup);
    }

    public void deleteTourGroup(int tourGroupId){
        tourGroupDao.deleteTourGroup(tourGroupId);
    }

    public TourGroup createTourGroup(TourGroup tourGroup){
        return tourGroupDao.createTourGroup(tourGroup);
    }
}
