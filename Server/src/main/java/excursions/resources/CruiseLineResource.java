package excursions.resources;

import excursions.controllers.CruiseLineController;
import excursions.models.CruiseLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CruiseLineResource {
    @Autowired
    private CruiseLineController cruiseLineController = new CruiseLineController();

    @RequestMapping(value = "/api/cruiseline", method = RequestMethod.GET)
    public @ResponseBody List<CruiseLine> getCrusieLines(){
        return cruiseLineController.getCruiseLines();
    }

    @RequestMapping(value = "/api/cruiseline/{cruiselineid}", method = RequestMethod.GET)
    public @ResponseBody CruiseLine getCruiseLine(@PathVariable(value="cruiselineid")int cruiseLineId){
        return cruiseLineController.getCruiseLine(cruiseLineId);
    }

    @RequestMapping(value = "/api/cruiseline", method = RequestMethod.PUT)
    public @ResponseBody CruiseLine updateCruiseLine(@RequestBody CruiseLine cruiseLine){
        return cruiseLineController.updateCruiseLine(cruiseLine);
    }

    @RequestMapping(value = "/api/cruiseline/{cruiselineid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCruiseLine(@PathVariable(value="cruiselineid") int cruiseLineId){
        cruiseLineController.deleteCruiseLine(cruiseLineId);
    }

    @RequestMapping(value = "/api/cruiseline", method = RequestMethod.POST)
    public @ResponseBody CruiseLine createCruiseLine(@RequestBody CruiseLine cruiseLine){
        return cruiseLineController.createCruiseLine(cruiseLine);
    }
}
