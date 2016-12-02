package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import data.EmploymentDB;
import student.EmploymentData;
import student.Student;
import student.StudentCollection;


/**
 * This class creates the GUI for Adding and Editing Student's Data
 * @author Loc Bui
 * @author Yau Tsang
 */
public class StudentEmploymentGUI extends JPanel implements ActionListener,
		TableModelListener {

	private static final long serialVersionUID = -7520370128176444786L;
    private static EmploymentDB myEmploymentDB;

    private JButton myBtnList, myBtnAdd, myAddBtn;
    private JPanel myPnlButtons, myPnlAdd, myPnlContent;
    private JLabel[] txfLabel = new JLabel[5];
    private JTextField[] txfField = new JTextField[5];
    /**
     * List of the Employments.
     */
	private List<EmploymentData> myList;
    /**
     * Put myList into a 2d Array,
     * and it will use in the myTable for displaying
     * the list of the Employments.
     */
	private Object[][] myData;
    private JTable myTable;
    private JScrollPane scrollPane;

    /**
     * Columns name of the Employment Table.
     */
	private String[] myEmploymentColumnNames = {"name", "sid", "company", "position",
			"description", "skillUsed", "salary", "startDay", "endDay", "type",};
    private JComboBox<String> myStudentComboBox, myTypeComboBox;
    private String[] myStudentArrays;
    private JComboBox<String> myMonthStartComboBox, myMonthEndComboBox;

	private JComboBox<String> myYearStartComboBox, myYearEndComboBox;

    /**
     * This constructor calls the method to create all of the components
     * @throws SQLException if it cause an error from the query calling SQL.
     */
	public StudentEmploymentGUI() {
		setLayout(new BorderLayout());
		if (myEmploymentDB == null) {
		    myEmploymentDB = new EmploymentDB();
        }
		myList = getData(null);
		createComponents();
		setVisible(true);
	}

    /**
     * Returns the data 2d to use in the list as well as the search panels.
     * @param theSearchKey the searching keyword.
     * @return a list of employment data.
     * @throws SQLException if it cause an error from the query calling SQL.
     */
    private List<EmploymentData> getData(final String theSearchKey) {
	    if (theSearchKey != null) {
            try {
                myList = myEmploymentDB.searchEmployments(theSearchKey);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                myList = myEmploymentDB.getEmployments();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (myList != null) {
	        myData = new Object[myList.size()][myEmploymentColumnNames.length];
	        for (int i = 0; i < myList.size(); i++) {
	            myData[i][0] = myList.get(i).getmStudentName();
                myData[i][1] = myList.get(i).getSID();
                myData[i][2] = myList.get(i).getCompany();
                myData[i][3] = myList.get(i).getPosition();
                myData[i][4] = myList.get(i).getDescription();
                myData[i][5] = myList.get(i).getSkill();
                myData[i][6] = myList.get(i).getSalary();
                myData[i][7] = myList.get(i).getStartDate();
                myData[i][8] = myList.get(i).getEndDate();
                myData[i][9] = myList.get(i).getType();
            }
        }
        return myList;
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

		// instant focus on the employment data list
		myTable = new JTable(myData, myEmploymentColumnNames);
		scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
		myPnlContent.add(scrollPane);
		// Adding listener for updating or modifying the myTable.
		myTable.getModel().addTableModelListener(this);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	/**
	 * Create the add student employment information panel.
	 */
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
		
		String labelNames[] = { "Company: *", "Position: * ", "Description: ", "Skill Used: * ", 
				"Salary per year: * "};
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
        comboPanel4.add(new JLabel("Type (Job or Intership): * "));
        comboPanel4.add(myTypeComboBox);
        myPnlAdd.add(comboPanel4);
        
		JPanel comboPanel2 = new JPanel();
        comboPanel2.setLayout(new GridLayout(1, 2));
		
		String[] months = {"01", "02", "03", "04", "05", "06", 
				"07", "08", "09", "10", "11", "12"};
		myMonthStartComboBox = new JComboBox<String>(months);
		myMonthStartComboBox.setSelectedIndex(0);
		
		String[] years = {"2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", 
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		
		myYearStartComboBox = new JComboBox<String>(years);
		myYearStartComboBox.setSelectedIndex(0);
        comboPanel2.add(new JLabel("Start Day (Month - Year): * "));
        comboPanel2.add(myMonthStartComboBox);
        comboPanel2.add(myYearStartComboBox);
        myPnlAdd.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 2));
		myMonthEndComboBox = new JComboBox<String>(months);
		myMonthEndComboBox.setSelectedIndex(0);
		myYearEndComboBox = new JComboBox<String>(years);
		myYearEndComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("End Day (Month - Year): * "));
        comboPanel3.add(myMonthEndComboBox);
        comboPanel3.add(myYearEndComboBox);
        myPnlAdd.add(comboPanel3);
		
		JPanel panel = new JPanel();
		myAddBtn = new JButton("Add");
		myAddBtn.addActionListener(this);
		JLabel label = new JLabel("(*) = Required Fields");
		panel.add(myAddBtn);
		panel.add(label);
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
		} else if (e.getSource() == myBtnList) {
		    myList = getData(null);
            myPnlContent.removeAll();
            myTable = new JTable(myData, myEmploymentColumnNames);
            myTable.getModel().addTableModelListener(this);
            scrollPane = new JScrollPane(myTable);
            scrollPane.setPreferredSize(new Dimension(StudentGUI.WIDTH, StudentGUI.HEIGHT));
            myPnlContent.add(scrollPane);
            myPnlContent.revalidate();
            this.repaint();
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
			posDescription = "NOT PROVIDED";
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
		
        //check for invalid start day and end day.
        int index2 = startDay.indexOf("-");
        int index1 = endDay.indexOf("-");
        int start = Integer.parseInt(startDay.substring(index2 + 1));
        int end = Integer.parseInt(endDay.substring(index1 + 1));
        int startMonth = Integer.parseInt(startDay.substring(0, index2));
        int endMonth = Integer.parseInt(endDay.substring(0, index1));
        if (start > end) {
        	JOptionPane.showMessageDialog(null, "Invalid start day and end day",
				"Add failed" , JOptionPane.WARNING_MESSAGE);
        } else if (start == end && startMonth > endMonth) {
        	JOptionPane.showMessageDialog(null, "Invalid start day and end day",
    				"Add failed" , JOptionPane.WARNING_MESSAGE);
        } else {
        	EmploymentData empData;
        	
    		empData = new EmploymentData(sid, company, position, posDescription, skillUsed,
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
	}

	/**
	 * Listen to the cell changes on the myTable.
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        if (columnName.matches("name") ||
                columnName.matches("sid") ||
                columnName.matches("startDay") ||
                columnName.matches("endDay") ||
                columnName.matches("type")) {

            JOptionPane.showMessageDialog(null,
                    "Update failed, "+ columnName +" CANNOT BE EDITED!!!");
        } else if (data != null && ((String) data).length() != 0) {
            EmploymentData employment = myList.get(row);
            if (!myEmploymentDB.updateEmployment(employment, columnName, data)) {
                JOptionPane.showMessageDialog(null,
                        "Update failed, Please check your input!");
            }
        }
	}
}