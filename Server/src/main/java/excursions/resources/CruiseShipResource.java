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

    //Todo: The sql is broken for this endpoint
    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.GET)
    public @ResponseBody List<CruiseShip> getCrusieShips(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return cruiseShipController.getCruiseShips(token);
    }

    //Todo: The sql is broken for this endpoint
    @RequestMapping(value = "/api/cruiseship/{cruiseshipid}", method = RequestMethod.GET)
    public @ResponseBody CruiseShip getCruiseShip(@PathVariable(value="cruiseshipid")int cruiseShipId){
        return cruiseShipController.getCruiseShip(cruiseShipId);
    }

    //Todo: Could not test because of sql exceptions
    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.PUT)
    public @ResponseBody CruiseShip updateCruiseShip(@RequestBody CruiseShip cruiseShip){
        return cruiseShipController.updateCruiseShip(cruiseShip);
    }

    //Todo: Could not test because of sql exceptions
    @RequestMapping(value = "/api/cruiseship/{cruiseshipid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCruiseShip(@PathVariable(value="cruiseshipid") int cruiseShipId){
        cruiseShipController.deleteCruiseShip(cruiseShipId);
    }

    //Todo: Could not test because of sql exceptions
    @RequestMapping(value = "/api/cruiseship", method = RequestMethod.POST)
    public @ResponseBody CruiseShip createCruiseShip(@RequestBody CruiseShip cruiseShip){
        return cruiseShipController.createCruiseShip(cruiseShip);
    }
}
