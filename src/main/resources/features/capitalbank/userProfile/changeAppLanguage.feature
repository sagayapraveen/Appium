@runPlan01
Feature: Change App Language in capital app

  @capitalMobile @userProfile @changeAppLanguage
  Scenario: Verify the Change app language in English - MOB-AND-USER-027, MOB-AND-USER-028
    Given I have launched the CBJ app
    When I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu
    And I click on "Change App Language" menu
    And I select "Arabic" language
    And I click "English" Apply
    Then I should see "تغيير لغة التطبيق" menu

    When I click on "تغيير لغة التطبيق" menu
    And I select "English" language
    And I click "Arabic" Apply
    Then I should see "Change App Language" menu