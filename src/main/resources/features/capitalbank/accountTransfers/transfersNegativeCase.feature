@runPlan03
Feature: Account Transfers negative scenarios

  Background: Navigation to transferPage - MOB-AND-CRD-396 MOB-AND-CRD-395 MOB-AND-CRD-394 MOB-AND-CRD-393 MOB-AND-CRD-371 MOB-AND-CRD-370 MOB-AND-CRD-369 MOB-AND-CRD-368 MOB-AND-CRD-367 MOB-AND-CRD-366 MOB-AND-CRD-365 MOB-AND-CRD-364 MOB-AND-CRD-342 MOB-AND-CRD-341 MOB-AND-CRD-340 MOB-AND-CRD-339 MOB-AND-CRD-338 MOB-AND-CRD-337 MOB-AND-CRD-336 MOB-AND-CRD-335
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile @accountTransfers @transfersNegative
  Scenario: Transfers with new Beneficiary -Negative Cases-Invalid Recipient Name
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10.10" to "Domestic"
    And I set the recipient name as "test"
    Then I should see alert message "Please enter at least 3 names with a minimum of 3characters in the first and last name" for Recipient Name

  @capitalMobile @accountTransfers @transfersNegative
  Scenario: Transfers with new Beneficiary -Negative Cases--Blank Recipient Name
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10.10" to "Domestic"
    And I set the recipient name " " and recipient address "TESt@#"
    Then I should see the field level error message "Recipient name cannot be empty"

  @capitalMobile @accountTransfers @transfersNegative
  Scenario: Transfers with new Beneficiary -Negative Cases--Blank Recipient address
    When I select "JOD" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "JO48JKBA2500003750880013002000"
    And I enter the transfer amount "10.10" to "Domestic"
    And I set the recipient name "TEST TEST" and recipient address " "
    Then I should see the field level error message "Recipient address cannot be empty" for Recipient Address

  @capitalMobile @accountTransfers @transfersNegative
  Scenario Outline: Transfers with new Beneficiary -Negative Cases--"<message>"
    When I select "<currency>" account under user Account
    And I select new Beneficiary for transfers with the IBAN number "<IBAN/Account>"
    Then I should see the error pop-up "<message>"

    Examples:
      | currency | IBAN/Account                  | message                           |
      | JOD      | JO94CBJO001000000000013100665 | Error Invalid IBAN                |
      | JOD      | 4156435                       | Error Invalid IBAN/account number |
      | JOD      | JO94CBJO0010000000000131      | Error Invalid IBAN                |

  @capitalMobile @accountTransfers @transfersNegative
  Scenario: Creating Transfer with amount more than available balance - negative testcase
    When I select payFrom account with "USD" account number "4816263"
    And I select "AUTOMATION OVERSEAS" from the existing beneficiary in Own Transfers
    And I enter the transfer amount with more than available balance in "Transfer to Overseas"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    And I confirm the transfer
    Then I should see the error pop-up "Error You do not have sufficient balance for this transaction. Please select another account or change the transaction amount."