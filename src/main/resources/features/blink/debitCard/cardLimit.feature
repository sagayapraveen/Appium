Feature: Card limit in Debit card Blink app

  #TC-BLINK-my debit card-001 - TC-BLINK-my debit card-014
  Background: Navigation to Blink Send money page
    Given I have logged in the blink app
    And I have navigated to the home page
    And I navigate to debit card

  @blink @debitCardBlink @freezeDebitCard
  Scenario Outline: Verify the blink debit card with <action> card freeze
    When I click on settings icon
    And I "<action>" the freeze card
    Then I should see the card gets "<response>"

    Examples:
      | action  | response |
      | enable  | enabled  |
      | disable | disabled |

  @blink @debitCardBlink @debitCardLimit
  Scenario Outline: Verify the blink debit card amount <amount>  and <type> less than limit
    When I click on settings icon
    And I click on manage card limit
    And I edit the amount to "<amount>" in "<type>" of "<card>"
    Then I should see "<amount>" as daily limit in "<type>"

    Examples:
      | amount | type              | card  |
      | 222    | ATM Withdrawal    | debit |
      | 5000   | ATM Withdrawal    | debit |
      | 222    | Merchant Payments | debit |
      | 5000   | Merchant Payments | debit |
      | 222    | Online Purchase   | debit |
      | 5000   | Online Purchase   | debit |

  @blink @debitCardBlink @debitCardLimit
  Scenario Outline: Verify the blink debitCard with <type> card limit with exceeding the limit
    When I click on settings icon
    And I click on manage card limit
    And I edit the amount "22222" to exceed limit in "<type>" of "<card>"
    Then I should see the error pop-up "Error Limit value cannot be set greater than max limit value" in the blink app

    Examples:
      | type              | card  |
      | ATM Withdrawal    | debit |
      | Merchant Payments | debit |
      | Online Purchase   | debit |

  @blink @debitCardBlink @debitCardLimit
  Scenario Outline: Verify the blink debitCard with <type> card limit with 0
    When I click on settings icon
    And I click on manage card limit
    And I edit the amount to "0" in "<type>" of "<card>"
    Then I should see the "<type>" is disabled

    Examples:
      | type              | card  |
      | ATM Withdrawal    | debit |
      | Merchant Payments | debit |
      | Online Purchase   | debit |