@runPlan01
Feature: Forgot password on CapitalMobile app

  Background: Navigation on Forgot password page - MOB-AND-FPW-030 MOB-AND-FPW-031 MOB-AND-FPW-032 MOB-AND-FPW-033 MOB-AND-FPW-034 MOB-AND-FPW-035
    Given I have launched the CBJ app
    When I click the forget username password link
    And I should see the page as "Forget Username/Password"
    And I should see the page as "Please complete the following details to reset your password"
    And I enter the debit card number as "4582730001084367"
    And I enter the card PIN as "3274"
    And I click on next button
    Then I should see the success pop-up "SUCCESS User Forgot Password Request Validated Successfull"
    Then  I should see the page as "Verify Mobile"
    And I should see the page as "Please enter the verification code sent to mobile number"
    And I Enter the six digit pin "654321" for transaction
    And I click on next button
    Then I should see the page as "Create Password"
    And I should see the page contains "Please enter your new password"
    And I should see the username is auto filled as "2221222"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password should be greater than 8 characters
    When I Enter the password as "New@123"
    Then I should see the field level error message "Password should be greater than 8 characters"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password must have atleast 1 uppercase
    When I Enter the password as "new123@"
    Then I should see the field level error message "Password must have atleast 1 uppercase"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password must have atleast 1 lowercase
    When I Enter the password as "NEW1234@"
    Then I should see the field level error message "Password must have atleast 1 lowercase"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password must have atleast 1 symbol
    When I Enter the password as "New12345"
    Then I should see the field level error message "Password must have atleast 1 symbol"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password must have atleast 1 number
    When I Enter the password as "New@testing"
    Then I should see the field level error message "Password must have atleast 1 number"

  @capitalMobile @forgotPassword
  Scenario: Verifying Error Password must have atleast 1 number
    When I Enter the password as "New@1234"
    And I Enter the re enter password as "New@1235"
    And I click on enter
    Then I should see the field level error message with apostrophe "Password Doesn't Match"