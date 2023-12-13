@runPlan04
Feature: Overseas Account Transfers to existing beneficiary

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: Existing Beneficiary Transfer to Overseas from <payFrom> account with Fees on Sender option - MOB-AND-TRF-129 MOB-AND-TRF-130 MOB-AND-TRF-131 MOB-AND-TRF-132 MOB-AND-TRF-133 MOB-AND-TRF-134 MOB-AND-TRF-135 MOB-AND-TRF-136 MOB-AND-TRF-137 MOB-AND-TRF-138 MOB-AND-TRF-139 MOB-AND-TRF-140 MOB-AND-TRF-141 MOB-AND-TRF-142 MOB-AND-TRF-143 MOB-AND-TRF-144 MOB-AND-TRF-145 MOB-AND-TRF-146 MOB-AND-TRF-147 MOB-AND-TRF-148 MOB-AND-TRF-149 MOB-AND-TRF-150 MOB-AND-TRF-151 MOB-AND-TRF-152
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION OVERSEAS" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
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

    @capitalMobile @accountTransfers @existingBeneficiaryTransfers @overseasTransfers
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

  Scenario Outline: Existing Beneficiary Transfer to Overseas from <payFrom> account with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION OVERSEAS" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
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

    @capitalMobile @accountTransfers @existingBeneficiaryTransfers @overseasTransfers
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