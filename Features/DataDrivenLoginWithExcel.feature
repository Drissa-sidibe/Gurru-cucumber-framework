Feature: Login with Valid Credentials in Guru Finance


  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://demo.guru99.com/insurance/v1/index.php"
    And User enters Email and Password with excel "<index-rows>"
    And User clicks on Login button
    Then User navigates to Broker Insurance
    Examples:
   |index-rows|
   |1         |
   |2         |
   |3         |
