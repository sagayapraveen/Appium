@runPlan01
Feature: Overdraft Transfer on CapitalMobile app

  Background: Navigation to Dashboard Page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2056482"
    And I navigate to dashboard page
    And I click on overdraft menu
    And I click the transfers menu

  @capitalMobile @overDraft @overdraftTransfer
  Scenario Outline: Creating overdraft Transfer for Own account with PayTo currency as <PayToCurrency>-MOB-AND-VAL-021,MOB-AND-VAL-022,MOB-AND-VAL-023,MOB-AND-VAL-024,MOB-AND-VAL-025,MOB-AND-VAL-026,MOB-AND-VAL-027
    When I select "<PayFromCurrency>" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I select pay to as own account
    And I select "<PayToCurrency>" card from pay to account with number "<PayToAccount>"
    And I enter the transfer amount "<Amount>" to "<Account>"
    And I enter the description as "<description>" for Overdraft transfers
    And I click on next button
    Then I should verify the details in the confirm page of overdraft

    When I confirm the overdraft transfer
    Then I should see the transfer successful message "<Message>"

    When I click back to dashboard option
    Then I should see the amount reduced from the overdraft Account card

    Examples:
      | PayFromCurrency | PayToCurrency | PayToAccount | Amount | Account     | description | Message              |
      | JOD             | USD           | 4812357      | 10     | Own Account | testing     | Transfer successful! |
      | JOD             | JOD           | 4146231      | 1      | Own Account | testing     | Transfer successful! |

  @capitalMobile @overDraft @overdraftTransfer
  Scenario: Creating overdraft Transfer JOD to JOD with new beneficiary-MOB-AND-VAL-028,MOB-AND-VAL-029,MOB-AND-VAL-030
    When I select "JOD" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I click on pay From account as new Beneficiary
    And I select new Beneficiary for transfers with the IBAN number "JO94CBJO0010000000000131000302"
    And I enter the transfer amount "10" to "Domestic"
    And I set the recipient name "test sample test" and recipient address "Jordan"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I select the charge options as "Fees on Sender"

    And I enter the description as "testing" for Overdraft transfers
    And I click on next button
    Then I should verify the confirm page of overdraft

    When I confirm the overdraft transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the transfer successful message "Transfer successful!"

    When I click back to dashboard option
    Then I should see the amount reduced from the overdraft Account card

  @capitalMobile @overDraft @overdraftTransfer
  Scenario: Creating overdraft Transfer from existing beneficiary list-MOB-AND-VAL-032,MOB-AND-VAL-033,MOB-AND-VAL-034
    When I select "JOD" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I select "Housing BANK IBAN" from the existing beneficiary
    And I enter the transfer amount "2" to "Domestic"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |

    And I select the charge options as "Fees on Sender"
    And I enter the description as "testing" for Overdraft transfers
    And I click on next button
    Then I should verify the confirm page of overdraft

    When I confirm the overdraft transfer
    Then I should see the transfer successful message "Transfer successful!"

    When I click back to dashboard option
    Then I should see the amount reduced from the overdraft Account card

  @capitalMobile @overDraft @overdraftTransfer
  Scenario: Creating overdraft Transfer by entering invalid recipient name-negative testcase-MOB-AND-VAL-036
    When I select "JOD" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I click on pay From account as new Beneficiary
    And I select new Beneficiary for transfers with the IBAN number "JO94CBJO0010000000000131000302"
    And I enter the transfer amount "10" to "Domestic"
    And I set the recipient name as "test"
    Then I should see alert message "Please enter at least 3 names with a minimum of 3 characters in the first and last name" for overdraft

  @capitalMobile @overDraft @overdraftTransfer
  Scenario: Creating overdraft Transfer with amount more than available balance - negative testcase-MOB-AND-VAL-035
    When I select "JOD" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I select "Housing BANK IBAN" from the existing beneficiary
    And I enter the transfer amount with more than available balance to "Domestic"
    Then I verify entered amount is greater than available balance in the card

    When I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing" for Overdraft transfers
    And I click on next button
    And I confirm the overdraft transfer
    Then I should see the error pop-up "Error Your transaction was not processed due to insufficient balance. For more details please reach to our Contact Center on 06-5100220"

  @capitalMobile @overDraft @overdraftTransfer
  Scenario: Creating overdraft with invalid IBAN-negative testcase-MOB-AND-VAL-031
    When I select "JOD" account under overdraft Account
    And I fetch the amount from the payFrom card
    And I click on pay From account as new Beneficiary
    And I select new Beneficiary for transfers with the IBAN number "JO94CBJO001000000000013100665"
    Then I should see the error pop-up "Error Invalid IBAN"