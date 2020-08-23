#Author: dhanyakrishna99@gmail.com

Feature: Automation Challenge
 
  Scenario: Use Case
    Given I have launch URL
    When I click on LearnMore button
    And Scroll down and navigate to Singapore on the left panel
    Then I Read and write the table in excel sheet  
    And I click on 'About' tab in header
    And I Navigate to Who we are tab
    And I Navigate to OurAwards & Accolades
    Then I validate the total number of awards displayed on the page is 22
    And I validate all the award name and caption of the awards 


