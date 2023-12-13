Feature: Transaction history entries

  @blink @transactionsBlink
  Scenario: Validation of transaction history for the account
    Given I have logged in the blink app
    And I have navigated to the home page
    When I navigate to my account page in blink
    And I navigate to transaction history page
    Then I should see the transaction history of the account for the date "20 March"