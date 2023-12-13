Feature: Credit card in Blink app

  Background: Navigation for Credit card
    Given I have logged in the blink app
    And I have navigated to the home page

   # TC-BLINK-credit-card-42, TC-BLINK-credit-card-39, TC-BLINK-credit-card-38
   # TC-BLINK-credit-card-43, TC-BLINK-credit-card-44, TC-BLINK-credit-card-45
  @blink @creditCardBlink
  Scenario: Verify flip card for account details
    When I navigate to credit card
    And I click on the credit card option as "Flip card"
    Then I should see the account details in flip card

    When I click on the credit card option as "Flip back"
    Then I should see flip credit card

    When I click on pay back in credit card
    Then I should not see the invalid no in keyboard

    When I enter the pay amount "0" in pay back page
    Then I should see the error pop-up message "Error Amount to pay should be greater than 0"

    When I enter the pay amount "2" in pay back page
    Then I should see the transaction amount "2" paid to page

    # TC-BLINK-credit-card-30, TC-BLINK-credit-card-32, TC-BLINK-credit-card-34, TC-BLINK-credit-card-35, TC-BLINK-credit-card-36
  @blink @creditCardBlink
  Scenario Outline: Verify manage settlements in <newPin>
    When I navigate to credit card
    When I click on settings icon in credit card
    And I click on manage settlement in credit card menu
    And I select the Change settlement options
    And I click on new settlement percentage
    And I select the settlement percentage "100 %"
    Then I should see the current settlement percentage "100%"

    When I click on back to card Setting
    And I click the Debit card menu as "Manage card PIN"
    And I click the Debit card menu as "Unblock card PIN"
    Then I should see the "Unblock card PIN" menu

    When I click the Debit card menu as "Manage card PIN"
    And I click the Debit card menu as "Change card PIN"
    And I enter the new pin "<newPin>" in change card pin
    And I confirm the new pine "<confirmPin>"in change card pin
    And I swipe left in the new pin page
    Then I should see the error message "Error Pin does not match" in change card pin

    Examples:
      | newPin | confirmPin |
      | 1111   | 1234       |

    # TC-BLINK-credit-card-49
  @blink @creditCardBlink
  Scenario: Verify account balance
    When I navigate to credit card
    And I click on pay back in credit card
    And I should fetch the available balance in pay back page
    And I swipe down in pay back page
    And I click on home button
    Then I should see the account balance