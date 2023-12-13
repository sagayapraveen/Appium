Feature: Outward CliQ in Blink app

  Background: Navigation for Outward CLiQ
    Given I have launched the blink app
    And I have logged in the blink app with username as "omartesting@y.com"
    And I have navigated to the home page
    And I select the Bill payments from the HomePage
    And I swipe up the screen to send money

  #TC-BLNK-OutwardCliq-002, TC-BLNK-OutwardCliq-003,TC-BLNK-OutwardCliq-001, TC-BLNK-OutwardCliq-012
  @blink @cliQBlink @outwardCliQ
  Scenario Outline: Blink Send money using <aliasType>
    When I click blue button after entering the amount "1"
    And I enter the beneficiary detail as "<type>"
    Then I should see "<name>" as Beneficiary name
    When I enter the purpose details with recipient
      | Purpose         | Personal        |
      | Purpose Details | Family expenses |
    And I select the bill to saved list
    And I enter "<nick name>" as nickname for Outward CliQ
    And I enter the otp "576824" for the blink transaction
    Then I should see the IBAN with "<IBAN>" in success page

    Examples:
      | aliasType    | type                           | name                           | nick name | IBAN                           |
      | mobileNumber | 00962796511323                 | MOHAMMAD ADNAN SHADAD          | visa 51   | 00962796511323                 |
      | iban         | JO63EFBK0012000000009487578101 | OMAR ASEM JALLAD               | Visa 54   | JO63EFBK0012000000009487578101 |
      | alias        | CLIQO                          | LEEN ESSAM EL ZOUBI   EL ZOUBI | Visa 53   | LEEN ESSAM EL ZOUBI   EL ZOUBI |

 #TC-BLNK-OutwardCliq-007, TC-BLNK-OutwardCliq-009, TC-BLNK-OutwardCliq-010, TC-BLNK-OutwardCliq-001, TC-BLNK-OutwardCliq-003, TC-BLNK-OutwardCliq-004
  @blink @cliQBlink @outwardCliQ
  Scenario Outline: Validation of blink Send money error message <errorMessage>
    When I click blue button after entering the amount "<amount>"
    Then I should see the "<errorMessage>" message for blink app

    Examples:
      | amount   | errorMessage                       |
      | 0        | Invalid amount                     |
      | 7777     | You do not have sufficient balance |
      | 77777777 | You do not have sufficient balance |

    #TC-BLNK-OutwardCliq-011, TC-BLNK-OutwardCliq-005, TC-BLNK-OutwardCliq-002, TC-BLNK-OutwardCliq-008
  @blink @cliQBlink @outwardCliQ
  Scenario: blink Send money with invalid otp
    Then I should not see the invalid no in keyboard

    When I click blue button after entering the amount "1"
    And I enter the beneficiary IBAN as "JO63EFBK0012000000009487578101"
    And I enter the purpose details with recipient
      | Purpose         | Personal        |
      | Purpose Details | Family expenses |
    And I select the bill to saved list
    And I enter "1" as nickname for Outward CliQ
    And I enter the otp "123456" for the blink transaction
    Then I should see the "invalid code" message for blink app