package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import student.Student;
/**
 * Test for the Student class.
 * @author Nico Tandyo
 */
public class StudentTest {
	
	private String mName = "Test";
	private String mID = "123456";
	private String mMajor = "Computer Science";
	private String mTerm = "Summer";
	private String mDegree = "Bachelor of Science";
	private String mYear = "2016";
	private double mGPA = 3.7;
	private String mEmail = "anon@yahoo.com";
	private Student mStudent;
	
	/**
	 * Set up the student.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mStudent = new Student(mName, mID, mMajor, mTerm, mDegree, mYear, mGPA, mEmail);
	}
	/**
	 * Test setName and getName.
	 */
	@Test
	public void testSetGetName() {
		String test = "SetTest";
		mStudent.setName(test);
		assertEquals(mStudent.getName(), test);
	}
	/**
	 * Test setID and getID.
	 */
	@Test
	public void testSetGetID() {
		String test = "setID";
		mStudent.setID(test);
		assertEquals(mStudent.getID(), test);
	}
	@Test
	/**
	 * Test setMajor and getMajor.
	 */
	public void testSetGetMajor() {
		String test = "setMajor";
		mStudent.setMajor(test);
		assertEquals(mStudent.getMajor(), test);
	}
	/**
	 * Test setEmail and getEmail.
	 */
	@Test
	public void testSetGetEmail() {
		String test = "setMajor";
		mStudent.setEmail(test);
        assertEquals(mStudent.getEmail(), test);
	}
	/**
	 * Test the getGPA.
	 */
	@Test
	public void testGetGPA() {
		assertEquals(mStudent.getGPA(), mGPA, 0.1);
		
	}
	/**
	 * Test the getTerm.
	 */
	@Test
	public void testGetTerm() {
		assertEquals(mStudent.getTerm(), mTerm);
	}
	/**
	 * Test the getYear.
	 */
	@Test
	public void testGetYear() {
		assertEquals(mStudent.getYear(), mYear);
	}
	/**
	 * Test the getDegree.
	 */
	@Test
	public void testGetDegree() {
		assertEquals(mStudent.getDegree(), mDegree);
	}
}