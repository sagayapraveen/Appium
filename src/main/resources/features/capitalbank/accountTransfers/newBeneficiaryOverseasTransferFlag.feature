@runPlan02
Feature: Overseas Account Transfers to new beneficiary wih flag change

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile @accountTransfers @newBeneficiaryTransfers @overseasTransfers
  Scenario Outline: New Beneficiary Transfer to Overseas from <payFrom> account with flag <flag> and Fees on Sender option - MOB-AND-TRF-035 MOB-AND-TRF-036 MOB-AND-TRF-040 MOB-AND-TRF-041 MOB-AND-TRF-045 MOB-AND-TRF-046 MOB-AND-TRF-050 MOB-AND-TRF-051 MOB-AND-TRF-055 MOB-AND-TRF-056 MOB-AND-TRF-060 MOB-AND-TRF-061 MOB-AND-TRF-065 MOB-AND-TRF-066 MOB-AND-TRF-070 MOB-AND-TRF-071 MOB-AND-TRF-075 MOB-AND-TRF-076 MOB-AND-TRF-080 MOB-AND-TRF-081 MOB-AND-TRF-085 MOB-AND-TRF-086 MOB-AND-TRF-090 MOB-AND-TRF-091 MOB-AND-TRF-095 MOB-AND-TRF-096 MOB-AND-TRF-100 MOB-AND-TRF-101 MOB-AND-TRF-105 MOB-AND-TRF-106 MOB-AND-TRF-110 MOB-AND-TRF-111 MOB-AND-TRF-115 MOB-AND-TRF-116 MOB-AND-TRF-120 MOB-AND-TRF-121 MOB-AND-TRF-125 MOB-AND-TRF-126 MOB-AND-TRF-130 MOB-AND-TRF-131 MOB-AND-TRF-135 MOB-AND-TRF-136 MOB-AND-TRF-140 MOB-AND-TRF-141 MOB-AND-TRF-145 MOB-AND-TRF-146 MOB-AND-TRF-150 MOB-AND-TRF-151 MOB-AND-TRF-155 MOB-AND-TRF-156 MOB-AND-TRF-160 MOB-AND-TRF-161 MOB-AND-TRF-165 MOB-AND-TRF-166 MOB-AND-TRF-170 MOB-AND-TRF-171 MOB-AND-TRF-175 MOB-AND-TRF-176 MOB-AND-TRF-180 MOB-AND-TRF-181 MOB-AND-TRF-185 MOB-AND-TRF-186 MOB-AND-TRF-190 MOB-AND-TRF-191 MOB-AND-TRF-195 MOB-AND-TRF-196 MOB-AND-TRF-200 MOB-AND-TRF-201 MOB-AND-TRF-205 MOB-AND-TRF-206 MOB-AND-TRF-209 MOB-AND-TRF-212
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "AE070331234567890123456"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers

    When I swipe to see Back to Dashboard
    And I click back to dashboard option
    And I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | USD  |
      | random            | JOD     | 4154573              | GBP  |
      | random            | JOD     | 4154573              | EUR  |
      | random            | JOD     | 4154573              | CHF  |
      | random            | JOD     | 4154573              | CAD  |
      | random            | JOD     | 4154573              | SAR  |
      | random            | JOD     | 4154573              | AED  |
      | random            | JOD     | 4154573              | AUD  |
      | random            | JOD     | 4154573              | BHD  |
      | random            | JOD     | 4154573              | KWD  |
      | random            | JOD     | 4154573              | QAR  |
      | random            | JOD     | 4154573              | OMR  |

      | random            | USD     | 4816263              | USD  |
      | random            | USD     | 4816263              | GBP  |
      | random            | USD     | 4816263              | EUR  |
      | random            | USD     | 4816263              | CHF  |
      | random            | USD     | 4816263              | CAD  |
      | random            | USD     | 4816263              | SAR  |
      | random            | USD     | 4816263              | AED  |
      | random            | USD     | 4154573              | AUD  |
      | random            | USD     | 4816263              | BHD  |
      | random            | USD     | 4816263              | KWD  |
      | random            | USD     | 4816263              | QAR  |
      | random            | USD     | 4816263              | OMR  |

      | random            | EUR     | 4816264              | USD  |
      | random            | EUR     | 4816264              | GBP  |
      | random            | EUR     | 4816264              | EUR  |
      | random            | EUR     | 4816264              | CHF  |
      | random            | EUR     | 4816264              | CAD  |
      | random            | EUR     | 4816264              | SAR  |
      | random            | EUR     | 4816264              | AED  |
      | random            | EUR     | 4816264              | AUD  |
      | random            | EUR     | 4816264              | BHD  |
      | random            | EUR     | 4816264              | KWD  |
      | random            | EUR     | 4816264              | QAR  |
      | random            | EUR     | 4816264              | OMR  |

      | random            | GBP     | 4816265              | USD  |
      | random            | GBP     | 4816265              | GBP  |
      | random            | GBP     | 4816265              | EUR  |
      | random            | GBP     | 4816265              | CHF  |
      | random            | GBP     | 4816265              | CAD  |
      | random            | GBP     | 4816265              | SAR  |
      | random            | GBP     | 4816265              | AED  |
      | random            | GBP     | 4816265              | AUD  |
      | random            | GBP     | 4816265              | BHD  |
      | random            | GBP     | 4816265              | KWD  |
      | random            | GBP     | 4816265              | QAR  |
      | random            | GBP     | 4816265              | OMR  |

      | random            | AED     | 4816266              | USD  |
      | random            | AED     | 4816266              | GBP  |
      | random            | AED     | 4816266              | EUR  |
      | random            | AED     | 4816266              | CHF  |
      | random            | AED     | 4816266              | CAD  |
      | random            | AED     | 4816266              | SAR  |
      | random            | AED     | 4816266              | AED  |
      | random            | AED     | 4816266              | AUD  |
      | random            | AED     | 4816266              | BHD  |
      | random            | AED     | 4816266              | KWD  |
      | random            | AED     | 4816266              | QAR  |
      | random            | AED     | 4816266              | OMR  |

  @capitalMobile @accountTransfers @newBeneficiaryTransfers @overseasTransfers
  Scenario Outline: New Beneficiary Transfer to Overseas from <payFrom> account with flag <flag> and Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I click on new Beneficiary and enter IBAN number "AE070331234567890123456"
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I set the beneficiary name "TEST TEST TEST" and beneficiary address "TEST"
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I click on Shared Fees radio button for transfers
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    And I verify the mobile 6 digit pin for the transaction
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I swipe to see Back to Dashboard
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

    Examples:
      | transactionAmount | payFrom | payFromAccountNumber | flag |
      | random            | JOD     | 4154573              | USD  |
      | random            | JOD     | 4154573              | GBP  |
      | random            | JOD     | 4154573              | EUR  |
      | random            | JOD     | 4154573              | CHF  |
      | random            | JOD     | 4154573              | CAD  |
      | random            | JOD     | 4154573              | SAR  |
      | random            | JOD     | 4154573              | AED  |
      | random            | JOD     | 4154573              | AUD  |
      | random            | JOD     | 4154573              | BHD  |
      | random            | JOD     | 4154573              | KWD  |
      | random            | JOD     | 4154573              | QAR  |
      | random            | JOD     | 4154573              | OMR  |

      | random            | USD     | 4816263              | USD  |
      | random            | USD     | 4816263              | GBP  |
      | random            | USD     | 4816263              | EUR  |
      | random            | USD     | 4816263              | CHF  |
      | random            | USD     | 4816263              | CAD  |
      | random            | USD     | 4816263              | SAR  |
      | random            | USD     | 4816263              | AED  |
      | random            | USD     | 4154573              | AUD  |
      | random            | USD     | 4816263              | BHD  |
      | random            | USD     | 4816263              | KWD  |
      | random            | USD     | 4816263              | QAR  |
      | random            | USD     | 4816263              | OMR  |

      | random            | EUR     | 4816264              | USD  |
      | random            | EUR     | 4816264              | GBP  |
      | random            | EUR     | 4816264              | EUR  |
      | random            | EUR     | 4816264              | CHF  |
      | random            | EUR     | 4816264              | CAD  |
      | random            | EUR     | 4816264              | SAR  |
      | random            | EUR     | 4816264              | AED  |
      | random            | EUR     | 4816264              | AUD  |
      | random            | EUR     | 4816264              | BHD  |
      | random            | EUR     | 4816264              | KWD  |
      | random            | EUR     | 4816264              | QAR  |
      | random            | EUR     | 4816264              | OMR  |

      | random            | GBP     | 4816265              | USD  |
      | random            | GBP     | 4816265              | GBP  |
      | random            | GBP     | 4816265              | EUR  |
      | random            | GBP     | 4816265              | CHF  |
      | random            | GBP     | 4816265              | CAD  |
      | random            | GBP     | 4816265              | SAR  |
      | random            | GBP     | 4816265              | AED  |
      | random            | GBP     | 4816265              | AUD  |
      | random            | GBP     | 4816265              | BHD  |
      | random            | GBP     | 4816265              | KWD  |
      | random            | GBP     | 4816265              | QAR  |
      | random            | GBP     | 4816265              | OMR  |

      | random            | AED     | 4816266              | USD  |
      | random            | AED     | 4816266              | GBP  |
      | random            | AED     | 4816266              | EUR  |
      | random            | AED     | 4816266              | CHF  |
      | random            | AED     | 4816266              | CAD  |
      | random            | AED     | 4816266              | SAR  |
      | random            | AED     | 4816266              | AED  |
      | random            | AED     | 4816266              | AUD  |
      | random            | AED     | 4816266              | BHD  |
      | random            | AED     | 4816266              | KWD  |
      | random            | AED     | 4816266              | QAR  |
      | random            | AED     | 4816266              | OMR  |
