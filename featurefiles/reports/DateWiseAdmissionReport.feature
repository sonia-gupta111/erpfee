Feature: Date Wise Admission Report
  As a user I would like to run the test cases of this page
  So that I don't have to do it manually

  Background: Steps to open fee manager landing page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo
    When user open date wise admission report

#test cases of all filters selection
  @verify_with_filters @scenario1
  Scenario: To verify date wise admission report with filters
    When select from date as month "August" year "2017" and day "20" on date wise admission report
    And select class with index "1" on date wise admission report
    And select section with index "1" on date wise admission report
    And select other details on date wise admission report
    Then click show on date wise admission report

#test cases on selection of radio buttons
  @verify_with_no_filters @scenario2
  Scenario: To verify date wise admission report with active option
    And click show on date wise admission report