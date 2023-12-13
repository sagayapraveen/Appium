# qa-mobile-automation
### Android and IOS Test automation framework for capitalMobile and blink mobile application`
 
## Initial Setup
1) Make a project with the default maven structure.

2) Update your device configuration (only If you want to run a project in IDE) to the `config.properties` file
   in the src/main/resources/config directory.
    - `deviceName` and `udid` are mandatory

3) make note of the following command line instructions to run as mvn test:

    1) To run code, you will need to use the `mvn clean verify` command.
    2) The minimum java parameters to pass in are the following:
        - `"-Dcucumber.options=--tags @mycustomtag"`
          ("s are required due ot the whitespace in the value)
        - If you want run multiple tag in a single execution thread,
          `"-Dcucumber.options=--tags @mycustomtag1,@mycustomtag2"` (corresponds to the tag names in the
          `main/resources/features` directory)
        - If you are in an IDE and want to debug your code:
          `-DforkCount=0` (this stops maven from using multiple threads,
          which otherwise interferes with the debugger)
    3) To parameterize the device details, have to attach device details in mvn command
       - to set your platform name,
         - `"-DplatformName=Android"`
       - to set your deviceName and udid/ipaddress
         - `""-DdeviceName=OnePlus Nord" -Dudid=123a4bc5"`
    4) your entire mvn command should have all the parameters to perform the test like below,
       - `mvn clean verify -Dcucumber.filter.tags=@login "-DdeviceName=OnePlus Nord" -Dudid=192.168.0.0:5555 -DplatformName=Android`

4) If you are using an IDE, create a run profile with these above parameters.


### List of tags
    capitalMobile app - @capitalMobile, @capitalInvestment, @cliQ, @creditCard, @dashboard, @transfers, @beneficiary @myTransfers, @overdraft, @payBillCapitalMobile, @termDeposits, @userProfile, @virtualPrepaidCard, @loyalty
    blink app - @blink, @blinkRegistration, @manageCliQ, @outwardCliQ, @payBillBlink, @requestMoneyBlink, @sendMoney


### Core dependencies and Plugins
    - appium-java-client - 8.2.1
    - cucumber-java - 7.0.0
    - selenium-remote-driver - 4.6.0
    - cucumber-testng - 7.11.1
    - maven-compiler-plugin - 3.8.1
    - maven-surefire-plugin - 2.22.1
    - maven-cucumber-reporting - 4.9.0


### Contacts
Developer/Architect - Vishnuprasath Badrinarayanan [mailto:vishnuprasath.badrinarayanan@expleogroup.com](mailto:vishnuprasath.badrinarayanan@expleogroup.com)  
Developer - SagayaPraveen Varghese [mailto:sagayapraveen.varghese@expleogroup.com](mailto:sagayapraveen.varghese@expleogroup.com)  
