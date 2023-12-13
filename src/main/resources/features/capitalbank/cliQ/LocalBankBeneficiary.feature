#Feature: Local Bank Beneficiary on CapitalMobile app
#   Non-Automatable
#       # MOB-IOS-CLQ-130
#  @capitalMobile @cliQManage @cliQTransfers
#  Scenario: Verify
#    Given I have launched the CBJ app
#    And I have logged in the CBJ app with username as "izzidin"
#    And I navigate to dashboard page
#    And I navigate to Profile menu
#    And I select the "Local Bank Beneficiaries" from profile menu
#    And I click on add CliQ button
#    And I select "CliQ" from select transaction type
#    And I select the beneficiary type "CliQ ID Alias"
#    And I enter the Mobile Number or Alias as "Rolex"
#    And I enter the nick name as "CliQ TRANSFER"
#    And I click on next button
#    And I click on confirm button
#    And I verify the mobile 6 digit pin for the transaction
#    Then I should see the successful message "Successfully added as beneficiary!"
#
#    # MOB-IOS-CLQ-129
#  @capitalMobile @CliQCBoJ @validate129
#  Scenario: Verify
#    Given I have launched the CBJ app
#    And I have logged in the CBJ app with username as "izzidin"
#    And I navigate to dashboard page
#    When I click on CliQ in dashboard
#    And I click on "Manage My CLIQ ID" to navigate to pay to page
#    And I click on the add CliQ button
#    When I select CliQ default link account
#    And I click on CliQID to enter "Alias" and enter alias as "MAR"
#    And I click on next button
#    And  I select radio button for CliQ and click on confirm
#    And I verify the mobile 6 digit pin for the transaction
#    Then I should see the success message for CliQ ID created "CliQ ID created successfully !"
#
