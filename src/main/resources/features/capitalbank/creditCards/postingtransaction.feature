@runPlan04
Feature: CreditCard Account posting transaction

  @capitalMobile @creditCard @accountPostingTransaction
  Scenario Outline: Credit card transfers with Account posting transaction - MOB-AND-CRD-483 MOB-AND-CRD-484 MOB-AND-CRD-485 MOB-AND-CRD-486 MOB-AND-CRD-487 MOB-AND-CRD-488 MOB-AND-CRD-489 MOB-AND-CRD-490 MOB-AND-CRD-491 MOB-AND-CRD-492 MOB-AND-CRD-493 MOB-AND-CRD-494 MOB-AND-CRD-495 MOB-AND-CRD-496 MOB-AND-CRD-497 MOB-AND-CRD-498 MOB-AND-CRD-499 MOB-AND-CRD-500 MOB-AND-CRD-501 MOB-AND-CRD-502 MOB-AND-CRD-503 MOB-AND-CRD-504 MOB-AND-CRD-505 MOB-AND-CRD-506 MOB-AND-CRD-507 MOB-AND-CRD-508 MOB-AND-CRD-509 MOB-AND-CRD-510 MOB-AND-CRD-511 MOB-AND-CRD-512 MOB-AND-CRD-513 MOB-AND-CRD-514 MOB-AND-CRD-515 MOB-AND-CRD-516 MOB-AND-CRD-517 MOB-AND-CRD-518 MOB-AND-CRD-519 MOB-AND-CRD-520 MOB-AND-CRD-521 MOB-AND-CRD-522 MOB-AND-CRD-523 MOB-AND-CRD-524 MOB-AND-CRD-525 MOB-AND-CRD-526 MOB-AND-CRD-527 MOB-AND-CRD-528 MOB-AND-CRD-529 MOB-AND-CRD-530 MOB-AND-CRD-531 MOB-AND-CRD-532 MOB-AND-CRD-533 MOB-AND-CRD-534 MOB-AND-CRD-535 MOB-AND-CRD-536 MOB-AND-CRD-537 MOB-AND-CRD-538
    Given I have launched the CBJ app
    And I have logged in the CBJ app with username as "<user>"
    And I navigate to dashboard page
    And I click on cards in dashboard
    And I navigate to JOD card in Cards tab
    And I click the transfers menu
    And I click the cards in transfers page
    And I select the Own account from the transfers page
    And I select the current account for transfers Pay to

    When I input the amount "10" for the Transfers to Own account
    And I fetch the Pay to card details
    And I confirm the transfer from credit card
    Then I should see the error pop-up "Error Your transaction will not be processed from this account. For more information please reach to our Contact Center on 06-5100220"

    Examples:
      | user    |
#  Posting restriction 43 for CreditCard
      | 2008075 |
#  Posting restriction 42 for CreditCard
      | 2033070 |
#  Posting restriction 31 for CreditCard
      | 2009491 |

