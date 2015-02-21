package excursions.daos.interfaces;

import java.util.List;

import javax.sql.DataSource;

import excursions.models.Resource;

public interface ResourceDao {
	public void setDataSource(DataSource ds);
	public List<Resource> getResources();
	public Resource getResource(int ResourceId);
	public boolean updateResource(Resource toUpdate);
	public boolean deleteResource(int ResourceId);
	public boolean createResource(Resource toCreate);
	
}
