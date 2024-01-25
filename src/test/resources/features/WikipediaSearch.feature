@wiki
Feature: Wikipedia search functionality


  Scenario: Search result Title verification
    Given User is on Wikipedia page
    When User enters "Steve Jobs" in search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in the tile


  Scenario: Search functionality Header verification
    Given User is on Wikipedia page
    When User enters "Steve Jobs" in search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in main header

  Scenario: Search functionality Image Header verification
    Given User is on Wikipedia page
    When User enters "Steve Jobs" in search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" is in the image header

  @scenario_Outline
  Scenario Outline: Wikipedia search Functionality with Scenario Outline
    Given User is on Wikipedia page
    When User enters "<searchValue>" in search box
    And User clicks wiki search button
    Then User should see "<expectedTitle>" in the tile
    Then User should see "<expectedMainHeader>" in main header
    Then User should see "<expectedImageHeader>" is in the image header

    Examples: search value we are going to using in this scenarios outlines
      | searchValue   | expectedTitle | expectedMainHeader | expectedImageHeader |
      | Steve Jobs    | Steve Jobs    | Steve Jobs         | Steve Jobs          |
      | Bruce Lee     | Bruce Lee     | Bruce Lee          | Bruce Lee           |
      | Gerard Butler | Gerard Butler | Gerard Butler      | Gerard Butler       |
      | Donald Trump  | Donald Trump  | Donald Trump       | Donald Trump        |
      | John Cena     | John Cena     | John Cena          | John Cena           |
      | Barack Obama  | Barack Obama  | Barack Obama       | Barack Obama        |


