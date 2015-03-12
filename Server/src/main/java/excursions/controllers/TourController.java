package excursions.controllers;

import excursions.daos.JdbcTourDao;
import excursions.daos.interfaces.TourDao;
import excursions.models.Tour;
import java.util.List;

import excursions.models.User;
import excursions.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TourController {
    @Autowired
    private TourDao tourDao = new JdbcTourDao();
	
	public List<Tour> getTours(String token) {
        User user = Converter.fromJSON(Converter.fromBase64(token));
		return tourDao.getTours(user.getCompanyId());
	}

	public Tour getTour(int tourId) {
		return tourDao.getTour(tourId);
	}

	public Tour updateTour(Tour tour) {
		return tourDao.updateTour(tour);
	}

	public void deleteTour(int tourId) {
		tourDao.deleteTour(tourId);
	}

	public Tour createTour(Tour tour) {
		
		return tourDao.createTour(tour);
	}
}
