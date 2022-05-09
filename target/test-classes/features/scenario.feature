@selenium
Feature: Main

  @internet @equ
  Scenario Outline:[<TestCaseID>] "The Internet"- Login functionality- Positive Flow
    Given user navigate to The Internet Home page
    Then validating page title "The Internet"
    And click authentication link
    And enter user name "<userName>"
    And enter password "<password>"
    And click login button
    Then validate success message "<successMsg>"
    And close browser
    Examples:
      |TestCaseID| celebrityName       | userName | password             | successMsg                     |
      |TC-Positive-01| Form Authentication | tomsmith | SuperSecretPassword! | You logged into a secure area! |

  @internet  @equ
  Scenario Outline:[<TestCaseID>] "The Internet"- Login functionality- Negative Flow
    Given user navigate to The Internet Home page
    Then validating page title "The Internet"
    And click authentication link
    And enter user name "<userName>"
    And enter password "<password>"
    And click login button
    Then validate error message "<errorMsg>"
    And close browser
    Examples:
      |TestCaseID| celebrityName       | userName      | password             | errorMsg                  |
      |TC-Negative-01| Form Authentication | tomsmith      | wrongPassword        | Your password is invalid! |
      |TC-Negative-02| Form Authentication | wrongUserName | wrongPassword        | Your username is invalid! |
      |TC-Negative-03| Form Authentication |               |                      | Your username is invalid! |
      |TC-Negative-04| Form Authentication | *&*           | SuperSecretPassword! | Your username is invalid! |
      |TC-Negative-05| Form Authentication | tomsmith      | wrongPassword!@#     | Your password is invalid! |

