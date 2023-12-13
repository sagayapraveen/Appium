@runPlan01
Feature: Card-less withdraw

  Background: Navigation to request money Page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    When I navigate to cashless withdraw menu

  @p1
  @capitalMobile @dashboard @cardlessWithdraw @capitalDashboard
  Scenario: Customer requesting for card-less withdrawal - MOB-AND-DAB-018, MOB-AND-DAB-019, MOB-AND-DAB-020, MOB-AND-DAB-021, MOB-AND-DAB-022
    When I enter the withdraw amount as "10"
    And I confirm the withdraw transaction
    Then I should see the withdraw successful message

  @capitalMobile @dashboard @cardlessWithdraw @capitalDashboard
  Scenario: Error message for card-less withdrawal amount 1 - MOB-AND-DAB-023
    When I enter the withdraw amount as "1"
    Then I should see the error pop-up "INFO Amount should be a multiple of 10"

  @capitalMobile @dashboard @cardlessWithdraw @capitalDashboard
  Scenario: Error message for card-less withdrawal amount 1010 - MOB-AND-DAB-024
    When I enter the withdraw amount as "1010"
    And I confirm the withdraw transaction
    Then I should see the error pop-up "Error Minimum amount is 10 JOD and maximum amount is 1000 JOD for cardless withdrawal"

  @capitalMobile @dashboard @cardlessWithdraw @capitalDashboard
  Scenario: Customer requesting for card-less withdrawal for USD - MOB-AND-DAB-045
    When I select pay from card USD
    And I enter the withdraw amount as "10"
    Then I should see the error pop-up "INFO To perform a Cardless Withdrawal the only allowed currency is JOD"