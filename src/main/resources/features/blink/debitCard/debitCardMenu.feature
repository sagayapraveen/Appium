Feature: Debit card menu in Blink app

  #TC-BLINK-my debit card-015, TC-BLINK-my debit card-019 - TC-BLINK-my debit card-024, TC-BLINK-my debit card-027
  #TC-BLINK-my debit card-028, TC-BLINK-my debit card-020, TC-BLINK-my debit card-031, TC-BLINK-my debit card-032
  Background: Navigation to Blink Send money page
    Given I have logged in the blink app
    And I have navigated to the home page
    And I navigate to debit card

  @blink @debitCardBlink @debitCardMenu
  Scenario: Verify the card freeze
    When I click on settings icon
    And I click the Debit card menu as "Manage card PIN"
    And I click the Debit card menu as "Unblock card PIN"
    Then I should see the "Unblock card PIN" menu
    And I should see the "Manage card PIN"

  @blink @debitCardBlink @debitCardMenu
  Scenario Outline: Verify the debit menu option
    When I click on settings icon
    And I click the Debit card menu as "<type>"
    Then I should see your card page

    When I set the pin "1234"
    Then I should see "Your card is ready!" message
    And I should see debit card

    Examples:
      | type                       |
      | Report stolen or lost card |
      | Replace damaged card       |

  @blink @debitCardBlink @debitCardMenu
  Scenario: Verify the cancel card
    When I click on settings icon
    And I click the Debit card menu as "Cancel this card"
    And I select "I don’t need" for Debit card
    Then I should see your card page

    When I set the pin "1234"
    Then I should see "Your card is ready!" message
    And I should see debit card

  @blink @debitCardBlink @debitCardMenu
  Scenario: Verify the cancel card
    When I click on settings icon
    And I click the Debit card menu as "Request physical card"
    Then I should see "Your card is ready!" message
    And I should see debit card

  @blink @debitCardBlink @debitCardMenu
  Scenario: Verify the flip card
    When I click on the debit card option as "Flip card"
    Then I should see the account details
    When I click on the debit card option as "Flip back"
    And I should see debit card

  @blink @debitCardBlink @debitCardMenu
  Scenario: Verify the add money
    When I click on the debit card option as "Add money"
    And I click back button in the add money page
    And I click on the debit card option as "Add money"
    Then I should see the message for blink debit card "Deposit cash directly into your Blink account"
    And I should see the message for blink debit card "Deposit money directly from any of eFawateercom agents"

    When I click on the debit card option as "Request money"
    Then I should see the request money page