@runPlan04
Feature: Foreign currency Card payment from JOD account

  Scenario Outline: FCY <payTo> Card payment from JOD account - MOB-AND-CRD-105 MOB-AND-CRD-104 MOB-AND-CRD-103 MOB-AND-CRD-102 MOB-AND-CRD-101 MOB-AND-CRD-100 MOB-AND-CRD-099 MOB-AND-CRD-090 MOB-AND-CRD-089 MOB-AND-CRD-086 MOB-AND-CRD-084 MOB-AND-CRD-083 MOB-AND-CRD-082 MOB-AND-CRD-081 MOB-AND-CRD-080 MOB-AND-CRD-079 MOB-AND-CRD-078 MOB-AND-CRD-077 MOB-AND-CRD-076 MOB-AND-CRD-075 MOB-AND-CRD-074 MOB-AND-CRD-073 MOB-AND-CRD-072 MOB-AND-CRD-071 MOB-AND-CRD-070 MOB-AND-CRD-069 MOB-AND-CRD-068 MOB-AND-CRD-067 MOB-AND-CRD-066 MOB-AND-CRD-065 MOB-AND-CRD-064 MOB-AND-CRD-063 MOB-AND-CRD-062 MOB-AND-CRD-061 MOB-AND-CRD-060 MOB-AND-CRD-059 MOB-AND-CRD-058 MOB-AND-CRD-057 MOB-AND-CRD-056 MOB-AND-CRD-055 MOB-AND-CRD-054 MOB-AND-CRD-045 MOB-AND-CRD-044 MOB-AND-CRD-041 MOB-AND-CRD-039 MOB-AND-CRD-038 MOB-AND-CRD-037 MOB-AND-CRD-036 MOB-AND-CRD-035 MOB-AND-CRD-034 MOB-AND-CRD-033
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to <payFrom> account in Accounts tab
    And I click on cards in dashboard
    And I navigate to <payTo> card in Cards tab

    When I click the settle card
    And I enter the "<amount>" in Any amount field
    And I click on next button
    And I confirm the credit card payment
    Then I should see the success message "You have successfully paid your credit card" for credit card transfers

    When I click back to dashboard option
    And I navigate to accounts tab from cards tab
    And I navigate to <payFrom> account in Accounts tab
    Then I should see the transaction "Visa Credit Card Payment" with debit amount "exchanged" in the transaction history with today's date in accounts tab
    And I should see the amount exchanged is reduced from the current account balance after transaction

    When I click on cards in dashboard
    And I navigate to <payTo> card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Last Payment" as "<cardTransaction>" in card details
    And I should see the "Available Balance" as "Card Balance" in card details
    And I should see the amount <amount> is increased from the Card balance
    And I should see the transaction "CREDIT CARD PAYMENT" with credit amount "<cardTransaction>" in the transaction history with today's date in cards tab

    When I click the Used Balance tab
    Then I should see the updated card balance in Used Balance Tab

    When I click the payment history tab for credit card
    Then I should see the "CREDIT CARD PAYMENT" with the amount "<cardTransaction>" in the payment history with today's date

    @capitalMobile @creditCard @settleCard @settleFcyCard
    Examples:
      | payFrom | payTo | amount | cardTransaction |
      | JOD     | USD   | 10     | 10.00 USD       |
      | JOD     | EUR   | 10     | 10.00 EUR       |
      | JOD     | AED   | 10     | 10.00 AED       |
      | JOD     | GBP   | 10     | 10.00 GBP       |

    @p1
    Examples:
      | payFrom | payTo | amount | cardTransaction |
      | JOD     | USD   | 10     | 10.00 USD       |