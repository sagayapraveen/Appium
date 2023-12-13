package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.cliQ.CliQTransferPage;
import com.qa.pages.capitalbank.cliQ.ManageCliQPage;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CliQSteps extends ProjectBase {

    @When("I select the {string} from profile menu")
    public void iSelectTheFromProfileMenu(String CliQ) {
        new ManageCliQPage().clickOnManageCliQID(CliQ);
    }

    @And("I click on CliQID to enter {string} and enter alias as {string}")
    public void iClickOnCliQIDToEnterAndEnterAliasAs(String type, String value) {
        if (type.equalsIgnoreCase("ALIAS"))
            new ManageCliQPage().selectAlias(type)
                    .enterAlias(value);
        else if (type.equalsIgnoreCase("Mobile number"))
            new ManageCliQPage().selectMobileNumber(type)
                    .enterMobileNumber(value);
    }

    @And("I click on edit details to edit CliQ ID")
    public void iClickOnEditDetailsToEditCliQID() {
        new ManageCliQPage().clickOnEditDetails();
    }

    @And("I edit the alias as {string}")
    public void iEditTheAliasAs(String alias) {
        new ManageCliQPage().editAlias(alias + new TestUtils().getRandomNumber(3));
    }

    @And("I select radio button for CliQ and click on confirm")
    public void iSelectRadioButtonAndClickOnConfirm() {
        new ManageCliQPage().clickOnConfirm();
    }

    @Then("I should see the success message for CliQ ID created {string}")
    public void iShouldSeeTheSuccessMessageForCliQIDCreated(String successMessage) {
        Assert.assertTrue(new ManageCliQPage().getCliQSavedSuccessMessage()
                .contains(successMessage), "Assertion in CliQ ID created");
    }

    @And("I select CliQ default link account {string}")
    public void iSelectCliqDefaultLinkAccount(String currency) {
        new ManageCliQPage().clickOnCard(currency);
    }

    @And("I click on {string} and enter the mobile number as {string}")
    public void iClickOnAndEnterTheMobileNumberAs(String mobile, String number) {
        new ManageCliQPage().selectMobileNumber(mobile)
                .enterMobileNumber(number);
    }

    @Then("I should see the alert message {string}")
    public void iShouldSeeTheAlertMessage(String alertMessage) {
        Assert.assertTrue(String.valueOf(new ManageCliQPage().getCliQMessage())
                .contains(alertMessage), "Assert in postpaid success message");
    }

    @Then("I should see the pop-up {string}")
    public void iShouldSeeThePopUp(String value) {
        Assert.assertTrue(new ManageCliQPage().getMobileNumberShouldBeOf()
                .contains(value), "Assertion on Mobile Number");
    }

    @Then("I should see the confirm button should be disable")
    public void iShouldSeeTheConfirmButtonShouldBeDisable() {
        Assert.assertFalse(new ManageCliQPage().isConfirmButtonIsClickable(), "Assert in CliQ");
    }

    @When("I click on CliQ in dashboard")
    public void iClickOnCliQInDashboard() {
        new CliQTransferPage().clickOnCliQ();
    }

    @And("I click on {string} to navigate to pay to page")
    public void iClickOnToNavigateToPayToPage(String CliQID) {
        new CliQTransferPage().clickOnCliQTransfer(CliQID);
    }

    @Then("I should see saved biller {string}")
    public void iShouldSeeSavedBillerList(String biller) {
        Assert.assertTrue(new CliQTransferPage().getSavedBiller(biller), "Assertion saved biller");
    }

    @Then("I should see {string} page")
    public void iShouldSeePage(String page) {
        Assert.assertTrue(new CliQTransferPage().iShouldBeInCliQTransferPage(page)
                .contains(page), "Assertion on CliQ page");
    }

    @And("I click on Beneficiary Type {string}")
    public void iClickOnBeneficiaryType(String Beneficiary) {
        new CliQTransferPage().clickBeneficiaryType(Beneficiary);
    }

    @And("I enter the beneficiary {string}")
    public void iEnterTheBeneficiary(String beneficiary) {
        new CliQTransferPage().enterBeneficiary(beneficiary);
        customData.setAccountNumber(beneficiary);
    }

    @And("I enter the amount in {string} in {string}")
    public void iEnterTheAmountInIn(String amount, String page) {
        new CliQTransferPage().enterAmount(amount, page)
                .clickOk();

        customData.setEnteredAmount(Float.parseFloat(amount));
    }

    @And("I enter recipient name as {string}")
    public void iEnterRecipientNameAs(String RecipientName) {
        new CliQTransferPage().enterRecipientName(RecipientName);
    }

    @Then("I should see the error as {string}")
    public void iShouldSeeTheErrorAs(String errorMessage) {
        Assert.assertTrue(new CliQTransferPage().recipientNameError()
                .contains(errorMessage), "Assertion on error message");
    }

    @And("I enter the address for CliQ transfer as {string}")
    public void iEnterTheAddressAsNullValue(String address) {
        new CliQTransferPage().enterRecipientAddress(address);
    }

    @And("I select the purpose from drop down {string}")
    public void iSelectThePurposeFromDropDown(String purpose) {
        new CliQTransferPage().selectPurpose(purpose);
    }

    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String errorMessage) {
        Assert.assertTrue(new CliQTransferPage().recipientAddressError().contains(errorMessage), "Assertion on error message");
    }

    @And("I enter the description as {string}")
    public void iEnterTheDescriptionAs(String description) {
        new CliQTransferPage().enterDescription(description);
    }

    @And("I click on confirm button in CliQ")
    public void iClickOnConfirmButtonInCliQ() {
        new CliQTransferPage().clickOnConfirm();
    }

    @And("I click on Add as Beneficiary")
    public void iClickOnAddAsBeneficiary() {
        new CliQTransferPage().clickOnBeneficiary();
    }

    @And("I enter the Mobile Number or Alias as {string}")
    public void iEnterTheMobileNumberOrAliasAs(String text) {
        new CliQTransferPage().enterMobileNumberOrAlias(text);
    }

    @And("I search for saved beneficiary to select {string}")
    public void iSearchForSavedBeneficiaryToSelect(String savedBeneficiary) {
        new CliQTransferPage().searchForSavedBeneficiary(savedBeneficiary);
    }

    @And("I select purpose from drop down {string}")
    public void iSelectPurposeFromDropDown(String purpose) {
        new CliQTransferPage().selectPurposeFromDropdown(purpose);
    }

    @Then("I should see confirm {string} message")
    public void iShouldSeeConfirmMessage(String success) {
        CliQTransferPage cliQTransfer = new CliQTransferPage();
        String message = String.valueOf(cliQTransfer.getTransferSuccessfulMessage());
        Assert.assertTrue(message.contains(success), "Assertion on IBAN page");
    }

    @Then("I should see the page {string}")
    public void iShouldSeeThePage(String page) {
        Assert.assertTrue(new CliQTransferPage().confirmPage().contains(page), "Assertion in confirm Transfer page");
    }

    @And("I retrieving {string} the CliQ transfer details")
    public void iRetrievingTheCliQTransferDetails(String IBAN) {
        Assert.assertTrue(String.valueOf(new CliQTransferPage().getCliQTransferDetails()).contains(IBAN), "Assertion on confirm page");
    }

    @Then("I should see currency not allowed to amand")
    public void iShouldSeeCurrencyNotAllowedToAmand() {
        Assert.assertFalse(new CliQTransferPage().isCurrencyButtonIsClickable(), "Assert in CliQ JOD");
    }

    @And("I edit the alias {string}")
    public void iEditTheAlias(String alias) {
        new ManageCliQPage().editAliasName(alias);
    }

    @Then("I should see the edited text is equal {string}")
    public void iShouldSeeTheEditedTextIsEqual(String alias) {
        Assert.assertTrue(new ManageCliQPage().getEditedAlias()
                .contains(alias), "Assertion in edit alias");
    }

    @When("I fetch the card details from the dashboard")
    public void iFetchTheCardDetailsFromTheDashboard() {
        String cardDetails = new CliQTransferPage().fetchCardDetails();
        logInfo(cardDetails);
    }

    @And("I enter the amount {string} in {string} page")
    public void iEnterTheAmountInPage(String amount, String page) {
        new CliQTransferPage().enterAmountInTransfer(amount, page);
        new CliQTransferPage().clickOnOkInKeypad();
    }

    @And("I click confirm button in add beneficiary")
    public void iClickConfirmButtonInAddBeneficiary() {
        new CliQTransferPage().clickConfirm();
    }

    @Then("I should see confirm page {string} message")
    public void iShouldSeeConfirmPageMessage(String message) {
        CliQTransferPage cliQTransfer = new CliQTransferPage();
        Assert.assertTrue(message.contains("Transfer successful"));
        cliQTransfer.getTransferSuccessfulDetails(customData.getEnteredAmount());
        Assert.assertTrue(String.valueOf(cliQTransfer.getTransferSuccessfulDetails(customData.getEnteredAmount())).contains(customData.getAccountNumber()), "Assertion on Ref no in last transaction");
    }

    @And("I click on the add CliQ button")
    public void iClickOnTheAddCliQButton() {
        new ManageCliQPage().clickingAddCliQ();
    }

    @When("I click on CliQID for entering {string} and enter alias {string}")
    public void iClickOnCliQIDForEnteringAndEnterAlias(String alias, String value) {
        if (alias.equalsIgnoreCase("ALIAS")) {
            new ManageCliQPage().selectAlias(alias)
                    .enterAliasText(value);
        } else {
            new ManageCliQPage().selectMobileNumber(alias).
                    enterTheMobileNumber(value);
        }
    }

    @When("I click on next button")
    public void iClickOnNextButton() {
        new CliQTransferPage().clickOnNext();
    }

    @Then("I should see the next button should be disable")
    public void iShouldSeeTheNextButtonShouldBeDisable() {
        Assert.assertFalse(new ManageCliQPage().isNextButtonIsClickable(), "Assertion in CliQ");
    }

    @Then("I should see the transaction {string} with amount {string} in the transaction history")
    public void iShouldSeeTheTransactionWithAmountInTheTransactionHistory(String purpose, String amount) {
        Assert.assertTrue(new CliQTransferPage().getTransactionDetails().contains(purpose), "Assertion on transaction history");
    }

    @Then("I should see the {string} in confirm transfer page")
    public void iShouldSeeTheInConfirmTransferPage(String IBAN) {
        Assert.assertTrue(new CliQTransferPage().iShouldTheIBANInTransferPage().contains(IBAN), "Assertion in Transaction page");
    }

    @Then("I fetch transfers details form the transfer page {string}")
    public void iFetchTransfersDetailsFormTheTransferPage(String info) {
        Assert.assertTrue(new CliQTransferPage().fetchDetailsOfPayTo().contains(info),
                "Assertion in confirm Transfer page");
    }
}