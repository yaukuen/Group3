package test;

import employee.EmployeeCollection;
import gui.MainGUI;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

/**
 * Test class for the EmployeeCollection class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class EmployeeCollectionTest {
    /**
     * Test the login method for admin.
     *
     * @throws SQLException if error occur.
     */
    @Test
    public void testAdminLogin() throws SQLException {
        boolean adminLoginSuccess = EmployeeCollection.login("admin", "admin", MainGUI.EMPLOYEE);
        assertTrue(adminLoginSuccess);
    }

    /**
     * Test the login method for advisor.
     *
     * @throws SQLException if error occur.
     */
    @Test
    public void testAdvisorLogin() throws SQLException {
        boolean advisorLoginSuccess = EmployeeCollection.login("advisor", "advisor", MainGUI.EMPLOYEE);
        assertTrue(advisorLoginSuccess);
    }

    /**
     * Test the login method for faculty.
     *
     * @throws SQLException if error occur.
     */
    @Test
    public void testFacultyLogin() throws SQLException {
        boolean staffLoginSuccess = EmployeeCollection.login("faculty", "faculty", MainGUI.EMPLOYEE);
        assertTrue(staffLoginSuccess);
    }

    /**
     * Test the login method for student.
     *
     * @throws SQLException if error occur.
     */
    @Test
    public void testStudentLogin() throws SQLException {
        boolean studentLoginSuccess = EmployeeCollection.login(null, null, MainGUI.STUDENT);
        assertTrue(studentLoginSuccess);
    }
}
