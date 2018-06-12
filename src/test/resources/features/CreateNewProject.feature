Feature:
  As an enterprenuer
  I want to register a business project
  Scenario: Register a new project
    Given I am on new project registration page
    When I fill my first name "Sergii" and last name "Oliinyk"
    And I fill my city "Kyiv"
    And I fill my phone "123456789"
    And I fill my email "qweasd@aedawe.ww"
    And I fill my password "Password1"
    And I click next button
    Then I am on second step
    When I fill project name "Project name"
    And I fill project description "Project description"
    And I select project satge 0
    And I fill advantages "Project advantages"
    And I fill monetization model "Project monetezation model"
    And I fill required amount "12345"
    And I click agree checkbox
    And I click submit button



