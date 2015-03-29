package excursions.daos;

import excursions.models.Portage;

import java.util.List;

public interface PortageDao {
    List<Portage> getPortages();
}
