package student;

/**
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

    public String getMyStdName() {
        return myStdName;
    }

    public String getMyStdID() {
        return myStdID;
    }

    public double getMyGPA() {
        return myGPA;
    }

    public String getMyStdMajor() {
        return myStdMajor;
    }

    public String getMyDegree() {
        return myDegree;
    }

    public int getMySalary() {
        return mySalary;
    }

    public String getMyCompany() {
        return myCompany;
    }

    public String getMyPosition() {
        return myPosition;
    }

    public String getMyType() {
        return myType;
    }
}