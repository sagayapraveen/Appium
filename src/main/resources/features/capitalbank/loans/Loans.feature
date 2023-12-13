@runPlan01
Feature: Loans on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page

  @capitalMobile @loan
  Scenario Outline: Verify saved beneficiary local currency in <beneficiary> - MOB-AND-LOAN-008, MOB-AND-LOAN-009, MOB-AND-LOAN-010
    When I click on Transfer in dashboard page
    And I select the card "JOD" in pay from page
    And I search for saved beneficiary to select "<beneficiary>"
    Then I should see the local currency "JOD"

    Examples:
      | beneficiary   |
      | Invest        |
      | test transfer |
      | ABC           |

  @p1
  @capitalMobile @loan
  Scenario: Verify pre-paid, Post-paid local currency - MOB-AND-LOAN-012, MOB-AND-LOAN-013, MOB-AND-LOAN-007
    When I click on pay bill button
    And I select the card "JOD" in pay from page
    And I click on postpaid tab
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I click on next in pay to page
    Then I should see local currency "JOD"
    And I click close button

    When I click on pay bill button
    And I click on prepaid button
    And I select the card "JOD" in pay from page
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I select the denomination "1"
    Then I should see local currency "JOD"
    And I click close button

    When I click on Transfer in dashboard page
    And I select the card "JOD" in pay from page
    And I click on own account Own account in transfer page
    And I select the card "GBP" in pay to page
    Then I should see the local currency "JOD" transfer page

  @capitalMobile @loan
  Scenario: Validate loan tenor, Next Payment - MOB-AND-LOAN-002, MOB-AND-LOAN-003, MOB-AND-LOAN-004
    When I click on Loans in dashboard
    Then I should see the "Loan Tenor" in loans page

    When I click on Loans in dashboard
    Then I should see the "Your next payment for the loan is due in" in loans page

    When I click on View portfolio in dashboard page
    Then I should see the "LOANS" is displayed

  @capitalMobile @loan
  Scenario: Validate loan schedule -MOB-AND-LOAN-001,MOB-AND-LOAN-006,MOB-AND-LOAN-005
    When I click on Loans in dashboard
    And I scroll to the "LOAN DETAILS" in loan dashboard
    And I fetch the loan details
    And I scroll to the "LOAN SCHEDULE" in loan dashboard
    And I click on view more button
    Then I should see the load schedule "Loan Payment"

  @capitalMobile @loan
  Scenario: Verify credit card settlement -MOB-AND-LOAN-011
    When I click on cards in dashboard
    And I select the dropdown
    And select the "Credit Card" from dropdown menu
    And I click on settle card in cards page
    And I select the card "JOD" in pay from page
    And I enter the amount to settle card
    And I enter the amount "250" in "Credit Card Payment"
    And I click on next button
    Then I should see the "JOD" in pay from  account