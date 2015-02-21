package excursions.controllers;

import java.util.List;

import excursions.daos.JdbcResourceDao;
import excursions.daos.interfaces.ResourceDao;
import excursions.models.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResourceController {
    @Autowired
    private ResourceDao resourceDao = new JdbcResourceDao();
    
    public List<Resource> getResources(){
    	return resourceDao.getResources();
    }
    public Resource getResource(int ResourceId){
    	return resourceDao.getResource(ResourceId);
    }
    public Resource updateResource(Resource toUpdate){
    	return resourceDao.updateResource(toUpdate);
    }
    public Resource deleteResource(int ResourceId){
    	return resourceDao.deleteResource(ResourceId);
    }
    public Resource createResource(Resource toCreate){
    	return resourceDao.createResource(toCreate);
    }
}
