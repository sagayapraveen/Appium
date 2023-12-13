Feature: Request money in Blink app

  Background: Navigation to Blink Request money
    Given I have logged in the blink app
    And I have navigated to the home page
    And I select the Bill payments from the HomePage
    And I swipe to see "request money" bill

  #TC-BLINK-request money-001, TC-BLINK-send money-012, TC-BLINK-send money-013, TC-BLINK-request money-010, TC-BLINK-request money-011
  @blink @requestMoneyBlink
  Scenario: Request money from new recipient
    When I swipe up the screen to request money
    And I click blue button after entering the amount "1"
    And I click on send money tooltip
    And I select the beneficiary details
      | Key             | mar      |
      | purpose         | Personal |
      | purpose details | Friend   |
    Then I should see "Maram Alaa Tawfiq Nweiran" as name for Request money

    When I enter the nick name as "Maram1" for bill payments
    Then I should see the "Requested" message for blink app
    #And I should see the dashboard after swiping

  #TC-BLINK-request money-002
  @blink @requestMoneyBlink
  Scenario: Request money for existing recipient
    When I select the existing request money payee "Marama"
    And I edit the purpose details
      | purpose         | Personal |
      | purpose details | Friend   |
    And I enter amount "10"
    Then I should see the "Requested" message for blink app

  #TC-BLINK-request money-005, TC-BLINK-request money-013
  @blink @requestMoneyBlink
  Scenario: Request money with invalid amount
    When I swipe up the screen to request money
    Then I should see "Request money" page after swipe down

    When I swipe up the screen to request money
    And I click blue button after entering the amount "0"
    Then I should see the "Invalid amount" message for blink app

  #TC-BLINK-request money-003, TC-BLINK-request money-004, TC-BLINK-request money-006, TC-BLINK-request money-007, TC-BLINK-request money-008, TC-BLINK-request money-009
  @blink @requestMoneyBlink
  Scenario Outline: Request money with invalid beneficiary <beneficiaries>
    When I swipe up the screen to request money
    And I click blue button after entering the amount "1"
    And I enter the invalid beneficiary "<beneficiaries>"
    Then I should see the "<error message>" message for blink app

    Examples:
      | beneficiaries      | error message                                                               |
      | 009627964310000980 | Oops! please enter an IBAN or CliQ ID to request money.                     |
      | 7bjor982798        | Oops! IBAN/account number/ mobile number/Alias is invalid, use another one. |
      | acc776567          | Oops! IBAN/account number/ mobile number/Alias is invalid, use another one. |
      | 009190909090       | Oops! IBAN/account number/ mobile number/Alias is invalid, use another one. |
      | archuu             | Oops! IBAN/account number/ mobile number/Alias is invalid, use another one. |
      | 00962796431000     | Oops! please enter an IBAN or CliQ ID to request money.                     |
      | test               | Oops! IBAN/account number/ mobile number/Alias is invalid, use another one. |


    #TC-BLINK-request money-012
  @blink @requestMoneyBlink
  Scenario: Request money from new recipient
    When I swipe up the screen to request money
    And I click blue button after entering the amount "1"
    And I enter the beneficiary "mar" in request money
    Then I should not see focus on purpose details in "request money"