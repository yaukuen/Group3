package request;

/**
 * Request class represents a request with student's ID number and request string.
 * Created by Yau on 11/29/2016.
 */
public class Request {

    /**
     * Student's ID number in string.
     */
    private String mySid;

    /**
     * Student's name.
     */
    private String myName;

    /**
     * A request for editing in String.
     */
    private String myContent;

    /**
     * A request ID.
     */
    private String myRequestId;
    private String myCompany;
    private String myStartDay;
    private String myEndDay;
    private String myType;
    private String myPosition;
    private int mySalary;


    /**
     * A constructor creating a new request.
     * @param theSid
     * @param theName
     * @param theCompany
     * @param thePosition
     * @param theStart
     * @param theEnd
     * @param theSalary
     * @param theType
     * @param theContent
     */
    public Request(final String theSid, final String theName, final String theCompany, final String thePosition, 
    		final String theStart, final String theEnd, final int theSalary, final String theType, final String theContent) {
        if (theSid == null) {
            throw new IllegalArgumentException("Please input your student ID number.");
        }
        this.mySid = theSid;
        this.myName = theName;
        this.myCompany = theCompany;
        this.myPosition = thePosition;
        this.myStartDay = theStart;
        this.myEndDay = theEnd;
        this.mySalary = theSalary;
        this.myType = theType;
        this.myContent = theContent;
    }

    /**
     * Gets the request student's id.
     *
     * @return A string of the student's id.
     */
    public String getMySid() {
        return mySid;
    }

    /**
     * Gets the student's name.
     * @return A string of the student's name.
     */
    public String getMyName() {
        return myName;
    }

    /**
     * Gets the request's string.
     *
     * @return A string of the request.
     */
    public String getMyContent() {
        return myContent;
    }

    /**
     * Gets the request's ID.
     *
     * @return A string of the request ID.
     */
    public String getMyRequestId() {
        return myRequestId;
    }

    /**
     * Sets the request's ID.
     *
     * @param myRequestId A string containing the request's ID.
     */
    public void setMyRequestId(String myRequestId) {
        this.myRequestId = myRequestId;
    }

	public String getMyCompany() {
		return myCompany;
	}

	public String getMyStartDay() {
		return myStartDay;
	}

	public String getMyEndDay() {
		return myEndDay;
	}

	public String getMyType() {
		return myType;
	}

	public String getMyPosition() {
		return myPosition;
	}

	public int getMySalary() {
		return mySalary;
	}
}
