import static org.junit.Assert.assertNotNull;

import org.junit.*;
public class DatabaseConnectionTest {
  @Test
  public void testGetConnectionSuccess() throws Exception{
    DatabaseConnection con = DatabaseConnection.getConnection();
    assertNotNull(conn,"The connection should not be null.");
    con.close();
  }

}
