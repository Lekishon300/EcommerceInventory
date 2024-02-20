-- Active: 1707935170385@@34.135.143.148@3306@ecommerce
CREATE TABLE customers(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(100),
email VARCHAR(50),
street_address VARCHAR(150)
);
ALTER TABLE customers
ADD COLUMN password VARCHAR(50);

CREATE TABLE products(
  product_id INT AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR(50),
  product_description VARCHAR(300),
  product_price DECIMAL(10, 2),
  product_quantity INT
)

CREATE TABLE orders (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  order_amount DOUBLE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items(
  order_item_id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT,
  product_id INT,
  item_quantity INT,
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
)
