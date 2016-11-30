package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	private JButton myBtnMake, myBtnInstruction, myAddBtn;
	private JPanel myPnlButtons, myInfoPnl, myPnlContent;
	private JLabel[] txfLabel = new JLabel[2];
	private JTextField[] txfField = new JTextField[2];
	private JLabel txfLabelNew = new JLabel();
	private JTextArea txfArea = new JTextArea();

	/**
	 * This constructor calls the method to create all of the components.
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
		myPnlContent = new JPanel();
		myPnlContent.setLayout(new BorderLayout());
		myPnlButtons = new JPanel();
		myBtnMake = new JButton("Make A Request");
		myBtnMake.addActionListener(this);

		myBtnInstruction = new JButton("Information Needed For Making A Request");
		myBtnInstruction.addActionListener(this);

		myPnlButtons.add(myBtnMake);
		myPnlButtons.add(myBtnInstruction);
		
		addPanel();
		
		add(myPnlButtons, BorderLayout.NORTH);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	public void addPanel() {
		// Add Panel
		myInfoPnl = new JPanel();
		myInfoPnl.setLayout(new GridLayout(3, 0));
		String labelNames[] = { "Name (First Last):", "SID: "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0));
			txfLabel[i] = new JLabel(labelNames[i]);
			txfField[i] = new JTextField(25);
			panel.add(txfLabel[i]);
			panel.add(txfField[i]);
			myInfoPnl.add(panel);
		}
		
		JPanel myCommentPnl = new JPanel(new GridLayout(2, 0));
		JPanel commentPanel = new JPanel();
		commentPanel.setLayout(new GridLayout(1,0));
		txfLabelNew = new JLabel("Comment: ");
		txfArea = new JTextArea(10, 10);
		txfArea.setLineWrap(true);
		txfArea.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(txfArea);
		commentPanel.add(txfLabelNew);
		commentPanel.add(scroll);
		myCommentPnl.add(commentPanel);
		
		
		JPanel panel = new JPanel();
		myAddBtn = new JButton("Add");
		myAddBtn.addActionListener(this);
		panel.add(myAddBtn);
		myCommentPnl.add(panel);
		myPnlContent.add(myInfoPnl, BorderLayout.NORTH);
		myPnlContent.add(myCommentPnl, BorderLayout.SOUTH);
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
		} else if (e.getSource() == myBtnMake) {
			myPnlContent.removeAll();
			addPanel();
			myPnlContent.add(myInfoPnl);
			myPnlContent.revalidate();
		} else if (e.getSource() == myAddBtn) {
			System.out.println(txfArea.getText());
		}
	}
}