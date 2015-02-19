package excursions.daos.interfaces;

import excursions.models.User;
import javax.sql.DataSource;

public interface UserDao {
	public void setDataSource(DataSource ds);
    public User findUserByUsername(String username);
    public User createUser(User user);
}
