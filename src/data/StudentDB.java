package data;

import student.EmploymentData;
import student.OutPut;
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
    private List<OutPut> myOutPutList;

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
			if (std.getID().toLowerCase().contains(theSearch)) {
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
		for (Student std : mStudentList) {
			if (std.getEmail().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		return filterList;
	}

    public List<OutPut> getOutputs(int number) throws SQLException {
        if (mConnection == null) {
            mConnection = DataConnection.getConnection();
        }
        String query = null;
        Statement stmt = null;
        if (number == 1) {
            query = "Select Student.name, Student.sid, Student.gpa, Student.major, Student.degree,\n" +
                    "Employment.salary, Employment.company, Employment.position, Employment.type\n" +
                    "from Student Join Employment\n" +
                    "on Student.sid = Employment.sid\n" +
                    "order by Student.gpa desc;";
        } else if (number == 2) {
            query = "Select Student.name, Student.sid, Student.gpa, Student.major, Student.degree,\n" +
                    "Employment.salary, Employment.company, Employment.position, Employment.type\n" +
                    "from Student Join Employment\n" +
                    "on Student.sid = Employment.sid\n" +
                    "order by Employment.salary desc;";
        }
        myOutPutList = new ArrayList<OutPut>();
        try {
            stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                double gpa = rs.getDouble("gpa");
                String major = rs.getString("major");
                String deg = rs.getString("degree");
                int salary = rs.getInt("salary");
                String company = rs.getString("company");
                String pos = rs.getString("position");
                String type = rs.getString("type");
                OutPut output = null;
                output = new OutPut(name, sid, gpa, major, deg, salary, company, pos, type);
                myOutPutList.add(output);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myOutPutList;
    }

    /**
     * Returns all students that contain the same GPA as the search keyword.
     * @return list of student that match
     * @throws SQLException
     */
    public List<OutPut> getOutput(int number) throws SQLException {
    	getOutputs(number);
        return myOutPutList;
    }

	/**
	 * Returns all students that contain the same major as the search keyword.
	 * @param theSearch
	 * @return list of student that match
	 * @throws SQLException
	 */
	public List<Student> getStudentsMajor(String theSearch) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		for(Student std: mStudentList) {
			if(std.getDegree().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		return filterList;
	}
	/**
	 * Returns all students that contain the same degree as the search keyword.
	 * @param theSearch
	 * @return list of student that match
	 * @throws SQLException
	 */
	public List<Student> getStudentsDegree(String theSearch) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		for (Student std : mStudentList) {
			if (std.getMajor().toLowerCase().contains(theSearch)) {
				filterList.add(std);
			}
		}
		return filterList;
	}
	/**
	 * Returns all students that contain the same job as the search keyword.
	 * @param theSearch
	 * @return list of student that match
	 * @throws SQLException
	 */
	public List<Student> getStudentsJob(String theSearch) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		
		for (Student std : mStudentList) {
			for(EmploymentData ed : std.getJobList()) {
				if(ed.getCompany().toLowerCase().contains(theSearch)) {
					filterList.add(std);
				}
			}
		}
		return filterList;
	}
	/**
	 * Returns all students that contain the same intern as the search keyword.
	 * @param theSearch
	 * @return list of student that match
	 * @throws SQLException
	 */
	public List<Student> getStudentsIntern(String theSearch) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		
		for (Student std : mStudentList) {
			for(EmploymentData ed : std.getInternList()) {
				if(ed.getCompany().toLowerCase().contains(theSearch)) {
					filterList.add(std);
				}
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
		String sql = "insert into Student(`name`,`sid`,`major`,`gradTerm`,"
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
			preparedStatement.setString(2, theStudent.getID());
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
	 * @param theStudent
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