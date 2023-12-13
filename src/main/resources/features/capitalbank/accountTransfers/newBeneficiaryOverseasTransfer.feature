@runPlan04
Feature: Overseas Account Transfers to new beneficiary

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: New Beneficiary Transfer to Overseas from <payFrom> account with Fees on Sender option - MOB-AND-TRF-369 MOB-AND-TRF-370 MOB-AND-TRF-371 MOB-AND-TRF-372 MOB-AND-TRF-373 MOB-AND-TRF-374 MOB-AND-TRF-375 MOB-AND-TRF-376 MOB-AND-TRF-377 MOB-AND-TRF-378 MOB-AND-TRF-379 MOB-AND-TRF-380 MOB-AND-TRF-005 MOB-AND-TRF-006 MOB-AND-TRF-010 MOB-AND-TRF-011 MOB-AND-TRF-015 MOB-AND-TRF-016 MOB-AND-TRF-020 MOB-AND-TRF-021 MOB-AND-TRF-025 MOB-AND-TRF-026 MOB-AND-TRF-030 MOB-AND-TRF-031
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "AE070331234567890123456"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
    And I set "<payTo>" currency
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers

    When I swipe to see Back to Dashboard
    And I click back to dashboard option
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @overseasTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | USD   | 4154573              |
      | random            | USD     | USD   | 4816263              |
      | random            | EUR     | USD   | 4816264              |
      | random            | GBP     | USD   | 4816265              |
      | random            | AED     | USD   | 4816266              |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | USD   | 4154573              |

  Scenario Outline: New Beneficiary Transfer to Overseas from <payFrom> account with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "AE070331234567890123456"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
    And I set "<payTo>" currency
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I swipe to see Back to Dashboard
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @overseasTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | USD   | 4154573              |
      | random            | USD     | USD   | 4816263              |
      | random            | EUR     | USD   | 4816264              |
      | random            | GBP     | USD   | 4816265              |
      | random            | AED     | USD   | 4816266              |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | USD   | 4154573              |