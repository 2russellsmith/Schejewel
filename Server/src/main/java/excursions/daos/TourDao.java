package excursions.daos;

import excursions.models.Tour;

import java.util.List;

public interface TourDao {
    List<Tour> getTours(int companyId);
}
