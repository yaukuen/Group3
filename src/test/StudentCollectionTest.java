package test;
import static org.junit.Assert.*;

import java.util.List;

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
	private String mID = "123327";
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
		mInitialStudent = new Student(mName, mID, mMajor, mTerm, mDegree, mYear, mGPA, mEmail);
		StudentCollection.addStudent(mInitialStudent);
	}
	/**
	 * Test searchByGPA.
	 */
//	@Test
//	public void testSearchByGPA() {
//		List<Student> filteredStudent = StudentCollection.searchByGPA(mGPA);
//		
//		boolean found = false;
//		for (Student std : filteredStudent){
//			if (std.getGPA() == mGPA){
//				found = true;
//				break;
//			}
//		}
//		assertTrue(found);
//	}
//	/**
//	 * Test searchByMajor.
//	 */
//	@Test
//	public void testSearchByMajor() {
//		List<Student> filteredStudent = StudentCollection.searchByMajor(mMajor);
//		
//		boolean found = true;
//		for (Student std : filteredStudent){
//			if (std.getMajor().equals(mMajor)){
//				found = true;
//				break;
//			}
//		}
//		assertTrue(found);
//	}
//	/**
//	 * Test searchByDegree.
//	 */
//	@Test
//	public void testSearchByDegree() {
//		List<Student> filteredStudent = StudentCollection.searchByDegree(mDegree);
//		
//		boolean found = true;
//		for (Student std : filteredStudent){
//			if (std.getDegree().equals(mDegree)){
//				found = true;
//				break;
//			}
//		}
//		assertTrue(found);
//	}
	/**
	 * Test for the addStudent method. However, change the student ID to unique student ID
	 * every time you test it because ID must not be duplicate.
	 */
	@Test
	public void testAddSuccess() {
		Student addedStudent = new Student("NameTest", "098097", "Computer Science", "Autumn", "Bachelor of Science"
				, "2018", 3.9, "name@uw.edu");
				
		boolean successfullAdd = StudentCollection.addStudent(addedStudent);
		assertTrue(successfullAdd);
	}
}