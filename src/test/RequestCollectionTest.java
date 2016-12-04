package test;

import org.junit.Before;
import org.junit.Test;
import request.Request;
import request.RequestCollection;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Test class for the RequestCollection class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class RequestCollectionTest {

    /**
     * Student ID.
     */
    private String mySID;

    /**
     * Student name.
     */
    private String myName = "Noone";

    /**
     * Comment's content.
     */
    private String myContent = "Bibibi";

    /**
     * Company's name.
     */
    private String myCompany = "Porsche";

    /**
     * Starting date.
     */
    private String myStartDay = "01-2001";

    /**
     * Ending date.
     */
    private String myEndDay = "02-2002";

    /**
     * Employment type.
     */
    private String myType = "Internship";

    /**
     * Employment position.
     */
    private String myPosition = "Developer";

    /**
     * Request ID.
     */
    private String myRID;

    /**
     * Salary amount.
     */
    private int mySalary = 30000;

    /**
     * The request.
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
     * Test for the addRequest method.
     */
    @Test
    public void testAddRequest() {
        Random rd = new Random();
        int rid = rd.nextInt(999999);
        myRID = Integer.toString(rid);
        myRequest.setMyRequestId(myRID);
        boolean successfullAdd = RequestCollection.addRequest(myRequest);
        assertTrue(successfullAdd);
    }

    /**
     * Test for the removeRequest method.
     */
    @Test
    public void testRemoveRequest() {
        boolean sucessfullRemove = RequestCollection.removeRequest(myRID);
        assertTrue(sucessfullRemove);
    }

}
