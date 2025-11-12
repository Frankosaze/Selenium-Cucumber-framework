@Backpack
Feature: Buy the Backpack

  Scenario: Buy the Backpack and Assert it Has Been Ordered
    Given The user is on the homepage
    When The user enters username
    And The user enters password
    And The user click on the login button
    Then The user should see the inventory items
    Then The user select the backpack item
    And The user adds the item to cart
    Then The user navigates to the shopping cart
    And The user proceed to checkout
    Then The user provides valid credentials
    And The user click on continue
    And The user click on finish
    Then The user should see a success message

