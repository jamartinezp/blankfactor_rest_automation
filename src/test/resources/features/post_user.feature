#created by Jefferson Martinez

Feature: Post user
  Scenario Outline: Create a new user
    Given that <actorName> want to create his user with his name and his job title, which is: <job>
    Then he see that a new user was created

    Examples:
      | actorName | job    |
      | Blank     | leader |
      | Andres    | QA     |
      | JEFF      | FRONT  |
      | PENA      | BACK   |