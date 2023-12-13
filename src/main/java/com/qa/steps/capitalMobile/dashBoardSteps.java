package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.cards.DeactivateCardPage;
import com.qa.pages.capitalbank.dashBoard.*;
import com.qa.pages.capitalbank.investment.InvestmentsPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.Map;

public class dashBoardSteps extends ProjectBase {
    @When("I select the card as {string}")
    public void iSelectTheCardAs(String card) throws InterruptedException {
        InvestmentsPage investment = new InvestmentsPage();

        investment.selectPayFromCard(card);

        customData.setPayFromCardDetails(investment.payFromCard(card));
    }

    @Then("I should verify the {} card details in Account detail tab")
    public void iShouldVerifyCardDetailsInAccountDetailTab(String type) {
        String value = new DashboardPage().accountDetails(type);

        logInfo("Account Details are " + value);

        Assert.assertTrue(customData.getPayFromCardDetails().contains(value), "Assertion on Account details in dashboard.");
    }

    @When("I select view portfolio button")
    public void iSelectViewPortfolioButton() {
        new DashboardPage().viewPortfolio();
    }

    @And("I should see Share My Account Number link")
    public void iShouldSeeShareMyAccountNumberLink() {
        Assert.assertTrue(new DashboardPage().shareMyAccountLink().contains("Share My Account Number"),
                "Assertion on Share My Account Number link");
    }

    @And("I should see Share My IBAN link")
    public void iShouldSeeShareMyIBANLink() {
        Assert.assertTrue(new DashboardPage().shareMyIBANLink().contains("Share My IBAN"),
                "Assertion on Share My IBAN link");
    }

    @And("I select card in {} with {}")
    public void iSelectCardInAccountTypeWithCurrency(String type, String currency) {
        customData.setPayFromCardDetails(new DashboardPage().getCard(type, currency));

        new DashboardPage().selectCard(type, currency);
    }

    @When("I navigate to Request Money menu")
    public void iNavigateToRequestMoneyMenu() {
        new HomePage().clickRequestMoney();
    }

    @And("I enter the request money amount")
    public void iEnterTheRequestMoneyAmount() {
        String value = utils.getRandomNumber(2);
        new RequestMoneyPage().enterMoney(value)
                .selectOk();
        customData.setEnteredAmount(Float.parseFloat(value));
    }

    @And("I select the existing Beneficiary {string} for the Request money")
    public void iSelectTheExistingBeneficiaryForTheRequestMoney(String beneficiaryName) {
        new RequestMoneyPage().myBeneficiaries()
                .clickExistingBeneficiary(beneficiaryName);
        customData.setRequestType(beneficiaryName);
    }

    @And("I select the purpose as {string}")
    public void iSelectThePurposeAs(String purpose) {
        new RequestMoneyPage().selectPurpose(purpose)
                .clickNext();
        customData.setPurposeType(purpose);
    }

    @Then("I verify the {string} entered details")
    public void iVerifyTheEnteredDetails(String value) {
        RequestMoneyPage request = new RequestMoneyPage();
        SoftAssert softAssert = new SoftAssert();

        if (value.equalsIgnoreCase("IBAN")) {
            softAssert.assertEquals(request.recipientName(), customData.getRecipientName().toUpperCase(), "Assertion on Recipient Name");
            softAssert.assertEquals(request.recipientAddress(), customData.getRecipientAddress(), "Assertion on Recipient Address");
            softAssert.assertTrue(request.requestType().contains(customData.getRequestType()), "Assertion on Request Type");
        } else if (value.equalsIgnoreCase("ALIAS") || value.equalsIgnoreCase("MOBILE")) {
            softAssert.assertTrue(request.requestType().contains(customData.getRequestType()), "Assertion on Request Type");
        } else if (value.equalsIgnoreCase("EXISTING")) {
            softAssert.assertEquals(request.recipientName(), customData.getRequestType().toUpperCase(), "Assertion on Recipient Name");
        }

        softAssert.assertEquals(request.purpose(), customData.getPurposeType(), "Assertion on purpose");
        softAssert.assertEquals(Float.parseFloat(request.amount().split(" ")[0]), customData.getEnteredAmount(), "Assertion on entered amount");
        softAssert.assertEquals(request.descriptionConfirm(), customData.getDescription(), "Assertion on description");
        softAssert.assertAll();
    }

    @And("I confirm the Request money")
    public void iConfirmTheRequestMoney() {
        new RequestMoneyPage().confirmRequest();
    }


    @And("I select new beneficiary with {string}")
    public void iSelectNewBeneficiaryWith(String val) {
        new RequestMoneyPage().clickNewBeneficiary()
                .beneficiaryDropDown()
                .selectBeneficiaryIBAN(val);
    }

    @And("I enter {string}")
    public void iEnter(String value) {
        if (value.equals(""))
            new RequestMoneyPage().enterBeneficiaryNullValue();
        else
            new RequestMoneyPage().enterBeneficiaryValue(value).clickNext();

        customData.setRequestType(value);
    }

    @And("I enter  request details")
    public void iEnterRequestDetails(Map<String, String> details) {

        new RequestMoneyPage().purposePageSelectOk()
                .enterRecipientName(details.get("Recipient Name"))
                .enterRecipientAddress(details.get("Recipient Address"))
                .enterDescription(details.get("Description"));

        customData.setRecipientName(details.get("Recipient Name"));
        customData.setRecipientAddress(details.get("Recipient Address"));
        customData.setDescription(details.get("Description"));
    }

    @And("I enter request details description as {string}")
    public void iEnterRequestDetailsDescriptionAs(String value) {
        new RequestMoneyPage().enterDescription(value);
        customData.setDescription(value);
    }

    @And("I select done button in details page")
    public void iSelectDoneButtonInDetailsPage() {
        new RequestMoneyPage().purposePageSelectOk();
    }

    @When("I navigate to withdraw cardless page")
    public void iNavigateToWithdrawCardlessPage() {
    }

    @When("I navigate to cashless withdraw menu")
    public void iNavigateToCashlessWithdrawMenu() {
        new WithdrawCardless().openWithdrawCardless()
                .clickCardlessWithdraw();
    }

    @And("I enter the withdraw amount as {string}")
    public void iEnterTheWithdrawAmountAs(String amount) {
        new WithdrawCardless().inputAmount(amount)
                .clickOk();
        customData.setEnteredAmount(Float.parseFloat(amount));
    }

    @And("I confirm the withdraw transaction")
    public void iConfirmTheWithdrawTransaction() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Confirm Payment']", 90);

        Assert.assertTrue(new WithdrawCardless().confirmPageDetails().replaceAll("\n", " ").replaceAll(",", "")
                        .contains(String.valueOf(customData.getEnteredAmount())),
                "Assertion on entered amount");

        new WithdrawCardless().confirmPayment();
    }

    @When("I navigate to manage cheques menu")
    public void iNavigateToManageChequesMenu() {
        new ManageCheques().openManageCheques();
    }


    @When("I select the cheque book as {string}")
    public void iSelectTheChequeBookAs(String value) {
        new ManageCheques().selectChequeBook(value);
        customData.setChequeBook(value);
    }

    @And("I select the cheque leaves as {string}")
    public void iSelectTheChequeLeavesAs(String value) {
        new ManageCheques().selectChequeLeaves(value);
        customData.setChequeLeaves(value);
    }

    @And("I select the Language as {string}")
    public void iSelectTheLanguageAs(String value) {
        new ManageCheques().selectLanguage(value);
        new InvestmentsPage().nextButton();
        customData.setChequeLanguage(String.valueOf(value.charAt(0)));
    }

    @Then("I confirm the entered cheque details")
    public void iConfirmTheEnteredChequeDetails() {
        String value = new ManageCheques().getConfirmationPageDetails();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(value.contains(customData.getChequeLeaves()), "Assertion on cheque leaves");
        softAssert.assertTrue(value.contains(customData.getChequeBook()), "Assertion on cheque book");
        softAssert.assertTrue(value.contains(customData.getChequeLanguage()), "Assertion on cheque language");

        softAssert.assertAll();

        new DeactivateCardPage().clickOnConfirmButton();
    }

    @When("I should see ATM Branches menu")
    public void iNavigateToATMBranchesMenu() {
        Assert.assertTrue(new DashboardPage().openATMBranches());
    }

    @And("I navigate to Request History menu")
    public void iNavigateToRequestHistoryMenu() {
        new RequestMoneyPage().openRequestHistory();
    }

    @Then("I should see the latest transaction details")
    public void iShouldSeeTheLatestTransactionDetails() {
        String value = "";
        if (getDriver() instanceof AndroidDriver)
            value = new RequestMoneyPage().getTransactionDetails(customData.getEnteredAmount()).split(customData.getDate())[1];
        else
            value = new RequestMoneyPage().getTransactionDetails(customData.getEnteredAmount()).split(customData.getDate())[0];

        logInfo("The status of the transaction is : " + value);

        Assert.assertTrue(value.trim().contains("Pending"), "Assertion on request money Status");
    }

    @Then("I should see the withdraw successful message")
    public void iShouldSeeTheWithdrawSuccessfulMessage() {
        Assert.assertTrue(new WithdrawCardless().successMessage().contains(
                LocalDate.now().getDayOfMonth() + " " + LocalDate.now().getMonth().toString().charAt(0) +
                        LocalDate.now().getMonth().toString().toLowerCase().substring(1) + " " +
                        LocalDate.now().getYear()), "Assertion on success message");
    }

    @Then("I should see the {string} and {string} tab")
    public void iShouldSeeTheAndTab(String request, String postDated) {
        DashboardPage dashboard = new DashboardPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(request.toUpperCase(), dashboard.request(request), "Assertion on Request Tab");
        softAssert.assertEquals(postDated.toUpperCase(), dashboard.postDated(postDated), "Assertion on Post Dated Tab");

        softAssert.assertAll();
    }

    @When("I click on Share My IBAN link")
    public void iClickOnShareMyIBANLink() {
        new DashboardPage().clickMyIBANLink();
    }

    @Then("I should see {string} message for IBAN link")
    public void iShouldSeeMessageForIbanLink(String message) {
        DashboardPage dashboard = new DashboardPage();
        Assert.assertEquals(dashboard.successMessageIBANLink(message), "Your information has been shared with the Social Security Corporation successfully!", "Assertion on success message");
        dashboard.done();
    }

    @And("I select the request tab")
    public void iSelectTheRequestTab() {
        new RequestMoneyPage().selectRequest();
    }

    @And("I {string} the request")
    public void iTheRequest(String value) {
        new RequestMoneyPage().actionRequest(value, customData.getDate());
    }

    @Then("I should see {string}")
    public void iShouldSee(String message) {
        Assert.assertTrue(new RequestMoneyPage().successMessage().contains(message), "Assertion on success message");

        customData.setDate(new RequestMoneyPage().acceptTime(String.valueOf(customData.getEnteredAmount())));
    }

    @Then("I should see the request {string} in request history menu")
    public void iShouldSeeTheRequestInRequestHistoryMenu(String Value) {
        String value = new RequestMoneyPage().getTransactionDetails(customData.getEnteredAmount())
                .split(customData.getDate())[1];

        logInfo("The status of the transaction is : " + value);

        Assert.assertEquals(value.trim(), Value, "Assertion on request money Status");
    }

    @When("I navigate to QR Pay menu")
    public void iNavigateToQRPayMenu() {
        new DashboardPage().openQRPay();
    }

    @And("I click close button in QR Pay")
    public void iClickCloseButtonInQRPay() {
        new DashboardPage().closeButton();
    }

    @Then("I should see QR Pay menu")
    public void iShouldSeeQRPayMenu() {
        Assert.assertTrue(new DashboardPage().displayQRPay());
    }
}