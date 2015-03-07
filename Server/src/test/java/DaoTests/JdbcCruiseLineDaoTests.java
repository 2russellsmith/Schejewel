
package DaoTests;

import static DaoTests.JdbcCruiseLineDaoTests.testDao;
import TestSuite.JdbcTestDao;
import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcCruiseLineDao;
import excursions.daos.interfaces.CruiseLineDao;
import excursions.models.CruiseLine;
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

public class JdbcCruiseLineDaoTests {
	static CruiseLineDao cruiseLineDao;
	static JdbcTestDao testDao;
	CruiseLine cruiseLine1, cruiseLine2, badCruiseLine;
	
	public JdbcCruiseLineDaoTests() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
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
		cruiseLine1.setId(-1);
		cruiseLine2 = new CruiseLine();
		cruiseLine2.setName("cruiseLine2");
		badCruiseLine = new CruiseLine();
	}
	
	@After
	public void tearDown() {
	}

    @Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCreateCruiseLine() {
		//test creation of cruiseLine
		cruiseLine1 = cruiseLineDao.createCruiseLine(cruiseLine1);
		assert(cruiseLine1 != null);
		assert(cruiseLine1.getId() != -1);
		assert(cruiseLine1.getId() >= 0);
		assertEquals(cruiseLine1.getName(), "cruiseLine1");
		
		//test creation of cruiseLine with null name
		thrown.expect(DataIntegrityViolationException.class);
		badCruiseLine = cruiseLineDao.createCruiseLine(badCruiseLine);
	}
	
	@Test
	public void testUpdateCruiseLine() {
		cruiseLine1 = cruiseLineDao.createCruiseLine(cruiseLine1);
		cruiseLine2.setId(cruiseLine1.getId());
		
		//test that update works
		cruiseLine2 = cruiseLineDao.updateCruiseLine(cruiseLine2);
		assertEquals(cruiseLine1.getId(), cruiseLine2.getId());
		assertEquals(cruiseLine2.getName(), "cruiseLine2");
		
		//test update on cruiseLine that doesn't exist
		badCruiseLine.setId(-1);
		badCruiseLine.setName("name");
		badCruiseLine = cruiseLineDao.updateCruiseLine(badCruiseLine);//doesn't throw exception
	}
	
	@Test
	public void testDeleteCruiseLine() {
		//test for successful deletion
		cruiseLine1 = cruiseLineDao.createCruiseLine(cruiseLine1);
		int comp1id = cruiseLine1.getId();
		cruiseLine2 = cruiseLineDao.createCruiseLine(cruiseLine2);
		int comp2id = cruiseLine2.getId();
		cruiseLineDao.deleteCruiseLine(cruiseLine1.getId());
		
		//try to get deleted cruiseLine
		thrown.expect(EmptyResultDataAccessException.class);
		cruiseLine1 = cruiseLineDao.getCruiseLine(cruiseLine1.getId());
		
		//try to get non-deleted cruiseLine
		cruiseLine2 = cruiseLineDao.getCruiseLine(cruiseLine2.getId());
		assertEquals(cruiseLine2.getId(), comp2id);
		assertEquals(cruiseLine2.getName(), "cruiseLine2");
		
		//try to delete already deleted cruiseLine - this doesn't throw an exception
		cruiseLineDao.deleteCruiseLine(comp1id);
	}
	
	@Test
	public void testGetCruiseLine() {
		cruiseLine1 = cruiseLineDao.createCruiseLine(cruiseLine1);
		cruiseLine2 = cruiseLineDao.createCruiseLine(cruiseLine2);
		
		//test getCruiseLine on cruiseLines that exist
		CruiseLine a = cruiseLineDao.getCruiseLine(cruiseLine1.getId());
		assertEquals(cruiseLine1.getId(), a.getId());
		assertEquals(cruiseLine1.getName(), a.getName());
		CruiseLine b = cruiseLineDao.getCruiseLine(cruiseLine2.getId());
		assertEquals(cruiseLine2.getId(), b.getId());
		assertEquals(cruiseLine2.getName(), b.getName());
		
		//test getCruiseLine on cruiseLine that doesn't exist
		thrown.expect(EmptyResultDataAccessException.class);
		CruiseLine c = cruiseLineDao.getCruiseLine(cruiseLine2.getId() + 1);
		
	}
}
