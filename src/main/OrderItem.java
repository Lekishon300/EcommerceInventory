package main;

public class OrderItem {
  private int productId;
  private int itemId;
  private int quantity;
  private double price;

  // Constructor
  public OrderItem(int productId, int quantity, double price) {
      this.productId = productId;
      this.quantity = quantity;
      this.price = price;
  }
  public OrderItem(int productId, int itemId, int quantity, double price) {
    this.productId = productId;
    this.itemId=itemId;
    this.quantity = quantity;
    this.price = price;
}

  // Getters
  public int getProductId() {
      return productId;
  }
  public int getItemId(){
    return itemId;
  }

  public int getQuantity() {
      return quantity;
  }

  public double getPrice() {
      return price;
  }

  // Setters
  public void setProductId(int productId) {
      this.productId = productId;
  }
  public void setItemId(int itemId) {
    this.itemId = itemId;
}

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }

  public void setPrice(double price) {
      this.price = price;
  }
}
