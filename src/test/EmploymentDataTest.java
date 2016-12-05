package test;

import data.EmploymentDB;
import org.junit.Before;
import org.junit.Test;
import student.EmploymentData;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Test class for the EmploymentData.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 */
public class EmploymentDataTest {

    /**
     * Student's ID.
     */
    private String[] mySID = {"123456", "4123123"};

    /**
     * Company name.
     */
    private String myCompany = "TESTING COMPANY";

    /**
     * Working position.
     */
    private String myPosition = "TESTING POSITION";

    /**
     * Position description.
     */
    private String myPosDescription = "GoodTest";

    /**
     * Skill used.
     */
    private String mySkillUsed = "Computer SciTest";

    /**
     * Salary amount.
     */
    private int mySalary = 7357;

    /**
     * Employment type.
     */
    private String myType = "Job";

    /**
     * Starting date.
     */
    private String myStartDate = "01-2013";

    /**
     * Ending date.
     */
    private String myEndDate = "01-2014";

    /**
     * Employment ID.
     */
    private String myEmID = "6";

    /**
     * Employment data.
     */
    private EmploymentData myEmp;

    /**
     * Employment database.
     */
    private EmploymentDB myEDB = new EmploymentDB();

    /**
     * Set up the employment.
     *
     * @throws Exception if error occur.
     */
    @Before
    public void setUp() throws Exception {

        myEmp = new EmploymentData(mySID[0], myCompany, myPosition, myPosDescription,
                mySkillUsed, mySalary, myType, myStartDate, myEndDate);
    }

    /**
     * Test set and get company methods.
     */
    @Test
    public void testSetGetCompany() {
        String test = "microTest";
        myEmp.setCompany(test);
        assertEquals(myEmp.getCompany(), test);
    }

    /**
     * Test set and get description methods.
     */
    @Test
    public void testSetGetDesc() {
        String test = "goodSet";
        myEmp.setDescription(test);
        assertEquals(myEmp.getDescription(), test);
    }

    /**
     * Test set and get position methods.
     */
    @Test
    public void testSetGetPos() {
        String test = "bossSet";
        myEmp.setPosition(test);
        assertEquals(myEmp.getPosition(), test);
    }

    /**
     * Test set and get skill methods.
     */
    @Test
    public void testSetGetSkill() {
        String test = "compSet";
        myEmp.setSkill(test);
        assertEquals(myEmp.getSkill(), test);
    }

    /**
     * Test set and get salary methods.
     */
    @Test
    public void testSetGetSalary() {
        int test = 73571;
        myEmp.setSalary(test);
        assertEquals(myEmp.getSalary(), test);
    }

    /**
     * Test set and get type methods.
     */
    @Test
    public void testSetGetType() {
        String test = "Internship";
        myEmp.setMyType(test);
        assertEquals(myEmp.getMyType(), test);
    }

    /**
     * Test the getEndDate.
     */
    @Test
    public void testGetEndDate() {
        assertEquals(myEmp.getEndDate(), myEndDate);

    }

    /**
     * Test the getStartDate.
     */
    @Test
    public void testGetStartDate() {
        assertEquals(myEmp.getStartDate(), myStartDate);

    }

    /**
     * Test the getSID.
     */
    @Test
    public void testGetSID() {
        assertEquals(myEmp.getSID(), mySID[0]);
    }

    /**
     * Test adding an employment to the Employment table
     */
    @Test
    public void testAddingEmployment() {
        Random rd = new Random();
        int type = rd.nextInt(2);
        if (type == 0) {
            myType = "Job";
        } else {
            myType = "Internship";
        }
        mySalary = rd.nextInt(500000) + 1;
        int start = rd.nextInt(9) + 1;
        int end = rd.nextInt(9) + 1;
        myStartDate = "0" + start + "-2015";
        myEndDate = "0" + end + "-2016";
        int person = rd.nextInt(2);
        myEmp = new EmploymentData(mySID[person], myCompany, myPosition, myPosDescription,
                mySkillUsed, mySalary, myType, myStartDate, myEndDate);
        boolean result = EmploymentDB.addEmployment(myEmp);
        assertTrue(result);
    }

    /**
     * Testing updating employment.
     */
    @Test
    public void testUpdatingEmployment() {
        Random rd = new Random();
        myEmp.setMyEmploymentId(myEmID);
        int salaryTemp = rd.nextInt(500000) + 1;
        boolean result = EmploymentDB.updateEmployment(myEmp, "salary", salaryTemp);
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
        List<EmploymentData> result = myEDB.searchEmployments(search);
        assertNotEquals(0, result.size());
    }

}