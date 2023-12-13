Feature: Blink My Account

  Background: Navigation to Blink Request money
    Given I have logged in the blink app
    And I have navigated to the home page
    And I click on home button

  # TC-BLINK-My account-001, TC-BLINK-My account-002, TC-BLINK-My account-003, TC-BLINK-My account-012
  # TC-BLINK-My account-010, TC-BLINK-My account-011, TC-BLINK-My account-012
  @blink @blinkMyAccount
  Scenario: Verify My account info
    When I click on home button
    Then I should see account details of "9428164371" IBAN "JO02EFBK0012000000009428164371"

    When I click on refresh button
    Then I should see the balance "AVAILABLE BALANCE"

    When I click on add money in my accounts page
    Then I should see the message "Deposit cash directly into your Blink account"
    And I should see the message "Deposit money directly from any of eFawateercom agents"

    When I click back button on way to add account page
    Then I should see account details of "9428164371" IBAN "JO02EFBK0012000000009428164371"

    When I swipe the screen to see account details
    Then I should see account approved date details "5 Jun"

    # TC-BLINK-My account-008
  @blink @blinkMyAccount
  Scenario: Verify request money page
    When I click on home button
    And I click on add money in my accounts page
    And I click on "Request money" in add money page
    Then I should redirect to "Request money from" page

    # TC-BLINK-My account-013, TC-BLINK-My account-014, TC-BLINK-My account-015
  @blink @blinkMyAccount
  Scenario: Verify Transaction History
    When I swipe screen to see account details
    And I search the transaction "ATM" in transaction history
    Then I should see "ATM" in transaction history

    When I click on the transaction period button transaction page
    Then I should see the transaction period "Last 30 days"

    # TC-BLINK-My account-016, TC-BLINK-My account-017, TC-BLINK-My account-018
  @blink @blinkMyAccount
  Scenario: Verify Transaction History
    When I swipe screen to see account details
    And I click on the transaction period button transaction page
    And I select the transaction period "Last 30 days"
    Then I should see the transaction history data

    When I click on the transaction period button transaction page
    And I select the transaction period "Last 3 months"
    Then I should see the transaction history data

    When I click on the transaction period button transaction page
    And I select the transaction period "Last 6 months"
    Then I should see the transaction history data

    #  TC-BLINK-My account-019, TC-BLINK-My account-021
  @blink @blinkMyAccount
  Scenario: Verify account statement
    When I swipe screen to see account details
    And I click on download button in transaction history page
    And I select month to download the statement
    Then I should see "Statement" of the account

    When I click on tick button in account statement
    Then I should see the transaction history data