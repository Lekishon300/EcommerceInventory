package main;
import java.util.Scanner;
import main.CustomerManager;
import main.ProductManager;
import main.OrderItemManager;
import main.OrderItem;
/**
 * The App class serves as the main entry point for a console-based store or e-commerce system application,
 * facilitating user interactions for order management. It allows users to authenticate themselves using their
 * email and password, view available products, add items to an order based on product ID and quantity, and 
 * conclude their order by calculating the total amount due. The application integrates with CustomerManager,
 * ProductManager, and OrderItemManager to manage customer information, product details, and order items 
 * respectively.
 * 
 * The user flow involves:
 * - Authenticating the user and creating a new order associated with their customer ID.
 * - Displaying all available products.
 * - Allowing the user to add products to their order by specifying product IDs and quantities, with validation checks for product existence and stock availability.
 * - Completing the order process by showing the order total and thanking the user, updating the stock accordingly, and saving the order details to the database.
 * - Providing options to either add more items, end the order, or exit the application.
 */
public class App {
   public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);

    System.out.println("Enter your email adress");
    String email="";
    if(sc.hasNext()){
       email = sc.next();
    }
    System.out.println("Enter password");
    String password= sc.next();
    try{
        int Customer_Id = CustomerManager.getCustomerId(email,password);
        //System.out.println("Your id is: "+Customer_Id);
            if (Customer_Id ==-1){
                System.out.println("Enter correct email and password or Create account.");
            }else{
                Order order = new Order(Customer_Id);
                ProductManager.getAllProducts();
                //boolean running= true;
                while(true){
                    System.out.println("Choose an option:");
                    System.out.println("1. Add to order");
                    System.out.println("2. End order");
                    System.out.println("3. Exit");

                    int choice = sc.nextInt();
                    switch(choice){
                        case 1:
                        System.out.println("Enter Product ID");
                        int Product_Id=-1;
                        if(sc.hasNextInt()){
                            Product_Id=sc.nextInt();
                            System.out.println("How many of item " + Product_Id + " would you like?");
                            int Item_Quantity=0;
                            if(sc.hasNextInt()){
                                Item_Quantity=sc.nextInt();
                            }
                            // must check that the id is valid, check quantity too
                            boolean IdQtValid = OrderItemManager.IDQtIsValid(Product_Id, Item_Quantity,Customer_Id);
                            if(IdQtValid==true){
                                double price = ProductManager.fetchProductPrice(Product_Id);
                                OrderItem item = new OrderItem(Product_Id, Item_Quantity, price);//make an item
                                order.addItem(item);//add item to the orderlist
                                System.out.println("Number of items in the order so far: "+ order.getItems().size());
                                
                                System.out.println("Adding to order...");
                            }else{
                                System.out.println("Invalid product ID or insufficient stock.");
                            }
                            break;
                        }
                        case 2:
                        double amt= order.calculateTotal();
                        if(amt == 0.0){
                            System.out.println("Your oder total is: " +amt);//put total here
                            System.out.println("No order placed. Exiting the application.");
                            
                        }else{
                            System.out.println("Your oder total is: " +amt);//put total here
                            System.out.println("Thank you for your order. Exiting the application.");
                        }
                        //save order to database and update stock
                        if(!order.getItems().isEmpty()){
                            OrderItemManager.saveOrder(Customer_Id, order);
                            ProductManager.updateStock(order);//update stock

                        }
                        return;

                        case 3:
                        System.out.println("Exiting. Thank you for using our service!");
                        return;

                        default:
                         System.out.println("Invalid option, please try again.");
                        break;
                    }
                }

            }
    }catch(Exception e){
      e.printStackTrace();
    }    
    finally{
        if (sc != null) {
            sc.close(); 
        }
  } 
  } 
}
