@runPlan04
Feature: Settle Credit Card JOD to JOD

  @smoke
  @capitalMobile @creditCard @settleCard
  Scenario: Settle Credit card from JOD account to JOD card - MOB-AND-CRD-032 MOB-AND-CRD-031 MOB-AND-CRD-030 MOB-AND-CRD-029 MOB-AND-CRD-028 MOB-AND-CRD-027 MOB-AND-CRD-026 MOB-AND-CRD-025 MOB-AND-CRD-024 MOB-AND-CRD-023 MOB-AND-CRD-022 MOB-AND-CRD-021 MOB-AND-CRD-020 MOB-AND-CRD-005 MOB-AND-CRD-002 MOB-AND-CRD-453 MOB-AND-CRD-454 MOB-AND-CRD-455 MOB-AND-CRD-456 MOB-AND-CRD-457 MOB-AND-CRD-458 MOB-AND-CRD-459 MOB-AND-CRD-460 MOB-AND-CRD-461 MOB-AND-CRD-462 MOB-AND-CRD-463 MOB-AND-CRD-464 MOB-AND-CRD-465 MOB-AND-CRD-466 MOB-AND-CRD-467 MOB-AND-CRD-468 MOB-AND-CRD-469 MOB-AND-CRD-470 MOB-AND-CRD-471 MOB-AND-CRD-472 MOB-AND-CRD-473 MOB-AND-CRD-474 MOB-AND-CRD-475 MOB-AND-CRD-476 MOB-AND-CRD-477 MOB-AND-CRD-478 MOB-AND-CRD-479 MOB-AND-CRD-480 MOB-AND-CRD-481 MOB-AND-CRD-482
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to JOD account in Accounts tab
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab

    When I click the settle card
    And I enter the "10" in Any amount field
    And I click on next button
    And I confirm the credit card payment
    Then I should see the success message "You have successfully paid your credit card" for credit card transfers

    When I click back to dashboard option
    Then I should see the amount 10 is increased from the Card balance

    When I navigate to accounts tab from cards tab
    Then I should see the transaction "Visa Credit Card Payment" with debit amount "10.000 JOD" in the transaction history with today's date in accounts tab
    And I should see the amount 10 is reduced from the current account balance after transaction

    When I click on cards in dashboard
    And I navigate to JOD card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Last Payment" as "10.000 JOD" in card details
    And I should see the transaction "CREDIT CARD PAYMENT" with credit amount "10.000 JOD" in the transaction history with today's date in cards tab

    When I click the Used Balance tab
    And I click the payment history tab for credit card
    Then I should see the "CREDIT CARD PAYMENT" with the amount "10.000 JOD" in the payment history with today's date