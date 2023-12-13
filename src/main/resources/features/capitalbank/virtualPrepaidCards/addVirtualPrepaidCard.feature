@runPlan01
Feature: Add Virtual prepaid card in capitalMobile app

  Background: Navigation to Virtual card page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2020169"
    And I navigate to dashboard page
    And I click on cards in dashboard
    And I select "Prepaid Card" from the dropdown

  @capitalMobile @virtualPrepaidCard @addVPC
  Scenario: Adding new Virtual prepaid Card -MOB-AND-VPD-41,MOB-AND-VPD-24,MOB-AND-VPD-40,MOB-AND-VPD-23
    When I swipe to add card menu
    And I select add new card button
    And I set the CardHolder name "Anas" and linked Mobile Number "799449493"
    Then I should see the page as "Confirm Add New Card"
    And I should see the confirmation page details of added card

    When I confirm the card details
    Then I should see the successful message with details of added card

    When I click on Top up Card button
    And I select TopUp To card
    And I enter the amount "10" for Top Up
    And I click on next button for TopUp page
    And I click on confirm button
    Then I should see the successful message for Top up

  @capitalMobile @virtualPrepaidCard @addVPC
  Scenario: Validation of adding virtual card more than exceeded attempts -MOB-AND-VPD-25,MOB-AND-VPD-22
    When I swipe to add card menu
    Then I verify "Add" button is clickable

    When I select add new card button
    And I set the CardHolder name "Anas" and linked Mobile Number "799449493"
    Then I should see the confirmation page details of added card

    When I confirm the card details
    Then I should see the error pop-up "Error You have exceeded the number of virtual cards allowed to be issued - 5 cards"

  @capitalMobile @virtualPrepaidCard @addVPC
  Scenario: Adding a card without entering the Card holder name -MOB-AND-VPD-49
    When I swipe to add card menu
    And I select add new card button
    And I set the CardHolder name "" and linked Mobile Number "799449493"
    Then I verify Next button is "disabled"

  @capitalMobile @virtualPrepaidCard @addVPC
  Scenario: Adding a card entering invalid mobile number -MOB-AND-VPD-50
    When I swipe to add card menu
    And I select add new card button
    And I set the CardHolder name "Anas" and linked Mobile Number "7994493"
    Then I should see the field level error message "Mobile number should be of 9 digits"