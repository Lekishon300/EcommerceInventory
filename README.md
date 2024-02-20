## Ecommerce Order App

## Overview
**Ecommerce Order App** is a Command Line-based Order Management System developed in Java, leveraging SQL for its database functionalities. It utilizes the JDBC API for database connectivity, ensuring efficient data management and operations.

This application can be used by customers to place their orders.

The aplication also manages stock levels for the store employees.

## Features
The application does the following:

* [✓] User Authentication: Allows customers to log in using their email and password to access their accounts and manage orders.
* [✓] Product Browsing: Enables customers to view all available products.
* [✓] Order Management: Customers can add items to their orders, with real-time validation for product ID and stock availability.
* [✓] Dynamic Order Summary: Displays the number of items in the current order and the total order cost, providing clarity to customers.
* [✓] Stock Management: Automatically updates the stock levels upon order completion, maintaining accurate inventory records.
* [✓] Application Exit: Offers the option to exit the app without placing an order, ensuring user flexibility.
  
## App Screenshots
Here's are screenshots of implemented features:(each screenshot has description on top)

Note the initial product quantity for product id 8 and 10, 8 is 300 while 10 is 85

<img src='screenshots/Screenshot (249).png' title='Video Walkthrough' width='400' height='300' alt='Video Walkthrough' />

Sucessful login - check sql/query.sql file for customer Jessica Jones credentials

<img src='screenshots/Screenshot (250).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />


<img src='screenshots/Screenshot (251).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />
<img src='screenshots/Screenshot (252).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />
<img src='screenshots\Screenshot (253).png' title='Video Walkthrough' width='' alt='Video Walkthrough' />
<img src='screenshots/Screenshot (254).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />
<img src='screenshots/Screenshot (255).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />
<img src='screenshots/Screenshot (256).png' title='Video Walkthrough' width='400' height='400' alt='Video Walkthrough' />

## Database ERD diagram

## Dependencies
* <a href="https://www.oracle.com/java/technologies/downloads/" target="_blank">Java Development Kit (JDK)</a>: Required to compile and run the Java application.
* <a href="https://www.oracle.com/mysql/what-is-mysql/" target="_blank">MySQL Database</a>: Utilized for storing and managing customer, product, and order data.
* <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/" target="_blank">JDBC</a>: Java Database Connectivity for database interactions.

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
