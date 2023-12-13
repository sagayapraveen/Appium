@runPlan01
Feature: QR Pay functionality

  @capitalMobile @QRPay @dashboard
  Scenario: QR Pay functionality
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    When I navigate to QR Pay menu
    And I click close button in QR Pay
    Then I should see QR Pay menu