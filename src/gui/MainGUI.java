package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.EmployeeDB;

/**
 * This class creates a GUI for the login process 
 * and goes to the HomeGUI after the user has logged in.
 * @author Loc Bui
 *
 */
public class MainGUI implements ActionListener{
	private JFrame myFrame;
	private JPanel myLoginPnl, myLoginBtnPnl;
	private JTextField myUserName;
	private JTextField myPassword;
	private JLabel myLabel, myLabelP;
	private JButton myLoginBtn, myStudentLoginBtn;
	
	/**
	 * The main method for running the GUI
	 * @param args
	 */
	public static void main(String[] args) {
		new MainGUI();
	}
	
	/**
	 * This constructor calls the method to create the login GUI.
	 */
	public MainGUI() {
		myFrame = new JFrame("Log in");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new BorderLayout());
		myFrame.setPreferredSize(new Dimension(300, 125));
		
		createLogin();

		myFrame.setVisible(true);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);
	}
	
	/**
	 * This method creates the login panel with buttons.
	 */
	public void createLogin() {
		myLoginPnl = new JPanel(new GridLayout(2,2));
		myLabel = new JLabel("Enter Username:");
		myLabel.setSize(myLabel.getPreferredSize());
		myLoginPnl.add(myLabel);
		
		myUserName = new JTextField();
		myUserName.setSize(myUserName.getPreferredSize());
		myUserName.setToolTipText("Enter Username");
		myUserName.setVisible(true);
		myLoginPnl.add(myUserName);
		
		myLabelP = new JLabel("Enter Password:");
		myLabelP.setSize(myLabelP.getPreferredSize());
		myLoginPnl.add(myLabelP);
		
		myPassword = new JTextField();
		myPassword.setSize(myPassword.getPreferredSize());
		myPassword.setToolTipText("Enter Password");
		myPassword.setVisible(true);
		myLoginPnl.add(myPassword);
		
		myLoginBtnPnl = new JPanel();
		myLoginBtn = new JButton("Log in");
		myLoginBtn.addActionListener(this);
		myLoginBtnPnl.add(myLoginBtn);
		myFrame.add(myLoginPnl, BorderLayout.NORTH);
		
		myStudentLoginBtn = new JButton("Log in as a student");
		myStudentLoginBtn.addActionListener(this);
		myLoginBtnPnl.add(myStudentLoginBtn);
		myFrame.add(myLoginBtnPnl, BorderLayout.SOUTH);
	}

	/**
	 * This method makes the buttons work. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myStudentLoginBtn) {
			HomeGUI home = null;
			try {
				home = new HomeGUI();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			home.studentPermission();
			myFrame.dispose();
		}
		
		if (e.getSource() == myLoginBtn) {
			EmployeeDB employee = new EmployeeDB();
			String user = myUserName.getText();
			String pass = myPassword.getText();
			try {
				employee.login(user, pass);
			} catch (SQLException err) {
				err.printStackTrace();
			}
			myFrame.dispose();
		}
	}
}
