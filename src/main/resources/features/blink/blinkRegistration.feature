Feature: Blink Registration

  Background: Blink app Registration verification
    Given I have launched the blink app
    When I click open an account button
    And I click on open your account now button

  #TC-BLNK-Onboarding-007, TC-BLNK-Onboarding-008, TC-BLNK-Onboarding-009, TC-BLNK-Onboarding-010, TC-BLNK-Onboarding-011, TC-BLNK-Onboarding-012
  @blink @blinkRegistration
  Scenario: Register with existing email address
    When I register with the email "omartesting@y.com" and mobile number "random"
    Then I should see the error pop-up "Error The email you have entered already exists, please enter another email or try to login using this email if you have already tried to register previously." in the blink app

  @blink @blinkRegistration
  Scenario: Register with Invalid email address
    When I register with the email "test@test" and mobile number "random"
    Then I should see the error pop-up "Error please enter valid email address" in the blink app

  @blink @blinkRegistration
  Scenario: Register with existing Mobile number
    When I register with the email "omartestin@yahoo.com" and mobile number "751474141"
    Then I should see the error pop-up "Error The mobile number you have entered already exists, please enter another number or try to login using your email and password if you have already tried to register previously." in the blink app

  @blink @blinkRegistration
  Scenario: Register password setup with invalid requirements
    When I register with the email "random" and mobile number "random"
    And I set a new password "Test@12" for blink register
    Then I should see the error pop-up "Error Your password does not meet the minimum requirements.  Please try again." in the blink app

  @blink @blinkRegistration
  Scenario: Register with invalid otp and exceed attempts
    When I register with the email "random" and mobile number "random"
    And I set a new password "Test@1234" for blink register
    And I enter the otp code as "111111"
    Then I should see the error pop-up "Error You have entered an invalid code. Please try again." in the blink app

    When I clear and re-enter the otp code as "123456"
    And I clear and re-enter the otp code as "654321"
    Then I should see the error pop-up "Error You have exceed the number of times allowed to enter the code. Please try again later or contact our Engagement Team from the app or call 06-5200100." in the blink app

  @blink @blinkRegistration
  Scenario: Register without accepting terms
    When I register with the email "random" and mobile number "random"
    And I set a new password "Test@1234" for blink register
    And I verify the OTP "576824" for cliq in blink app transaction
    And I swipe from profile page
    And I swipe from scanning page
    Then I should see the error pop-up "Error Confirm to the terms and condition to proceed." in the blink app