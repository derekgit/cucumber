@runthis
Feature: Data table unsuccessful login

  Verify that the user login is unsuccessful after passing incorrect inputs.

  Scenario:

    Given I am on the login page
    When I enter invalid data on login

      | Email                   | Password            |
      | First Name              | Tom                 |

    Then the login should be unsuccessful