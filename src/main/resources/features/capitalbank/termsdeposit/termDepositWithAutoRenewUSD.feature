@runPlan01
Feature: Term Deposit with Auto Renewal on USD Currency

  @capitalMobile @termDeposits
  Scenario Outline: Term deposit creation for USD Currency for <period> and <autoRenewType> -MOB-AND-TD-026,  MOB-AND-TD-027, MOB-AND-TD-028,  MOB-AND-TD-029,MOB-AND-TD-030,  MOB-AND-TD-031, MOB-AND-TD-048, MOB-AND-TD-032,  MOB-AND-TD-033, MOB-AND-TD-079,  MOB-AND-TD-080, MOB-AND-TD-081,  MOB-AND-TD-082,MOB-AND-TD-083,  MOB-AND-TD-084,MOB-AND-TD-085,  MOB-AND-TD-086, MOB-AND-TD-087,  MOB-AND-TD-088,MOB-AND-TD-089,  MOB-AND-TD-090,MOB-AND-TD-091, MOB-AND-TD-092,MOB-AND-TD-093,  MOB-AND-TD-094 MOB-AND-TD-113,MOB-AND-TD-116,MOB-AND-TD-119,MOB-AND-TD-122,MOB-AND-TD-125,MOB-AND-TD-128,MOB-AND-TD-131,MOB-AND-TD-134,MOB-AND-TD-040,MOB-AND-TD-043,MOB-AND-TD-046,MOB-AND-TD-049
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2012406"
    And I navigate to dashboard page
    And I click on Term Deposits in dashboard
    And I click on create new deposits menu
    And I select the deposit account with "USD" currency
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

    And I click on account menu from the term deposit tab
    And I select the funding account with card number "<creditFundingAccountNumber>"
    Then I should see the amount "<depositAmount>" reduced from the the funding account card
    And I should see the transaction "Takeover Principal" with debit amount "<accountDebit>" in the transaction history with today's date in accounts tab

    Examples:
      | period   | creditFundingAccountNumber | autoRenew | autoRenewType                            | depositAmount | accountDebit |
      | 01 Month | 4164108                    | Yes       | Renew initial amount and credit interest | 7500          | 7,500.00 USD |
      | 03 Month | 4164108                    | Yes       | Renew initial amount and credit interest | 7500          | 7,500.00 USD |
      | 06 Month | 4164108                    | Yes       | Renew initial amount and credit interest | 7500          | 7,500.00 USD |
      | 12 Month | 4164108                    | Yes       | Renew initial amount and credit interest | 7500          | 7,500.00 USD |
      | 01 Month | 4164108                    | Yes       | Renew initial amount only                | 7900          | 7,900.00 USD |
      | 03 Month | 4164108                    | Yes       | Renew initial amount only                | 7900          | 7,900.00 USD |
      | 06 Month | 4164108                    | Yes       | Renew initial amount only                | 7900          | 7,900.00 USD |
      | 12 Month | 4164108                    | Yes       | Renew initial amount only                | 7900          | 7,900.00 USD |