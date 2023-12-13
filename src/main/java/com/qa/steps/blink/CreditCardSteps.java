package com.qa.steps.blink;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.CreditCardPage;
import com.qa.pages.blink.DebitCard;
import com.qa.pages.blink.MyAccountPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CreditCardSteps extends ProjectBase {

    @And("I click on settings icon in credit card")
    public void iClickOnSettingsIconInCreditCard() {
        new CreditCardPage().clickOnSetting();
    }

    @Then("I should see the account details in flip card")
    public void iShouldSeeTheAccountDetailsInFlipCard() {
        Assert.assertTrue(new CreditCardPage().accountDetails().contains("CARD NUMBER"), "Assertion flip card ");
    }

    @Then("I should see flip credit card")
    public void iShouldSeeFlipCreditCard() {
        Assert.assertTrue(new CreditCardPage().creditCard().contains("Credit Card"), "Assertion flip card ");
    }

    @And("I click on manage settlement in credit card menu")
    public void iClickOnManageSettlementInCreditCardMenu() {
        new CreditCardPage().clickManageSettlement();
    }

    @And("I select the Change settlement options")
    public void iSelectTheChangeSettlementOptions() {
        new CreditCardPage().clickSettlementOption();
    }

    @And("I click on new settlement percentage")
    public void iClickOnNewSettlementPercentage() {
        new CreditCardPage().clickOnNewSettlement();
    }


    @And("I select the settlement percentage {string}")
    public void iSelectTheSettlementPercentage(String percentage) {
        new CreditCardPage().selectSettlementPercentage(percentage);
        new HomePage().scroll("left");
    }

    @Then("I should see the successful message {string}")
    public void iShouldSeeTheSuccessfulMessage(String message) {
        Assert.assertTrue(new CreditCardPage().getCreditSuccessMessage().contains(message), "Assertion in manage settlement");
    }

    @When("I click on pay back in credit card")
    public void iClickOnPayBackInCreditCard() {
        new CreditCardPage().clickOnPayBack();
    }

    @And("I enter the pay amount {string} in pay back page")
    public void iEnterThePayAmountInPayBackPage(String amount) throws InterruptedException {
        new CreditCardPage().enterPayAmount(amount)
                .proceedPaymentNext();
    }

    @Then("I should see the transaction amount {string} paid to page")
    public void iShouldSeeTheTransactionAmountPaidToPage(String amount) {
        Assert.assertTrue(new CreditCardPage().getTransactionDetails().contains(amount), "Assertion in pay back page");
    }

    @Then("I should see the error pop-up message {string}")
    public void iShouldSeeTheErrorPopUpMessage(String error) {
        Assert.assertTrue(new CreditCardPage().getErrorMessage().contains(error), "Assertion in credit card error");
    }

    @When("I click on the credit card option as {string}")
    public void iClickOnTheCreditCardOptionAs(String value) {
        new DebitCard().clickAction(value);
    }

    @And("I should fetch the available balance in pay back page")
    public void iShouldFetchTheAvailableBalanceInPayBackPage() {
        customData.setTotalAccountBalance(new CreditCardPage().getPayBackBalance());
    }

    @And("I swipe down in pay back page")
    public void iSwipeDownInPayBackPage() {
        new CreditCardPage().swipeDown();
    }

    @Then("I should see the account balance")
    public void iShouldSeeTheAccountBalance() {
        Assert.assertTrue(new MyAccountPage().getAccountDetails().contains(customData.getTotalAccountBalance()), "Assertion in debit account balance");
    }

    @And("I enter the new pin {string} in change card pin")
    public void iEnterTheNewPinInChangeCardPin(String newPin) {
        new CreditCardPage().enterNewPin(newPin);
    }

    @And("I confirm the new pine {string}in change card pin")
    public void iConfirmTheNewPineInChangeCardPin(String pin) {
        new CreditCardPage().confirmNewPin(pin);
    }

    @Then("I should see the error message {string} in change card pin")
    public void iShouldSeeTheErrorMessageInChangeCardPin(String error) {
        Assert.assertTrue(new CreditCardPage().getErrorMessageInChangePin().contains(error), "Assertion in new pin");
    }

    @And("I swipe left in the new pin page")
    public void iSwipeLeftInTheNewPinPage() {
        new CreditCardPage().swipeLeft();
    }

    @Then("I should see the current settlement percentage {string}")
    public void iShouldSeeTheCurrentSettlementPercentage(String percentage) {
        Assert.assertTrue(new CreditCardPage().currentSettlementPercentage().contains(percentage));
    }

    @When("I click on back to card Setting")
    public void iClickOnBackToCardSetting() {
        new CreditCardPage().clickOnBackToCard();
    }

    @When("I navigate to credit card")
    public void iNavigateToCreditCard() {
        new CreditCardPage().navigateToCreditCard();

    }
}