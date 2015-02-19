/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuite;

import ControllerTests.UserControllerTests;
import DaoTests.JdbcUserDaoTests;
import ModelTests.LoginResponseModelTests;
import ModelTests.UserModelTests;
import ResourceTests.AuthenticationResourceTests;
import ResourceTests.UserResourceTests;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ivy Bridge
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserControllerTests.class, JdbcUserDaoTests.class, LoginResponseModelTests.class,
					UserModelTests.class, AuthenticationResourceTests.class, UserResourceTests.class})
public class TestSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
