/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoTests;

import TestSuite.JdbcTestDao;
import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcTourDao;
import excursions.daos.interfaces.TourDao;
import excursions.models.Tour;
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
public class JdbcTourDaoTests {
	static TourDao tourDao;
	static JdbcTestDao testDao;
	Tour tour1;
	
	public JdbcTourDaoTests() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
		tourDao = new JdbcTourDao();
		tourDao.setDataSource(ds);
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
		tour1 = new Tour();
		tour1.setOwnerId(5);
		tour1.setStartDate(100000000);
		tour1.setEndDate(200000000);
		tour1.setTourTypes(9);
	}
	
	@After
	public void tearDown() {
	}

    
	@Test
	public void testCreateTour() {
		/*
		This is the error message I'm getting:
		error code '1452', message [Cannot add or update a child row: a foreign key constraint fails
		(`alaska`.`tour`, CONSTRAINT `tour_ibfk_1` FOREIGN KEY (`tour_type_id`) REFERENCES `tour_type` 
		(`id`))];
		I think this means the we need to put some data into the tour_type table before we can insert
		into the tour table.
		*/
			Tour result = tourDao.createTour(tour1);
		Tour newTour = tourDao.getTour(result.getTourId());
		assertEquals(tour1.getTourId(), newTour.getTourId());
		assertEquals(tour1.getOwnerId(), newTour.getOwnerId());
		assertEquals(tour1.getStartDate(), newTour.getStartDate());
		assertEquals(tour1.getEndDate(), newTour.getEndDate());
		assertEquals(tour1.getTourTypes(), newTour.getTourTypes());
	}
}
