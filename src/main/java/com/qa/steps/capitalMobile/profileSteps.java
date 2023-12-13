package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.ProfilePage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class profileSteps extends ProjectBase {
    @And("I click on Profile menu")
    public void iClickOnProfileMenu() {
        new HomePage().clickProfileIcon();
    }

    @When("I click on change password")
    public void iClickOnChangePassword() {
        new ProfilePage().changePassword();
    }

    @And("I enter the password details")
    public void iEnterThePasswordDetails(Map<String, String> details) {
        new ProfilePage().enterCurrentPassword(details.get("Current Password"))
                .enterNewPassword(details.get("New Password"))
                .reEnterPassword(details.get("Re-enter Password"));
    }

    @And("I enter the current password as {string} details and new password as {string}")
    public void iEnterTheCurrentPasswordAsDetailsAndNewPasswordAs(String current, String newPassword) {
        new ProfilePage().enterCurrentPassword(current)
                .enterNewPassword(newPassword);
    }

    @And("I enter {} then {} and {}")
    public void iEnterCurrentPasswordThenNewPasswordAndReEnterPassword(String currentPassword, String newPassword, String reEnterPassword) {
        new ProfilePage().enterCurrentPassword(currentPassword)
                .enterNewPassword(newPassword)
                .reEnterPassword(reEnterPassword);
    }

    @Then("I should see the next button is non clickable")
    public void iShouldSeeTheNextButtonIsNonClickable() {
        Assert.assertEquals(new ProfilePage().nextButton(), "false", "Assertion on Next button");
    }

    @When("I click on health and wealth toggle")
    public void iClickOnHealthAndWealthToggle() {
        new ProfilePage().healthToggle();
    }

    @And("I give {string} on terms and conditions")
    public void iAcceptTermsAndConditions(String value) {
        new ProfilePage().termsAndCondition(value);
        customData.setRequestType(value);
    }

    @Then("I should see message for health and wealth")
    public void iShouldSeeMessageForHealthAndWealth() {
        if (customData.getRequestType().equalsIgnoreCase("YES"))
            Assert.assertEquals(new ProfilePage().healthMessage().replace("\n", " "),
                    "Succesfully joined our Health & Wealth program!");
        else
            Assert.assertEquals(new ProfilePage().healthMessage().replace("\n", " "),
                    "You can always join our Health & Wealth program by clicking on your profile");
    }

    @And("I came back from terms and condition")
    public void iCameBackFromTermsAndCondition() {
        new ProfilePage().cancellingTermsAndCondition();
    }

    @Then("I should see the menu option")
    public void iShouldSeeTheMenuOption() {
        Assert.assertEquals(new ProfilePage().menuOption(), "Change profile image");
    }

    @When("I click on {string} menu")
    public void iClickOnMenu(String menu) {
        new ProfilePage().selectMenu(menu);
    }

    @And("I read all the terms and conditions details")
    public void iReadAllTheTermsAndConditionsDetails() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "=\"Online Banking Security\"]", 30);
        new HomePage().scroll("up", 0.75);
    }

    @And("I click close button in {string}")
    public void iClickCloseButtonIn(String value) {
        new ProfilePage().clickCloseButton();
    }

    @Then("I should see accounts tab")
    public void iShouldSeeAccountsTab() {
        Assert.assertTrue(new ProfilePage().accountsTab(), "Assertion on Dashboard page");
    }

    @And("I click back button in {string}")
    public void iClickBackButtonIn(String value) {
        new ProfilePage().clickBackButton(value);
    }

    @Then("I should see {string} menu")
    public void iShouldSeeMenu(String value) {
        Assert.assertTrue(new ProfilePage().menuValue(value), "Assertion on Terms and condition menu");
    }

    @And("I select {string} language")
    public void iSelectLanguage(String value) {
        new ProfilePage().selectLanguage(value);
    }

    @And("I click {string} Apply")
    public void iClickApply(String value) {
        new ProfilePage().apply(value);
    }

    @When("I navigate to app assistant menu")
    public void iNavigateToAppAssistantMenu() {
        new ProfilePage().appAssistant();
    }

    @And("I click done after viewing all the feature")
    public void iClickDoneAfterViewingAllTheFeature() throws InterruptedException {
        new HomePage().proceedTakeTour();
    }

    @And("I click on Sanad Digital ID toggle")
    public void iClickOnSanadDigitalIDToggle() {
        new ProfilePage().sanadDigitalIdToggle();
    }

    @And("I click on cancel button")
    public void iClickOnCancelButton() {
        new ProfilePage().cancel();
    }

    @And("I enter the new mobile number {string}")
    public void iEnterTheNewMobileNumber(String no) {
        new ProfilePage().mobileNumber(no);
    }

    @Then("I verify the {string} content in online Banking Security Guidelines & Tips")
    public void iVerifyTheContentContentInOnlineBankingSecurityGuidelinesTips(String content) {
        Assert.assertTrue(new ProfilePage().getContent(content).contains(content));
    }
}