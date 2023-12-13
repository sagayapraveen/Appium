Feature: Pay Bill in Blink app

  Background: Navigation to bill payment page
    Given I have logged in the blink app
    And I have navigated to the home page
    And I select the Bill payments from the HomePage

  #TC-BLNK-billPymnt-001
  @blink @payBillBlink @postpaidBlink
  Scenario: Postpay Bill Payments in Blink app with sufficient fund
    When I swipe to see "postpaid" bill
    And I swipe up the screen to pay bill
    And I select the postpaid biller details
      | Key | Service            | Biller    | Biller Services | Electricity |
      | gov | Government Service | Madfooat2 | Electricity     | 12345       |
    And I swipe the screen to "left"
    Then I should see the bill with "Madfooat2" and "12345"
    And I should see the "Success" status

  #TC-BLNK-billPymnt-003, TC-BLNK-billPymnt-006
  @blink @payBillBlink @postpaidBlink
  Scenario: Postpay Bill Payments in Blink app with insufficient fund
    When I swipe to see "postpaid" bill
    And I swipe up the screen to pay bill
    And I select the postpaid biller details
      | Key | Service            | Biller    | Biller Services | Electricity |
      | gov | Government Service | Madfooat2 | Electricity     | 12345       |
    And I select the bill to saved list
    And I enter nickname "visa 1"
    And I edit the amount in the bill as "5000"
    Then I should see the bill with "Madfooat2" and "12345"
    And I should see the "Amount should be less than or equal to 100.000 JOD" message for blink app

  #TC-BLNK-billPymnt-005
  @blink @payBillBlink @postpaidBlink
  Scenario Outline: Postpay Bill Payments in Blink app with small amount with nickname <name>
    When I swipe to see "postpaid" bill
    And I swipe up the screen to pay bill
    And I select the postpaid biller details
      | Key | Service            | Biller    | Biller Services | Electricity |
      | gov | Government Service | Madfooat2 | Electricity     | <billNo>    |
    And I select the bill to saved list
    And I enter nickname "<name>"
    And I edit the amount in the bill as "1"
    Then I should see the bill with "Madfooat2" and "<billNo>"
    And I should see the "Success" status

    Examples:
      | name   | billNo |
      | visa 1 | 12345  |
      | visa 2 | 1234   |
      | visa 3 | 123    |

  #TC-BLNK-billPymnt-007
  @blink @payBillBlink @postpaidBlink
  Scenario: Remove the saved card from Postpaid Bill Payments
    When I swipe to see "postpaid" bill
    And I click on "Manage my bills" button
    Then I verify "visa 1" bill after deleting it

  #TC-BLNK-billPymnt-002, TC-BLNK-billPymnt-004
  @blink @payBillBlink @postpaidBlink
  Scenario: Remove the saved card from Postpaid Bill Payments
    When I swipe to see "postpaid" bill
    And I click on "View and pay your due bills" button
    And I pay the bills
    Then I should see the "We are processing your request and we will notify you once ready" request message

  #TC-BLNK-billPymnt-009
  @blink @payBillBlink @prepaidBlink
  Scenario: Prepaid Bill Payments in Blink app with Mobile prepaid
    When I swipe to see "prepaid" bill
    And I swipe up the screen to pay bill
    And I select the prepaid biller details
      | Key | Service            | Biller    | Biller Services | Mobile Number | Denomination |
      | gov | Government Service | Madfooat2 | Mobile_Prepaid  | 0727272722    | 1            |
    Then I should see the bill with "Madfooat2"
    And I should see the "Success" status

    #TC-BLNK-billPymnt-008,TC-BLNK-billPymnt-013, TC-BLNK-billPymnt-011
  @blink @payBillBlink @prepaidBlink
  Scenario Outline: Prepaid Bill Payments in Blink app with advance payment <amount>
    When I swipe to see "prepaid" bill
    And I swipe up the screen to pay bill
    And I select the prepaid biller details
      | Key | Service            | Biller    | Biller Services | Billing number | Amount   |
      | gov | Government Service | Madfooat2 | Advance_Payment | 12345          | <amount> |
    Then I should see the bill with "Madfooat2"
    And I should see the "Success" status

    Examples:
      | amount |
      | 5      |
      | 10     |
      | 20     |

  #TC-BLNK-billPymnt-012, TC-BLNK-billPymnt-014
  @blink @payBillBlink @prepaidBlink
  Scenario Outline: Prepaid Bill Payments in Blink app with insufficient fund <value>
    When I swipe to see "prepaid" bill
    And I swipe up the screen to pay bill
    And I select the prepaid biller details
      | Key | Service            | Biller    | Biller Services | Billing number | Amount  |
      | gov | Government Service | Madfooat2 | Advance_Payment | 12345          | <value> |
    Then I should see the bill with "Madfooat2"
    And I should see the "Insufficient funds" message for blink app

    Examples:
      | value  |
      | 10000  |
      | 20000  |
      | 500000 |