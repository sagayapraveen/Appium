@runPlan01
Feature: Manage Centre

  Background: Navigation to MessageCentre page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I click on messageCentre button

  @capitalMobile @notification @messageCentre
  Scenario: Validating message in the inbox-MOB-AND-NOTIFICATIONS-1,MOB-AND-NOTIFICATIONS-2,MOB-AND-NOTIFICATIONS-10,MOB-AND-NOTIFICATIONS-11,MOB-AND-NOTIFICATIONS-12,MOB-AND-NOTIFICATIONS-13,MOB-AND-NOTIFICATIONS-14,MOB-AND-NOTIFICATIONS-15,MOB-AND-NOTIFICATIONS-18,MOB-AND-NOTIFICATIONS-19
    When I click on inbox tab
    Then I should see the message in the inbox

    When I click on add Button
    Then I should see the page as "New Message"

    When I select the new message details
      | I need to | Request |
      | About     | Card    |
    And I click on start chat button
    And I enter the message as "test"
    Then I should see the entered message in the screen with time

    When I click on back button from inbox page
    Then I should see the latest conversation details in message centre

    When I click on view conversation
    Then I should verify the date of conversation on the screen

    When I enter the message as "test"
    Then I should see the entered message in the screen with time
    And I click on back button from inbox page

  @capitalMobile @notification @messageCentre
  Scenario: Validation of the status of the notification-MOB-AND-NOTIFICATIONS-3,MOB-AND-NOTIFICATIONS-4,MOB-AND-NOTIFICATIONS-5,MOB-AND-NOTIFICATIONS-7
    When I click on the menu button
    And I click on selectAll option in the page
    And I select the action as "Mark as Read"
    Then I should see the updated status for notification "Test Njoud pp"

    When I click on the menu button
    And I click on selectAll option in the page
    And I select the action as "Mark as Unread"
    Then I should see the updated status for notification "Test Njoud pp"

    When I click on the menu button
    And I click on selectAll option in the page
    And I should see the "Delete Message(s)" action in the list

  @capitalMobile @notification @messageCentre
  Scenario: Validation of the notification-MOB-AND-NOTIFICATIONS-16,MOB-AND-NOTIFICATIONS-17
    When I click on notification tab
    And I swipe to delete the notification of "Test Njoud pp"
    And I select the notification "Test Njoud pp"
    Then I should see the notification details in the screen

    When I click on back button from notificationPage
    And I click the read or unread symbol in the notification "Test Njoud pp"
    Then I should see the updated status for notification "Test Njoud pp"