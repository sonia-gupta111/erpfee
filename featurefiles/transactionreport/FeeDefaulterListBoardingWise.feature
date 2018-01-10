Feature: Fee Defaulter List Boarding Wise
  As a user I would like to run the test cases of this page
  So that I don't have to do it manually

  Background: Steps to open fee manager landing page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo
    And user open fee defaulter list boarding wise

#test cases of all filters selection
  @verify_with_filters @scenario1
  Scenario: To verify fee defaulter list boarding wise with filters
    And select school with index "1" on fee defaulter list boarding wise
    And select wing with index "1" fee defaulter list boarding wise
    And select class with index "1" on fee defaulter list boarding wise
    And select section with index "1" on fee defaulter list boarding wise
    And select board with index "1" on fee defaulter list boarding wise
    And select fee type with index "1" on fee defaulter list boarding wise
    And select installment on fee defaulter list boarding wise
    And select till date as month "April" year "2017" and day "30" on fee defaulter list boarding wise
    And select range with index "1" on fee defaulter list boarding wise
    And enter range value "1000" on fee defaulter list boarding wise
    And select boarding with index "1" on fee defaulter list boarding wise
    And click show on fee defaulter list boarding wise

#test cases on selection of radio buttons
  @verify_with_no_filters @scenario2
  Scenario: To verify fee defaulter list boarding wise class wise and without head
    And select radio button "1" on fee defaulter list boarding wise
    And select date range on fee defaulter list boarding wise
    And select from date as month "April" year "2017" and day "1" on fee defaulter list boarding wise
    And select radio button "1" head or headwise on fee defaulter list boarding wise
    And click with fine on fee defaulter list boarding wise
    And click header with class group on fee defaulter list boarding wise
    And select select cheque clearance date on fee defaulter list boarding wise
    And click show on fee defaulter list boarding wise

  @verify_with_no_filters @scenario3
  Scenario: To verify fee defaulter list boarding wise with class range and with head
    And select radio button "2" on fee defaulter list boarding wise
    And select class on fee defaulter list boarding wise
    And select radio button "2" head or headwise on fee defaulter list boarding wise
    And select head on fee defaulter list boarding wise
    And click show on fee defaulter list boarding wise