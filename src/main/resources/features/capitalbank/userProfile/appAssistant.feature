@runPlan01
Feature: App assistant in capital app

  @capitalMobile @userProfile @appAssistant
  Scenario: Verify the app assistant - MOB-AND-USER-013, MOB-AND-USER-014, MOB-AND-USER-015, MOB-AND-USER-015, MOB-AND-USER-016, MOB-AND-USER-017,
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu
    When I navigate to app assistant menu
    And I click done after viewing all the feature
    Then I should see "App Assistant" menu