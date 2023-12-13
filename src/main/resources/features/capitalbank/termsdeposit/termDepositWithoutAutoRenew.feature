@runPlan01
Feature: Term Deposit without Auto Renewal on JOD Currency

  Background: Navigation to Term Deposits and selecting the funding account
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2000112"
    And I navigate to dashboard page
    And I click on Term Deposits in dashboard
    And I click on create new deposits menu
    And I select the deposit account with "JOD" currency
    And I click on get started button

  @capitalMobile @termDeposits
  Scenario Outline: Term deposit creation without auto renew <period> and <autoRenewType>-MOB-AND-TD-010,MOB-AND-TD-011,MOB-AND-TD-063, MOB-AND-TD-064,MOB-AND-TD-012,MOB-AND-TD-013,MOB-AND-TD-065,MOB-AND-TD-066,MOB-AND-TD-014, MOB-AND-TD-015,MOB-AND-TD-067, MOB-AND-TD-068, MOB-AND-TD-016,MOB-AND-TD-017,MOB-AND-TD-047,MOB-AND-TD-069, MOB-AND-TD-070,,MOB-AND-TD-019,MOB-AND-TD-022,MOB-AND-TD-025,MOB-AND-TD-089,MOB-AND-TD-092,MOB-AND-TD-095,MOB-AND-TD-098
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
    And I should see the transaction "Takeover Principal" with debit amount "<accountDebit>" in the transaction history with today's date in accounts tab

    Examples:
      | period   | creditFundingAccountNumber | autoRenew | depositAmount | accountDebit  |
      | 01 Month | 4000463                    | No        | 7500          | 7,500.000 JOD |
      | 03 Month | 4000463                    | No        | 8700          | 8,700.000 JOD |
      | 06 Month | 4000463                    | No        | 8700          | 8,700.000 JOD |
      | 12 Month | 4000463                    | No        | 8700          | 8,700.000 JOD |
      | 01 Month | 4000463                    | No        | 9897.897      | 9,897.897 JOD |
     # Term Deposits with the exactly allowed limit
      | 12 Month | 4000463                    | No        | 5000          | 5,000.000 JOD |


  @capitalMobile @termDeposits
  Scenario: Creating Term Deposits with the limit amount lesser than allowed limit - Negative case- MOB-AND-TD-045,MOB-AND-TD-050
    When I select the funding account with card number "4000463"
    And I click on next button
    And I enter the amount "4700" for Create Deposits
    Then I should see the error pop-up "Error Minimum Amount allowed 5000"



