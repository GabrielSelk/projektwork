Feature: As a normal user I want to be able to access the "Tervezési beállítások" sub-menu and set up a method of travell and click on the map to select a vehicles full route

  Rule: go.bkk.hu is loaded and the cookies are accepted

    Background:
      Given Search result is loaded on the map
      And I can click on the "Tervezési beállítások" sub-menu


    @sub-menu
    Scenario: Set up a route
      When I click on the "Tervezési beállítások" sub-menu
      And I dropdown menu appears
      Then I can de-select "villamos"
      And a new result is displayed


    Scenario: Click on a service
      When I select the first route in the resulsts
      And click on the bus number "26 on the drowpdown
      Then the selected vehicles whole route is displayed on the map

    @MapHandling
    Scenario: Selecting a bus stop on the map
      When I click on a "white dot" on the blue line
      Then I the page zooms into the marker
      And new information is displayed