Feature: Term Deposit Weekend Validation

  Background: Navigation to Term Deposits and selecting the funding account
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2082294"
    And I navigate to dashboard page
    And I click on Term Deposits in dashboard
    And I click on create new deposits menu

  @capitalMobile @termDeposits @termDepositsWeekendValidation
  Scenario Outline: Creating the deposit during the weekend to check the behaviour for <currency>-MOB-AND-TD-042,MOB-AND-TD-053
    And I select the deposit account with "<currency>" currency
    And I click on get started button
    When I select the funding account with card number "<creditFundingAccountNumber>"
    And I fetch the amount from the funding account card
    And I click on next button
    And I enter the amount "<depositAmount>" for Create Deposits
    And I select the deposit period as "<period>"
    And I select the deposit details with credit account number "<creditFundingAccountNumber>"
    And I select "<autoRenew>" radio button for Auto renew upon maturity
    And I click on next button to navigate to confirm page
    Then I verify the total amount at maturity for the amount "<depositAmount>"
    When I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the message for term Deposit "Your Term Deposit is created successfully!" with details

    And I click back to dashboard option
    Then I should verify the created Term deposit

    And I click on account menu from the term deposit tab
    When I select the funding account with card number "<creditFundingAccountNumber>"
    Then I should see the amount "<depositAmount>" reduced from the the funding account card
    And I should see the transaction "Takeover Principal" with debit amount "<accountDebit>" in the transaction history with sunday's date in accounts tab
    Examples:
      | currency | period   | creditFundingAccountNumber | autoRenew | depositAmount | accountDebit  |
      | JOD      | 01 Month | 4536042                    | No        | 5000          | 5,000.000 JOD |
      | USD      | 01 Month | 4536043                    | No        | 5000          | 5,000.00 USD  |