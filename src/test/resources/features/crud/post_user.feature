#created by Jefferson Martinez

Feature: Post user

  Scenario Outline: Create a new user
    Given that an user wants to create his user with <name> and his job title, which is: <job>
    Then he see that a new user was created

    Examples:
      | name   | job    |
      | Blank  | leader |
      | Andres | QA     |
      | JEFF   | FRONT  |
      | PENA   | BACK   |