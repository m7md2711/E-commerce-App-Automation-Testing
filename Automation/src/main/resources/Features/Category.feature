@smoke
Feature: Category

  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: Logged user could select different Categories

    When user chooses category randomly

    Then user return to the chose category page