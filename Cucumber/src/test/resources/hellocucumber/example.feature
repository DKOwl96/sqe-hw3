Feature: A set of scenarios for testing the "example" module

  Scenario: A user comments on product
    Given the user logged in
    And the user in the home page
    And the user navigates to the product page he wants to comment on
    When the user clicks on "write your review" button
    Then message will be shown 'Review sent'

  Scenario: An admin disables the commenting
    Given the admin logged in
    And the admin in his home page - dashboard
    And the admin navigates to "Product Comments" module
    When the admin disable the module
    Then click on 'Yes, disable it'

  Scenario: An admin disables the commenting while user is commenting
    Given the admin logged in
    And the admin in his home page - dashboard
    And the admin navigates to "Product Comments" module
    And the user logged in
    And the user in the home page
    And the user navigates to the product page he wants to comment on
    And the user clicks on "write your review" button
    And the admin disable the module
    When the user submit the review
    Then error message should pop up
