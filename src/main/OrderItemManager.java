package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manages order item operations, including validating product IDs and quantities,
 * and saving orders and order items to the database. Provides methods to check the
 * availability of requested products and to persist order details, ensuring product
 * quantities are sufficient and order information is accurately recorded.
 */
public class OrderItemManager {
/**
 * Checks if the specified product ID is valid and if the requested quantity is available.
 *
 * @param product_Id    the ID of the product to check.
 * @param item_Quantity the quantity of the product requested.
 * @param customer_Id   the ID of the customer making the request.
 * @return              true if the product ID is valid and the requested quantity is available; false otherwise.
 */
  public static boolean IDQtIsValid(int product_Id,int item_Quantity,int customer_Id){
    boolean isValid=false;
    Connection con = null;
    try{
      con = DatabaseConnection.getConnection();
    }catch(Exception e){
      System.out.println("No connection!!!!!!!!!!");
      e.printStackTrace();
    }
    
     try{
      if (con!= null){
        String query = "Select * from products where product_id=?";//how can i handle when the id can not be found
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, product_Id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
        String Product_Name= rs.getString("product_name");
        int Product_Id = rs.getInt("product_id");
        int product_Quantity= rs.getInt("product_quantity");
        double product_price= rs.getInt("product_price");
          if(product_Quantity>=item_Quantity && Product_Id!=-1){
            isValid = true;
            System.out.println("Product ID    Product Name      Price per item   Item Quantity");
            System.out.println(Product_Id + "   "+ Product_Name +"    "+ product_price+ "   " +item_Quantity);
          }
        }
     }else{
      System.out.println("Result set has nothing inside!");
   }
  }catch(SQLException s){
    System.out.println("Check your SQL syntax");
    s.printStackTrace();
    }
    return isValid;
  }
/**
 * Saves an order to the database. This method first inserts the order into the orders table,
 * including the customer ID and the total order amount, and retrieves the generated order ID.
 * It then iterates through each item in the order, inserting them into the order_items table
 * with the newly obtained order ID, product ID, and item quantity.
 * 
 * @param customer_Id the ID of the customer placing the order.
 * @param order       the Order object containing the order details to be saved.
 */
  public static void saveOrder(int customer_Id,Order order ){
    Connection con = null;
    try {
        con = DatabaseConnection.getConnection();
    } catch (Exception e) {
        System.err.println("Failed to establish a database connection in saveOrder method. Error: " + e.getMessage());
        e.printStackTrace();
    }
    if(con!=null){
      String query= "INSERT INTO orders (customer_id,order_amount) VALUES (?,?)";
      try{
      PreparedStatement st= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      st.setInt(1, customer_Id);
      st.setDouble(2, order.calculateTotal());

      int affectedRows= st.executeUpdate();
      if(affectedRows>0) { 
        ResultSet keys = st.getGeneratedKeys();
          if(keys.next()){
            order.setOrderId(keys.getInt(1));
          }else{
            throw new SQLException("Creating order failed, no order ID obtained.");
        }
      }     
      }catch(SQLException s){
        System.out.println("Database error on saving order.");
        s.printStackTrace();
      }

    }
//save item to order item table
    for (OrderItem item: order.getItems()){//add each item to orderitem table
      //order_item_id PK-autogen
      //order_id FK from order
      //product_id FK from order.productid
      //item_quantity from itemquantity

      if(con!=null){
        String query= "INSERT INTO order_items (order_id,product_id,item_quantity) VALUES (?,?,?)";
        try{
        PreparedStatement st= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, order.getOrderId());
        st.setInt(2, item.getProductId());
        st.setInt(3, item.getQuantity());
  
        int affectedRows= st.executeUpdate();
        if(affectedRows>0) { 
          ResultSet keys = st.getGeneratedKeys();
            if(keys.next()){
              item.setItemId(keys.getInt(1));//now that the item is added to db, retrieve it's id
            }else{
              throw new SQLException("Creating order failed, no item ID obtained.");
          }
        }     
        }catch(SQLException s){
          System.out.println("Database error on saving order item.");
          s.printStackTrace();
        }  
      }
    }    
  }
}
