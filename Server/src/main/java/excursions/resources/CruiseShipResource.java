package excursions.resources;

import excursions.controllers.CruiseShipController;
import excursions.models.CruiseShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CruiseShipResource {
    @Autowired
    private CruiseShipController cruiseShipController = new CruiseShipController();

    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.GET)
    public @ResponseBody List<CruiseShip> getCrusieShips(){
        return cruiseShipController.getCruiseShips();
    }

    @RequestMapping(value = "/api/cruiseship/{cruiseshipid}", method = RequestMethod.GET)
    public @ResponseBody CruiseShip getCruiseShip(@RequestParam(value="cruiseshipid")int cruiseShipId){
        return cruiseShipController.getCruiseShip(cruiseShipId);
    }

    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.PUT)
    public @ResponseBody CruiseShip updateCruiseShip(@RequestBody CruiseShip cruiseShip){
        return cruiseShipController.updateCruiseShip(cruiseShip);
    }

    @RequestMapping(value = "/api/cruiseship/{cruiseshipid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCruiseShip(@RequestParam(value="cruiseshipid") int cruiseShipId){
        cruiseShipController.deleteCruiseShip(cruiseShipId);
    }

    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.POST)
    public @ResponseBody CruiseShip createCruiseShip(@RequestBody CruiseShip cruiseShip){
        return cruiseShipController.createCruiseShip(cruiseShip);
    }
}
