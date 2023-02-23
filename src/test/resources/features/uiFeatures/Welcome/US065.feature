Feature: US065
  @UI
  @US065

  Scenario:
    Given User goes to "https://test.urbanicfarm.com"
    Given User goes to login button and click
    When User goes to e mail box and write address
    Then User goes to password box and writes password
    And User clicks Submit button
    When User verifies welcome page is displayed
    Then User verifies a list of sellers under the heading local sellers near you
    And User is able to choose any seller
    Then User verifies Products are listed in separate sections
   Then User verifies Product quantity icons plus minus are clickable
    Then User verifies add to Cart button is clickable
    When User clicks on the add to Cart button
    Then User verifies the product is added to the cart.
    Then User verifies "added to your basket!" warning is displayed

 #Welcome Page-Orders
 # A list of sellers should appear under the heading Local sellers near you.
 # Any seller should be able to choose
 # Products should be seen listed in separate sections
 # Product quantity icons (+ -) must be functional
 # Add to Cart button must be functional
#the Add to Cart button is clicked, the product should be added to the cart.
# ..... added to your basket! warning should appear