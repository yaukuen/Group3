package test;

import static org.junit.Assert.*;

import data.EmploymentDB;
import org.junit.Before;
import org.junit.Test;
import student.EmploymentData;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Test class for the EmploymentData.
 * @author Nico Tandyo
 *
 */
public class EmploymentDataTest {
	private String[] mSID = {"123456", "4123123"};
    private String mCompany = "TESTING COMPANY";
    private String mPosition = "TESTING POSITION";
    private String mPosDescription = "GoodTest";
    private String mSkillUsed = "Computer SciTest";
    private int mSalary = 7357;
    private String mType = "Job";
    private String mStartDate = "01-2013";
    private String mEndDate = "01-2014";
    private String mEmID = "17";
    
    private EmploymentData mEmp;
    private EmploymentDB mEDB = new EmploymentDB();
    
    /**
	 * Set up the employment.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		mEmp = new EmploymentData(mSID[0], mCompany, mPosition, mPosDescription,
				mSkillUsed, mSalary, mType, mStartDate, mEndDate);
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
	 * Test the getEndDate.
	 */
	@Test
	public void testGetEndDate() {
		assertEquals(mEmp.getEndDate(), mEndDate);
		
	}
	/**
	 * Test the getStartDate.
	 */
	@Test
	public void testGetStartDate() {
		assertEquals(mEmp.getStartDate(), mStartDate);
		
	}
	/**
	 * Test the getSID.
	 */
	@Test
	public void testGetSID() {
		assertEquals(mEmp.getSID(), mSID[0]);
	}

    /**
     * Test adding an employment to the Employment table
     */
	@Test
    public void testAddingEmployment() {
        Random rd = new Random();
        int type = rd.nextInt(2);
        if (type == 0) {
            mType = "Job";
        } else {
            mType = "Internship";
        }
        mSalary = rd.nextInt(500000) + 1;
        int start = rd.nextInt(9) + 1;
        int end = rd.nextInt(9) + 1;
        mStartDate = "0" + start + "-2015";
        mEndDate = "0" + end + "-2016";
        int person = rd.nextInt(2);
        mEmp = new EmploymentData(mSID[person], mCompany, mPosition, mPosDescription,
                mSkillUsed, mSalary, mType, mStartDate, mEndDate);
	    boolean result = EmploymentDB.addEmployment(mEmp);
        assertTrue(result);
    }

    /**
     * Testing updating employment.
     */
    @Test
    public void testUpdatingEmployment() {
        Random rd = new Random();
        mEmp.setmEmploymentId(mEmID);
        int salaryTemp = rd.nextInt(500000) + 1;
        boolean result = EmploymentDB.updateEmployment(mEmp, "salary", salaryTemp);
        assertTrue(result);
    }

    /**
     * Testing searching an employment.
     */
    @Test
    public void testSearchingEmployment() throws SQLException {
        Random rd = new Random();
        int type = rd.nextInt(2);
        String search = null;
        if (type == 0) {
            search = "Job";
        } else {
            search = "Internship";
        }
        List<EmploymentData> result = mEDB.searchEmployments(search);
        assertNotEquals(0, result.size());
    }
	
}