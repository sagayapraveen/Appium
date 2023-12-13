@runPlan01
Feature: Dashboard verification on CapitalMobile app

  @capitalMobile @dashboard
  Scenario: Dashboard Verification for dormunt account - MOB-AND-SSEC-010
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2003533"
    And I navigate to dashboard page
    When I select the card as "4011148"
    Then I should verify the accounts card details in Account detail tab

  @capitalMobile @dashboard
  Scenario Outline: Dashboard Verification for account type <accountType> and currency <currency> - MOB-AND-SSEC-005, MOB-AND-SSEC-008
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2012406"
    And I navigate to dashboard page
    When I select view portfolio button
    And I select card in <accountType> with <currency>
    Then I should verify the <accountType> card details in Account detail tab

    Examples:
      | accountType | currency |
      | deposit     | JOD      |
      | overdraft   | JOD      |

  @p1
  @capitalMobile @dashboard
  Scenario: Dashboard Verification for share my account no and IBAN - MOB-AND-SSEC-005, MOB-AND-DAB-035, MOB-AND-DAB-036
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    When I select view portfolio button
    And I select card in overdraft with JOD
    Then I should verify the overdraft card details in Account detail tab
    And I should see Share My Account Number link
    And I should see Share My IBAN link

    When I click on Share My IBAN link
    Then I should see "Your information has been shared" message for IBAN link
    And I should see Share My IBAN link