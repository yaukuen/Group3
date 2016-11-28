package student;

import java.util.Calendar;

/**
 * EmploymentData class represent the employment data with the company name, position, description,
 * skill used, start date, end date, and if it is an intern or a job.
 * @author Nico Tandyo
 *
 */
public class EmploymentData {
    private String mCompany;
    private String mPosition;
    private String mPosDescription;
    private String mSkillUsed;
    private Calendar mStartDate;
    private Calendar mEndDate;
    private boolean mIsIntern;
    
    /**
     * Constructor for the EmploymentData.
     * @param theCompany
     * @param thePosition
     * @param theDescr
     * @param theSkill
     * @param theIntern
     * @param theStart date
     * @param theEnd date
     */
    public EmploymentData(String theCompany, String thePosition, String theDescr, 
    		String theSkill, boolean theIntern, Calendar theStart, Calendar theEnd) {
    	mCompany = theCompany;
    	mPosition = thePosition;
    	mPosDescription = theDescr;
    	mSkillUsed = theSkill;
    	mIsIntern = theIntern;
    	mStartDate = theStart;
    	mEndDate = theEnd;
    	
    }
    /**
     * Constructor for the EmploymentData.
     * @param theCompany
     * @param thePosition
     * @param theDescr
     * @param theSkill
     * @param theIntern
     */
    public EmploymentData(String theCompany, String thePosition, String theDescr, 
    		String theSkill, boolean theIntern) {
    	mCompany = theCompany;
    	mPosition = thePosition;
    	mPosDescription = theDescr;
    	mSkillUsed = theSkill;
    	mIsIntern = theIntern;
    }
    /**
     * Set company name.
     * @param theCompany
     */
    public void setCompany(String theCompany) {
    	mCompany = theCompany;
    }
    /**
     * Set position.
     * @param thePosition
     */
    public void setPosition(String thePosition) {
    	mPosition = thePosition;
    }
    /**
     * Set position description.
     * @param theDesc
     */
    public void setDescription(String theDesc) {
    	mPosDescription = theDesc;
    }
    /**
     * Set skill used.
     * @param theSkill
     */
    public void setSkill(String theSkill) {
    	mSkillUsed = theSkill;
    }
    /**
     * Set true if is intern, false otherwise.
     * @param theIsIntern
     */
    public void setInternship(boolean theIsIntern) {
    	mIsIntern = theIsIntern;
    }
    /**
     * Get company name.
     * @return the company name
     */
    public String getCompany() {
    	return mCompany;
    }
    /**
     * Get position.
     * @return the position
     */
    public String getPosition() {
    	return mPosition;
    }
    /**
     * Get position description.
     * @return the description
     */
    public String getDescription() {
    	return mPosDescription;
    }
    /**
     * Get the skill used.
     * @return the skill used
     */
    public String getSkill() {
    	return mSkillUsed;
    }
    /**
     * Check if the employment is an internship.
     * @return true if intern, false otherwise
     */
    public boolean getInternship() {
    	return mIsIntern;
    }
    /**
     * Get the employment start date.
     * @return the starting date
     */
    public Calendar getStartDate() {
    	return mStartDate;
    }
    /**
     * Get the employment end date.
     * @return the end date
     */
    public Calendar getEndDate() {
    	return mEndDate;
    }
    
}
