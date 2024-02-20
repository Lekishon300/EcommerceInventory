package main;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import main.DatabaseConnection;
import java.sql.Connection;
import main.ProductManager;
public class CustomerManager{


  public static int getCustomerId(String email, String password)throws SQLException{
    Connection con = null;
    try{
      con = DatabaseConnection.getConnection();
    }catch(Exception e){
      System.out.println("No connection!!!!!!!!!!");
      e.printStackTrace();
    }
   int Customer_ID= -1;
   try{
      if (con!= null){
      String query = "Select customer_id from customers where email=? and password=?";
      PreparedStatement st = con.prepareStatement(query);
      st.setString(1, email);
      st.setString(2, password);
      ResultSet rs = st.executeQuery();
    if(rs.next()){
      Customer_ID= rs.getInt("customer_id");
    }
  
   }else{
    System.out.println("rs has nothing inside!");
   }
  }catch(SQLException s){
    System.out.println("Check your sql syntax");
    s.printStackTrace();
  }
  return Customer_ID;
  }
}