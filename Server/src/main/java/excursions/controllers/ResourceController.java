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
    public List<Resource> getResources(String token, long startTime, long endTime){
        User user = Converter.fromJSON(Converter.fromBase64(token));
        return resourceDao.getResources(user.getCompanyId(), startTime, endTime);
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
