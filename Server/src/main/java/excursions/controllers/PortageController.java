package excursions.controllers;

import excursions.daos.PortageDao;
import excursions.models.Portage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortageController {
    @Autowired
    private PortageDao portageDao;

    @RequestMapping(value = "/api/portages", method = RequestMethod.GET)
    public @ResponseBody List<Portage> getPortages(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return portageDao.getPortages();
    }
}
