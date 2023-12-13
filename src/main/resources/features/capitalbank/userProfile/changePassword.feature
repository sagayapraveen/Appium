@runPlan01
Feature: Change password in capital app

  Background: Navigation to menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu

  @capitalMobile @userProfile @changePassword
  Scenario Outline: Validation of <errorMessage> for invalid password - MOB-AND-USER-004, MOB-AND-USER-006, MOB-AND-USER-007, MOB-AND-USER-008, MOB-AND-USER-009, MOB-AND-USER-011, MOB-AND-USER-012
    When I click on change password
    And I enter <currentPassword> then <newPassword> and <re-enterPassword>
    Then I should see the error message "<errorMessage>" for password

    Examples:
      | currentPassword | newPassword | re-enterPassword | errorMessage                                 |
      | New@1234        | test        | test             | Password must have atleast 1 uppercase       |
      | New@1234        | TEST        | TEST             | Password must have atleast 1 lowercase       |
      | New@1234        | Test        | Test             | Password must have atleast 1 number          |
      | New@1234        | Test@123    | Test@1234        | Password Doesn't Match                       |
      | New@1234        | Test1       | Test1            | Password must have atleast 1 symbol          |
      | New@12          | Test@123    | Test@123         | Password should be greater than 8 characters |

  @capitalMobile @userProfile @changePassword
  Scenario: Verify the incorrect password error message - MOB-AND-USER-010
    When I click on change password
    And I enter the password details
      | Current Password  | New@1234567 |
      | New Password      | Test1#test  |
      | Re-enter Password | Test1#test  |
    And I click on next button
    Then I should see the error pop-up "Error Incorrect password."

  @capitalMobile @userProfile @changePassword
  Scenario: Verify the Next button without entering re enter password - MOB-AND-USER-031
    When I click on change password
    And I enter the current password as "New@1234567" details and new password as "Test1#test"
    Then I should see the next button is non clickable