
@runTheTest
Feature: As a user
  I want to nagivate to gmail.com
  to login to the account



  Scenario Outline: Verify User is  not logged in
    Given I navigate to Gmail site with browser <browserName>
    Then I should see the message 'Sign in to continue to Gmail'

    Examples:
    |browserName|
    |Firefox    |
    |IE         |


  Scenario Outline: Login with valid credentials
    Given I navigate to Gmail site with browser <browserName>
     When I enter username as 'kaplantesters'
     And I click the Next button
     And I enter password as 'Kaplan2015'
     And I click on Sign In button
     Then I should be see 'kaplantesters@gmail.com'
     Then I should be able to SignOut

    Examples:
    |browserName|
    |Firefox    |
    |IE         |



   Scenario Outline: Attempt login without credentials
     Given I navigate to Gmail site with browser <browserName>
     When I click the Next button
     Then I should see an error message 'Please enter your email.'

     Examples:
     |browserName|
     |Firefox    |
     |IE         |




