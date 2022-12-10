@smoke
Feature: Color

  Background: user has account
    Given user had an actual account
    And open home page again

  Scenario: Logged user could filter with color

    When user chooses Category and hover to open sub-Category

    And user can filter sub-Category with color

    Then user will find product with the selected color
