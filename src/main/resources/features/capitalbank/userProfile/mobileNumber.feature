@runPlan01
Feature: Mobile no in capital app

  @capitalMobile @userProfile @mobileNumber
  Scenario: Verify the error message of mobile no - MOB-AND-USER-003
    Given I have launched the CBJ app
    When I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu
    And I click on "Update Mobile Number" menu
    And I verify the mobile 6 digit pin for the transaction
    And I enter the new mobile number "09762732"
    Then I should see the error message "Mobile number should be of 9 digits" for mobile