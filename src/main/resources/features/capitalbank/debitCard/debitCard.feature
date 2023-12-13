@runPlan01
Feature: Debit Card on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page

  @capitalMobile @debiCard
  Scenario: Verify Debit Card Spending Limit - MOB-AND-debit card -1, MOB-AND-debit card -2 MOB-AND-debit card -3, MOB-AND-debit card -4, MOB-AND-debit card -5, MOB-AND-debit card -14, MOB-AND-debit card -13, MOB-AND-debit card -11, MOB-AND-debit card -8
    When I click on cards in dashboard
    And I select the dropdown
    And select the "Debit Card" from dropdown menu
    And I click the freeze button in cards page
    And I click on confirm button
    Then I should see the card status "Deactivated"

    When I click on freeze button in cards page
    Then I should see the card status "Active"

    When I click on cards in dashboard
    And I select the dropdown
    And select the "Debit Card" from dropdown menu
    Then I should see the "Spending" in cards page

    When I select the "Spending" under cards page
    And I set ATM withdrawal limit "5000"
    And I set card payment "500"
    And I set online purchase "251"
    And I set contactless payment "2"
    And I click on save Button in Manage Spending Limits page
    Then I should see the "Debit Card Spending Limit Updated Successfully" message in Manage Spending Limits pag


  @capitalMobile @debiCard
  Scenario: Verify maximum Debit Card Spending Limit - MOB-AND-debit card -9, MOB-AND-debit card -15, MOB-AND-debit card -12, MOB-AND-debit card -6
    When I click on cards in dashboard
    And I select the dropdown
    And select the "Debit Card" from dropdown menu
    And I select the "Spending" under cards page
    And I set ATM withdrawal limit "8000"
    Then I should see the error as "Entered value is greater than max limit for ATM Withdrawal" in Manage Spending Limits page

    When I set card payment "1500"
    Then I should see the error "Entered value is greater than max limit for Card Payments" in Manage Spending Limits page

    When I set online purchase "751"
    Then I should see the error "Entered value is greater than max limit for Online Purchase" on Manage Spending Limits page

    When I set contactless payment "652"
    Then I should see the error as "Entered value is greater than max limit for Contactless Payment" on Manage Spending Limits page

  @capitalMobile @debiCard
  Scenario: Verify toggle off and on - MOB-AND-debit card -10, MOB-AND-debit card -7, MOB-AND-debit card -16
    When I click on cards in dashboard
    And I select the dropdown
    And select the "Debit Card" from dropdown menu
    And I select the "Spending" under cards page
    And I click on toggle off on ATM withdrawal option
    And I click on toggle off on card option
    And I click on toggle off on online shopping option
    And I click on toggle off on contactless payment option
    And I click on save Button in Manage Spending Limits page
    Then I should see the "Debit Card Spending Limit Updated Successfully" message in Manage Spending Limits pag

    When I click on toggle on ATM withdrawal option
    And I set ATM withdrawal limit "5000"
    And I click on toggle on card option
    And I set card payment "500"
    And I click on toggle on online shopping option
    And I set online purchase "251"
    And I click on toggle on contactless payment option
    And I set contactless payment "2"
    Then I click on save Button  Manage Spending Limits page