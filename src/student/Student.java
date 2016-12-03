package student;


/**
 * Student class represent a student with name, student id, 
 * major, term, degree, year, GPA, email, and a list of employment.
 * @author Nico Tandyo
 *
 */
public class Student {
    private String mStdName;
    private String mStdID;
    private String mStdMajor;
    private String mGradTerm;
    private String mDegree;
    private String mYear;
    private double mGPA;
    private String mEmail;
    
    /**
     * Constructor for the student.
     * @param theName
     * @param theID
     * @param theMajor
     * @param theTerm
     * @param theDegree
     * @param theYear
     * @param theGPA
     * @param theEmail
     */
    public Student(String theName, String theID, String theMajor, String theTerm, String theDegree,
    		String theYear, double theGPA, String theEmail) {
    	mStdName = theName;
    	mStdID = theID;
    	mStdMajor = theMajor;
    	mGradTerm = theTerm;
    	mDegree = theDegree;
    	mYear = theYear;
    	mGPA = theGPA;
    	mEmail = theEmail;
    }
    /**
     * Set the student's name.
     * @param theName
     */
    public void setName(String theName) {
    	mStdName = theName;
    }
    /**
     * Set the student's ID.
     * @param theID
     */
    public void setID(String theID) {
    	mStdID = theID;
    }
    /**
     * Set the student's major.
     * @param theMajor
     */
    public void setMajor(String theMajor) {
    	mStdMajor = theMajor;
    }
    /**
     * Set the student's email.
     * @param theEmail
     */
    public void setEmail(String theEmail) {
    	mEmail = theEmail;
    }
    /**
     * Add an employment to the list of job or intern.
     * @param theEmployment
     */
//    public void addEmployment(EmploymentData theEmployment) {
//    	if(theEmployment.getType() == "Intership") {
//    		mInternList.add(theEmployment);
//    	}else if(theEmployment.getType() == "Job") {
//    		mJobList.add(theEmployment);
//    	}
//    }
//    /**
//     * Get the list of job.
//     * @return a list of job
//     */
//    public List<EmploymentData> getJobList() {
//    	return mJobList;
//    }
//    /**
//     * Get the list of intern.
//     * @return a list of intern.
//     */
//    public List<EmploymentData> getInternList() {
//    	return mInternList;
//    }
    /**
     * Get the student's name.
     * @return the student's name
     */
    public String getName() {
    	return mStdName;
    }
    /**
     * Get the student's ID.
     * @return the student's ID
     */
    public String getID() {
    	return mStdID;
    }
    /**
     * Get the student's major.
     * @return the student's major
     */
    public String getMajor() {
    	return mStdMajor;
    }
    /**
     * Get the student's graduation term.
     * @return the student's graduation term
     */
    public String getTerm() {
    	return mGradTerm;
    }
    /**
     * Get the student's degree.
     * @return the student's degree
     */
    public String getDegree() {
    	return mDegree;
    }
    /**
     * Get the student's year.
     * @return the student's year
     */
    public String getYear() {
    	return mYear;
    }
    /**
     * Get the student's GPA.
     * @return the student's GPA
     */
    public double getGPA() {
    	return mGPA;
    }
    /**
     * Get the student's email.
     * @return the student's email
     */
    public String getEmail() {
    	return mEmail;
    }
    
}