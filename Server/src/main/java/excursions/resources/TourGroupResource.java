package excursions.resources;

import excursions.controllers.TourGroupController;
import excursions.models.Tour;
import excursions.models.TourGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourGroupResource {
    @Autowired
    private TourGroupController tourGroupController = new TourGroupController();

    @RequestMapping(value = "/api/tourgroup", method = RequestMethod.GET)
    public @ResponseBody List<TourGroup> getTourGroups(){
        return tourGroupController.getTourGroups();
    }

    @RequestMapping(value = "/api/tourgroup/{tourgroupid}", method = RequestMethod.GET)
    public @ResponseBody TourGroup getTourGroup(@RequestParam(value="tourgroupid")int tourGroupId){
        return tourGroupController.getTourGroup(tourGroupId);
    }

    @RequestMapping(value = "/api/tourgroup", method = RequestMethod.PUT)
    public @ResponseBody TourGroup updateTourGroup(@RequestBody TourGroup tourGroup){
        return tourGroupController.updateTourGroup(tourGroup);
    }

    @RequestMapping(value = "/api/tourgroup/{tourgroupid}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTourGroup(@RequestParam(value="tourgroupid") int tourGroupId){
        tourGroupController.deleteTourGroup(tourGroupId);
    }

    @RequestMapping(value = "/api/tourgroup", method = RequestMethod.POST)
    public @ResponseBody TourGroup createTourGroup(@RequestBody TourGroup tourGroup){
        return tourGroupController.createTourGroup(tourGroup);
    }
}
