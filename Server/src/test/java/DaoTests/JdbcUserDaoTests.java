/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoTests;

import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcUserDao;
import excursions.daos.interfaces.UserDao;
import excursions.models.User;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivy Bridge
 */
public class JdbcUserDaoTests {
	static UserDao userDao;
	static JdbcTestDao testDao;
	User user1;
	User user2;
	
	public JdbcUserDaoTests() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
		userDao = new JdbcUserDao();
		userDao.setDataSource(ds);
		testDao = new JdbcTestDao(ds);
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		testDao.clearDataBase();
		
		user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("password1");
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testCreateUser() {
		User newUser = userDao.createUser(user1);
		User user = userDao.findUserByUsername("user1");
		assertEquals(user.getUsername(), "user1");
		assertEquals(user.getPassword(), newUser.getPassword());
		
		//try to insert new user with same username
		user1.setPassword("password2");
		user2 = userDao.createUser(user1);
		user = userDao.findUserByUsername("user1");//throws error expected 1, actual 2
		assertEquals(user.getUsername(), "user1");
		assertEquals(user.getPassword(), user2.getPassword());
	}
	
	@Test
	public void testReadUser() {
		User user = userDao.findUserByUsername("user1");
		if (user == null)
			fail();
		
		assertEquals(user.getUsername(), "user1");
		assertEquals(user.getPassword(), user1.getPassword());
		
		//userDao throws error because returnset is empty, need more graceful failure
		user = userDao.findUserByUsername("user2");
		assert(user == null);
	}
	
	@Test
	public void testReadUserRoles() {
		
		
	}
}
