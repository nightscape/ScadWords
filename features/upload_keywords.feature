Feature: Upload keywords
  In order to save API costs and prevent problems with size limits
  As a sem4r user
  I want to upload keywords in bulk

  Scenario: Upload one generated keyword
    Given I am logged into my AdWords API account
    And all client accounts are empty
    And I select one client account
    When I create the following campaigns
    | name |
    | cmpg |
    And I create the following ad groups in campaign "cmpg"
    | name |
    | adgr |
    When I create the following keywords in campaign "cmpg" and ad group "adgr"
    | text   | match |
    | buy me | BROAD |
    Then ad group "adgr" in campaign "cmpg" should contain the following keywords
    | text   | match |
    | buy me | BROAD |
