package request;

import data.RequestDB;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kuenk on 11/29/2016.
 */
public class RequestCollection {

//    private List<Request> myRequest;

    /**
     * Request collection's database for connecting to the database.
     */
    private static RequestDB myRequestDB;

    /**
     * Return all requests in the list, null otherwise.
     * @return a list of requests.
     */
    public static List<Request> showTheList() {
        if (myRequestDB == null) {
            myRequestDB = new RequestDB();
        }
        try {
            return myRequestDB.getRequests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds a new request to the database.
     * @param theRequest request contains sid and request content.
     * @return true if succeeded, false otherwise.
     */
    public static boolean addRequest(final Request theRequest) {
        if (myRequestDB == null) {
            myRequestDB = new RequestDB();
        }
        String message = myRequestDB.addRequest(theRequest);
        if (message.startsWith("Error adding request:")) {
            return false;
        }
        return true;
    }

    /**
     * A request user want to remove.
     * @param theRequestId request contains request id.
     * @return true if succeeded, false otherwise.
     */
    public static boolean removeRequest(final String theRequestId) {
        if (myRequestDB == null) {
            myRequestDB = new RequestDB();
        }
        String message = myRequestDB.removeRequest(theRequestId);
        if (message.startsWith("Error removing request:")) {
            return false;
        }
        return true;
    }

}
