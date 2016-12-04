package test;

import data.DataConnection;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Test class for the DataConnection class.
 *
 * @author Nico Tandyo
 * @author Yau
 */
public class DataConnectionTest {

    /**
     * Test the connection.
     */
    @Test
    public void testConnection() {
        try {
            Connection conn = DataConnection.getConnection();
            assertNotNull(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
