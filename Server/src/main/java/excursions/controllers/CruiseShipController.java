package excursions.controllers;

import excursions.daos.JdbcCruiseShipDao;
import excursions.daos.interfaces.CruiseShipDao;
import excursions.models.CruiseShip;
import excursions.models.User;
import excursions.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CruiseShipController {
    @Autowired
    private CruiseShipDao cruiseShipDao = new JdbcCruiseShipDao();

    public List<CruiseShip> getCruiseShips(String token){
        User user = Converter.fromJSON(Converter.fromBase64(token));
        return cruiseShipDao.getCruiseShips(user.getCompanyId());
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
