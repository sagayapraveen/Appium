@runPlan01
Feature: My Transfers on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    And I navigate to Profile menu
    And I select the "My Transfers" from profile menu

  @capitalMobile @myTransfers
  Scenario: validate exit button and back button - MOB-AND-MTRF-015, MOB-AND-MTRF-016, MOB-AND-MTRF-017
    When I click close button
    Then  I should see the "Accounts" dashboard page

    When I navigate to Profile menu
    And I select the "My Transfers" from profile menu
    And I click on back to Profile menu
    Then I should see the "Customer ID" option on profile menu

  Scenario Outline: validate search button for capital bank for <bank> - MOB-AND-MTRF-013MOB-AND-MTRF-014,MOB-AND-MTRF-012,MOB-AND-MTRF-006,MOB-AND-MTRF-007,MOB-AND-MTRF-012,MOB-AND-MTRF-018,MOB-AND-MTRF-011
    When I click on the "<bank>" under My Transfer page
    And I click on the search icon
    Then I should see the page "Search Filter" page

    @capitalMobile @myTransfers
    Examples:
      | bank         |
      | Capital Bank |
      | Overseas     |
      | Domestic     |

    @p1
    Examples:
      | bank         |
      | Capital Bank |

  @capitalMobile @myTransfers
  Scenario Outline: validate share button for <bank> - MOB-AND-MTRF-001, MOB-AND-MTRF-002, MOB-AND-MTRF-003
    When I click on the "<bank>" under My Transfer page
    And I select the transaction to share
    Then I should check the share button is clickable

    Examples:
      | bank         |
      | Capital Bank |
      | Overseas     |
      | Domestic     |

  @capitalMobile @myTransfers
  Scenario Outline: Validating swift image link for <bank> - MOB-AND-MTRF-019, MOB-AND-MTRF-021, MOB-AND-MTRF-022
    When I click on the "<bank>" under My Transfer page
    And I select the transaction "<transactionName>"
    Then I should verify view swift Image link is clickable

    Examples:
      | bank     | transactionName     |
      | Overseas | MEEZAN BANK LIMITED |
      | Domestic | BANK ALETIHAD       |

  @capitalMobile @myTransfers
  Scenario: Validate exit button and back button - MOB-AND-MTRF-024, MOB-AND-MTRF-025, MOB-AND-MTRF-026,MOB-AND-MTRF-020, MOB-AND-MTRF-023
    When I click on the "Capital Bank" under My Transfer page
    And I select the transaction "NUJUD MOHAMMED EID AL-SOUDANI"
    Then I should Verify the transaction details
      | Account Number   | 4156411                       |
      | Beneficiary Name | NUJUD MOHAMMED EID AL-SOUDANI |
    And I click on back button from transaction details

    When I click on the "Overseas" under My Transfer page
    And I select the transaction "THE SAUDI NATIONAL BANK"
    Then I should Verify the transaction details
      | Account Number   | SA661000002234869000010 |
      | Beneficiary Name | TEST TEST               |
    And  I click on back button from transaction details

    When I click on the "Domestic" under My Transfer page
    And I select the transaction "NASER"
    Then I should Verify the transaction details
      | Account Number   | 4154673 |
      | Beneficiary Name | NASER   |