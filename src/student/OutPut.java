package student;

/**
 * Output class represent the output with student name, student id, GPA, major, degree, 
 * salary, company, position, and the type of employment.
 * Created by Yau on 12/1/2016.
 */
public class OutPut {
    private String myStdName;
    private String myStdID;
    private double myGPA;
    private String myStdMajor;
    private String myDegree;
    private int mySalary;
    private String myCompany;
    private String myPosition;
    private String myType;
    /**
     * The constructor of the Output class.
     * @param myStdName
     * @param myStdID
     * @param myGPA
     * @param myStdMajor
     * @param myDegree
     * @param mySalary
     * @param myCompany
     * @param myPosition
     * @param myType
     */
    public OutPut(String myStdName, String myStdID, double myGPA,
                  String myStdMajor, String myDegree, int mySalary,
                  String myCompany, String myPosition, String myType) {
        this.myStdName = myStdName;
        this.myStdID = myStdID;
        this.myGPA = myGPA;
        this.myStdMajor = myStdMajor;
        this.myDegree = myDegree;
        this.mySalary = mySalary;
        this.myCompany = myCompany;
        this.myPosition = myPosition;
        this.myType = myType;
    }
    /**
     * Get the student name.
     * @return the student name
     */
    public String getMyStdName() {
        return myStdName;
    }
    /**
     * Get the student ID.
     * @return the student ID
     */
    public String getMyStdID() {
        return myStdID;
    }
    /**
     * Get the GPA.
     * @return GPA
     */
    public double getMyGPA() {
        return myGPA;
    }
    /**
     * Get the student major.
     * @return major
     */
    public String getMyStdMajor() {
        return myStdMajor;
    }
    /**
     * Get the student degree.
     * @return degree
     */
    public String getMyDegree() {
        return myDegree;
    }
    /**
     * Get the student salary.
     * @return salary
     */
    public int getMySalary() {
        return mySalary;
    }
    /**
     * Get the company.
     * @return company
     */
    public String getMyCompany() {
        return myCompany;
    }
    /**
     * Get the position.
     * @return position
     */
    public String getMyPosition() {
        return myPosition;
    }
    /**
     * Get the employment type.
     * @return employment
     */
    public String getMyType() {
        return myType;
    }
}
