@runPlan03
Feature: Account Transfers to existing beneficiary Capital Bank

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: Existing Beneficiary Transfer Within Capital Bank from <payFrom> account - MOB-AND-TRF-001 MOB-AND-TRF-002 MOB-AND-TRF-003 MOB-AND-TRF-004 MOB-AND-TRF-005 MOB-AND-TRF-006 MOB-AND-TRF-007 MOB-AND-TRF-008 MOB-AND-TRF-009 MOB-AND-TRF-010 MOB-AND-TRF-011 MOB-AND-TRF-012 MOB-AND-TRF-013 MOB-AND-TRF-014 MOB-AND-TRF-015 MOB-AND-TRF-016 MOB-AND-TRF-017 MOB-AND-TRF-018 MOB-AND-TRF-019 MOB-AND-TRF-020 MOB-AND-TRF-021 MOB-AND-TRF-022 MOB-AND-TRF-023 MOB-AND-TRF-024
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION CBJ" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer Within Capital Bank" for Beneficiary
    And I set "<payTo>" currency
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Transfer from account" with "debit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount exchanged is reduced from the PayFrom account balance

    @capitalMobile @accountTransfers @existingBeneficiaryTransfers @withInCBJTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |
      | random            | EUR     | JOD   | 4816264              |
      | random            | GBP     | JOD   | 4816265              |
      | random            | AED     | JOD   | 4816266              |

    @smoke
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |

  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @withInCBJTransfers
  Scenario Outline: Existing Beneficiary Transfer Within Capital Bank from <payFrom> account with Flag "<flag>"
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION CBJ" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer Within Capital Bank" for Beneficiary
    And I set "<flag>" currency
    And I select the currency type as "<flag>"
    When I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Transfer from account" with "debit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount exchanged is reduced from the PayFrom account balance

    Examples:
      | transactionAmount | payFrom | flag | payFromAccountNumber |
      | random            | USD     | USD  | 4816263              |
      | random            | EUR     | EUR  | 4816264              |
      | random            | GBP     | GBP  | 4816265              |
      | random            | AED     | AED  | 4816266              |

    @sanity @p1
    Examples:
      | transactionAmount | payFrom | flag | payFromAccountNumber |
      | random            | USD     | USD  | 4816263              |
