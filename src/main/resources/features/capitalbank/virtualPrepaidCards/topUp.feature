@runPlan01
Feature: TopUp in CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    When I click on cards in dashboard
    And I select "Prepaid Card" from the dropdown

  @sanity @p1
  @capitalMobile @virtualPrepaidCard @topUp
  Scenario: Validation the TopUp in Virtual prepaid card -MOB-AND-VPD-35,MOB-AND-VPD-34,MOB-AND-VPD-33,MOB-AND-VPD-32,MOB-AND-VPD-31
    And I select the card with name "ZAINUATT"
    Then I verify "Top Up" button is clickable
    And I click on TopUp menu
    Then I should see the page displayed as "Select Account"
    And I select the card with account Number "4176995"
    And I select TopUp To card
    When I enter the amount "100" for Top Up
    And I click on next button for TopUp page
    Then I should see the page as "Confirm Top Up"
    When I click on confirm button
    Then I should see the successful message for Top up

  @capitalMobile @virtualPrepaidCard @topUp
  Scenario: Validation the TopUp with more than available card balance - Negative -MOB-AND-VPD-36
    And I click on TopUp menu
    And I select TopUp To card
    When I enter the amount "500" for Top Up
    And I click on next button for TopUp page
    When I click on confirm button
    Then I should see the topUp failed message as "Top up failed!"