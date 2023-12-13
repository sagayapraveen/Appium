@runPlan04
Feature: Settle Credit Card via Used balance

  @p1
  @capitalMobile @creditCard @settleViaUsedBalance @testTransfers
  Scenario: Settle up Credit card via Used Balance menu with Any amount - MOB-AND-CRD-539 MOB-AND-CRD-540 MOB-AND-CRD-541 MOB-AND-CRD-542 MOB-AND-CRD-543 MOB-AND-CRD-544 MOB-AND-CRD-545 MOB-AND-CRD-546 MOB-AND-CRD-547 MOB-AND-CRD-548 MOB-AND-CRD-549 MOB-AND-CRD-550 MOB-AND-CRD-551 MOB-AND-CRD-552 MOB-AND-CRD-553 MOB-AND-CRD-554 MOB-AND-CRD-555 MOB-AND-CRD-556 MOB-AND-CRD-557 MOB-AND-CRD-558 MOB-AND-CRD-559 MOB-AND-CRD-560 MOB-AND-CRD-561 MOB-AND-CRD-562 MOB-AND-CRD-563 MOB-AND-CRD-564 MOB-AND-CRD-565 MOB-AND-CRD-566 MOB-AND-CRD-567 MOB-AND-CRD-568 MOB-AND-CRD-569 MOB-AND-CRD-570 MOB-AND-CRD-571 MOB-AND-CRD-572 MOB-AND-CRD-573 MOB-AND-CRD-574 MOB-AND-CRD-575 MOB-AND-CRD-576 MOB-AND-CRD-577 MOB-AND-CRD-578
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to JOD account in Accounts tab
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab

    When I click the Used Balance tab
    And I click the settle card now from Used Balance menu
    And I enter the "10" in Any amount field
    Then I should see the focused "false" for the "Outstanding Amount"
    And I should see the focused "false" for the "Minimum Due Amount"

    When I click on next button
    And I confirm the credit card payment
    Then I should see the success message "You have successfully paid your credit card" for credit card transfers

    When I click back to dashboard option
    Then I should see the amount 10 is increased from the Card balance

    When I navigate to accounts tab from cards tab
    Then I should see the transaction "Visa Credit Card Payment" with debit amount "10.000 JOD" in the transaction history with today's date in accounts tab
    And I should see the amount 10 is reduced from the current account balance after transaction

    When I click on cards in dashboard
    Then I should see the transaction "CREDIT CARD PAYMENT" with credit amount "10.000 JOD" in the transaction history with today's date in cards tab

    When I fetch the Card dashboard details from the card dashboard
    Then I should see the "Last Payment" as "10.000" in card details
    And I should see the "Card Status" as "Active" in card details
    And I should see the "Card Currency" as "JOD" in card details

    When I click the Used Balance tab
    And I click the payment history tab for credit card
    Then I should see the "CREDIT CARD PAYMENT" with the amount "10.000 JOD" in the payment history with today's date