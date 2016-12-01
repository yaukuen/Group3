package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import student.EmploymentData;
/**
 * Test class for the EmploymentData.
 * @author Nico Tandyo
 *
 */
public class EmploymentDataTest {
	private String mSID = "123456";
    private String mCompany = "MicroTest";
    private String mPosition = "Software DevTest";
    private String mPosDescription = "GoodTest";
    private String mSkillUsed = "Computer SciTest";
    private int mSalary = 7357;
    private String mType = "Job";
    private String mStartDate = "01-2013";
    private String mEndDate = "01-2014";
    
    private EmploymentData mEmp;
    
    /**
	 * Set up the employment.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mEmp = new EmploymentData(mSID, mCompany, mPosition, mPosDescription, 
				mSkillUsed, mSalary, mType, mStartDate, mEndDate);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorIllegalArgument() {
		new EmploymentData(mSID, mCompany, mPosition, mPosDescription, mSkillUsed, 
				mSalary, mType, "02-2015", "01-2013");
	}
	/**
	 * Test set and get company methods.
	 */
	@Test
	public void testSetGetCompany() {
		String test = "microTest";
		mEmp.setCompany(test);
		assertEquals(mEmp.getCompany(), test);
	}
	/**
	 * Test set and get description methods.
	 */
	@Test
	public void testSetGetDesc() {
		String test = "goodSet";
		mEmp.setDescription(test);
		assertEquals(mEmp.getDescription(), test);
	}
	/**
	 * Test set and get position methods.
	 */
	@Test
	public void testSetGetPos() {
		String test = "bossSet";
		mEmp.setPosition(test);
		assertEquals(mEmp.getPosition(), test);
	}
	/**
	 * Test set and get skill methods.
	 */
	@Test
	public void testSetGetSkill() {
		String test = "compSet";
		mEmp.setSkill(test);
		assertEquals(mEmp.getSkill(), test);
	}
	/**
	 * Test set and get salary methods.
	 */
	@Test
	public void testSetGetSalary() {
		int test = 73571;
		mEmp.setSalary(test);
		assertEquals(mEmp.getSalary(), test);
	}
	/**
	 * Test set and get type methods.
	 */
	@Test
	public void testSetGetType() {
		String test = "Internship";
		mEmp.setType(test);
		assertEquals(mEmp.getType(), test);
	}
	/**
	 * Test the rest of the getters.
	 */
	@Test
	public void testGetters() {
		assertEquals(mEmp.getEndDate(), mEndDate);
		assertEquals(mEmp.getStartDate(), mStartDate);
		assertEquals(mEmp.getSID(), mSID);
	}
	
	
}