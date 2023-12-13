@runPlan01
Feature: Manage Beneficiaries - Within CBOJ Beneficiaries

  Background: Navigation of Within CBOJ Beneficiary page
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    When I navigate to Profile menu
    And I select the "Within CBOJ Beneficiary" from the profile

  @capitalMobile @manageBeneficiary @withinCboj
  Scenario: Add new Within CBOJ beneficiary - MOB-AND-MNGBEN-001 MOB-AND-MNGBEN-002 MOB-AND-MNGBEN-003
    And I click the add beneficiary
    And I add the new "Within CBOJ" beneficiary with
      | Account/IBAN          | 4170465              |
      | Address               | Amman                |
    And I confirm the "Within CBOJ" beneficiary details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for new beneficiary

  @capitalMobile @manageBeneficiary @withinCboj
  Scenario: Update the created Within CBOJ Beneficiaries - MOB-AND-MNGBEN-004 MOB-AND-MNGBEN-005
    And I select the created beneficiary for "Within CBOJ" beneficiaries

    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I change the nickname and save
    Then I should see the updated name in the "Within CBOJ" beneficiaries list

  @capitalMobile @manageBeneficiary @withinCboj
  Scenario: Delete the created Within CBOJ Beneficiaries - MOB-AND-MNGBEN-006
    And I delete the created "Within CBOJ" beneficiary
    Then I should not see the deleted name in the "Within CBOJ" beneficiaries list

  @capitalMobile @manageBeneficiary @withinCboj
  Scenario: Add new Within CBOJ beneficiary - Negative case -  MOB-AND-MNGBEN-007
    And I click the add beneficiary

    When I set a Account number "417046!"
    Then I should see the field level error message "Please enter valid iban"

    When I set a Account number "4170465"
    When I clear the nickname to proceed
    Then I should see the field level error message "Nick name cannot be empty"

    When I change the invalid "nickname" as "Test 123@"
    Then I should see the field level error message "Nick name can only contain alphanumerics"

    When I clear the name to proceed
    Then I should see the field level error message "Name cannot be empty"
