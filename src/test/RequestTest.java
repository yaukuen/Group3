package test;

import org.junit.Before;
import org.junit.Test;
import request.Request;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Request class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class RequestTest {

    /**
     * Student ID.
     */
    private String mySID;

    /**
     * Student's name.
     */
    private String myName = "Wassup";

    /**
     * Comment's content.
     */
    private String myContent = "Alibaba";

    /**
     * Company's name.
     */
    private String myCompany = "Bubba";

    /**
     * Start date.
     */
    private String myStartDay = "01-2013";

    /**
     * End date.
     */
    private String myEndDay = "01-2014";

    /**
     * Employment type.
     */
    private String myType = "Internship";

    /**
     * Employment position.
     */
    private String myPosition = "Owner";

    /**
     * Salary amount.
     */
    private int mySalary = 20000;

    /**
     * The request that contains request inforamtion.
     */
    private Request myRequest;

    /**
     * Set up the request.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        int sid = rd.nextInt(999999);
        mySID = Integer.toString(sid);
        myRequest = new Request(mySID, myName, myCompany, myPosition,
                myStartDay, myEndDay, mySalary, myType, myContent);
    }

    /**
     * Test getName.
     */
    @Test
    public void testGetName() {
        assertEquals(myRequest.getMyName(), myName);
    }

    /**
     * Test getContent.
     */
    @Test
    public void testGetContent() {
        assertEquals(myRequest.getMyContent(), myContent);

    }

    /**
     * Test getSID.
     */
    @Test
    public void testGetSID() {
        assertEquals(myRequest.getMySid(), mySID);

    }

    /**
     * Test getCompany.
     */
    @Test
    public void testGetCompany() {
        assertEquals(myRequest.getMyCompany(), myCompany);

    }

    /**
     * Test getMyType.
     */
    @Test
    public void testGetType() {
        assertEquals(myRequest.getMyType(), myType);

    }

    /**
     * Test getSalary.
     */
    @Test
    public void testGetSalary() {
        assertEquals(myRequest.getMySalary(), mySalary);

    }

    /**
     * Test getPosition.
     */
    @Test
    public void testGetPosition() {
        assertEquals(myRequest.getMyPosition(), myPosition);

    }

    /**
     * Test getStartDay.
     */
    @Test
    public void testGetStartDay() {
        assertEquals(myRequest.getMyStartDay(), myStartDay);
    }

    /**
     * Test getEndDay.
     */
    @Test
    public void testGetEndDay() {
        assertEquals(myRequest.getMyEndDay(), myEndDay);
    }
}
