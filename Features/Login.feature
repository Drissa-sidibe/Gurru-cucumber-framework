Feature: Login with Valid Credentials in Guru Finance

  @Sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://demo.guru99.com/insurance/v1/index.php"
#    When User navigates to Gurru99-Insurance Home Page
    And User enters Email as "hana@gmail.com" and Password as "123password"
    And clicks on Login button
    Then User navigates to Broker Insurance Webpage