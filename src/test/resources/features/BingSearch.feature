Feature: Bing search functionality
  Agile story: As a user, when I am on the Bing search page
  I should be able to search anything and see relevant results

  Scenario: Search page default title verification
    When user is on Bing search page
    Then user should see title is Bing

  Scenario: Search result Title verification
       Given user is on Bing search page
       When user search for orange
       Then user should see orange in the title

  Scenario: Search result Title verification
    Given user is on Bing search page
    When user enters Tesla in the Bing search box
    Then user should see Tesla in the title

  Scenario: Search result Title verification
    Given user is on Bing search page
    When user enters Toyota Highlander in the Bing search box
    Then user should see Toyota Highlander in the title

  Scenario: Search result Title verification
    Given user is on Bing search page
    When user enters "BMW cars" in the Bing search box
    Then user should see "BMW cars" in the title