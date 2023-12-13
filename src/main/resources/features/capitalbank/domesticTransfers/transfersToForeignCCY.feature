@runPlan01
Feature: Domestic Transfers with Foreign Currency on CapitalMobile app

  Background: Navigation to transferPage
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2005746"
    And I navigate to dashboard page
    When I click the transfers menu

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - JOD to USD -MOB-AND-TRF-028
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I Select the amount as "USD"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "JOD" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - JOD to AED -MOB-AND-TRF-034
    And I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I Select the amount as "AED"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "JOD" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - AED to EUR -MOB-AND-TRF-033
    And I select "AED" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I selected the amount as "EUR"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "AED" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - USD to GBP -MOB-AND-TRF-031
    And I select "USD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I selected the amount as "GBP"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "USD" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile  @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - EUR to GBP -MOB-AND-TRF-032
    And I select "EUR" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I selected the amount as "GBP"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate for "EUR" for the amount "10"
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer
  Scenario: Transfers with new Beneficiary - Domestic IBAN - USD to USD -OB-AND-TRF-030
    And I select "USD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10" to "Domestic"
    And I selected the amount as "USD"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    And I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details