
package main;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;

public class DatabaseConnection {
  private static Properties properties = new Properties();

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
