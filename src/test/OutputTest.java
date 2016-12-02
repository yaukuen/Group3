package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import student.OutPut;

/**
 * This is class for the Output class.
 * @author Nico Tandyo
 */
public class OutputTest {
	 private String mStdName = "Joey";
	 private String mStdID = "000653";
	 private double mGPA = 3.8;
	 private String mStdMajor = "CSS";
	 private String mDegree = "Master of Science";
	 private int mSalary = 30000;
	 private String mCompany = "Amazon";
	 private String mPosition = "Manager";
	 private String mType = "Job";
	 private OutPut mOutput;
	 /**
	 * Set up the request.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mOutput = new OutPut(mStdName, mStdID, mGPA, mStdMajor, mDegree, mSalary, mCompany, mPosition, mType);
	}
	/**
	 * Test getMyStdName
	 */
	@Test
	public void testGetName() {
		assertEquals(mOutput.getMyStdName(), mStdName);
	}
	/**
	 * Test getMyStdID
	 */
	@Test
	public void testGetID() {
		assertEquals(mOutput.getMyStdID(), mStdID);
	}
	/**
	 * Test getMyGPA
	 */
	@Test
	public void testGetGPA() {
		assertEquals(mOutput.getMyGPA(), mGPA, 0.1);
	}
	/**
	 * Test getMyMajor.
	 */
	@Test
	public void testGetMajor() {
		assertEquals(mOutput.getMyStdMajor(), mStdMajor);
	}
	/**
	 * Test getMyDegree.
	 */
	@Test
	public void testGetDegree() {
		assertEquals(mOutput.getMyDegree(), mDegree);
	}
	/**
	 * Test getMySalary.
	 */
	@Test
	public void testGetSalary() {
		assertEquals(mOutput.getMySalary(), mSalary);
	}
	/**
	 * Test getMyCompany.
	 */
	@Test
	public void testGetCompany() {
		assertEquals(mOutput.getMyCompany(), mCompany);
	}
	/**
	 * Test getMyPosition.
	 */
	@Test
	public void testGetPosition() {
		assertEquals(mOutput.getMyPosition(), mPosition);
	}
	/**
	 * Test getMyType.
	 */
	@Test
	public void testGetType() {
		assertEquals(mOutput.getMyType(), mType);
	}
	
}
