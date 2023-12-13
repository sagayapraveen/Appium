@runPlan01
Feature: Health and wealth in capital app

  Background: Navigation to menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu

  @capitalMobile @userProfile @healthAndWealth
  Scenario Outline: Verify the health and wealth <type> toggle - MOB-AND-USER-018, MOB-AND-USER-019
    When I click on health and wealth toggle
    And I give "<type>" on terms and conditions
    Then I should see message for health and wealth

    Examples:
      | type |
      | Yes  |
      | No   |

  @capitalMobile @userProfile @healthAndWealth
  Scenario: Verify the terms and condition back button - MOB-AND-USER-032
    When I click on health and wealth toggle
    And I came back from terms and condition
    Then I should see the menu option