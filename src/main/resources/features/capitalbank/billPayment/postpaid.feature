@runPlan01
Feature: Postpaid paybill on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2020169"
    And I navigate to dashboard page
    When I click on pay bill button

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the view history button -MOB-AND-BPNEWDESIGN-2, MOB-AND-BPNEWDESIGN-7
    When I click view history on Pay bills page
    Then I should see the latest Transaction date as "2023"

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the new biller Mobile prepaid Mandatory -MOB-AND-BPNEWDESIGN-10, MOB-AND-BPNEWDESIGN-11, MOB-AND-BPNEWDESIGN-12, MOB-AND-BPNEWDESIGN-8
    When I click on postpaid tab
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Mobile_Prepaid"
    Then I should see the "Mobile Number" field in new biller page

    When I click on next button
    Then I should see the "Mobile Number" field in new biller page

  @p1
  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the prepaid new biller -MOB-AND-BPNEWDESIGN-13, MOB-AND-BPNEWDESIGN-20, MOB-AND-BPNEWDESIGN-9
    When I click on postpaid tab
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Mobile_Prepaid"
    And I enter the mobile number as "12345" on Pay bill page
    And I select the denomination "Mobile 2" and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I click on pay button on pay new bill page
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    Then I should see the "You have successfully" message

    When I click on the back to dashboard in successful bill page
    Then I should see the "Accounts" dashboard page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid Success message for paying all the bills -MOB-AND-BPNEWDESIGN-41, MOB-AND-BPNEWDESIGN-42, MOB-AND-BPNEWDESIGN-43
    When I click on postpaid tab
    And I scroll to bottom of the page
    And I select the last two saved biller
    And I click on next button
    And I click on pay button
    And I click on confirm in confirm bill page
    Then I should see the "You have successfully paid your bill!" postpaid Bill paid successful message

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid saved biller -MOB-AND-BPNEWDESIGN-46
    When I click on postpaid tab
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I click on next in pay to page
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "20.000"
    And I click on pay button
    And I click on confirm in confirm bill page
    And I click on the back to dashboard in postpaid success bill
    Then I should see the "Accounts" dashboard page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid new biller amount text field -MOB-AND-BPNEWDESIGN-14, MOB-AND-BPNEWDESIGN-15, MOB-AND-BPNEWDESIGN-16
    When I click on postpaid tab
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Land Tax"
    And I enter the enter billing number "12345"
    And I click on next button
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "20.000"
    And I click on pay button
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    Then I should see the "postpaid" success message "Biller Name"

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid new biller confirm page - MOB-AND-BPNEWDESIGN-44, MOB-AND-BPNEWDESIGN-5
    When I click on postpaid tab
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I click on next in pay to page
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "20.000"
    And I click on pay button
    Then I should see the enter amount equal in confirm page

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid new biller successful message -MOB-AND-BPNEWDESIGN-17, MOB-AND-BPNEWDESIGN-18, MOB-AND-BPNEWDESIGN-21, MOB-AND-BPNEWDESIGN-22
    When I click on postpaid tab
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Mobile_Prepaid"
    And I enter the mobile number on Pay bill page
    And I select the denomination "Mobile 2" and click on next
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on pay button on pay new bill page
    And I click on confirm in confirm bill page
    And I verify the otp "654321" in paybill transfer page
    And I click on the save biller under "You have successfully paid your bill"
    And I click on the save biller under "Add as Save Biller"
    Then I should see the successful message of "You have successfully saved your bill!"

  @capitalMobile @billPaymentCapitalMobile
  Scenario Outline: Verifying the postpaid min and max value <error> - MOB-AND-BPNEWDESIGN-23, MOB-AND-BPNEWDESIGN-23, MOB-AND-BPNEWDESIGN-24
    When I click on postpaid tab
    And I click on new Biller
    And I select the "Government Service" in Select Category page
    And I select the biller name "Madfooat2" and ServiceType as "Land Tax"
    And I enter the enter billing number "12345"
    And I click on next button
    And I enter the nick name "Test Payment" in Pay New Bill
    And I click on continue to pay button
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "<amount>"
    Then I should see the "<error>" error message in pay new biller

    Examples:
      | amount  | error                                      |
      | 0.500   | Amount should be more than                 |
      | 200.000 | Amount should be less than or equal to 100 |

  @capitalMobile @billPaymentCapitalMobile
  Scenario Outline: Verifying the postpaid min and max amount in pay bill <error> - MOB-AND-BPNEWDESIGN-24, MOB-AND-BPNEWDESIGN-40, MOB-AND-BPNEWDESIGN-48, MOB-AND-BPNEWDESIGN-50
    When I click on postpaid tab
    And I scroll to saved biller in pay bill page
    And I select the first two saved biller
    And I click on next button
    And I scroll to amount text field of the pay new biller
    And I delete the entries already present and enter the amount "<amount>"
    Then I should see the "<error>" error message in pay new biller

    Examples:
      | amount  | error                                      |
      | 0.500   | Amount should be more than 1               |
      | 110.000 | Amount should be less than or equal to 100 |

  @capitalMobile @billPaymentCapitalMobile
  Scenario: Verifying the postpaid successful message -MOB-AND-BPNEWDESIGN-45, MOB-AND-BPNEWDESIGN-47, MOB-AND-BPNEWDESIGN-49
    When I click on postpaid tab
    And I scroll to bottom of the page
    And I click on saved biller "Madfooat2" in pay to page
    And I click on next in pay to page
    And I scroll to bottom of the pay new biller
    And I delete the existed entries and enter the amount "20.000"
    And I click on pay button
    And I click on confirm in confirm bill page
    Then I should see the "Success" success message "Madfooat2"

    When I click on the back to dashboard in postpaid success bill
    Then I should see the "Accounts" dashboard page