@runPlan01
Feature: Manage Beneficiaries - Local Bank Beneficiaries

  Background: Navigation of Local Beneficiary page
    #Given I have logged in the CBJ app
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2056420"
    And I navigate to dashboard page
    And I navigate to Profile menu
    And I select the "Local Bank Beneficiary" from the profile

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - Domestic - MOB-AND-MNGBEN-022 MOB-AND-MNGBEN-023 MOB-AND-MNGBEN-024 MOB-AND-MNGBEN-025
    When I click the add beneficiary
    And I add the new Local Bank beneficiary with
      | Transaction type | Domestic                       |
      | IBAN             | JO94CBJO0010000000000131000302 |
    And I confirm the "Local Bank" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Update the created Local Bank Beneficiaries - Domestic - MOB-AND-MNGBEN-022 MOB-AND-MNGBEN-023 MOB-AND-MNGBEN-024 MOB-AND-MNGBEN-025
    And I select the created beneficiary for "Local Bank" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Delete the created Local Bank Beneficiaries - Domestic - MOB-AND-MNGBEN-022 MOB-AND-MNGBEN-023 MOB-AND-MNGBEN-024 MOB-AND-MNGBEN-025
    When I delete the created "Local Bank" beneficiary
    Then I should not see the deleted name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - CliQ Alias -  MOB-AND-MNGBEN-026 MOB-AND-MNGBEN-027 MOB-AND-MNGBEN-028 MOB-AND-MNGBEN-029 MOB-AND-MNGBEN-030 MOB-AND-MNGBEN-031
    When I click the add beneficiary
    And I add the new Local Bank beneficiary with
      | Transaction type      | CliQ       |
      | Cliq beneficiary type | Cliq Alias |
      | Alias                 | MAR        |
    And I confirm the "Local Bank" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Update the created Local Bank Beneficiaries - CliQ Alias -  MOB-AND-MNGBEN-026 MOB-AND-MNGBEN-027 MOB-AND-MNGBEN-028 MOB-AND-MNGBEN-029 MOB-AND-MNGBEN-030 MOB-AND-MNGBEN-031
    And I select the created beneficiary for "Local Bank" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Delete the created Local Bank Beneficiaries - CliQ Alias -  MOB-AND-MNGBEN-026 MOB-AND-MNGBEN-027 MOB-AND-MNGBEN-028 MOB-AND-MNGBEN-029 MOB-AND-MNGBEN-030 MOB-AND-MNGBEN-031
    When I delete the created "Local Bank" beneficiary
    Then I should not see the deleted name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - Cliq Mobile Number -  MOB-AND-MNGBEN-032 MOB-AND-MNGBEN-033 MOB-AND-MNGBEN-034 MOB-AND-MNGBEN-035 MOB-AND-MNGBEN-036 MOB-AND-MNGBEN-037
    When I click the add beneficiary
    And I add the new Local Bank beneficiary with
      | Transaction type      | CliQ               |
      | Cliq beneficiary type | Cliq Mobile Number |
      | MobileNumber          | 796401604          |
    And I confirm the "Local Bank" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Update the created Local Bank Beneficiaries - Cliq Mobile Number -  MOB-AND-MNGBEN-032 MOB-AND-MNGBEN-033 MOB-AND-MNGBEN-034 MOB-AND-MNGBEN-035 MOB-AND-MNGBEN-036 MOB-AND-MNGBEN-037
    And I select the created beneficiary for "Local Bank" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Delete the created Local Bank Beneficiaries - Cliq Mobile Number - MOB-AND-MNGBEN-032 MOB-AND-MNGBEN-033 MOB-AND-MNGBEN-034 MOB-AND-MNGBEN-035 MOB-AND-MNGBEN-036 MOB-AND-MNGBEN-037
    When I delete the created "Local Bank" beneficiary
    Then I should not see the deleted name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - CliQ IBAN
    When I click the add beneficiary
    And I add the new Local Bank beneficiary with
      | Transaction type      | CliQ                           |
      | IBAN                  | JO94CBJO0010000000000131000302 |
      | Cliq beneficiary type | IBAN                           |
    And I confirm the "Local Bank" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Update the created Local Bank Beneficiaries - Cliq IBAN - MOB-AND-MNGBEN-032 MOB-AND-MNGBEN-033 MOB-AND-MNGBEN-034 MOB-AND-MNGBEN-035 MOB-AND-MNGBEN-036 MOB-AND-MNGBEN-037
    And I select the created beneficiary for "Local Bank" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Delete the created Local Bank Beneficiaries - Cliq IBAN - MOB-AND-MNGBEN-032 MOB-AND-MNGBEN-033 MOB-AND-MNGBEN-034 MOB-AND-MNGBEN-035 MOB-AND-MNGBEN-036 MOB-AND-MNGBEN-037
    When I delete the created "Local Bank" beneficiary
    Then I should not see the deleted name in the "Local Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - Domestic - Negative -  MOB-AND-MNGBEN-038 MOB-AND-MNGBEN-039 MOB-AND-MNGBEN-040
    And I click the add beneficiary
    And I select the beneficiary transaction type as "Domestic"

    When I change the invalid "Iban" as "Test 123@"
    Then I should see the field level error message "Please enter valid iban"

    When I change the invalid "Iban" as "JOD-"
    Then I should see the field level error message "Iban Can Only Contain Alphanumerics"

    When I set a IBAN number "JO94CBJO001000000000013100030"
    Then I should see the error pop-up "Error Invalid beneficiary IBAN/account number."

  @capitalMobile @manageBeneficiary @localBankBeneficiary
  Scenario: Add new Local beneficiary - CliQ IBAN - Negative -  MOB-AND-MNGBEN-038 MOB-AND-MNGBEN-039 MOB-AND-MNGBEN-040
    And I click the add beneficiary
    And I select the beneficiary transaction type as "CliQ"
    And I select the beneficiary type as "CliQ IBAN"

    When I clear the name to proceed
    Then I should see the field level error message "Name cannot be empty"

    When I enter name as "Test Test Test Test"
    And I clear the address to proceed
    Then I should see the field level error message "Recipient address cannot be empty"

    When I enter address as "Amman"
    And I change the invalid "Iban" as "JOD-"
    Then I should see the field level error message "Iban Can Only Contain Alphanumerics"

    When I set a IBAN number "JO94CBJO00100000000001310003011"
    And I fill the basic beneficiary details for "Local Bank" beneficiary
    Then I should see the error pop-up "Error Invalid IBAN"

