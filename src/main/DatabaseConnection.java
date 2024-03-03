
package main;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;

/**
 * The DatabaseConnection class provides a mechanism to establish a connection to the database.
 * It utilizes a properties file to configure the database connection parameters including the URL, username,
 * and password. This class centralizes the database connection setup for reuse across different parts of the application
 * that require database access.
 */
public class DatabaseConnection {
  private static Properties properties = new Properties();
     /**
     * Attempts to establish a connection to the database using parameters defined in a properties file.
     * It first attempts to load the database connection details from "database.properties" file.
     * After successfully loading the properties, it tries to establish a connection to the database
     * using the JDBC URL, username, and password provided in the properties file.
     * 
     * @return A Connection object to the database if the connection is successfully established.
     * @throws Exception if there is an issue loading the properties file, 
     * class not found exception for the JDBC driver, or if there is a problem establishing the connection to the database.
     */
  public static Connection getConnection()throws Exception{
    try{
      FileReader reader= new FileReader("database.properties");
      properties.load(reader);
    }catch(Exception e){
    e.printStackTrace();
    }
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));  
      return con;
    }catch(Exception e){
      System.out.println("Check url,username for database!"); 
      e.printStackTrace();
      return null;
    }
  } 
}
