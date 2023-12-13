@runPlan01
Feature: ATM Branches under Dashboard

  @capitalMobile @dashboard @atmBranches @capitalDashboard
  Scenario: Verifying the ATM branches menu - MOB-AND-DAB-031
    Given I have logged in the CBJ app
    When I navigate to dashboard page
    Then I should see ATM Branches menu