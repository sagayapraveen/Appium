@runPlan01
Feature: CliQ Transfer on CapitalMobile app

  Background: Navigation to dashboard page
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "izzidin"
    And I navigate to dashboard page

  @capitalMobile @cliQ @cliQTransfers
  Scenario: Verify if the IBAN is wrong, Error message should be raised - MOB-IOS-CLQ-003, MOB-IOS-CLQ-007, MOB-IOS-CLQ-068
    When I click on CliQ in dashboard
    Then I should see saved biller "aya37"

    When I click on "CLIQ Transfer" to navigate to pay to page
    Then I should see "CLIQ ID" page

    When I click on Beneficiary Type "IBAN"
    And I enter the beneficiary "AAJO48JKBA2500003750880013002000332"
    And I click on confirm button
    Then I should see the error pop-up "Error Invalid IBAN"

  @capitalMobile @cliQ @cliQTransfers
  Scenario: Verify filling the recipient address keeps empty error message raised - MOB-IOS-CLQ-008, MOB-IOS-CLQ-009, MOB-IOS-CLQ-010, MOB-IOS-CLQ-022, MOB-IOS-CLQ-023, MOB-IOS-CLQ-069, MOB-IOS-CLQ-070, MOB-IOS-CLQ-071
    When I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "IBAN"
    And I enter the beneficiary "JO48JKBA2500003750880013002000"
    And I click on confirm button
    And I enter the amount in "160" in "CLIQ Transfer"
    Then I retrieving "JO48JKBA2500003750880013002000" the CliQ transfer details

    When I enter recipient name as "TEST"
    Then I should see the error as "Please enter at least 3 names"

    When I click close button
    And I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "IBAN"
    And I enter the beneficiary "JO48JKBA2500003750880013002000"
    And I click on confirm button
    And I enter the amount in "160" in "CLIQ Transfer"
    And I enter recipient name as "TEST SAMPLE TRANSFER"
    And I enter the address for CliQ transfer as ""
    And I select the purpose from drop down "Transfer to Friend"
    And I click on next button
    Then I should see the error "Recipient address cannot be empty"

  @capitalMobile @cliQ @cliQTransfers
  Scenario Outline: Verify filling the recipient name, address, account details, card details <IBAN> -MOB-IOS-CLQ-006, MOB-IOS-CLQ-011, MOB-IOS-CLQ-012, MOB-IOS-CLQ-013, MOB-IOS-CLQ-014, MOB-IOS-CLQ-025, MOB-IOS-CLQ-026, MOB-IOS-CLQ-027, MOB-IOS-CLQ-031, MOB-IOS-CLQ-072, MOB-IOS-CLQ-073,MOB-IOS-CLQ-074, MOB-IOS-CLQ-075, MOB-IOS-CLQ-076, MOB-IOS-CLQ-077, MOB-IOS-CLQ-080, MOB-IOS-CLQ-081
    When I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "IBAN"
    And I enter the beneficiary "<IBAN>"
    And I click on confirm button
    And I enter the amount in "160" in "CLIQ Transfer"
    And I enter recipient name as "TEST SAMPLE TRANSFER"
    And I enter the address for CliQ transfer as "Jordan"
    And I select the purpose from drop down "Transfer to Friend"
    And I enter the description as "Testing"
    And I click on next button
    Then I should see the "<IBAN>" in confirm transfer page

    When I click on confirm button in CliQ
    And I verify the mobile 6 digit pin for the transaction
    Then I should see confirm "<IBAN>" message

    When I click on Add as Beneficiary
    And I click confirm button in add beneficiary
    Then I should see the error pop-up "<error>"

    When I click on the back to dashboard in successful bill page
    And I fetch the card details from the dashboard
    Then I should see the transaction "DB Outward IPS ON-US" with amount "-80.000 JOD" in the transaction history

    Examples:
      | IBAN                           | error                                        |
      | JO48JKBA2500003750880013002000 | Error Please fill in all the required fields |

  @capitalMobile @cliQ @cliQTransfers
  Scenario: Verify that, after clicking on the confirm button success  message raised for saving the beneficiary -MOB-IOS-CLQ-015, MOB-IOS-CLQ-018, MOB-IOS-CLQ-024, MOB-IOS-CLQ-030, MOB-IOS-CLQ-067
    When I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "IBAN"
    And I enter the beneficiary "JO20EFBK0140000000000004100874"
    And I click on confirm button
    And I enter the amount in "160" in "CLIQ Transfer"
    And I enter recipient name as "TEST SAMPLE TRANSFER"
    And I enter the address for CliQ transfer as "Jordan"
    And I select the purpose from drop down "Transfer to Friend"
    And I enter the description as "Testing"
    And I click on next button
    And I click on confirm button in CliQ
    And I verify the mobile 6 digit pin for the transaction
    Then I should see confirm page "Transfer successful!" message

    When I click on Add as Beneficiary
    And I click confirm button in add beneficiary
    Then I should see the error pop-up "Error Please fill in all the required fields"

  @capitalMobile @cliQ @cliQTransfers
  Scenario Outline: If the Alias is wrong or not defined before error message should be raised <alias/mobileNumber> -MOB-IOS-CLQ-096
    When I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "CLIQ ID"
    And I enter the Mobile Number or Alias as "<alias/mobileNumber>"
    And I click on confirm button
    Then I should see the error pop-up "Error Account not found for this customer."

    Examples:
      | alias/mobileNumber |
      | GPR1796            |
      | 009627964          |

  @capitalMobile @cliQ @cliQTransfers
  Scenario Outline: Validate the success message details in <alias/mobileNumber> -MOB-IOS-CLQ-001, MOB-IOS-CLQ-002, MOB-IOS-CLQ-004, MOB-IOS-CLQ-005, MOB-IOS-CLQ-020, MOB-IOS-CLQ-034, MOB-IOS-CLQ-035, MOB-IOS-CLQ-036, MOB-IOS-CLQ-037, MOB-IOS-CLQ-038, MOB-IOS-CLQ-039, MOB-IOS-CLQ-040, MOB-IOS-CLQ-042, MOB-IOS-CLQ-062, MOB-IOS-CLQ-063, MOB-IOS-CLQ-065, MOB-IOS-CLQ-066, MOB-IOS-CLQ-082, MOB-IOS-CLQ-097,MOB-IOS-CLQ-098,MOB-IOS-CLQ-099, MOB-IOS-CLQ-100, MOB-IOS-CLQ-101, MOB-IOS-CLQ-102, MOB-IOS-CLQ-105, MOB-IOS-CLQ-106
    When I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "CLIQ ID"
    And I enter the Mobile Number or Alias as "<alias/mobileNumber>"
    And I click on confirm button
    And I enter the amount in "80" in "CLIQ Transfer"
    Then I should see currency not allowed to amand

    Then I fetch transfers details form the transfer page "<data>"
    And I select purpose from drop down "to Friend or Family at a bank"
    And I enter the description as "Testing"
    And I click on next button
    And I click on confirm button in CliQ
    And I verify the mobile 6 digit pin for the transaction
    Then I should see confirm "Transfer successful!" message

    When I click on Add as Beneficiary
    And I click confirm button in add beneficiary
    Then I should see the error pop-up "<error>"

    Examples:
      | alias/mobileNumber | error                                        | data  |
      | MAR321             | Error Please fill in all the required fields | AMIR  |
      | 00962796401604     | Error This beneficiary already exists        | NASER |

  Scenario Outline:Validate the success message details in <beneficiary> -MOB-IOS-CLQ-019, MOB-IOS-CLQ-044, MOB-IOS-CLQ-045, MOB-IOS-CLQ-046, MOB-IOS-CLQ-047, MOB-IOS-CLQ-048, MOB-IOS-CLQ-049, MOB-IOS-CLQ-050, MOB-IOS-CLQ-051, MOB-IOS-CLQ-052, MOB-IOS-CLQ-053, MOB-IOS-CLQ-054, MOB-IOS-CLQ-055, MOB-IOS-CLQ-056, MOB-IOS-CLQ-057, MOB-IOS-CLQ-058, MOB-IOS-CLQ-059, MOB-IOS-CLQ-060, MOB-IOS-CLQ-061, MOB-IOS-CLQ-064, MOB-IOS-CLQ-107, MOB-IOS-CLQ-108, MOB-IOS-CLQ-109, MOB-IOS-CLQ-110, MOB-IOS-CLQ-111, MOB-IOS-CLQ-112, MOB-IOS-CLQ-113, MOB-IOS-CLQ-114, MOB-IOS-CLQ-115, MOB-IOS-CLQ-116, MOB-IOS-CLQ-117, MOB-IOS-CLQ-118, MOB-IOS-CLQ-119, MOB-IOS-CLQ-120, MOB-IOS-CLQ-121, MOB-IOS-CLQ-122, MOB-IOS-CLQ-123, MOB-IOS-CLQ-124
    When I click on CliQ in dashboard
    And I search for saved beneficiary to select "<beneficiary>"
    And I enter the amount "80" in "Transfers" page
    Then I fetch transfers details form the transfer page "<data>"

    When I select purpose from drop down "<purpose>"
    And I enter the description as "Testing"
    And I click on next button
    Then I should see the page "<data>"

    When I click on confirm button in CliQ
    Then I should see confirm "Transfer successful!" message

    When I click on the back to dashboard in successful bill page
    And I fetch the card details from the dashboard
    Then I should see the transaction "DB Outward IPS ON-US" with amount "-80.000 JOD" in the transaction history

    @capitalMobile @cliQ @cliQTransfers
    Examples:
      | beneficiary | purpose                                                | data                           |
      | TEST MOBILE | to Friend or Family at a bank                          | 00962796401604                 |
      | SAMPLE      | to Friend or Family at a bank                          | MAR                            |
      | 01          | Transfer to Friend or Family via online/mobile banking | JO73UBSI1010000010106416715101 |

    @sanity
    Examples:
      | beneficiary | purpose                       | data           |
      | TEST MOBILE | to Friend or Family at a bank | 00962796401604 |

  @p1
  @capitalMobile @cliQ @cliQTransfers
  Scenario Outline: Validate the success message details in <data> -MOB-IOS-CLQ-043, MOB-IOS-CLQ-084, MOB-IOS-CLQ-085, MOB-IOS-CLQ-086, MOB-IOS-CLQ-087, MOB-IOS-CLQ-088, MOB-IOS-CLQ-089, MOB-IOS-CLQ-090, MOB-IOS-CLQ-093, MOB-IOS-CLQ-094, MOB-IOS-CLQ-095, MOB-IOS-CLQ-131
    When I click on CliQ in dashboard
    And I search for saved beneficiary to select "TEST MOBILE"
    And I enter the amount "9000000" in "Transfers" page
    Then I fetch transfers details form the transfer page "<data>"

    When I select purpose from drop down "to Friend or Family at a bank"
    And I click on next button
    Then I should see the error pop-up "Error Amount is more than limit"

    When I click close button
    And I click on CliQ in dashboard
    And I click on "CLIQ Transfer" to navigate to pay to page
    And I click on Beneficiary Type "CLIQ ID"
    And I enter the Mobile Number or Alias as "00962796401604"
    And I click on confirm button
    And I enter the amount in "80" in "CLIQ Transfer"
    Then I fetch transfers details form the transfer page "<alias>"

    When I select purpose from drop down "to Friend or Family at a bank"
    And I enter the description as "Testing"
    And I click on next button
    And I click on confirm button in CliQ
    And I verify the mobile 6 digit pin for the transaction
    Then I should see confirm "Transfer successful!" message

    When I click on the back to dashboard in successful bill page
    And I fetch the card details from the dashboard
    Then I should see the transaction "DB Outward IPS ON-US" with amount "-80.000 JOD" in the transaction history

    Examples:
      | data           | alias |
      | 00962796401604 | NASER |