@runPlan01
Feature: Sanad Digital Id security in capital app

  @capitalMobile @userProfile @sanadDigitalId
  Scenario: Verify the activation of sanad digital Id without national Id - MOB-AND-USER-029, MOB-AND-USER-041
    Given I have launched the CBJ app
    When I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    And I click on Profile menu
    And I click on Sanad Digital ID toggle
    And I click on confirm button
    Then I should see the error pop-up "Error National Id missing"

  @capitalMobile @userProfile @sanadDigitalId
  Scenario: Verify the activation of sanad digital Id cancel button - MOB-AND-USER-030
    Given I have launched the CBJ app
    When I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    And I click on Profile menu
    And I click on Sanad Digital ID toggle
    And I click on cancel button
    Then I should see the menu option