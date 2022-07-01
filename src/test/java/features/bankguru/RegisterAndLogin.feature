@registerAndLogin
Feature: Register and Login with registered credentials

  Scenario: As a normal user, I can register email to get userid and password and using these info to login into system
    When Click register link
    And Input email address with "johnnySin123@gmail.com"
    And Click submit button
    Then Get userId
    And Get password
    When Open login page
    And Input userid
    And Input password
    And Click login button
    Then Verify homepage is displayed
