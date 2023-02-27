#created by Jefferson Martinez

Feature: Put user
  Scenario Outline: Update an user
    Given that Blank want to update an user with id 3, sending <newName> as new name and <newJob> as new job
    Then he see that an user was updated

    Examples:
      | newName | newJob|
      | example | example |