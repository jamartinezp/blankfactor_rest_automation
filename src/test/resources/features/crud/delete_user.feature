#created by Jefferson Martinez

Feature: Delete user
  Background:
    Given that an user wants to login successfully with eve.holt@reqres.in and cityscapes
    Then he logs in successfully

  Scenario: Delete user by id
    Given that an user wants to delete an user with id 3
    Then he sees that the user was deleted