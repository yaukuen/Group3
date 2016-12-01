package student;

/**
 * EmploymentData class represent the employment data with the company name, position, description,
 * skill used, start date, end date, and if it is an intern or a job.
 * @author Nico Tandyo
 *
 */
public class EmploymentData {
	private String mSID;
    private String mCompany;
    private String mPosition;
    private String mPosDescription;
    private String mSkillUsed;
    private int mSalary;
    private String mStartDate;
    private String mEndDate;
    private String type;
    
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
    public EmploymentData(String theSID, String theCompany, String thePosition, String theDescr, 
    		String theSkill, int theSalary, String theType, String theStart, String theEnd) {
    	
    	//check for invalid start day and end day.
    	int index = theStart.indexOf("-");
    	int index1 = theEnd.indexOf("-");
    	int start = Integer.parseInt(theStart.substring(index + 1));
    	int end = Integer.parseInt(theEnd.substring(index1 + 1));
    	int startMonth = Integer.parseInt(theStart.substring(0, index));
    	int endMonth = Integer.parseInt(theEnd.substring(0, index1));
    	if (start > end) {
    		throw new IllegalArgumentException("Invalid start day and end day");
    	} else if (start == end &&  startMonth > endMonth ) {
    		throw new IllegalArgumentException("Invalid start day and end day");
    	}
    	
    	mSID = theSID;
    	mCompany = theCompany;
    	mPosition = thePosition;
    	mPosDescription = theDescr;
    	mSkillUsed = theSkill;
    	mSalary = theSalary;
    	type = theType;
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
    		String theSkill, String theType) {
    	mCompany = theCompany;
    	mPosition = thePosition;
    	mPosDescription = theDescr;
    	mSkillUsed = theSkill;
    	type = theType;
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
     * Set salary.
     * @param theSalary
     */
    public void setSalary(int theSalary) {
    	mSalary = theSalary;
    }
    /**
     * Set true if is intern, false otherwise.
     * @param theIsIntern
     */
    public void setType(String theType) {
    	type = theType;
    }
    
    /**
     * Get SID
     * @return the SID
     */
    public String getSID() {
    	return mSID;
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
     * Get the salary.
     * @return the salary
     */
    public int getSalary() {
    	return mSalary;
    }
    /**
     * Check if the employment is an internship.
     * @return true if intern, false otherwise
     */
    public String getType() {
    	return type;
    }
    /**
     * Get the employment start date.
     * @return the starting date
     */
    public String getStartDate() {
    	return mStartDate;
    }
    /**
     * Get the employment end date.
     * @return the end date
     */
    public String getEndDate() {
    	return mEndDate;
    }
    
}