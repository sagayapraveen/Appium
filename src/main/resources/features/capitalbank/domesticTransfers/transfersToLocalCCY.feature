@runPlan01
Feature: Domestic Transfers with Local Currency on CapitalMobile app

  Background: Navigation to transferPage
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2005746"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - GBP to JOD -MOB-AND-TRF-026
    And I select "GBP" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10.10" to "Domestic"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate for "GBP" for the amount "10.10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - USD to JOD -MOB-AND-TRF-025
    And I select "USD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10.10" to "Domestic"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate for "USD" for the amount "10.10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - AED to JOD -MOB-AND-TRF-027
    And I select "AED" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate for "AED" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - JOD to JOD -MOB-AND-TRF-024
    And I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO36HBHO1360000121586500105001"
    And I enter the transfer amount "1" to "Domestic"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details