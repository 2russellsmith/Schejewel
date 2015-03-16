package excursions.resources;

import java.util.List;

import excursions.controllers.ResourceController;
import excursions.models.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResourceResource {
    @Autowired
    private ResourceController resourceController = new ResourceController();   
    
    @RequestMapping(value = "/api/resource", method = RequestMethod.GET)
    public @ResponseBody List<Resource> getResources(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return resourceController.getResources(token);
    }

    @RequestMapping(value = "/api/resource/{startTime}", method = RequestMethod.GET)
    public @ResponseBody List<Resource> getResources(@RequestHeader(value="X-AUTH-TOKEN") String token, @PathVariable(value = "startTime") long startTime){
        return resourceController.getResources(token, startTime);
    }
    @RequestMapping(value = "/api/resource/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody Resource getResource(@PathVariable(value = "resourceId") int ResourceId){
        return resourceController.getResource(ResourceId);
    } 
    @RequestMapping(value = "/api/resource", method = RequestMethod.PUT)
    public @ResponseBody Resource updateResource(@RequestBody Resource toUpdate){
        return resourceController.updateResource(toUpdate);
    }
    @RequestMapping(value = "/api/resource{resourceId}", method = RequestMethod.DELETE)
    public @ResponseBody Resource deleteResource(@PathVariable(value = "resourceId") int ResourceId){
        return resourceController.deleteResource(ResourceId);//this is null as of now.  don't try to access what this returns
    }
    @RequestMapping(value = "/api/resource", method = RequestMethod.POST)
    public @ResponseBody Resource createResource(@RequestBody Resource toCreate){
        return resourceController.createResource(toCreate);
    }
}
