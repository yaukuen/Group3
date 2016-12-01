package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class creates the GUI for generating outputs 
 * based on the criterion that the user has chosen to view by.
 * @author Loc Bui
 *
 */
public class OutputGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7655286335054538989L;
	private JButton myBtnSearch;
	private JComboBox<String> myComboBox;
	private JPanel myComboBoxPnl;
	private String[] myComboBoxValues = {"GPA", "Salary", "Major", "Degree", "Internship", "Job"};

	/**
	 * The constructor to call the method to create all of the components
	 */
	public OutputGUI() {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}
	
	/**
	 * This method creates the panel for generating outputs.
	 */
	private void createComponents() {
		myComboBoxPnl = new JPanel();
		JLabel label = new JLabel("Choose a criterion to search by: ");
		myComboBoxPnl.add(label);
		myComboBox = new JComboBox<String>();
		for (int i = 0; i < myComboBoxValues.length; i++) {
			myComboBox.addItem(myComboBoxValues[i]);
		}
		myComboBoxPnl.add(myComboBox);
		myBtnSearch = new JButton("Search");
		myBtnSearch.addActionListener(this);
		myComboBoxPnl.add(myBtnSearch);
		add(myComboBoxPnl, BorderLayout.NORTH);
		
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnSearch) {
			JOptionPane.showMessageDialog(null, "Nothing to search for, need to be implemented", 
    				"Nothing to search" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
