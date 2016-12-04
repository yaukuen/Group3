package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import gui.MainGUI;
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
		boolean adminLoginSuccess = EmployeeCollection.login("admin", "admin", MainGUI.EMPLOYEE);
		assertTrue(adminLoginSuccess);
		boolean advisorLoginSuccess = EmployeeCollection.login("advisor", "advisor", MainGUI.EMPLOYEE);
		assertTrue(advisorLoginSuccess);
		boolean staffLoginSuccess = EmployeeCollection.login("faculty", "faculty", MainGUI.EMPLOYEE);
		assertTrue(staffLoginSuccess);
        boolean studentLoginSuccess = EmployeeCollection.login(null, null, MainGUI.STUDENT);
        assertTrue(studentLoginSuccess);
	}
}
