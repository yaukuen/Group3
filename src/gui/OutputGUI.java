package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import data.EmploymentDB;
import student.OutPut;
import student.StudentCollection;

/**
 * This class creates the GUI for generating outputs 
 * based on the criterion that the user has chosen to view by.
 * @author Loc Bui
 *
 */
public class OutputGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7655286335054538989L;
	private static final int TABLE_WIDTH = 1100;
	private static final int TABLE_HEIGHT = 550;
	private JButton myBtnSearch;
	private JComboBox<String> myComboBox;
	private JPanel myComboBoxPnl, myPnlContent;
	private List<OutPut> myList;
	private String[] myComboBoxValues = {"GPA", "Salary", "Major - CSS", "Major - CES", "Major - IT",
			"Degree - BA", "Degree - BS", "Degree - MS", "Internship", "Job"};

	private String[] myColumnNames = { "name", "sid", "gpa",
			"major", "degree", "salary", "company", "position", "type" };
	private Object[][] myData;
	private JTable myTable;
	private JScrollPane myScrollPane;
	public static final int GPA = 1;
	public static final int SALARY = 2;

	/**
	 * The constructor to call the method to create all of the components
	 * @throws SQLException 
	 */
	public OutputGUI() throws SQLException {
		setLayout(new BorderLayout());
		createComponents();
		setVisible(true);
	}
	
    private List<OutPut> getData(int number) {
        if (number == 1) {
        	myList = StudentCollection.searchByGPA();
            myData = new Object[myList.size()][myColumnNames.length];
        } else if (number == 2) {
        	myList = StudentCollection.searchBySalary();
            myData = new Object[myList.size()][myColumnNames.length];
        }
	    if (myList != null) {
	        for (int i = 0; i < myList.size(); i++) {
	            myData[i][0] = myList.get(i).getMyStdName();
                myData[i][1] = myList.get(i).getMyStdID();
                myData[i][2] = myList.get(i).getMyGPA();
                myData[i][3] = myList.get(i).getMyStdMajor();
                myData[i][4] = myList.get(i).getMyDegree();
                myData[i][5] = myList.get(i).getMySalary();
                myData[i][6] = myList.get(i).getMyCompany();
                myData[i][7] = myList.get(i).getMyPosition();
                myData[i][8] = myList.get(i).getMyType();
            }
        }
        return myList;
    }
	
	public List<OutPut> getInternshipData() throws SQLException {
		myList = EmploymentDB.getInternship();

		if (myList != null) {
			myData = new Object[myList.size()][myColumnNames.length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getMyStdName();
				myData[i][1] = myList.get(i).getMyStdID();
				myData[i][2] = myList.get(i).getMyGPA();
				myData[i][3] = myList.get(i).getMyStdMajor();
				myData[i][4] = myList.get(i).getMyDegree();
				myData[i][5] = myList.get(i).getMySalary();
				myData[i][6] = myList.get(i).getMyCompany();
				myData[i][7] = myList.get(i).getMyPosition();
				myData[i][8] = myList.get(i).getMyType();
			}
		}

		return myList;
	}
	
	public List<OutPut> getJobData() throws SQLException {
		myList = EmploymentDB.getJob();

		if (myList != null) {
			myData = new Object[myList.size()][myColumnNames.length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getMyStdName();
				myData[i][1] = myList.get(i).getMyStdID();
				myData[i][2] = myList.get(i).getMyGPA();
				myData[i][3] = myList.get(i).getMyStdMajor();
				myData[i][4] = myList.get(i).getMyDegree();
				myData[i][5] = myList.get(i).getMySalary();
				myData[i][6] = myList.get(i).getMyCompany();
				myData[i][7] = myList.get(i).getMyPosition();
				myData[i][8] = myList.get(i).getMyType();
			}
		}

		return myList;
	}
	
	public List<OutPut> getMajor(String theSearch) throws SQLException {
		myList = EmploymentDB.getMajor(theSearch);

		if (myList != null) {
			myData = new Object[myList.size()][myColumnNames.length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getMyStdName();
				myData[i][1] = myList.get(i).getMyStdID();
				myData[i][2] = myList.get(i).getMyGPA();
				myData[i][3] = myList.get(i).getMyStdMajor();
				myData[i][4] = myList.get(i).getMyDegree();
				myData[i][5] = myList.get(i).getMySalary();
				myData[i][6] = myList.get(i).getMyCompany();
				myData[i][7] = myList.get(i).getMyPosition();
				myData[i][8] = myList.get(i).getMyType();
			}
		}
		return myList;
	}
	
	public List<OutPut> getDegree(String theSearch) throws SQLException {
		myList = EmploymentDB.getMajor(theSearch);

		if (myList != null) {
			myData = new Object[myList.size()][myColumnNames.length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getMyStdName();
				myData[i][1] = myList.get(i).getMyStdID();
				myData[i][2] = myList.get(i).getMyGPA();
				myData[i][3] = myList.get(i).getMyStdMajor();
				myData[i][4] = myList.get(i).getMyDegree();
				myData[i][5] = myList.get(i).getMySalary();
				myData[i][6] = myList.get(i).getMyCompany();
				myData[i][7] = myList.get(i).getMyPosition();
				myData[i][8] = myList.get(i).getMyType();
			}
		}
		return myList;
	}
	
	
	
	/**
	 * This method creates the panel for generating outputs.
	 */
	private void createComponents() {
		myPnlContent = new JPanel();
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
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	public void changeTable() {
		myPnlContent.removeAll();
		myTable = new JTable(myData, myColumnNames);
		myScrollPane = new JScrollPane(myTable);
		myScrollPane.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		myPnlContent.add(myScrollPane);
		myPnlContent.revalidate();
		myPnlContent.setVisible(true);
		this.repaint();
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnSearch) {
            if (myComboBox.getSelectedItem().equals("GPA")) {
                myList = getData(GPA);
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Salary")) {
                myList = getData(SALARY);
                changeTable();
            } else if (myComboBox.getSelectedItem().equals("Internship")) {
				try {
					myList = getInternshipData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Job")) {
				try {
					myList = getJobData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Major - CSS")) {
				try {
					myList = getMajor("CSS");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Major - CES")) {
				try {
					myList = getMajor("CES");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Major - IT")) {
				try {
					myList = getMajor("IT");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Degree - BA")) {
				try {
					myList = getMajor("Bachelor of Arts");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Degree - BS")) {
				try {
					myList = getMajor("Bachelor of Science");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} else if (myComboBox.getSelectedItem().equals("Degree - MS")) {
				try {
					myList = getMajor("Master of Science");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				changeTable();
			} 
		}
	}
}