package excursions.resources;

import java.util.List;

import excursions.controllers.ResourceController;
import excursions.models.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResourceResource {
    @Autowired
    private ResourceController resourceController = new ResourceController();   
    
    @RequestMapping(value = "/api/resource", method = RequestMethod.GET)
    public ResponseEntity<List<Resource>> getResources(@RequestHeader(value="X-AUTH-TOKEN") String token){
        return new ResponseEntity<List<Resource>>(resourceController.getResources(token), HttpStatus.FOUND);
    }
    //or they could just pass us one value and we would assume that they only meant for that day.
    //this just feels more robust
    @RequestMapping(value = "/api/resource", method = RequestMethod.GET)
    public ResponseEntity<List<Resource>> getResources(@RequestHeader(value="X-AUTH-TOKEN") String token, 
    													@RequestParam(value = "startTime") long startTime,
    													@RequestParam(value = "endTime") long endTime){
        return new ResponseEntity<List<Resource>>(resourceController.getResources(token, startTime, endTime), HttpStatus.FOUND);
    }
    @RequestMapping(value = "/api/resource", params = {"ResourceId"}, method = RequestMethod.GET)
    public ResponseEntity<Resource> getResource(@RequestParam(value = "ResourceId") int ResourceId){
        return new ResponseEntity<Resource>(resourceController.getResource(ResourceId), HttpStatus.FOUND);
    } 
    @RequestMapping(value = "/api/resource", method = RequestMethod.PUT)
    public ResponseEntity<Resource> updateResource(@RequestBody Resource toUpdate){
        return new ResponseEntity<Resource>(resourceController.updateResource(toUpdate), HttpStatus.OK);
    }
    @RequestMapping(value = "/api/resource", params = {"ResourceId"}, method = RequestMethod.DELETE)
    public ResponseEntity<Resource> deleteResource(@RequestParam(value = "ResourceId") int ResourceId){
        return new ResponseEntity<Resource>(resourceController.deleteResource(ResourceId), HttpStatus.FOUND);//this is null as of now.  don't try to access what this returns
    }
    @RequestMapping(value = "/api/resource", method = RequestMethod.POST)
    public ResponseEntity<Resource> createResource(@RequestBody Resource toCreate){
        return new ResponseEntity<Resource>(resourceController.createResource(toCreate), HttpStatus.CREATED);
    }
}
