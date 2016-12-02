package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import request.Request;

/**
 * Test class for the Request class.
 * @author Nico Tandyo
 *
 */
public class RequestTest {
	/** Student ID. **/
    private String mSID = "99123";
    /** Request ID. **/
    private String mRID = "11234";
    
    private String mName = "theRequest";
    private String mContent = "theName";
    
    private Request mRequest;
    
    /**
	 * Set up the request.
	 * @throws Exception
	 */
//	@Before
//	public void setUp() throws Exception {
//		mRequest = new Request(mSID, mName, mContent);
//	}
//	/**
//	 * Test constructor.
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testConstructor() {
//		new Request(null, mName, mContent);
//	}
	/**
	 * Test setName and getName.
	 */
	@Test
	public void testSetGetRequestID() {
		mRequest.setMyRequestId(mRID);
		assertEquals(mRequest.getMyRequestId(), mRID);
	}
	/**
	 * Test other getters.
	 */
	@Test
	public void testGetters() {
		assertEquals(mRequest.getMyContent(), mContent);
		assertEquals(mRequest.getMyName(), mName);
		assertEquals(mRequest.getMySid(), mSID);
	}
}
