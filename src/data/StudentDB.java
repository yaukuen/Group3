package data;

import student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains methods to access the student tables data.
 * @author Nico Tandyo
 *
 */
public class StudentDB {
	private Connection mConnection;
    private List<Student> mStudentList;
    
    /**
	 * Retrieves all students from the Student table.
	 * 
	 * @return list of students
	 * @throws SQLException
	 */
	public List<Student> getStudents() throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from Student ";

		mStudentList = new ArrayList<Student>();
		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String sid = rs.getString("sid");
				String major = rs.getString("major");
				String term = rs.getString("gradTerm");
				String deg = rs.getString("degree");
				String year = rs.getString("year");
				double gpa = rs.getDouble("gpa");
				String email = rs.getString("email");
				Student student = null;
				student = new Student(name, sid, major, term, deg, year, gpa, email);
				mStudentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return mStudentList;
	}
	/**
	 * Returns all students that contain the search keyword in the name or description. 
	 * @param theSearch search name
	 * @return list of student that match
	 * @throws SQLException
	 */
	public List<Student> getStudents(String theSearch) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		theSearch = theSearch.toLowerCase();
		for (Student std : mStudentList) {
			if (std.getName().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		for (Student std : mStudentList) {
			if (std.getId().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		for (Student std : mStudentList) {
			if (std.getMajor().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		for (Student std : mStudentList) {
			if (std.getTerm().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		for(Student std: mStudentList) {
			if(std.getDegree().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		for (Student std : mStudentList) {
			if (std.getYear().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		//TODO search by gpa?
		for (Student std : mStudentList) {
			if (std.getEmail().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		return filterList;
	}

	/**
	 * Retrieve the student with the given id or null if not found.
	 * @param theId id
	 * @return student
	 * @throws SQLException
	 */
	public Student getStudent(String theId) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from Student where sid = " + theId;

		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				String name = rs.getString("name");
				String sid = rs.getString("sid");
				String major = rs.getString("major");
				String term = rs.getString("gradTerm");
				String deg = rs.getString("degree");
				String year = rs.getString("year");
				double gpa = rs.getDouble("gpa");
				String email = rs.getString("email");
				return new Student(name, sid, major, term, deg, year, gpa, email);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}

	/**
	 * Adds a new student to the Student table. 
	 * @param theStudent student
	 * @return Returns "Added Student Successfully" or "Error adding student: " with the sql exception.
	 */
	public String addStudent(Student theStudent) {
		String sql = "insert into Client(`name`,`sid`,`major`,`gradTerm`,"
				+ "`degree`,`year`,`gpa`, `email`) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?); ";

		if (mConnection == null) {
			try {
				mConnection = DataConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			preparedStatement.setString(1, theStudent.getName());
			preparedStatement.setString(2, theStudent.getId());
			preparedStatement.setString(3, theStudent.getMajor());
			preparedStatement.setString(4, theStudent.getTerm());
			preparedStatement.setString(5, theStudent.getDegree());
			preparedStatement.setString(6, theStudent.getYear());
			preparedStatement.setDouble(7, theStudent.getGPA());
			preparedStatement.setString(8, theStudent.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding student: " + e.getMessage();
		}
		return "Added Student Successfully";
	}

	/**
	 * Modifies the data on a Student - only email can be changed
	 * @param row
	 * @param theCol
	 * @param theData
	 * @return Returns a message with success or failure.
	 */
	public String updateStudent(Student theStudent, String theCol, Object theData) {
		
		String email = theStudent.getEmail();
		String sql = "update Student set `" + theCol
				+ "` = ?  where email= ?";
		// For debugging - System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			if (theData instanceof String)
				preparedStatement.setString(1, (String) theData); 
			else if (theData instanceof Double)
				preparedStatement.setDouble(1, (Double) theData);
			preparedStatement.setString(2, email);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return "Error updating student: " + e.getMessage();
		}
		return "Updated Student Successfully";
	
	}

}
