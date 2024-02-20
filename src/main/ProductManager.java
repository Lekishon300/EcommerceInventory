package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.Product;

public class ProductManager {
  public static void getAllProducts(){
    Connection con = null;
    try{
      con = DatabaseConnection.getConnection();
    }catch(Exception e){
      System.out.println("No connection!");
      e.printStackTrace();
    }
    try{
      if (con!= null){
        String query = "Select * from products";
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        System.out.println("Product ID    Product Name      Product Quantity");
        while(rs.next()){
        String Product_Name= rs.getString("product_name");
        int Product_ID = rs.getInt("product_id");
        int product_Quantity= rs.getInt("product_quantity");
        System.out.println(Product_ID + "   "+ Product_Name +"    "+ product_Quantity);
        }
     }else{
      System.out.println("Result set has nothing inside!");
   }
  }catch(SQLException s){
    System.out.println("Check your SQL syntax");
    s.printStackTrace();
    }
  }
  public static double fetchProductPrice(int productId) throws Exception{
    double price = 0.0;
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement("SELECT product_price FROM products WHERE product_id =?")) {
        stmt.setInt(1, productId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                price = rs.getDouble("product_price");
            }
        }
    } catch (SQLException s) {
        System.err.println("Database error when fetching product price: " + s.getMessage());
    }
    return price;
}
public static Product getProductById(int productId) {
  Product product = null;
  try (Connection con = DatabaseConnection.getConnection();
      PreparedStatement stmt = con.prepareStatement("SELECT product_name, product_description, product_price, product_quantity FROM products WHERE product_id =?")){  
      stmt.setInt(1,productId);
      try(ResultSet rs= stmt.executeQuery()){
        if (rs.next()){//get details of a given product
          String product_name= rs.getString("product_name");
          String product_description = rs.getString("product_description");
          double product_price= rs.getDouble("product_price");
          int product_quantity= rs.getInt("product_quantity");
          //create a product object and return
          product= new Product(productId, product_name, product_description, product_price, product_quantity);
        }
      }
  }catch(SQLException s){
    System.err.println("Database error when querying product details: " + s.getMessage());
    s.printStackTrace();
  }
  catch (Exception e) {
    System.err.println("Failed to establish a database connection in getProductById() method, ProductManager class. Error: " + e.getMessage());
    e.printStackTrace();
   }  
  return product;
  }
//update stock
//take the order, for each order item take note of id and quantity, subtract quantity from database
public static void updateStock(Order order) throws Exception{
  try (Connection con = DatabaseConnection.getConnection();){
    for (OrderItem item: order.getItems()){
        try(PreparedStatement stmt = con.prepareStatement("SELECT product_quantity FROM products WHERE product_id =?")){
            stmt.setInt(1,item.getProductId());
            try(ResultSet rs= stmt.executeQuery()){
              if(rs.next()){
                int old_Quantity=rs.getInt("product_quantity");
                int new_Quantity= old_Quantity-item.getQuantity();//get the amount of the new quantity
                //use sql to update the quantity of tthe product in that id
                try(PreparedStatement updateStmt = con.prepareStatement("UPDATE products SET product_quantity =? WHERE product_id =?")){
                  updateStmt.setInt(1,new_Quantity);
                  updateStmt.setInt(2,item.getProductId());
                  int affectedRows = updateStmt.executeUpdate();
                  if(affectedRows>0){
                    //only update the product quantity on application after sucessful update on database
                    Product product = getProductById(item.getProductId());
                    product.setQuantity(new_Quantity);
                  }else{
                    throw new SQLException("Updating product quantity failed, no rows affected.");
                  } 
                }catch(SQLException s){
                  System.err.println("Database error when updating product quantity: "+ s.getMessage());
                }    
              }
            }
        }catch(SQLException s){
          System.err.println("Database error when querying product quantity: " + s.getMessage());
        }
    }
  }catch(SQLException s){
    System.err.println("Database error when updating stock: " + s.getMessage()); 
  }
}
}
