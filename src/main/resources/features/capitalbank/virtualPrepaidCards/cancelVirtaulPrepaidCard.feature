@runPlan01
Feature: Card Cancel

  @capitalMobile @virtualPrepaidCard @cancelVPC
  Scenario: Cancel the created card -MOB-AND-VPD-27,MOB-AND-VPD-28,MOB-AND-VPD-29,MOB-AND-VPD-26,MOB-AND-VPD-30
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2020169"
    And I navigate to dashboard page
    When I click on cards in dashboard
    And I select "Prepaid Card" from the dropdown
    And I select the newly added card "ANAS" and click on cancel card
    Then I should see the confirmation message for cancelling the card "cancel"

    When I confirm cancelling the card
    And I select the account to transfer the balance with account "4811849"
    Then I should see the success message of cancel "Your Virtual Prepaid  Card has been  cancelled successfully!"

    When I click back to dashboard option
    And I click on account in dashboard
    Then I should see the canceled card amount transferred to Primary card "4811849"