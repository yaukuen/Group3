package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import data.EmploymentDB;
import student.EmploymentData;
import student.Student;
import student.StudentCollection;


/**
 * This class creates the GUI for Adding and Editing Student's Data
 * @author Loc Bui
 *
 */
public class StudentEmploymentGUI extends JPanel implements ActionListener,
		TableModelListener {
	
	private static final int TABLE_WIDTH = 1100;
	private static final int TABLE_HEIGHT = 550;
	private static final long serialVersionUID = -7520370128176444786L;
	
	private JButton myBtnList, myBtnAdd, myAddBtn;
	private JPanel myPnlButtons, myPnlAdd, myPnlContent;
	private JLabel[] txfLabel = new JLabel[5];
	private JTextField[] txfField = new JTextField[5];
	private Object[][] mData;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] mItemColumnNames = {"name", "company", "position",
			"description", "skillUsed", "salary", "startDay", "endDay", "type" };

	private JComboBox<String> myStudentComboBox, myTypeComboBox;
	private String[] myStudentArrays;
	private JComboBox<String> myMonthStartComboBox, myMonthEndComboBox;
	private JComboBox<String> myYearStartComboBox, myYearEndComboBox;

	/**
	 * This constructor calls the method to create all of the components
	 */
	public StudentEmploymentGUI() {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}

	/**
	 * Create the three panels to add to this GUI. One for list, one for search,
	 * one for add.
	 */
	private void createComponents() {
		// A button panel at the top for list, search, add
		
		myPnlContent = new JPanel();
		myPnlButtons = new JPanel();
		myBtnList = new JButton("Student Employment List");
		myBtnList.addActionListener(this);

		myBtnAdd = new JButton("Add Student Employment");
		myBtnAdd.addActionListener(this);
		
		myPnlButtons.add(myBtnList);
		myPnlButtons.add(myBtnAdd);
		
		add(myPnlButtons, BorderLayout.NORTH);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	public void addPanel() {
		// Add Panel
		myPnlAdd = new JPanel();
		myPnlAdd.setLayout(new GridLayout(10, 0));
		
		JPanel comboPanel1 = new JPanel();
		comboPanel1.setLayout(new GridLayout(1, 0));
		
		List<Student> studentList = StudentCollection.showAll();
		myStudentArrays = new String[studentList.size()];
		
		for (int i = 0; i < studentList.size(); i++) {
			myStudentArrays[i] = studentList.get(i).getName() + " - SID: " + studentList.get(i).getID();
		}
		
		myStudentComboBox = new JComboBox<String>(myStudentArrays);
		comboPanel1.add(new JLabel("Choose a student: "));
		comboPanel1.add(myStudentComboBox);
		myPnlAdd.add(comboPanel1);
		
		String labelNames[] = { "Company:", "Position: ", "Description: ", "Skill Used: ", 
				"Salary: "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0));
			txfLabel[i] = new JLabel(labelNames[i]);
			txfField[i] = new JTextField(25);
			panel.add(txfLabel[i]);
			panel.add(txfField[i]);
			myPnlAdd.add(panel);
		}
		
		JPanel comboPanel4 = new JPanel();
		comboPanel4.setLayout(new GridLayout(1,2));
		String[] types = {"Job", "Internship"};
		myTypeComboBox = new JComboBox<String>(types);
		myTypeComboBox.setSelectedIndex(0);
        comboPanel4.add(new JLabel("Type (Job or Intership): "));
        comboPanel4.add(myTypeComboBox);
        myPnlAdd.add(comboPanel4);
        
		JPanel comboPanel2 = new JPanel();
        comboPanel2.setLayout(new GridLayout(1, 2));
        
//		String[] months = {"January", "February", "March", "April", "May", "June", 
//				"July", "August", "September", "October", "November", "December"};
		
		String[] months = {"01", "02", "03", "04", "05", "06", 
				"07", "08", "09", "10", "11", "12"};
		myMonthStartComboBox = new JComboBox<String>(months);
		myMonthStartComboBox.setSelectedIndex(0);
		
		String[] years = {"2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", 
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		
		myYearStartComboBox = new JComboBox<String>(years);
		myYearStartComboBox.setSelectedIndex(0);
        comboPanel2.add(new JLabel("Start Day (Month - Year): "));
        comboPanel2.add(myMonthStartComboBox);
        comboPanel2.add(myYearStartComboBox);
        myPnlAdd.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 2));
		myMonthEndComboBox = new JComboBox<String>(months);
		myMonthEndComboBox.setSelectedIndex(0);
		myYearEndComboBox = new JComboBox<String>(years);
		myYearEndComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("End Day (Month - Year): "));
        comboPanel3.add(myMonthEndComboBox);
        comboPanel3.add(myYearEndComboBox);
        myPnlAdd.add(comboPanel3);
		
		JPanel panel = new JPanel();
		myAddBtn = new JButton("Add");
		myAddBtn.addActionListener(this);
		panel.add(myAddBtn);
		myPnlAdd.add(panel);
		myPnlContent.add(myPnlAdd);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnAdd) {
			myPnlContent.removeAll();
			addPanel();
			myPnlContent.add(myPnlAdd);
			myPnlContent.revalidate();
			this.repaint();
		} else if (e.getSource() == myAddBtn) {
			performAddStudent();
		}
	}

	/**
	 * Perform adding a student's data.
	 */
	private void performAddStudent() {
		String company = txfField[0].getText();
		if (company.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Company Name");
			txfField[0].setFocusable(true);
			return;
		}
		
		String position = txfField[1].getText();
		if (position.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Position");
			txfField[1].setFocusable(true);
			return;
		}
		
		String posDescription = txfField[2].getText();
		if (posDescription.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Position Description");
			txfField[2].setFocusable(true);
			return;
		}
		
		String skillUsed = txfField[3].getText();
		if (skillUsed.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Skill Used");
			txfField[3].setFocusable(true);
			return;
		}
		
		String salaryStr = txfField[4].getText();
		int salary = 0;
		
		if (salaryStr.length() != 0) {
			try {
				salary = Integer.parseInt(salaryStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter salary");
				txfField[2].setFocusable(true);
				return;
			}
		}
		
		String type = (String) myTypeComboBox.getSelectedItem();
		
		String startDay = (String) myMonthStartComboBox.getSelectedItem() + "-" + myYearStartComboBox.getSelectedItem();
		String endDay = (String) myMonthEndComboBox.getSelectedItem() + "-" + myYearEndComboBox.getSelectedItem();
		
		String name = (String) myStudentComboBox.getSelectedItem();
		int index = name.indexOf(":");
		String sid = name.substring(index+2);
		
		EmploymentData empData = new EmploymentData(sid, company, position, posDescription, skillUsed,
				salary, type, startDay, endDay);
		
		String message = "Student add failed";
		if (EmploymentDB.addEmployment(empData)) {
			message = "Student added successfully";
		}
		JOptionPane.showMessageDialog(null, message);
		
		// Clear all text fields.
		for (int i = 0; i < txfField.length; i++) {
			if (txfField[i].getText().length() != 0) {
				txfField[i].setText("");
			}
		}
	}

	/**
	 * Listen to the cell changes on the table. 
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
	}

}