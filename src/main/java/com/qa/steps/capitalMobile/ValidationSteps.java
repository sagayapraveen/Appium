package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.HomePage;
import com.qa.pages.capitalbank.LauncherPage;
import com.qa.pages.capitalbank.beneficiary.BeneficiariesPage;
import com.qa.pages.capitalbank.beneficiary.BeneficiaryDetailsPage;
import com.qa.pages.capitalbank.billpay.PayBillPage;
import com.qa.pages.capitalbank.billpay.PayBillSuccessfulPage;
import com.qa.pages.capitalbank.cards.*;
import com.qa.pages.capitalbank.dashBoard.DashboardPage;
import com.qa.pages.capitalbank.dashBoard.RequestMoneyPage;
import com.qa.pages.capitalbank.investment.InvestmentsPage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValidationSteps extends ProjectBase {
    @Then("I should see the Transfer successful message with the details")
    public void iShouldSeeTheTransferSuccessfulMessageWithTheDetails() {
        String xpath = "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Transfer successful!']//..//" + customData.getViewAttribute();
        List<String> transferDetails = new ArrayList<>();

        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'successful!')]", 90);
            for (int i = 2; i <= 13; ) {
                String key = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute(customData.getAttribute());
                i = i + 1;
                String value = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute(customData.getAttribute());
                transferDetails.add(key + " - " + value);

                i = i + 1;
            }

        } else {
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ",'successful!')]", 90);
            for (int i = 1; i < 13; ) {
                String key = getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Transfer successful!\"]//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute(customData.getAttribute());
                i = i + 1;
                String value = getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Transfer successful!\"]//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute(customData.getAttribute());
                transferDetails.add(key + " - " + value);

                i = i + 1;
            }
        }

        for (String transferDetail : transferDetails) {
            logInfo(transferDetail.replaceAll("\n", " "));
        }
    }

    @Then("I should see the successful message for {}")
    public void iShouldSeeTheWithdrawSuccessfulMessage(String name) {
        String message = String.valueOf(new TopUpPage().fetchSuccessMessage(name));
        Assert.assertTrue(message.contains("successful"), "Assertion on Successful message");
        logInfo(message);
    }

    @Then("I should see the confirmation message for request money")
    public void iShouldSeeTheConfirmationMessageForRequestMoney() {
        RequestMoneyPage request = new RequestMoneyPage();
        /*customData.setDate(request.successPageDate());
        logInfo("The time is: " + request.successPageDate());*/

        String message = request.fetchConfirmationMessage();
        logInfo(message);

        if (getDriver() instanceof AndroidDriver) {
            customData.setDate(request.fetchConfirmationMessage().split("\n")[2].split("-")[2].trim());
            logInfo("The time is: " + request.fetchConfirmationMessage().split("\n")[2].split("-")[2]);
        } else {
            customData.setDate(request.fetchConfirmationMessage().split("\n")[2].split("-")[1].trim());
            logInfo("The time is: " + request.fetchConfirmationMessage().split("\n")[2].split("-")[1]);
        }
    }

    @Then("I should not see the deleted name in the {string} beneficiaries list")
    public void iShouldNotSeeTheDeletedNameInTheCBOJBeneficiariesList(String beneficiaryType) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='" + beneficiaryType + " Beneficiaries']", 60);

        Assert.assertTrue(new BeneficiariesPage().isValueNotPresent(customData.getBeneficiaryName().toUpperCase(Locale.ROOT)));
    }

    @Then("I should see the success message for new beneficiary")
    public void iShouldSeeTheSuccessMessageForNewBeneficiary() {
        logInfo(new BeneficiaryDetailsPage().getSuccessMessage());
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheBillPaidSuccessfulMessageWithDetails(String successMessage) {
        Assert.assertTrue(String.valueOf(new PayBillSuccessfulPage().getSuccessfulMessage())
                .contains(successMessage), "Assertion in bill paid successful page");
    }

    @Then("I should see the latest Transaction date as {string}")
    public void iShouldSeeTheLatestTransactionDate(String year) {
        String referenceMessage = new PayBillPage()
                .getLatestTransaction();
        Assert.assertTrue(referenceMessage.contains(year), "Assertion in view history");
        logInfo("Latest transaction date " + referenceMessage);
    }

    @Then("I should see the {string} field in new biller page")
    public void iShouldSeeTheMobileNumberFieldIn(String field) {
        String referenceMessage = new PayBillPage()
                .getMobileNumber();
        Assert.assertTrue(referenceMessage.contains(field), "Assertion in biller page");
        logInfo("App is in " + referenceMessage + " Mandatory field");
    }

    @Then("I should able to click on next button")
    public void iShouldAbleToClickOnNextButton() {
        new PayBillPage().clickOnNext();
    }

    @Then("I should see the field level error message {string}")
    public void iShouldSeeTheFieldLevelErrorMessage(String errorText) {
        int size = getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='" + errorText + "' or contains(@name,'empty')]")).size();
        String message = "";

        if (size == 0)
            message = "Error message '" + errorText + "' is not displayed.";
        else
            message = "Error message '" + errorText + "' is displayed.";

        try {
            Assert.assertEquals(size, 1, message);
        } finally {
            logInfo(message);
        }
    }

    @Then("I should see the error pop-up {string}")
    public void iShouldSeeTheErrorPopUp(String expectedError) {
        String xpath = "//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ", 'Error') or contains(@" + customData.getAttribute() + ", 'INFO')]";

        utils.waitForElement(getDriver(), xpath, 90);

        String actualError = getDriver().findElement(By.xpath(xpath)).getAttribute(customData.getAttribute()).replace("\n", " ").trim();

        Assert.assertEquals(actualError, expectedError);
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String page) {
        String referenceMessage = new PayBillPage()
                .getPayBillPAge();
        Assert.assertTrue(referenceMessage.contains(page));
        logInfo("App is in " + referenceMessage);
    }

    @Then("I should see app in {string} page")
    public void iShouldSeeAppInPage(String page) {
        String referenceMessage = new PayBillPage()
                .getNewRegistration();
        Assert.assertTrue(referenceMessage.contains(page));
        logInfo("App is in  " + referenceMessage);
    }

    @Then("I should see Cvv of the card")
    public void iShouldSeeCvvOfTheCard() {
        // cvv number returns as ***
        Assert.assertTrue("***".contains(new CardPage()
                .getCvvNumber().replace(", Please Enter", "")), "Assertion on card CVV number");
    }

    @Then("I should see the card details")
    public void iShouldSeeTheCardDetails() {
        String message = String.valueOf(new CardPage().fetchSuccessMessage());
        Assert.assertTrue(message.contains("Card Number"), "Assertion on Card number");
    }

    @Then("I should see the status of card {string}")
    public void iShouldSeeTheStatusOfCard(String cardStatus) {
        String CardStatus = new CardPage().fetchCardStatus();
        logInfo("Fetched Card Status, " + CardStatus);
        Assert.assertTrue(CardStatus.replace("\n", " ").contains(cardStatus), "Assertion on card status");
    }

    @Then("I should see the selected card details and status")
    public void iShouldSeeTheSelectedCardDetailsAndStatus() {
        String cardDetails = new CardPage().fetchVirtualCardDetails();
        String CardStatus = new CardPage().fetchCardStatus();

        logInfo("Fetched Card details, " + cardDetails);
        logInfo("Fetched Card Status, " + CardStatus);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(cardDetails.replace("\n", " ").contains("VIRTUAL"), "Assertion of card details");
        softAssert.assertTrue(CardStatus.replace("\n", " ").contains("Card Status"), "Assertion of card status");

        softAssert.assertAll();
    }

    @Then("I should see the confirmation page details of added card")
    public void iShouldSeeTheConfirmationPageDetailsOfAddedCard() {
        Assert.assertTrue(String.valueOf(new AddNewCard().fetchConfirmationDetails())
                        .replace("\n", " ").contains("Cardholder Name"),
                "Assertion of confirmation Page");
    }

    @Then("I should see the page displayed as {string}")
    public void iShouldSeeThePageDisplayedAs(String actualMessage) {
        String selectAccountPage = String.valueOf(new CardPage().fetchSelectAccount());
        Assert.assertEquals(actualMessage.replace("\n", " "), selectAccountPage, "Assertion of select account page");
    }

    @Then("I should see the confirmation message for cancelling the card {string}")
    public void iShouldSeeTheConfirmationMessageForCancellingTheCard(String cancelMessage) {
        String message = String.valueOf(new CancelCardPage().fetchCancelMessage());

        Assert.assertTrue(message.replace("\n", " ").contains(cancelMessage), "Assertion of confirmation message");
        logInfo(message);
    }

    @Then("I should see the success message of cancel {string}")
    public void iShouldSeeTheSuccessMessageOfCancel(String successMessage) {
        Assert.assertEquals(String.valueOf(new CancelCardPage().successfulMessage())
                        .replace("\n", " "), successMessage,
                "Assertion on cancel message");
    }

    @Then("I should see the {string} dashboard page")
    public void iShouldSeeTheDashboardPage(String accounts) {
        String value = new DashboardPage().getDashboardPage();
        logInfo("App is in " + accounts + "page");
        Assert.assertTrue(value.contains(accounts), "Assertion on the Dashboard page to present.");
    }

    @Then("I should see the saved biller {string}")
    public void iShouldSeeTheSavedBiller(String biller) {
        String name = new PayBillPage().getSavedBiller();
        Assert.assertTrue(name.contains(biller), "Assert in saved biller");
    }

    @Then("I should see the {string} postpaid Bill paid successful message")
    public void iShouldSeeThePostpaidBillPaidSuccessfulMessage(String successMessage) {
        String message = String.valueOf(new PayBillSuccessfulPage().getPostpaidSuccessful());
        Assert.assertTrue(message.contains(successMessage), "Assert in postpaid success message");
        logInfo(message);
    }

    @Then("I should see the {string} add as save biller page")
    public void iShouldSeeTheAddAsSaveBillerPage(String page) {
        String name = new PayBillSuccessfulPage().addAsSaveBiller();
        logInfo("App is in " + name);
        Assert.assertTrue(name.contains(page), "Assert in add new biller");
    }

    @Then("I should see the Verify your card page for Register")
    public void iShouldSeeTheVerifyYourCardPageForRegister() {
        new LauncherPage().waitForVerifyCard();
    }

    @Then("I should see the Forget Username password page")
    public void iShouldSeeTheForgetUsernamePasswordPage() {
        new LauncherPage().waitForForgotLoginPage();
    }

    @Then("I should see the last two biller are selected")
    public void iShouldSeeTheLastTwoBillerAreSelected() {
        boolean lastBiller = new PayBillPage().billerIsSelected(1);
        boolean lastBeforeBller = new PayBillPage().billerIsSelected(2);
        Assert.assertTrue(lastBiller, String.valueOf(true));
        Assert.assertTrue(lastBeforeBller, String.valueOf(true));
    }

    @Then("I should see the {string} success message {string}")
    public void iShouldSeeThePostpaidSuccessMessage(String paymentMode, String element) throws InterruptedException {
        String name = new PayBillSuccessfulPage().getPrePaidAndPostpaidSuccessMessage(paymentMode, element);
        Assert.assertTrue(name.contains(element), "Assertion in biller name.");
    }

    @Then("I should see the enter amount equal in confirm page")
    public void iShouldSeeTheEnterAmountEqualInConfirmPage() {
        String value = new PayBillSuccessfulPage().getAmountForConfirmation();
        String[] splitValue = value.split(" ");
        float value1 = Float.parseFloat(splitValue[0]);
        String valueAmount = String.format("%.1f", value1);
        logInfo(valueAmount);
        Assert.assertEquals(valueAmount, customData.getPayBillAmount(), "Assertion in postpaid biller");
    }

    @Then("I should see the successful message of {string}")
    public void iShouldSeeTheSuccessfulMessageOfBillerSaved(String message) {
        String name = new PayBillSuccessfulPage().getPostpaidBillerSavedSuccessMessage();
        logInfo(name);
        Assert.assertTrue(name.contains(message), "Assertion in postpaid success message");
    }

    @Then("I should see the {string} error message in pay new biller")
    public void iShouldSeeTheErrorMessageInPayNewBiller(String message) {
        String name = new PayBillSuccessfulPage().getPostpaidInsufficientError();
        logInfo(name);
        Assert.assertTrue(name.contains(message), "Assert in pay new biller");
    }

    @Then("I should see the pay bill page")
    public void iShouldSeeThePayBillPage() {
        String message = String.valueOf(new PayBillPage().getPayBillPage());
        Assert.assertTrue(message.contains("PREPAID"), "Assert in pay bill page");
    }

    @Then("I verify the amount text filed")
    public void iVerifyTheAmountTextFiled() {
        Assert.assertFalse(new PayBillPage().isAmountClickable(), "Assert in verify amount text field");
    }

    @Then("I verify the exchange rate for {string} for the amount {string}")
    public void iVerifyTheExchangeRateForForTheAmount(String country, String enteredAmount) {
        new HomePage().scroll("up");
        utils.waitForElement(getDriver(), "//*[@" + customData.getAttribute() + "='Confirm Transfer']", 90);
        String Amount = new TransferPayeePage().getAmountValue(country);
        String exchangeRate = new TransferPayeePage().getExchangeRate();
        float enteredValue = Float.parseFloat(enteredAmount);
        String actual_condition = String.format("%.2f", enteredValue);
        float countryValue = Float.parseFloat(Amount.replace(",", ""));
        if (exchangeRate.contains("=")) {
            String[] rate = exchangeRate.split(" ");
            float conversionAmount = Float.parseFloat(rate[3]);
            float comparisonAmount = conversionAmount * countryValue;
            String conversionAmount_format = String.format("%.2f", comparisonAmount);
            Assert.assertEquals(conversionAmount_format, actual_condition);
        } else {
            float exchangeRateValue = Float.parseFloat(exchangeRate);
            float comparisonAmount = countryValue * exchangeRateValue;
            String conversionAmount_format = String.format("%.2f", comparisonAmount);
            Assert.assertEquals(conversionAmount_format, actual_condition);
        }
    }

    @Then("I verify the exchange rate from {string} for the amount {string}")
    public void iVerifyTheExchangeRateFromForTheAmount(String country, String enteredAmount) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'Transfer')]", 90);
        String Amount = new TransferPayeePage().getAmountValue(country);
        String actualCondition = String.format("%.2f", Float.parseFloat(enteredAmount));
        String exchangeRate = new TransferPayeePage().getExchangeRate();
        float countryValue = Float.parseFloat(Amount.replace(",", ""));

        if (exchangeRate.contains("=")) {
            String[] rate = exchangeRate.split(" ");
            float conversionAmount = Float.parseFloat(rate[3]);
            float comparisonAmount = countryValue / conversionAmount;
            Assert.assertEquals(String.format("%.2f", comparisonAmount), actualCondition);
        } else {
            float exchangeRateValue = Float.parseFloat(exchangeRate);
            float comparisonAmount = countryValue / exchangeRateValue;
            Assert.assertEquals(String.format("%.2f", comparisonAmount), actualCondition);
        }
    }

    @Then("I should see the topUp failed message as {string}")
    public void iShouldSeeTheTopUpFailedMessageAs(String message) {
        String failedMessage = new TopUpPage().fetchFailedMessage();
        Assert.assertEquals(failedMessage, message);
    }

    @Then("I verify deactivate toggle is clickable")
    public void iVerifyDeactivateToggleIsClickable() {
        if (!new CardPage().fetchCardStatus().toUpperCase(Locale.ROOT).contains("WARM"))
            Assert.assertTrue(new DeactivateCardPage().isDeactivateToggleClickable(), "Assertion on deactivate toggle");
    }

    @Then("I should see the page as {string}")
    public void iShouldSeeThePageAs(String page) {
        String pageName = new WithdrawPage().fetchPageName(page);
        Assert.assertTrue(pageName.contains(page), "Assertion on Page navigation");
        logInfo("Page " + page + " is displayed");
    }

    @Then("I verify the selected card is {string}")
    public void iVerifyTheSelectedCardIs(String cardType) {
        Assert.assertTrue(new CardPage().fetchDetails().contains(cardType), "Assertion of selected card");
    }

    @Then("I should see the available balance of the card")
    public void iShouldSeeTheAvailableBalanceOfTheCard() {
        Assert.assertTrue(new WithdrawPage().withdrawFromDetails() > 0, "Assertion on available balance.");
    }

    @Then("I should see the canceled card amount transferred to Primary card {string}")
    public void iShouldSeeTheCanceledCardAmountTransferredToPrimaryCard(String number) throws InterruptedException {
        new CancelCardPage().selectCard(number);

        String balance = new CardPage().fetchDetails().split("BALANCE\n")[1];

        double actualBalance = Double.parseDouble(balance.split(" ")[0]
                .replaceAll(",", ""));

        logInfo("The actual balance in the card = " + actualBalance);

        Assert.assertTrue(actualBalance > customData.getCardBalance(), "Assertion on card balance after cancelling virtual card.");
    }

    @Then("I should see the message for card limit {string}")
    public void iShouldSeeTheMessageForCardLimit(String message) {
        Assert.assertTrue(String.valueOf(new CardLimitPage().getMessage(message)).contains(message),
                "Assertion of selected card");
    }

    @Then("I should see the successful message with details of added card")
    public void iShouldSeeTheSuccessfulMessageWithDetailsOfAddedCard() {
        Assert.assertTrue(String.valueOf(new AddNewCard().fetchSuccessMessage())
                        .contains("Your New Card is ready!"),
                "Assertion on added new card");
    }

    @Then("I should see the request {string} message")
    public void iShouldSeeTheConfirmMessage(String success) {
        InvestmentsPage investment = new InvestmentsPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(investment.getRequestMessage(success), success, "Assertion on success message");
        softAssert.assertEquals(investment.refNo().length(), 16, "The Ref No length is not 16");
        softAssert.assertEquals(Float.parseFloat(investment.currency().split(" ")[0]), customData.getEnteredAmount(), "Different amount is displaying");
        softAssert.assertEquals(investment.currency().split(" ")[1], customData.getPayFromCurrency(), "Different description is displaying");
        softAssert.assertTrue(customData.getPayFromCardDetails().contains(investment.payFrom()), "Different pay from card no is displaying");
        softAssert.assertTrue(customData.getPayToCardDetails().contains(investment.payTo()), "Different pay to card no is displaying");

        customData.setReferenceNo(investment.refNo());
        softAssert.assertAll();
    }

    @Then("I verify the done button field is not enabled")
    public void iVerifyTheDoneButtonFieldIsNotEnabled() {
        Assert.assertFalse(new InvestmentsPage().isAmountClickable(), "Done button for amount field is displaying");
    }

    @Then("I should see the transaction history for the today's date")
    public void iShouldSeeTheTransactionHistoryForTheDate() {
        String month = LocalDate.now().getMonth().toString();
        String date = month.charAt(0) + month.substring(1).toLowerCase() + " " + LocalDate.now().getDayOfMonth();

        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Transactions\"]", 60);

        List<String> transactionEntries = List.of(new InvestmentsPage().getTransactionWithDate(date));
        List<String> currentDateEntries = new ArrayList<>();

        transactionEntries.stream().filter(s -> s.contains(date)).forEach(log()::info);
        transactionEntries.stream().filter(s -> s.contains(date)).forEach(s -> currentDateEntries.add(s));

        if (currentDateEntries.size() > 0)
            Assert.assertTrue(currentDateEntries.get(0).contains(date), "Assertion on date in entries");
        else
            logInfo("No entry is displaying in transaction history");
    }

    @Then("I verify Next button is {}")
    public void iVerifyNextButtonIsEnabled(String result) {
        if (result.equalsIgnoreCase("disabled")) {
            Assert.assertFalse(new AddNewCard().isButtonEnabled(), "Assertion on next button disabled");
        } else if (result.equalsIgnoreCase("enabled")) {
            Assert.assertTrue(new AddNewCard().isButtonEnabled(), "Assertion on next button enabled");
            logInfo("next button is not clickable as expected");
        }
    }

    @Then("I should see the error message {string} for password/mobile")
    public void iShouldSeeTheErrorMessage(String message) {
        String xpath = "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", \"Password must have atleast\") or contains(@" + customData.getAttribute() + ", \"Password should be\") or contains(@" + customData.getAttribute() + ", \"Match\") or contains(@" + customData.getAttribute() + ", \"Mobile number\") or contains(@" + customData.getAttribute() + ", \"Alias\")]";

        utils.waitForElement(getDriver(), xpath, 30);

        String actualError = getDriver().findElement(By.xpath(xpath)).getAttribute(customData.getAttribute());

        Assert.assertEquals(actualError, message);
    }

    @Then("I should see the success pop-up {string}")
    public void iShouldSeeTheSuccessPopUp(String successText) {
        String xpath = "//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ", 'SUCCESS')]";
        utils.waitForElement(getDriver(), xpath, 15);
        String actualError = getDriver().findElement(By.xpath(xpath)).getAttribute(customData.getAttribute());
        Assert.assertEquals(actualError.replace("\n", " "), successText);
    }
}