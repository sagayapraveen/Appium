@runPlan01
Feature: Manage CliQ on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2221222"
    And I navigate to dashboard page
    And I navigate to Profile menu
    And I select the "Manage CliQ ID" from profile menu
    And I click on the add CliQ button

  @capitalMobile @cliQ @cliQManage
  Scenario Outline: Verify create a new cliQ by Alias type on other than the current account <type> - MOB-IOS-CLQ-001, MOB-IOS-CLQ-003, MOB-IOS-CLQ-004,
    When I select CliQ default link account "JOD"
    And I click on CliQID to enter "<type>" and enter alias as "<keyword>"
    And I click on next button
    And  I select radio button for CliQ and click on confirm
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for CliQ ID created "CliQ ID created successfully !"

    Examples:
      | type          | keyword |
      | Alias         | MAR     |
      | Mobile Number | 79640   |

  @capitalMobile @cliQ @cliQManage
  Scenario: Verify create a cliQ using MobileNumber type, with an invalid mobile format - MOB-IOS-CLQ-008, MOB-IOS-CLQ-011,MOB-IOS-CLQ-032, MOB-IOS-CLQ-033, MOB-IOS-CLQ-083
    When I click on "Mobile Number" and enter the mobile number as "123"
    Then I should see the pop-up "Mobile number should be of 9 digits"

  @capitalMobile @cliQ @cliQManage
  Scenario Outline: Verify create more than a cliQ using two Aliases on the same user in <type> - MOB-IOS-CLQ-002, MOB-IOS-CLQ-005, MOB-IOS-CLQ-006,
    When I click on next button
    Then I should see the next button should be disable

    When I click on CliQID to enter "<type>" and enter alias as "<keyword>"
    And I click on next button
    And I select radio button for CliQ and click on confirm
    And I verify the mobile 6 digit pin for the transaction
    And I click back to dashboard option
    And I navigate to Profile menu
    And I select the "Manage CliQ ID" from profile menu
    And I click on the add CliQ button
    And I click on CliQID to enter "<type>" and enter alias as "<newKeyword>"
    And I click on next button
    And  I select radio button for CliQ and click on confirm
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for CliQ ID created "CliQ ID created successfully !"

    Examples:
      | type          | keyword | newKeyword |
      | Alias         | MAR25   | MAR23      |
      | Mobile Number | 79640   | 79640      |

  @capitalMobile @cliQ @cliQManage
  Scenario Outline: Verify that create an existing cliQ using Alias type <type> - MOB-IOS-CLQ-007, MOB-IOS-CLQ-012, MOB-IOS-CLQ-013, MOB-IOS-CLQ-014, MOB-IOS-CLQ-015
    When I click on CliQID for entering "<type>" and enter alias "<keyword>"
    And I click on next button
    And  I select radio button for CliQ and click on confirm
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the error pop-up "Error Alias already exist, please enter new alias"

    Examples:
      | type          | keyword   |
      | Mobile Number | 796401604 |
      | Alias         | MAR123    |

  @p1
  @capitalMobile @cliQ @cliQManage
  Scenario: Verify the confirmation page, click on agree button on terms and terms and conditions -MOB-IOS-CLQ-022, MOB-IOS-CLQ-028, MOB-IOS-CLQ-031, MOB-IOS-CLQ-032, MOB-IOS-CLQ-033, MOB-IOS-CLQ-034, MOB-IOS-CLQ-127
    When I click on CliQID to enter "Alias" and enter alias as "MAR"
    Then I should see the alert message "Alias Should Be Greater Than 3 Characters"

    When I click on next button
    And I click on confirm button
    Then I should see the confirm button should be disable

    When I click close button
    And I navigate to Profile menu
    And I select the "Manage CliQ ID" from profile menu
    And I click on the add CliQ button
    And I select CliQ default link account "JOD"
    And I click on CliQID to enter "Alias" and enter alias as "MAR"
    And I click on next button
    And I click on edit details to edit CliQ ID
    And I edit the alias as "SAMPLE"
    And I click on next button
    And  I select radio button for CliQ and click on confirm
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for CliQ ID created "CliQ ID created successfully !"

    When I click back to dashboard option
    Then I should see the "Accounts" dashboard page

  @capitalMobile @cliQ @cliQManage
  Scenario: Verify under the confirmation page, edit the cliQ type the validate the edited details reflection - MOB-IOS-CLQ-029, MOB-IOS-CLQ-030, MOB-IOS-CLQ-035
    When I click on CliQID to enter "Alias" and enter alias as "MAR321"
    And I click close button
    Then I should see the "Accounts" dashboard page

    When I navigate to Profile menu
    And I select the "Manage CliQ ID" from profile menu
    And I click on the add CliQ button
    And I select CliQ default link account "JOD"
    And I click on CliQID to enter "Alias" and enter alias as "MAR"
    And I click on next button
    And I click on edit details to edit CliQ ID
    And I edit the alias "MAR123"
    And I click on next button
    Then I should see the edited text is equal "MAR123"