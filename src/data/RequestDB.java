package data;

import request.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods to access Request table.
 * Created by Yau on 11/29/2016.
 */
public class RequestDB {

    /**
     * It's a connection for connecting to the database.
     */
    private Connection myConnection;

    /**
     * It's a list holding all request.
     */
    private List<Request> myRequestList;

    /**
     * Get all requests from the Request table.
     * @returnA list of all requests.
     * @throws SQLException if query not input correctly.
     */
    public List<Request> getRequests() throws SQLException {
        if (myConnection == null) {
            myConnection = DataConnection.getConnection();
        }
        Statement stmt = null;
        String query = "SELECT * " + "FROM Request ;";

        myRequestList = new ArrayList<>();
        try {
            stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("requestId");
                String studentId = rs.getString("studentId");
                String studentName = rs.getString("name");
                String content = rs.getString("content");
                Request requestTemp = new Request(studentId, studentName, content);
                requestTemp.setMyRequestId(new Integer(id).toString());
                myRequestList.add(requestTemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return myRequestList;
    }

    /**
     * Adds a new request to the Request table.
     * @param theRequest contains information of the request.
     * @return "Added Request Successfully" or "Error adding request: " with the sql exception.
     */
    public String addRequest(final Request theRequest) {
        String sql = "insert into Request(sid, `name`, content) values "
                + "(?, ?, ?); ";

        if (myConnection == null) {
            try {
                myConnection = DataConnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnection.prepareStatement(sql);
            preparedStatement.setString(1, theRequest.getMySid());
            preparedStatement.setString(2, theRequest.getMyName());
            preparedStatement.setString(3, theRequest.getMyContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding request: " + e.getMessage();
        }
        return "Added Request Successfully";
    }

    /**
     * Remove a row after finished editing student's information.
     * @param theRequest contains information of the request.
     * @return "Removed Request Successfully" or "Error removing request: " with the sql exception.
     */
    public String removeRequest(final Request theRequest) {
        // Delete From Request Where requestId = ?;
        String requestId = theRequest.getMyRequestId();
        String sql = "delete from Request where requestId = ? ;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnection.prepareStatement(sql);
            preparedStatement.setString(1, requestId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error removing request: " + e.getMessage();
        }
        return "Removed Request Successfully";
    }
}