@runPlan01
Feature: Loyalty on CapitalMobile app

  Background: Navigation of Loyalty screen
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2080102"
    And I navigate to dashboard page
    And I should see Loyalty widget
    And I should see "loyalty points" in the Loyalty widget
    When I click on Redeem now button
    Then I should see app in the "Loyalty Points" in Loyalty

  @capitalMobile @loyalty
  Scenario: Verifying View Details and history page - MOB-AND-LOY-001 MOB-AND-LOY-002 MOB-AND-LOY-003 MOB-AND-LOY-004 MOB-AND-LOY-005
    When I should see View Details and Redeem button in Loyalty page
    And I click on view Details link
    Then I should see info about Points collected and Expiry details
    And I click close button

    When I click on History tab in Loyalty Points page
    Then I should see the page as "History"

    When I click on search button in history page
    And I click on "Redeemed" filter
    Then I should see the page as Redeemed history

    When I click on search button in history page
    And I click on "Gained" filter
    Then I should see the page as Gained history

    When I click on search button in history page
    And I click on "Expired" filter
    Then I should see the page as No Data Found history
    And I click close button

  @capitalMobile @loyalty
  Scenario: Verifying Redeem Loyalty Points - MOB-AND-LOY-006 MOB-AND-LOY-007 MOB-AND-LOY-008 MOB-AND-LOY-009 MOB-AND-LOY-010 MOB-AND-LOY-011
    When I click on Redeem button
    And I should see the page as "Redeem"
    And I enter Redeem points "280"
    And I should see Confirm Redeem page
    And I click on confirm button
    Then I should see the Redeem successful message "You have successfully redeemed points!"
    When I click back to dashboard option
    Then I should see Loyalty widget

    When I click on Redeem now button
    And I should see app in the "Loyalty Points" in Loyalty
    And I click on Redeem button
    And I should see the page as "Redeem"
    And I enter Redeem points "250"
    Then I should see Confirm Redeem page
    When I click on confirm button
    Then I should see the Redeem successful message "You have successfully redeemed points!"