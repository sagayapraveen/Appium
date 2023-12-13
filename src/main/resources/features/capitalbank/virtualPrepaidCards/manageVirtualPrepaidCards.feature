@runPlan01
Feature: Manage Virtual Prepaid Cards in capitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page
    And I click on cards in dashboard
    And I select "Prepaid Card" from the dropdown

  @capitalMobile @virtualPrepaidCard
  Scenario: to verify the CVV of the card -MOB-AND-VPD-39, MOB-AND-VPD-45,MOB-AND-VPD-38,MOB-AND-VPD-4,MOB-AND-VPD-13,MOB-AND-VPD-3,MOB-AND-VPD-2,MOB-AND-VPD-6,MOB-AND-VPD-37, MOB-AND-VPD-42,MOB-AND-VPD-5,MOB-AND-VPD-1
    When I should see the selected card details and status
    Then I verify the selected card is "VIRTUAL"

    When I click on card details
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the card details
    And I should see Cvv of the card

  @capitalMobile @virtualPrepaidCard
  Scenario: Set the Card Limit -MOB-AND-VPD-47,MOB-AND-VPD-14,MOB-AND-VPD-52
    Then I verify "Limits" button is clickable

    When I click on Card Limits
    And I enable the E-commerce purchase
    And I set the card limit for VPC
    Then I should see the page as "Card Limits"

    When I click on save Button on Card limit page
    And I click on Card Limits
    And I enable the E-commerce purchase
    Then I should see the new limit for the card got updated

  @capitalMobile @virtualPrepaidCard
  Scenario: Set the Card Limit more than allowed limit
    Then I verify "Limits" button is clickable
    When I click on Card Limits
    And I enable the E-commerce purchase
    And I set the card limit "10000"
    Then I should see the message for card limit "Entered value is greater than max limit for Card Payments"

  @capitalMobile @virtualPrepaidCard
  Scenario: Validating the Virtual card deactivate toggle -MOB-AND-VPD-16,MOB-AND-VPD-15,MOB-AND-VPD-51
    When I navigate to toggle deactivate menu
    Then I verify deactivate toggle is clickable
    When I click on deactivate card toggle
    Then I should see the status of card "Warm"

    When I navigate to toggle deactivate menu
    And I click on activate card toggle
    Then I should see the status of card "Active"

  @capitalMobile @virtualPrepaidCard
  Scenario: Validation of adding card -MOB-AND-VPD-44
    When I view the available number of cards
      | Name   | Anas      | Mathiv    | Ibu       | Ibrahim   |
      | Number | 799449493 | 799449496 | 799449497 | 799449499 |
    And I swipe to add card menu
    And I select add new card button
    And I set the CardHolder name "Ibrahimm" and linked Mobile Number "799449499"
    And I confirm the card details
    Then I should see the error pop-up "Error You have exceeded the number of virtual cards allowed to be issued - 5 cards"