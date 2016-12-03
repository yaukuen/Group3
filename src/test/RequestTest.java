package test;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import request.Request;

/**
 * Test class for the Request class.
 * @author Nico Tandyo
 *
 */
public class RequestTest {
	private String mSID;
    private String mName = "Wassup";
    private String mContent = "Alibaba";
    private String mCompany = "Bubba";
    private String mStartDay;
    private String mEndDay;
    private String mType = "Internship";
    private String mPosition = "Owner";
    private int mSalary = 20000;
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
	 * Test getName.
	 */
	@Test
	public void testGetName() {
		assertEquals(mRequest.getMyName(), mName);
	}
	/**
	 * Test getContent.
	 */
	@Test
	public void testGetContent() {
		assertEquals(mRequest.getMyContent(), mContent);
		
	}
	/**
	 * Test getSID.
	 */
	@Test
	public void testGetSID() {
		assertEquals(mRequest.getMySid(), mSID);
		
	}
	/**
	 * Test getCompany.
	 */
	@Test
	public void testGetCompany() {
		assertEquals(mRequest.getMyCompany(), mCompany);
		
	}
	/**
	 * Test getType.
	 */
	@Test
	public void testGetType() {
		assertEquals(mRequest.getMyType(), mType);
		
	}
	/**
	 * Test getSalary.
	 */
	@Test
	public void testGetSalary() {
		assertEquals(mRequest.getMySalary(), mSalary);
		
	}
	/**
	 * Test getPosition.
	 */
	@Test
	public void testGetPosition() {
		assertEquals(mRequest.getMyPosition(), mPosition);
		
	}
}
