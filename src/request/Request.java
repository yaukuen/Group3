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


    /**
     * A constructor creating a new request.
     *
     * @param theSid     Student's ID number.
     * @param theContent Student's request.
     */
    public Request(final String theSid, final String theName, final String theContent) {
        if (theSid == null) {
            throw new IllegalArgumentException("Please input your student ID number.");
        }
        this.mySid = theSid;
        this.myName = theName;
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
}
