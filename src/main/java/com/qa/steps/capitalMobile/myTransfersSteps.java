package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.myTransfers.MyTransfersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class myTransfersSteps extends ProjectBase {

    @And("I click on back to Profile menu")
    public void iClickOnBackToProfileMenu() {
        new MyTransfersPage().clickOnBackButton();
    }

    @Then("I should see the {string} option on profile menu")
    public void iShouldSeeTheOptionOnProfileMenu(String option) {
        Assert.assertTrue(new MyTransfersPage().profileMenu().contains(option), "Assertion in profile menu");
    }

    @And("I click on the {string} under My Transfer page")
    public void iClickOnTheUnderMyTransferPage(String menu) {
        new MyTransfersPage().selectTab(menu);
    }

    @And("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        new MyTransfersPage().clickOnSearchIcon();
    }

    @Then("I should see the page {string} page")
    public void iShouldSeeThePagePage(String page) {
        Assert.assertTrue(new MyTransfersPage().searchFilterPage().contains(page), "Assertion on My Transfer");
    }

    @And("I select the transaction to share")
    public void iSelectTheTransactionToShare() {
        new MyTransfersPage().selectTransactionDetails();
    }

    @Then("I should check the share button is clickable")
    public void iShouldCheckTheShareButtonIsClickable() {
        Assert.assertTrue(new MyTransfersPage().sharePage(), "Assertion in transfer page");
    }

    @And("I select the transaction {string}")
    public void iSelectTheTransaction(String name) {
        new MyTransfersPage().selectTransaction(name);
    }

    @Then("I should verify the details of the transaction")
    public void iShouldVerifyTheDetailsOfTheTransaction() {
        logInfo(new MyTransfersPage().fetchTransactionDetails());
    }

    @Then("I should verify view swift Image link is clickable")
    public void iShouldVerifyViewSwiftImageLinkIsClickable() {
        Assert.assertTrue(new MyTransfersPage().viewSwiftImage());

    }

    @Then("I should Verify the transaction details")
    public void iShouldVerifyTheTransactionDetails(Map<String, String> account) {
        SoftAssert softassert = new SoftAssert();

        String transferDetails = new MyTransfersPage().fetchTransactionDetails().replaceAll("\n", " ");

        softassert.assertTrue(transferDetails.contains(account.get("Account Number")), "Assertion on Account");
        softassert.assertTrue(transferDetails.contains(account.get("Beneficiary Name")), "Assertion on BeneficiaryName");
        softassert.assertTrue(transferDetails.split(" ")[transferDetails.split(" ").length - 1].length() == 16, "Assertion on Ref No");

        softassert.assertAll();
    }

    @And("I click on back button from transaction details")
    public void iClickOnBackButtonFromTransactionDetails() {
        new MyTransfersPage().clickOnBackButtonFromTransactionPage()
                .scrollToTop();
    }
}
