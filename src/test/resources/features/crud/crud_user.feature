#created by Jefferson Martinez

Feature: Crud user

  @DeleteUser
  Scenario: Delete user by id
    Given that a user wants to delete an user with id 3
    Then he sees that the response code was 204

  @GetUser
  Scenario: Get user's info by id
    Given that a user wants to get user's info with id 2
    Then he sees that the response code was 200

  @PostUser
  Scenario Outline: Create a new user
    Given that a user wants to create his user with <name> and his job title, which is: <job>
    Then he see that a new user was created
    And he sees that the response code was 201

    Examples:
      | name   | job    |
      | Blank  | leader |
      | Andres | QA     |
      | JEFF   | FRONT  |
      | PENA   | BACK   |

  @PutUser
  Scenario Outline: Update an user
    Given that a user wants to update an user with id 3, sending <newName> as new name and <newJob> as new job
    Then he see that an user was updated
    And he sees that the response code was 200

    Examples:
      | newName | newJob  |
      | example | example |