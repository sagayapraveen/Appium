@runPlan04
Feature: Domestic Account Transfers to new beneficiary

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with Fees on Sender option - MOB-AND-TRF-257 MOB-AND-TRF-258 MOB-AND-TRF-259 MOB-AND-TRF-260 MOB-AND-TRF-261 MOB-AND-TRF-262 MOB-AND-TRF-263 MOB-AND-TRF-264 MOB-AND-TRF-265 MOB-AND-TRF-266 MOB-AND-TRF-267 MOB-AND-TRF-268 MOB-AND-TRF-269 MOB-AND-TRF-270 MOB-AND-TRF-271 MOB-AND-TRF-272 MOB-AND-TRF-273 MOB-AND-TRF-274 MOB-AND-TRF-275 MOB-AND-TRF-276 MOB-AND-TRF-277 MOB-AND-TRF-278 MOB-AND-TRF-279 MOB-AND-TRF-280
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO54ARAB1110000000111006906102"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set "<payTo>" currency
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I swipe to see end of the page
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I swipe to see Back to Dashboard
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @domesticTransfers
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

  @capitalMobile @accountTransfers @newBeneficiaryTransfers @domesticTransfers
  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO54ARAB1110000000111006906102"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set "<payTo>" currency
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I swipe to see end of the page
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

    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber |
      | random            | JOD     | JOD   | 4154573              |
      | random            | USD     | JOD   | 4816263              |
      | random            | EUR     | JOD   | 4816264              |
      | random            | GBP     | JOD   | 4816265              |
      | random            | AED     | JOD   | 4816266              |