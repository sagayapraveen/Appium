Feature: Pay Bill with zero balance in Blink app

  @blink @payBillBlink @prepaidBlink
  Scenario: Prepaid Bill Payments in Blink app with zero balance
    Given I have launched the blink app
    And I have logged in the blink app with username as "omartesting@y.com"
    And I have navigated to the home page
    And I select the Bill payments from the HomePage
    When I swipe to see "prepaid" bill
    And I swipe up the screen to pay bill
    And I select the prepaid biller details
      | Key | Service            | Biller    | Biller Services | Mobile Number | Denomination |
      | gov | Government Service | Madfooat2 | Mobile_Prepaid  | 0727272722    | 1            |
    Then I should see the bill with "Madfooat2"
    And I should see the "Insufficient funds" message for blink app