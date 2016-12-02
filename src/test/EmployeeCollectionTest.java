package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import employee.EmployeeCollection;

/**
 * Test class for the EmployeeCollection class.
 * @author Nico Tandyo
 */
public class EmployeeCollectionTest {
	/**
	 * Test the login method.
	 * @throws SQLException
	 */
	@Test
	public void testAddRequest() throws SQLException {
		boolean adminLoginSuccess = EmployeeCollection.login("admin", "admin");
		assertTrue(adminLoginSuccess);
		boolean advisorLoginSuccess = EmployeeCollection.login("advisor", "advisor");
		assertTrue(advisorLoginSuccess);
		boolean staffLoginSuccess = EmployeeCollection.login("faculty", "faculty");
		assertTrue(staffLoginSuccess);
	}
}
