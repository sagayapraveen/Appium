Feature: Blink Login

  #TC-BLINK-login-001 - TC-BLINK-login-020
  @blink @blinkLogin
  Scenario: Login without username and password
    Given I have launched the blink app
    When I click on login with email button
    And I click on login button
    Then I should see error pop-up "Please enter your email address"

  @blink @blinkLogin
  Scenario: Login without username and password
    Given I have launched the blink app
    When I entered the username as "rashan1@testing.com" and password as "test"
    And I click blink login button
    Then I should see the error pop-up "Error Oops! We are unable to authorize you. User might not be registered or something went wrong. Please try again later or contact our Engagement Team from the app or call 06-5200100. (Err-u)" in the blink app

  @blink @blinkLogin @forgotPassword
  Scenario: Login without username and password
    Given I have launched the blink app
    When I click on login with email button
    And I click forgot password
    And I click back to login
    Then I should see login page

  @blink @blinkLogin
  Scenario: Login without username and password
    Given I have launched the blink app
    When I entered the username as "rashan1@testing.com" and password as "test"
    Then I should see the password "••••"
    And I click on eye icon
    Then I should see the password "test"

  @blink @blinkLogin
  Scenario: Language check verification
    Given I have launched the blink app
    When I click on "ARB" language
    Then I should see "الدخول باستخدام البريد الإلكتروني" button

    When I click on "ENG" language
    Then I should see "Login with Email" button

  @blink @blinkLogin
  Scenario: Registration verification
    Given I have launched the blink app
    When I click on open an account button
    Then I should see profile creation page

  @blink @blinkLogin @forgotPassword
  Scenario: Login for password reset
    Given I have launched the blink app
    When I click on login with email button
    And I click forgot password
    And I enter the personal details
      | email    | rashan41@test.com |
      | national | 9922481389        |
      | date     | 10/31/2032        |
    Then I should see the new password page

  @blink @blinkLogin @forgotPassword
  Scenario Outline: Login error for forgot password error message <error>
    Given I have launched the blink app
    When I click on login with email button
    And I click forgot password
    And I enter the personal details
      | email    | <email>    |
      | national | <national> |
      | date     | <date>     |
    Then I should see the error pop-up "<error>" in the blink app

    Examples:
      | email             | national   | date       | error                                                                                               |
      | rashan41@test.com | 992248138  | 10/31/2032 | Error The national ID number you entered is invalid. Please enter a valid ID number and try again.  |
      | rashan41@tes.com  | 9922481389 | 10/31/2032 | Error User is not registered. Please register and call our Engagement Team if needed on 06-5200100. |
      | rashan41@test.com | 9922481389 | 10/31/2033 | Error The ID expiry date you entered is incorrect. Please enter the correct date and try again.     |
      | rashan41@test.com | nil        | 10/31/2032 | Error Oops! Please fill the missing field.                                                          |
      | rashan41@test.com | 9922481389 | nil        | Error Oops! Please fill the missing field.                                                          |
      | nil               | 9922481389 | 10/31/2032 | Error Oops! Please fill the missing field.                                                          |