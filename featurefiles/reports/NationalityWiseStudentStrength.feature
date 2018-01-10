Feature: Nationality Wise Student Strength
  As a user I would like to run the test cases of this page
  So that I don't have to do it manually

  Background: Steps to open fee manager landing page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo
    When user open nationality wise student strength

 #test cases of all filters selection
  @verify_with_filters @scenario1
  Scenario: To verify nationality wise student strength with filters class wise
    And select class with index "1" on nationality wise student strength
    Then click show on nationality wise student strength

 #test cases on selection of radio buttons/ check box
  @verify_with_no_filters @scenario2
  Scenario: To verify category gender wise student strength without any filter bus stop wise
    And select section wise on nationality wise student strength
    And select section with index "1" on nationality wise student strength
    And select graphical view on nationality wise student strength
    Then click show on nationality wise student strength