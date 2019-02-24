# Meal Preperation Application

### Problem Statement
My application aims to reduce stress, lower grocery cost, and eliminate food waste while promoting healthier eating habits.  My focus group will aim to help single people, couples, and families.
My fiance and I have developed a system for meal planning and grocery shopping that is extremely efficient and allows us to eat healthy foods all week.
Meals are chosen for the week, combined, then ingredients are pulled from the recipes to make a grocery list.
Meals are then placed in a weekly calendar and assigned to a person to cook.

### Project Technologies/Techniques
* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/add/delete/edit/view of all data
  * User role: create/add/delete/edit/view to grocery list, recipes, calendar or view grocery list, recipes, calendar
  * All: anyone can view sample lists (no login)  
* Database
  * MySQL
  * Store users and roles
  * Store all data for the recipes, grocery lists, and dates for calendar
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * TBD
* CSS 
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * Continuous Integration tools in AWS
  * Materialize
  * Amazon Rekognition
  * Google calendar API
  * Apple calendar API
  * Optical Character Recognition
  * Figure out how to read files of purchased amazon recipe books.
  * Hibernate Validation
  * Hibernate Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA