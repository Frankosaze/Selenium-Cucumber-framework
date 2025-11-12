@OrangeHRM
Feature: Human Resource Management and Recruitment

  Scenario: Candidate Submission Functionality
    Given the user is on the login page
    When the user input valid username
    And the user input valid password
    And the user clicks on login
    And the user clicks on recruitment
    And the user clicks on add
    And the user input a candidate details
    And the user consent the data and save
    And the user shortlist the candidate
    And the user adds note
    And the user clicks save
    Then the user should get a success message

