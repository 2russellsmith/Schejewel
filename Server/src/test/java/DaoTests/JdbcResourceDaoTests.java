
package DaoTests;

import static DaoTests.JdbcResourceDaoTests.resourceDao;
import static DaoTests.JdbcResourceDaoTests.testDao;
import static DaoTests.JdbcTourGroupDaoTests.companyDao;
import static DaoTests.JdbcTourGroupDaoTests.tourGroupDao;
import TestSuite.JdbcTestDao;
import TestSuite.TestDatabaseInfo;
import excursions.daos.JdbcCompanyDao;
import excursions.daos.JdbcResourceDao;
import excursions.daos.interfaces.CompanyDao;
import excursions.daos.interfaces.ResourceDao;
import excursions.models.Company;
import excursions.models.Resource;
import excursions.models.TourGroup;
import java.util.List;
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

public class JdbcResourceDaoTests {
	static ResourceDao resourceDao;
	static CompanyDao companyDao;
	static JdbcTestDao testDao;
	Resource resource1, resource2, badResource;
	Company company1, company2;
	
	public JdbcResourceDaoTests() {
		TestDatabaseInfo tdi = new TestDatabaseInfo();
		DataSource ds = tdi.getDataSource();
		resourceDao = new JdbcResourceDao();
		resourceDao.setDataSource(ds);
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
		
		resource1 = new Resource();
		resource1.setName("resource1");
		resource1.setCapacity(10);
		resource1.setOwnerId(company1.getCompanyId());
		
		resource2 = new Resource();
		resource2.setName("resource2");
		resource2.setOwnerId(company2.getCompanyId());
		
		badResource = new Resource();
	}
	
	@After
	public void tearDown() {
	}

    @Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCreateResource() {
		//test creation of resource
		resource1 = resourceDao.createResource(resource1);
		assert(resource1 != null);
		assert(resource1.getResourceId() >= 0);
		assertEquals(resource1.getName(), "resource1");
		
		Resource newResource = resourceDao.getResource(resource1.getResourceId());
		assertEquals(resource1.getResourceId(), newResource.getResourceId());
		assertEquals(resource1.getName(), newResource.getName());
		assertEquals(resource1.getCapacity(), newResource.getCapacity());
		assertEquals(resource1.getOwnerId(), newResource.getOwnerId());
		
		//test creation of resource with null name
		thrown.expect(DataIntegrityViolationException.class);
		badResource = resourceDao.createResource(badResource);
	}
	
	@Test
	public void testUpdateResource() {
		resource1 = resourceDao.createResource(resource1);
		resource2.setResourceId(resource1.getResourceId());
		
		//test that update works
		resource2 = resourceDao.updateResource(resource2);
		
		Resource newResource = resourceDao.getResource(resource1.getResourceId());
		assertEquals(resource2.getResourceId(), newResource.getResourceId());
		assertEquals(resource2.getName(), newResource.getName());
		assertEquals(resource2.getCapacity(), newResource.getCapacity());
		assertEquals(resource2.getOwnerId(), newResource.getOwnerId());
		
		//test update on resource that doesn't exist
		badResource.setResourceId(-1);
		badResource.setName("name");
		badResource.setOwnerId(company1.getCompanyId());
		badResource = resourceDao.updateResource(badResource);//doesn't throw exception
	}
	
	@Test
	public void testDeleteResource() {
		//test for successful deletion
		resource1 = resourceDao.createResource(resource1);
		int res1id = resource1.getResourceId();
		resource2 = resourceDao.createResource(resource2);
		resourceDao.deleteResource(resource1.getResourceId());
		
		//try to get deleted resource
		thrown.expect(EmptyResultDataAccessException.class);
		resource1 = resourceDao.getResource(resource1.getResourceId());
		
		//try to get non-deleted resource
		Resource newResource = resourceDao.getResource(resource2.getResourceId());
		assertEquals(resource2.getResourceId(), newResource.getResourceId());
		assertEquals(resource2.getName(), newResource.getName());
		assertEquals(resource2.getCapacity(), newResource.getCapacity());
		assertEquals(resource2.getOwnerId(), newResource.getOwnerId());
		
		//try to delete already deleted resource - this doesn't throw an exception
		resourceDao.deleteResource(res1id);
	}
	
	@Test
	public void testGetResource() {
		resource1 = resourceDao.createResource(resource1);
		resource2 = resourceDao.createResource(resource2);
		
		//test getResource on resources that exist
		Resource a = resourceDao.getResource(resource1.getResourceId());
		assertEquals(resource1.getResourceId(), a.getResourceId());
		assertEquals(resource1.getName(), a.getName());
		assertEquals(resource1.getCapacity(), a.getCapacity());
		assertEquals(resource1.getOwnerId(), a.getOwnerId());
		Resource b = resourceDao.getResource(resource2.getResourceId());
		assertEquals(resource2.getResourceId(), b.getResourceId());
		assertEquals(resource2.getName(), b.getName());
		assertEquals(resource2.getCapacity(), b.getCapacity());
		assertEquals(resource2.getOwnerId(), b.getOwnerId());
		
		//test getResource on resource that doesn't exist
		thrown.expect(EmptyResultDataAccessException.class);
		Resource c = resourceDao.getResource(resource2.getResourceId() + 1);
	}
	
	@Test
	public void testGetTourGroups() {
		resource1 = resourceDao.createResource(resource1);
		resource2 = resourceDao.createResource(resource2);
		
		Resource resource3 = new Resource();
		resource3.setName("resource3");
		resource3.setCapacity(30);
		resource3.setOwnerId(company1.getCompanyId());
		resource3 = resourceDao.createResource(resource3);
		
		List<Resource> resources = resourceDao.getResources(company1.getCompanyId());
		assertEquals(resources.size(), 2);
		
		Resource newResource = resources.get(0);
		assertEquals(resource1.getResourceId(), newResource.getResourceId());
		assertEquals(resource1.getName(), newResource.getName());
		assertEquals(resource1.getCapacity(), newResource.getCapacity());
		assertEquals(resource1.getOwnerId(), newResource.getOwnerId());
		
		newResource = resources.get(1);
		assertEquals(resource3.getResourceId(), newResource.getResourceId());
		assertEquals(resource3.getName(), newResource.getName());
		assertEquals(resource3.getCapacity(), newResource.getCapacity());
		assertEquals(resource3.getOwnerId(), newResource.getOwnerId());
	}
}
