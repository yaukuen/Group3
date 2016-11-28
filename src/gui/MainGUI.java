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

import data.LoginDB;

/**
 * The GUI for Main
 * @author Loc Bui
 *
 */
public class MainGUI implements ActionListener{
	private JFrame myFrame;
	private JPanel myLoginPnl;
	private JTextField myUserName;
	private JTextField myPassword;
	private JLabel myLabel, myLabelP;
	private JButton myLoginBtn, myStudentLoginBtn;
	
	public static void main(String[] args) {
		new MainGUI();
	}
	
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
	
	public void createLogin() {
		myLoginPnl = new JPanel(new GridLayout(3,2));
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
		
		myLoginBtn = new JButton("Log in");
		myLoginBtn.setPreferredSize(new Dimension(100,20));
		myLoginBtn.addActionListener(this);
		myLoginPnl.add(myLoginBtn);
		myFrame.add(myLoginPnl, BorderLayout.NORTH);
		
		myStudentLoginBtn = new JButton("Log in as a student");
		myStudentLoginBtn.addActionListener(this);
		myFrame.add(myStudentLoginBtn, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myStudentLoginBtn) {
			HomeGUI home = new HomeGUI();
			home.studentPermission();
			myFrame.dispose();
		}
		
		if (e.getSource() == myLoginBtn) {
			LoginDB login = new LoginDB();
			String user = myUserName.getText();
			String pass = myPassword.getText();
			try {
				login.login(user, pass);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			myFrame.dispose();
		}
	}
}
