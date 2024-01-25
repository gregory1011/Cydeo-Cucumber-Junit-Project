Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search anything and see relevant results

  Scenario: Search page default title verification
    When user is on Google search page
    Then user should see title is Google

    # command + option + L


    Scenario: Search result Title verification
      Given user is on Google search page
      When user search for Apple
      Then user should see Apple in the title