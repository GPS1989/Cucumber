Feature: Google Functionality

  Scenario: Validate google search is working 
    Given Browser is open 
    And user is on google search page 
    And user enter text in search box
    And hits enter 
    And user is navigated to the search results
    And Click on the Products and services 
    And Click on the Portfolio Strategy & Business Development 
    And Click on the Generics Intelligence
    And Click on the login menu
    And Click on the Cortellis Generics Intelligence Login
    Then Verify the URL