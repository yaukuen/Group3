package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import employee.Employee;

/**
 * Test class for the Employee class
 * @author Nico Tandyo
 *
 */
public class EmployeeTest {
	
    private String mUserName = "EmployeeTest";
    private String mPassword = "employee";
    private int mRole = 1;
    private String mId = "982345";
    private Employee mEmployee;
    /**
	 * Set up the employee.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mEmployee = new Employee(mUserName, mPassword);
		mEmployee.setMyRole(mRole);
		mEmployee.setMyId(mId);
	}
	/**
	 * Test the constructor.
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testConstructor() {
		new Employee(null, null);
		new Employee("John", null);
	}
	/**
	 * Test setMyUserName and getMyUserName methods.
	 */
	@Test
	public void testSetGetName() {
		String test = "SetTest";
		mEmployee.setMyUserName(test);
		assertEquals(mEmployee.getMyUserName(), test);
	}
	/**
	 * Test setMyPassword and getMyPassword methods.
	 */
	@Test
	public void testSetGetPassword() {
		String test = "setpassword";
		mEmployee.setMyPassword(test);
		assertEquals(mEmployee.getMyPassword(), test);
	}
	/**
	 * Test setMyRole and getMyRole methods.
	 */
	@Test
	public void testSetGetRole() {
		int test = 0;
		mEmployee.setMyRole(test);
		assertEquals(mEmployee.getMyRole(), test);
	}
	/**
	 * Test setMyID and getMyID methods.
	 */
	@Test
	public void testSetGetID() {
		String test = "0987766";
		mEmployee.setMyId(test);
		assertEquals(mEmployee.getMyId(), test);
	}

}
