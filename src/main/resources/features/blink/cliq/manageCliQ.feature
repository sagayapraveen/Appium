Feature: Manage CliQ

  Background: Blink app Manage Cliq feature
    Given I have logged in the blink app
    And I have navigated to the home page
    When I select the Manage CliQ from the home page

  @blink @cliQBlink @manageCliQ @addCliQ
  Scenario: Add new CliQ ID
    When I click the Create new CliQ ID
    And I fill the below details for create new CliQ
      | CliQ ID Type        | Alias |
      | Alias name          | OMAR  |
      | Set default account | Yes   |
    And I verify the OTP "576824" for the blink app transaction
    Then I should see the success message "CliQ ID created successfully Alias OMAR" for Create CliQ ID
    When I swipe back to dashboard
    Then I should see CliQ id with the name "OMAR"

  #TC-BLNK-OutwardCliq-002
  @blink @cliQBlink @manageCliQ @updateCliQ
  Scenario: Update created CliQ ID
    When I select active CliQ alias "OMAR"
    And I edit the CLiq ID to the alias name as "OMAR1"
    And I verify the OTP "576824" for cliq in blink app transaction
    Then I should see the active alias name "OMAR1" in the CliQ page

  #TC-BLNK-OutwardCliq-005
  @blink @cliQBlink @manageCliQ @suspendCliQ
  Scenario: Suspend created CliQ ID
    When I select active CliQ alias "OMAR1"
    And I suspend the CLiQ ID
    And I verify the OTP "576824" for cliq in blink app transaction
    Then I should see the suspended alias name "OMAR1" in the CliQ page

  #TC-BLNK-OutwardCliq-006
  @blink @cliQBlink @manageCliQ @activateCliQ
  Scenario: Activate created CliQ ID
    When I select suspended CliQ alias "OMAR1"
    And I activate the CliQ ID
    And I verify the OTP "576824" for cliq in blink app transaction
    Then I should see the active alias name "OMAR1" in the CliQ page

  #TC-BLNK-OutwardCliq-004
  @blink @cliQBlink @manageCliQ @deleteCliQ
  Scenario: Delete created CliQ ID
    When I select active CliQ alias "OMAR1"
    And I delete the CLiQ ID
    And I verify the OTP "576824" for cliq in blink app transaction
    Then I should not see the alias name "OMAR1" in the CliQ page

    #TC-BLNK-OutwardCliq-003
  @blink @cliQBlink @manageCliQ @setAsDefaultCliq
  Scenario: Add new CliQ ID
    When I click the Create new CliQ ID
    And I fill the below details for create new CliQ
      | CliQ ID Type        | Alias  |
      | Alias name          | JORDAN |
      | Set default account | No     |
    And I verify the OTP "576824" for the blink app transaction
    Then I should see the success message "CliQ ID created successfully Alias JORDAN to manage CLIQ ID" for Create CliQ ID

    When I swipe back to dashboard
    Then I should see CliQ id with the name "JORDAN"

    When I set the "JORDAN" cliq value as default
    And I verify the OTP "576824" for cliq in blink app transaction
    Then I should see the default value in "JORDAN"