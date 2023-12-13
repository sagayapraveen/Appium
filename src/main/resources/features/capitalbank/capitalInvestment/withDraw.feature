@runPlan01
Feature: Overseas Withdraw on CapitalMobile app

  Background: Navigation to transferPage
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I navigate to investment option
    And I select pay from card JOD
    And I select Withdraw option
    And I select "withdraw" pay to card JOD

  @capitalMobile @capitalInvestment @investmentWithDraw
  Scenario: Transfer amount JOD to JOD using withDraw option with insufficient balance - MOB-AND-INVEST-082, MOB-AND-INVEST-085
    When I enter amount as 7000000 and description as "withdrawal" for Investments page
    And I click on next button
    Then I should see the error pop-up "Error You do not have sufficient balance for this transaction. Please select another account or change the transaction amount."

  @capitalMobile @capitalInvestment @investmentWithDraw
  Scenario: Transfer amount JOD to JOD using invalid OTP in withDraw option - MOB-AND-INVEST-087, MOB-AND-INVEST-088, MOB-AND-INVEST-089
    When I enter amount as 1 and description as "withdrawal" for Investments page
    And I should verifying the details in the confirm page
    And I verify the mobile otp pin "654322"
    Then I should see the error pop-up "Error Not Valid OTP"

  @capitalMobile @capitalInvestment @investmentWithDraw
  Scenario: Verifying the close button in withDraw option - MOB-AND-INVEST-019
    When I enter amount as 1 and description as "withdrawal" for Investments page
    And I click close button
    Then I should see the page as "Investments"