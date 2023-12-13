@runPlan01
Feature: Bill Payment on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2020169"
    And I navigate to dashboard page
    When I click on pay bill button

  @sanity
  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid successful message -MOB-AND-CREDITCARD-55, MOB-AND-BPNEWDESIGN-52
    When I click on prepaid button
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I select the denomination "1"
    And I click on pay button
    And I click on confirm in confirm bill page
    Then I should see the "You have successfully" message

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying postpaid success message -MOB-AND-BPNEWDESIGN-19, MOB-AND-BPNEWDESIGN-25, MOB-AND-BPNEWDESIGN-20, MOB-AND-BPNEWDESIGN-22
    When I click on "POSTPAID" tab in pay to page
    And I click on New Biller in pay to page
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" in Select Category page
    And ServiceType as "Mobile_Prepaid" in Select Category page
    And I enter the mobile number on Pay bill page
    And I select the denomination "Mobile 2" and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I click on pay button on pay new bill page
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    And I click on the save biller under "You have successfully paid your bill"
    And I click on the save biller under "Add as Save Biller"
    Then I should see the successful message of "You have successfully saved your bill!"

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying postpaid success - MOB-AND-BPNEWDESIGN-10, MOB-AND-BPNEWDESIGN-50, MOB-AND-BPNEWDESIGN-56, MOB-AND-BPNEWDESIGN-57,  MOB-AND-BPNEWDESIGN-14, MOB-AND-BPNEWDESIGN-55
    When I click on "POSTPAID" tab in pay to page
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I click on next in pay to page
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "20.000"
    And I click on pay button
    And I click on confirm in confirm bill page
    Then I should see the "Postpaid" success message "Madfooat2"

    When I click on the back to dashboard in postpaid success bill
    Then I should see the "Accounts" dashboard page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid min value - MOB-AND-BPNEWDESIGN-9
    When I click on "POSTPAID" tab in pay to page
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" in Select Category page
    And ServiceType as "Land Tax" in Select Category page
    And I enter the enter billing number "12345"
    And I click on next button
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "1.500"
    And I click on pay button
    Then I should see the "Confirm" in confirm page

  @capitalMobile @billPaymentCapitalMobile
  Scenario Outline: Verifying that save beneficiary deleted  <payTo> - MOB-AND-BPNEWDESIGN-41, MOB-AND-BPNEWDESIGN-42,MOB-AND-BPNEWDESIGN-41,  MOB-AND-BPNEWDESIGN-42, MOB-AND-BPNEWDESIGN-41, MOB-AND-BPNEWDESIGN-42,MOB-AND-BPNEWDESIGN-41
    When I click on "<payTo>" tab in pay to page
    And I scroll to saved biller in pay bill page
    And I swipe left to delete the biller
    And I click on delete saved biller
    And I click on confirm button in delete save biller
    Then I should see the successful message "SUCCESS You have successfully deleted this bill." in delete save biller

    Examples:
      | payTo    |
      | POSTPAID |
      | PREPAID  |

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the Select all and Unselect all - MOB-AND-BPNEWDESIGN-41, MOB-AND-BPNEWDESIGN-41
    When I click on "POSTPAID" tab in pay to page
    And I click on "Select All" in pay to page
    Then I should see the biller is selected "billers selected"

    When I click on "Unselect All" in pay to page
    Then I should see the biller is Unselected "0 billers selected"

  @p1
  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid successful message - MOB-AND-BPNEWDESIGN-36, MOB-AND-BPNEWDESIGN-37, MOB-AND-BPNEWDESIGN-38, MOB-AND-BPNEWDESIGN-39, MOB-AND-BPNEWDESIGN-31, MOB-AND-BPNEWDESIGN-31
    When I click on prepaid button
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" in Select Category page
    And ServiceType as "Prepaid2" in Select Category page
    And I set the "Prepaid2" text as "test" for paybill
    And I select the denomination and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    Then I should see the total amount not be editable

    When I click on pay button on pay new bill page
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    Then I should see the "You have successfully" message

    When I click on save Biller in successfully message
    And I enter the nick name as "Test test"
    And I click on save Biller in successfully message
    Then I should see the successful message of "Biller Saved"

    When I click on the back to dashboard in success biller saved page
    Then I should see the "Accounts" dashboard page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying next button New biller Education page -MOB-AND-BPNEWDESIGN-28,
    When I click on prepaid button
    And I click on new Biller
    And I select the "Education" in Select Category page
    And I select the biller name "Al ALBayt University" in Select Category page
    And ServiceType as "Application fees aabu" in Select Category page
    Then I should see the app is displaying "fees" field