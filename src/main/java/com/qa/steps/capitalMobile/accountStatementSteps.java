package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.accountStatement.AccountStatementPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class accountStatementSteps extends ProjectBase {


    @And("I scroll to the {string} in account dashboard")
    public void iScrollToTheInAccountDashboard(String text) {
        new AccountStatementPage().clickTransactionButton(text);
    }

    @And("I click on E-Statement in transaction page")
    public void iClickOnEStatementInTransactionPage() {
        new AccountStatementPage().clickOnEStatement();
    }

    @Then("I should see the {string} along with the {string}")
    public void iShouldSeeTheAlongWithThe(String year, String month) {
        String accountStatement = new AccountStatementPage().getStatementYearAndMonth();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountStatement.contains(year), "Assertion on E-Statement");
        softAssert.assertTrue(accountStatement.contains(month), "Assertion on E-Statement");
        softAssert.assertAll();
    }

    @And("I click on statement year dropdown in E-Statement")
    public void iClickOnStatementYearDropdownInEStatement() {
        new AccountStatementPage().clickOnYearDropDown();
    }


    @Then("I should see the {string} years in dropdown list")
    public void iShouldSeeTheYearsInDropdownList(String year) {
        List<String> values = new AccountStatementPage().getStatementYear();

        Assert.assertTrue(values.contains(year), "Assertion on E-Statement");
        Assert.assertTrue(values.contains("2022"), "Assertion on E-Statement");
        Assert.assertTrue(values.contains("2021"), "Assertion on E-Statement");

        if (getDriver() instanceof AndroidDriver)
            new HomePage().scrollWithCoordinates("down", 0.5, 249, 460);
        else
            new HomePage().scrollWithCoordinates("down", 0.5, 175, 700);
    }

    @And("I click on statement month dropdown in E-Statement")
    public void iClickOnStatementMonthDropdownInEStatement() {
        new AccountStatementPage().clickOnStatementMonthDropDown();
    }

    @Then("I should see the {string} month in dropdown list")
    public void iShouldSeeTheMonthInDropdownList(String month) {
        List<String> values = new AccountStatementPage().getStatementMonth();

        Assert.assertTrue(values.contains(month), "Assertion on E-Statement");
        Assert.assertTrue(values.contains("May"), "Assertion on E-Statement");
        Assert.assertTrue(values.contains("August"), "Assertion on E-Statement");
        new HomePage().scroll("down");
    }

    @When("I select the year {string} in select statement year")
    public void iSelectTheYearInSelectStatementYear(String year) {
        new AccountStatementPage().selectYear(year);

    }

    @And("I select the month {string} in select statement month")
    public void iSelectTheMonthInSelectStatementMonth(String month) {
        new AccountStatementPage().selectMonth(month);
    }

    @And("I click on generate PDF")
    public void iClickOnGeneratePDF() {
        new AccountStatementPage().clickOnGeneratePDF();
    }

    @Then("I should see the {string} in E-statement")
    public void iShouldSeeTheInEStatement(String value) {
        Assert.assertTrue(new AccountStatementPage().getStatementPDF().contains(value.toUpperCase()), "Assertion on share E-Statement");
    }
}