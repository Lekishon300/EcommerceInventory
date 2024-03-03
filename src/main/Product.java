package main;
/**
 * Represents a product in the order system, encapsulating product details
 * such as ID, name, description, price, and available stock quantity. Provides
 * constructors for initializing product objects and getters/setters for managing
 * product attributes, enabling easy access and modification of product information.
 */
public class Product {
  private int productId;
  private String name;
  private String description;
  private double price;
  private int quantity; // Available stock quantity

  // Constructor
  public Product(int productId, String name, String description, double price, int quantity) {
      this.productId = productId;
      this.name = name;
      this.description = description;
      this.price = price;
      this.quantity = quantity;
  }

  // Getters and setters
  public int getProductId() {
      return productId;
  }

  public void setProductId(int productId) {
      this.productId = productId;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public double getPrice() {
      return price;
  }

  public void setPrice(double price) {
      this.price = price;
  }

  public int getQuantity() {
      return quantity;
  }

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }
}

