@runPlan03
Feature: Account Transfers to new beneficiary

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: New Beneficiary Transfer Within Capital Bank from <payFrom> account - MOB-AND-TRF-233 MOB-AND-TRF-234 MOB-AND-TRF-235 MOB-AND-TRF-236 MOB-AND-TRF-237 MOB-AND-TRF-238 MOB-AND-TRF-239 MOB-AND-TRF-240 MOB-AND-TRF-241 MOB-AND-TRF-242 MOB-AND-TRF-243 MOB-AND-TRF-244 MOB-AND-TRF-245 MOB-AND-TRF-246 MOB-AND-TRF-247 MOB-AND-TRF-248 MOB-AND-TRF-249 MOB-AND-TRF-250 MOB-AND-TRF-251 MOB-AND-TRF-252 MOB-AND-TRF-253 MOB-AND-TRF-254 MOB-AND-TRF-255 MOB-AND-TRF-256
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO66EFBK0010000000000004815836"
    And I enter the transfer amount "<transactionAmount>" in "Transfer Within Capital Bank" for Beneficiary
    And I set the recipient name as "TEST TEST TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Transfer from account" with "debit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount exchanged is reduced from the PayFrom account balance

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @withInCBJTransfers
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber |
      | random            | JOD     | 4154573              |
      | random            | USD     | 4816263              |
      | random            | EUR     | 4816264              |
      | random            | GBP     | 4816265              |
      | random            | AED     | 4816266              |

    @sanity @p1
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber |
      | random            | JOD     | 4154573              |

  Scenario Outline: New Beneficiary Transfer Within Capital Bank from <payFrom> account with Flag <flag>
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO66EFBK0010000000000004815836"
    And I enter the transfer amount "<transactionAmount>" in "Transfer Within Capital Bank" for Beneficiary
    And I set "<flag>" currency
    And I select the currency type as "<flag>" for new beneficiary within CBJ
    And I set the recipient name as "TEST TEST TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Transfer from account" with "debit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount exchanged is reduced from the PayFrom account balance

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @withInCBJTransfers
    Examples:
      | transactionAmount | payFrom | flag | payFromAccountNumber |
      | random            | USD     | JOD  | 4816263              |
      | random            | EUR     | JOD  | 4816264              |
      | random            | GBP     | JOD  | 4816265              |
      | random            | AED     | JOD  | 4816266              |

    @p1
    Examples:
      | transactionAmount | payFrom | flag | payFromAccountNumber |
      | random            | USD     | JOD  | 4816263              |