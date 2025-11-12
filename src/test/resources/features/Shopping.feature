@Shopping
Feature: Order and remove items

  Scenario: Ordering and removing items from the shopping cart.
    Given The user is on a new browser
    And The user navigates to the website
    When The user enters valid username
    And The user enters valid password
    And The user clicks on the login button
    Then The user should see the products page
    When The user sorts the items by Price low to high
    And The user selects the bike light item
    And The user adds the bike light item to cart
    And The user goes back to the inventory items page
    And The user selects the fleece jacket
    And The user adds the fleece jacket to cart
    And The user navigates into the shopping cart
    And The user remove fleece jacket from the cart
    And The user selects All Items
    Then The user should be redirected to the products page
    When The user navigates back into the shopping cart
    And The user proceeds to checkout
    And The user enters valid credentials
    And The user clicks on continue
    And The user verifies the tax is $0.80
    And The user clicks on finish
    Then The user should be shown a success message