@runPlan04
Feature: Domestic Account Transfers to new beneficiary with flag change

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Fees on Sender option - MOB-AND-TRF-281 MOB-AND-TRF-282 MOB-AND-TRF-283 MOB-AND-TRF-284 MOB-AND-TRF-285 MOB-AND-TRF-286 MOB-AND-TRF-287 MOB-AND-TRF-288 MOB-AND-TRF-289 MOB-AND-TRF-290 MOB-AND-TRF-291 MOB-AND-TRF-292 MOB-AND-TRF-293 MOB-AND-TRF-294 MOB-AND-TRF-295 MOB-AND-TRF-296 MOB-AND-TRF-297 MOB-AND-TRF-298 MOB-AND-TRF-299 MOB-AND-TRF-300 MOB-AND-TRF-301 MOB-AND-TRF-302 MOB-AND-TRF-303 MOB-AND-TRF-304 MOB-AND-TRF-305 MOB-AND-TRF-306 MOB-AND-TRF-307 MOB-AND-TRF-308 MOB-AND-TRF-309 MOB-AND-TRF-310 MOB-AND-TRF-311 MOB-AND-TRF-312 MOB-AND-TRF-313 MOB-AND-TRF-314 MOB-AND-TRF-315 MOB-AND-TRF-316 MOB-AND-TRF-317 MOB-AND-TRF-318 MOB-AND-TRF-319 MOB-AND-TRF-320 MOB-AND-TRF-321 MOB-AND-TRF-322 MOB-AND-TRF-323 MOB-AND-TRF-324 MOB-AND-TRF-325 MOB-AND-TRF-326 MOB-AND-TRF-327 MOB-AND-TRF-328 MOB-AND-TRF-329 MOB-AND-TRF-330 MOB-AND-TRF-331 MOB-AND-TRF-332 MOB-AND-TRF-333 MOB-AND-TRF-334 MOB-AND-TRF-335 MOB-AND-TRF-336 MOB-AND-TRF-337 MOB-AND-TRF-338 MOB-AND-TRF-339 MOB-AND-TRF-340 MOB-AND-TRF-341 MOB-AND-TRF-342 MOB-AND-TRF-343 MOB-AND-TRF-344 MOB-AND-TRF-345 MOB-AND-TRF-346 MOB-AND-TRF-347 MOB-AND-TRF-348 MOB-AND-TRF-349 MOB-AND-TRF-350 MOB-AND-TRF-351 MOB-AND-TRF-352 MOB-AND-TRF-353 MOB-AND-TRF-354 MOB-AND-TRF-355 MOB-AND-TRF-356 MOB-AND-TRF-357 MOB-AND-TRF-358 MOB-AND-TRF-359 MOB-AND-TRF-360 MOB-AND-TRF-361 MOB-AND-TRF-362 MOB-AND-TRF-363 MOB-AND-TRF-364 MOB-AND-TRF-365 MOB-AND-TRF-366 MOB-AND-TRF-367 MOB-AND-TRF-368
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO54ARAB1110000000111006906102"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I swipe to see end of the page
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I verify the mobile 6 digit pin for the transaction
    And I should see the success message "Transfer successful!" for credit card transfers

    When I swipe to see Back to Dashboard
    And I click back to dashboard option
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @p1
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | JOD  |

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @domesticTransfers
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | JOD  |
      | random            | JOD     | 4154573              | USD  |
      | random            | JOD     | 4154573              | GBP  |
      | random            | JOD     | 4154573              | EUR  |

      | random            | USD     | 4816263              | JOD  |
      | random            | USD     | 4816263              | USD  |
      | random            | USD     | 4816263              | GBP  |
      | random            | USD     | 4816263              | EUR  |

      | random            | EUR     | 4816264              | JOD  |
      | random            | EUR     | 4816264              | USD  |
      | random            | EUR     | 4816264              | GBP  |
      | random            | EUR     | 4816264              | EUR  |
      | random            | EUR     | 4816264              | AED  |

      | random            | GBP     | 4816265              | JOD  |
      | random            | GBP     | 4816265              | USD  |
      | random            | GBP     | 4816265              | GBP  |
      | random            | GBP     | 4816265              | EUR  |

      | random            | AED     | 4816266              | JOD  |
      | random            | AED     | 4816266              | USD  |
      | random            | AED     | 4816266              | GBP  |
      | random            | AED     | 4816266              | EUR  |

  @capitalMobile @accountTransfers @newBeneficiaryTransfers @domesticTransfers
  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Fees on Sender option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "JO54ARAB1110000000111006906102"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I set the recipient name "TEST TEST TEST" and recipient address "TEST"
    And I swipe to see end of the page
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I verify the mobile 6 digit pin for the transaction
    And I should see the success message "Transfer successful!" for credit card transfers

    When I swipe to see Back to Dashboard
    And I click back to dashboard option
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | CHF  |
      | random            | JOD     | 4154573              | CAD  |
      | random            | JOD     | 4154573              | SAR  |
      | random            | JOD     | 4154573              | AED  |
      | random            | JOD     | 4154573              | AUD  |
      | random            | JOD     | 4154573              | BHD  |
      | random            | JOD     | 4154573              | KWD  |
      | random            | JOD     | 4154573              | QAR  |
      | random            | JOD     | 4154573              | OMR  |

      | random            | USD     | 4816263              | CHF  |
      | random            | USD     | 4816263              | CAD  |
      | random            | USD     | 4816263              | SAR  |
      | random            | USD     | 4816263              | AED  |
      | random            | USD     | 4154573              | AUD  |
      | random            | USD     | 4816263              | BHD  |
      | random            | USD     | 4816263              | KWD  |
      | random            | USD     | 4816263              | QAR  |
      | random            | USD     | 4816263              | OMR  |

      | random            | EUR     | 4816264              | CHF  |
      | random            | EUR     | 4816264              | CAD  |
      | random            | EUR     | 4816264              | SAR  |
      | random            | EUR     | 4816264              | AUD  |
      | random            | EUR     | 4816264              | BHD  |
      | random            | EUR     | 4816264              | KWD  |
      | random            | EUR     | 4816264              | QAR  |
      | random            | EUR     | 4816264              | OMR  |

      | random            | GBP     | 4816265              | CHF  |
      | random            | GBP     | 4816265              | CAD  |
      | random            | GBP     | 4816265              | SAR  |
      | random            | GBP     | 4816265              | AED  |
      | random            | GBP     | 4816265              | AUD  |
      | random            | GBP     | 4816265              | BHD  |
      | random            | GBP     | 4816265              | KWD  |
      | random            | GBP     | 4816265              | QAR  |
      | random            | GBP     | 4816265              | OMR  |

      | random            | AED     | 4816266              | CHF  |
      | random            | AED     | 4816266              | CAD  |
      | random            | AED     | 4816266              | SAR  |
      | random            | AED     | 4816266              | AED  |
      | random            | AED     | 4816266              | AUD  |
      | random            | AED     | 4816266              | BHD  |
      | random            | AED     | 4816266              | KWD  |
      | random            | AED     | 4816266              | QAR  |
      | random            | AED     | 4816266              | OMR  |


  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    @p1
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | JOD  |

    @capitalMobile @accountTransfers @newBeneficiaryTransfers @domesticTransfers
    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | JOD  |
      | random            | JOD     | 4154573              | USD  |
      | random            | JOD     | 4154573              | GBP  |
      | random            | JOD     | 4154573              | EUR  |

      | random            | USD     | 4816263              | JOD  |
      | random            | USD     | 4816263              | USD  |
      | random            | USD     | 4816263              | GBP  |
      | random            | USD     | 4816263              | EUR  |

      | random            | EUR     | 4816264              | JOD  |
      | random            | EUR     | 4816264              | USD  |
      | random            | EUR     | 4816264              | GBP  |
      | random            | EUR     | 4816264              | EUR  |

      | random            | GBP     | 4816265              | JOD  |
      | random            | GBP     | 4816265              | USD  |
      | random            | GBP     | 4816265              | GBP  |
      | random            | GBP     | 4816265              | EUR  |

      | random            | AED     | 4816266              | JOD  |
      | random            | AED     | 4816266              | USD  |
      | random            | AED     | 4816266              | GBP  |
      | random            | AED     | 4816266              | EUR  |


  Scenario Outline: New Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | CHF  |
      | random            | JOD     | 4154573              | CAD  |
      | random            | JOD     | 4154573              | SAR  |
      | random            | JOD     | 4154573              | AED  |
      | random            | JOD     | 4154573              | AUD  |
      | random            | JOD     | 4154573              | BHD  |
      | random            | JOD     | 4154573              | KWD  |
      | random            | JOD     | 4154573              | QAR  |
      | random            | JOD     | 4154573              | OMR  |

      | random            | USD     | 4816263              | CHF  |
      | random            | USD     | 4816263              | CAD  |
      | random            | USD     | 4816263              | SAR  |
      | random            | USD     | 4816263              | AED  |
      | random            | USD     | 4154573              | AUD  |
      | random            | USD     | 4816263              | BHD  |
      | random            | USD     | 4816263              | KWD  |
      | random            | USD     | 4816263              | QAR  |
      | random            | USD     | 4816263              | OMR  |

      | random            | EUR     | 4816264              | CHF  |
      | random            | EUR     | 4816264              | CAD  |
      | random            | EUR     | 4816264              | SAR  |
      | random            | EUR     | 4816264              | AED  |
      | random            | EUR     | 4816264              | AUD  |
      | random            | EUR     | 4816264              | BHD  |
      | random            | EUR     | 4816264              | KWD  |
      | random            | EUR     | 4816264              | QAR  |
      | random            | EUR     | 4816264              | OMR  |

      | random            | GBP     | 4816265              | CHF  |
      | random            | GBP     | 4816265              | CAD  |
      | random            | GBP     | 4816265              | SAR  |
      | random            | GBP     | 4816265              | AED  |
      | random            | GBP     | 4816265              | AUD  |
      | random            | GBP     | 4816265              | BHD  |
      | random            | GBP     | 4816265              | KWD  |
      | random            | GBP     | 4816265              | QAR  |
      | random            | GBP     | 4816265              | OMR  |

      | random            | AED     | 4816266              | CHF  |
      | random            | AED     | 4816266              | CAD  |
      | random            | AED     | 4816266              | SAR  |
      | random            | AED     | 4816266              | AED  |
      | random            | AED     | 4816266              | AUD  |
      | random            | AED     | 4816266              | BHD  |
      | random            | AED     | 4816266              | KWD  |
      | random            | AED     | 4816266              | QAR  |
      | random            | AED     | 4816266              | OMR  |
