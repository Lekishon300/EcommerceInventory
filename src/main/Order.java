package main;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a customer's order, including customer ID, order ID, and a list of items.
 * Offers functionality to add items to the order, calculate the total order amount,
 * and manage order details. Supports two constructors for flexibility with or without
 * an existing order ID. Useful for integrating order management with customer and
 * product inventory systems.
 */
public class Order {
    private int orderId; 
    private int customerId;
    private List<OrderItem> items = new ArrayList<>();

    // Constructor without orderId, as is auto-generated in the database
    public Order(int customerId) {
        this.customerId = customerId;
    }

    // Constructor including orderId to enable assiging after autogenetaion 
    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    // Adds an item to the order
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // Calculates the total price of the order
    public double calculateTotal() {
        double totalOrderAmount=0.00;
        for(OrderItem item : items){
            double ProductTotal= item.getPrice()*item.getQuantity();
            //System.out.println("For product id: " + item.getProductId()+ " Product Total is : "+ProductTotal);
            totalOrderAmount+=ProductTotal;
        }
        return totalOrderAmount;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
