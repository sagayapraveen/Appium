@runPlan01
Feature: Overseas Transfers on CapitalMobile app

  Background: Navigation to transferPage
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2005746"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile @domesticTransfer @overseasTransfer
  Scenario: Transfers with new Beneficiary - Overseas IBAN - USA -MOB-AND-TRF-077,MOB-AND-TRF-056,MOB-AND-TRF-040,MOB-AND-TRF-16
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "325062581747"
    And I search for "United States of America" in Transfers page
    And I enter the transfer amount "10.10" to "Overseas"
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I set the Routing Number "026009593" for payee
    And I set the Swift Label "BOFAUS3N" for payee
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "JOD" for the amount "10.10"
    When I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer @overseasTransfer
  Scenario: Transfers with new Beneficiary - JOD Overseas IBAN -MOB-AND-TRF-035
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "SA6610000022348690000102"
    And I enter the transfer amount "10.10" to "Overseas"
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "JOD" for the amount "10.10"
    When I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details

  @capitalMobile @domesticTransfer @overseasTransfer
  Scenario: Transfers with new Beneficiary - EUR Overseas IBAN  -MOB-AND-TRF-037
    When I select "USD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "SA6610000022348690000102"
    And I enter the transfer amount "10.10" to "Overseas"
    And I Select the amount as "EUR"
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the exchange rate from "USD" for the amount "10.10"
    When I confirm the transfer
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the Transfer successful message with the details
