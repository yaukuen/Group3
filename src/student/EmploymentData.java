package student;

/**
 * EmploymentData class represent the employment data with the company name, position, description,
 * skill used, start date, end date, and if it is an intern or a job.
 *
 * @author Nico Tandyo
 * @author Yau Tsang
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
     * Student's name that belong to the employment
     */
    private String mStudentName;
    /**
     * The unique number "Primary key" of the Employment table,
     * it auto generate and increments by 1 when a new employment
     * added into the table.
     */
    private String mEmploymentId;

    /**
     * Constructor for the EmploymentData.
     *
     * @param theCompany
     * @param thePosition
     * @param theDescr
     * @param theSkill
     * @param theSalary
     * @param theStart    date
     * @param theEnd      date
     */
    public EmploymentData(String theSID, String theCompany, String thePosition, String theDescr,
                          String theSkill, int theSalary, String theType, String theStart, String theEnd) {
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
     * Constructor for the EmploymentData without the position description
     * because it's optional.
     *
     * @param theCompany
     * @param thePosition
     * @param theSkill
     * @param theSalary
     * @param theStart    date
     * @param theEnd      date
     */
    public EmploymentData(String theSID, String theCompany, String thePosition,
                          String theSkill, int theSalary, String theType, String theStart, String theEnd) {
        mSID = theSID;
        mCompany = theCompany;
        mPosition = thePosition;
        mSkillUsed = theSkill;
        mSalary = theSalary;
        type = theType;
        mStartDate = theStart;
        mEndDate = theEnd;
    }

    /**
     * Gets SID
     *
     * @return the SID
     */
    public String getSID() {
        return mSID;
    }

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompany() {
        return mCompany;
    }

    /**
     * Sets company name.
     *
     * @param theCompany
     */
    public void setCompany(String theCompany) {
        mCompany = theCompany;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public String getPosition() {
        return mPosition;
    }

    /**
     * Sets position.
     *
     * @param thePosition
     */
    public void setPosition(String thePosition) {
        mPosition = thePosition;
    }

    /**
     * Gets position description.
     *
     * @return the description
     */
    public String getDescription() {
        return mPosDescription;
    }

    /**
     * Sets position description.
     *
     * @param theDesc
     */
    public void setDescription(String theDesc) {
        mPosDescription = theDesc;
    }

    /**
     * Gets the skill used.
     *
     * @return the skill used
     */
    public String getSkill() {
        return mSkillUsed;
    }

    /**
     * Sets skill used.
     *
     * @param theSkill
     */
    public void setSkill(String theSkill) {
        mSkillUsed = theSkill;
    }

    /**
     * Gets the salary.
     *
     * @return the salary
     */
    public int getSalary() {
        return mSalary;
    }

    /**
     * Sets salary.
     *
     * @param theSalary
     */
    public void setSalary(int theSalary) {
        mSalary = theSalary;
    }

    /**
     * Checks if the employment is an internship.
     *
     * @return true if intern, false otherwise
     */
    public String getType() {
        return type;
    }

    /**
     * Sets true if is intern, false otherwise.
     *
     * @param theType
     */
    public void setType(String theType) {
        type = theType;
    }

    /**
     * Gets the employment start date.
     *
     * @return the starting date
     */
    public String getStartDate() {
        return mStartDate;
    }

    /**
     * Gets the employment end date.
     *
     * @return the end date
     */
    public String getEndDate() {
        return mEndDate;
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name that belong to this employment.
     */
    public String getmStudentName() {
        return mStudentName;
    }

    /**
     * Sets the student's name.
     *
     * @param mStudentName the student's name that belong to this employment.
     */
    public void setmStudentName(String mStudentName) {
        this.mStudentName = mStudentName;
    }

    /**
     * Gets the Unique ID "Primary key" of the Employment
     *
     * @return the employment id.
     */
    public String getmEmploymentId() {
        return mEmploymentId;
    }

    /**
     * Sets the Unique ID "Primary key" to the employment.
     *
     * @param mEmploymentId the number of the employment id.
     */
    public void setmEmploymentId(String mEmploymentId) {
        this.mEmploymentId = mEmploymentId;
    }
}