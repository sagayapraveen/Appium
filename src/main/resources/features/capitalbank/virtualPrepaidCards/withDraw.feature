@runPlan01
Feature: Withdraw from Virtual Prepaid card

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    And I click on cards in dashboard
    And I select "Prepaid Card" from the dropdown

  @capitalMobile @virtualPrepaidCard @withdraw
  Scenario: Validating withdraw amount more than available -MOB-AND-VPD-48
    Then I verify "Withdraw" button is clickable
    And I click on Withdraw Menu
    When I select withdraw To card
    And I enter the amount "2500" for Withdraw
    And I click on next button for TopUp page
    Then I should see the error pop-up "Error You do not have sufficient balance for this transaction. Please select another account or change the transaction amount."

  @sanity @p1
  @capitalMobile @virtualPrepaidCard @withdraw
  Scenario: Validating withdraw amount -MOB-AND-VPD-12,MOB-AND-VPD-11,MOB-AND-VPD-10,MOB-AND-VPD-9,MOB-AND-VPD-7,MOB-AND-VPD-8
    And I select the card with name "ZAINUATT"
    And I click on Withdraw Menu
    Then I should see the page as "Select Account"
    When I select withdraw To card
    Then I should see the page as "Withdraw"

    When I enter the amount "56" for Withdraw
    And I enter the payment details as "Testing"
    And I click on next button for TopUp page
    Then I should see the page as "Confirm Withdraw"

    When I click on confirm button
    Then I should see the successful message for Withdraw

  @capitalMobile @virtualPrepaidCard @withdraw
  Scenario: Withdrawing balance amount available in the card -MOB-AND-VPD-46
    And I select the card with name "ZAINUATT"
    And I click on Withdraw Menu
    Then I should see the available balance of the card
    When I select withdraw To card for the available limit "Withdraw"
    And I click on next button for TopUp page
    And I click on confirm button
    Then I should see the successful message for Withdraw