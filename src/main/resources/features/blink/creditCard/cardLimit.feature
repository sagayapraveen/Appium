Feature: Card limit in Credit card Blink app

  Background: Navigation to Blink Send money page
    Given I have launched the blink app
    And I have logged in the blink app with username as "c@ro.com"
    And I have navigated to the home page

  @blink @creditCardBlink @freezeCreditCard
  Scenario Outline: Verify the <action> card freeze for blink creditCard
    When I navigate to credit card
    And I click on settings icon
    And I "<action>" the freeze card
    Then I should see the card gets "<response>"

    Examples:
      | action  | response |
      | enable  | enabled  |
      | disable | disabled |

  @blink @creditCardBlink @creditCardLimit
  Scenario Outline: Verify the card amount <amount> for <type> less than limit for blink creditCard
    When I navigate to credit card
    And I click on settings icon
    And I click on manage card limit
    And I edit the amount to "<amount>" in "<type>" of "<card>"
    Then I should see "<amount>" as daily limit in "<type>"

    Examples:
      | amount | type              | card   |
      | 222    | ATM Withdrawal    | credit |
      | 5000   | ATM Withdrawal    | credit |
      | 222    | Merchant Payments | credit |
      | 5000   | Merchant Payments | credit |

  @blink @creditCardBlink @creditCardLimit
  Scenario Outline: Verify the <type> card limit with exceeding the limit for blink CreditCard
    When I navigate to credit card
    And I click on settings icon
    And I click on manage card limit
    And I edit the amount "22222" to exceed limit in "<type>" of "<card>"
    Then I should see the error pop-up "Error Limit value cannot be set greater than max limit value" in the blink app

    Examples:
      | type              | card   |
      | ATM Withdrawal    | credit |
      | Merchant Payments | credit |

  @blink @creditCardBlink @creditCardLimit
  Scenario Outline: Verify the <type> card limit with 0 for blink CreditCard
    When I navigate to credit card
    And I click on settings icon
    And I click on manage card limit
    And I edit the amount to "0" in "<type>" of credit card
    Then I should see the "<type>" is disabled

    Examples:
      | type              |
      | ATM Withdrawal    |
      | Merchant Payments |

  @blink @creditCardBlink @creditCardLimit
  Scenario: Verify the blink credit card name and due amount
    When I navigate to credit card
    Then I should see "CAROLINE" in debit card
    And I should see "MIN. DUE BY" in debit card
    When I swipe the screen to see transaction history
    Then I should see the "Aug" transaction history

    When I choose "Jun" month after selecting the download button
    Then I should verify the "Jun" statement