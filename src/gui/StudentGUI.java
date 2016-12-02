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
import javax.swing.table.TableModel;

import student.Student;
import student.StudentCollection;


/**
 * This class creates the GUI for Adding and Editing Student's Data
 * @author Loc Bui
 *
 */
public class StudentGUI extends JPanel implements ActionListener,
		TableModelListener {
	protected static final int WIDTH = 1100;
	protected static final int HEIGHT = 550;
	private static final long serialVersionUID = -7520370128176444786L;
	
	private JButton myBtnList, myBtnSearch, myBtnAdd, myAddBtn, mySearchBtn;
	private JPanel myPnlButtons, myPnlAdd, myPnlContent;
	private JLabel[] myTxfLabel = new JLabel[4];
	private JTextField[] myTxfField = new JTextField[4];
	private Object[][] myData;
	private JTable myTable;
	private JScrollPane myScrollPane;
	private String[] myColumnNames = { "name", "sid", "major",
			"graduationterm", "degree", "year", "gpa", "email" };
	private List<Student> myList;
	private JPanel myPnlSearch;
	private JComboBox<String> myTermComboBox, myYearComboBox, myMajorComboBox, myDegreeComboBox;
	private JTextField myTxfTitle;
	private JLabel mylblTitle;;

	/**
	 * This constructor calls the method to create all of the components
	 */
	public StudentGUI() {
		setLayout(new BorderLayout());
		myList = getData(null);
		createComponents();
		setVisible(true);
	}
	
	/**
	 * Retrieve the list of student to display
	 * @param searchKey the key to search for a student.
	 * @return list of student
	 */
	private List<Student> getData(String searchKey) {
		if (searchKey != null) {
			myList = StudentCollection.search(searchKey);
		} else {
			myList = StudentCollection.showAll();
		}

		if (myList != null) {
			myData = new Object[myList.size()][myColumnNames.length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getName();
				myData[i][1] = myList.get(i).getID();
				myData[i][2] = myList.get(i).getMajor();
				myData[i][3] = myList.get(i).getTerm();
				myData[i][4] = myList.get(i).getDegree();
				myData[i][5] = myList.get(i).getYear();
				myData[i][6] = myList.get(i).getGPA();
				myData[i][7] = myList.get(i).getEmail();
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
		myBtnList = new JButton("Student List");
		myBtnList.addActionListener(this);

		myBtnSearch = new JButton("Student Search");
		myBtnSearch.addActionListener(this);

		myBtnAdd = new JButton("Add Student");
		myBtnAdd.addActionListener(this);
		
		myPnlButtons.add(myBtnList);
		myPnlButtons.add(myBtnSearch);
		myPnlButtons.add(myBtnAdd);
		
		addListPanel();
		
		myPnlSearch = new JPanel();
		mylblTitle = new JLabel("Enter Name: ");
		myTxfTitle = new JTextField(25);
		mySearchBtn = new JButton("Search");
		mySearchBtn.addActionListener(this);
		myPnlSearch.add(mylblTitle);
		myPnlSearch.add(myTxfTitle);
		myPnlSearch.add(mySearchBtn);
		
		add(myPnlButtons, BorderLayout.NORTH);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	/**
	 * Create the list panel for displaying the list of student information.
	 */
	public void addListPanel() {
		// List Panel
		myPnlContent = new JPanel();
		myTable = new JTable(myData, myColumnNames);
		myScrollPane = new JScrollPane(myTable);
		myScrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		myPnlContent.add(myScrollPane);
		myTable.getModel().addTableModelListener(this);
	}
	
	/**
	 * Create the add panel for adding a student information.
	 */
	public void addPanel() {
		// Add Panel
		myPnlAdd = new JPanel();
		myPnlAdd.setLayout(new GridLayout(9, 0));
		String labelNames[] = { "Name (First Last): * ", "SID: * ", "GPA: * ", "Email: * "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0));
			myTxfLabel[i] = new JLabel(labelNames[i]);
			myTxfField[i] = new JTextField(25);
			panel.add(myTxfLabel[i]);
			panel.add(myTxfField[i]);
			myPnlAdd.add(panel);
		}
		
		JPanel comboPanel1 = new JPanel();
		comboPanel1.setLayout(new GridLayout(1, 0));
		
		String[] majors = {"CSS", "CES", "IT"};
		myMajorComboBox = new JComboBox<String>(majors);
		myMajorComboBox.setSelectedIndex(0);
		comboPanel1.add(new JLabel("Choose Major: * "));
		comboPanel1.add(myMajorComboBox);
        myPnlAdd.add(comboPanel1);

        JPanel comboPanel2 = new JPanel();
        comboPanel2.setLayout(new GridLayout(1, 0));
		String[] degrees = {"Bachelor of Science", "Bachelor of Arts", "Master of Science"};
		myDegreeComboBox = new JComboBox<String>(degrees);
		myDegreeComboBox.setSelectedIndex(0);
        comboPanel2.add(new JLabel("Choose Degree: * "));
        comboPanel2.add(myDegreeComboBox);
        myPnlAdd.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 0));
		String[] terms = {"Spring", "Summer", "Fall", "Winter"};
		myTermComboBox = new JComboBox<String>(terms);
		myTermComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("Graduation Term: * "));
        comboPanel3.add(myTermComboBox);
        myPnlAdd.add(comboPanel3);

        JPanel comboPanel4 = new JPanel();
        comboPanel4.setLayout(new GridLayout(1, 0));
		String[] years = {"2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", 
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		myYearComboBox = new JComboBox<String>(years);
		myYearComboBox.setSelectedIndex(0);
        comboPanel4.add(new JLabel("Graduation Year: * "));
        comboPanel4.add(myYearComboBox);
        myPnlAdd.add(comboPanel4);
		
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
			myTable = new JTable(myData, myColumnNames);
			myTable.getModel().addTableModelListener(this);
			myScrollPane = new JScrollPane(myTable);
			myScrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			myPnlContent.add(myScrollPane);
			myPnlContent.revalidate();
			myPnlContent.setVisible(true);
			this.repaint();
		} else if (e.getSource() == myBtnSearch) {
			myPnlContent.removeAll();
			myPnlContent.add(myPnlSearch);
			myPnlContent.revalidate();
			this.repaint();
		} else if (e.getSource() == mySearchBtn) {
			String title = myTxfTitle.getText();
			if (title.length() > 0) {
				myList = getData(title);
				myPnlContent.removeAll();
				myTable = new JTable(myData, myColumnNames);
				myTable.getModel().addTableModelListener(this);
				myScrollPane = new JScrollPane(myTable);
				myScrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				myPnlContent.add(myScrollPane);
				myPnlContent.revalidate();
				this.repaint();
				myTxfTitle.setText("");
			}
		}
	}

	/**
	 * Perform adding a student's data.
	 */
	private void performAddStudent() {
		String name = myTxfField[0].getText();
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Student Name (First Last)");
			myTxfField[0].setFocusable(true);
			return;
		}
		String sid = myTxfField[1].getText();
		if (sid.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter SID");
			myTxfField[1].setFocusable(true);
			return;
		}
		String major = (String) myMajorComboBox.getSelectedItem();
		
		String degree = (String) myDegreeComboBox.getSelectedItem();
		
		String gpaStr = myTxfField[2].getText();
		double gpa = 0.0;
		
		if (gpaStr.length() != 0) {
			try {
				gpa = Double.parseDouble(gpaStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter GPA as decimal");
				myTxfField[2].setFocusable(true);
				return;
			}
		}
		
		String email = myTxfField[3].getText();
		if (email.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter email");
			myTxfField[3].setFocusable(true);
			return;
		}

		String gradTerm = (String) myTermComboBox.getSelectedItem();
		String year = (String) myYearComboBox.getSelectedItem();
		
    	if (name.length() < 3 || sid.length() < 3 || gpa < 0.0 || gpa > 4.0 || email.length() < 3) {
        	JOptionPane.showMessageDialog(null, "Invalid input! Please check again",
    				"Add failed" , JOptionPane.WARNING_MESSAGE);
    	} else {
    		Student student = new Student(name, sid, major, gradTerm, degree, year, gpa, email);

//    		String message = "Student add failed";
    		String message = null;
    		if (StudentCollection.addStudent(student)) {
    			message = "Student added successfully!\nNow you can add the employment information"
    				+ " for this student in the \nAdd or Update Student's Employment Information tab.";
        		JOptionPane.showMessageDialog(null, message);
        		
        		// Clear all text fields.
        		for (int i = 0; i < myTxfField.length; i++) {
        			if (myTxfField[i].getText().length() != 0) {
        				myTxfField[i].setText("");
        			}
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
        if (!columnName.matches("email")) {
            JOptionPane.showMessageDialog(null,
                    "Update failed, "+ columnName +" CANNOT BE EDITED!!!");
        } else if (data != null && ((String) data).length() != 0) {
            Student student = myList.get(row);
            if (!StudentCollection.updateStudent(student, columnName, data)) {
                JOptionPane.showMessageDialog(null,
                        "Update failed, Please check your input!");
            }
        }
	}

}