@runPlan01
Feature: Manage cheques in Dashboard

  Background: Navigation to request money Page
    Given I have logged in the CBJ app
    And I navigate to dashboard page
    When I navigate to manage cheques menu

  @capitalMobile @dashboard @manageCheques
  Scenario Outline: Customer requesting for cheques with check book <chequeBook> and leaves <chequeLeaves> for language <language> - MOB-AND-DAB-025, MOB-AND-DAB-026, MOB-AND-DAB-027, MOB-AND-DAB-028, MOB-AND-DAB-029, MOB-AND-DAB-030, MOB-AND-DAB-046
    Then I should see the "Request" and "Post Dated" tab

    When I select the cheque book as "<chequeBook>"
    And I select the cheque leaves as "<chequeLeaves>"
    And I select the Language as "<language>"
    Then I confirm the entered cheque details
    And I should see the error pop-up "Error Your cheque book request cannot be processed."

    Examples:
      | chequeBook | chequeLeaves | language |
      | 1          | 10           | English  |
      | 1          | 25           | Arabic   |
      | 1          | 40           | English  |
      | 2          | 10           | English  |
      | 2          | 25           | English  |
      | 2          | 40           | Arabic   |
      | 3          | 10           | English  |
      | 3          | 25           | Arabic   |
      | 3          | 40           | English  |
      | 4          | 25           | Arabic   |
      | 4          | 40           | Arabic   |
      | 4          | 10           | English  |
      | 5          | 25           | Arabic   |
      | 5          | 40           | Arabic   |
      | 5          | 10           | English  |