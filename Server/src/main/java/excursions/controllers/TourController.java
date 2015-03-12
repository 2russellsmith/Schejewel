package excursions.controllers;

import excursions.daos.JdbcTourDao;
import excursions.daos.interfaces.TourDao;
import excursions.models.Tour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TourController {
    @Autowired
    private TourDao tourDao = new JdbcTourDao();
	
	public List<Tour> getTours() {
		//need to get company id
		return tourDao.getTours(0/*company id here*/);
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
