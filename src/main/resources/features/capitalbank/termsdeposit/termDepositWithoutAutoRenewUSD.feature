@runPlan01
Feature: Term Deposit without Auto Renewal on USD Currency

  Background: Navigation to Term Deposits and selecting the funding account
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2082294"
    And I navigate to dashboard page
    And I click on Term Deposits in dashboard
    And I click on create new deposits menu
    And I select the deposit account with "USD" currency
    And I click on get started button

  @capitalMobile @termDeposits
  Scenario Outline: Term deposit creation without auto renew <period> and <autoRenewType>-MOB-AND-TD-34,   MOB-AND-TD-035,MOB-AND-TD-36,   MOB-AND-TD-037,MOB-AND-TD-038,MOB-AND-TD-039 ,MOB-AND-TD-040,  MOB-AND-TD-041 , MOB-AND-TD-046,MOB-AND-TD-095,  MOB-AND-TD-096,,MOB-AND-TD-097,  MOB-AND-TD-098,,MOB-AND-TD-099, MOB-AND-TD-0100 ,MOB-AND-TD-101,  MOB-AND-TD-0102,MOB-AND-TD-053,   MOB-AND-TD-0104MOB-AND-TD-137,MOB-AND-TD-140,MOB-AND-TD-143,MOB-AND-TD-052,MOB-AND-TD-055,MOB-AND-TD-058
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

    When I click back to dashboard option
    Then I should verify the created Term deposit

    And I click on account menu from the term deposit tab
    And I select the funding account with card number "<creditFundingAccountNumber>"
    Then I should see the amount "<depositAmount>" reduced from the the funding account card
    And I should see the transaction "Takeover Principal" with debit amount "<accountDebit>" in the transaction history with today's date in accounts tab

    Examples:
      | period   | creditFundingAccountNumber | autoRenew | depositAmount | accountDebit  |
      | 01 Month | 4536043                    | No        | 6800          | 6,800.00 USD |
      | 03 Month | 4536043                    | No        | 6800          | 6,800.00 USD |
      | 06 Month | 4536043                    | No        | 6800          | 6,800.00 USD |
      | 12 Month | 4536043                    | No        | 6800          | 6,800.00 USD |
      | 01 Month | 4536043                    | No        | 8769.897      | 8,769.90 USD |
    # Term Deposits with the limit amount allowed
      | 12 Month | 4536043                    | No        | 5000          | 5,000.00 USD |

  @capitalMobile @termDeposits
  Scenario: Creating Term Deposits with the limit amount lesser than allowed limit - Negative case- MOB-AND-TD-049
    When I select the funding account with card number "4536043"
    And I click on next button
    And I enter the amount "4100" for Create Deposits
    Then I should see the error pop-up "Error Minimum Amount allowed 5000"