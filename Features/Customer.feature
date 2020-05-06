Feature: Customer

  Background: Login step
    Given User open chrome browser
    When User open url "https://admin-demo.nopcommerce.com"
    And User enter email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard

  Scenario: Add new customer
    When User click on customers menu
    And click on customers
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser

  Scenario: Search Customer by Email
    When User click on customers menu
    And click on customers
    And enter customer email
    When Click on search button
    Then User should found email in the search table
    And close browser

  Scenario: Search Customer by Name
    When User click on customers menu
    And click on customers
    And enter first name
    And enter last name
    When Click on search button
    Then User should found name in the search table
    And close browser



