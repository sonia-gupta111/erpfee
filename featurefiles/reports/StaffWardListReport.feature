Feature: Staff Ward List Report
  As a user I would like to run the test cases of this page
  So that I don't have to do it manually

  Background: Steps to open fee manager landing page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo
    When user open staff ward list report

#test cases of all filters selection
  @verify_with_filters @scenario1
  Scenario: To verify staff ward list report with filters
    And select class with index "1" on staff ward list report
    And select section with index "1" on staff ward list report
    And select staff type with index "1" on staff ward list report
    And select staff name with index "1" on staff ward list report
    Then click show on staff ward list report

#test cases on selection of radio buttons
  @verify_with_no_filters @scenario2
  Scenario: To verify staff ward list report with no filters
    Then click show on staff ward list report