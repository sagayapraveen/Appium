@runPlan04
Feature: Foreign currency to JOD Card Payment

  Scenario Outline: JOD card payment from <payFrom> currency account - MOB-AND-CRD-209 MOB-AND-CRD-208 MOB-AND-CRD-207 MOB-AND-CRD-206 MOB-AND-CRD-205 MOB-AND-CRD-204 MOB-AND-CRD-203 MOB-AND-CRD-202 MOB-AND-CRD-201 MOB-AND-CRD-200 MOB-AND-CRD-199 MOB-AND-CRD-198 MOB-AND-CRD-197 MOB-AND-CRD-196 MOB-AND-CRD-195 MOB-AND-CRD-194 MOB-AND-CRD-193 MOB-AND-CRD-192 MOB-AND-CRD-191 MOB-AND-CRD-190 MOB-AND-CRD-189 MOB-AND-CRD-180 MOB-AND-CRD-179 MOB-AND-CRD-176 MOB-AND-CRD-175 MOB-AND-CRD-174 MOB-AND-CRD-173 MOB-AND-CRD-172 MOB-AND-CRD-171 MOB-AND-CRD-170 MOB-AND-CRD-169 MOB-AND-CRD-168 MOB-AND-CRD-167 MOB-AND-CRD-166 MOB-AND-CRD-165 MOB-AND-CRD-164 MOB-AND-CRD-163 MOB-AND-CRD-162 MOB-AND-CRD-161 MOB-AND-CRD-160 MOB-AND-CRD-159 MOB-AND-CRD-158 MOB-AND-CRD-157 MOB-AND-CRD-156 MOB-AND-CRD-155 MOB-AND-CRD-154 MOB-AND-CRD-153 MOB-AND-CRD-152 MOB-AND-CRD-151 MOB-AND-CRD-150 MOB-AND-CRD-149 MOB-AND-CRD-148 MOB-AND-CRD-147 MOB-AND-CRD-146 MOB-AND-CRD-145 MOB-AND-CRD-144 MOB-AND-CRD-135 MOB-AND-CRD-134 MOB-AND-CRD-131 MOB-AND-CRD-130 MOB-AND-CRD-129 MOB-AND-CRD-128 MOB-AND-CRD-127 MOB-AND-CRD-126 MOB-AND-CRD-125 MOB-AND-CRD-124 MOB-AND-CRD-123 MOB-AND-CRD-122 MOB-AND-CRD-121 MOB-AND-CRD-120 MOB-AND-CRD-119 MOB-AND-CRD-118 MOB-AND-CRD-117 MOB-AND-CRD-116 MOB-AND-CRD-115 MOB-AND-CRD-114 MOB-AND-CRD-113 MOB-AND-CRD-112 MOB-AND-CRD-111 MOB-AND-CRD-110 MOB-AND-CRD-109 MOB-AND-CRD-108 MOB-AND-CRD-107 MOB-AND-CRD-106
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to <payFrom> account in Accounts tab
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab

    When I click the settle card
    And I change the Pay from account to <payFrom> account
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
    And I navigate to JOD card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Last Payment" as "<cardTransaction>" in card details
    Then I should see the "Available Balance" as "Card Balance" in card details
    Then I should see the amount <amount> is increased from the Card balance
    And I should see the transaction "CREDIT CARD PAYMENT" with credit amount "<cardTransaction>" in the transaction history with today's date in cards tab

    When I click the Used Balance tab
    Then I should see the updated card balance in Used Balance Tab

    When I click the payment history tab for credit card
    Then I should see the "CREDIT CARD PAYMENT" with the amount "<cardTransaction>" in the payment history with today's date

    @capitalMobile @creditCard @settleCard
    Examples:
      | payFrom | amount | cardTransaction |
      | USD     | 10     | 10.000 JOD      |
      | AED     | 12     | 12.000 JOD      |
      | GBP     | 15     | 15.000 JOD      |
      | EUR     | 20     | 20.000 JOD      |

    @p1
    Examples:
      | payFrom | amount | cardTransaction |
      | USD     | 10     | 10.000 JOD      |