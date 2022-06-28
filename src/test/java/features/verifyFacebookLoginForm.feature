@displayed
Feature: Login Form
  Scenario: Verify that login form is displayed
    Given Open facebook url
    And Input valid email or username
    And Input valid password
    Then Login successfully
    Then Close application