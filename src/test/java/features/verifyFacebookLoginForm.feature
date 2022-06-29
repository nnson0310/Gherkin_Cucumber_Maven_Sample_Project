@login_form
Feature: Login Form

  Scenario: Verify that login form is displayed
    Given Open facebook url
    When Input valid email with "tomanyeuem@gmail.com"
    And Input valid password with "123456"
    Then Login successfully
    Then Close application

  Scenario Outline: Verify that "forgotten password" page is displayed
    Given Open facebook url
    And Click Forgot Password link
    When Input invalid emailAddress
    | emailAddress |
    | <emailAddress> |
    And Click search button
    Then "No search results" message is displayed
    Then Close application

    Examples:
      | emailAddress |
      | dit$$$$@gmail.com |
      | emla8888888@gmail.com |
      | jz1224332@gmail.com |
