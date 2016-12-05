package test;

import org.junit.Before;
import org.junit.Test;
import student.Output;

import static org.junit.Assert.assertEquals;

/**
 * This is class for the Output class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class OutputTest {

    /**
     * Student name.
     */
    private String myStdName = "Joey";

    /**
     * Student ID.
     */
    private String myStdID = "000653";

    /**
     * GPA.
     */
    private double myGPA = 3.8;

    /**
     * Major of the degree.
     */
    private String myStdMajor = "CSS";

    /**
     * Academic degree.
     */
    private String myDegree = "Master of Science";

    /**
     * Salary amount.
     */
    private int mySalary = 30000;

    /**
     * Company's name.
     */
    private String myCompany = "Amazon";

    /**
     * Employment position.
     */
    private String myPosition = "Manager";

    /**
     * Employment type.
     */
    private String myType = "Job";

    /**
     * The Output contain output information.
     */
    private Output myOutput;

    /**
     * Set up the request.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {
        myOutput = new Output(myStdName, myStdID, myGPA, myStdMajor, myDegree, mySalary, myCompany, myPosition, myType);
    }

    /**
     * Test getMyStdName
     */
    @Test
    public void testGetName() {
        assertEquals(myOutput.getMyStdName(), myStdName);
    }

    /**
     * Test getMyStdID
     */
    @Test
    public void testGetID() {
        assertEquals(myOutput.getMyStdID(), myStdID);
    }

    /**
     * Test getMyGPA
     */
    @Test
    public void testGetGPA() {
        assertEquals(myOutput.getMyGPA(), myGPA, 0.1);
    }

    /**
     * Test getMyMajor.
     */
    @Test
    public void testGetMajor() {
        assertEquals(myOutput.getMyStdMajor(), myStdMajor);
    }

    /**
     * Test getMyDegree.
     */
    @Test
    public void testGetDegree() {
        assertEquals(myOutput.getMyDegree(), myDegree);
    }

    /**
     * Test getMySalary.
     */
    @Test
    public void testGetSalary() {
        assertEquals(myOutput.getMySalary(), mySalary);
    }

    /**
     * Test getMyCompany.
     */
    @Test
    public void testGetCompany() {
        assertEquals(myOutput.getMyCompany(), myCompany);
    }

    /**
     * Test getMyPosition.
     */
    @Test
    public void testGetPosition() {
        assertEquals(myOutput.getMyPosition(), myPosition);
    }

    /**
     * Test getMyType.
     */
    @Test
    public void testGetType() {
        assertEquals(myOutput.getMyType(), myType);
    }

}
