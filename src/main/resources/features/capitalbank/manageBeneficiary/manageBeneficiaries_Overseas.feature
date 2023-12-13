@runPlan01
Feature: Manage Beneficiaries - Overseas Beneficiaries

  Background: Navigation of Overseas Beneficiary page
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    When I navigate to Profile menu
    And I select the "Overseas Bank Beneficiary" from the profile

  @capitalMobile @manageBeneficiary @overseasBeneficiary
  Scenario: Add new Overseas beneficiary - MOB-AND-MNGBEN-008 MOB-AND-MNGBEN-009 MOB-AND-MNGBEN-010 MOB-AND-MNGBEN-011 MOB-AND-MNGBEN-012
    And I click the add beneficiary
    And I add the new "Overseas Bank" beneficiary with
      | Account/IBAN          | AL35202111090000000001234567 |
      | Address               | Amman                        |
      | Overseas bank country | United Arab Emirates         |
    And I confirm the "Overseas Bank" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @overseasBeneficiary
  Scenario: Update the created Overseas Beneficiaries -  MOB-AND-MNGBEN-013 MOB-AND-MNGBEN-014 MOB-AND-MNGBEN-015 MOB-AND-MNGBEN-016 MOB-AND-MNGBEN-017
    And I select the created beneficiary for "Overseas Bank" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Overseas Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @overseasBeneficiary
  Scenario: Delete the created Overseas Beneficiaries -  MOB-AND-MNGBEN-018 MOB-AND-MNGBEN-019 MOB-AND-MNGBEN-020
    And I delete the created "Overseas Bank" beneficiary
    Then I should not see the deleted name in the "Overseas Bank" beneficiaries list

  @capitalMobile @manageBeneficiary @overseasBeneficiary
  Scenario: Add new Overseas beneficiary - Negative case - MOB-AND-MNGBEN-021
    And I click the add beneficiary

    When I set a IBAN number "AL3520211109000000000123456"
    Then I should see the error pop-up "Error Invalid beneficiary IBAN/account number."

    When I change the invalid "Iban" as "AL3520211109000000000123456-"
    Then I should see the field level error message "Iban Can Only Contain Alphanumerics"