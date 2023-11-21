Feature: As a normal user I want to be able to set up and search a route between two locations

  Rule: go.bkk.hu is loaded and the cookies are accepted

    Background:
      Given I can type into the input fields
      And the map is loaded


@RouteSearch
Scenario: Set up a route
When I type "Margit-sziget" into input field A
And I type "Budai Vár" into input field B
And I click on the Search button
Then possible routes should be displayed

Scenario: Selecting a route
  When the search results are visible
  And I click on the first result
  And the dropdown menu is displayed
  Then the correct route is displayed on the map
