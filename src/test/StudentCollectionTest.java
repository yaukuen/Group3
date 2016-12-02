package test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

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
		int sid = rd.nextInt(999999);
		String sidStr = Integer.toString(sid);
		mInitialStudent = new Student(mName, sidStr, mMajor, mTerm, mDegree, mYear, mGPA, mEmail);
		StudentCollection.addStudent(mInitialStudent);
	}
	/**
	 * Test searchByMajor.
	 */
	@Test
	public void testSearchByMajor() {
		List<Student> filteredStudent = StudentCollection.searchByMajor(mMajor);
		
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
		List<Student> filteredStudent = StudentCollection.searchByDegree(mDegree);
		
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
		Random rd = new Random();
		int sid = rd.nextInt(999999);
		String sidStr = Integer.toString(sid);
		Student addedStudent = new Student("NameTest", sidStr, "Computer Science", "Autumn", "Bachelor of Science"
				, "2018", 3.9, "name@uw.edu");
				
		boolean successfullAdd = StudentCollection.addStudent(addedStudent);
		assertTrue(successfullAdd);
	}
}