Feature: Login with Valid Credentials in Guru Finance


  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://demo.guru99.com/insurance/v1/index.php"
    And User enters Email as "<email>" and Password as "<password>"
    And clicks on Login button
    Then User navigates to Broker Insurance

   Examples:
    |email           |password   |
    |han@gmail.com   |123password|
    |hana@gmail.com  |123password|
#    |han@gmail.com   |password000|
