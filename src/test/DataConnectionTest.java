package test;
import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import data.DataConnection;

/**
 * Test class for the DataConnection class.
 * @author Nico Tandyo
 *
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
