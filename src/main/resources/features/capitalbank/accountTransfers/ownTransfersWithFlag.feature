@runPlan02
Feature: Account Transfers with flag change

  @capitalMobile @accountTransfers @ownAccountTransfers
  Scenario Outline: Transfers to Own Account from <payFrom> account to <payTo> account with Flag <payFrom> - MOB-AND-TRF-314 MOB-AND-TRF-322 MOB-AND-TRF-325 MOB-AND-TRF-328 MOB-AND-TRF-331 MOB-AND-TRF-334 MOB-AND-TRF-335 MOB-AND-TRF-343 MOB-AND-TRF-344 MOB-AND-TRF-348 MOB-AND-TRF-355 MOB-AND-TRF-357 MOB-AND-TRF-361 MOB-AND-TRF-366 MOB-AND-TRF-368 MOB-AND-TRF-373 MOB-AND-TRF-378 MOB-AND-TRF-382 MOB-AND-TRF-387 MOB-AND-TRF-392 MOB-AND-TRF-397 MOB-AND-TRF-400 MOB-AND-TRF-403 MOB-AND-TRF-408 MOB-AND-TRF-411 MOB-AND-TRF-414 MOB-AND-TRF-417 MOB-AND-TRF-420 MOB-AND-TRF-423 MOB-AND-TRF-426 MOB-AND-TRF-429 MOB-AND-TRF-432 MOB-AND-TRF-435 MOB-AND-TRF-438 MOB-AND-TRF-441 MOB-AND-TRF-444 MOB-AND-CRD-429 MOB-AND-CRD-428 MOB-AND-CRD-427 MOB-AND-CRD-426 MOB-AND-CRD-425 MOB-AND-CRD-424 MOB-AND-CRD-423 MOB-AND-CRD-422 MOB-AND-CRD-400 MOB-AND-CRD-399 MOB-AND-CRD-398 MOB-AND-CRD-397
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click on the transfers menu
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select PayTo as "Own Account"
    And I select the PayTo account with "<payTo>" account number "<payToAccountNumber>"
    And I input the amount "<transactionAmount>" for the Transfers to Own account
    And I select the currency type as "<payFrom>"
    Then I verify the transfer exchange rate with flag from "<payTo>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Account Transaction" for flag with "debit" amount in the transaction history with today's date in accounts "tab"
    And I should see the amount transactionAmount is reduced from the PayFrom account balance

    When I select payTo account with account number "<payToAccountNumber>" After transaction
    Then I should see the "Account Transaction" for flag with "credit" amount in the transaction history with today's date in accounts "tab"
    And I should see the amount exchanged is increased from the PayTo account balance

    Examples:
      | transactionAmount | payFrom | payTo | payFromAccountNumber | payToAccountNumber |
      | random            | JOD     | USD   | 4154573              | 4816263            |
      | random            | JOD     | EUR   | 4816262              | 4109253            |
      | random            | JOD     | GBP   | 4816262              | 4816265            |
      | random            | JOD     | AED   | 4816262              | 4816266            |

      | random            | USD     | JOD   | 4816263              | 4816262            |
      | random            | USD     | EUR   | 4816263              | 4109253            |
      | random            | USD     | GBP   | 4816263              | 4816265            |
      | random            | USD     | AED   | 4816263              | 4816266            |

      | random            | GBP     | JOD   | 4816265              | 4816262            |
      | random            | GBP     | EUR   | 4816265              | 4109253            |
      | random            | GBP     | USD   | 4816265              | 4816263            |
      | random            | GBP     | AED   | 4816265              | 4816266            |

      | random            | EUR     | GBP   | 4109253              | 4816265            |
      | random            | EUR     | JOD   | 4109253              | 4816262            |
      | random            | EUR     | USD   | 4109253              | 4816263            |
      | random            | EUR     | AED   | 4109253              | 4816266            |

      | random            | AED     | JOD   | 4816266              | 4816262            |
      | random            | AED     | EUR   | 4816266              | 4109253            |
      | random            | AED     | USD   | 4816266              | 4816263            |
      | random            | AED     | GBP   | 4816266              | 4816265            |