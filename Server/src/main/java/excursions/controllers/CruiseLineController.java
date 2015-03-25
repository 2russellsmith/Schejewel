package excursions.controllers;

import excursions.daos.JdbcCruiseLineDao;
import excursions.daos.interfaces.CruiseLineDao;
import excursions.models.CruiseLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CruiseLineController {
    @Autowired
    private CruiseLineDao cruiseLineDao = new JdbcCruiseLineDao();

    public List<CruiseLine> getCruiseLines(){
        return cruiseLineDao.getCruiseLines();
    }

    public CruiseLine getCruiseLine(int cruiseLineId){
        return cruiseLineDao.getCruiseLine(cruiseLineId);
    }

    public CruiseLine updateCruiseLine(CruiseLine cruiseLine){
        return cruiseLineDao.updateCruiseLine(cruiseLine);
    }

    public void deleteCruiseLine(int cruiseLineId){
        cruiseLineDao.deleteCruiseLine(cruiseLineId);
    }

    public CruiseLine createCruiseLine(CruiseLine cruiseLine){
        return cruiseLineDao.createCruiseLine(cruiseLine);
    }
}
