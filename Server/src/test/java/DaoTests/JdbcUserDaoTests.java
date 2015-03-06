/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoTests;

import static DaoTests.JdbcCompanyDaoTests.companyDao;
import TestSuite.JdbcTestDao;
import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcCompanyDao;
import excursions.daos.JdbcUserDao;
import excursions.daos.interfaces.CompanyDao;
import excursions.daos.interfaces.UserDao;
import excursions.models.Company;
import excursions.models.User;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Ivy Bridge
 */
public class JdbcUserDaoTests {
	static UserDao userDao;
	static CompanyDao companyDao;
	static JdbcTestDao testDao;
	User user1, user2, badUser;
	Company company1, company2;
	
	public JdbcUserDaoTests() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
		userDao = new JdbcUserDao();
		userDao.setDataSource(ds);
		companyDao = new JdbcCompanyDao();
		companyDao.setDataSource(ds);
		testDao = new JdbcTestDao(ds);
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		testDao.clearDataBase();
		
		company1 = new Company();
		company1.setName("company1");
		company1 = companyDao.createCompany(company1);
			
		company2 = new Company();
		company2.setName("company2");
		company2 = companyDao.createCompany(company2);
		
		user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("password1");
		user1.setCompanyId(company1.getCompanyId());
		
		user2 = new User();
		user2.setUsername("user2");
		user2.setPassword("password2");
		user2.setCompanyId(company2.getCompanyId());
		
		badUser = new User();
	}
	
	@After
	public void tearDown() {
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCreateUser() {
		//test creation of user
		user1 = userDao.createUser(user1);
		assert(user1 != null);
		User newUser = userDao.getUser(user1.getId());
		assertEquals(user1.getUsername(), newUser.getUsername());
		assertEquals(user1.getPassword(), newUser.getPassword());
		assertEquals(user1.getCompanyId(), newUser.getCompanyId());
		
		//test creation of user with same username
		user2.setUsername("user1");
		thrown.expect(DuplicateKeyException.class);
		user2 = userDao.createUser(user2);
		
		//test creation of user with various stages of incompleteness
		thrown.expect(java.lang.NullPointerException.class);
		badUser = userDao.createUser(badUser);
		
		badUser.setUsername("username");
		thrown.expect(java.lang.NullPointerException.class);
		badUser = userDao.createUser(badUser);
		
		badUser.setPassword("password");
		thrown.expect(DataIntegrityViolationException.class);
		badUser = userDao.createUser(badUser);
		
		badUser.setCompanyId(company1.getCompanyId());
		badUser = userDao.createUser(badUser);
		newUser = userDao.getUser(badUser.getId());
		assertEquals(badUser.getUsername(), newUser.getUsername());
		assertEquals(badUser.getPassword(), newUser.getPassword());
		assertEquals(badUser.getCompanyId(), newUser.getCompanyId());
	}
	
	@Test
	public void testFindUserByUsername() {
		user1 = userDao.createUser(user1);
		user2 = userDao.createUser(user2);
		
		User newUser = userDao.findUserByUsername(user1.getUsername());
		assertEquals(user1.getUsername(), newUser.getUsername());
		assertEquals(user1.getPassword(), newUser.getPassword());
		assertEquals(user1.getCompanyId(), newUser.getCompanyId());
		
		newUser = userDao.findUserByUsername(user2.getUsername());
		assertEquals(user2.getUsername(), newUser.getUsername());
		assertEquals(user2.getPassword(), newUser.getPassword());
		assertEquals(user2.getCompanyId(), newUser.getCompanyId());
		
		thrown.expect(EmptyResultDataAccessException.class);
		newUser = userDao.findUserByUsername("bob");
	}
	
	@Test
	public void testGetUser() {
		
	}
	
	@Test
	public void testGetUsers() {
		
	}
	
	@Test
	public void testDeleteUser() {
		
	}
	
	@Test
	public void testUpdateUser() {
		
	}
}
