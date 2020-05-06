Feature: Login

  Scenario: Login with valid credential
    Given User open chrome browser
    When User open url "https://admin-demo.nopcommerce.com/"
    And User enter email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page Title should be "Your store. Login"
    And close browser