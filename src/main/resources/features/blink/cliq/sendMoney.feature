Feature: Send Money in Blink app

  Background: Navigation to Blink Send money page
    Given I have logged in the blink app
    And I have navigated to the home page
    And I select the Bill payments from the HomePage

  #TC-BLINK-send money-001, TC-BLINK-send money-012, TC-BLINK-send money-013
  @blink @sendMoneyBlink
  Scenario: Blink Send money with new contact
    When I swipe up the screen to send money
    And I click blue button after entering the amount "1"
    And I click on send money tooltip
    And I enter the beneficiary details "00962000000011"
    Then I should see "LEEN ESSAM EL ZOUBI" as Beneficiary name

    When I enter the purpose details
      | Purpose         | Fees       |
      | Purpose Details | Commission |
    And I enter the nick name as "Omar ja" for bill payments
    And I enter the otp "576824" for the blink transaction
    Then I should see the IBAN with "00962000000011" in success page

      #TC-BLINK-send money-014
  @blink @sendMoneyBlink
  Scenario: Blink send money Error message for existing nick name provided
    When I swipe up the screen to send money
    And I click blue button after entering the amount "1"
    And I enter the beneficiary details "00962000000011"
    Then I should see "LEEN ESSAM EL ZOUBI" as Beneficiary name

    When I enter the purpose details
      | Purpose         | Fees       |
      | Purpose Details | Commission |
    And I enter the nick name as "Omar ja" for bill payments
    And I enter the otp "576824" for the blink transaction
    Then I should see the "Nickname is already stored" message for send money

      #TC-BLINK-send money-002, TC-BLINK-send money-007, TC-BLINK-send money-013
  @blink @sendMoneyBlink
  Scenario: Blink Send money to existing contact
    When I swipe up the screen to send money
    Then I should see "Send Money" page after swipe down

    When I send money "10" to the payee "Omar ja"
    Then I should see the IBAN with "00962000000011" in success page

    #TC-BLINK-send money-005
  @blink @sendMoneyBlink
  Scenario: Send money to existing contact with insufficient fund
    When I send money "100000" to the payee "Omar ja"
    Then I should see the "Your attempt to send money was unsuccessful." message for blink app

    #TC-BLINK-send money-006, C-BLINK-send money-004
  @blink @sendMoneyBlink
  Scenario Outline: Send money with invalid amount <amount>
    When I swipe up the screen to send money
    And I click blue button after entering the amount "<amount>"
    Then I should see the "<error message>" message for blink app

    Examples:
      | amount  | error message                      |
      | 0       | Invalid amount                     |
      | 1000000 | You do not have sufficient balance |


    #TC-BLINK-send money-003, TC-BLINK-send money-008, TC-BLINK-send money-009, TC-BLINK-send money-010, TC-BLINK-send money-011
  @blink @sendMoneyBlink
  Scenario Outline: Error message for Send money beneficiary <beneficiary>
    When I swipe up the screen to send money
    And I click blue button after entering the amount "1"
    And I enter the beneficiary details "<beneficiary>"
    Then I should see the "Oops! IBAN/account number/ mobile number/Alias is invalid, use another one." message for blink app

    Examples:
      | beneficiary                |
      | archuu                     |
      | 7bjor982798                |
      | acc776567                  |
      | 009190909090               |
      | 962796431000               |
      | 0796431000                 |
      | testest                    |
      | Jo43efbk001200009519110451 |
      | 0096279643                 |

    #TC-BLINK-send money-014
  @blink @sendMoneyBlink
  Scenario: Verifying purpose details for Send money
    When I swipe up the screen to send money
    And I click blue button after entering the amount "1"
    And I enter the beneficiary details "Maram"
    Then I should not see focus on purpose details in "send money"