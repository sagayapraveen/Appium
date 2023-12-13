@runPlan01
Feature: Term Deposit with Auto Renewal on JOD Currency

  Scenario Outline: Term deposit creation for JOD Currency for <period> and <autoRenewType> -MOB-AND-TD-001,  MOB-AND-TD-002,  MOB-AND-TD-003, MOB-AND-TD-054,MOB-AND-TD-055,# MOB-AND-TD-056,MOB-AND-TD-004,MOB-AND-TD-005,  MOB-AND-TD-057,  MOB-AND-TD-058,MOB-AND-TD-006, MOB-AND-TD-007,  MOB-AND-TD-059,  MOB-AND-TD-060,MOB-AND-TD-008,   MOB-AND-TD-009,  MOB-AND-TD-061,  MOB-AND-TD-062, MOB-AND-TD-018,MOB-AND-TD-019, MOB-AND-TD-071,  MOB-AND-TD-072,MOB-AND-TD-020,MOB-AND-TD-021, MOB-AND-TD-073, MOB-AND-TD-074,  MOB-AND-TD-022,MOB-AND-TD-023, MOB-AND-TD-075, MOB-AND-TD-076,MOB-AND-TD-024,MOB-AND-TD-025,MOB-AND-TD-077,MOB-AND-TD-078,MOB-AND-TD-004,MOB-AND-TD-007,MOB-AND-TD-010,MOB-AND-TD-013,MOB-AND-TD-016,MOB-AND-TD-028,MOB-AND-TD-031,MOB-AND-TD-034,MOB-AND-TD-037,MOB-AND-TD-107,MOB-AND-TD-110
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2008075"
    And I navigate to dashboard page
    And I click on Term Deposits in dashboard
    And I click on create new deposits menu
    And I select the deposit account with "JOD" currency
    And I click on get started button
    And I select the funding account with card number "<creditFundingAccountNumber>"
    And I fetch the amount from the funding account card
    And I click on next button
    When I enter the amount "<depositAmount>" for Create Deposits
    And I select the deposit period as "<period>"
    And I select the deposit details with credit account number "<creditFundingAccountNumber>"
    And I select "<autoRenew>" radio button for Auto renew upon maturity
    And I select the type of auto renew as "<autoRenewType>"

    And I click on next button to navigate to confirm page
    Then I verify the total amount at maturity for the amount "<depositAmount>"

    When I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the message for term Deposit "Your Term Deposit is created successfully!" with details

    When I click back to dashboard option
    Then I should verify the created Term deposit

    When I click on account menu from the term deposit tab
    And I select the funding account with card number "<creditFundingAccountNumber>"
    Then I should see the amount "<depositAmount>" reduced from the the funding account card

    And I should see the transaction "Takeover Principal" with debit amount "<accountDebit>" in the transaction history with today's date in accounts tab

    @capitalMobile @termDeposits
    Examples:
      | period   | creditFundingAccountNumber | autoRenew | autoRenewType                            | depositAmount | accountDebit  |
      | 01 Month | 4022484                    | Yes       | Renew initial amount only                | 5000          | 5,000.000 JOD |
      | 03 Month | 4022484                    | Yes       | Renew initial amount only                | 8700          | 8,700.000 JOD |
      | 06 Month | 4022484                    | Yes       | Renew initial amount only                | 9500          | 9,500.000 JOD |
      | 12 Month | 4022484                    | Yes       | Renew initial amount only                | 8700          | 8,700.000 JOD |
      | 01 Month | 4022484                    | Yes       | Renew initial amount and credit interest | 8700          | 8,700.000 JOD |
      | 03 Month | 4022484                    | Yes       | Renew initial amount and credit interest | 8700          | 8,700.000 JOD |
      | 06 Month | 4022484                    | Yes       | Renew initial amount and credit interest | 8700          | 8,700.000 JOD |
      | 12 Month | 4022484                    | Yes       | Renew initial amount and credit interest | 8700          | 8,700.000 JOD |

    @p1
    Examples:
      | period   | creditFundingAccountNumber | autoRenew | autoRenewType                            | depositAmount | accountDebit  |
      | 01 Month | 4022484                    | Yes       | Renew initial amount only                | 5000          | 5,000.000 JOD |
