@selenium
Feature: Main

  @celebrity @equ
  Scenario Outline: Wikipedia- Celebrity search and birthday/spouse details- "<celebrityName>"
    Given user navigate to the Wikipedia Home page
    Then validating page title "Wikipedia, the free encyclopedia"
    And search with celebrity name "<celebrityName>"
    Then validating page title "<celebrityName> - Wikipedia"
    Then print celebrity birth day "<celebrityName>"
    Then print celebrity spouse name "<celebrityName>"
    And close browser
    Examples:
      | celebrityName         |
      | Ed Sheeran            |
      | Vijay Deverakonda     |
      | Johnny Depp           |
      | Al Pacino             |
      | Robert De Niro        |
      | Kevin Spacey          |
      | Angelina Jolie        |
      | Christian Bale        |
      | Arnold Schwarzenegger |
      | Sylvester Stallone    |


  @language @equ
  Scenario Outline: Wikipedia- language page- "<lang>"
    Given user navigate to the Wikipedia Home page
    Then validating page title "Wikipedia, the free encyclopedia"
    And click language link "<lang>"
    Then Validate page title for language "<langTitle>"
    And close browser
    Examples:
      | lang       | langTitle                          |
      | Spanish    | Wikipedia, la enciclopedia libre   |
      | German     | Wikipedia – Die freie Enzyklopädie |
      | Dutch      | Wikipedia, de vrije encyclopedie   |
      | Swedish    | Wikipedia, den fria encyklopedin   |
      | Portuguese | Wikipédia, a enciclopédia livre    |
      | Italian    | Wikipedia, l'enciclopedia libera   |
      | Slovenian  | Wikipedija                         |
      | Finnish    | Wikipedia, vapaa tietosanakirja    |
      | Polish     | Wikipedia, wolna encyklopedia      |


