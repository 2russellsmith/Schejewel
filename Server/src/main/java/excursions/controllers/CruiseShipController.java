package excursions.controllers;

import excursions.daos.JdbcCruiseShipDao;
import excursions.daos.interfaces.CruiseShipDao;
import excursions.models.CruiseShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CruiseShipController {
    @Autowired
    private CruiseShipDao cruiseShipDao = new JdbcCruiseShipDao();

    public List<CruiseShip> getCruiseShips(int cruiseLineId){
        return cruiseShipDao.getCruiseShips(cruiseLineId);
    }

    public CruiseShip getCruiseShip(int cruiseShipId){
        return cruiseShipDao.getCruiseShip(cruiseShipId);
    }

    public CruiseShip updateCruiseShip(CruiseShip cruiseShip){
        return cruiseShipDao.updateCruiseShip(cruiseShip);
    }

    public void deleteCruiseShip(int cruiseShipId){
        cruiseShipDao.deleteCruiseShip(cruiseShipId);
    }

    public CruiseShip createCruiseShip(CruiseShip cruiseShip){
        return cruiseShipDao.createCruiseShip(cruiseShip);
    }
}
