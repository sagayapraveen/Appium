package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.debitCard.DebitCardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class debitCardSteps extends ProjectBase {

    @Then("I should see the {string} in cards page")
    public void iShouldSeeTheInCardsPage(String value) {
        Assert.assertTrue(new DebitCardPage().getMenu().contains(value), "Assertion on cards page");
    }

    @When("I select the {string} under cards page")
    public void iSelectTheUnderCardsPage(String text) {
        new DebitCardPage().clickOnManageSpending(text);
    }

    @And("I set ATM withdrawal limit {string}")
    public void iSetATMWithdrawalLimit(String amount) {
        new DebitCardPage().setATMWithdrawalLimit(amount);
    }

    @And("I set card payment {string}")
    public void iSetCardPayment(String amount) {
        new DebitCardPage().setCardPayment(amount);
    }

    @And("I set online purchase {string}")
    public void iSetOnlinePurchase(String amount) {
        new DebitCardPage().setOnlinePurchase(amount);
    }

    @And("I set contactless payment {string}")
    public void iSetContactlessPayment(String amount) {
        new DebitCardPage().setContactLessPayment(amount);
    }

    @And("I click on save Button in Manage Spending Limits page")
    public void iClickOnSaveButtonInManageSpendingLimitsPage() {
        new DebitCardPage().clickOnSave();
    }

    @Then("I should see the {string} message in Manage Spending Limits pag")
    public void iShouldSeeTheMessageInManageSpendingLimitsPag(String success) throws InterruptedException {
        Assert.assertTrue(new DebitCardPage().getSuccessMessage().contains(success), "Assertion on Manage Spending");
    }

    @And("I click on toggle off on contactless payment option")
    public void iClickOnToggleOffOnContactlessPaymentOption() {
        new DebitCardPage().clickToggleOnContactLess();
    }

    @And("I click on toggle off on ATM withdrawal option")
    public void iClickOnToggleOffOnATMWithdrawalOption() {
        new DebitCardPage().clickToggleOnATMWithdrawal();
    }

    @And("I click on toggle off on online shopping option")
    public void iClickOnToggleOffOnOnlineShoppingOption() {
        new DebitCardPage().clickToggleOnlinePurchase();
    }

    @And("I click on toggle off on card option")
    public void iClickOnToggleOffOnCardOption() {
        new DebitCardPage().clickToggleOnCard();
    }

    @Then("I should see the error as {string} in Manage Spending Limits page")
    public void iShouldSeeTheErrorAsInManageSpendingLimitsPage(String error) {
        Assert.assertTrue(new DebitCardPage().getATMErrorMessage().contains(error), "Assertion on ATM Error message");
    }

    @Then("I should see the error {string} in Manage Spending Limits page")
    public void iShouldSeeTheErrorInManageSpendingLimitsPage(String error) {
        Assert.assertTrue(new DebitCardPage().getCardErrorMessage().contains(error), "Assertion on card error message");
    }

    @Then("I should see the error {string} on Manage Spending Limits page")
    public void iShouldSeeTheErrorOnManageSpendingLimitsPage(String error) {
        Assert.assertTrue(new DebitCardPage().getOnlineErrorMessage().contains(error), "Assertion on Online shopping");
    }

    @Then("I should see the error as {string} on Manage Spending Limits page")
    public void iShouldSeeTheErrorAsOnManageSpendingLimitsPage(String error) {
        Assert.assertTrue(new DebitCardPage().getContactLessErrorMessage().contains(error), "Assertion on Contact less payment");
    }

    @And("I click on freeze button in cards page")
    public void iClickOnFreezeButtonInCardsPage() {
        new DebitCardPage().clickFreezeButton();
    }

    @Then("I should see the card status {string}")
    public void iShouldSeeTheCardStatus(String status) {
        Assert.assertTrue(new DebitCardPage().getCardStatus().contains(status), "Assertion on cards");
    }

    @And("I click the freeze button in cards page")
    public void iClickTheFreezeButtonInCardsPage() {
        new DebitCardPage().clickOnFreeze();
    }

    @And("I click on toggle on ATM withdrawal option")
    public void iClickOnToggleOnATMWithdrawalOption() {
        new DebitCardPage().clickOnATMToggle();
    }

    @And("I click on toggle on card option")
    public void iClickOnToggleOnCardOption() {
        new DebitCardPage().clickOnToggleOnlinePurchase();
    }

    @And("I click on toggle on online shopping option")
    public void iClickOnToggleOnOnlineShoppingOption() {
        new DebitCardPage().clickOnCardToggle();
    }

    @And("I click on toggle on contactless payment option")
    public void iClickOnToggleOnContactlessPaymentOption() {
        new DebitCardPage().clickOnContactLessToggle();
    }

    @And("I click on save Button  Manage Spending Limits page")
    public void iClickOnSaveButtonManageSpendingLimitsPage() {
        new DebitCardPage().clickOnSave();
    }
}