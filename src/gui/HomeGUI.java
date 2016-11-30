package gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * The GUI for Home with features for user to use 
 * based on their permission of access.
 * @author Loc Bui
 *
 */
public class HomeGUI {
	private JFrame myFrame;
	private JTabbedPane myTabbedPane;
	
	/**
	 * This constructors calls the method to create the GUI.
	 */
	public HomeGUI() {
		myFrame = new JFrame("Home");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		myFrame.setSize(1200, 700);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}
	
	/**
	 * This method creates several tabs for different features for user to use.
	 */
	private void createComponents()
	{
		myTabbedPane = new JTabbedPane();
		JComponent addPanel = makeTextPanel("Add or Update Student's Data");
		myTabbedPane.addTab("Add or Update Student's Data", addPanel);
		JComponent genePanel = makeTextPanel("Generates Outputs");
		myTabbedPane.addTab("Generates Outputs", genePanel);
		JComponent requestPanel = makeTextPanel("Request to Edit Student's Data");
		myTabbedPane.addTab("Request to Edit Student's Data", requestPanel);
		JComponent requestViewPanel = makeTextPanel("View Students' Request");
		myTabbedPane.addTab("View Student Request", requestViewPanel);
		myFrame.add(myTabbedPane);
	}
	
	/**
	 * Create the the particular part to add to the tab based on the type.
	 * @param type the tab's type.
	 * @return the panel.
	 */
	private JComponent makeTextPanel(String type) {
		JPanel panel = new JPanel();
		if (type.equalsIgnoreCase("Add or Update Student's Data")) {
			panel.add(new StudentGUI());
		} else if (type.equalsIgnoreCase("Generates Outputs")) {
			panel.add(new OutputGUI());
		} else if (type.equalsIgnoreCase("Request to Edit Student's Data")) {
			panel.add(new RequestMakingGUI());
		} else if (type.equalsIgnoreCase("View Students' Request")) {
			panel.add(new ViewRequestGUI());
		}
		return panel;
	}
	
	/**
	 * This method restricts the permission for user as a student.
	 */
	public void studentPermission() {
		myTabbedPane.setSelectedIndex(2);
		myTabbedPane.setEnabledAt(0, false);
		myTabbedPane.setEnabledAt(1, false);
		myTabbedPane.setEnabledAt(3, false);
	}
	
	/**
	 * This method restricts the permission for user as an advisor.
	 */
	public void advisorPermission() {
		myTabbedPane.setSelectedIndex(0);
		myTabbedPane.setEnabledAt(1, false);
		myTabbedPane.setEnabledAt(2, false);
	}
	
	/**
	 * This method restricts the permission for user as a faculty.
	 */
	public void facultyPermission() {
		myTabbedPane.setSelectedIndex(1);
		myTabbedPane.setEnabledAt(0, false);
		myTabbedPane.setEnabledAt(2, false);
	}
}