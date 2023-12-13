@runPlan01
Feature: Paybill on CapitalMobile app

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Validate the pay bill page - MOB-AND-BPNEWDESIGN-5
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    And I click on pay bill button
    And I scroll to bottom of the page
    Then I should see the saved biller "Madfooat2"

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Validate the cards of account - MOB-AND-BPNEWDESIGN-2
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2008075"
    And I navigate to dashboard page
    And I click on pay bill button
    Then I verify the "VISA GOLD" card

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Validate the pay bill page - MOB-AND-BPNEWDESIGN-3
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    And I click on pay bill button
    Then I should see the pay bill page