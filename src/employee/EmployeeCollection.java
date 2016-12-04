package employee;

import data.EmployeeDB;

import java.sql.SQLException;

/**
 * It's a collection of all the employees information
 * and login.
 * Created by Yau on 11/27/2016.
 */
public class EmployeeCollection {

//    private List<Employee> myEmployee;

    /**
     * Employee collection's database for connecting to the data base.
     */
    private static EmployeeDB myEmployeeDB;

    /**
     * A login to find employee is in the system or not.
     *
     * @param username An employee's username.
     * @param password An employee's password.
     * @return true if found, otherwise return false.
     * @throws SQLException if query is not correct.
     */
    public static boolean login(String username, String password, int theRole) throws SQLException {
        if (myEmployeeDB == null) {
            myEmployeeDB = new EmployeeDB();
        }

//        String message = null;
//        if (!message.matches(theEmployee.getMyUserName())) {
//            message = myEmployeeDB.login(theEmployee);
//            if (message == null) {
//                return false;
//            }
//        }

        String message = myEmployeeDB.login(username, password, theRole);
        return message != null;
    }
}
