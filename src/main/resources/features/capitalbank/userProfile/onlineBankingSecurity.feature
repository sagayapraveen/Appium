@runPlan01
Feature: Online banking security in capital app

  Background: Navigation to menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on Profile menu

  @capitalMobile @userProfile @onlineBankingSecurity
  Scenario: Verify the close button in online banking security - MOB-AND-USER-026, MOB-AND-USER-037
    When I click on "Online Banking Security Guidelines & Tips" menu
    And I read all the terms and conditions details
    And I click close button in "Online Banking Security Guidelines & Tips"
    Then I should see accounts tab

  @capitalMobile @userProfile @onlineBankingSecurity
  Scenario: Verify the online banking security back button - MOB-AND-USER-038
    When I click on "Online Banking Security Guidelines & Tips" menu
    And I read all the terms and conditions details
    And I click back button in "Online Banking Security"
    Then I should see "Online Banking Security Guidelines & Tips" menu

  @capitalMobile @userProfile @onlineBankingSecurity
  Scenario Outline: Verify the <content> contents in online banking security - MOB-AND-USER-042, MOB-AND-USER-043, MOB-AND-USER-044, MOB-AND-USER-045, MOB-AND-USER-046, MOB-AND-USER-047, MOB-AND-USER-048, MOB-AND-USER-049, MOB-AND-USER-050
    When I click on "Online Banking Security Guidelines & Tips" menu
    Then I verify the "<content>" content in online Banking Security Guidelines & Tips

    Examples:
      | content                                            |
      | Protect your password and personal information     |
      | Protect your Computer and Internet session         |
      | Mobile Security                                    |
      | Keep your registered mobile number updated with us |
      | Capital Cards Security                             |
      | When using any ATM                                 |
      | When paying at merchant terminals                  |
      | When paying online                                 |
      | Tips to avoid falling prey to fraudulent emails    |