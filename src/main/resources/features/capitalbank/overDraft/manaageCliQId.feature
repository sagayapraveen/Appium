@runPlan01
Feature: Manage CliQ

  Background: Navigation to Dashboard Page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2221222"
    And I navigate to dashboard page
    And I navigate to Profile menu
    And  I select the Manage CliQ ID from the profile

  @capitalMobile @overDraft @manageCliQCapitalMobile
  Scenario Outline: Creating a new cliQ Id - <cliQIdType>-MOB-AND-VAL-003,MOB-AND-VAL-004,MOB-AND-VAL-005,MOB-AND-VAL-006,MOB-AND-VAL-007,MOB-AND-VAL-010,MOB-AND-VAL-011,MOB-AND-VAL-012
    When I click on create new cliQ
    And I select the Default link account with account number "<defaultLinkAccount>"
    And I fetch the available balance amount from default link account card
    And I select the cliQ ID type as "<cliQIdType>"
    And I Enter the "<cliQIdType>" as "<alias>"
    And I click on next button
    And I select the Default link account with account number "<defaultLinkAccount>"
    And I click on the radio button for acceptance of created CliQ Id
    And I confirm the creation of new CliQ Id
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message for create CliQ ID "<message>"

    Examples:
      | defaultLinkAccount | cliQIdType    | alias    | message                        |
      | 4635187            | Alias         | MAR      | CliQ ID created successfully ! |
      | 4635187            | Mobile Number | 79640161 | CliQ ID created successfully ! |

  @capitalMobile @overDraft @manageCliQCapitalMobile
  Scenario Outline: Creating a new cliQ Id - negative testcase - <message>-MOB-AND-VAL-008,MOB-AND-VAL-009,MOB-AND-VAL-013
    When I click on create new cliQ
    And I select the Default link account with account number "<defaultLinkAccount>"
    And I select the cliQ ID type as "<cliQIdType>"
    And I Enter the "<cliQIdType>" as "<alias>"
    Then I should see the alert message "<message>" for CliQ ID

    Examples:
      | defaultLinkAccount | cliQIdType    | alias  | message                                   |
      | 4635187            | Alias         | G      | Alias Should Be Greater Than 3 Characters |
      | 4635187            | Alias         | 12345  | Alias must have atleast 1 Uppercase       |
      | 4635187            | Mobile Number | 962796 | Mobile number should be of 9 digits       |
