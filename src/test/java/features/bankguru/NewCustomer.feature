@newCustomer
Feature: Create new customer

  Background:
    When Input userid
    And Input password
    And Click login button

  Scenario Outline: As a normal user, I can create new customer
    When Click to dynamic "New Customer" link in menu sub
    And Enter to dynamic "name" textbox with value "<Name>"
    And Click to dynamic radio checkbox with value "<Gender>"
    And Enter to dynamic "dob" textbox with value "<BirthDate>"
    And Enter to dynamic "addr" textarea with value "<Address>"
    And Enter to dynamic "city" textbox with value "<City>"
    And Enter to dynamic "state" textbox with value "<State>"
    And Enter to dynamic "pinno" textbox with value "<Pin>"
    And Enter to dynamic "telephoneno" textbox with value "<Telephone>"
    And Enter to dynamic "emailid" textbox with value "<Email>"
    And Enter to dynamic "password" textbox with value "<Password>"
    And Click to dynamic button with value "sub"
    Then Register success message with value "Customer Registered Successfully" is displayed

    Examples:
      | Name      | Gender | BirthDate  | Address           | City   | State     | Pin    | Telephone   | Email                   | Password |
      | NguyenSon | m      | 12-03-1994 | 12 Hoang Hoa Tham | Ha Noi | Long Bien | 123456 | 08933334445 | tomanyeuem123@gmail.com | 123456   |
