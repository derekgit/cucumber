@runthis
Feature: OMDB rest api gets

  Scenario: Get movie by title
    Given I query movie by "Finding Nemo"
    When I make the rest call
    Then response should contain:
      """
      {
      "Title":"Finding Nemo",
      "Released":"30 May 2003",
      "Genre":"Animation, Adventure, Comedy",
      "Rated":"G"
      }
      """

  Scenario Outline: Get many movies by title
    Given I query movie by "<title>"
    When I make the rest call
    Then response should contain "<genres>"

    Examples: No special characters in movie titles

      | title        | genres                                         |
      | Finding Nemo | {"Genre":"Animation, Adventure, Comedy"}       |
      | Inception    | {"Genre":"Action, Adventure, Sci-Fi"}          |

    Examples: Special characters in movie titles
      | title        | genres                                         |
      | WALL·E       | {"Genre":"Animation, Adventure, Family"}       |
      | 8½           | {"Genre":"Drama, Fantasy"}                     |
