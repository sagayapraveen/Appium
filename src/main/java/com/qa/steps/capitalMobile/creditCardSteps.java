package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.HomePage;
import com.qa.pages.capitalbank.cards.CardPage;
import com.qa.pages.capitalbank.creditcards.CreditCardPaymentPage;
import com.qa.pages.capitalbank.creditcards.TransfersCardPage;
import com.qa.pages.capitalbank.creditcards.TransfersToOwnAccountPage;
import com.qa.pages.capitalbank.dashBoard.AccountsPage;
import com.qa.pages.capitalbank.transfers.TransfersPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class creditCardSteps extends ProjectBase {
    protected double fcyTransactionAmount;
    protected Map<String, String> cardDashboardDetails = new HashMap<>();
    private String cardBalancePostTransaction;

    @And("I click the cards in transfers page")
    public void iClickTheCardsInTransfersPage() {
        new TransfersPage().clickCards();
    }

    @And("I select the Own account from the transfers page")
    public void iSelectTheOwnAccountFromTheTransfersPage() {
        new TransfersCardPage().clickOwnAccount();
    }

    @And("I select the current account for transfers Pay to")
    public void iSelectTheCurrentAccountForTransfersPayTo() {
        new TransfersCardPage().selectCurrentAccount();
    }

    @When("I input the amount {string} for the Transfers to Own account")
    public void iInputTheAmountForTheTransfersToOwnAccount(String amount) {
        if (amount.equalsIgnoreCase("random"))
            amount = utils.getRandomNumber(2);

        customData.setTransactionAmount(amount);
        new TransfersToOwnAccountPage().setTransferAmount(amount)
                .selectOk();
    }

    @And("I fetch the Pay to card details")
    public void iFetchThePayToCardDetails() {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Pay to']", 30);
        else
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Pay to']", 30);
        new HomePage().scroll("up");

        customData.setPayToAccountBalance(new TransfersToOwnAccountPage().fetchPayToAccountBalance());
    }

    @And("I confirm the transfer from credit card")
    public void iConfirmTheTransferFromCreditCard() {
        TransfersCardPage transfersCardPage = new TransfersCardPage();

        transfersCardPage.clickNext();

        logInfo("Pay From details --> " + transfersCardPage.getConfirmPayFromDetails());
        logInfo("Pay To details --> " + transfersCardPage.getConfirmPayToDetails());

        transfersCardPage.confirmTransfer();
    }

    @Then("I should see the success message {string} for credit card transfers")
    public void iShouldSeeTheSuccessMessageForCreditCardTransfers(String context) {
        logInfo(new TransfersCardPage().fetchSuccessfulMessage(context));
    }

    @When("I navigate to accounts tab from cards tab")
    public void iNavigateToAccountsTabFromCardsTab() {
        new CardPage().navigateToAccountsTab();
    }

    @Then("I should see the amount {} is {} from the Card balance")
    public void iShouldSeeTheAmountIsReducedFromTheCardBalance(String amount, String operation) {
        DecimalFormat df = new DecimalFormat("#.#");
        utils.waitForElement(getDriver(), "//" + customData.getImageAttribute() + "[@" + customData.getAttribute() + "='Transfers']", 60);

        double transactionAmount = 0;
        double expectedValue = 0;

        transactionAmount = amount.equalsIgnoreCase("random") ?
                Double.parseDouble(customData.getTransactionAmount()) :
                Double.parseDouble(amount);

        List<String> cardDetails = List.of(new CardPage().fetchCardDetails().toUpperCase(Locale.ROOT).split("\n"));

        for (int i = 0; i <= cardDetails.size(); i++) {
            if (cardDetails.get(i).contains("TOTAL ACCOUNT BALANCE")) {
                cardBalancePostTransaction = cardDetails.get(i + 1);
                break;
            }
        }

        double actualValue = Double.parseDouble(df.format(Double.parseDouble(cardBalancePostTransaction.split(" ")[0].replace(",", ""))));

        if (operation.equalsIgnoreCase("reduced"))
            expectedValue = customData.getCardBalanceBeforeTransaction() - transactionAmount;
        else if (operation.equalsIgnoreCase("increased"))
            expectedValue = customData.getCardBalanceBeforeTransaction() + transactionAmount;

        Assert.assertEquals(df.format(actualValue), df.format(expectedValue), "Assertion after the transfer from Credit card");

        logInfo("Card balance " + customData.getCardBalanceBeforeTransaction() + " is " + operation + " to "
                + customData.getTransactionAmount() + ". Current Card balance is " + cardBalancePostTransaction);
    }

    @Then("I should see the transaction {string} with {} amount {string} in the transaction history with today's date in {} tab")
    public void iShouldSeeTheTransactionWithAmountInTheTransactionHistoryWithTodaySDate(String transactionEntry, String debitOrCredit, String amount, String tab) throws InterruptedException {
        AccountsPage accountsPage = new AccountsPage();

        List<String> expectedEntries = new ArrayList<>();

        if (tab.equalsIgnoreCase("accounts"))
            accountDetails = accountsPage.fetchCurrentAccountDetails();

        List<String> actualEntries = accountsPage.clickTransactions()
                .getLatestTransactionsEntries();

        Thread.sleep(1500);
        accountsPage.moveToAccountsTab();

        String transactionDate = LocalDate.now().getMonth().toString() + " " + LocalDate.now().getDayOfMonth() + ", " + LocalDate.now().getYear();

        expectedEntries.add(transactionEntry.toUpperCase(Locale.ROOT));

        if (amount.equalsIgnoreCase("random JOD"))
            amount = customData.getTransactionAmount();
        else if (amount.equalsIgnoreCase("exchanged")) {
            if (exchangeRate.contains("=") || exchangeRate.contains(" "))
                exchangeAmount = Double.parseDouble(exchangeRate.split("=")[1].trim().split(" ")[0].trim());
            else exchangeAmount = Double.parseDouble(exchangeRate);

            if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
                fcyTransactionAmount = transactionAmount * exchangeAmount;
            else if (customData.getPayToCurrency().equalsIgnoreCase("JOD"))
                fcyTransactionAmount = transactionAmount / exchangeAmount;
            else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP"))
                fcyTransactionAmount = transactionAmount / exchangeAmount;
            else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                    fcyTransactionAmount = transactionAmount * exchangeAmount;
                else fcyTransactionAmount = transactionAmount / exchangeAmount;
            } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                if (customData.getPayToCurrency().equalsIgnoreCase("AED"))
                    fcyTransactionAmount = transactionAmount / exchangeAmount;
                else fcyTransactionAmount = transactionAmount * exchangeAmount;
            } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED"))
                fcyTransactionAmount = transactionAmount * exchangeAmount;

            if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
                amount = String.format("%.3f", fcyTransactionAmount) + " " + customData.getPayFromCurrency();
            else
                amount = String.format("%.2f", fcyTransactionAmount) + " " + customData.getPayFromCurrency();
        }

        customData.setExchangedTransactionAmount(fcyTransactionAmount);

        logInfo("Exchanged amount expected to debit in Account is " + fcyTransactionAmount);

        if (debitOrCredit.equalsIgnoreCase("debit"))
            expectedEntries.add("-" + amount);
        else
            expectedEntries.add(amount);

        if (tab.equalsIgnoreCase("accounts"))
            expectedEntries.add(transactionDate);

        logInfo("Expected Transaction entries --> ");
        expectedEntries.forEach(log()::info);

        for (String expectedEntry : expectedEntries) {
            Assert.assertTrue(actualEntries.contains(expectedEntry), "Assertion on transaction entry --> " + expectedEntry);
        }

        logInfo("Transaction entry is created in " + tab + " transactions");

        new HomePage().scroll("down", 0.75);
    }

    @And("I should see the amount {} is {} from the current account balance after transaction")
    public void iShouldSeeTheAmountIsAddedFromTheCurrentAccountBalance(String value, String operation) {
        if (customData.getPayFromCurrency() == null)
            customData.setPayFromCurrency("JOD");

        DecimalFormat df = new DecimalFormat("#.##");
        double transactionAmount;
        double expectedAmount = 0;

        if (value.equalsIgnoreCase("exchanged"))
            transactionAmount = customData.getExchangedTransactionAmount();
        else transactionAmount = Double.parseDouble(value);

        List<String> accountDetails = List.of(new AccountsPage().fetchCurrentAccountDetails().toUpperCase(Locale.ROOT).split("\n"));

        accountDetails.forEach(log()::info);

        for (int i = 0; i < accountDetails.size(); i++) {
            if (accountDetails.get(i).contains("TOTAL ACCOUNT BALANCE")) {
                customData.setTotalAccountBalance(accountDetails.get(i + 1));
                break;
            }
        }

        double actualAmount = Double.parseDouble(customData.getTotalAccountBalance().split(" ")[0].replace(",", ""));

        logInfo("Account balance before transaction is " + customData.getAccountBalanceBeforeTransaction());
        logInfo("Exchanged amount to debit/credit in Account is " + fcyTransactionAmount);

        if (operation.equalsIgnoreCase("increased"))
            expectedAmount = customData.getAccountBalanceBeforeTransaction() + transactionAmount;
        else if (operation.equalsIgnoreCase("reduced"))
            expectedAmount = customData.getAccountBalanceBeforeTransaction() - transactionAmount;

        Assert.assertEquals(df.format(actualAmount), df.format(expectedAmount));

        logInfo("Total Account balance " + customData.getAccountBalanceBeforeTransaction() + " is " + operation + " "
                + Double.parseDouble(df.format(transactionAmount)) + ". Current Account balance is " + customData.getTotalAccountBalance());
    }

    @When("I click the Used Balance tab")
    public void iClickTheUsedBalanceTab() {
        new CardPage().clickUsedBalance();
    }

    @And("I click the settle card now from Used Balance menu")
    public void iClickTheSettleCardNowFromUsedBalanceMenu() {
        new CreditCardPaymentPage().settleCardNow();
    }

    @And("I click the settle card")
    public void iClickTheSettleCard() {
        new CardPage().clickSettleCard();
    }

    @And("I enter the {string} in Any amount field")
    public void iEnterTheInAnyAmountField(String amount) {
        if (amount.equalsIgnoreCase("random")) {
            amount = utils.getRandomNumber(2);

            if (amount.equals("00"))
                amount = utils.getRandomNumber(2);
            if (amount.startsWith("0"))
                amount = amount.replaceAll("0", "");
        }

        customData.setTransactionAmount(amount);

        logInfo("Transaction amount is set as " + amount);

        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Credit Card Payment']", 30);
        transactionAmount = Double.parseDouble(amount);

        CreditCardPaymentPage creditCardPaymentPage = new CreditCardPaymentPage();

        String payTo = creditCardPaymentPage.getConfirmPayToDetails();

        logInfo("Pay From details --> " + creditCardPaymentPage.fetchPayFromCard());
        logInfo("Pay To details --> " + payTo);

        customData.setPayToCurrency(payTo.substring(payTo.length() - 3));

        creditCardPaymentPage.setAnyAmount(amount)
                .selectOk();
    }

    @And("I confirm the credit card payment")
    public void iConfirmTheCreditCardPayment() {
        CreditCardPaymentPage creditCardPaymentPage = new CreditCardPaymentPage();

        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Confirm Credit Card Payment']", 30);

        String confirmationDetails = creditCardPaymentPage.getConfirmationDetails().toUpperCase();

        if (!customData.getPayToCurrency().equalsIgnoreCase(customData.getPayFromCurrency()))
            Assert.assertTrue(confirmationDetails.contains("EXCHANGE RATE"));

        if (confirmationDetails.contains("EXCHANGE RATE")) {
            exchangeRate = confirmationDetails.split("EXCHANGE RATE")[1];
            logInfo(exchangeRate);
        }

        logInfo(confirmationDetails.replaceAll("\n", "\t"));

        creditCardPaymentPage.confirm();
    }

    @And("I click the payment history tab for credit card")
    public void iClickThePaymentHistoryTabForCreditCard() {
        new CreditCardPaymentPage().paymentHistory();
    }

    @Then("I should see the {string} with the amount {string} in the payment history with today's date")
    public void iShouldSeeTheWithTheAmountInThePaymentHistoryWithTodaySDate(String transactionDescription, String transactionAmount) {
        if (transactionAmount.equalsIgnoreCase("random JOD"))
            transactionAmount = customData.getTransactionAmount() + ".000 JOD";

        List<String> transactions = new CreditCardPaymentPage().getPaymentHistory();

        String transactionDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")).toUpperCase();

        logInfo("Expected Entries in payment history --> " + transactionDescription
                + "\t" + transactionAmount
                + "\t" + transactionDate);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(transactions.contains(transactionDescription), "Assertion on transaction description");
        softAssert.assertTrue(transactions.contains(transactionAmount), "Assertion on transaction amount");
        softAssert.assertTrue(transactions.contains(transactionDate), "Assertion on transaction date");

        softAssert.assertAll();

        logInfo("Transaction entry is created in the Payment history tab");
    }

    @And("I fetch the all Card details from the card dashboard")
    public void iFetchTheAllCardDetailsFromTheCardDashboard() throws InterruptedException {
        List<String> cardDetails = new CardPage().getAllCardAccountDetails();

        cardDetails.forEach(log()::info);

        for (String cardDetail : cardDetails) {
            if (cardDetail.contains("JOD"))
                customData.setJodCardAccountDetails(cardDetail);
            else if (cardDetail.contains("AED"))
                customData.setAedCardAccountDetails(cardDetail);
            else if (cardDetail.contains("USD"))
                customData.setUsdCardAccountDetails(cardDetail);
            else if (cardDetail.contains("GBP"))
                customData.setGbpCardAccountDetails(cardDetail);
            else if (cardDetail.contains("EUR"))
                customData.setEurCardAccountDetails(cardDetail);
        }

        new CardPage().backToHome(cardDetails.size());
    }

    @Then("the transfers option should be {}")
    public void theTransfersOptionShouldBe(String action) {
        if (action.equalsIgnoreCase("clickable")) {
            Assert.assertTrue(new CardPage().isTransfersClickable());
            logInfo("Transfers option is clickable");
        } else if (action.equalsIgnoreCase("not-clickable")) {
            Assert.assertFalse(new CardPage().isTransfersClickable());
            logInfo("Transfers option is not clickable");
        }
    }

    @And("I change the Pay from account to {} account")
    public void iChangeThePayFromAccountToUSDAccount(String currency) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Credit Card Payment']", 90);

        customData.setPayFromCurrency(currency);

        new CreditCardPaymentPage().selectCardWithCurrency(currency);
    }

    @Then("I should see the updated card balance in Used Balance Tab")
    public void iShouldSeeTheUpdatedCardBalanceInUsedBalanceTab() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Credit Card Info']", 30);

        Assert.assertEquals(new CreditCardPaymentPage().getBalanceRemaining(), cardBalancePostTransaction);

        logInfo("Used balance tab is updated after card payment");
    }

    @And("I change the card to {} card in Used balance tab")
    public void iChangeTheCardToCardInUsedBalanceTab(String currency) throws InterruptedException {
        new CardPage().selectCardWithCurrency(currency);
    }

    @When("I fetch the Card dashboard details from the card dashboard")
    public void iFetchTheCardDashboardDetailsFromTheCardDashboard() {
        List<String> details = List.of(new CardPage().clickOnCardDetails().getEntireCardAllDetails().split("\n"));

        for (int i = 2; i < details.size() - 1; i++) {
            cardDashboardDetails.put(details.get(i), details.get(i + 1));
            i += 1;
        }

        new HomePage().scroll("down", 0.25);
    }

    @Then("I should see the {string} as {string} in card details")
    public void iShouldSeeTheAsInCardDetails(String key, String value) {
        if (key.equalsIgnoreCase("Last Payment"))
            value = value.split(" ")[0];
        if (value.contains("Card Balance"))
            value = customData.getCreditCardTotalAccountBalance().split(" ")[0];

        Assert.assertEquals(cardDashboardDetails.get(key), value);
    }

    @Then("I should see the focused {string} for the {string}")
    public void iShouldSeeTheFocusedForThe(String value, String field) {
        Assert.assertTrue(getDriver().findElement(By.xpath
                        ("//" + customData.getViewAttribute() + "[contains(@text, '" + field + "')]"))
                .getAttribute("focused").equalsIgnoreCase(value));
    }

    @And("the card middle 6 digit should be masked")
    public void theCardMiddleDigitShouldBeMasked() {
        String cardNumber = customData.getMaskedCreditCardNumber();
        String first6 = cardNumber.substring(0, 6);
        String middle = cardNumber.replaceAll(first6, "").substring(0, 6);
        String last4 = cardNumber.substring(12);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(customData.getMaskedCreditCardNumber(), cardDashboardDetails.get("Card No."));
        softAssert.assertFalse(first6.matches("[a-zA-Z]+"));
        softAssert.assertTrue(first6.matches("[0-9]+"));
        softAssert.assertEquals(middle, "XXXXXX");
        softAssert.assertFalse(last4.matches("[a-zA-Z]+"));
        softAssert.assertTrue(last4.matches("[0-9]+"));

        softAssert.assertAll();
    }
}
