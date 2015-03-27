package excursions.controllers;

import java.util.List;

import excursions.daos.JdbcResourceDao;
import excursions.daos.interfaces.ResourceDao;
import excursions.models.Resource;
import excursions.models.User;
import excursions.utils.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResourceController {
    @Autowired
    private ResourceDao resourceDao = new JdbcResourceDao();
    
    public List<Resource> getResources(String token){
        User user = Converter.fromJSON(Converter.fromBase64(token));
        return resourceDao.getResources(user.getCompanyId());
    }
    public List<Resource> getResources(String token, String startTime){
        User user = Converter.fromJSON(Converter.fromBase64(token));        
        return resourceDao.getResources(user.getCompanyId(), startTime);
    }    
    public Resource getResource(int resourceId){
    	return resourceDao.getResource(resourceId);
    }
    public Resource updateResource(Resource resource){
    	return resourceDao.updateResource(resource);
    }
    public Resource deleteResource(int resourceId){
    	return resourceDao.deleteResource(resourceId);
    }
    public Resource createResource(Resource resource){
    	return resourceDao.createResource(resource);
    }
}
