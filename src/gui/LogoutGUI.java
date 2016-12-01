package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class creates the GUI for logging out
 * and a button to show things about this program
 * @author Loc Bui
 *
 */
public class LogoutGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7655286335054538989L;
	private JButton myBtnLogout, myBtnAbout;
	private JPanel myBtnPanel;

	/**
	 * The constructor to call the method to create all of the components
	 */
	public LogoutGUI() {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}
	
	/**
	 * This method creates the panel for log out button and about buttn
	 */
	private void createComponents() {
		myBtnPanel = new JPanel();
		myBtnLogout = new JButton("Log Out");
		myBtnLogout.addActionListener(this);
		myBtnAbout = new JButton("About This Program");
		myBtnAbout.addActionListener(this);
		myBtnPanel.add(myBtnLogout);
		myBtnPanel.add(myBtnAbout);
		add(myBtnPanel, BorderLayout.NORTH);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnLogout) {
			HomeGUI.close();
			new MainGUI();
		} else if (e.getSource() == myBtnAbout) {
			JOptionPane.showMessageDialog(null, "About this program", 
    				"About" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
