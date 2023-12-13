@runPlan03
Feature: Domestic Account Transfers to existing beneficiary with flag change

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers @testToday1
  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Fees on Sender option - MOB-AND-TRF-049 MOB-AND-TRF-050 MOB-AND-TRF-051 MOB-AND-TRF-052 MOB-AND-TRF-053 MOB-AND-TRF-054 MOB-AND-TRF-055 MOB-AND-TRF-056 MOB-AND-TRF-057 MOB-AND-TRF-058 MOB-AND-TRF-059 MOB-AND-TRF-060 MOB-AND-TRF-061 MOB-AND-TRF-062 MOB-AND-TRF-063 MOB-AND-TRF-064 MOB-AND-TRF-065 MOB-AND-TRF-066 MOB-AND-TRF-067 MOB-AND-TRF-068 MOB-AND-TRF-069 MOB-AND-TRF-070 MOB-AND-TRF-071 MOB-AND-TRF-072 MOB-AND-TRF-073 MOB-AND-TRF-074 MOB-AND-TRF-075 MOB-AND-TRF-076 MOB-AND-TRF-077 MOB-AND-TRF-078 MOB-AND-TRF-079 MOB-AND-TRF-080 MOB-AND-TRF-081 MOB-AND-TRF-082 MOB-AND-TRF-083 MOB-AND-TRF-084 MOB-AND-TRF-085 MOB-AND-TRF-086 MOB-AND-TRF-087 MOB-AND-TRF-088 MOB-AND-TRF-089 MOB-AND-TRF-090 MOB-AND-TRF-091 MOB-AND-TRF-092 MOB-AND-TRF-093 MOB-AND-TRF-094 MOB-AND-TRF-095 MOB-AND-TRF-096 MOB-AND-TRF-097 MOB-AND-TRF-098 MOB-AND-TRF-099 MOB-AND-TRF-100 MOB-AND-TRF-101 MOB-AND-TRF-102 MOB-AND-TRF-103 MOB-AND-TRF-104 MOB-AND-TRF-105 MOB-AND-TRF-106 MOB-AND-TRF-107 MOB-AND-TRF-108 MOB-AND-TRF-109 MOB-AND-TRF-110 MOB-AND-TRF-111 MOB-AND-TRF-112 MOB-AND-TRF-113 MOB-AND-TRF-114 MOB-AND-TRF-115 MOB-AND-TRF-116 MOB-AND-TRF-117 MOB-AND-TRF-118 MOB-AND-TRF-119 MOB-AND-TRF-120 MOB-AND-TRF-121 MOB-AND-TRF-122 MOB-AND-TRF-123 MOB-AND-TRF-124 MOB-AND-TRF-125 MOB-AND-TRF-126 MOB-AND-TRF-127 MOB-AND-TRF-128
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
    Then I verify the transfer exchange rate from "<payFrom>" for the amount "<transactionAmount>"

    When I click on confirm button
    Then I should see the success message "Transfer successful!" for credit card transfers
    And I click back to dashboard option

    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>" After transaction
    Then I should see the "Outward Transfer" with "debit" amount in the transaction history with today's date in "accounts" tab

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


  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers
  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> and Fees on Sender option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set Flag "<flag>" currency
    And I select the currency type as "<flag>"
    And I swipe to see payment details
    And I enter the transfer purpose as
      | Purpose of Transfer          | Personal        |
      | Detailed Purpose of Transfer | Standing Orders |
    And I enter the description as "testing"
    And I click on next button
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

  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers
  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set "<flag>" currency
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


  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @domesticTransfers
  Scenario Outline: Existing Beneficiary Transfer to Domestic from <payFrom> account with flag <flag> with Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION DOMESTIC" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Domestic" for Beneficiary
    And I set "<flag>" currency
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