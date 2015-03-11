
package excursions.daos.interfaces;

import excursions.models.ResourceSchedule;
import java.util.List;
import javax.sql.DataSource;

public interface ResourceScheduleDao {
	public void setDataSource(DataSource ds);
	public ResourceSchedule createResourceSchedule(ResourceSchedule resourceSchedule);
	public List<ResourceSchedule> getResourceSchedulesByResourceId(int resourceId);
	public List<ResourceSchedule> getResourceSchedulesByTourId(int tourId);
	public void deleteResourceSchedule(ResourceSchedule resourceSchedule);
}
