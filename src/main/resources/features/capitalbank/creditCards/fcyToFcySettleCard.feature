@runPlan04
Feature: Foreign currency account to foreign currency Card Payment

  @capitalMobile @creditCard @settleCard @settleFcyCard
  Scenario Outline: FCY Settle Credit card from <payFrom> account to <payTo> card - MOB-AND-CRD-382 MOB-AND-CRD-381 MOB-AND-CRD-380 MOB-AND-CRD-379 MOB-AND-CRD-378 MOB-AND-CRD-377 MOB-AND-CRD-375 MOB-AND-CRD-374 MOB-AND-CRD-373 MOB-AND-CRD-372 MOB-AND-CRD-363 MOB-AND-CRD-362 MOB-AND-CRD-361 MOB-AND-CRD-360 MOB-AND-CRD-359 MOB-AND-CRD-358 MOB-AND-CRD-356 MOB-AND-CRD-355 MOB-AND-CRD-354 MOB-AND-CRD-353 MOB-AND-CRD-352 MOB-AND-CRD-351 MOB-AND-CRD-350 MOB-AND-CRD-349 MOB-AND-CRD-348 MOB-AND-CRD-346 MOB-AND-CRD-345 MOB-AND-CRD-344 MOB-AND-CRD-343 MOB-AND-CRD-334 MOB-AND-CRD-333 MOB-AND-CRD-332 MOB-AND-CRD-331 MOB-AND-CRD-330 MOB-AND-CRD-329 MOB-AND-CRD-327 MOB-AND-CRD-326 MOB-AND-CRD-325 MOB-AND-CRD-324 MOB-AND-CRD-323 MOB-AND-CRD-322 MOB-AND-CRD-321 MOB-AND-CRD-320 MOB-AND-CRD-319 MOB-AND-CRD-317 MOB-AND-CRD-316 MOB-AND-CRD-315 MOB-AND-CRD-314 MOB-AND-CRD-309 MOB-AND-CRD-304 MOB-AND-CRD-303 MOB-AND-CRD-302 MOB-AND-CRD-301 MOB-AND-CRD-300 MOB-AND-CRD-297 MOB-AND-CRD-296 MOB-AND-CRD-295 MOB-AND-CRD-294 MOB-AND-CRD-293 MOB-AND-CRD-292 MOB-AND-CRD-291 MOB-AND-CRD-290 MOB-AND-CRD-289 MOB-AND-CRD-285 MOB-AND-CRD-283 MOB-AND-CRD-282 MOB-AND-CRD-281 MOB-AND-CRD-280 MOB-AND-CRD-278 MOB-AND-CRD-277 MOB-AND-CRD-276 MOB-AND-CRD-275 MOB-AND-CRD-273 MOB-AND-CRD-272 MOB-AND-CRD-271 MOB-AND-CRD-270 MOB-AND-CRD-268 MOB-AND-CRD-267 MOB-AND-CRD-266 MOB-AND-CRD-265 MOB-AND-CRD-263 MOB-AND-CRD-262 MOB-AND-CRD-261 MOB-AND-CRD-260 MOB-AND-CRD-264 MOB-AND-CRD-265 MOB-AND-CRD-266 MOB-AND-CRD-267 MOB-AND-CRD-268 MOB-AND-CRD-269 MOB-AND-CRD-270 MOB-AND-CRD-220 MOB-AND-CRD-219 MOB-AND-CRD-218 MOB-AND-CRD-217 MOB-AND-CRD-216 MOB-AND-CRD-215 MOB-AND-CRD-214 MOB-AND-CRD-213 MOB-AND-CRD-212 MOB-AND-CRD-211 MOB-AND-CRD-210
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2213269"
    And I navigate to dashboard page
    And I navigate to <payFrom> account in Accounts tab
    And I click on cards in dashboard
    And I navigate to <payTo> card in Cards tab

    When I click the settle card
    And I change the Pay from account to <payFrom> account
    And I enter the "<transactionAmount>" in Any amount field
    And I click on next button
    And I confirm the credit card payment
    Then I should see the success message "You have successfully paid your credit card" for credit card transfers

    When I click back to dashboard option
    And I navigate to accounts tab from cards tab
    And I navigate to <payFrom> account in Accounts tab
    Then I should see the transaction "Visa Credit Card Payment" with debit amount "<accountTransaction>" in the transaction history with today's date in accounts tab
    And I should see the amount <accountDebit> is reduced from the current account balance after transaction

    When I click on cards in dashboard
    And I navigate to <payTo> card in Cards tab
    And I fetch the Card dashboard details from the card dashboard
    Then I should see the "Last Payment" as "<cardTransaction>" in card details
    And I should see the amount <transactionAmount> is increased from the Card balance
    And I should see the transaction "CREDIT CARD PAYMENT" with credit amount "<cardTransaction>" in the transaction history with today's date in cards tab

    When I click the Used Balance tab
    And I click the payment history tab for credit card
    Then I should see the "CREDIT CARD PAYMENT" with the amount "<cardTransaction>" in the payment history with today's date

    Examples:
      | payFrom | payTo | transactionAmount | cardTransaction | accountTransaction | accountDebit |
      | USD     | USD   | 10                | 10.00 USD       | 10.00 USD          | 10           |
      | GBP     | GBP   | 11                | 11.00 GBP       | 11.00 GBP          | 11           |
      | EUR     | EUR   | 12                | 12.00 EUR       | 12.00 EUR          | 12           |
      | AED     | AED   | 13                | 13.00 AED       | 13.00 AED          | 13           |

      | USD     | GBP   | 14                | 14.00 GBP       | exchanged          | exchanged    |
      | USD     | EUR   | 15                | 15.00 EUR       | exchanged          | exchanged    |
      | USD     | AED   | 16                | 16.00 AED       | exchanged          | exchanged    |

      | GBP     | USD   | 17                | 17.00 USD       | exchanged          | exchanged    |
      | GBP     | EUR   | 18                | 18.00 EUR       | exchanged          | exchanged    |
      | GBP     | AED   | 19                | 19.00 AED       | exchanged          | exchanged    |

      | EUR     | USD   | 20                | 20.00 USD       | exchanged          | exchanged    |
      | EUR     | GBP   | 21                | 21.00 GBP       | exchanged          | exchanged    |
      | EUR     | AED   | 22                | 22.00 AED       | exchanged          | exchanged    |

      | AED     | USD   | 10                | 10.00 USD       | exchanged          | exchanged    |
      | AED     | GBP   | 10                | 10.00 GBP       | exchanged          | exchanged    |
      | AED     | EUR   | 10                | 10.00 EUR       | exchanged          | exchanged    |

