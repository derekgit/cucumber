@runthis
Feature: Check addition in Google calculator
  In order to verify that google calculator work correctly
  As a user of google
  I should be able to get correct addition result

  Scenario: Addition
    Given I open google.com
    When I enter "2+2" in search textbox
    Then I should get result as 4