#created by Jefferson Martinez

Feature: Delete user
  Scenario: Delete user by id
    Given that Blank want to delete an user with id 3
    Then he sees that the user was deleted