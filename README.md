## Table of Contents
- [Our RoadMap/Journey](#our-roadmapjourney)
- [Introduction](#introduction)
- [Getting Started](#getting-started)
 - [Prerequisites](#prerequisites)
 - [Installation](#installation)
 - [Quick-Start Guide](#quick-start-guide)
 - [User Guide](#user-guide)
- [Developer Documentation](#developer-documentation)
- [UML Diagram](#uml-diagram)
- [Credits](#credits)
- [Acknowledgement](#acknowledgement)

## Our RoadMap/Journey

- Beginning (Days 1 & 2): We kicked off our journey with team introductions, task coordination, 
and setting up a Git repository. Clear project outlines and a detailed ReadMe file laid the foundation for what lay ahead.

- Planning to Execution (Days 3 & 4): Transitioning into implementation, we crafted a UML diagram and based on that we
started Coding & Run Application

- Fix/Debug Errors (Day 5): We addressed errors, added aesthetic ANSI colors, and conducted thorough code refactoring. 

# DELI-Dose Sales Application
 
## Introduction

Welcome to the DELI-DOSE Sales Application!
This project seeks to simplify and enhance the ordering process for our unique sandwich shop, DELI-Dose.
This app is built to manage sandwich orders, giving customers the freedom to customize their sandwiches with various sizes, 
select their favorite bread, add regular and premium toppings, choose to toast their sandwich, and include drinks and chips in their order.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- Git - For cloning the repository and merging each other changes.

### Installation

Intelli J
- git clone https://github.com/AlexisS05/deli-dose.git

## User Guide

### Quick-Start Guide

1. **Run the program.**
 - Open your terminal or command prompt.
 - Navigate to the project directory:
   ```bash
   cd /c/pluralsight/Deli-Fork/deli-dose
   ```
 - Compile the Java files:
   ```bash
   javac src/main/java/com/pluralsight/main/Main.java
   ```
 - Run the program:
   ```bash
   java com.pluralsight.main.Main
   ```

2. **Follow on-screen instructions to navigate.**
 - Use the keyboard to interact with the command-line interface.
 - Follow the prompts and instructions displayed on the screen.

3. **Customize your sandwich order.**
 - Choose your preferred bread type, sandwich size, and customize toppings.
 - Follow the prompts to add sides and drinks to your order.

4. **Confirm your order at the checkout.**
 - Review your order details.
 - Confirm your order to complete the process.

### Ordering Process

- Customers can choose sandwiches in three sizes: 4", 8", and 12".
- Bread options include white, wheat, rye, or wrap.
- Regular Toppings are available, it includes meats, cheeses and other toppings.
- Customers have the option to request extra toppings.
- Each sandwich can be toasted according to the customer's preference.
- Customers can place orders with one or more sandwiches.
- Orders guide customers to customize each sandwich individually.
- Customers can include drinks and chips in their order.


### Order Confirmation and Receipt

- Customers are guided to personalize each sandwich individually during the ordering process.
- Once the order is finalized, the application presents a summary, showcasing the sandwich choices along with selected toppings.
- The order confirmation screen indicates the overall cost of the entire order.
- Successfully placed orders are stored in a designated "receipts" folder.


## Developer Documentation

### Project Structure

The project follows a simple package structure:

- `com.pluralsight.main`: Main application logic
- `com.pluralsight.order`: Order-related classes
- `com.pluralsight.ui`: User interface components
- `com.pluralsight.utils`: Utility classes

### Class Overview

- `Main`: Entry point for the application.
- `UserInterface`: Manages the user interface and order process.
- `Order`: Represents an order and manages items.
- `OrderItem`: Interface for order items.
- `OrderFileManager`: Manages saving order details to a text file.
- Various Enums: Representing bread types, sandwich sizes, toppings, etc.

### Software Architecture 

Our software architecture is made up of enums, which are essentially what constructs our sandwich. 
It has all the toppings, such as various meats and includes our sides. However, our sandwich could not be constructed without the enums.


### Screenshots 
<img src = "https://github.com/AlexisS05/deli-dose/blob/main/ScreenShots/WelcomeScreen.jpg" >
<img src = "https://github.com/AlexisS05/deli-dose/blob/main/ScreenShots/Ordering.jpg" >
<img src = "https://github.com/AlexisS05/deli-dose/blob/main/ScreenShots/Receipt.jpg" >


## UML Diagram 

![UML Diagram](https://github.com/SleamanAbdelhadi/deli-dose/assets/147070134/b904a3e0-99ab-4560-aa74-d2e7b2eafba5)

## Credits
 - Alex (Leading the group)
 - Google 
 - Stack OverFlow
 - ChatGPT (Receipt)
 - Lucid Chart (Tools to develop UML Diagram)

## Acknowledgement

We acknowledge each and every individual in the group for their contributions.  
Deli-Dose by Alex, Kerry, Sleaman, Preen 

## Notes

- This README serves as a guide to understanding and contributing to the project.
- However, improvements can be made on code/refactoring. Stay tuned for more updates.