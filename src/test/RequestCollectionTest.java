package test;

import static org.junit.Assert.assertTrue;

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
	private Request mReq;
    private String mSid = "4564564";
    private String mName = "Snow";
    private String mContent = "Fix everything";
    private String mRid = "123414";
    /**
	 * Set up the request.
	 * @throws Exception
	 */
//	@Before
//	public void setUp() throws Exception {
//		mReq = new Request(mSid, mName, mContent);
//		RequestCollection.addRequest(mReq);
//	}
//	/**
//	 * Test for the addRequest method. 
//	 */
//	@Test
//	public void testAddRequest() {
//		Request addedReq = new Request("126345", "Jon", "Fix test");
//		addedReq.setMyRequestId(mRid);
//		boolean successfullAdd = RequestCollection.addRequest(addedReq);
//		assertTrue(successfullAdd);
//	}
	/**
	 * Test for the removeRequest method. 
	 */
	@Test
	public void testRemoveRequest() {
		boolean sucessfullRemove = RequestCollection.removeRequest(mRid);
		assertTrue(sucessfullRemove);
	}
	
}
