Feature: Blink Profile Setting

  Background: Navigation to Blink Request money
    Given I have logged in the blink app
    And I have navigated to the home page
    And I click on blink logo in home page
    And I click on profile setting from home page

# TC-Blink- profile settings-010, TC-Blink- profile settings-010
  @blink @blinkProfileSetting
  Scenario Outline: Verify My account info error <error>
    When I click in E-mail address in profile setting page
    And I enter the E-mail ID "<emailID>"
    Then I should see error pop-up "<error>"

    Examples:
      | emailID | error                                  |
      | abcd@   | Error please enter valid email address |
      |         | Error Please enter your email address  |

   # TC-Blink- profile settings-012, TC-Blink- profile settings-013
  @blink @blinkProfileSetting
  Scenario Outline: Verify My account info error <error>
    When I click on mobile number in profile setting page
    And I enter the "<mobile>" in profile setting
    Then I should see error pop-up "<error>"

    Examples:
      | mobile  | error                                                         |
      |         | Error You entered an invalid mobile number. Please try again. |
      | ABC@123 | Error You entered an invalid mobile number. Please try again. |

    # TC-Blink- profile settings-014
  @blink @blinkProfileSetting
  Scenario: Verify My account info
    When I click on mobile number in profile setting page
    And I click in country dropdown to search "India"
    And I enter the "9777663337" in profile setting
    Then I should see error pop-up "Error The mobile number you have entered already exists"

    # TC-Blink- profile settings-016
  @blink @blinkProfileSetting
  Scenario Outline: Verify change password error <error>
    When I click on the Change Password in profile setting
    And I enter "<currentPassword>" in change password page
    And I enter the new password "<newPassword>" in change password page
    And I confirm password "<confirmPassword>" in change password page
    Then I should see error pop-up "<error>"

    Examples:
      | currentPassword | newPassword | confirmPassword | error                                                       |
      | Test@123        | Test@1234   | Test            | Error Confirm password should be same as new password       |
      | Test@123        | Test        | Test            | Error Your password does not meet the minimum requirements. |

    # TC-Blink- profile settings-003
  @blink @blinkProfileSetting
  Scenario: Verify Mobile number changed successfully
    When I click on mobile number in profile setting page
    And I enter the "079569857" in profile setting
    And I enter the otp "576824" for the blink transaction
    Then I should see the "079569857" updated successfully in profile setting page

    When I click on mobile number in profile setting page
    And I click in country dropdown to search "India"
    And I enter the "9777663337" in profile setting
    And I enter the otp "576824" for the blink transaction
    Then I should see the "9777663337" updated successfully in profile setting page