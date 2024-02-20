package test;
import static org.junit.Assert.assertNotNull;
import java.sql.Connection;

import main.DatabaseConnection;

import org.junit.*;
public class DatabaseConnectionTest {
  @Test
  public void testGetConnectionSuccess() throws Exception{
    Connection con = DatabaseConnection.getConnection();
    assertNotNull("The connection should not be null.",con);
    con.close();
  }

}
