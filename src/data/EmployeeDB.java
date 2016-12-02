package data;

import gui.HomeGUI;
import gui.MainGUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * This class contains methods to access Employee table.
 * Created by Yau on 11/27/2016.
 */
public class EmployeeDB {

    /**
     * It's a connection for connecting to the database.
     */
    private Connection myConnection;


    /**
     * It login to the system by given Employee information.
     *
     * @param theEmployee An Employee login in information
     * @return A string message that telling user success or not.
     */
	public String login(String user, String pass) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
        Statement stmt = null;
	    try {
	        if (user != null && pass != null) {
	            String sql = "Select * from Login where username ='" + user + "' and password='" + pass + "'";
	            stmt = myConnection.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                //in this case enter when at least one result comes it means user is valid
	            	int role = rs.getInt("role");
	            	HomeGUI home = new HomeGUI();
	            	if (role == 1) {
		            	home.advisorPermission();
	            		JOptionPane.showMessageDialog(null, "You are logged in as an Advisor",
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            		return "Sucess";
	            	} else if (role == 2) {
	            		home.adminPermission();
	            		JOptionPane.showMessageDialog(null, "You are logged in as an Administrative Staff", 
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            		return "Sucess";
	            	} else {
	            		home.facultyPermission();
	            		JOptionPane.showMessageDialog(null, "You are logged in as a Faculty",
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            		return "Sucess";
	            	}
	            } else {
	                //in this case enter when  result size is zero  it means user is invalid
	            	JOptionPane.showMessageDialog(null, "Invalid username or password",
	            			"Login failed" , JOptionPane.INFORMATION_MESSAGE);
	            	new MainGUI();
	            	return null;
	            }
	        }
	        // You can also validate user by result size if its comes zero user is invalid else user is valid

	    } catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
	    }
	    return null;
	}
}
