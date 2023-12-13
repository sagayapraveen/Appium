package com.qa.steps.blink;

import com.qa.engine.DriverManager;
import com.qa.engine.ProjectBase;
import com.qa.pages.blink.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class BlinkSteps extends ProjectBase {

    @Given("I have launched the blink app")
    public void iHaveLaunchedTheBlinkApp() {
        try {
            if (getDriver() != null) getDriver().quit();
            new DriverManager().initializeDriver(BLINK);
            logInfo("Blink app is launched");
        } catch (Exception e) {
            logInfo("Error while launching the Blink app");
            throw new RuntimeException(e);
        }

        if (getDriver() instanceof AndroidDriver) {
            customData.setViewAttribute("android.view.View");
            customData.setButtonAttribute("android.widget.Button");
            customData.setTextAttribute("android.widget.EditText");
            customData.setImageAttribute("android.widget.ImageView");
            customData.setAttribute("content-desc");
        } else if (getDriver() instanceof IOSDriver) {
            customData.setViewAttribute("XCUIElementTypeOther");
            customData.setButtonAttribute("XCUIElementTypeButton");
            customData.setTextAttribute("XCUIElementTypeTextField");
            customData.setImageAttribute("XCUIElementTypeImage");
            customData.setAttribute("name");
        }
    }

    @Given("I have logged in the blink app")
    public void iHaveLoggedInTheBlinkApp() {
        iHaveLaunchedTheBlinkApp();

        new LoginPage().loginPage().userName(properties.getProperty("blink.username")).password(properties.getProperty("blink.password")).login().loginClick();
    }

    @And("I verify the OTP {string} for the blink app")
    public void iVerifyTheOTPForTheBlinkApp(String otp) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'SWITCH DEVICE')]/" + customData.getViewAttribute() + "/" + customData.getViewAttribute(), 45);
        Point point = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'SWITCH DEVICE')]/" + customData.getViewAttribute() + "/" + customData.getViewAttribute())).getLocation();
        new HomePage().tapOnPosition(point.x + 10, point.y + 10);
        new Actions(getDriver()).sendKeys(otp).perform();

        new HomePage().scroll("Left");
    }

    @And("I verify the OTP {string} for the blink app transaction")
    public void iVerifyTheOTPForTheBlinkAppTransaction(String otp) throws InterruptedException {
        new OtpPage().enterOtp(otp);
    }

    @And("I have navigated to the home page")
    public void iHaveNavigatedToTheHomePage() throws InterruptedException {
        Instant timeout = Instant.now().plusSeconds(120);
        Instant timeout1 = Instant.now().plusSeconds(120);
        Instant timeout2 = Instant.now().plusSeconds(120);
        Thread.sleep(2000);

        By newDeviceDetected = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"New device detected\"]/following-sibling::" + customData.getImageAttribute());
        By enter6DigitCode = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'SWITCH DEVICE')]/" + customData.getViewAttribute() + "/" + customData.getViewAttribute());
        By payYourBills = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Pay your bills with Blink!']");
        By eVoucher = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"e-Vouchers are here!\"]");
        By flight = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Book flight with us\"]");
        By homeMenu = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Total Balance')]/" + customData.getImageAttribute());
        By homePageNeverPostpone = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Never postpone a purchase again')]");
        By congratulations = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Congratulations!']");

        while (getDriver().findElements(newDeviceDetected).size() == 0) {
            if (getDriver().findElements(newDeviceDetected).size() > 0) {
                getDriver().findElement(newDeviceDetected).click();
                if (getDriver().findElements(enter6DigitCode).size() > 0) {
                    getDriver().findElement(enter6DigitCode).click();
                    break;
                }
            }
            // Exit condition 1 --> OTP page
            if (getDriver().findElements(enter6DigitCode).size() > 0) {
                getDriver().findElement(enter6DigitCode).click();
                break;
            }
            /*// Exit condition 2 --> payYourBills pop-up
            if (getDriver().findElements(payYourBills).size() == 1) {
                new HomePage().scroll("Down");
                break;
            }*/
            if (getDriver().findElements(payYourBills).size() == 1) {
                Point point = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]")).getLocation();
                new HomePage().scrollWithCoordinates("down", 0.5, point.x + 20, point.y);
                break;
            }

            // Exit condition 3 --> Blink Home page
            if (getDriver().findElements(homePageNeverPostpone).size() > 0) break;

            // Exit condition 3 --> Blink Home page
            if (getDriver().findElements(homeMenu).size() > 0) break;

            // Exit condition 3 --> Blink Home page
            if (getDriver().findElements(congratulations).size() > 0) break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("App not loaded after waited for 180seconds");
        }

        if (getDriver().findElements(homeMenu).size() > 0 || getDriver().findElements(homePageNeverPostpone).size() > 0)
            logInfo("Home page in app launched");
        else {
            if (getDriver().findElements(newDeviceDetected).size() > 0) {
                getDriver().findElement(newDeviceDetected).click();
                iVerifyTheOTPForTheBlinkApp("576824");
            }

            while (getDriver().findElements(payYourBills).size() == 0) {
                if (getDriver().findElements(payYourBills).size() == 1) {
                    //new HomePage().scroll("Down");
                    Point point = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]")).getLocation();
                    new HomePage().scrollWithCoordinates("down", 0.5, point.x + 20, point.y);
                    break;
                }

                if (getDriver().findElements(congratulations).size() == 1) {
                    new HomePage().scroll("Left");
                    break;
                }

                if (getDriver().findElements(enter6DigitCode).size() > 0) {
                    iVerifyTheOTPForTheBlinkApp("576824");
                    break;
                }

                if (getDriver().findElements(homePageNeverPostpone).size() > 0) break;

                if (getDriver().findElements(homeMenu).size() > 0) break;

                if (Instant.now().isAfter(timeout1))
                    throw new TimeoutException("App not loaded after waited for 180seconds");
            }

            while (getDriver().findElements(congratulations).size() == 0) {
                if (getDriver().findElements(congratulations).size() > 0) {
                    new HomePage().scroll("Left");
                    new HomePage().scroll("Left");
                    break;
                }

                if (getDriver().findElements(eVoucher).size() == 1) {
                    //new HomePage().scroll("Down");
                    Point point = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='e-Vouchers are here!']")).getLocation();
                    new HomePage().scrollWithCoordinates("down", 0.5, point.x + 20, point.y);

                    utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]", 10);
                    Point point1 = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]")).getLocation();
                    new HomePage().scrollWithCoordinates("down", 0.5, point1.x + 20, point1.y);

                    utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Book flight with us!\"]", 10);
                    Point point2 = getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Book flight with us!\"]")).getLocation();
                    new HomePage().scrollWithCoordinates("down", 0.5, point2.x + 20, point2.y + 100);
                    break;
                }

                if (getDriver().findElements(homePageNeverPostpone).size() > 0) break;

                if (getDriver().findElements(homeMenu).size() > 0) break;

                if (Instant.now().isAfter(timeout2))
                    throw new TimeoutException("App not loaded after waited for 180seconds");
            }
        }
    }

    @When("I select the Bill payments from the HomePage")
    public void iSelectTheBillPaymentsFromTheHomePage() throws InterruptedException {
        By homeMenu;
        By homePageNeverPostpone;
        By congratulations;
        By eVoucher;

        if (getDriver() instanceof AndroidDriver) {
            homeMenu = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Total Balance')]/" + customData.getImageAttribute() + "[2]");
            homePageNeverPostpone = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Never postpone a purchase again')]");
            congratulations = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Congratulations!']");
            eVoucher = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"e-Vouchers are here!\"]");
        } else {
            homeMenu = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Total Balance')]//following-sibling::" + customData.getImageAttribute() + "[2]");
            homePageNeverPostpone = By.xpath("//*[contains(@" + customData.getStaticAttribute() + ", 'Never postpone a purchase again')]");
            congratulations = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Congratulations!']");
            eVoucher = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"e-Vouchers are here!\"]");
        }
        Instant timeout2 = Instant.now().plusSeconds(120);

        while (getDriver().findElements(congratulations).size() == 0) {
            if (getDriver().findElements(congratulations).size() > 0) {
                Thread.sleep(1500);
                new HomePage().scroll("Left");
                new HomePage().scroll("Left");
                break;
            }

            if (getDriver().findElements(eVoucher).size() == 1) {
                Point point = getDriver().findElement(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='e-Vouchers are here!']")).getLocation();
                new HomePage().scrollWithCoordinates("down", 0.5, point.x + 20, point.y);

                utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]", 10);
                Point point1 = getDriver().findElement(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"Pay your bills with Blink!\"]")).getLocation();
                new HomePage().scrollWithCoordinates("down", 0.5, point1.x + 20, point1.y);

                utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"Book flight with us!\"]", 10);
                Point point2 = getDriver().findElement(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"Book flight with us!\"]")).getLocation();
                new HomePage().scrollWithCoordinates("down", 0.5, point2.x + 20, point2.y + 100);
                break;
            }

            if (getDriver().findElements(homePageNeverPostpone).size() > 0) break;

            if (getDriver().findElements(homeMenu).size() > 0) break;

            if (Instant.now().isAfter(timeout2))
                throw new TimeoutException("App not loaded after waited for 90seconds");
        }
        new HomePage().clickHomeMenu()
                .clickBillPayments();
    }

    @And("I send money {string} to the payee {string}")
    public void iSendMoneyToThePayee(String amount, String payee) throws InterruptedException {
        new SendMoneyPage().sendMoneyTo(payee).enterMoney(amount).proceedPayment();
    }

    @When("I navigate to my account page in blink")
    public void iNavigateToMyAccountPage() {
        By congratulations = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Congratulations!']");
        By homeMenu = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Total Balance')]/" + customData.getImageAttribute() + "[2]");
        By homePageNeverPostpone = By.xpath("//*[contains(@" + customData.getAttribute() + ", 'Never postpone a purchase again')]");
        Instant timeout2 = Instant.now().plusSeconds(120);

        while (getDriver().findElements(congratulations).size() == 0) {
            if (getDriver().findElements(congratulations).size() > 0) {
                new HomePage().scroll("Left");
                new HomePage().scroll("Left");
                break;
            }

            if (getDriver().findElements(homePageNeverPostpone).size() > 0) break;

            if (getDriver().findElements(homeMenu).size() > 0) break;

            if (Instant.now().isAfter(timeout2))
                throw new TimeoutException("App not loaded after waited for 180seconds");
        }
        new HomePage().scroll("right");
        new HomePage().scroll("right");
    }

    @And("I navigate to transaction history page")
    public void iNavigateToTransactionHistoryPage() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Add money']", 90);
        new HomePage().scroll("up");
        logInfo("Navigated to Transaction history screen");
    }

    @Then("I should see the transaction history of the account for the date {string}")
    public void iShouldSeeTheTransactionHistoryOfTheAccountForTheDate(String date) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Transaction History']", 90);

        Set<String> transactionEntries = new TransactionHistoryPage().getTransactionWithDate(date);

        for (String transactionEntry : transactionEntries) {
            logInfo(transactionEntry.replaceAll("\n", " "));
        }
    }

    @When("I open the Request new debit card menu")
    public void iOpenTheRequestNewDebitCardMenu() throws InterruptedException {
        new HomePage().scroll("left");
        new HomePage().scroll("left");
        new HomePage().scroll("left");

        new HomePage().requestNewDebitCard();
    }

    @And("I set the pin for the debit card and confirm")
    public void iSetThePinForTheDebitCardAndConfirm() {
        LetsSetYourPin pin = new LetsSetYourPin().setYourPin("1234");

        new HomePage().scroll("left");

        pin.setYourPin("1234");

        new HomePage().scroll("left");
    }

    @Then("I should see the {string} message for Debit card issuance")
    public void iShouldSeeTheMessageForDebitCardIssuance(String message) {
        new LetsSetYourPin().getSuccessMessage();

        new HomePage().scroll("Left");

        utils.waitForElement(getDriver(), "//*[contains(@" + customData.getAttribute() + ", 'Total Balance')]/" + customData.getImageAttribute() + "[2]", 60);
    }

    @When("I select the Manage CliQ from the home page")
    public void iSelectTheManageCliQFromTheHomePage() {
        new HomePage().clickHomeMenu().clickManageCliQ();
    }

    @And("I click the Create new CliQ ID")
    public void iClickTheCreateNewCliQID() {
        new ManageCliQPage().createCliQ();
    }

    @And("I fill the below details for create new CliQ")
    public void iFillTheBelowDetailsForCreateNewCliQ(Map<String, String> table) {
        CreateNewCliQ createNewCliQ = new CreateNewCliQ();

        if (table.get("CliQ ID Type").equalsIgnoreCase("Alias"))
            createNewCliQ.selectCliQAlias().setAliasName(table.get("Alias name"));
        else if (table.get("CliQ ID Type").equalsIgnoreCase("Mobile number")) createNewCliQ.selectCliQMobile();

        new HomePage().scroll("left");

        createNewCliQ.acceptCreation();

        if (table.get("Set default account").equalsIgnoreCase("Yes")) createNewCliQ.setDefaultAccount();

        new HomePage().scroll("left");
    }

    @Then("I should see the success message {string} for Create CliQ ID")
    public void iShouldSeeTheSuccessMessageForCreateCliQID(String expectedMessage) {
        String actualMessage = new CreateNewCliQ().fetchSuccessMessage().split("Swipe")[0].replaceAll("\n", " ").trim();

        Assert.assertTrue(actualMessage.toUpperCase().contains(expectedMessage.toUpperCase()));

        logInfo("CliQ ID has been created");
    }

    @When("I swipe back to dashboard")
    public void iSwipeBackToDashboard() {
        new HomePage().scroll("left");
    }

    @Then("I should see CliQ id with the name {string}")
    public void iShouldSeeCliQIdWithTheName(String cliQ) {
        Assert.assertTrue(new ManageCliQPage().isAliasPresent(cliQ), "Assertion on Created CliQ present in app.");
    }

    @And("I select {} CliQ alias {string}")
    public void iSelectActiveCliQAlias(String aliasType, String alias) {
        if (aliasType.equalsIgnoreCase("Active")) new ManageCliQPage().selectActiveAlias(alias);
        else if (aliasType.equalsIgnoreCase("Suspended")) new ManageCliQPage().selectSuspendedAlias(alias);
    }

    @And("I edit the CLiq ID to the alias name as {string}")
    public void iEditTheCLiqIDToTheAliasNameAs(String aliasName) {
        new ManageCliQPage().editAlias().setAliasName(aliasName).agreeChanges();
        new HomePage().scroll("left");
    }

    @Then("I should see the {} alias name {string} in the CliQ page")
    public void iShouldSeeTheUpdatedAliasNameInTheCliQPage(String aliasStatus, String aliasName) {
        String actualAliasName = "";

        if (aliasStatus.equalsIgnoreCase("active")) actualAliasName = new ManageCliQPage().fetchActiveAlias(aliasName);

        else if (aliasStatus.equalsIgnoreCase("suspended"))
            actualAliasName = new ManageCliQPage().fetchSuspendedAlias(aliasName);

        Assert.assertEquals(actualAliasName, aliasName);
    }

    @And("I suspend the CLiQ ID")
    public void iSuspendTheCLiQID() {
        new ManageCliQPage().suspendAlias().okSuspend();
    }

    @And("I activate the CliQ ID")
    public void iActivateTheCliQID() {
        new ManageCliQPage().activateAlias().acceptActivateCliQ().okReactivate();
    }

    @And("I delete the CLiQ ID")
    public void iDeleteTheCLiQID() {
        new ManageCliQPage().deleteAlias().confirmDelete();
    }

    @Then("I should not see the alias name {string} in the CliQ page")
    public void iShouldNotSeeTheAliasNameInTheCliQPage(String alias) {
        Assert.assertFalse(new ManageCliQPage().isAliasPresent(alias), "Assertion on Created CliQ present in app.");
    }

    @When("I click the Register via Email in blink app")
    public void iClickTheRegisterViaEmailInBlinkApp() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Swipe up to join our community']", 30);

        new HomePage().scroll("up", 0.99);

        new CreateYourProfilePage().registerViaEmail();
    }

    @And("I register with the email {string} and mobile number {string}")
    public void iRegisterWithTheEmail(String email, String mobile) throws InterruptedException {
        if (email.equalsIgnoreCase("random")) email = utils.getRandomString(9) + "@test.com";

        if (mobile.equalsIgnoreCase("random")) mobile = utils.getRandomNumber(9);

        new CreateYourProfilePage().setEmailAddress(email).setMobileNumber(mobile);

        new HomePage().scroll("left");
    }

    @Then("I should see the error pop-up {string} in the blink app")
    public void iShouldSeeTheErrorPopUpInTheBlinkApp(String errorText) {
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'Error')]";
        else
            xpath = "//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ", 'Error')]";

        utils.waitForElement(getDriver(), xpath, 60);
        String actualError = getDriver().findElement(By.xpath(xpath)).getAttribute(customData.getAttribute());
        Assert.assertEquals(actualError.replace("\n", " "), errorText);
    }

    @And("I set a new password {string} for blink register")
    public void iSetANewPasswordForBlinkRegister(String password) {
        new CreateYourProfilePage().setPassword(password).setConfirmPassword(password);

        new HomePage().scroll("left");
    }

    @And("I enter the otp code as {string}")
    public void iEnterTheOtpCodeAs(String otp) throws InterruptedException {
        iVerifyTheOTPForTheBlinkAppTransaction(otp);
    }

    @And("I clear and re-enter the otp code as {string}")
    public void iClearAndReEnterTheOtpCodeAs(String otp) throws InterruptedException {
        new OtpPage().clearAndEnterOtp(otp);
    }

    @And("I swipe up the screen to {}")
    public void iSwipeUpTheScreenTo(String value) throws InterruptedException {
        Thread.sleep(2000);
        new HomePage().scroll("up");
    }

    @And("I click blue button after entering the amount {string}")
    public void iClickBlueButtonAfterEnteringTheAmount(String amount) {
        new SendMoneyPage().enterMoney(amount).proceedPaymentNext();
    }

    @And("I enter the beneficiary details {string}")
    public void iEnterTheBeneficiaryDetails(String accountNunmber) {
        new SendMoneyPage().sendAccountNo(accountNunmber);
        new Actions(getDriver()).sendKeys(Keys.TAB).perform();
    }

    @And("I enter the beneficiary detail {string}")
    public void iEnterTheBeneficiaryDetail(String accountNO) throws InterruptedException {
        new SendMoneyPage().sendAccountNo(accountNO);
        new Actions(getDriver()).sendKeys(Keys.TAB).perform();
    }

    @Then("I should see {string} as Beneficiary name")
    public void iShouldSeeAsBeneficiaryName(String name) throws InterruptedException {
        String BeneficiaryName = new SendMoneyPage().accountName(name);
        Assert.assertEquals(name.toLowerCase(), BeneficiaryName.toLowerCase(), "Assertion on Beneficiary name");
    }

    @When("I enter the nick name as {string} for bill payments")
    public void iEnterTheNickNameAsForBillPayments(String name) {
        new SendMoneyPage().enterNickName(name);
        new HomePage().scroll("left");
    }

    @Then("I should see the {string} message for blink app")
    public void iShouldSeeTheMessageForBlinkApp(String message) {
        String errorMessage = new SendMoneyPage().statusMessage(message);
        Assert.assertTrue(errorMessage.contains(message), "Assertion on status message.");
        logInfo("The " + message + " message is displaying");
    }

    @Then("I should see the bill with {string} and {string}")
    public void iShouldSeeTheBillWithAnd(String biller, String billNo) {
        Assert.assertEquals(biller, new BillPaymentPage().iVerifyBill(biller));
        Assert.assertEquals(billNo, new BillPaymentPage().iVerifyBill(billNo));
        logInfo("Bill details has been verified");
        new HomePage().scroll("left");
    }

    @And("I select the bill to saved list")
    public void iSelectTheBillToSavedList() {
        new BillPaymentPage().addBill();
    }

    @And("I enter nickname {string}")
    public void iEnterNickname(String nickName) {
        new BillPaymentPage().nickName(nickName).swipeWithSwipeLocation("left");
    }

    @And("I edit the amount in the bill as {string}")
    public void iEditTheAmountInTheBillAs(String amount) {
        new BillPaymentPage().editAmount(amount);
    }

    @And("I click on {string} button")
    public void iClickButton(String value) {
        new BillPaymentPage().selectBillsType(value);
    }

    @And("I verify {string} bill after deleting it")
    public void iSwipeOnAnyBill(String bill) {
        BillPaymentPage billPaymentPage = new BillPaymentPage();

        String beforeDelete = billPaymentPage.billDetail(bill);

        billPaymentPage.deleteBill(bill).doneBiller();

        String afterDeletion = billPaymentPage.billDetail(bill);

        Assert.assertNotEquals(afterDeletion, beforeDelete, "Bill didn't get deleted");

        logInfo("Bill has been deleted");
    }

    @And("I select the prepaid biller details")
    public void iSelectTheBillerDetails(DataTable billerDetails) throws InterruptedException {
        BillPaymentPage billPayment = new BillPaymentPage();
        List<List<String>> data = billerDetails.asLists();

        billPayment.selectBill(data.get(1).get(0), data.get(1).get(1));

        billPayment.selectBillerType(data.get(1).get(1));

        billPayment.enterBillerType(data.get(1).get(2)).clickOkBiller();

        billPayment.enterServiceType(data.get(1).get(3)).clickOkServices();

        if (data.get(1).get(3).equals("Mobile_Prepaid")) {
            billPayment.enterMobileNo(data.get(0).get(4).toUpperCase(), data.get(1).get(4));

            billPayment.selectDenomination(data.get(0).get(4).toUpperCase(), data.get(1).get(5), data.get(0).get(5));
        } else if (data.get(1).get(3).equals("Advance_Payment")) {
            billPayment.enterBillNo(data.get(0).get(4).toUpperCase(), data.get(1).get(4));

            billPayment.enterPrepaidAmount(data.get(1).get(5));
        }

        billPayment.swipeWithSwipeLocation("left");

    }

    @And("I swipe to see {string} bill")
    public void iSwipeToSeePrepaidBill(String card) throws InterruptedException {
        switch (card.toUpperCase()) {
            case "PREPAID" -> new BillPaymentPage().swipeCard(3);
            case "POSTPAID" -> new BillPaymentPage().swipeCard(2);
            case "REQUEST MONEY" -> new BillPaymentPage().swipeCard(1);
        }
    }

    @Then("I should see the {string} status")
    public void iShouldSeeTheStatus(String message) {
        String actual = new BillPaymentPage().statusMessage(message);
        Assert.assertTrue(actual.contains(message), "Wrong status is displaying");
        logInfo("Success message has been displaying");
    }

    @Then("I should see the bill with {string}")
    public void iShouldSeeTheBillWith(String biller) {
        Assert.assertEquals(biller, new BillPaymentPage().iVerifyBill(biller));
        logInfo("Biller name has been verified");
        new HomePage().scroll("left");
    }

    @And("I select the postpaid biller details")
    public void iSelectThePostpaidBillerDetails(DataTable billerDetails) throws InterruptedException {
        List<List<String>> data = billerDetails.asLists();
        BillPaymentPage billPaymentPage = new BillPaymentPage();

        billPaymentPage.selectBill(data.get(1).get(0), data.get(1).get(1));

        billPaymentPage.selectBillerType(data.get(1).get(1));

        billPaymentPage.enterBillerType(data.get(1).get(2)).clickOkBiller();

        billPaymentPage.enterServiceType(data.get(1).get(3)).clickOkServices();

        billPaymentPage.enterBillNo(data.get(0).get(4).toUpperCase(), data.get(1).get(4));
    }

    @And("I select the beneficiary details")
    public void iSelectTheBeneficiaryDetails(Map<String, String> beneficiary) throws InterruptedException {
        new RequestMoneyPage().sendAccountNo(beneficiary.get("Key")).sendPurpose(beneficiary.get("purpose")).sendPurposeDetails(beneficiary.get("purpose details"));
    }

    @Then("I should see {string} as name for Request money")
    public void iShouldSeeAsNameForRequestMoney(String name) {
        Assert.assertEquals(new RequestMoneyPage().accountName(name).toUpperCase(Locale.ROOT),
                name.toUpperCase(Locale.ROOT), "Different name is showing");
        logInfo("Account name has been verified");
    }

    @And("I select the existing request money payee {string}")
    public void iSelectTheExistingPayee(String name) {
        new RequestMoneyPage().selectExistingRequestMoneyPayee(name);
    }

    @And("I enter amount {string}")
    public void iEnterAmount(String amount) {
        new RequestMoneyPage().enterMoney(amount).editProceedPayment();
    }

    @And("I edit the purpose details")
    public void iEditThePurposeDetails(Map<String, String> purpose) throws InterruptedException {
        new RequestMoneyPage().editButton()
                .editPurpose(purpose.get("purpose"))
                .editPurposeDetails(purpose.get("purpose details"))
                .doneEditPayment();
    }

    @And("I enter the invalid beneficiary {string}")
    public void iEnterTheInvalidBeneficiary(String beneficiary) {
        new RequestMoneyPage().sendAccountNo(beneficiary);
    }

    @And("I enter the purpose details")
    public void iEnterThePurposeDetails(Map<String, String> beneficiary) {
        new SendMoneyPage().sendPurpose(beneficiary.get("Purpose")).sendPurposeDetails(beneficiary.get("Purpose Details"));
    }

    @When("I enter the otp {string} for the blink transaction")
    public void iEnterTheOtpForTheBlinkTransaction(String otp) {
        new OtpPage().enterOtp(otp);
    }

    @And("I swipe the screen to {string}")
    public void iSwipeTheScreenTo(String direction) {
        new BillPaymentPage().swipeWithSwipeLocation(direction);
    }

    @And("I enter the beneficiary detail as {string}")
    public void iEnterTheBeneficiaryDetailAs(String value) throws InterruptedException {
        new OutwardCliq().sendBeneficiaryNo(value);
    }

    @And("I enter the beneficiary IBAN as {string}")
    public void iEnterTheBeneficiaryIBANAs(String value) throws InterruptedException {
        new OutwardCliq().sendIBANNo(value);
    }

    @And("I enter the purpose details with recipient")
    public void iEnterThePurposeDetailsWithRecipient(Map<String, String> beneficiary) throws InterruptedException {
        SendMoneyPage sendMoney = new SendMoneyPage();
        OutwardCliq cliq = new OutwardCliq();

        for (Map.Entry<String, String> value : beneficiary.entrySet()) {
            if (value.getKey().equals("Recipient name"))
                cliq.sendRecipient(beneficiary.get("Recipient name"));
            if (value.getKey().equals("Recipient Address"))
                cliq.sendRecipientAddress(beneficiary.get("Recipient Address"));
            if (value.getKey().equals("Purpose")) {
                sendMoney.sendPurpose(beneficiary.get("Purpose"));
                sendMoney.scroll("up", 0.25);
            }
            if (value.getKey().equals("Purpose Details"))
                sendMoney.sendPurposeDetails(beneficiary.get("Purpose Details"));
        }
    }

    @And("I enter {string} as nickname for Outward CliQ")
    public void iEnterAsNickname(String name) {
        new OutwardCliq().nickName(name);
    }

    @Then("I should see the IBAN with {string} in success page")
    public void iShouldSeeTheIBANWithInSuccessPage(String beneficiary) {
        Assert.assertTrue(new BillSubmissionPage().getReferenceMessage().contains(beneficiary), "Assertion in Beneficiary detail is displaying in the Ref No");
    }

    @Then("I should see {string} page after swipe down")
    public void iShouldSeeSendMoneyPageAfterSwipeDown(String value) {
        Assert.assertTrue(new SendMoneyPage().swipeFromBackToPayments(value).contains(value),
                "Assertion on send money page");
    }

    @And("I should see the dashboard after swiping")
    public void iShouldSeeTheDashboardAfterSwiping() throws InterruptedException {
        Assert.assertTrue(new RequestMoneyPage().dashboard().contains("Total Balance"), "Assertion on Dashboard");
    }

    @Then("I should see the {string} message for send money")
    public void iShouldSeeTheMessageForSendMoney(String message) {
        Assert.assertTrue(new SendMoneyPage().statusMessage(message).contains("Nickname is already stored as beneficiary"), "Assertion on Nick name");
    }

    @And("I verify the OTP {string} for cliq in blink app transaction")
    public void iVerifyTheOTPForCliqInBlinkAppTransaction(String value) {
        new OtpPage().enterOtpUpdateCliq(value);
    }

    @When("I set the {string} cliq value as default")
    public void iSetTheCliqValueAsDefault(String value) {
        new ManageCliQPage().clickLinkButton(value);
    }

    @Then("I should see the default value in {string}")
    public void iShouldSeeTheDefaultValueIn(String value) {
        Assert.assertTrue(new ManageCliQPage().defaultVerification(value).contains("Default"), "Assertion on default value");
    }

    @When("I click open an account button")
    public void iClickOpenAnAccountButton() {
        new CreateYourProfilePage().openAnAccount();
    }

    @And("I click on open your account now button")
    public void iClickOnOpenYourAccountNowButton() {
        new CreateYourProfilePage().openYourAccountNow();
    }

    @And("I swipe from scanning page")
    public void iSwipeFromScanningPage() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",\"Make sure\")]", 30);
        new HomePage().scroll("left");
    }

    @Then("I should not see the invalid no in keyboard")
    public void iShouldNotSeeTheInvalidNoInKeyboard() {
        Assert.assertTrue(new OutwardCliq().enterString(), "Assertion on Invalid string");
    }

    @And("I navigate to debit card")
    public void iNavigateToDebitCard() {
        new DebitCard().swipeToDebitCard();
    }

    @When("I click on settings icon")
    public void iClickOnSettingsIcon() {
        new DebitCard().settingsIcon();
    }

    @And("I {string} the freeze card")
    public void iTheFreezeCard(String value) {
        new DebitCard().freezeCard(value);
    }

    @Then("I should see the card gets {string}")
    public void iShouldSeeTheCardGets(String value) {
        Assert.assertEquals(new DebitCard().cardValue(), value);
    }

    @And("I click on manage card limit")
    public void iClickOnManageCardLimit() {
        new DebitCard().manageCardLimit();
    }

    @And("I edit the amount to {string} in {string} of {string}")
    public void iEditTheAmountTo(String value, String type, String card) {
        new DebitCard().editAmount(value, type, card);
    }

    @Then("I should see {string} as daily limit in {string}")
    public void iShouldSeeAsDailyLimit(String value, String type) {
        Assert.assertEquals(new DebitCard().getAmount(type), value);
    }

    @Then("I should see the {string} is disabled")
    public void iShouldSeeTheAtmWithdrawalIsDisabled(String type) {
        Assert.assertEquals(new DebitCard().atmToggle(type), "NO");
    }

    @And("I edit the amount {string} to exceed limit in {string} of {string}")
    public void iEditTheAmountToExceedLimit(String value, String type, String card) {
        new DebitCard().amountExceedsLimit(value, type, card);
    }

    @And("I click the Debit card menu as {string}")
    public void iClick(String value) {
        new DebitCard().debitMenu(value);
    }

    @Then("I should see the {string} menu")
    public void iShouldSeeTheMenu(String value) {
        Assert.assertTrue(new DebitCard().managePinMessage(value).contains(value));
        new HomePage().scroll("down", 0.85);
    }

    @And("I should see the {string}")
    public void iShouldSeeThe(String value) {
        Assert.assertEquals(new DebitCard().managePinMessage(value), value);
    }

    @Then("I should see your card page")
    public void iShouldSeeYourCardPage() {
        new DebitCard().yourCardPage();
    }

    @When("I set the pin {string}")
    public void iSetThePin(String value) {
        new DebitCard().setPin(value).confirmPin(value);
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String value) {
        Assert.assertEquals(new DebitCard().reportCardMessage(), value);
        new HomePage().scroll("left");
    }

    @And("I should see debit card")
    public void iShouldSeeDebitCard() {
        Assert.assertTrue(new DebitCard().debitCard().contains("Debit Card"), "Assertion on Debit card");
    }

    @And("I select {string} for Debit card")
    public void iSelectForDebitCard(String value) {
        new DebitCard().selectReasonForCancel(value)
                .cancelCardTerms()
                .cancelCardDone();
    }

    @When("I click on the debit card option as {string}")
    public void iClickOn(String value) {
        new DebitCard().clickAction(value);
    }

    @Then("I should see the account details")
    public void iShouldSeeTheAccountDetails() {
        Assert.assertTrue(new DebitCard().accountDetails().contains("CARD NUMBER"), "Assertion on account details");
    }

    @And("I click back button in the add money page")
    public void iClickBackButtonInTheAddMoneyPage() {
        new DebitCard().backButton();
    }

    @Then("I should see the message for blink debit card {string}")
    public void iShouldSeeTheMessage(String value) {
        Assert.assertTrue(new DebitCard().addMoneyMessage(value).contains(value), "Assertion on Request money page");
    }

    @Then("I should see the request money page")
    public void iShouldSeeTheRequestMoneyPage() {
        Assert.assertTrue(new DebitCard().requestMoney().contains("Request money"), "Assertion on Request money page");
    }

    @When("I click on login with email button")
    public void iClickOnLoginButtonWithEmailButton() {
        new LoginPage().loginPage();
    }

    @When("I entered the username as {string} and password as {string}")
    public void iEnteredTheUsernameAsAndPasswordAs(String username, String password) {
        new LoginPage().loginPage().userName(username).password(password).login();
    }

    @And("I click blink login button")
    public void iClickBlinkLoginButton() {
        new LoginPage().loginClick();
    }

    @And("I click forgot password")
    public void iClickForgotPassword() {
        new LoginPage().forgotPassword();
    }

    @And("I click back to login")
    public void iClickBackToLogin() {
        new LoginPage().backToLogin();
    }

    @Then("I should see login page")
    public void iShouldSeeLoginPage() {
        Assert.assertEquals(new LoginPage().getLoginPageAttribute(), "Enter your login details");
    }

    @And("I click on eye icon")
    public void iClickOnEyeIcon() {
        new LoginPage().eyeIcon();
    }

    @Then("I should see the password {string}")
    public void iShouldSeeThePassword(String value) {
        Assert.assertEquals(new LoginPage().eyeValue(), value);
    }

    @When("I click on {string} language")
    public void iClickOnLanguage(String value) {
        new LoginPage().languageClick(value);
    }

    @Then("I should see {string} button")
    public void iShouldSeeButton(String value) {
        Assert.assertEquals(new LoginPage().getLoginButtonAttribute(), value);
        logInfo("Login button is displaying as: " + value);
    }

    @When("I click on open an account button")
    public void iClickOnOpenAnAccountButton() {
        new LoginPage().openAnAccountButton();
    }

    @Then("I should see profile creation page")
    public void iShouldSeeProfileCreationPage() {
        Assert.assertEquals(new LoginPage().getOpenAnAccountButtonAttribute(), "true");
    }

    @And("I click on send money tooltip")
    public void iClickOnSendMoneyTooltip() {
        new SendMoneyPage().toolTip();
    }

    @And("I click on purpose {string}")
    public void iClickOnPurpose(String value) {
        new SendMoneyPage().sendPurpose(value);
    }

    @Then("I should not see focus on purpose details in {string}")
    public void iShouldNotSeeFocusOnPurposeDetails(String value) {
        if (value.equalsIgnoreCase("Send Money"))
            Assert.assertEquals(new SendMoneyPage().getAttributePurposeDetails(), "false");
        else if (value.equalsIgnoreCase("Request Money"))
            Assert.assertEquals(new RequestMoneyPage().getAttributePurposeDetails(), "false");
    }

    @And("I enter the beneficiary {string} in request money")
    public void iEnterTheBeneficiaryInRequestMoney(String value) {
        new RequestMoneyPage().sendAccountNo(value);
    }

    @And("I enter the personal details")
    public void iEnterThePersonalDetails(Map<String, String> table) {
        LoginPage login = new LoginPage();
        if (!(table.get("email").equalsIgnoreCase("nil")))
            login.forgotPasswordEmail(table.get("email"));

        if (!(table.get("national").equalsIgnoreCase("nil")))
            login.forgotPasswordNationalId(table.get("national"));

        if (!(table.get("date").equalsIgnoreCase("nil")))
            login.forgotPasswordDate(table.get("date"));

        new HomePage().scroll("left");
    }

    @Then("I should see the new password page")
    public void iShouldSeeTheNewPasswordPage() {
        Assert.assertEquals(new LoginPage().getAttributeNewPasswordPage(), "Next, let’s create your new password");
    }

    @And("I pay the bills")
    public void iPayTheBills() {
        new BillPaymentPage().clickPayBillButton().swipeWithSwipeLocation("left");
    }

    @Then("I should see the {string} request message")
    public void iShouldSeeTheRequestMessage(String value) {
        Assert.assertEquals(new BillPaymentPage().getRequestMessage(), value);
    }

    @And("I have logged in the blink app with username as {string}")
    public void iHaveLoggedInTheBlinkAppWithUsernameAs(String value) {
        new LoginPage().loginPage().userName(value)
                .password(properties.getProperty(value + ".password"))
                //.login()
                .loginClick();
    }

    @And("I edit the amount to {string} in {string} of credit card")
    public void iEditTheAmountToInOfCreditCard(String amount, String type) {
        new CreditCardPage().editAmount(amount, type);
    }

    @Then("I should see {string} in debit card")
    public void iShouldSeeInDebitCard(String value) {
        Assert.assertTrue(new CreditCardPage().cardDetails().contains(value),
                "Assertion on " + value);
    }

    @When("I swipe the screen to see transaction history")
    public void iSwipeTheScreenToSeeTransactionHistory() {
        new HomePage().scroll("up", 0.80);
    }

    @And("I choose {string} month after selecting the download button")
    public void iChooseMonthAfterSelectingTheDownloadButton(String month) {
        new CreditCardPage().downloadTransaction(month)
                .doneTransaction();
    }

    @Then("I should verify the {string} statement")
    public void iShouldVerifyTheStatement(String month) {
        CreditCardPage details = new CreditCardPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(details.statementVerification().get("From").split("\\D+")[0].equals("02"));
        softAssert.assertTrue(details.statementVerification().get("To").split("\\D+")[0].equals("02"));

        softAssert.assertTrue(details.transactionStatementVerification().contains(customData.getRequestType().split(" ")[0]));
        softAssert.assertAll("Assertion on CreditCard statement details");
    }

    @Then("I should see the {string} transaction history")
    public void iShouldVerifyTheTransactionHistory(String month) {
        Assert.assertTrue(new CreditCardPage().transactionDetails(), "Assertion on Transaction History");

        Set<String> transactionEntries = new CreditCardPage().transactionList(month);

        customData.setRequestType(String.valueOf(transactionEntries.iterator().next()));
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().loginClick();
    }

    @And("I swipe from profile page")
    public void iSwipeFromProfilePage() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",\"profile\")]", 30);
        new HomePage().scroll("left");
    }
}