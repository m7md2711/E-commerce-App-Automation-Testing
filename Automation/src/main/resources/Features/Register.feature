@smoke
Feature: Register

  Scenario: User could register with valid data

    Given user navigates to home page


    When user pressed on Register link
    And user enters first name
    And user enters last name
    And user enters email address
    And user enters password
    And user enters confirm password
    And user pressed on REGISTER button

    Then display "Your registration completed" message to user
    And user log-in successfully and log-out link appears in the header
    And user pressed on Log-out link
