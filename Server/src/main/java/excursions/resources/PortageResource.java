package excursions.resources;

import excursions.controllers.PortageController;
import excursions.models.Portage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortageResource {
    @Autowired
    private PortageController portageController = new PortageController();

    @RequestMapping(value = "/api/portage", method = RequestMethod.GET)
    public @ResponseBody
    List<Portage> getPortages(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return portageController.getPortages(token);
    }

    @RequestMapping(value = "/api/portage/{portageid}", method = RequestMethod.GET)
    public @ResponseBody Portage getPortage(@PathVariable(value="portageid")int portageId){
        return portageController.getPortage(portageId);
    }

    @RequestMapping(value = "/api/portage", method = RequestMethod.PUT)
    public @ResponseBody Portage updatePortage(@RequestBody Portage portage){
        return portageController.updatePortage(portage);
    }

    @RequestMapping(value = "/api/portage/{portageid}", method = RequestMethod.DELETE)
    public @ResponseBody void deletePortage(@PathVariable(value="portageid") int portageId){
        portageController.deletePortage(portageId);
    }

    @RequestMapping(value = "/api/Portage", method = RequestMethod.POST)
    public @ResponseBody Portage createPortage(@RequestBody Portage portage){
        return portageController.createPortage(portage);
    }
}
