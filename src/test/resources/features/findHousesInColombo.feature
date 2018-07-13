Feature: Search houses in colombo with some filters
  Scenario: User search for houses
    Given User on the welcome page of "https://ikman.lk"
    When User click on property
    Then User should navigate to property page
    When User click on houses
    Then User should navigate to houses page
    When User click on colombo
    Then User should navigate to colombo houses page
    When User click on prices drop down
    And User enter minimum and maximum values
    And Click on filter
    When User click on beds drop down
    And User click on threeBeds
    Then User should navigate to filtered results page
    Then Should close the browser