@Customers
Feature:Customers

  Background: Below are the common steps for each scenario
    Given User Launch Firefox Browser
    When  User open URL "http://admin-demo.nopcommerce.com/login"
    And   User enters Email as "admin@yourstore.com" and Password as "admin"
    And   Click on Login
    Then  User can view Dasboard

 @Sanity
  Scenario: Add a New Customer
    When  User click on customers Menu
    And   Click on Customers menu item
    And   Click on Add new button
    Then  User can view Add new customer page
    When  User enter customer info
    And   Click on Save button
    Then  User can view confirmation message "The new customer has been added successfully."
    And   Close browser

 @Regression
  Scenario: Search customer by E-mailId
    When User click on customers Menu
    And  Click on Customers menu item
    And  Enter customer e-mail
    When click on search button
    Then user should find E-mail in search table
    And  Close browser

  @Regression
  Scenario: Search customer by Name
    When User click on customers Menu
    And  Click on Customers menu item
    And  Enter customer FirstName
    And  Enter customer LastName
    When click on search button
    Then user should find Name in search table
    And  Close browser

