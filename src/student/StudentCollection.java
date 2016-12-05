package student;

import data.StudentDB;
import gui.OutputGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for the collection of students.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 * @author Loc Bui
 */
public class StudentCollection {

    /**
     * Connect to Student database.
     */
    private static StudentDB myStudentDB;

    /**
     * Return a list of students with the matching name.
     *
     * @param theName client to look for.
     * @return a list of clients that match.
     */
    public static List<Student> search(final String theName) {
        List<Student> list = new ArrayList<>();
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }
        try {
            return myStudentDB.getStudents(theName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Return a list of students with the matching GPA.
     *
     * @return a list of students with matching GPA
     */
    public static List<Output> searchByGPA() {
        List<Output> list = new ArrayList<>();
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }
        try {
            return myStudentDB.getOutput(OutputGUI.GPA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Return a list of students with the matching salary.
     *
     * @return a list of students with matching salary
     */
    public static List<Output> searchBySalary() {
        List<Output> list = new ArrayList<>();
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }
        try {
            return myStudentDB.getOutput(OutputGUI.SALARY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	/**
	 * Return a list of students with the matching major or degree.
	 * @param theName of the major or degree.
	 * @return a list of students with matching major.
	 */
	public static List<Output> searchByMajorOrDegree(final String theName) {
		List<Output> list = new ArrayList<>();
		if (myStudentDB == null) {
			myStudentDB = new StudentDB();
		}
		try {
				return StudentDB.searchByMajorOrDegree(theName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Return a list of students with the matching intern.
     * @return a list of students with matching intern
	 */
	public static List<Output> searchByInternship() {
		List<Output> list = new ArrayList<>();
		if (myStudentDB == null) {
			myStudentDB = new StudentDB();
		}
		try {
            return StudentDB.searchByInternship();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return a list of students with the matching job.
	 * @return a list of students with matching intern
	 */
	public static List<Output> searchByJob() {
		List<Output> list = new ArrayList<>();
		if (myStudentDB == null) {
			myStudentDB = new StudentDB();
		}
		try {
				return StudentDB.searchByJob();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

    /**
     * Modify the particular column of the student with the given data can only modify email.
     *
     * @param theStudent student to modify.
     * @param theColumn  the field in the table to modify.
     * @param theData    the value for the field.
     * @return true or false.
     */
    public static boolean updateStudent(final Student theStudent,
                                        final String theColumn, final Object theData) {
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }
        String message = myStudentDB.updateStudent(theStudent, theColumn, theData);
        return !message.startsWith("Error updating student: ");
    }

    /**
     * Adds a new client to the data.
     *
     * @param theStudent that contains all student's information.
     * @return true or false.
     */
    public static boolean addStudent(final Student theStudent) {
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }

        String message = myStudentDB.addStudent(theStudent);
        return !message.startsWith("Error adding student:");
    }

    /**
     * Return all students in the list, null otherwise.
     *
     * @return a list of students
     */
    public static List<Student> showAll() {
        if (myStudentDB == null) {
            myStudentDB = new StudentDB();
        }
        try {
            return myStudentDB.getStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}