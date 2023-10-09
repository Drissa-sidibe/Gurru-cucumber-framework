Feature: Validate Gurru Broker Insurance Website Account Registration
  @Regression
  Scenario: Register Gurru Broker Insurance Website User
    Given User Launches browser
    And opens GuruURL "https://demo.guru99.com/insurance/v1/index.php"
    And User Clicks on Register button
    And User selects user title
    And User enters first name
    And User enters sir name
    And User user phone number
    And User selects birth year
    And User selects birth month
    And User selects birth date
    And User selects licence period
    And User selects occupation
    And User enters street number
    And User enters city name
    And User enters county name
    And User enters post code
    And User enters email
    And User enters password
    And User confirms password
    When User clicks on create button
    Then Validates User views Login Page Text

