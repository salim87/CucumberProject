Feature: WebDriverUniversity -Login page

  Background:
    Given I access the webdriver university login page

  Scenario: Validate successful login
    When  I enter a username webdriver
    And I enter a password webdriver123
    And I click on the login button
    Then I should get the successful login message

  Scenario: Validate unsuccessful login
    When  I enter a username webdriver
    And I enter a password password123
    And I click on the login button
    Then I should get the unsuccessful login message

  Scenario Outline:
    When  I enter a username <username>
    And I enter a password <password>
    And I click on the login button
    Then I should get the following login message with <validationMessage>

    Examples:
    | username | password  | validationMessage |
    | webdriver | webdriver123 | validation succeeded |
    | webdriver | password123 | validation failed |
