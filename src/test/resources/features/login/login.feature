#created by Jefferson Martinez

Feature: Login as an user

  Scenario Outline: Successful login
    Given that Blank want to login successfully with <email> and <password>
    Then he login successfully

    Examples:
      | email              | password   |
      | eve.holt@reqres.in | cityscapes |