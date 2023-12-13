package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.ForgotPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class forgotPasswordSteps extends ProjectBase {

    @And("I enter the debit card number as {string}")
    public void iEnterTheDebitCardNumberAs(String DebitCard) {
        new ForgotPasswordPage().enterDebitCardNumber(DebitCard);
    }

    @And("I enter the card PIN as {string}")
    public void iEnterTheCardPINAs(String PIN) {
        new ForgotPasswordPage().enterPin(PIN);
    }

    @And("I enter the six digit code as {string}")
    public void iEnterTheSixDigitCodeAs(String code) {
        new ForgotPasswordPage().enterCode(code);
    }

    @And("I should see the page contains {string}")
    public void iShouldSeeThePageContains(String message) {
        String referenceMessage = new ForgotPasswordPage().fetchPageContains(message);
        Assert.assertTrue(referenceMessage.contains(message), "Assertion on page to be appear");
        logInfo("Page contains " + message + " is displayed");
    }

    @And("I should see the username is auto filled as {string}")
    public void iShouldSeeTheUsernameIsAutoFilledAs(String username) {
        Assert.assertTrue(new ForgotPasswordPage().fetchUsername(username), "Assertion on username auto filled");
    }

    @And("I should see password hit message as {string}")
    public void iShouldSeePasswordHitMessageAs(String message) {
        String referenceMessage = new ForgotPasswordPage().passwordHintMessage(message);
        Assert.assertTrue(referenceMessage.contains(message), "Assertion on password hint message");
        logInfo("password hint message " + message + " in Create Password");
    }

    @And("I Enter the password as {string}")
    public void iEnterThePasswordAs(String value) {
        new ForgotPasswordPage().enterPassword(value);
    }

    @And("I Enter the re enter password as {string}")
    public void iEnterTheReEnterPasswordAs(String value) {
        new ForgotPasswordPage().reenterPassword(value);
    }

    @And("I should see Resend Code text")
    public void iShouldSeeResendCodeText() {
        Assert.assertTrue(new ForgotPasswordPage().isResendCodeDisplayed(), "Assertion on Resend Code text");
        logInfo("Resend Code is displayed");
    }

    @And("I verify the mobile six digit pin {string}")
    public void iVerifyTheMobileSixDigitPin(String code) {
        new ForgotPasswordPage().enterCode(code);
    }

    @And("I Enter the six digit pin {string} for transaction")
    public void iEnterTheSixDigitPinForTransaction(String code) {
        new ForgotPasswordPage().enteringCode(code);
    }

    @And("I enter the PIN as {string}")
    public void iEnterThePINAs(String PIN) {
        new ForgotPasswordPage().enterPin(PIN);
    }

    @When("I enter debit card number as {string}")
    public void iEnterDebitCardNumberAs(String DebitCard) {
        new ForgotPasswordPage().enterDebitCardNumber(DebitCard);
    }

    @And("I should see the confirmation message You’re all set,ready to go!")
    public void iShouldSeeTheConfirmationMessageYouReAllSetReadyToGo() {
        Assert.assertTrue(new ForgotPasswordPage().successMessage(), "Assertion on confirmation message You’re all set,ready to go!");
        logInfo("Confirmation message is displayed");
    }

    @And("I click on Back to Login button in confirmation page")
    public void iClickOnBackToLoginButtonInConfirmationPage() {
        new ForgotPasswordPage().backToLoginButton();
    }

    @And("I should see Login page")
    public void iShouldSeeLoginPage() {
        Assert.assertTrue(new ForgotPasswordPage().loginPage(), "Assertion on Login page");
        logInfo("Login page is displayed");
    }

    @And("I click on enter")
    public void iClickOnEnter() {
        new ForgotPasswordPage().clickOnEnter();
    }

    @Then("I should see the field level error message with apostrophe {string}")
    public void iShouldSeeTheFieldLevelErrorMessageWithApostrophe(String errorText) {
        int size = getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"" + errorText + "\"]")).size();
        String message = "";

        if (size == 0)
            message = "Error message '" + errorText + "' is not displayed.";
        else
            message = "Error message '" + errorText + "' is displayed.";

        Assert.assertEquals(size, 1, message);
        logInfo(message);
    }
}