Feature:  Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | tomato     |
      | peach      |
      | pear       |
      | kiwi       |
      | watermelon |


  Scenario: List of pet pype I love
    Then I will share my favorites
      | Kagal            |
      | Husky            |
      | Golden Retriever |
      | Golden Doodle    |
      | Dodge            |
      | Delfin           |
      | Sharks           |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane          |
      | surname | Doe           |
      | age     | 29            |
      | address | 29 Washington |
      | state   | CA            |
      | zipCode | 90123         |
      | phone   | 123-123-1234  |

  @dataTable
  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |