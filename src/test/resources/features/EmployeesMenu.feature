@wower
Feature: Employees Menu functionality
  Agile story: As a user, I want to access the Employees page.

  Background:
    Given the user is on the login page
    When the user logged in as "HrUser"

  Scenario:
    When the user clicks on the Employees in the menu tab
    Then the user should be able to see following modules
      | Company Structure   |
      | Find Employee       |
      | Telephone Directory |
      | Staff Changes       |
      | Efficiency Report   |
      | Honored Employees   |
      | Birthdays           |
      | New page            |


  Scenario:
    When the user clicks on the Employees in the menu tab
    Then the user should view the Company Structure by default
