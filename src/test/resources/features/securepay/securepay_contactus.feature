Feature: As a user I should be able to Search SecurePay website in Google and navigate to Contact us tab and fill the details

  Scenario Outline: Searching SecurePay website in Google and fill the Contact us details
    Given User search for "<SearchText>" on the google page
    And Click on the securePay website
    When Navigates to the contact us page
    And Verifies the contact us page "<Tittle>" is loaded
    Then Fill the Contact us form with random generated data

 	Examples:
	|SearchText|Tittle|
	|SecurePay|Contact SecurePay|

   
