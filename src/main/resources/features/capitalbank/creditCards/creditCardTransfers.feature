@runPlan04
Feature: Transfers in Credit Card

  @sanity
  @p1
  @capitalMobile @creditCard @creditCardTransfers
  Scenario: Validation of Transfer from Credit card to current account - MOB-AND-CRD-452 MOB-AND-CRD-450 MOB-AND-CRD-443 MOB-AND-CRD-442 MOB-AND-CRD-435 MOB-AND-CRD-434 MOB-AND-CRD-430 MOB-AND-CRD-421 MOB-AND-CRD-420 MOB-AND-CRD-419 MOB-AND-CRD-418 MOB-AND-CRD-417 MOB-AND-CRD-416 MOB-AND-CRD-414 MOB-AND-CRD-413 MOB-AND-CRD-412 MOB-AND-CRD-411 MOB-AND-CRD-410 MOB-AND-CRD-409 MOB-AND-CRD-408 MOB-AND-CRD-407 MOB-AND-CRD-406 MOB-AND-CRD-404 MOB-AND-CRD-403 MOB-AND-CRD-402 MOB-AND-CRD-401 MOB-AND-CRD-392 MOB-AND-CRD-391 MOB-AND-CRD-390 MOB-AND-CRD-389 MOB-AND-CRD-388 MOB-AND-CRD-387 MOB-AND-CRD-385 MOB-AND-CRD-384 MOB-AND-CRD-383
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to JOD account in Accounts tab
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab
    And I click the transfers menu
    And I click the cards in transfers page
    And I select the Own account from the transfers page
    And I select the current account for transfers Pay to

    When I input the amount "10" for the Transfers to Own account
    And I fetch the Pay to card details
    And I confirm the transfer from credit card
    Then I should see the success message "Transfer successful!" for credit card transfers

    When I click back to dashboard option
    Then I should see the amount 10 is reduced from the Card balance

    When I navigate to accounts tab from cards tab
    Then I should see the transaction "Transfer from Card" with credit amount "10.000 JOD" in the transaction history with today's date in accounts tab
    And I should see the amount 10 is increased from the current account balance

  @capitalMobile @creditCard @creditCardTransfers
  Scenario: Validation of CreditCard transfers - FCY currencies - Negative
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab

    When I fetch the Card dashboard details from the card dashboard
    Then I should see the "Card Status" as "Active" in card details
    And the card middle 6 digit should be masked
    And the transfers option should be clickable

    When I navigate to USD card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Card Status" as "Active" in card details
    And the card middle 6 digit should be masked
    And the transfers option should be not-clickable

    When I navigate to GBP card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Card Status" as "Active" in card details
    And the card middle 6 digit should be masked
    And the transfers option should be not-clickable

    When I navigate to AED card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Card Status" as "Active" in card details
    And the card middle 6 digit should be masked
    And the transfers option should be not-clickable

    When I navigate to EUR card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Card Status" as "Active" in card details
    And the card middle 6 digit should be masked
    And the transfers option should be not-clickable

