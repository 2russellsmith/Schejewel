package excursions.controllers;

import excursions.daos.JdbcPortageDao;
import excursions.daos.interfaces.PortageDao;
import excursions.models.Portage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PortageController {
    @Autowired
    private PortageDao portageDao = new JdbcPortageDao();

    public List<Portage> getPortages(){
        return portageDao.getPortages();
    }

    public Portage getPortage(int portageId){
        return portageDao.getPortage(portageId);
    }

    public Portage updatePortage(Portage portage){
        return portageDao.updatePortage(portage);
    }

    public void deletePortage(int portageId){
        portageDao.deletePortage(portageId);
    }

    public Portage createPortage(Portage portage){
        return portageDao.createPortage(portage);
    }
}
