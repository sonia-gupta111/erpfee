Feature: Cheque Report Date Wise
  As a user I would like to run the test cases of this page
  So that I don't have to do it manually

  Background: Steps to open fee manager landing page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo
    When user open cheque report date wise

#validation message verification test cases
  @validation @scenario1
  Scenario: To test client side validations on mandatory fields
    And verify validation when no entry mode is selected on cheque report date wise
    And verify validation when no date from is selected on cheque report date wise
    And select from date as month "July" year "2017" and day "1" on cheque report date wise
    And verify validation when no date to is selected on cheque report date wise
    And select to date as month "August" year "2017" and day "1" on cheque report date wise
    And verify validation when no class is selected on cheque report date wise
    And verify validation when no cheque bank is selected on cheque report date wise

  @validation @scenario2
  Scenario: To test alert validation when from date is greater than to date
    When select from date as month "August" year "2017" and day "10" on cheque report date wise
    And select to date as month "August" year "2017" and day "9" on cheque report date wise
    Then verify alert message for date on cheque report date wise

#test cases of all filters selection
  @verify_with_filters @scenario3
  Scenario: To verify cheque report date wise with filters
    And select entry mode on cheque report date wise
    And select from date as month "April" year "2017" and day "1" on cheque report date wise
    And select to date as month "March" year "2018" and day "31" on cheque report date wise
    And select class on cheque report date wise
    And select school with index "1" on cheque report date wise
    And select fee type with index "1" on cheque report date wise
    And select cheque bank on cheque report date wise
    And select user with index "1" on cheque report date wise
    Then click show on cheque report date wise

#test cases on selection of radio buttons/ check box
  @verify_with_no_filters @scenario4
  Scenario: To verify cheque report date wise without selecting any filter
    And select from date as month "April" year "2017" and day "1" on cheque report date wise
    Then click show on cheque report date wise