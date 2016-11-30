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

import student.Student;
import student.StudentCollection;


/**
 * This class creates the GUI for Adding and Editing Student's Data
 * @author Loc Bui
 *
 */
public class StudentGUI extends JPanel implements ActionListener,
		TableModelListener {
	
	private static final int TABLE_WIDTH = 1100;
	private static final int TABLE_HEIGHT = 550;
	private static final long serialVersionUID = -7520370128176444786L;
	
	private JButton myBtnList, myBtnSearch, myBtnAdd, myAddBtn, mySearchBtn;
	private JPanel myPnlButtons, myPnlAdd, myPnlContent;
	private JLabel[] txfLabel = new JLabel[4];
	private JTextField[] txfField = new JTextField[4];
	private Object[][] mData;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] mItemColumnNames = { "name", "sid", "major",
			"graduationterm", "degree", "year", "gpa", "email" };
	private List<Student> mList;
	private JPanel pnlSearch;
	private JComboBox<String> myTermComboBox, myYearComboBox, myMajorComboBox, myDegreeComboBox;
	private JTextField myTxfTitle;
	private JLabel lblTitle;;

	/**
	 * This constructor calls the method to create all of the components
	 */
	public StudentGUI() {
		setLayout(new BorderLayout());
		mList = getData(null);
		createComponents();
		setVisible(true);
	}
	
	private List<Student> getData(String searchKey) {
		if (searchKey != null) {
			mList = StudentCollection.search(searchKey);
		} else {
			mList = StudentCollection.showAll();
		}

		if (mList != null) {
			mData = new Object[mList.size()][mItemColumnNames.length];
			for (int i = 0; i < mList.size(); i++) {
				mData[i][0] = mList.get(i).getName();
				mData[i][1] = mList.get(i).getID();
				mData[i][2] = mList.get(i).getMajor();
				mData[i][3] = mList.get(i).getTerm();
				mData[i][4] = mList.get(i).getDegree();
				mData[i][5] = mList.get(i).getYear();
				mData[i][6] = mList.get(i).getGPA();
				mData[i][7] = mList.get(i).getEmail();
			}
		}

		return mList;
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
		
		pnlSearch = new JPanel();
		lblTitle = new JLabel("Enter Name: ");
		myTxfTitle = new JTextField(25);
		mySearchBtn = new JButton("Search");
		mySearchBtn.addActionListener(this);
		pnlSearch.add(lblTitle);
		pnlSearch.add(myTxfTitle);
		pnlSearch.add(mySearchBtn);
		
		add(myPnlButtons, BorderLayout.NORTH);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	public void addListPanel() {
		// List Panel
		myPnlContent = new JPanel();
		table = new JTable(mData, mItemColumnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		myPnlContent.add(scrollPane);
		table.getModel().addTableModelListener(this);
	}
	
	public void addPanel() {
		// Add Panel
		myPnlAdd = new JPanel();
		myPnlAdd.setLayout(new GridLayout(9, 0));
		String labelNames[] = { "Name (First Last):", "SID: ", "GPA: ", "Email: "};
		for (int i = 0; i < labelNames.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0));
			txfLabel[i] = new JLabel(labelNames[i]);
			txfField[i] = new JTextField(25);
			panel.add(txfLabel[i]);
			panel.add(txfField[i]);
			myPnlAdd.add(panel);
		}
		
		JPanel comboPanel1 = new JPanel();
		comboPanel1.setLayout(new GridLayout(1, 0));
		
		String[] majors = {"CSS", "CES", "IT"};
		myMajorComboBox = new JComboBox<String>(majors);
		myMajorComboBox.setSelectedIndex(0);
		comboPanel1.add(new JLabel("Choose Major: "));
		comboPanel1.add(myMajorComboBox);
        myPnlAdd.add(comboPanel1);

        JPanel comboPanel2 = new JPanel();
        comboPanel2.setLayout(new GridLayout(1, 0));
		String[] degrees = {"Bachelor of Science", "Bachelor of Arts", "Master of Science"};
		myDegreeComboBox = new JComboBox<String>(degrees);
		myDegreeComboBox.setSelectedIndex(0);
        comboPanel2.add(new JLabel("Choose Degree: "));
        comboPanel2.add(myDegreeComboBox);
        myPnlAdd.add(comboPanel2);

        JPanel comboPanel3 = new JPanel();
        comboPanel3.setLayout(new GridLayout(1, 0));
		String[] terms = {"Spring", "Summer", "Fall", "Winter"};
		myTermComboBox = new JComboBox<String>(terms);
		myTermComboBox.setSelectedIndex(0);
        comboPanel3.add(new JLabel("Graduation Term: "));
        comboPanel3.add(myTermComboBox);
        myPnlAdd.add(comboPanel3);

        JPanel comboPanel4 = new JPanel();
        comboPanel4.setLayout(new GridLayout(1, 0));
		String[] years = {"2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", 
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		myYearComboBox = new JComboBox<String>(years);
		myYearComboBox.setSelectedIndex(0);
        comboPanel4.add(new JLabel("Graduation Year: "));
        comboPanel4.add(myYearComboBox);
        myPnlAdd.add(comboPanel4);
		
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
		} else if (e.getSource() == myBtnList) {
			mList = getData(null);
			myPnlContent.removeAll();
			table = new JTable(mData, mItemColumnNames);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
			myPnlContent.add(scrollPane);
			myPnlContent.revalidate();
			myPnlContent.setVisible(true);
			this.repaint();
		} else if (e.getSource() == myBtnSearch) {
			myPnlContent.removeAll();
			myPnlContent.add(pnlSearch);
			myPnlContent.revalidate();
			this.repaint();
		} else if (e.getSource() == mySearchBtn) {
			String title = myTxfTitle.getText();
			if (title.length() > 0) {
				mList = getData(title);
				myPnlContent.removeAll();
				table = new JTable(mData, mItemColumnNames);
				table.getModel().addTableModelListener(this);
				scrollPane = new JScrollPane(table);
				scrollPane.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
				myPnlContent.add(scrollPane);
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
		String name = txfField[0].getText();
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Student Name (First Last)");
			txfField[0].setFocusable(true);
			return;
		}
		String sid = txfField[1].getText();
		if (sid.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter SID");
			txfField[1].setFocusable(true);
			return;
		}
		String major = (String) myMajorComboBox.getSelectedItem();
		
		String degree = (String) myDegreeComboBox.getSelectedItem();
		
		String gpaStr = txfField[2].getText();
		double gpa = 0.0;
		
		if (gpaStr.length() != 0) {
			try {
				gpa = Double.parseDouble(gpaStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter GPA as decimal");
				txfField[2].setFocusable(true);
				return;
			}
		}
		
		String email = txfField[3].getText();
		if (email.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter email");
			txfField[3].setFocusable(true);
			return;
		}

		String gradTerm = (String) myTermComboBox.getSelectedItem();
		String year = (String) myYearComboBox.getSelectedItem();
		
		Student student = new Student(name, sid, major, gradTerm, degree, year, gpa, email);

		String message = "Student add failed";
		if (StudentCollection.addStudent(student)) {
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