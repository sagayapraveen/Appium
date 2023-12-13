package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.cards.CardPage;
import com.qa.pages.capitalbank.loans.LoansPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class loansSteps extends ProjectBase {

    protected Map<String, String> tdDashboardDetails = new LinkedHashMap<>();

    @When("I click on Transfer in dashboard page")
    public void iClickOnTransferInDashboardPage() {
        new LoansPage().clickOnTransfer();
    }

    @And("I select the card {string} in pay from page")
    public void iSelectTheCardInPayFromPage(String currency) {
        new LoansPage().selectPayBillAccount(currency);
    }

    @When("I click on Loans in dashboard")
    public void iClickOnLoansInDashboard() {
        new LoansPage().clickOnLoans();
    }

    @Then("I should see the local currency {string}")
    public void iShouldSeeTheLocalCurrency(String currency) {
        Assert.assertTrue(new LoansPage().payFromAccountDetails()
                .contains(currency), "Assertion on Pay from account");
    }

    @And("I click on own account Own account in transfer page")
    public void iClickOnOwnAccountOwnAccountInTransferPage() {
        new LoansPage().clickOnOwnAccount();
    }

    @When("I click on View portfolio in dashboard page")
    public void iClickOnViewPortfolioInDashboardPage() {
        new LoansPage().clickOnPortfolio();
    }

    @Then("I should see the {string} is displayed")
    public void iShouldSeeTheIsDisplayed(String accountType) {
        Assert.assertTrue(String.valueOf(new LoansPage().loans(accountType)).contains(accountType), "Assertion on View portfolio ");
    }

    @And("I select the card {string} in pay to page")
    public void iSelectTheCardInPayToPage(String currency) {
        new LoansPage().clickOnOwnAccount(currency);
    }

    @And("I scroll to the {string} in loan dashboard")
    public void iScrollToTheInLoanDashboard(String name) {
        new LoansPage().scrollDownInLoans(name);
    }

    @Then("I should see the {string} in loans page")
    public void iShouldSeeTheInLoansPage(String value) {
        Assert.assertTrue(new LoansPage().fetchLoanDetails().contains(value), "Assertion in loan page");
    }

    @Then("I should see the load schedule {string}")
    public void iShouldSeeTheLoadSchedule(String loan) {
        Assert.assertTrue(new LoansPage().isLoanSchedulePresent(loan));
    }

    @And("select the {string} from dropdown menu")
    public void selectTheFromDropdownMenu(String type) {
        new LoansPage().selectCardFromDropDown(type);
    }

    @Then("I fetch the loan details")
    public void iFetchTheLoanDetails() {
        List<String> loanDetails = List.of(new LoansPage().fetchLoanDetails().replaceAll("\n", "-").split("-"));

        int count = loanDetails.size();
        List<String> termDepositDetails1;
        if (count < 29) {
            termDepositDetails1 = List.of(new LoansPage().fetchLoanDetails().replaceAll("\n", "  ").replace("Next Payment Date,", "Next Payment Date  Nil").split("  "));
            for (int i = 0; i < termDepositDetails1.size(); i++) {
                for (int j = 1; j < termDepositDetails1.size(); i++) {
                    while (j <= 28) {
                        tdDashboardDetails.put(termDepositDetails1.get(i), termDepositDetails1.get(j));
                        i = i + 2;
                        j = j + 2;
                    }
                }
            }
        } else {
            termDepositDetails1 = List.of(new LoansPage().fetchLoanDetails().replaceAll("\n", "  ").split("  "));
            logInfo(termDepositDetails1);
        }

        for (Map.Entry<String, String> entry : tdDashboardDetails.entrySet()) {
            logInfo(entry.getKey() + "=" + entry.getValue());
        }

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(customData.getPayBillAmount(), tdDashboardDetails.get(tdDashboardDetails.get("47,856.000")), "Assertion on Card Details");
        softAssert.assertEquals(customData.getAccountNumber(), tdDashboardDetails.get(tdDashboardDetails.get("4624346")), "Assertion on Card Details");
        softAssert.assertEquals(customData.getPayFromCurrency(), tdDashboardDetails.get(tdDashboardDetails.get("JOD")), "Assertion on Card Details");
        softAssert.assertEquals(customData.getDate(), tdDashboardDetails.get(tdDashboardDetails.get("April 24, 2025")), "Assertion on Card Details");
        softAssert.assertEquals(customData.getDescription(), tdDashboardDetails.get(tdDashboardDetails.get(" 32,920.826")), "Assertion on Card Details");

        softAssert.assertAll();
    }

    @And("I select the dropdown")
    public void iSelectTheDropdown() {
        new CardPage().selectCardDropdown();
    }

    @And("I click on settle card in cards page")
    public void iClickOnSettleCardInCardsPage() {
        new LoansPage().settleCard();
    }

    @And("I enter the amount to settle card")
    public void iEnterTheAmountToSettleCard() {
        new LoansPage().enterAmount();
    }

    @And("I enter the amount {string} in {string}")
    public void iEnterTheAmountIn(String amount, String page) {
        new LoansPage().enterAmount(amount, page);
    }

    @Then("I should see the {string} in pay from  account")
    public void iShouldSeeTheInPayFromAccount(String currency) {
        Assert.assertTrue(new LoansPage().getPayFromDetails().contains(currency), "Assertion on pay from account");
    }

    @Then("I should see local currency {string}")
    public void iShouldSeeLocalCurrency(String currency) {
        Assert.assertTrue(new LoansPage().payAccountDetails().contains(currency), "Assertion in loan page");
    }

    @Then("I should see the local currency {string} transfer page")
    public void iShouldSeeTheLocalCurrencyTransferPage(String currency) {
        Assert.assertTrue(new LoansPage().payAccountTransfer().contains(currency), "Assertion on loan page");
    }
}