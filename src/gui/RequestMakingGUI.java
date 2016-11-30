package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class creates the GUI for making a request to edit student's employment information.
 * @author Loc Bui
 *
 */
public class RequestMakingGUI extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1779520078061383929L;
	private JButton myBtnMake, myBtnInstruction;
	private JPanel myPnlButtons;

	/**
	 * This constructor calls the modthod to create all of the components.
	 */
	public RequestMakingGUI() {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}

	/**
	 * Create the three panels to add to this GUI. One for making a request,
	 * one for the instruction for making a request
	 */
	private void createComponents() {
		// A button panel at the top for list, search, add
		myPnlButtons = new JPanel();
		myBtnMake = new JButton("Make A Request");
		myBtnMake.addActionListener(this);

		myBtnInstruction = new JButton("Instruction For Making A Request");
		myBtnInstruction.addActionListener(this);

		myPnlButtons.add(myBtnMake);
		myPnlButtons.add(myBtnInstruction);
		add(myPnlButtons, BorderLayout.NORTH);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnInstruction) {
			JOptionPane.showMessageDialog(null, "Name: \nSID: \nCompany: "
					+ "\nPosition: \nDescription: \nSkill used: \nSalary: "
					+ "\nStart day: \nEnd day: \nType (Job or Internship): ", 
    				"Request Instruction" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}