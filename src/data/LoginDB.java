package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import gui.HomeGUI;
import gui.MainGUI;

public class LoginDB {
	private Connection mConnection;
	
	public void login(String user, String pass) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
        Statement stmt = null;
	    try {
	        if (user != null && pass != null) {
	            String sql = "Select * from Login where username ='" + user + "' and password='" + pass + "'";
	            stmt = mConnection.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                //in this case enter when at least one result comes it means user is valid
	            	int role = rs.getInt("role");
	            	HomeGUI home = new HomeGUI();
	            	if (role == 1) {
		            	home.advisorPermission();
	            		JOptionPane.showMessageDialog(null, "You are logged in as an Advisor",
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            	} else if (role == 2) {
	            		JOptionPane.showMessageDialog(null, "You are logged in as an Administrative", 
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            	} else {
	            		home.facultyPermission();
	            		JOptionPane.showMessageDialog(null, "You are logged in as a Faculty",
	            				"Login success" , JOptionPane.INFORMATION_MESSAGE);
	            	}
	            } else {
	                //in this case enter when  result size is zero  it means user is invalid
	            	JOptionPane.showMessageDialog(null, "Invalid username or password",
	            			"Login failed" , JOptionPane.INFORMATION_MESSAGE);
	            	new MainGUI();
	            }
	        }
	        // You can also validate user by result size if its comes zero user is invalid else user is valid

	    } catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
	    }
	}
}
