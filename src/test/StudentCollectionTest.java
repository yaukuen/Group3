package test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import student.OutPut;
import student.Student;
import student.StudentCollection;

/**
 * Test class for the StudentCollection class.
 * @author Nico Tandyo
 *
 */
public class StudentCollectionTest {

    private Student mInitialStudent;
    private String mName = "InitTest";
	private String mMajor = "CSS";
	private String mTerm = "Spring";
	private String mDegree = "Bachelor of Science";
	private String mYear = "2016";
	private double mGPA = 3.5;
	private String mEmail = "anon@test.com";
	
	/**
	 * Set up the student.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Random rd = new Random();
		int number = rd.nextInt(999999);
		String sid = "" + number;
//		String sidStr = Integer.parseInt(sid);
		mInitialStudent = new Student(mName, sid, mMajor, mTerm, mDegree, mYear, mGPA, mEmail);
	}
	/**
	 * Test searchByMajor.
	 */
	@Test
	public void testSearchByMajor() {
		List<Student> filteredStudent = StudentCollection.search(mMajor);
		
		boolean found = true;
		for (Student std : filteredStudent){
			if (std.getMajor().equals(mMajor)){
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
	/**
	 * Test searchByDegree.
	 */
	@Test
	public void testSearchByDegree() {
		List<Student> filteredStudent = StudentCollection.search(mDegree);
		
		boolean found = true;
		for (Student std : filteredStudent){
			if (std.getDegree().equals(mDegree)){
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
	/**
	 * Test for the addStudent method using random student ID so there will be no duplicates.
	 */
	@Test
	public void testAddSuccess() {
		boolean successfullAdd = StudentCollection.addStudent(mInitialStudent);
		assertTrue(successfullAdd);
	}

	/**
	 * Testing showing all student.
	 */
	@Test
	public void testShowAll() {
		List<Student> studentList = StudentCollection.showAll();
		int result = studentList.size();
		assertNotEquals(0, result);
	}

    /**
     * Testing search by GPA.
     */
	@Test
	public void testSearchbyGPA() {
	    List<OutPut> gpaOutput = StudentCollection.searchByGPA();
        int result = gpaOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing search by Salary.
     */
    @Test
    public void testSearchbySalary() {
        List<OutPut> salaryOutput = StudentCollection.searchBySalary();
        int result = salaryOutput.size();
        assertNotEquals(0, result);
    }

    /**
     * Testing update a student's email.
     */
    @Test
    public void testUpdateStudent() {
        mInitialStudent.setID("123456");
        Random rd = new Random();
        int number = rd.nextInt(999999);
        String email = number + "@uw.edu";
        boolean result = StudentCollection.updateStudent(mInitialStudent, "email", email);
        assertTrue(result);
    }
}