Feature: WebDriverUniversity -Login page

  Scenario: Validate successful login
    Given I access the webdriver university login page
    When  I enter a username "webdriver"
    And I enter a password "webdriver123"
    And I click on the login button
    Then I should get the successful login message