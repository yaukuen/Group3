package test;

import org.junit.Before;
import org.junit.Test;
import student.Student;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Student class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class StudentTest {

    /**
     * Student name.
     */
    private String myName = "Test";

    /**
     * Student ID.
     */
    private String myID = "123456";

    /**
     * Degree major.
     */
    private String myMajor = "Computer Science";

    /**
     * Degree's term.
     */
    private String myTerm = "Summer";

    /**
     * Academic degree.
     */
    private String myDegree = "Bachelor of Science";

    /**
     * Degree's year.
     */
    private String myYear = "2016";

    /**
     * GPA.
     */
    private double myGPA = 3.7;

    /**
     * Student's email.
     */
    private String myEmail = "anon@yahoo.com";

    /**
     * A Student that contains all student's information.
     */
    private Student myStudent;

    /**
     * Set up the student.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {
        myStudent = new Student(myName, myID, myMajor,
                myTerm, myDegree, myYear, myGPA, myEmail);
    }

    /**
     * Test setName and getName.
     */
    @Test
    public void testSetGetName() {
        String test = "SetTest";
        myStudent.setName(test);
        assertEquals(myStudent.getName(), test);
    }

    /**
     * Test setID and getID.
     */
    @Test
    public void testSetGetID() {
        String test = "setID";
        myStudent.setID(test);
        assertEquals(myStudent.getID(), test);
    }

    /**
     * Test setMajor and getMajor.
     */
    @Test
    public void testSetGetMajor() {
        String test = "setMajor";
        myStudent.setMajor(test);
        assertEquals(myStudent.getMajor(), test);
    }

    /**
     * Test setEmail and getEmail.
     */
    @Test
    public void testSetGetEmail() {
        String test = "setMajor";
        myStudent.setEmail(test);
        assertEquals(myStudent.getEmail(), test);
    }

    /**
     * Test the getGPA.
     */
    @Test
    public void testGetGPA() {
        assertEquals(myStudent.getGPA(), myGPA, 0.1);
    }

    /**
     * Test the getTerm.
     */
    @Test
    public void testGetTerm() {
        assertEquals(myStudent.getTerm(), myTerm);
    }

    /**
     * Test the getYear.
     */
    @Test
    public void testGetYear() {
        assertEquals(myStudent.getYear(), myYear);
    }

    /**
     * Test the getDegree.
     */
    @Test
    public void testGetDegree() {
        assertEquals(myStudent.getDegree(), myDegree);
    }
}