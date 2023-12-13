package com.qa.steps.blink;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.MyAccountPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BlinkMyAccountSteps extends ProjectBase {

    @And("I click on home button")
    public void iClickOnHomeButton() {
        new MyAccountPage().homeButton();
    }

    @Then("I should see account details of {string} IBAN {string}")
    public void iShouldSeeAccountDetailsOf(String account, String IBAN) {
        SoftAssert softAssert = new SoftAssert();
        String accountDetails = new MyAccountPage().getAccountDetails();

        softAssert.assertTrue(accountDetails.contains(account), "Assertion in my account");
        softAssert.assertTrue(accountDetails.contains(IBAN), "Assertion in my account");

        softAssert.assertAll();
    }

    @And("I swipe the screen to see account details")
    public void iSwipeTheScreenToSeeAccountDetails() {
        new HomePage().scroll("down", 0.50);
    }

    @Then("I should see account approved date details {string}")
    public void iShouldSeeAccountApprovedDateDetails(String date) {
        Assert.assertTrue(new MyAccountPage().getAccountActivationDate().contains(date), "Assertion in account page");
    }

    @And("I click on refresh button")
    public void iClickOnRefreshButton() {
        new MyAccountPage().clickOnRefresh();
    }

    @Then("I should see the balance {string}")
    public void iShouldSeeTheBalance(String balance) {
        Assert.assertTrue(new MyAccountPage().getAccountDetails().contains(balance), "Assertion in My account page");
    }

    @And("I click on add money in my accounts page")
    public void iClickOnAddMoneyInMyAccountsPage() {
        new MyAccountPage().clickOnAddMoney();
    }

    @And("I click on {string} in add money page")
    public void iClickOnInAddMoneyPage(String request) {
        new MyAccountPage().clickOnRequestMoney(request);
    }

    @Then("I should redirect to {string} page")
    public void iShouldRedirectToPage(String page) {
        Assert.assertTrue(new MyAccountPage().requestMoneyPage().contains(page), "Assertion request money page");
    }

    @And("I swipe screen to see account details")
    public void iSwipeScreenToSeeAccountDetails() {
        new HomePage().scroll("up", 0.50);
    }

    @And("I search the transaction {string} in transaction history")
    public void iSearchTheTransactionInTransactionHistory(String search) {
        new MyAccountPage().searchTransaction(search);
    }

    @Then("I should see {string} in transaction history")
    public void iShouldSeeInTransactionHistory(String history) {
        Assert.assertTrue(new MyAccountPage().getTransactionDetails().contains(history), "Assertion on transaction History");
    }

    @And("I click on the transaction period button transaction page")
    public void iClickOnTheTransactionPeriodButtonTransactionPage() {
        new MyAccountPage().transactionButton();
    }

    @Then("I should see the transaction period {string}")
    public void iShouldSeeTheTransactionPeriod(String period) {
        List<String> values = new MyAccountPage().getTransactionPeriod();

        Assert.assertTrue(values.contains(period), "Assertion on transaction period");
        Assert.assertTrue(values.contains("Last 3 months"), "Assertion on transaction period");
        Assert.assertTrue(values.contains("Last 6 months"), "Assertion on transaction period");
    }

    @And("I click on download button in transaction history page")
    public void iClickOnDownloadButtonInTransactionHistoryPage() {
        new MyAccountPage().clickOnDownloadButton();
    }

    @And("I select month to download the statement")
    public void iSelectMonthToDownloadTheStatement() {
        new MyAccountPage().selectMonth();
    }

    @Then("I should see {string} of the account")
    public void iShouldSeeOfTheAccount(String statement) {
        Assert.assertTrue(new MyAccountPage().getStatement().contains(statement), "Assertion in Account statement");
    }

    @And("I select the transaction period {string}")
    public void iSelectTheTransactionPeriod(String period) {
        new MyAccountPage().clickOnTransactionPeriod(period);
    }

    @Then("I should see the transaction history data")
    public void iShouldSeeTheTransactionHistoryData() {
        Assert.assertTrue(new MyAccountPage().getTransactionHist0ryDetails() > 0, "Assertion on transaction history");
    }

    @And("I click back button on way to add account page")
    public void iClickBackButtonOnWayToAddAccountPage() {
        new MyAccountPage().clickOnBackButton();
    }

    @When("I click on tick button in account statement")
    public void iClickOnTickButtonInAccountStatement() {
        new MyAccountPage().clickOnOkButton();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String value) {
        Assert.assertTrue(new MyAccountPage().addMoneyMessage(value).contains(value), "Assertion on Request money page");
    }
}