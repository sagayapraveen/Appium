@runPlan01
Feature: Invalid login and register

  @capitalMobile @login
  Scenario: Invalid username and password - MOB-AND-LOGIN-130 MOB-AND-LOGIN-129 MOB-AND-LOGIN-128 MOB-AND-LOGIN-127 MOB-AND-LOGIN-126 MOB-AND-LOGIN-123 MOB-AND-LOGIN-122 MOB-AND-LOGIN-121 MOB-AND-LOGIN-120
    Given I have launched the CBJ app
    When I have logged in the CBJ app with username as "izzidin" and password as "Test@123"
    Then I should see the error pop-up "Error The entered username/password is incorrect. You can reset your password from the login screen or call 06-5100220 for further assistance."

    When I have logged in the CBJ app with username as "izzidi" and password as "Test@123"
    Then I should see the error pop-up "Error Invalid login attempt. Please make sure to register first by clicking on ‘Register’ and entering your debit card number and password. For any inquiry, please call 06-5100220."

  @capitalMobile @login
  Scenario: Register and forget username and password - MOB-AND-LOGIN-141 MOB-AND-LOGIN-140 MOB-AND-LOGIN-139 MOB-AND-LOGIN-138 MOB-AND-LOGIN-137 MOB-AND-LOGIN-136 MOB-AND-LOGIN-135 MOB-AND-LOGIN-134 MOB-AND-LOGIN-133 MOB-AND-LOGIN-132 MOB-AND-LOGIN-131
    Given I have launched the CBJ app
    When I click the Register from capitalMobile app launcher
    Then I should see the Verify your card page for Register
    When I click the forget username password link
    Then I should see the Forget Username password page

    @test
    Scenario: Test login
      Given I have launched the CBJ app
      And I navigate to dashboard page
      When I have logged in the CBJ app with username as "2005746"
