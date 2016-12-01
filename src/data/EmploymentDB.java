package data;

import student.EmploymentData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods to access the Employment
 *
 * @author Nico Tandyo
 * @author Yau Tsang
 */
public class EmploymentDB {
    private static Connection mConnection;
    private List<EmploymentData> mEmploymentList;

    /**
     * Adds a new employment to the Employment table.
     *
     * @param theEmployment
     * @return Returns true or false
     */
    public static boolean addEmployment(EmploymentData theEmployment) {
        String sql = "insert into Employment(`sid`,`company`,`position`,`description`,"
                + "`skillUsed`,`startDay`,`endDay`, `type`, `salary`) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?); ";

        if (mConnection == null) {
            try {
                mConnection = DataConnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = mConnection.prepareStatement(sql);
            preparedStatement.setString(1, theEmployment.getSID());
            preparedStatement.setString(2, theEmployment.getCompany());
            preparedStatement.setString(3, theEmployment.getPosition());
            preparedStatement.setString(4, theEmployment.getDescription());
            preparedStatement.setString(5, theEmployment.getSkill());
            preparedStatement.setString(6, theEmployment.getStartDate());
            preparedStatement.setString(7, theEmployment.getEndDate());
            preparedStatement.setString(8, theEmployment.getType());
            preparedStatement.setInt(9, theEmployment.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Retrieves all Employment from the Employment table.
     *
     * @return list of employments
     * @throws SQLException
     */
    public List<EmploymentData> getEmployments() throws SQLException {
        if (mConnection == null) {
            mConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "select Student.name , Employment.*\n" +
                "from Student join Employment\n" +
                "on Student.sid = Employment.sid;";

        mEmploymentList = new ArrayList<EmploymentData>();
        try {
            stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String sid = rs.getString("sid");
                String company = rs.getString("company");
                String pos = rs.getString("position");
                String desc = rs.getString("description");
                String skill = rs.getString("skillUsed");
                String sd = rs.getString("startDay");
                String ed = rs.getString("endDay");
                String type = rs.getString("type");
                String eid = rs.getString("employmentid");
                int salary = rs.getInt("salary");
                EmploymentData employment = null;
                employment = new EmploymentData(sid, company, pos, desc, skill, salary, type, sd, ed);
                employment.setmStudentName(name);
                employment.setmEmploymentId(eid);
                mEmploymentList.add(employment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return mEmploymentList;
    }

    /**
     * Returns all employments that contain the search keyword in the name or description.
     *
     * @param theSearch keyword of searching.
     * @return list of employment that match
     * @throws SQLException
     */
    public List<EmploymentData> searchEmployments(String theSearch) throws SQLException {
        List<EmploymentData> filterList = new ArrayList<EmploymentData>();
        if (mEmploymentList == null) {
            getEmployments();
        }
        theSearch = theSearch.toLowerCase();
        // searching name
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getmStudentName().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // student ID
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getSID().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // company name
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getCompany().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // position
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getPosition().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // description
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getDescription().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // skill
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getSkill().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // start date
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getStartDate().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // end date
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getEndDate().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        // type - job or internship
        for (EmploymentData emp : mEmploymentList) {
            if (emp.getType().toLowerCase().contains(theSearch)) {
                filterList.add(emp);
            }
        }
        return filterList;
    }

    /**
     * Returns all employments that contain the same salary as the search keyword.
     * If theMinSalary = 0, search employment with salary more than theMaxSalary
     * If theMaxSalary = 0, search employment with salary less than theMinSalary
     *
     * @param theMinSalary
     * @param theMaxSalary
     * @return list of employment that match
     * @throws SQLException
     */
    public List<EmploymentData> getEmploymentSalary(int theMinSalary, int theMaxSalary) throws SQLException {
        List<EmploymentData> filterList = new ArrayList<EmploymentData>();
        if (mEmploymentList == null) {
            getEmployments();
        }
        if (theMinSalary == 0) {
            for (EmploymentData ed : mEmploymentList) {
                if (ed.getSalary() >= theMaxSalary) {
                    filterList.add(ed);
                }
            }
        } else if (theMaxSalary == 0) {
            for (EmploymentData ed : mEmploymentList) {
                if (ed.getSalary() <= theMinSalary) {
                    filterList.add(ed);
                }
            }
        } else {
            for (EmploymentData ed : mEmploymentList) {
                if ((ed.getSalary() >= theMinSalary) && (ed.getSalary() <= theMaxSalary)) {
                    filterList.add(ed);
                }
            }
        }
        return filterList;
    }

    /**
     * Retrieve the employment with the given id or null if not found.
     *
     * @param theId the employment ID
     * @return employment
     * @throws SQLException
     */
    public EmploymentData getEmployment(String theId) throws SQLException {
        if (mConnection == null) {
            mConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "select * " + "from Employment where employmentid = " + theId;

        try {
            stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                String sid = rs.getString("sid");
                String company = rs.getString("company");
                String pos = rs.getString("position");
                String desc = rs.getString("description");
                String skill = rs.getString("skillUsed");
                String sd = rs.getString("startDay");
                String ed = rs.getString("endDay");
                String type = rs.getString("type");
                int salary = rs.getInt("salary");
                return new EmploymentData(sid, company, pos, desc, skill, salary, type, sd, ed);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return null;
    }

    /**
     * Modifies the data on an Employment .
     *
     * @param theEmployment EmploymentData object.
     * @param theCol        column name.
     * @param theData       the change of input.
     * @return Returns a message with success or failure.
     */
    public boolean updateEmployment(EmploymentData theEmployment, String theCol, Object theData) {

        int employmentid = Integer.parseInt(theEmployment.getmEmploymentId());

        String sql = "update Employment set `" + theCol
                + "` = ?  where employmentid = ?";
        // For debugging - System.out.println(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = mConnection.prepareStatement(sql);
            if (theData instanceof String)
                preparedStatement.setString(1, (String) theData);
            else if (theData instanceof Integer)
                preparedStatement.setInt(1, (Integer) theData);
            preparedStatement.setInt(2, employmentid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
        return true;

    }


}