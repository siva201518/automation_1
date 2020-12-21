@selenium
Feature: Main

  @mainpage
  Scenario Outline: Main page search functionality
    Given user login to the application
    Then validating page title "We Build SG Data"
    And search with module name "<moduleName>"
    Then validate filtered modules matched with search string "<moduleName>"
    And close browser
    Examples:
    |moduleName|
    |events    |


 @mainpage
  Scenario Outline: Main page- validate all modules navigation from main page "<moduleName>" and its page title "<title>"
    Given user login to the application
    And click module "<moduleName>"
    Then validating modules title "<title>"
    And close browser
    Examples:
      | moduleName              | title                              |
      | active user groups      | active user groups with > 5 events |
      | event day of week       | events by day of week              |
      | repos per week          | repositories updated per week      |
      | events per week         | events per week                    |
      | active repositories     | active repos with > 10 updates     |
      | event per week of month | events per week of month           |
      | event locations         | popular event locations            |
      | event duration          | events by duration                 |

@activeUserGroup
  Scenario Outline: Active User Group-validate user group names and its counts
    Given user login to the application
    And click module "<moduleName>"
    Then validating modules title "<title>"
    Then print result user group names
    Then validating result user group counts are greater than "<count>" events
    And close browser

    Examples:
      | moduleName         | title                              | count |
      | active user groups | active user groups with > 5 events | 5     |

@repositoriesPerProgramming
  Scenario Outline: Repositories Per Programming Language- Validate results based on programming language selected "<language>"
    Given user login to the application
    And click module "<moduleName>"
    Then validating modules title "<title>"
    And select "<language>" radio button
    Then validating results based on languages selected
    And close browser
    Examples:
      | moduleName                            | title                                  | language |
      | repositories per programming language | repositories per programming languages | Clojure  |
      | repositories per programming language | repositories per programming languages | R        |
      | repositories per programming language | repositories per programming languages | Tex      |
