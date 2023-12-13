@runPlan04
Feature: Overseas Account Transfers to existing beneficiary with flag change

  Background: Navigating to Transfers menu
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "2009474"
    And I navigate to dashboard page
    And I click the transfers menu

  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @overseasTransfers
  Scenario Outline: Existing Beneficiary Transfer to Overseas from <payFrom> account with flag <flag> and Fees on Sender option - MOB-AND-TRF-153 MOB-AND-TRF-154 MOB-AND-TRF-155 MOB-AND-TRF-156 MOB-AND-TRF-157 MOB-AND-TRF-158 MOB-AND-TRF-159 MOB-AND-TRF-160 MOB-AND-TRF-161 MOB-AND-TRF-162 MOB-AND-TRF-163 MOB-AND-TRF-164 MOB-AND-TRF-165 MOB-AND-TRF-166 MOB-AND-TRF-167 MOB-AND-TRF-168 MOB-AND-TRF-169 MOB-AND-TRF-170 MOB-AND-TRF-171 MOB-AND-TRF-172 MOB-AND-TRF-173 MOB-AND-TRF-174 MOB-AND-TRF-175 MOB-AND-TRF-176 MOB-AND-TRF-177 MOB-AND-TRF-178 MOB-AND-TRF-179 MOB-AND-TRF-180 MOB-AND-TRF-181 MOB-AND-TRF-182 MOB-AND-TRF-183 MOB-AND-TRF-184 MOB-AND-TRF-185 MOB-AND-TRF-186 MOB-AND-TRF-187 MOB-AND-TRF-188 MOB-AND-TRF-189 MOB-AND-TRF-190 MOB-AND-TRF-191 MOB-AND-TRF-192 MOB-AND-TRF-193 MOB-AND-TRF-194 MOB-AND-TRF-195 MOB-AND-TRF-196 MOB-AND-TRF-197 MOB-AND-TRF-198 MOB-AND-TRF-199 MOB-AND-TRF-200 MOB-AND-TRF-201 MOB-AND-TRF-202 MOB-AND-TRF-203 MOB-AND-TRF-204 MOB-AND-TRF-205 MOB-AND-TRF-206 MOB-AND-TRF-207 MOB-AND-TRF-208 MOB-AND-TRF-209 MOB-AND-TRF-210 MOB-AND-TRF-211 MOB-AND-TRF-212 MOB-AND-TRF-213 MOB-AND-TRF-214 MOB-AND-TRF-215 MOB-AND-TRF-216 MOB-AND-TRF-217 MOB-AND-TRF-218 MOB-AND-TRF-219 MOB-AND-TRF-220 MOB-AND-TRF-221 MOB-AND-TRF-222 MOB-AND-TRF-223 MOB-AND-TRF-224 MOB-AND-TRF-225 MOB-AND-TRF-226 MOB-AND-TRF-227 MOB-AND-TRF-228 MOB-AND-TRF-229 MOB-AND-TRF-230 MOB-AND-TRF-231 MOB-AND-TRF-232
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION OVERSEAS" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
    And I set "<flag>" currency
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


  @capitalMobile @accountTransfers @existingBeneficiaryTransfers @overseasTransfers
  Scenario Outline: Existing Beneficiary Transfer to Overseas from <payFrom> account with flag <flag> and Shared Fees option
    When I select payFrom account with "<payFrom>" account number "<payFromAccountNumber>"
    And I select "AUTOMATION OVERSEAS" from the existing beneficiary in Own Transfers
    And I enter the transfer amount "<transactionAmount>" in "Transfer to Overseas" for Beneficiary
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
