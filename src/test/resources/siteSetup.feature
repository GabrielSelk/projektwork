Feature: As a normal user I want to be able to handle cookies and change languages on the site

  Rule: Open the page as a normal user

    Background:
      Given I open the site go.bkk.hu
      And the cookie pop-up appears

    @CookieHandling
    Scenario:
      When I click on the "Elfogadom" button
      Then The cookie pop-up disappears


    @LanguageChange
    Scenario Outline: Change language
      Given the language is set to "<newPageLanguage>"
      When I change the language to "<newLanguage>"
      And I change the language back to "<newPageLanguage>"
      Then language is changed to <newPageLanguage>

      Examples:
        | newPageLanguage | newLanguage |
        | hungarian       | english     |
