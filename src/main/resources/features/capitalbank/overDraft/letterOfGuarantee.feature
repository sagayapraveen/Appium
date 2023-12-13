@runPlan01
Feature: Letter of Guarantee

  @capitalMobile @overDraft @letterOfGuarantee @overdraftTransfer
  Scenario: Validating Letter of Guarantee-MOB-AND-VAL-001,MOB-AND-VAL-002,MOB-AND-VAL-037,MOB-AND-VAL-038,MOB-AND-VAL-039
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2000112"
    And I navigate to dashboard page
    And I click on Letter of Guarantee menu from dashboard
    Then I should see the details in letter of Guarantee screen