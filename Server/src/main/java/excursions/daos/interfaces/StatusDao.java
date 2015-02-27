
package excursions.daos.interfaces;

import excursions.models.Status;
import javax.sql.DataSource;


public interface StatusDao {
	public void setDataSource(DataSource ds);
	public Status getStatus(int statusid);
	public Status updateStatus(Status status);
	public void deleteStatus(int statusid);
	public Status createStatus(Status status);
}
