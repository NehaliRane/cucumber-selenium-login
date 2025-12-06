Feature: Login feature

  Background:
    Given the user navigates to the login page

  @smoke
  Scenario: Valid Login
    When the user enters username "tomsmith" and password "SuperSecretPassword!"
    Then the user should be successfully logged in and see the Secure Area page

  Scenario: Invalid Login
    When the user enters username "wrongusername" and password "wrongpassword"
    Then the user should see an error message "Your username is invalid!"

  Scenario: Empty Fields
    When the user enters username "" and password ""
    Then the user should see "This field is required" for both fields
