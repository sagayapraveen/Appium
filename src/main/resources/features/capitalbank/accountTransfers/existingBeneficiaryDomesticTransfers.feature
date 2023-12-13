@runPlan03
Feature:Domestic Account Transfers to existing beneficiary

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click on the transfers menu

  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with Fees on Sender option - MOB-AND-TRF-025 MOB-AND-TRF-026 MOB-AND-TRF-027 MOB-AND-TRF-028 MOB-AND-TRF-029 MOB-AND-TRF-030 MOB-AND-TRF-031 MOB-AND-TRF-032 MOB-AND-TRF-033 MOB-AND-TRF-034 MOB-AND-TRF-035 MOB-AND-TRF-036 MOB-AND-TRF-037 MOB-AND-TRF-038 MOB-AND-TRF-039 MOB-AND-TRF-040 MOB-AND-TRF-041 MOB-AND-TRF-042 MOB-AND-TRF-043 MOB-AND-TRF-044 MOB-AND-TRF-045 MOB-AND-TRF-046 MOB-AND-TRF-047 MOB-AND-TRF-048
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
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
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |
      | random            | EUR     | JOD   | 4816264              |
      | random            | GBP     | JOD   | 4816265              |
      | random            | AED     | JOD   | 4816266              |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |

  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set "<payTo>" currency
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |
      | random            | EUR     | JOD   | 4816264              |
      | random            | GBP     | JOD   | 4816265              |
      | random            | AED     | JOD   | 4816266              |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |