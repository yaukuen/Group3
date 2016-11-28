package gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * The GUI for Home.
 * @author Loc Bui
 *
 */
public class HomeGUI {
	private JFrame myFrame;
	private JTabbedPane myTabbedPane;
	
	public static void main(String[] args) {
		new MainGUI();
	}
	public HomeGUI() {
		myFrame = new JFrame("Home");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		myFrame.setSize(700, 700);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}
	
	private void createComponents()
	{
		myTabbedPane = new JTabbedPane();
		JComponent addPanel = makeTextPanel("Add or Update Student's Data");
		myTabbedPane.addTab("Add or Update Student's Data", addPanel);
		JComponent genePanel = makeTextPanel("Generates Outputs");
		myTabbedPane.addTab("Generates Outputs", genePanel);
		JComponent requestPanel = makeTextPanel("Request to Edit Student's Data");
		myTabbedPane.addTab("Request to Edit Student's Data", requestPanel);
		myFrame.add(myTabbedPane);
	}
	
	private JComponent makeTextPanel(String type) {
		JPanel panel = new JPanel();
		if (type.equalsIgnoreCase("Add or Update Student's Data")) {
			panel.add(new JLabel("Implement 'Add or Update Student's Data'"));
		} else if (type.equalsIgnoreCase("Generates Outputs")) {
			panel.add(new JLabel("Implement 'Generates Outputs'"));
		} else if (type.equalsIgnoreCase("Request to Edit Student's Data")) {
			panel.add(new JLabel("Implement 'Request to Edit Student's Data'"));
		}
		return panel;
	}
	
	public void studentPermission() {
		myTabbedPane.setSelectedIndex(2);
		myTabbedPane.setEnabledAt(0, false);
		myTabbedPane.setEnabledAt(1, false);
	}
	
	public void advisorPermission() {
		myTabbedPane.setSelectedIndex(0);
		myTabbedPane.setEnabledAt(1, false);
		myTabbedPane.setEnabledAt(2, false);
	}
	
	public void facultyPermission() {
		myTabbedPane.setSelectedIndex(1);
		myTabbedPane.setEnabledAt(0, false);
		myTabbedPane.setEnabledAt(2, false);
	}
}
