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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import employee.EmployeeCollection;

/**
 * This class creates a GUI for the login process 
 * and goes to the HomeGUI after the user has logged in.
 * @author Loc Bui
 *
 */
public class MainGUI implements ActionListener{
	public static final int EMPLOYEE = 1;
	public static final int STUDENT = 2;
	private static final int WIDTH = 380;
	private static final int HEIGHT = 125;
	private JFrame myFrame;
	private JPanel myLoginPnl, myLoginBtnPnl;
	private JTextField myUserName;
	private JTextField myPassword;
	private JLabel myLabel, myLabelP;
	private JButton myLoginBtn, myStudentLoginBtn, myBtnAbout;
	
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
		myFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
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
		
		myStudentLoginBtn = new JButton("Log in as a student");
		myStudentLoginBtn.addActionListener(this);
		myBtnAbout = new JButton("About This Program");
		myBtnAbout.addActionListener(this);
		myLoginBtnPnl.add(myStudentLoginBtn);
		myLoginBtnPnl.add(myBtnAbout);

		myFrame.add(myLoginPnl, BorderLayout.NORTH);
		myFrame.add(myLoginBtnPnl, BorderLayout.SOUTH);
	}

	/**
	 * This method makes the buttons work. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myStudentLoginBtn) {
			try {
                EmployeeCollection.login(null, null, STUDENT);
			} catch (SQLException e1) {
				e1.printStackTrace(); //For debugging!
				JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
						+ "\nPlease check your internet connection and restart the program!",
				"Login failed" , JOptionPane.WARNING_MESSAGE);
			}
			myFrame.dispose();
		} else if (e.getSource() == myLoginBtn) {

			String user = myUserName.getText();
			String pass = myPassword.getText();
			try {
				EmployeeCollection.login(user, pass, EMPLOYEE);
			} catch (SQLException err) {
				err.printStackTrace(); //For debugging!
				JOptionPane.showMessageDialog(null, "Unable to connect to the server!"
						+ "\nPlease check your internet connection and restart the program!",
				"Login failed" , JOptionPane.WARNING_MESSAGE);
			}
			myFrame.dispose();
		} else if (e.getSource() == myBtnAbout) {
			String about = "This is the final project for TCSS 360 - Software Development"
					+ " and\nQuality Assurance Techniques at University of Washington Tacoma.\n"
					+ "\nThe README.txt contains the information for using this program including\nthe "
					+ "username and password for logging in if you want to try our program.\nThank you!\n"
					+ "\nGroup members:\nLoc Bui - locbui@uw.edu\nYau Kuen Tsang - yktsang@uw.edu\nNico Tandyo - nicot@uw.edu";

			
			JOptionPane.showMessageDialog(null, about, 
    				"About This Program" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}