package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.dashBoard.AccountsPage;
import com.qa.pages.capitalbank.dashBoard.DashboardPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import com.qa.pages.capitalbank.investment.ConfirmPage;
import com.qa.pages.capitalbank.investment.InvestmentsPage;
import com.qa.pages.capitalbank.termDeposit.TermDepositPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;


public class termDepositInvestmentsSteps extends ProjectBase {
    protected Map<String, String> tdDashboardDetails = new LinkedHashMap<>();

    @And("I navigate to investment option")
    public void iNavigateToInvestmentOption() {
        new InvestmentsPage().swipeToInvestment();
    }

    @When("I select {} option")
    public void iSelectOption(String value) {
        new InvestmentsPage().options(value);
    }

    @And("I enter amount as {} and description as {string} for Investments page")
    public void iEnterAmountAsAndDescriptionAsForInvestmentPage(String amount, String description) {
        InvestmentsPage investment = new InvestmentsPage();

        investment.enterAmount(amount);
        investment.amountDoneButton();
        customData.setEnteredAmount(Float.parseFloat(amount));

        investment.enterDescription(description);
        customData.setDescription(description);

        investment.nextButton();
    }

    @When("I select {} card and {} for {string}")
    public void iSelectCardFor(String from, String to, String options) throws InterruptedException {
        InvestmentsPage investment = new InvestmentsPage();
        investment.selectPayFromCard(from);

        customData.setPayFromCurrency(investment.payFromCard(from).split("\n")[2].split(" ")[1]);
        customData.setPayFromAmount(Float.parseFloat(investment.payFromCard(from).split("BALANCE\n")[1].split(" ")[0].replaceAll(",", "")));
        customData.setPayFromCardDetails(investment.payFromCard(from));

        logInfo("Pay From card currency: " + customData.getPayFromCurrency());
        logInfo("Pay From card amount: " + customData.getPayFromAmount());

        String element = investment.selectPayToCard(options, to);
        customData.setPayToCurrency(element.split("BALANCE\n")[1].split(" ")[1]);
        customData.setPayToAmount(Float.parseFloat(element.split("BALANCE\n")[1].split(" ")[0].replaceAll(",", "")));
        customData.setPayToCardDetails(element);
        logInfo("Pay to card currency: " + customData.getPayToCurrency());
        logInfo("Pay to card amount: " + customData.getPayToAmount());
    }

    @Then("I should verifying the details in the confirm page")
    public void iShouldVerifyingTheDetailsInTheConfirmPage() {
        SoftAssert softAssert = new SoftAssert();

        ConfirmPage confirm = new ConfirmPage();
        float conversionRate = 0;
        float updatedBalanceDebitCard = confirm.withDrawFromBalance();
        float availableBalanceDebitCard = confirm.withDrawFrom();
        float updatedBalanceCreditCard = confirm.withDrawToBalance();
        float availableBalanceCreditCard = confirm.withDrawTo();
        float finalAmount = Float.parseFloat(confirm.amount().split(" ")[0].replaceAll(",", ""));

        logInfo("Updated balance in Debit card : " + updatedBalanceDebitCard + "\n" +
                "Available balance in Debit card : " + availableBalanceDebitCard + "\n" +
                "Available balance in Credit card : " + availableBalanceCreditCard + "\n" +
                "Updated balance in Credit card : " + updatedBalanceCreditCard + "\n" +
                "Entered amount in the confirm page : " + finalAmount);

        softAssert.assertEquals(customData.getPayFromAmount(), availableBalanceDebitCard, "Before Debit amount are not equal");
        softAssert.assertEquals(customData.getPayToAmount(), availableBalanceCreditCard, "Before Credit amount are not equal");
        softAssert.assertEquals(Math.round(updatedBalanceDebitCard), Math.round(availableBalanceDebitCard - customData.getEnteredAmount()), "After Debit amount are not equal");

        if (customData.getPayFromCurrency().equals(customData.getPayToCurrency())) {
            softAssert.assertEquals(updatedBalanceCreditCard, availableBalanceCreditCard + customData.getEnteredAmount(), "After Credit amount are not equal");
            softAssert.assertEquals(confirm.description(), customData.getDescription(), "The entered description is not displaying");
            softAssert.assertEquals(confirm.amount().split(" ")[1], customData.getPayFromCurrency(), "The Currency are not equal");
        } else {
            conversionRate = confirm.conversionRate();
            softAssert.assertEquals(confirm.descriptionConversion(), customData.getDescription(), "The entered description is not displaying");
            softAssert.assertEquals(confirm.currency(), customData.getPayFromCurrency(), "The Currency are not equal");
        }

        // If the send currency in JOD then amount will have 3 decimal points
        // else it will be 2 decimal points
        if (customData.getPayFromCurrency().equals("JOD"))
            softAssert.assertEquals(String.format("%.3f", finalAmount), String.format("%.3f", customData.getEnteredAmount()),
                    "The entered amount is not equal");
        else
            softAssert.assertEquals(String.format("%.2f", finalAmount), String.format("%.2f", customData.getEnteredAmount()),
                    "The entered amount is not equal");

        // If the from CCY is JOD then we need to divide the amount / conversion rate
        // else we need to multiple the entered amount into conversion rate
        if (customData.getPayFromCurrency().equals("JOD") && !(customData.getPayToCurrency().equals("JOD"))) {
            customData.setConversionRate(customData.getEnteredAmount() / conversionRate);
            softAssert.assertEquals(Math.round(updatedBalanceCreditCard), Math.round(availableBalanceCreditCard + customData.getConversionRate()),
                    "After Credit amount are not equal");
        } else if (customData.getPayToCurrency().equals("JOD") && !(customData.getPayFromCurrency().equals("JOD"))) {
            customData.setConversionRate(customData.getEnteredAmount() * conversionRate);
            softAssert.assertEquals(Math.round(updatedBalanceCreditCard), Math.round(availableBalanceCreditCard + customData.getConversionRate()),
                    "After Credit amount are not equal");
        } else {
            customData.setConversionRate(0);
        }
        logInfo("The conversion rate is :" + customData.getConversionRate());
        softAssert.assertAll();
        confirm.confirm();
    }

    @And("I select pay from card {}")
    public void iSelectPayFromCard(String currency) throws InterruptedException {
        InvestmentsPage investment = new InvestmentsPage();
        investment.selectPayFromCard(currency);

        logInfo(investment.payFromCard(currency));

        customData.setPayFromCurrency(investment.payFromCard(currency).split("BALANCE\n")[1].split(" ")[1]);
        customData.setPayFromAmount(Float.parseFloat(investment.payFromCard(currency).split("BALANCE\n")[1].split(" ")[0].replaceAll(",", "")));
        customData.setPayFromCardDetails(investment.payFromCard(currency));

        logInfo("Pay From card currency: " + customData.getPayFromCurrency());
        logInfo("Pay From card amount: " + customData.getPayFromAmount());
    }

    @And("I select {string} pay to card {}")
    public void iSelectPayToCard(String options, String currency) {
        String element = new InvestmentsPage().selectPayToCard(options, currency);

        customData.setPayToCurrency(element.split("BALANCE\n")[1]
                .split(" ")[1]);
        customData.setPayToAmount(Float.parseFloat(element.split("BALANCE\n")[1]
                .split(" ")[0].replaceAll(",", "")));
        customData.setPayToCardDetails(element);

        logInfo("Pay to card currency: " + customData.getPayToCurrency());
        logInfo("Pay to card amount: " + customData.getPayToAmount());
    }

    @And("I click close button")
    public void iClickCloseButton() {
        new ConfirmPage().clickCloseButton();
    }

    @When("I click the confirm button after checking terms and condition")
    public void iClickTheConfirmButtonAfterCheckingTermsAndCondition() {
        new ConfirmPage().selectTC()
                .backButton()
                .confirm();
    }

    @Then("I should see the {string} amount in the pay from {} and pay to {} cards should get updated")
    public void iShouldSeeTheAmountInThePayFromAndPayToCardsShouldGetUpdated(String options, String payFrom, String payTo) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        InvestmentsPage investment = new InvestmentsPage().selectPayFromCard(payFrom);

        softAssert.assertEquals(Float.parseFloat(investment.payFromCard(payFrom).split("BALANCE\n")[1]
                        .split(" ")[0].replaceAll(",", "")),
                customData.getPayFromAmount() - customData.getEnteredAmount());

        String element = investment.selectPayToCard(options, payTo);

        if (customData.getConversionRate() > 0) {
            softAssert.assertEquals(Math.round(Float.parseFloat(element.split("BALANCE\n")[1]
                            .split(" ")[0].replaceAll(",", ""))),
                    Math.round(customData.getPayToAmount() + customData.getConversionRate()));
            logInfo(customData.getPayToAmount() + customData.getConversionRate());
        } else {
            softAssert.assertEquals(Math.round(Float.parseFloat(element.split("BALANCE\n")[1]
                            .split(" ")[0].replaceAll(",", ""))),
                    Math.round(customData.getPayToAmount() + customData.getEnteredAmount()));
            logInfo(customData.getPayToAmount() + customData.getConversionRate());
        }

        softAssert.assertAll();
    }

    @When("I navigate back to {} page")
    public void iNavigateBackToPage(String arg0) {
        ConfirmPage confirm = new ConfirmPage().confirm();

        String xpath = "//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ", 'Error')]";
        Instant timeout = Instant.now().plusSeconds(15);
        utils.waitForElement(getDriver(), xpath, 15);

        while (getDriver().findElements(By.xpath(xpath)).size() == 1) {
            if (getDriver().findElements(By.xpath(xpath)).size() == 0)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Error message is not displaying after 15 seconds");
        }
        confirm.backButton().backButton();
    }

    @And("I select {string} new pay to card {}")
    public void iSelectNewPayToCard(String option, String currency) {
        String element = new InvestmentsPage().selectPayToCardUpdate(option, customData.getPayToCardDetails(), currency);

        customData.setPayToCurrency(element.split("BALANCE\n")[1].split(" ")[1]);
        customData.setPayToAmount(Float.parseFloat(element.split("BALANCE\n")[1]
                .split(" ")[0].replaceAll(",", "")));

        logInfo("Pay to card currency: " + customData.getPayToCurrency());
        logInfo("Pay to card amount: " + customData.getPayToAmount());

        customData.setPayToCardDetails(element);
    }

    @Then("I enter invalid amount as {string}")
    public void iEnterInvalidAmountAs(String amount) {
        new InvestmentsPage().enterAmount(amount);
    }

    @And("I should see the reference no in latest transactions")
    public void iShouldSeeTheReferenceNoInLatestTransactions() throws InterruptedException {
        InvestmentsPage investment = new InvestmentsPage();
        SoftAssert softAssert = new SoftAssert();

        investment.selectTransaction();
        softAssert.assertEquals(investment.latestTransactions(customData.getReferenceNo()).replaceAll("\n", " ").split(" ")[4], customData.getReferenceNo(), "Assertion on Ref no in last transaction");
        softAssert.assertEquals(investment.latestTransactions(customData.getReferenceNo()).replaceAll("\n", " ").split(" ")[7], customData.getPayToCurrency(), "Assertion on currency in last transaction");

        if (customData.getConversionRate() > 0)
            softAssert.assertEquals(String.format("%.2f", customData.getConversionRate()), String.format("%.2f", Float.parseFloat(investment.latestTransactions(customData.getReferenceNo()).replaceAll("\n", " ").split(" ")[6])), "Assertion on amount in last transaction");
        else
            softAssert.assertEquals(String.format("%.2f", customData.getEnteredAmount()), String.format("%.2f", Float.parseFloat(investment.latestTransactions(customData.getReferenceNo()).replaceAll("\n", " ").split(" ")[6])), "Assertion on amount in last transaction");

        softAssert.assertAll();
    }

    @And("I click on Term Deposits in dashboard")
    public void iClickOnTermDepositsInDashboard() {
        new DashboardPage().clickTermsDeposits();
    }

    @When("I click on create new deposits menu")
    public void iClickOnCreateNewDepositsMenu() {
        new TermDepositPage().clickOnCreateNewDeposit();
    }

    @And("I select the deposit account with {string} currency")
    public void iSelectTheDepositAccountWithCurrency(String currency) {
        new TermDepositPage().selectCard(currency);
    }

    @And("I click on get started button")
    public void iClickOnGetStartedButton() {
        new TermDepositPage().clickOnGetStartedButton();
    }

    @And("I select the funding account with card number {string}")
    public void iSelectTheFundingAccountWithCardNumber(String cardNumber) {
        new TermDepositPage().selectFundingCardWithNumber(cardNumber);
    }

    @And("I select the deposit period as {string}")
    public void iSelectTheDepositPeriodAs(String depositPeriod) {
        new TermDepositPage().swipeToDetails()
                .clickOnDepositPeriod(depositPeriod);
    }

    @And("I select the deposit details with credit account number {string}")
    public void iSelectTheDepositDetailsWithCreditAccountNumber(String cardNumber) {
        new TermDepositPage().clickDepositDetails()
                .selectCreditAccountWithNumber(cardNumber);
    }

    @And("I select {string} radio button for Auto renew upon maturity")
    public void iSelectRadioButtonForAutoRenewUponMaturity(String radioButton) {
        new HomePage().scroll("up", 0.50);
        new TermDepositPage().clickRadioButton(radioButton);
        customData.setAutoRenewal(radioButton);
    }

    @And("I select the type of auto renew as {string}")
    public void iSelectTheTypeOfAutoRenewAs(String typeOfRenew) {
        new HomePage().scroll("up");
        new TermDepositPage().clickRadioButton(typeOfRenew);
    }

    @Then("I verify the total amount at maturity for the amount {string}")
    public void iVerifyTheTotalAmountAtMaturityForTheAmount(String enteredAmount) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Confirm Transfer\"]", 90);

        double enteredValue = Double.parseDouble(enteredAmount.replace(",", ""));
        double interestValue = Double.parseDouble(new TermDepositPage().getInterestAmount().replace(",", ""));
        double totalValue = Double.parseDouble(new TermDepositPage().getTotalAmount().replace(",", ""));

        double totalInterestAmount = Double.parseDouble(new TermDepositPage().fetchTotalInterestAmount().replace(",", ""));
        double comparisonAmount = enteredValue + interestValue;

        logInfo("Total amount at maturity = " + comparisonAmount);

        Assert.assertEquals(String.format("%.2f", comparisonAmount), String.format("%.2f", totalValue),
                "Assertion on TD Maturity amount");

        customData.setMaturityAmount(totalInterestAmount + enteredValue);
    }

    @Then("I should see the message for term Deposit {string} with details")
    public void iShouldSeeTheMessageForTermDepositWithDetails(String message) {
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Your Term Deposit is created successfully!\"]//..//" + customData.getViewAttribute();
        else
            xpath = "//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ",\"successfully!\")]";

        List<String> depositDetails = new ArrayList<>();

        utils.waitForElement(getDriver(), xpath, 90);

        if (getDriver() instanceof AndroidDriver) {
            for (int i = 2; i <= 7; ) {
                String key = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("content-desc");
                i = i + 1;
                String value = getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("content-desc");
                depositDetails.add(key + " - " + value);

                i = i + 1;
            }
        } else {
            for (int i = 1; i < 6; ) {
                String key = getDriver().findElement(By.xpath(xpath + "//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute("name");
                i = i + 1;
                String value = getDriver().findElement(By.xpath(xpath + "//following-sibling::XCUIElementTypeStaticText[" + i + "]")).getAttribute("name");
                depositDetails.add(key + " - " + value);

                i = i + 1;
            }

        }

        depositDetails.forEach(log()::info);

        Assert.assertTrue(new TermDepositPage().fetchSuccessMessage().replace("\n", " ")
                .contains(message), "Assertion on Term deposit Successful");

        customData.setAccountNumber(new TermDepositPage().fetchCardNumber());
    }

    @And("I select the funding account")
    public void iSelectTheFundingAccount() {
        new TermDepositPage().clickOnFundingAccount()
                .clickOnNextButton();
    }

    @And("I fetch the amount from the funding account card")
    public void iFetchTheAmountFromTheFundingAccountCard() {
        customData.setCardBalance(Double.parseDouble(new TermDepositPage().fetchCardValue()
                .split("BALANCE\n")[1]
                .split(" ")[0].replace(",", "")));

        logInfo("The total available balance in card is " + customData.getCardBalance());
    }

    @Then("I should see the amount {string} reduced from the the funding account card")
    public void iShouldSeeTheAmountReducedFromTheTheFundingAccountCard(String amount) {
        double enteredValue = Double.parseDouble(amount);
        String balanceValue = new TermDepositPage().fetchCardValue().split("BALANCE\n")[1];

        double actualBalance = Double.parseDouble(balanceValue.split(" ")[0]
                .replaceAll(",", ""));

        logInfo("The actual balance in the card after transaction of " + amount + " = " + actualBalance);

        Assert.assertEquals(Math.round(customData.getCardBalance() - enteredValue), Math.round(actualBalance), "After Debit amount are not equal");
    }

    @And("I click on account menu from the term deposit tab")
    public void iClickOnAccountMenuFromTheTermDepositTab() {
        new DashboardPage().clickOnAccountMenu();
    }

    @And("I should see the {} account details in the investments tab")
    public void iShouldSeeTheAccountDetailsInTheInvestmentsTab(String currency) throws InterruptedException {
        InvestmentsPage investment = new InvestmentsPage();
        SoftAssert softAssert = new SoftAssert();

        String accountDetails = investment.selectPayFromCard(currency).payFromCard(currency);
        logInfo("Account Details: " + accountDetails);

        String accountsTab = investment.accountDetails();
        logInfo("Account Details: " + accountsTab);

        softAssert.assertTrue(accountDetails.contains(accountsTab.split(" ")[2]), "Assertion on card no");
        softAssert.assertTrue(accountDetails.contains(accountsTab.split(" ")[5]), "Assertion on amount");
        softAssert.assertTrue(accountDetails.contains(accountsTab.split(" ")[6]), "Assertion on card currency");

        softAssert.assertAll();
    }

    @When("I click on Transaction tab")
    public void iClickOnTransactionTab() {
        new InvestmentsPage().selectTransaction();
    }

    @And("I click on view more button")
    public void iClickOnViewMoreButton() {
        new InvestmentsPage().viewMore();
    }

    @And("I click on next button to navigate to confirm page")
    public void iClickOnNextButtonToNavigateToConfirmPage() {
        new TermDepositPage().clickOnNextButton();
    }

    @Then("I should verify the created Term deposit")
    public void iShouldVerifyTheCreatedTermDeposit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Instant timeout = Instant.now().plusSeconds(360);

        String cardValue = new TermDepositPage().fetchTermDepositValue();

        while (!cardValue.contains(customData.getAccountNumber())) {
            new TermDepositPage().clickForwardArrowForCurrency();
            Thread.sleep(1000);
            cardValue = new TermDepositPage().fetchTermDepositValue();
            if (cardValue.contains(customData.getAccountNumber()))
                break;

            if (Instant.now().isAfter(timeout)) {
                logInfo("Term deposit is not created");
                break;
            }
        }

        logInfo("Term deposit is created");

        String cardNumber = new TermDepositPage().fetchTermDepositValue().split("NUMBER: ")[1].split(" ")[0]
                .replaceAll(",", "");
        softAssert.assertEquals(cardNumber, customData.getAccountNumber(), "Assertion on created term deposit");


        List<String> termDepositDetails = List.of(new TermDepositPage().fetchTermDepositDetails().replaceAll("\n", "-").split("-"));


        for (int i = 0; i <= 18; i++) {
            int j = i + 1;
            tdDashboardDetails.put(termDepositDetails.get(i), termDepositDetails.get(j));
        }

        for (int i = 25; i <= 27; i++) {
            int j = i + 1;
            tdDashboardDetails.put(termDepositDetails.get(i), termDepositDetails.get(j));
        }

        if (termDepositDetails.get(21).equals("Auto Renewal")) {
            tdDashboardDetails.put(termDepositDetails.get(20), "nil");
            tdDashboardDetails.put(termDepositDetails.get(21), termDepositDetails.get(22));
            tdDashboardDetails.put(termDepositDetails.get(23), termDepositDetails.get(24));
        } else {
            tdDashboardDetails.put(termDepositDetails.get(20), termDepositDetails.get(21));
            tdDashboardDetails.put(termDepositDetails.get(22), termDepositDetails.get(23));
            tdDashboardDetails.put(termDepositDetails.get(24), "nil");
        }

        softAssert.assertEquals(customData.getAutoRenewal(), tdDashboardDetails.get("Auto Renewal"), "Assertion on Auto renewal");

        softAssert.assertEquals(customData.getAccountNumber(), tdDashboardDetails.get("Account Number"), "Assertion on term deposit account number");

        Assert.assertEquals(String.format("%.1f", customData.getMaturityAmount()), String.format("%.1f", Double.parseDouble(tdDashboardDetails.get("Maturity Amount").replace(",", ""))),
                "Assertion on TD Maturity amount");

        softAssert.assertAll();
    }

    @And("I should see the transaction {string} with {} amount {string} in the transaction history with sunday's date in {} tab")
    public void iShouldSeeTheTransactionWithDebitAmountInTheTransactionHistoryWithSundaySDateInAccountsTab(String transactionEntry, String debitOrCredit, String amount, String tab) throws InterruptedException {
        AccountsPage accountsPage = new AccountsPage();

        List<String> expectedEntries = new ArrayList<>();

        if (tab.equalsIgnoreCase("accounts"))
            accountDetails = accountsPage.fetchCurrentAccountDetails();

        List<String> actualEntries = accountsPage.clickTransactions()
                .getLatestTransactionsEntries();

        Thread.sleep(1500);
        accountsPage.moveToAccountsTab();

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            int daysToAdd = (dayOfWeek == DayOfWeek.FRIDAY) ? 2 : 1;
            String transactionDate = LocalDate.now().plusDays(daysToAdd).getMonth().toString() + " " + LocalDate.now().plusDays(daysToAdd).getDayOfMonth() + ", " + LocalDate.now().plusDays(daysToAdd).getYear();
            if (tab.equalsIgnoreCase("accounts"))
                expectedEntries.add(transactionDate);
            logInfo("Today is weekend");
            logInfo("TransactionDate = " + transactionDate);
        } else {
            logInfo("Today is not Weekend");
            String transactionDate = LocalDate.now().getMonth().toString() + " " + LocalDate.now().getDayOfMonth() + ", " + LocalDate.now().getYear();
            if (tab.equalsIgnoreCase("accounts"))
                expectedEntries.add(transactionDate);
        }

        expectedEntries.add(transactionEntry.toUpperCase(Locale.ROOT));

        if (debitOrCredit.equalsIgnoreCase("debit"))
            expectedEntries.add("-" + amount);
        else
            expectedEntries.add(amount);

        logInfo("Expected Transaction entries --> ");
        expectedEntries.forEach(log()::info);

        for (String expectedEntry : expectedEntries) {
            Assert.assertTrue(actualEntries.contains(expectedEntry), "Assertion on transaction entry");
        }

        logInfo("Transaction entry is created in " + tab + " transactions");

        new HomePage().scroll("down", 0.75);
    }
}