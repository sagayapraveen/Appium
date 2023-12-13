@runPlan01
Feature: CapitalInvestment fund transfers on CapitalMobile app

  Background: Navigation to transferPage
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2029335"
    And I navigate to dashboard page
    And I navigate to investment option

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario Outline: Investment Fund transfer from <payFrom> to <payTo> - MOB-AND-INVEST-081, MOB-AND-INVEST-071, MOB-AND-INVEST-070, MOB-AND-INVEST-068, MOB-AND-INVEST-067, MOB-AND-INVEST-066, MOB-AND-INVEST-065, MOB-AND-INVEST-064, MOB-AND-INVEST-062, MOB-AND-INVEST-055, MOB-AND-INVEST-046, MOB-AND-INVEST-043, MOB-AND-INVEST-042, MOB-AND-INVEST-040, MOB-AND-INVEST-038, MOB-AND-INVEST-037, MOB-AND-INVEST-035, MOB-AND-INVEST-033, MOB-AND-INVEST-032, MOB-AND-INVEST-031, MOB-AND-INVEST-027, MOB-AND-INVEST-068, MOB-AND-INVEST-082
    When I select Fund option
    And I select <payFrom> card and <payTo> for "fund transfer"
    And I enter amount as <amount> and description as "fund" for Investments page
    Then I should verifying the details in the confirm page

    When I verify the mobile 6 digit pin for the transaction
    Then I should see the request "Request has been submitted" message

    When I click back to dashboard option
    And I select Fund option
    Then I should see the "fund" amount in the pay from <payFrom> and pay to <payTo> cards should get updated

    Examples:
      | payFrom | payTo | amount |
      | USD     | JOD   | 10     |
      | JOD     | JOD   | 10     |
      | JOD     | USD   | 10     |
      | GBP     | JOD   | 10     |

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario Outline: Investment Fund transfer with insufficient balance from <payFrom> to <payTo> - MOB-AND-INVEST-073, MOB-AND-INVEST-036,
    When I select Fund option
    And I select <payFrom> card and <payTo> for "fund transfer"
    And I enter amount as <amount> and description as "fund" for Investments page
    And I should verifying the details in the confirm page
    Then I should see the error pop-up "Error You do not have sufficient balance for this transaction. Please select another account or change the transaction amount."

    Examples:
      | payFrom | payTo | amount |
      | USD     | JOD   | 7000000  |
      | JOD     | JOD   | 7000000  |
      | JOD     | USD   | 7000000  |
      | GBP     | JOD   | 7000000  |

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario Outline:Investment Fund transfer with invalid OTP from <payFrom> to <payTo> - MOB-AND-INVEST-079, MOB-AND-INVEST-041, MOB-AND-INVEST-030, MOB-AND-INVEST-029, MOB-AND-INVEST-025
    When I select Fund option
    And I select <payFrom> card and <payTo> for "fund transfer"
    And I enter amount as <amount> and description as "fund" for Investments page
    Then I should verifying the details in the confirm page

    When I verify the mobile otp pin "654322"
    Then I should see the error pop-up "Error This OTP is invalid. Please enter the correct OTP."

    Examples:
      | payFrom | payTo | amount |
      | USD     | JOD   | 1      |
      | JOD     | JOD   | 1      |
      | JOD     | USD   | 1      |
      | GBP     | JOD   | 1      |

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario: Verifying the close button for Fund transfer - MOB-AND-INVEST-020, MOB-AND-INVEST-004
    When I select Fund option
    And I select JOD card and JOD for "fund transfer"
    And I enter amount as 1 and description as "fund" for Investments page
    And I click close button
    Then I should see the page as "Investments"

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario: Verifying the Terms and conditions for Fund transfer - MOB-AND-INVEST-003, MOB-AND-INVEST-002, MOB-AND-INVEST-001, MOB-AND-INVEST-028, MOB-AND-INVEST-039
    When I select Fund option
    And I select JOD card and JOD for "fund transfer"
    And I enter amount as 1 and description as "fund" for Investments page
    And I click the confirm button after checking terms and condition
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the request "Request has been submitted" message

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario: Investment Fund transfer for choosing a new pay to card - MOB-AND-INVEST-026
    When I select Fund option
    And I select JOD card and Reg for "fund transfer"
    And I enter amount as 7000000 and description as "fund" for Investments page
    And I navigate back to fund page
    And I select "fund" new pay to card Int
    And I enter amount as 10 and description as "fund" for Investments page
    Then I should verifying the details in the confirm page

    When I verify the mobile 6 digit pin for the transaction
    Then I should see the request "Request has been submitted" message

    When I click back to dashboard option
    And I select Fund option
    Then I should see the "fund" amount in the pay from JOD and pay to Int cards should get updated

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario: Investment Fund transfer for choosing a new pay to card - MOB-AND-INVEST-024
    When I select Fund option
    And I select JOD card and JOD for "fund transfer"
    And I enter invalid amount as "00"
    Then I verify the done button field is not enabled

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario Outline: Investment Fund transfer dashboard verification from <payFrom> to <payTo> - MOB-AND-INVEST-025, MOB-AND-INVEST-023, MOB-AND-INVEST-019
    When I select Fund option
    And I select <payFrom> card and <payTo> for "fund transfer"
    And I enter amount as <amount> and description as "fund" for Investments page
    Then I should verifying the details in the confirm page

    When I verify the mobile 6 digit pin for the transaction
    Then I should see the request "Request has been submitted" message

    When I click back to dashboard option
    Then I should see the <payTo> account details in the investments tab
    And I should see the reference no in latest transactions

    Examples:
      | payFrom | payTo | amount |
      | JOD     | USD   | 10     |
      | JOD     | JOD   | 10     |
      | JOD     | USD   | 10     |

  @capitalMobile @capitalInvestment @investmentFundTransfer
  Scenario: Investment dashboard verification - MOB-AND-INVEST-017, MOB-AND-DAB-037
    When I click on Transaction tab
    And I click on view more button
    Then I should see the transaction history for the today's date