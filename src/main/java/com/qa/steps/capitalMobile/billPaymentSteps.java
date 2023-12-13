package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.billpay.PayBillPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class billPaymentSteps extends ProjectBase {

    @And("I click on New Biller in pay to page")
    public void iClickOnNewBillerInPayToPage() {
        new PayBillPage().clickNewBillerButton();
    }

    @And("I select the {string} in Select Category page")
    public void iSelectTheInSelectCategoryPage(String category) {
        new PayBillPage().searchCategory(category);
    }

    @And("I select the biller name {string} in Select Category page")
    public void iSelectTheBillerNameInSelectCategoryPage(String biller) {
        new PayBillPage().clickBillerName().swipeToBiller("up", biller);
    }

    @And("ServiceType as {string} in Select Category page")
    public void ServiceTypeAsInSelectCategoryPage(String service) {
        new PayBillPage().clickOnServiceTypeButton()
                .clickBillerNameWithValue("up", service);
    }

    @When("I click on {string} tab in pay to page")
    public void iClickOnTabInPayToPage(String payTo) {
        new PayBillPage().clickPayTo(payTo);
    }

    @Then("I should see the {string} in confirm page")
    public void iShouldSeeTheInConfirmPage(String value) {
        Assert.assertTrue(new PayBillPage().getConfirmDetails().contains(value), "Assertion in confirm page");
    }

    @And("I swipe left to delete the biller")
    public void iSwipeLeftToDeleteTheBiller() {
        new PayBillPage().swipeBiller();
    }

    @And("I click on delete saved biller")
    public void iClickOnDeleteSavedBiller() {
        new PayBillPage().clickOnDelete();
    }

    @And("I click on confirm button in delete save biller")
    public void iClickOnConfirmButtonInDeleteSaveBiller() {
        new PayBillPage().clickOnConfirm();
    }

    @Then("I should see the successful message {string} in delete save biller")
    public void iShouldSeeTheSuccessfulMessageInDeleteSaveBiller(String success) {
        Assert.assertTrue(new PayBillPage().getConfirmMessage().contains(success), "Assertion in successfully message");
    }

    @And("I click on {string} in pay to page")
    public void iClickOnInPayToPage(String biller) {
        new PayBillPage().selectAndDeselect(biller);
    }

    @Then("I should see the biller is selected {string}")
    public void iShouldSeeTheBillerIsSelected(String value) {
        Assert.assertTrue(new PayBillPage().isBillerSelected().contains(value), "Assertion in select biller");
    }

    @Then("I should see the biller is Unselected {string}")
    public void iShouldSeeTheBillerIsUnselected(String value) {
        Assert.assertTrue(new PayBillPage().isBillerSelected().contains(value), "Assertion in unselect biller");
    }

    @Then("I should see the app is displaying {string} field")
    public void iShouldSeeTheAppIsDisplayingField(String fees) {
        Assert.assertTrue(new PayBillPage().getFeesDetails().contains(fees), "Assertion in education biller");
    }

    @Then("I should see the total amount not be editable")
    public void iShouldSeeTheTotalAmountNotBeEditable() {
        Assert.assertTrue(new PayBillPage().getTotalAmount().contains("false"), "Assertion in Pay New Bill");
    }

    @And("I click on save Biller in successfully message")
    public void iClickOnSaveBillerInSuccessfullyMessage() {
        new PayBillPage().clickOnSaveBiller();
    }

    @And("I enter the nick name as {string}")
    public void iEnterTheNickNameAs(String nickName) {
        new PayBillPage().enterNickNameAs(nickName);
    }

    @When("I click on the back to dashboard in success biller saved page")
    public void iClickOnTheBackToDashboardInSuccessBillerSavedPage() {
        new PayBillPage().clickOnBackToDashboard();
    }

    @And("I enter the nick name {string} in Pay New Bill")
    public void iEnterTheNickNameInPayNewBill(String nickName) {
        new PayBillPage().enterPayBillNickName(nickName + utils.getRandomString(3));
    }

    @And("I click on continue to pay button")
    public void iClickOnContinueToPayButton() {
        new PayBillPage().clickOnContinueToPay();
    }
}