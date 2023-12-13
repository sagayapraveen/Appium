@runPlan01
Feature: Request Money with CliQ

  Background: Navigation to request money Page
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    When I navigate to Request Money menu

  @sanity @p1
  @capitalMobile @dashboard @requestMoneyCbj
  Scenario: Requesting money from existing beneficiary - MOB-AND-DAB-001, MOB-AND-DAB-002, MOB-AND-DAB-003, MOB-AND-DAB-004, MOB-AND-DAB-005, MOB-AND-DAB-038
    When I enter the request money amount
    And I select the existing Beneficiary "IZZIDIN" for the Request money
    And I enter request details description as "Request money"
    And I select the purpose as "Transfer to Friend or Family at a bank"
    Then I verify the "Existing" entered details

    When I confirm the Request money
    Then I should see the confirmation message for request money

    When I click back to dashboard option
    And I navigate to Request History menu
    Then I should see the latest transaction details

  @capitalMobile @dashboard @requestMoneyCbj
  Scenario: Requesting money from new IBAN beneficiary - MOB-AND-DAB-014, MOB-AND-DAB-015, MOB-AND-DAB-016, MOB-AND-DAB-041
    When I enter the request money amount
    And I select new beneficiary with "IBAN"
    And I enter "JO39EFBK0010000000000004176995"
    And I enter  request details
      | Recipient Name    | Testing       |
      | Recipient Address | Jodan         |
      | Description       | Request money |
    And I select the purpose as "Transfer to Friend or Family at a bank"
    Then I verify the "IBAN" entered details

    When I confirm the Request money
    Then I should see the confirmation message for request money

    When I click back to dashboard option
    And I navigate to Request History menu
    Then I should see the latest transaction details

  @capitalMobile @dashboard @requestMoneyCbj
  Scenario: Requesting money from invalid IBAN - MOB-AND-DAB-017
    When I enter the request money amount
    And I select new beneficiary with "IBAN"
    And I enter "JO39EFBK0010000000000004176777"
    Then I should see the error pop-up "Error Invalid IBAN"

  @capitalMobile @dashboard @requestMoneyCbj
  Scenario Outline: Requesting money from new mobile and alias beneficiary for <Type> - MOB-AND-DAB-006, MOB-AND-DAB-007, MOB-AND-DAB-008, MOB-AND-DAB-009, MOB-AND-DAB-010, MOB-AND-DAB-011, MOB-AND-DAB-012, MOB-AND-DAB-013, MOB-AND-DAB-039, MOB-AND-DAB-040
    When I enter the request money amount
    And I select new beneficiary with "<Type>"
    And I enter "<Keyword>"
    And I select done button in details page
    And I enter request details description as "<Description>"
    And I select the purpose as "<Purpose>"
    Then I verify the "<Type>" entered details

    When I confirm the Request money
    Then I should see the confirmation message for request money

    When I click back to dashboard option
    And I navigate to Request History menu
    Then I should see the latest transaction details

    Examples:
      | Type   | Keyword   | Description   | Purpose                                                                        |
      | Mobile | 778010119 | Request money | Transfer to Friend or Family from a Personal wallet to an individual at a bank |
      | Alias  | MAR       | Request money | Transfer to Friend or Family at a bank                                         |

  @capitalMobile @dashboard @requestMoneyCbj
  Scenario Outline: Validation of error <errorMessage> for invalid beneficiary - MOB-AND-DAB-042, MOB-AND-DAB-043, MOB-AND-DAB-044, MOB-AND-DAB-045
    When I enter the request money amount
    And I select new beneficiary with "<type>"
    And I enter "<keyword>"
    Then I should see the error message "<errorMessage>" for mobile

    Examples:
      | type   | keyword | errorMessage                              |
      | Mobile | 778010  | Mobile number should be of 9 digits       |
      | Alias  |         | Alias cannot be empty                     |
      | Alias  | MA      | Alias Should Be Greater Than 3 Characters |
      | Alias  | mn12    | Alias must have atleast 1 Uppercase       |

  @capitalMobile @dashboard @requestMoneyCbj
  Scenario Outline: Requesting money Dashboard verification to other mobile for <type> - MOB-AND-DAB-047, MOB-AND-DAB-048, MOB-AND-DAB-049, MOB-AND-DAB-050, MOB-AND-DAB-051,
    When I enter the request money amount
    And I select new beneficiary with "Alias"
    And I enter "MAR24"
    And I select done button in details page
    And I enter request details description as "Request money"
    And I select the purpose as "Transfer to Friend or Family at a bank"
    Then I verify the "Alias" entered details

    When I confirm the Request money
    Then I should see the confirmation message for request money

    When I click back to dashboard option
    And I navigate to Request History menu
    Then I should see the latest transaction details

    When I have launched the CBJ app
    And I have logged in the CBJ app with username as "2005564"
    And I navigate to dashboard page
    And I click on CliQ in dashboard
    And I select the request tab
    And I "<type>" the request
    And I verify the mobile otp pin 654321
    Then I should see "Your request is successful"

    When I have logged in the CBJ app
    And I navigate to dashboard page
    And I navigate to Request History menu
    Then I should see the request "<type>" in request history menu

    Examples:
      | type   |
      | Accept |
      | Reject |