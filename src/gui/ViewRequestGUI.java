package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class creates the GUI for viewing all of the student requests.
 * @author Loc Bui
 *
 */
public class ViewRequestGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8173105788916568140L;
	private JButton myBtnView, myBtnDelete;
	private JPanel myBtnPanel;

	/**
	 * The constructor to call the method to create all of the components
	 */
	public ViewRequestGUI() {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}
	
	/**
	 * This method creates the panel for viewing all of the request
	 * and delete button for deleting request after updating.
	 */
	private void createComponents() {
		myBtnView = new JButton("View all request");
		myBtnView.addActionListener(this);
		myBtnDelete = new JButton("Delete request");
		myBtnDelete.addActionListener(this);
		
		myBtnPanel = new JPanel();
		myBtnPanel.add(myBtnView);
		myBtnPanel.add(myBtnDelete);
		add(myBtnPanel, BorderLayout.NORTH);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnView) {
			JOptionPane.showMessageDialog(null, "Nothing to view, need to be implemented", 
    				"Nothing to view" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}