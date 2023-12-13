package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.ProfilePage;
import com.qa.pages.capitalbank.dashBoard.DashboardPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import com.qa.pages.capitalbank.overdraft.LetterOfGuaranteePage;
import com.qa.pages.capitalbank.overdraft.ManageCliQIdPage;
import com.qa.pages.capitalbank.overdraft.OverdraftConfirmPage;
import com.qa.pages.capitalbank.overdraft.OverdraftTransferPage;
import com.qa.pages.capitalbank.termDeposit.TermDepositPage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class cliqOverdraftSteps extends ProjectBase {


    @And("I select the Manage CliQ ID from the profile")
    public void iSelectTheManageCliQIDFromTheProfile() {
        new ProfilePage().clickOnManageCliQId();
    }

    @And("I click on create new cliQ")
    public void iClickOnCreateNewCliQ() {
        new ManageCliQIdPage().clickCreateCliQ();
    }

    @And("I select the Default link account with account number {string}")
    public void iSelectTheDefaultLinkAccountWithAccountNumber(String number) {
        new ManageCliQIdPage().selectCard(number);
    }

    @And("I select the cliQ ID type as {string}")
    public void iSelectTheCliQIDTypeAs(String name) {
        new ManageCliQIdPage().clickRadioButton(name);
    }

    @And("I Enter the {string} as {string}")
    public void iEnterTheAs(String type, String value) {
        new ManageCliQIdPage().enterAlias(type, value);
    }

    @And("I fetch the available balance amount from default link account card")
    public void iFetchTheAvailableBalanceAmountFromDefaultLinkAccountCard() {
        customData.setCardBalance(Double.parseDouble(new TermDepositPage().fetchCardValue()
                .split("BALANCE\n")[1]
                .split(" ")[0].replace(",", "")));

        logInfo("The total available balance in card is " + customData.getCardBalance());
    }

    @And("I click on the radio button for acceptance of created CliQ Id")
    public void iClickOnTheRadioButtonForAcceptanceOfCreatedCliQId() {
        new HomePage().scroll("up");
        new ManageCliQIdPage().clickCheckBox();
    }

    @And("I confirm the creation of new CliQ Id")
    public void iConfirmTheCreationOfNewCliQId() {
        new ManageCliQIdPage().clickConfirmButton();
    }

    @And("I click on request history")
    public void iClickOnRequestHistory() {
        new ManageCliQIdPage().clickOnRequestHistory();
    }

    @And("I click on overdraft menu")
    public void iClickOnOverdraftMenu() {
        new DashboardPage().clickOverdraftMenu();
    }

    @And("I select pay to as own account")
    public void iSelectPayToAsOwnAccount() {
        new OverdraftTransferPage().clickOwnAccount();
    }

    @And("I enter the description as {string} for Overdraft transfers")
    public void iEnterTheDescriptionAsForOverdraftTransfers(String name) {
        new HomePage().scroll("up");
        new OverdraftTransferPage().descriptionName(name);
        customData.setDescription(name);
    }

    @And("I fetch the amount from the payFrom card")
    public void iFetchTheAmountFromThePayFromCard() {
        customData.setCardBalance(Double.parseDouble(new OverdraftTransferPage().fetchDetails()
                .split("BALANCE\n")[1]
                .split(" ")[0].replace(",", "")));
        customData.setPayFromCurrency(new OverdraftTransferPage().fetchDetails().split("\n")[2].split(" ")[1]);
        customData.setPayFromAccountNumber(new OverdraftTransferPage().fetchDetails()
                .split("NUMBER: ")[1]);

        logInfo("The pay From currency is " + customData.getPayFromCurrency()
                + "\n" + "The total available balance in payFrom card is " + customData.getCardBalance()
                + "\n" + "The pay from account number = " + customData.getPayFromAccountNumber());
    }

    @And("I fetch the amount from payTo card")
    public void iFetchTheAmountFromPayToCard() {
        customData.setPayToAmount(Float.parseFloat(new OverdraftTransferPage().fetchCardDetails()
                .split("BALANCE\n")[1]
                .split(" ")[0].replaceAll(",", "")));
        customData.setPayToCurrency(new OverdraftTransferPage().fetchCardDetails()
                .split("\n")[2].split(" ")[1]);
        customData.setAccountNumber(new OverdraftTransferPage().fetchCardDetails()
                .split("NUMBER: ")[0]);


        logInfo("The total available balance in payTo card is " + customData.getPayToAmount() + "\n" +
                "The pay From currency is " + customData.getPayToCurrency());
    }

    @Then("I should verify the details in the confirm page of overdraft")
    public void iShouldVerifyTheDetailsInTheConfirmPageOfOverdraft() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Confirm Transfer']", 90);
        SoftAssert softAssert = new SoftAssert();
        OverdraftConfirmPage confirm = new OverdraftConfirmPage();

        float conversionRate = 0;
        float finalAmount = Float.parseFloat(confirm.getAmount().split(" ")[0].replaceAll(",", ""));

        if (customData.getPayFromCurrency().equals(customData.getPayToCurrency())) {
            softAssert.assertEquals(confirm.getAmount(), String.format("%.3f", customData.getEnteredAmount()), "Assertion on entered amount");

        } else {
            conversionRate = confirm.getConversionRate();
            customData.setConversionRate(conversionRate);
            softAssert.assertEquals(confirm.getDescription(), customData.getDescription(), "The entered description is not displaying");
        }

        if (customData.getPayFromCurrency().equals("JOD"))
            softAssert.assertEquals(String.format("%.3f", finalAmount), String.format("%.3f", customData.getEnteredAmount()),
                    "The entered amount is not equal");
        else
            softAssert.assertEquals(String.format("%.2f", finalAmount), String.format("%.2f", customData.getEnteredAmount()),
                    "The entered amount is not equal");

        if (customData.getPayFromCurrency().equals("JOD") && !(customData.getPayToCurrency().equals("JOD"))) {
            customData.setConversionRate(customData.getEnteredAmount() * conversionRate);
            softAssert.assertEquals(confirm.getConversionRate(), customData.getConversionRate() / customData.getEnteredAmount(), "Assertion on conversion rate");

        } else if (customData.getPayToCurrency().equals("JOD") && !(customData.getPayFromCurrency().equals("JOD"))) {
            customData.setConversionRate(customData.getEnteredAmount() / conversionRate);
            softAssert.assertEquals(confirm.getConversionRate(), customData.getConversionRate() * customData.getEnteredAmount(), "Assertion on conversion rate");

        } else {
            customData.setConversionRate(0);
        }

        softAssert.assertAll();
    }

    @Then("I should see the alert message {string} for CliQ ID")
    public void iShouldSeeTheAlertMessageForCliQId(String message) {
        String alertMessage = String.valueOf(new ManageCliQIdPage().fetchAlertMessage());
        Assert.assertTrue(alertMessage.contains(message), "Assert on manage cliq Id");
        logInfo(alertMessage);
    }

    @Then("I should see the transfer successful message {string}")
    public void iShouldSeeTheTransferSuccessfulMessage(String message) {
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Transfer successful!\"]//..//" + customData.getViewAttribute();
        else
            xpath = "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "=\"Transfer successful!\"]";

        List<String> depositDetails = new ArrayList<>();

        utils.waitForElement(getDriver(), xpath, 90);

        if (getDriver() instanceof AndroidDriver) {
            for (int i = 2; i <= 5; ) {
                String key = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("content-desc");
                i = i + 1;
                String value = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("content-desc");
                depositDetails.add(key + " - " + value);

                i = i + 1;
            }
        } else {
            for (int i = 1; i < 5; ) {
                String key = getDriver().findElement(By.xpath(xpath + "//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute("name");
                i = i + 1;
                String value = getDriver().findElement(By.xpath(xpath + "//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute("name");
                depositDetails.add(key + " - " + value);

                i = i + 1;
            }
        }

        depositDetails.forEach(log()::info);

        Assert.assertTrue(new OverdraftTransferPage().fetchSuccessMessage().replace("\n", " ")
                .contains(message), "Assertion on overdraft Transfer Successful");
    }

    @And("I confirm the overdraft transfer")
    public void iConfirmTheOverdraftTransfer() {
        new OverdraftTransferPage().confirmTransfer();
    }

    @And("I select {string} card from pay to account with number {string}")
    public void iSelectCardFromPayToAccountWithNumber(String currency, String number) {
        new OverdraftTransferPage().selectPayToAccount(currency, number);
        customData.setPayToCurrency(currency);
    }

    @And("I click on pay From account as new Beneficiary")
    public void iClickOnPayFromAccountAsNewBeneficiary() {
        new OverdraftTransferPage().clickNewBeneficiary();
    }

    @And("I select {string} from the existing beneficiary")
    public void iSelectFromTheExistingBeneficiary(String name) {
        new OverdraftTransferPage().clickAndEnterBeneficiary(name);
        new HomePage().scroll("up");
        new OverdraftTransferPage().selectBeneficiary(name)
                .clickOnAmountTextField();
        customData.setPayToCurrency(name);
    }

    @And("I click on Letter of Guarantee menu from dashboard")
    public void iClickOnLetterOfGuaranteeMenuFromDashboard() {
        new DashboardPage().clickOnLetterOfGuarantee();
    }

    @Then("I verify entered amount is greater than available balance in the card")
    public void iVerifyEnteredAmountIsGreaterThanAvailableBalanceInTheCard() {
        Assert.assertTrue(customData.getEnteredAmount() > customData.getCardBalance(),
                "Assertion on card entered amount greater than available balance");
    }

    @And("I swipe to see payment details")
    public void iSwipeToSeePaymentDetails() {
        new TransferPayeePage().swipeToDetails();
    }

    @Then("I should see alert message {string} for overdraft")
    public void iShouldSeeAlertMessageForOverdraft(String message) {
        Assert.assertEquals((new OverdraftTransferPage().fetchAlertMessage().replace("\n", " ")), message,
                "Assertion on alert message");
    }

    @Then("I should see the amount {string} reduced from the overdraft Account card")
    public void iShouldSeeTheAmountReducedFromTheOverdraftAccountCard(String amount) {
        double enteredValue = Double.parseDouble(amount);
        String balanceValue = new OverdraftTransferPage().fetchDetails().split("BALANCE\n")[1];

        double actualBalance = Double.parseDouble(balanceValue.split(" ")[0]
                .replaceAll(",", ""));

        logInfo("The actual balance in the card after transaction of " + amount + " = " + actualBalance);

        Assert.assertEquals(Math.round(customData.getCardBalance() - enteredValue), Math.round(actualBalance),
                "After Debit amount are not equal");
    }

    @Then("I should see the amount reduced from the overdraft Account card")
    public void iShouldSeeTheAmountReducedFromTheOverdraftAccountCard() {
        Instant timeout = Instant.now().plusSeconds(90);

        OverdraftTransferPage overdraftTransferPage = new OverdraftTransferPage();

        String cardValue = overdraftTransferPage.fetchDetails();

        while (!cardValue.contains(customData.getPayFromAccountNumber())) {
            new TransferPayeePage().clickOnForwardArrow();

            cardValue = overdraftTransferPage.fetchDetails();

            if (cardValue.contains(customData.getPayFromAccountNumber()))
                break;

            if (Instant.now().isAfter(timeout)) {
                break;
            }
        }

        String balanceValue = overdraftTransferPage.fetchDetails().split("BALANCE\n")[1];

        double actualBalance = Double.parseDouble(balanceValue.split(" ")[0]
                .replaceAll(",", ""));

        if (customData.getPayToCurrency().equals("JOD")) {
            Assert.assertEquals(customData.getCardBalance() - customData.getEnteredAmount(), actualBalance,
                    "Assertion on card balance after overdraft transfer");
        } else if (customData.getPayToCurrency().equals("USD")) {
            Assert.assertEquals(Math.round(customData.getCardBalance() - customData.getConversionRate()), Math.round(actualBalance),
                    "Assertion on card balance after overdraft transfer");
        } else {
            double transactionAmount = customData.getEnteredAmount() + customData.getSurCharge();
            Assert.assertEquals(customData.getCardBalance() - transactionAmount, actualBalance,
                    "Assertion on card balance after overdraft transfer");
        }
    }

    @Then("I should see the success message for create CliQ ID {string}")
    public void iShouldSeeTheSuccessMessageForCreateCliQID(String message) {
        String actualMessage = new ManageCliQIdPage().fetchSuccessMessage()
                .split("Swipe")[0].replaceAll("\n", " ").trim();

        Assert.assertEquals(actualMessage.toUpperCase(), message.toUpperCase(),
                "Assertion on CliQ ID creation");

        logInfo("CliQ ID has been created");
    }

    @Then("I should verify the confirm page of overdraft")
    public void iShouldVerifyTheConfirmPageOfOverdraft() {
        SoftAssert softAssert = new SoftAssert();

        OverdraftConfirmPage confirmPage = new OverdraftConfirmPage();
        softAssert.assertEquals(customData.getPayFromAccountNumber(), confirmPage.getPayFromAccount(), "Assertion on payFrom Account");
        softAssert.assertEquals(String.valueOf(customData.getDescription()), confirmPage.getDescription(), "Assertion on Description");

        softAssert.assertAll();
    }

    @And("I select {string} account under overdraft Account")
    public void iSelectAccountUnderOverdraftAccount(String currency) {
        new OverdraftTransferPage().selectCard(currency);
    }

    @Then("I should see the details in letter of Guarantee screen")
    public void iShouldSeeTheDetailsInLetterOfGuaranteeScreen() {
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> letterOfGuaranteeDetails = new LinkedHashMap<>();
        LetterOfGuaranteePage page = new LetterOfGuaranteePage();
        List<String> details = List.of(page.fetchDetailsInLetterOfGuarantee().split("\n"));

        for (int i = 0; i < details.size() - 1; i++) {
            letterOfGuaranteeDetails.put(details.get(i), details.get(i + 1));
            letterOfGuaranteeDetails.put(details.get(12), "nil");
            i++;
        }
        for (Map.Entry<String, String> entry : letterOfGuaranteeDetails.entrySet()) {
            logInfo(entry.getKey() + "=" + entry.getValue());
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Beneficiary Name"), "وزارة العمل", "Assertion on Beneficiary Name");
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Original Amount"), "0.000 JOD", "Assertion on Original Amount");
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Outstanding Amount"), "0.000 JOD", "Assertion on Outstanding Amount");
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Currency"), "JOD", "Assertion on Currency");
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Expiry Date"), "2024-06-07T00:00:00", "Assertion on Expiry Date");
            softAssert.assertEquals(letterOfGuaranteeDetails.get("Reference Number"), "nil", "Assertion on Reference Number");
        }

        softAssert.assertAll();
    }

    @And("I select the charge options as {string}")
    public void iSelectTheChargeOptionsAs(String chargeOption) {
        if (chargeOption.equalsIgnoreCase("Fees on Sender")) {
            customData.setSurCharge(2);
        } else {
            new OverdraftTransferPage().clickOnChargeOptions(chargeOption);
            customData.setSurCharge(2);
        }
    }

    @And("I enter the transfer amount with more than available balance to {string}")
    public void iEnterTheTransferAmountWithMoreThanAvailableBalanceTo(String beneficiaryType) {
        double enterAmount = customData.getCardBalance() + 100;

        new TransferPayeePage().setAmount(beneficiaryType, String.valueOf(enterAmount))
                .clickOk(beneficiaryType);
        customData.setEnteredAmount(Float.parseFloat(String.valueOf(enterAmount)));
    }
}