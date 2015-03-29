package excursions.controllers;

import excursions.daos.TourDao;
import excursions.models.Tour;
import excursions.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private TourDao tourDao;

    @RequestMapping(value = "/api/tours", method = RequestMethod.GET)
    public @ResponseBody List<Tour> getTours(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return tourDao.getTours(Converter.fromJSON(Converter.fromBase64(token)).getCompanyId());
    }
}
