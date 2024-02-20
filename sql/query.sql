-- Active: 1707935170385@@34.135.143.148@3306@ecommerce
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('John Doe', 'janjohndoe@gmail.com', '123 Elm Street', 'apple123');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Jane Smith', 'janesmith@outlook.com', '456 Oak Avenue', 'banana456');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Michael Brown', 'michaelbrown@hotmail.com', '789 Pine Road', 'cherry789');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Emily Johnson', 'emilyjohnson@gmail.com', '101 Maple Lane', 'date101');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Daniel Williams', 'danielwilliams@school.edu', '202 Birch Drive', 'elderberry202');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Jessica Jones', 'jessicajones@outlook.com', '303 Cedar Place', 'fig303');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Christopher Davis', 'christopherdavis@hotmail.com', '404 Spruce Court', 'grape404');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Amanda Wilson', 'amandawilson@gmail.com', '505 Redwood Boulevard', 'honeydew505');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Joshua Martinez', 'joshuamartinez@school.edu', '606 Willow Way', 'kiwi606');
INSERT INTO customers (customer_name, email, street_address, password) VALUES ('Sophia Anderson', 'sophiaanderson@outlook.com', '707 Cherry Street', 'lemon707');

INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Smartphone', 'Latest model with high-resolution camera and long-lasting battery', 999.99, 150);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Laptop', 'Lightweight laptop with 16GB RAM, 512GB SSD, and a 4K display', 1299.99, 75);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Bluetooth Headphones', 'Noise-cancelling over-ear headphones with 20 hours of battery life', 199.99, 200);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Smartwatch', 'Water-resistant smartwatch with fitness tracking and notifications', 299.99, 120);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('E-Reader', 'Lightweight e-reader with a high-resolution, glare-free display', 129.99, 90);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Gaming Console', 'Next-gen console with 8K support and 1TB storage', 499.99, 60);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Tablet', '10-inch tablet with stylus support and high-speed internet connectivity', 599.99, 110);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Wireless Charger', 'Fast-charging wireless charger compatible with all devices', 59.99, 300);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('External Hard Drive', '2TB USB 3.0 external hard drive for high-speed data transfers', 89.99, 150);
INSERT INTO products (product_name, product_description, product_price, product_quantity) VALUES ('Action Camera', '4K action camera with waterproof casing and image stabilization', 249.99, 85);


SELECT product_id,product_name,product_quantity FROM products

SELECT customer_id,customer_name FROM customers

select order_id,customer_id,order_amount FROM orders

select order_item_id,order_id,product_id,item_quantity FROM order_items

SELECT product_id,product_name,product_quantity FROM products