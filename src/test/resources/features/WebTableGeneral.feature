Feature: Some of the general functionality verifications


  Scenario: Dropdown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |


  Scenario: Payment options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Visa ad enabled payment option
    Then user sees MasterCard ad enabled payment option
    Then user sees AmericanExpress ad enabled payment option


  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customer name "Bob Martin"
    And user enters street "22, West Ave"
    And user enters city "New York"
    And user enters state "New York"
    And user enters zip "11368"
    And user selects payment option "Visa"
    And user enters credit card number "3333222211112222"
    And user enters expiration date "06/24"
    And user clicks to process order button
    Then user should see "Bob Martin" in the row of the web table

  @wip3
  Scenario Outline: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects payment option "<paymentType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiration date "<expDate>"
    And user clicks to process order button
    Then user should see "<expectedName>" in the row of the web table

    Examples:
      | quantity | customerName   | street       | city      | state | zip   | paymentType | cardNumber       | expDate | expectedName   |
      | 2        | Bob Martin     | 22, West Ave | New York  | NY    | 11365 | Visa        | 3333222211112222 | 06/24   | Bob Martin     |
      | 2        | Samuel Jackson | 13 Owl St    | Starberry | UT    | 53665 | MasterCard  | 555743242342     | 03/25   | Samuel Jackson |
      | 2        | Ned Stark      | 13 Owl St    | Starberry | UT    | 53665 | MasterCard  | 555743242342     | 03/25   | Ned Stark      |
      | 2        | Alexandra Gray | 13 Owl St    | Starberry | UT    | 53665 | MasterCard  | 555743242342     | 03/25   | Alexandra Gray |
     # | 2        | Stewart Dawidson | 13 Owl St | Starberry | UT    | 53665 | MasterCard  | 555743242342 | 03/25   | Stewart Dawidson |
    #  | 2        | Robert Baratheon | 13 Owl St | Starberry | UT    | 53665 | MasterCard  | 555743242342 | 03/25   | Robert Baratheon |
   #   | 2        | Bart Fisher      | 13 Owl St | Starberry | UT    | 53665 | MasterCard  | 555743242342 | 03/25   | Bart Fisher      |
    #  | 2        | John Doe         | 13 Owl St | Starberry | UT    | 53665 | MasterCard  | 555743242342 | 03/25   | John Doe         |






