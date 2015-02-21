package excursions.daos.interfaces;

import java.util.List;

import javax.sql.DataSource;

import excursions.models.Resource;

public interface ResourceDao {
	public void setDataSource(DataSource ds);
	public List<Resource> getResources();
	public Resource getResource(int ResourceId);
	public Resource updateResource(Resource toUpdate);
	public Resource deleteResource(int ResourceId);
	public Resource createResource(Resource toCreate);
	
}
