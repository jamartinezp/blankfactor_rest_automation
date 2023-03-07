#created by Jefferson Martinez

Feature: Test login

  Background: Login
    Given that an user wants to login successfully with eve.holt@reqres.in and cityscapes
    Then he logs in successfully

  Scenario: Test login creating a get request asking for all users
    Given that an user wants to see all users in the system
    Then he can see all users
