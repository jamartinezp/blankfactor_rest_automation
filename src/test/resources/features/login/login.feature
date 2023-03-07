#created by Jefferson Martinez

Feature: Login as an user

  Scenario Outline: Successful login
    Given that an user wants to login successfully with <email> and <password>
    Then he logs in successfully

    Examples:
      | email              | password   |
      | eve.holt@reqres.in | cityscapes |