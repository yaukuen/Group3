package test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import request.Request;
import request.RequestCollection;

/**
 * Test class for the RequestCollection class.
 * @author Nico Tandyo
 *
 */
public class RequestCollectionTest {
	private String mSID;
    private String mName = "Noone";
    private String mContent = "Bibibi";
    private String mCompany = "Porsche";
    private String mStartDay;
    private String mEndDay;
    private String mType = "Internship";
    private String mPosition = "Developer";
    private String mRID;
    private int mSalary = 30000;
    private Request mRequest;
    /**
	 * Set up the request.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Random rd = new Random();
		int sid = rd.nextInt(999999);
		mSID = Integer.toString(sid);
		mRequest = new Request(mSID, mName, mCompany, mPosition, 
	    		mStartDay, mEndDay, mSalary, mType, mContent);
	}
	/**
	 * Test for the addRequest method. 
	 */
	@Test
	public void testAddRequest() {
		Random rd = new Random();
		int rid = rd.nextInt(999999);
		mRID = Integer.toString(rid);
		mRequest.setMyRequestId(mRID);
		boolean successfullAdd = RequestCollection.addRequest(mRequest);
		assertTrue(successfullAdd);
	}
	/**
	 * Test for the removeRequest method. 
	 */
	@Test
	public void testRemoveRequest() {
		boolean sucessfullRemove = RequestCollection.removeRequest(mRID);
		assertTrue(sucessfullRemove);
	}
	
}
