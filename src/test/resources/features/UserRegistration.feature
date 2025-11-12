@UserRegistration
Feature:  Registration functionality

  Scenario: Valid User Registration
    Given The user is on the registration page
    When The user enters valid registration details
    Then The user should be registered successfully