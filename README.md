# E-commerce Automation Framework

## Overview
This project is a Selenium WebDriver automation framework using the Page Object Model (POM) design pattern with TestNG for testing.  
It automates the end-to-end testing of an e-commerce application, covering login, product selection, cart verification, checkout, and order confirmation.

## Features
- Automated tests for login functionality with valid and invalid users  
- Product selection and cart validation  
- Checkout process automation  
- TestNG framework integration for structured test execution and reporting  
- Data-driven testing using TestNG DataProviders  
- Maven-based project for easy build and dependency management

## Technologies Used
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Object Model (POM) design pattern

## Project Structure
src/
├── main/java/PageObjects # Page Object classes for UI elements and actions
├── test/java/Tests # Test classes implementing test scenarios
├── test/java/TestComponents # Test base and utility classes
├── main/resources # Configuration files (e.g., properties)
target/ # Compiled classes and build output (ignored in Git)
test-output/ # TestNG reports (ignored in Git)


## Setup Instructions
1. Clone the repository:  
   `git clone https://github.com/UdayKumar-sb/E-commerce-Project.git`  
2. Open the project in your favorite IDE (e.g., Eclipse, IntelliJ).  
3. Make sure you have Java and Maven installed.  
4. Run `mvn clean test` to build and execute the tests.

## How to Run Tests
- Tests are managed via TestNG XML suites located in the `TestSuites` folder.  
- Use your IDE’s TestNG runner or execute via Maven command line:  
  `mvn test -DsuiteXmlFile=TestSuites/testng.xml`

## Contact
For questions or suggestions, feel free to reach me at:  
**Email:** imudayuk@gmail.com  
**GitHub:** [UdayKumar-sb](https://github.com/UdayKumar-sb)


