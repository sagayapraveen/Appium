package com.qa.steps.blink;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.ProfileSettingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BlinkProfileSettingSteps extends ProjectBase {

    @And("I click on profile setting from home page")
    public void iClickOnProfileSettingFromHomePage() {
        new ProfileSettingPage().clickProfileSetting();
    }

    @And("I click on blink logo in home page")
    public void iClickOnBlinkLogoInHomePage() {
        new ProfileSettingPage().clickOnLogo();
    }

    @And("I enter the E-mail ID {string}")
    public void iEnterTheEMailID(String email) {
        new ProfileSettingPage().enterMailID(email);
    }

    @Then("I should see error pop-up {string}")
    public void iShouldSeeErrorPopUp(String error) {
        Assert.assertTrue(new ProfileSettingPage().errorMessage().contains(error), "Assertion on email profile setting ");
    }

    @And("I enter the {string} in profile setting")
    public void iEnterTheInProfileSetting(String number) {
        new ProfileSettingPage().enterMobileNumber(number);
    }

    @And("I click in country dropdown to search {string}")
    public void iClickInCountryDropdownToSearch(String country) throws InterruptedException {
        new ProfileSettingPage().clickOnCountryDropdown(country)
                .clickOk();
    }

    @And("I enter {string} in change password page")
    public void iEnterInChangePasswordPage(String currentPassword) {
        new ProfileSettingPage().currentPassword(currentPassword);
    }

    @And("I enter the new password {string} in change password page")
    public void iEnterTheNewPasswordInChangePasswordPage(String newPassword) {
        new ProfileSettingPage().newPassword(newPassword);
    }

    @And("I confirm password {string} in change password page")
    public void iConfirmPasswordInChangePasswordPage(String password) {
        new ProfileSettingPage().confirmPassword(password);
    }

    @And("I click on the Change Password in profile setting")
    public void iClickOnTheChangePasswordInProfileSetting() {
        new ProfileSettingPage().clickOnChangePassword();
    }

    @And("I click on mobile number in profile setting page")
    public void iClickOnMobileNumberInProfileSettingPage() {
        new ProfileSettingPage().clickOnMobileNumber();
    }

    @And("I click in E-mail address in profile setting page")
    public void iClickInEMailAddressInProfileSettingPage() {
        new ProfileSettingPage().clickOnEmail();
    }

    @Then("I should see the {string} updated successfully in profile setting page")
    public void iShouldSeeTheUpdatedSuccessfullyInProfileSettingPage(String number) {
        Assert.assertTrue(new ProfileSettingPage().fetchMobileNumber().contains(number), "Assertion in change mobile number");
    }
}