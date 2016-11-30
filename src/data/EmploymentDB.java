package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.EmploymentData;

/**
 * This class contains methods to access the Employment
 * @author Nico Tandyo
 *
 */
public class EmploymentDB {
	private Connection mConnection;
    private List<EmploymentData> mEmploymentList;
    
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
		String query = "select * " + "from Employment ";

		mEmploymentList = new ArrayList<EmploymentData>();
		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
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
	 * @param theSearch search name
	 * @return list of employment that match
	 * @throws SQLException
	 */
	public List<EmploymentData> getEmployments(String theSearch) throws SQLException {
		List<EmploymentData> filterList = new ArrayList<EmploymentData>();
		if (mEmploymentList == null) {
			getEmployments();
		}
		theSearch = theSearch.toLowerCase();
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getSID().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getCompany().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getPosition().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getDescription().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getSkill().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getStartDate().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
		for (EmploymentData emp : mEmploymentList) {
			if (emp.getEndDate().toLowerCase().contains(theSearch)) {
				filterList.add(emp);
			}
		}
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
		if(theMinSalary == 0) {
			for (EmploymentData ed : mEmploymentList) {
				if(ed.getSalary()>= theMaxSalary) {
					filterList.add(ed);
				}				
			}
		}else if (theMaxSalary == 0) {
			for(EmploymentData ed : mEmploymentList) {
				if(ed.getSalary()<= theMinSalary) {
					filterList.add(ed);
				}				
			}
		} else {
			for(EmploymentData ed : mEmploymentList) {
				if((ed.getSalary()>=theMinSalary) && (ed.getSalary()<= theMaxSalary)) {
					filterList.add(ed);
				}
			}
		}
		return filterList;
	}
	/**
	 * Retrieve the employment with the given id or null if not found.
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
				String eid = rs.getString("employmentid");
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
	 * Adds a new employment to the Employment table. 
	 * @param theEmployment 
	 * @return Returns "Added Employment Successfully" or "Error adding employment: " with the sql exception.
	 */
	public String addEmployment(EmploymentData theEmployment) {
		String sql = "insert into Employment(`sid`,`company`,`position`,`description`,"
				+ "`skillUsed`,`startDay`,`endDay`, `type`, `salary`) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?); ";

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
			return "Error adding employment: " + e.getMessage();
		}
		return "Added Employment Successfully";
	}

	/**
	 * Modifies the data on an Employment 
	 * @param row
	 * @param theCol
	 * @param theData
	 * @return Returns a message with success or failure.
	 */
	public String updateEmployment(EmploymentData theEmployment, String theCol, Object theData) {
		
		String company = theEmployment.getCompany();
		String pos = theEmployment.getPosition();
		String des = theEmployment.getDescription();
		String skill = theEmployment.getSkill();
		String start = theEmployment.getStartDate();
		String end = theEmployment.getEndDate();
		String type = theEmployment.getType();
		int salary = theEmployment.getSalary();
		String sql = "update Employment set `" + theCol
				+ "` = ?  where company = ? and position = ? and description = ? and skillUsed = ? "
				+ "and startDay = ? and endDay = ? and type = ? and salary = ?";
		// For debugging - System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			if (theData instanceof String)
				preparedStatement.setString(1, (String) theData); 
			else if (theData instanceof Double)
				preparedStatement.setDouble(1, (Double) theData);
			preparedStatement.setString(2, company);
			preparedStatement.setString(3, pos);
			preparedStatement.setString(4, des);
			preparedStatement.setString(5, skill);
			preparedStatement.setString(6, start);
			preparedStatement.setString(7, end);
			preparedStatement.setString(8, type);
			preparedStatement.setInt(9, salary);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return "Error updating employment: " + e.getMessage();
		}
		return "Updated Employment Successfully";
	
	}

}
