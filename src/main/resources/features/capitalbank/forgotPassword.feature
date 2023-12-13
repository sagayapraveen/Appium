@runPlan01
Feature: Forgot password on CapitalMobile app

  Background: Navigation on Forgot Password
    Given I have launched the CBJ app
    When I click the forget username password link
    And I should see the page as "Forget Username/Password"
    And I should see the page as "Please complete the following details to reset your password"

  @capitalMobile @forgotPassword
  Scenario: Verifying Debit card number field - MOB-AND-FPW-001 MOB-AND-FPW-002 MOB-AND-FPW-003 MOB-AND-FPW-004 MOB-AND-FPW-005 MOB-AND-FPW-006 MOB-AND-FPW-007 MOB-AND-FPW-008
    When I enter the debit card number as "4582730001084367"
    And I enter the card PIN as "3274"
    And I click on next button
    Then I should see the success pop-up "SUCCESS User Forgot Password Request Validated Successfull"
    And I should see the page as "Verify Mobile"
    And I should see the page as "Please enter the verification code sent to mobile number"
    And I should see Resend Code text

    When I Enter the six digit pin "654321" for transaction
    And I click on next button
    Then I should see the page as "Create Password"
    And I should see the page contains "Please enter your new password"
    And I should see the username is auto filled as "2221222"
    And I should see password hit message as "Minimum of  8 characters with combination of at least 1 uppercase, 1 lowercase, 1 symbol and 1 digit"

    When I Enter the password as "New@1234"
    And I Enter the re enter password as "New@1234"
    And I click on next button
    Then I should see the success pop-up "SUCCESS Password Updated Successful"
    And I should see the confirmation message You’re all set,ready to go!

    When I click on Back to Login button in confirmation page
    Then I should see Login page

  @capitalMobile @forgotPassword
  Scenario: Verifying debit card with wrong PIN information - MOB-AND-FPW-009 MOB-AND-FPW-010 MOB-AND-FPW-011 MOB-AND-FPW-012 MOB-AND-FPW-013 MOB-AND-FPW-014 MOB-AND-FPW-015 MOB-AND-FPW-016
    And I enter the debit card number as "45827300"
    Then I should see the field level error message "Debit card number should be of 16 digits"
    And I click close button

  @capitalMobile @forgotPassword
  Scenario Outline: Verifying Error message for wrong DebitCard <debitCard> and PIN - MOB-AND-FPW-017 MOB-AND-FPW-018 MOB-AND-FPW-019 MOB-AND-FPW-020 MOB-AND-FPW-021 MOB-AND-FPW-022 MOB-AND-FPW-023 MOB-AND-FPW-024
    When I enter debit card number as "<debitCard>"
    And I enter the PIN as "<pin>"
    And I click on next button
    Then I should see the error pop-up "Error Card Information entered is incorrect."

    Examples:
      | debitCard        | pin  |
      | 4582730001737096 | 5077 |
      | 4582730001073709 | 5066 |
      | 4582730001081231 | 7181 |
      | 4582730001074558 | 1461 |



