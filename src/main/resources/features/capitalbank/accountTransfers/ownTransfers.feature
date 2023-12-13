@runPlan02
Feature: Own Account Transfers

  Scenario Outline: Transfers to Own Account form <payFrom> account to <payTo> account - MOB-AND-TRF-215 MOB-AND-TRF-218 MOB-AND-TRF-221 MOB-AND-TRF-224 MOB-AND-TRF-227 MOB-AND-TRF-230 MOB-AND-TRF-233 MOB-AND-TRF-236 MOB-AND-TRF-239 MOB-AND-TRF-242 MOB-AND-TRF-245 MOB-AND-TRF-248 MOB-AND-TRF-251 MOB-AND-TRF-254 MOB-AND-TRF-257 MOB-AND-TRF-261 MOB-AND-TRF-264 MOB-AND-TRF-267 MOB-AND-TRF-270 MOB-AND-TRF-273 MOB-AND-TRF-276 MOB-AND-TRF-279 MOB-AND-TRF-282 MOB-AND-TRF-285 MOB-AND-TRF-288 MOB-AND-TRF-291 MOB-AND-TRF-294 MOB-AND-TRF-297 MOB-AND-TRF-300 MOB-AND-TRF-303 MOB-AND-TRF-306 MOB-AND-TRF-310
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    When I click the transfers menu
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select PayTo as "Own Account"
    And I select the PayTo account with "<payTo>" account number "<payToAccountNumber>"
    And I input the amount "<transactionAmount>" for the Transfers to Own account
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Account Transaction" with "debit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount exchanged is reduced from the PayFrom account balance

    When I select payTo account with account number "<payToAccountNumber>" After transaction
    Then I should see the "Account Transaction" with "credit" amount in the transaction history with today's date in "accounts" tab
    And I should see the amount transactionAmount is increased from the PayTo account balance

    @capitalMobile @accountTransfers @ownAccountTransfers
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber | payToAccountNumber |
      | random            | JOD     | USD   | 4816262              | 4816263            |
      | random            | JOD     | EUR   | 4816262              | 4109253            |
      | random            | JOD     | GBP   | 4816262              | 4816265            |
      | random            | JOD     | AED   | 4816262              | 4816266            |
      | random            | JOD     | JOD   | 4816262              | 4816261            |

      | random            | USD     | JOD   | 4816263              | 4816262            |
      | random            | USD     | EUR   | 4816263              | 4109253            |
      | random            | USD     | GBP   | 4816263              | 4816265            |
      | random            | USD     | AED   | 4816263              | 4816266            |
      | random            | USD     | USD   | 4026050              | 4816263            |

      | random            | GBP     | JOD   | 4816265              | 4816262            |
      | random            | GBP     | EUR   | 4816265              | 4109253            |
      | random            | GBP     | USD   | 4816265              | 4816263            |
      | random            | GBP     | AED   | 4816265              | 4816266            |

      | random            | EUR     | GBP   | 4109253              | 4816265            |
      | random            | EUR     | EUR   | 4109253              | 4816264            |
      | random            | EUR     | JOD   | 4109253              | 4816262            |
      | random            | EUR     | USD   | 4109253              | 4816263            |
      | random            | EUR     | AED   | 4109253              | 4816266            |

      | random            | AED     | JOD   | 4816266              | 4816262            |
      | random            | AED     | EUR   | 4816266              | 4109253            |
      | random            | AED     | USD   | 4816266              | 4816263            |
      | random            | AED     | GBP   | 4816266              | 4816265            |

    @p1
    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber | payToAccountNumber |
      | random            | JOD     | USD   | 4816262              | 4816263            |