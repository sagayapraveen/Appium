@runPlan01
Feature: Account Statement on CapitalMobile app

  @capitalMobile @accountStatement
  Scenario Outline: Verify E-Statement in JOD currency with <currency/accountNumber>  - MOB-AND-ESMT-001, MOB-AND-ESMT-002, MOB-AND-ESMT-003, MOB-AND-ESMT-004, MOB-AND-ESMT-005, MOB-AND-ESMT-006, MOB-AND-ESMT-007, MOB-AND-ESMT-013, MOB-AND-ESMT-014, MOB-AND-ESMT-020, MOB-AND-ESMT-021, MOB-AND-ESMT-027, MOB-AND-ESMT-028
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2005746"
    And I navigate to dashboard page
    And I click on account in dashboard
    And I select the funding account with card number "<currency/accountNumber>"
    And I scroll to the "TRANSACTIONS" in account dashboard
    And I click on view more button
    And I click on E-Statement in transaction page
    Then I should see the "Statement Year" along with the "Statement Month"

    When I click on statement month dropdown in E-Statement
    Then I should see the "February" month in dropdown list

    When I click on statement year dropdown in E-Statement
    Then I should see the "2023" years in dropdown list

    When I click on statement year dropdown in E-Statement
    And I select the year "<year>" in select statement year
    And I select the month "<month>" in select statement month
    And I click on generate PDF
    Then I should see the "pdf" in E-statement

    # Data available only for June month
    Examples:
      | currency/accountNumber | year | month |
      | 4171175                | 2023 | June  |
      | 4544785                | 2023 | June  |
      | 4812491                | 2023 | June  |

  @capitalMobile @accountStatement
  Scenario Outline: Verify E-Statement in JOD currency with <currency/account> - MOB-AND-ESMT-015, MOB-AND-ESMT-017, MOB-AND-ESMT-022, MOB-AND-ESMT-029
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2083500"
    And I navigate to dashboard page
    And I click on account in dashboard
    And I select the funding account with card number "<currency/account>"
    And I scroll to the "TRANSACTIONS" in account dashboard
    And I click on view more button
    And I click on E-Statement in transaction page
    And I click on statement year dropdown in E-Statement
    And  I select the year "<year>" in select statement year
    And I select the month "<month>" in select statement month
    And I click on generate PDF
    Then I should see the "pdf" in E-statement

    Examples:
      | currency/account | year | month |
      | 4539986          | 2023 | May   |