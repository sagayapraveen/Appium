@runPlan01
Feature: Prepaid paybill on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2020169"
    And I navigate to dashboard page
    When I click on pay bill button

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the New biller Education page - MOB-AND-BPNEWDESIGN-26, MOB-AND-BPNEWDESIGN-27, MOB-AND-BPNEWDESIGN-6
    When I click on prepaid button
    And I click on new Biller
    And I select the "Education" in Select Category page
    And I select the biller Name "Al ALBayt University"
    And I select the service type "Application fees"
    And I confirm the new registration number "ABC"
    Then I should able to click on next button

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying next button New biller Education page - MOB-AND-BPNEWDESIGN-28, MOB-AND-BPNEWDESIGN-29
    When I click on prepaid button
    And I click on new Biller
    And I select the "Education" in Select Category page
    And I select the biller Name "Universal Schools"
    And I select the service type "New registration – Full payment"
    And I click on next button
    Then I should see app in "New registration" page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid new biller - MOB-AND-BPNEWDESIGN-3, MOB-AND-BPNEWDESIGN-30, MOB-AND-BPNEWDESIGN-33
    When I click on prepaid button
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Prepaid2"
    And I click on the prepaid "test"
    And I select the denomination and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    Then I should see the "Pay New Bill" page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid new biller -MOB-AND-BPNEWDESIGN-31
    When I click on prepaid button
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Prepaid2"
    And I click on the prepaid "test"
    And I select the denomination and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    Then I verify the amount text filed

  @p1
  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid new biller -MOB-AND-BPNEWDESIGN-32
    When I click on prepaid button
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Land Tax"
    And I enter the enter billing number "12345"
    And I click on next button
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "10.000"
    And I click on pay button
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    Then I should see the "prepaid" success message "Biller Name"

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid successful message -MOB-AND-BPNEWDESIGN-34, MOB-AND-BPNEWDESIGN-35
    When I click on prepaid button
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Prepaid2"
    And I set the "Prepaid2" text as "test" for paybill
    And I select the denomination and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on pay button on pay new bill page
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    Then I should see the "You have successfully" message

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid successful message -MOB-AND-BPNEWDESIGN-4, MOB-AND-BPNEWDESIGN-53, MOB-AND-BPNEWDESIGN-53, MOB-AND-BPNEWDESIGN-54
    When I click on prepaid button
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I select the denomination "itunes10"
    And I click on pay button
    And I click on confirm in confirm bill page
    Then I should see the "You have successfully" message