
package DaoTests;

import static DaoTests.JdbcCruiseShipDaoTests.testDao;
import static DaoTests.JdbcCruiseShipDaoTests.cruiseShipDao;
import TestSuite.JdbcTestDao;
import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcCruiseLineDao;
import excursions.daos.JdbcCruiseShipDao;
import excursions.daos.interfaces.CruiseShipDao;
import excursions.models.CruiseLine;
import excursions.models.CruiseShip;
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
import org.springframework.dao.EmptyResultDataAccessException;

public class JdbcCruiseShipDaoTests {
	static CruiseShipDao cruiseShipDao;
	static JdbcCruiseLineDao cruiseLineDao;
	static JdbcTestDao testDao;
	CruiseShip cruiseShip1, cruiseShip2, badCruiseShip;
	CruiseLine cruiseLine1, cruiseLine2;
	
	public JdbcCruiseShipDaoTests() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
		cruiseShipDao = new JdbcCruiseShipDao();
		cruiseShipDao.setDataSource(ds);
		cruiseLineDao = new JdbcCruiseLineDao();
		cruiseLineDao.setDataSource(ds);
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
		
		cruiseLine1 = new CruiseLine();
		cruiseLine1.setName("cruiseLine1");
		cruiseLine1 = cruiseLineDao.createCruiseLine(cruiseLine1);
		
		cruiseLine2 = new CruiseLine();
		cruiseLine2.setName("cruiseLine2");
		cruiseLine2 = cruiseLineDao.createCruiseLine(cruiseLine2);
		
		cruiseShip1 = new CruiseShip();
		cruiseShip1.setId(-1);
		cruiseShip1.setName("cruiseShip1");
		cruiseShip1.setCapacity(1000);
		cruiseShip1.setCruiseLineId(cruiseLine1.getId());
		
		cruiseShip2 = new CruiseShip();
		cruiseShip2.setName("cruiseShip2");
		cruiseShip2.setCapacity(2000);
		cruiseShip2.setCruiseLineId(cruiseLine2.getId());
		
		badCruiseShip = new CruiseShip();
	}
	
	@After
	public void tearDown() {
	}

    @Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCreateCruiseShip() {
		//test creation of cruiseShip
		cruiseShip1 = cruiseShipDao.createCruiseShip(cruiseShip1);
		assert(cruiseShip1 != null);
		assert(cruiseShip1.getId() != -1);
		assert(cruiseShip1.getId() >= 0);
		
		//test creation of cruiseShip with null name
		thrown.expect(DataIntegrityViolationException.class);
		badCruiseShip = cruiseShipDao.createCruiseShip(badCruiseShip);
		
		//test creation of cruiseShip with null cruiseLineid
		badCruiseShip.setName("");
		thrown.expect(DataIntegrityViolationException.class);
		badCruiseShip = cruiseShipDao.createCruiseShip(badCruiseShip);
	}
	
	@Test
	public void testUpdateCruiseShip() {
		cruiseShip1 = cruiseShipDao.createCruiseShip(cruiseShip1);
		cruiseShip2.setId(cruiseShip1.getId());
		cruiseShip2.setCruiseLineId(cruiseLine2.getId());
		
		//test that update works
		CruiseShip cruiseShip3 = cruiseShipDao.updateCruiseShip(cruiseShip2);
		assertEquals(cruiseShip2.getId(), cruiseShip3.getId());
		assertEquals(cruiseShip3.getName(), "cruiseShip2");
		assertEquals(cruiseShip3.getCapacity(), cruiseShip2.getCapacity());
		
		//test update on cruiseShip that doesn't exist
		badCruiseShip.setId(-1);
		badCruiseShip.setName("name");
		badCruiseShip = cruiseShipDao.updateCruiseShip(badCruiseShip);//doesn't throw exception
	}
	
	@Test
	public void testDeleteCruiseShip() {
		//test for successful deletion
		cruiseShip1 = cruiseShipDao.createCruiseShip(cruiseShip1);
		int tt1id = cruiseShip1.getId();
		cruiseShip2 = cruiseShipDao.createCruiseShip(cruiseShip2);
		int tt2id = cruiseShip2.getId();
		cruiseShipDao.deleteCruiseShip(cruiseShip1.getId());
		
		//try to get deleted cruiseShip
		thrown.expect(EmptyResultDataAccessException.class);
		cruiseShip1 = cruiseShipDao.getCruiseShip(cruiseShip1.getId());
		
		//try to get non-deleted cruiseShip
		cruiseShip2 = cruiseShipDao.getCruiseShip(cruiseShip2.getId());
		assertEquals(cruiseShip2.getId(), tt2id);
		assertEquals(cruiseShip2.getName(), "cruiseShip2");
		assertEquals(cruiseShip2.getId(), cruiseLine2.getId());
		
		//try to delete already deleted cruiseShip - this doesn't throw an exception
		cruiseShipDao.deleteCruiseShip(tt1id);
	}
	
	@Test
	public void testGetCruiseShip() {
		cruiseShip1 = cruiseShipDao.createCruiseShip(cruiseShip1);
		cruiseShip2 = cruiseShipDao.createCruiseShip(cruiseShip2);
		
		//test getCruiseShip on cruiseShips that exist
		CruiseShip a = cruiseShipDao.getCruiseShip(cruiseShip1.getId());
		assertEquals(cruiseShip1.getId(), a.getId());
		assertEquals(cruiseShip1.getName(), a.getName());
		assertEquals(cruiseShip1.getCapacity(), a.getCapacity());
		assertEquals(cruiseShip1.getCruiseLineId(), a.getCruiseLineId());
		CruiseShip b = cruiseShipDao.getCruiseShip(cruiseShip2.getId());
		assertEquals(cruiseShip2.getId(), b.getId());
		assertEquals(cruiseShip2.getName(), b.getName());
		assertEquals(cruiseShip2.getCapacity(), b.getCapacity());
		assertEquals(cruiseShip2.getCruiseLineId(), b.getCruiseLineId());
		
		//test getCruiseShip on cruiseShip that doesn't exist
		thrown.expect(EmptyResultDataAccessException.class);
		CruiseShip c = cruiseShipDao.getCruiseShip(cruiseShip2.getId() + 1);
		
	}
}
