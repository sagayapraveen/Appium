package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.LauncherPage;
import com.qa.pages.capitalbank.LoyaltyPage;
import com.qa.pages.capitalbank.OtpPinSetUpPage;
import com.qa.pages.capitalbank.ProfilePage;
import com.qa.pages.capitalbank.beneficiary.BeneficiariesPage;
import com.qa.pages.capitalbank.beneficiary.BeneficiaryDetailsPage;
import com.qa.pages.capitalbank.billpay.*;
import com.qa.pages.capitalbank.cards.*;
import com.qa.pages.capitalbank.dashBoard.DashboardPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import com.qa.pages.capitalbank.dashBoard.WithdrawCardless;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import com.qa.pages.capitalbank.transfers.TransfersPage;
import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class capitalMobileAppSteps extends ProjectBase {
    protected static final String LOCAL_BANK_BENEFICIARY = "Local Bank Beneficiary";
    protected static final String WITHIN_CBOJ_BENEFICIARY = "Within CBOJ Beneficiary";
    protected static final String OVERSEAS_BANK_BENEFICIARY = "Overseas Bank Beneficiary";
    protected static final String DOMESTIC = "Domestic";
    protected static final String CLIQ = "CliQ";

    @When("I click the transfers menu")
    public void iClickTheTransfersMenu() {
        new HomePage().clickTransfers();
    }

    @And("I select the new Beneficiary for transfers with the IBAN number {string}")
    public void iSelectTheNewBeneficiaryForTransfersWithTheIBANNumber(String ibanNumber) {
        new TransfersPage().clickNewBeneficiary()
                .setIban(ibanNumber)
                .clickConfirm();
    }

    @And("I enter the transfer amount {string} to {string}")
    public void iEnterTheTransferAmount(String amount, String beneficiaryType) {
        new TransferPayeePage().setAmount(beneficiaryType, amount)
                .clickOk(beneficiaryType);
        customData.setEnteredAmount(Float.parseFloat(amount));
    }

    @And("I set the recipient name {string} and recipient address {string}")
    public void iSetTheRecipientNameAndRecipientAddress(String name, String address) throws InterruptedException {
        new TransferPayeePage().swipeToDetails()
                .enterRecipientName(name)
                .enterRecipientAddress(address);
    }

    @And("I set the recipient name as {string}")
    public void iSetTheRecipientNameAs(String name) {
        new TransferPayeePage().swipeToDetails()
                .enterRecipientName(name);
    }

    @And("I select the existing Beneficiary for the transfers from the app")
    public void iSelectTheExistingBeneficiaryForTheTransfersFromTheApp() {
        new TransfersPage().existingBeneficiary();
    }

    @And("I enter the transfer purpose as")
    public void iEnterTheTransferPurposeAs(Map<String, String> table) {
        new TransferPayeePage()
                .selectPurpose("Personal")
                .selectDetailedPurpose("Standing Orders");
    }

    @And("I confirm the transfer")
    public void iConfirmTheTransfer() {
        new TransferPayeePage()
                .confirmTransfer();
    }

    @When("I click back to dashboard option")
    public void iClickBackToDashboardOption() {
        new WithdrawCardless().backToDashboard();
    }

    @When("I navigate to Profile menu")
    public void iNavigateToProfileMenu() {
        new HomePage().clickProfileIcon()
                .scrollToBeneficiaries();
    }

    @And("I select the {string} from the profile")
    public void iSelectTheFromTheProfile(String input) {
        if (input.equalsIgnoreCase(LOCAL_BANK_BENEFICIARY))
            new ProfilePage().selectLocalBank();
        else if (input.equalsIgnoreCase(WITHIN_CBOJ_BENEFICIARY))
            new ProfilePage().selectWithinCboj();
        else if (input.equalsIgnoreCase(OVERSEAS_BANK_BENEFICIARY))
            new ProfilePage().selectOverseasBank();
    }

    @And("I select the created beneficiary for {string} beneficiaries")
    public void iSelectTheExistingBeneficiaryForBeneficiaries(String option) {
        new BeneficiariesPage().selectExistingBeneficiaries(option, "AUTOMATION");
    }

    @And("I change the nickname and save")
    public void iChangeTheNicknameAndSave() {
        customData.setUpdatedNickName("Automation" + utils.getRandomString(5));

        new BeneficiaryDetailsPage()
                .updatingNickname(customData.getUpdatedNickName())
                .saveChanges();
    }

    @And("I should see the updated name in the {string} beneficiaries list")
    public void iShouldSeeTheUpdatedNameInTheCBOJBeneficiariesList(String beneficiaryType) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='" + beneficiaryType + " Beneficiaries']", 60);

        Assert.assertTrue(new BeneficiariesPage().isValuePresent(Objects.requireNonNullElse(
                customData.getUpdatedNickName(), "Automation").toUpperCase(Locale.ROOT)));
    }

    @And("I delete the created {string} beneficiary")
    public void iDeleteTheExistingCBOJBeneficiary(String beneficiaryType) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='" + beneficiaryType + " Beneficiaries']", 60);

        customData.setBeneficiaryName(new BeneficiariesPage().selectBeneficiariesWithName("AUTOMATION"));

        new BeneficiariesPage().deleteBeneficiary()
                .confirm();
    }

    @And("I delete the beneficiary with {string}")
    public void iDeleteTheBeneficiaryWith(String beneficiaryName) {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Beneficiaries']", 60);

        new BeneficiariesPage().selectBeneficiariesWithName(beneficiaryName);

        new BeneficiariesPage().deleteBeneficiary()
                .confirm();
    }

    @And("I click the add beneficiary")
    public void iClickTheAddBeneficiary() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'Beneficiaries')]", 60);

        new BeneficiariesPage().addBeneficiary();
    }

    @And("I add the new {string} beneficiary with")
    public void iAddTheNewBeneficiaryWithTheIBAN(String beneficiaryType, Map<String, String> table) {
        String address = table.get("Address") != null ? table.get("Address") : "Amman";

        String random = utils.getRandomString(5);

        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'Beneficiaries')]", 60);

        BeneficiaryDetailsPage beneficiariesPage = new BeneficiaryDetailsPage();

        if (beneficiaryType.equalsIgnoreCase("Local Bank"))
            beneficiariesPage.domesticTransaction();

        if (beneficiaryType.equalsIgnoreCase("Overseas Bank"))
            beneficiariesPage.selectBankCountry(table.get("Overseas bank country"));

        beneficiariesPage.setIban(table.get("Account/IBAN"));

        if (beneficiaryType.equalsIgnoreCase("Overseas Bank"))
            new HomePage().scroll("up");

        beneficiariesPage.setNickName("1AUTOMATION" + random.toUpperCase(Locale.ROOT))
                .setName("Test Automation " + random.toUpperCase(Locale.ROOT));

        if (!beneficiaryType.equalsIgnoreCase("Within CBOJ"))
            beneficiariesPage.setAddress(address);
    }

    @And("I add the new Local Bank beneficiary with")
    public void iAddTheNewLocalBankBeneficiaryWith(Map<String, String> table) {
        customData.setBeneficiaryTransactionType(table.get("Transaction type"));
        String cliqBeneficiaryType = table.get("Cliq beneficiary type") != null ? table.get("Cliq beneficiary type") : "";
        String ibanNumber = table.get("IBAN") != null ? table.get("IBAN") : "";
        String alias = table.get("Alias") != null ? table.get("Alias") : "";
        String mobileNumber = table.get("MobileNumber") != null ? table.get("MobileNumber") : "";

        String random = utils.getRandomString(5);

        BeneficiaryDetailsPage beneficiaryDetailsPage = new BeneficiaryDetailsPage();

        if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(DOMESTIC))
            beneficiaryDetailsPage.domesticTransaction()
                    .setIban(ibanNumber)
                    .setNickName("1Automation" + random)
                    .setName("Test Automation " + random)
                    .setAddress("Amman");
        else if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(CLIQ)) {
            beneficiaryDetailsPage.cliQ();
            if (cliqBeneficiaryType.equalsIgnoreCase("Cliq Alias"))
                beneficiaryDetailsPage.selectCliqAlias()
                        .setAlias(alias)
                        .setNickName("1Automation" + random);
            else if (cliqBeneficiaryType.equalsIgnoreCase("Cliq Mobile Number"))
                beneficiaryDetailsPage.selectCliqMobileNumber()
                        .setMobileNumber(mobileNumber)
                        .setNickName("1Automation" + random);
            else if (cliqBeneficiaryType.equalsIgnoreCase("IBAN"))
                beneficiaryDetailsPage.selectCliqIban()
                        .setIban(ibanNumber)
                        .setNickName("1Automation" + random)
                        .setName("Test Automation " + random)
                        .setAddress("Amman");
        }
    }

    @When("I set a IBAN/Account number {string}")
    public void iSetAIBANNumber(String iban) {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Beneficiary Details']", 60);
        else
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Beneficiary Details']", 60);

        new BeneficiaryDetailsPage().setIban(iban);

        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\") or contains(@name,\"Done\") or contains(@name,\"Next:\")]")).click();
    }

    @And("I confirm the {string} beneficiary details")
    public void iConfirmTheBeneficiaryDetails(String beneficiaryName) {
        new BeneficiaryDetailsPage().clickNext();

        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Confirm Details']", 60);

        int entry = 0, i = 0;

        if (beneficiaryName.equalsIgnoreCase("Within CBOJ")) {
            entry = 12;
            i = 1;
        } else if (beneficiaryName.equalsIgnoreCase("Local Bank")) {
            if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(DOMESTIC)) {
                entry = 16;
                i = 1;
            } else if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(CLIQ)) {
                entry = 7;
                i = 2;
            }
        } else if (beneficiaryName.equalsIgnoreCase("Overseas bank")) {
            entry = 12;
            i = 1;
        }
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "(//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Add profile image']/following-sibling::" + customData.getViewAttribute();
        else
            xpath = "//XCUIElementTypeStaticText[contains(@name,\"profile image\")]//following-sibling::XCUIElementTypeStaticText";

        StringBuilder content = new StringBuilder();

        if (getDriver() instanceof AndroidDriver) {
            for (; i <= entry - 1; i++) {
                content.append(getDriver().findElement(By.xpath(xpath + ")[" + i + "]")).getAttribute("content-desc").replaceAll("\n", "")).append(" - ");
                i = i + 1;
                content.append(getDriver().findElement(By.xpath(xpath + ")[" + i + "]")).getAttribute("content-desc").replaceAll("\n", "")).append("\n");
            }
        } else {
            for (i = 2; i <= entry; i++) {
                content.append(getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("name").replaceAll("\n", " ")).append(" - ");
                i = i + 1;
                content.append(getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute("name").replaceAll("\n", " ")).append("\n");
            }

        }

        logInfo(content.toString());

        new BeneficiaryDetailsPage()
                .clickConfirm();
    }

    @When("I click on pay bill button")
    public void iClickOnPayBillButton() {
        new DashboardPage().clickPayBill();
    }

    @When("I click on postpaid tab")
    public void iClickOnPostpaidTab() {
        new PayBillPage().postPaidButton();
    }

    @And("I click on pay button")
    public void iClickOnPayButton() {
        new PayBillDetailsPage().clickPayButton();
    }

    @And("I navigate to cards page")
    public void iNavigateToCardsPage() {
        new DashboardPage().clickCards();
    }

    @When("I click on cards in dashboard")
    public void iClickOnCardsInDashboard() throws InterruptedException {
        Thread.sleep(1500);
        new DashboardPage().clickCards();
    }

    @And("I click on Card Limits")
    public void iClickOnCardLimits() {
        new CardPage().clickOnCardLimit();
    }

    @When("I set the card limit {string}")
    public void iSetTheCardLimit(String amount) {
        new CardLimitPage().clickAddAmount(amount);
    }

    @And("I click on save Button on Card limit page")
    public void iClickOnSaveOnCardLimitPage() {
        new CardLimitPage().clickOnSaveButton();
    }

    @And("I select withdraw To card")
    public void ISelectWithdrawToCard() {
        new WithdrawPage().clickOnWithdrawTo();
    }

    @And("I navigate to Confirm Withdraw to Confirm the Top Up")
    public void iNavigateToConfirmWithdrawToConfirmTheTopUp() {
        new TopUpPage().clickOnConfirm();
    }

    @And("click on next button on TopUp page")
    public void clickOnNextButtonOnTopUpPage() {
        new TopUpPage().clickOnNext();
    }

    @And("I select TopUp To card")
    public void iSelectTopUpToCard() {
        new TopUpPage().clickOnVirtualCard();
    }

    @When("I enter the amount {string} for {}")
    public void iEnterTheAmountForTopUp(String amount, String Name) {
        new TopUpPage().setAmount(amount, Name)
                .clickOk(Name);
    }

    @When("I click on confirm button")
    public void IClickOnConfirmButton() {
        new TopUpPage().clickOnConfirm();
    }

    @When("I click on the the cards to proceed for cards page")
    public void iClickOnTheTheCardsToProceedForCardsPage() {
        new DashboardPage().clickCards();
    }

    @And("I clicked on the Forward arrow button on the Virtual pre-paid card")
    public void iClickedOnTheForwardArrowButtonOnTheVirtualPrePaidCard() {
        new CardPage().clickOnCardForward();
    }

    @When("I click on cards and click on Top up")
    public void iClickOnCardsAndClickOnTopUp() {
        new DashboardPage().clickCards();
        new CardPage().clickOnTopUp();
    }

    @When("I enter the amount {string} and click on enter")
    public void iEnterTheAmountAndClickOnEnter(String amount) {
        new CardLimitPage().clickAddAmount(amount);
    }

    @When("I click on prepaid button")
    public void iClickOnPrepaidButton() {
        new PayBillPage().clickPrepaidButton();
    }

    @When("I click on new Biller")
    public void iClickOnNewBiller() {
        new PayBillPage().clickNewBillerButton();
    }

    @And("I select the biller name {string} and ServiceType as {string}")
    public void iSelectTheBillerNameAndServiceTypeAs(String billerName, String type) {
        new PayBillPage().clickBillerName().swipeToBiller("up", billerName)
                .clickOnServiceTypeButton()
                .clickBillerNameWithValue("up", type);
    }

    @When("I click view history on Pay bills page")
    public void iClickViewHistoryOnPayBillsPage() {
        new PayBillPage().clickOnViewHistory();
    }

    @When("I scroll to bottom of the page")
    public void iScrollToBottomOfThePage() {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'View History')]", 90);
        else
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ", 'View History')]", 90);

        new HomePage().scroll("up");

        logInfo("Scrolling to bottom of page");
    }

    @And("I select the new biller category as {string}")
    public void iClickOnSearchForSearching(String biller) {
        new PayBillPage().clickOnSelectCategory(biller);
    }

    @And("I select the biller Name {string}")
    public void iSelectTheBillerName(String billername) {
        new PayBillPage().selectNewBiller(billername);
    }

    @And("I select the service type {string}")
    public void iSelectTheServiceType(String service) {
        new PayBillPage().selectServiceType(service);
    }

    @And("I confirm the new registration number {string}")
    public void iConfirmTheNewRegistrationNumber(String number) {
        new PayBillPage().selectRegistration(number);
    }

    @And("I set the {string} text as {string} for paybill")
    public void iSetTheTextAs(String field, String value) {
        new PayBillPage().setComments(field, value);
    }

    @And("I click on the prepaid {string}")
    public void iClickOnThePrepaid(String text) {
        new PayBillPage().clickOnPrepaid(text);
    }

    @And("I select the denomination {string} and click on next")
    public void iSelectTheDenominationAndClickOnNext(String mobile) {
        new PayBillPage().clickPrePaidDenomination()
                .clickDenomination(mobile)
                .clickOnNext();
    }

    @And("I select the beneficiary transaction type as {string}")
    public void iSelectTheTransactionTypeAs(String transactionType) {
        customData.setBeneficiaryTransactionType(transactionType);

        if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(DOMESTIC))
            new BeneficiaryDetailsPage().domesticTransaction();
        else if (customData.getBeneficiaryTransactionType().equalsIgnoreCase(CLIQ))
            new BeneficiaryDetailsPage().cliQ();
    }

    @And("I select the beneficiary type as {string}")
    public void iSelectTheBeneficiaryTypeAs(String beneficiaryType) {
        if (beneficiaryType.equalsIgnoreCase("CliQ IBAN"))
            new BeneficiaryDetailsPage().selectCliqIban();
    }

    @When("I change the invalid {string} as {string}")
    public void iChangeTheInvalidNickname(String field, String value) {
        if (field.equalsIgnoreCase("nickname"))
            new BeneficiaryDetailsPage()
                    .updatingNickname(value);
        else if (field.equalsIgnoreCase("iban"))
            new BeneficiaryDetailsPage().setIban(value);

        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Beneficiary Details']", 30);
        else
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Beneficiary Details']", 30);
    }

    @When("I clear the nickname to proceed")
    public void iClearTheNicknameToProceed() {
        new BeneficiaryDetailsPage().setNickName("Test")
                .clearNickName();
    }

    @When("I clear the name to proceed")
    public void iClearTheNameToProceed() {
        new BeneficiaryDetailsPage().setName("Test")
                .clearName();
    }

    @When("I clear the address to proceed")
    public void iClearTheAddressToProceed() {
        new BeneficiaryDetailsPage().setAddress("Test")
                .clearAddress();
    }

    @And("I enter the mobile number on Pay bill page")
    public void iEnterTheMobileNumberOnPayBIllPage() {
        new PayBillPage().enterMobileNumber();
    }

    @And("I click on pay button on pay new bill page")
    public void iClickOnPayButtonOnPayNewBillPage() {
        new PayPrepaidNewBillPage().clickPayButton();
    }

    @And("I click on confirm in confirm bill page")
    public void iClickOnConfirmInConfirmBillPage() {
        new PrepaidBillConfirmPage().clickConfirmButton();
    }

    @And("I select the denomination and click on next")
    public void iSelectTheDenominationAsAndClickOnNext() {
        new PayBillPage().clickPrePaidDenomination()
                .clickOnDenomination()
                .clickOnNext();
    }

    @And("I click on card details")
    public void iClickOnCardDetails() {
        new CardPage().clickOnCardDetailsWidget();
    }

    @And("I navigate to add new card menu")
    public void iNavigateToAddNewCardMenu() throws InterruptedException {
        new AddNewCard().swipeToAddToCard().clickOnAddNewCard();
    }

    @And("I set the CardHolder name {string} and linked Mobile Number {string}")
    public void iSetTheCardHolderNameAndLinkedMobileNumber(String name, String number) {
        new AddNewCard()
                .enterCardHolderName(name)
                .enterMobileNumber(number)
                .clickOnNextButton();
    }

    @When("I confirm the card details")
    public void iConfirmTheCardDetails() {
        new AddNewCard().clickOnConfirmButton();
    }

    @And("I navigate to cancel card Menu")
    public void iNavigateToCancelCardMenu() throws InterruptedException {
        new CancelCardPage().swipeToCancelCard()
                .clickOnCancelCardButton();
    }

    @And("I click on TopUp menu")
    public void iClickOnTopUpMenu() {
        new CardPage().clickOnTopUp();
    }

    @And("I navigate to toggle deactivate menu")
    public void iNavigateToToggleDeactivateMenu() throws InterruptedException {
        new DeactivateCardPage().swipeToDeactivateCard();
    }

    @And("I click on {} card toggle")
    public void iClickOnDeactivateCardToggle(String action) {
        if (action.equalsIgnoreCase("Deactivate")) {
            if (!new CardPage().fetchCardStatus().toUpperCase(Locale.ROOT).contains("WARM"))
                new DeactivateCardPage().clickOnDeactivateCardToggle()
                        .clickOnConfirmButton();
        } else if (action.equalsIgnoreCase("activate"))
            new DeactivateCardPage().clickOnActivateToggle();
    }

    @And("I search for {string} in Transfers page")
    public void iSearchFor(String countryName) {
        new TransfersPage().searchForCountry(countryName).clickCountry();
    }

    @And("I set the beneficiary name {string} and beneficiary address {string}")
    public void iSetTheBeneficiaryNameAndBeneficiaryAddress(String name, String address) throws InterruptedException {
        new TransferPayeePage().swipeToName()
                .enterBeneficiaryName(name)
                .enterBeneficiaryAddress(address);
    }

    @And("I set the Routing Number {string} for payee")
    public void iSetTheRoutingNumber(String number) {
        new TransferPayeePage().enterRoutingNumber(number);
    }

    @And("I set the Swift Label {string} for payee")
    public void iSetTheSwiftLabel(String label) {
        new TransferPayeePage().enterSwiftLabel(label);
    }

    @And("I click on Shared Fees radio button for transfers")
    public void iClickOnRadioButton() {
        Boolean sharedRadioButton = true;
        new HomePage().scroll("up");
        new TransferPayeePage().selectFeeRadioButton()
                .clickNext();
    }

    @When("I confirm cancelling the card")
    public void iConfirmCancellingTheCard() {
        new CancelCardPage().clickOnConfirmButton();
    }

    @And("I click on the back to dashboard in successful bill page")
    public void iClickOnTheBackToDashboardInSuccessfulBillPage() {
        new PayBillPage().clickOnDashboard();
    }

    @And("I select the last two saved biller")
    public void iSelectTheLastTwoSavedBiller() throws InterruptedException {
        new PayBillPage().clickOnBiller();
    }

    @And("I click on the save biller under {string}")
    public void iClickOnTheSaveBillerUnder(String page) {
        new PayBillSuccessfulPage().clickOnSaveBiller(page);
    }

    @And("I click on saved biller {string} in pay to page")
    public void iClickOnSavedBillerInPayToPage(String biller) {
        new PayBillPage().clickOnPrepaidSavedBiller(biller);
    }

    @And("I select the denomination {string}")
    public void iSelectTheDenomination(String mobile) {
        new PayBillPage().clickPrepaidDenomination(mobile);
    }

    @And("I fill the basic beneficiary details for {string} beneficiary")
    public void iFillTheBasicBeneficiaryDetailsForBeneficiary(String beneficiaryType) {
        new BeneficiaryDetailsPage().updatedName("Test Test Test")
                .setNickName("TestNickname")
                .clickNext();
    }

    @When("I click the Register from capitalMobile app launcher")
    public void iClickTheRegisterFromCapitalMobileAppLauncher() {
        new LauncherPage().clickCloseButton().register();
    }

    @When("I click the forget username password link")
    public void iClickTheForgetUsernamePasswordLink() {
        new LauncherPage().clickLogin().clickCloseButton().forgotLogin();
    }

    @And("I Select the amount as {string}")
    public void iSelectTheAmountAs(String currency) {
        new TransferPayeePage().selectAmount()
                .enterCurrency(currency).selectCurrency();
    }

    @And("I click on Withdraw Menu")
    public void iClickOnWithdrawMenu() {
        new WithdrawPage().clickOnWithdraw();
    }

    @And("I select {string} account under user Account")
    public void iSelectAccountUnderUserAccount(String countryName) {
        new TransferPayeePage().selectCard(countryName);
    }

    @And("I enter the enter billing number {string}")
    public void iEnterTheEnterBillingNumber(String billerNumber) {
        new PayBillPage().enterBillerNumber(billerNumber);
    }

    @And("I scroll to bottom of the pay new biller")
    public void iScrollToBottomOfThePayNewBiller() {
        new PayBillPage().swipePayTo("up");
    }

    @And("I click on next in pay to page")
    public void iClickOnNextInPayToPage() throws InterruptedException {
        new OtpPinSetUpPage().next();
    }

    @And("I click on the back to dashboard in postpaid success bill")
    public void iClickOnTheBackToDashboardInPostpaidSuccessBill() {
        new PayBillPage().clickBackToDashBoardPostpaid();
    }

    @And("I select the last two saved biller in prepaid")
    public void iSelectTheLastTwoSavedBillerInPrepaid() throws InterruptedException {
        new PayBillPage().prepaidSavedBiller();
    }

    @And("I enter the nick name on add as save biller page")
    public void iEnterTheNickNameOnAddAsSaveBiller() {
        new PayBillPage().enterNickName(new TestUtils().getRandomString(10));
    }

    @And("I select the first two saved biller")
    public void iSelectTheFirstTwoSavedBiller() throws InterruptedException {
        new PayBillPage().clickOnSavedBiller();
    }

    @And("I scroll to amount text field of the pay new biller")
    public void iScrollToAmountTextFieldOfThePayNewBiller() {
        new PayBillPage().swipeAmountTextFiled("up");
    }

    @And("I delete the entries already present and enter the amount {string}")
    public void iDeleteTheEntriesAlreadyPresentAndEnterTheAmount(String amount) {
        new PayBillPage().clickOnBillerAmount(amount);
    }

    @And("I scroll to saved biller in pay bill page")
    public void iScrollToSavedBillerInPayBillPage() {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'View History')]", 90);
        else
            utils.waitForElement(getDriver(), "//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ", 'View History')]", 90);
        new HomePage().scroll("up", 0.7);
        logInfo("Scroll to saved biller");
    }

    @When("I verify the {string} card")
    public void iVerifyTheCard(String card) {
        String visaCard = new PayBillPage().clickOnCard();
        Assert.assertTrue(visaCard.contains(card));
    }

    @And("I enter the mobile number as {string} on Pay bill page")
    public void iEnterTheMobileNumberAsOnPayBillPage(String number) {
        new PayBillPage().mobileNumber(number);
    }

    @And("I select new Beneficiary for transfers with the IBAN number {string}")
    public void iSelectNewBeneficiaryForTransfersWithTheIBANNumber(String ibanNumber) {
        new TransfersPage()
                .setIban(ibanNumber)
                .clickConfirm();
        customData.setPayToCurrency(ibanNumber);
    }

    @And("I selected the amount as {string}")
    public void iSelectedTheAmountAs(String currency) {
        new TransferPayeePage().selectCurrencyType()
                .enterCurrency(currency).selectCurrency();
    }

    @When("I select the newly added card {string} and click on cancel card")
    public void iSelectTheNewlyAddedCardAndClickOnCancelCard(String cardName) throws InterruptedException {
        new CancelCardPage().clickOnCard(cardName)
                .clickOnCancelCardButton();
    }

    @And("I enter the payment details as {string}")
    public void iEnterThePaymentDetailsAs(String paymentDetails) {
        new HomePage().scroll("up");
        new WithdrawPage().enterPaymentDetails(paymentDetails);
    }

    @And("I click on next button for TopUp page")
    public void iClickOnNextButton() {
        new TopUpPage().clickOnNext();
    }

    @Then("I verify {string} button is clickable")
    public void iVerifyButtonIsClickable(String button) {
        Assert.assertTrue(new CardPage().isMenuClickable(button));
        logInfo(button + " is clickable");
    }

    @When("I swipe to add card menu")
    public void iSwipeToAddCardMenu() throws InterruptedException {
        new AddNewCard().swipeToAddToCard();
    }

    @And("I select add new card button")
    public void iSelectAddNewCardButton() {
        new AddNewCard().clickOnAddNewCard();
    }

    @And("I click on Top up Card button")
    public void iClickOnTopUpCardButton() {
        new AddNewCard().clickTopUpCard();
    }

    @And("I select the account to transfer the balance with account {string}")
    public void iSelectTheAccountToTransferTheBalanceWithAccount(String account) {
        String cardDetails = new CancelCardPage().clickCardToTransferBalance(account);
        logInfo("Card details" + cardDetails);
        customData.setCardBalance(Double.parseDouble(cardDetails.split("Balance\n")[1]
                .split(" ")[0].replace(",", "")));

        logInfo("The total available balance in card is " + customData.getCardBalance());
    }

    @And("I select the card with account Number {string}")
    public void iSelectTheCardWithAccountNumber(String accountNumber) {
        new TopUpPage().selectTopUPFromCard(accountNumber);
    }

    @And("I click on account in dashboard")
    public void IClickOnAccountInDashboard() {
        new HomePage().scroll("right");
        new DashboardPage().clickAccount();
    }

    @When("I select withdraw To card for the available limit {string}")
    public void iSelectWithdrawToCardForTheAvailableLimit(String name) {
        WithdrawPage withdrawPage = new WithdrawPage();

        float amount = withdrawPage.withdrawFromDetails();
        withdrawPage.clickOnWithdrawTo();
        withdrawPage.setAmount(name, amount);

        new TopUpPage().clickOk(name);
    }

    @And("I select the card with name {string}")
    public void iShouldSelectTheCardWithName(String cardName) throws InterruptedException {
        new TopUpPage().selectCard(cardName);
    }

    @And("I delete the existed entries and enter the amount {string}")
    public void iDeleteTheExistedEntriesAndEnterTheAmount(String amount) {
        customData.setPayBillAmount(String.valueOf(Float.parseFloat(amount)));
        new PayBillPage().clickOnAmount(customData.getPayBillAmount());
    }

    @And("I view the available number of cards")
    public void iViewTheAvailableNumberOfCards(DataTable cardDetail) throws InterruptedException {
        List<List<String>> cardDetails = cardDetail.asLists();

        int count = new AddNewCard().countOfCard();

        for (int i = count; i < 5; i++) {
            logInfo("The number of card available is " + count);
            new AddNewCard().swipeToAddToCard()
                    .clickOnAddNewCard()
                    .enterCardHolderName(cardDetails.get(0).get(i))
                    .enterMobileNumber(cardDetails.get(1).get(i))
                    .clickOnNextButton()
                    .clickOnConfirmButton();

            new WithdrawCardless().backToDashboard();

            logInfo("The name is " + cardDetails.get(0).get(i));
            logInfo("The number is " + cardDetails.get(1).get(i));
        }
    }

    @And("I should see Loyalty widget")
    public void iShouldSeeLoyaltyWidget() {
        Assert.assertEquals("Redeem now", new LoyaltyPage().redeemNowButtonVisibility());
        logInfo("Loyalty widget is present in the dashboard");
    }

    @And("I should see {string} in the Loyalty widget")
    public void iShouldSeeLoyaltyPointInTheLoyaltyWidget(String text) {
        Assert.assertTrue(new LoyaltyPage().loyaltyPointsText().contains(text),
                "Assertion on Loyalty points");

        logInfo("Loyalty point is present in the dashboard");
    }

    @When("I click on Redeem now button")
    public void iClickOnRedeemNowButton() {
        new LoyaltyPage().clickingRedeemNowButton();
    }

    @Then("I should see app in the {string} in Loyalty")
    public void iShouldSeeAppInTheInLoyalty(String page) {
        String referenceMessage = new LoyaltyPage().getLoyaltyPage();
        Assert.assertTrue(referenceMessage.contains(page));
        logInfo("App is in " + referenceMessage);
    }

    @And("I should see View Details and Redeem button in Loyalty page")
    public void iShouldSeeViewDetailsAndRedeemButtonInLoyaltyPage() {
        Assert.assertTrue(new LoyaltyPage().isViewDetailsDisplayed(), "Assertion on Redeem ViewDetails");
        Assert.assertTrue(new LoyaltyPage().isRedeemDisplayed(), "Assertion on Redeem button");
    }

    @When("I click on view Details link")
    public void iClickOnViewDetailsLink() {
        new LoyaltyPage().clickViewDetails();
    }

    @Then("I should see info about Points collected and Expiry details")
    public void iShouldSeeInfoAboutPointsCollectedAndExpiryDetails() {
        String referenceMessage = new LoyaltyPage().pointsCollectedAndExpiryDetails();
        logInfo(referenceMessage);
        Assert.assertTrue(referenceMessage.contains
                        ("Collected points will be valid for 24 months"),
                "Assertion on loyalty points");
    }

    @When("I click on History tab in Loyalty Points page")
    public void iClickOnHistoryTabInLoyaltyPointsPage() {
        new LoyaltyPage().clickingHistoryTab();
    }

    @When("I click on search button in history page")
    public void iClickOnSearchButtonInHistoryPage() {
        new LoyaltyPage().clickOnSearch();
    }

    @And("I click on {string} filter")
    public void iClickOnFilter(String value) {
        new LoyaltyPage().filterBy(value);
    }

    @When("I click on Redeem button")
    public void iClickOnRedeemButton() {
        new LoyaltyPage().clickingRedeemButton();
    }

    @And("I enter Redeem points {string}")
    public void iEnterRedeemPoints(String amount) {
        new LoyaltyPage().enteringRedeemAmount(amount)
                .clickOnTab();
    }

    @And("I should see Confirm Redeem page")
    public void iShouldSeeConfirmRedeemPage() {
        String referenceMessage = new LoyaltyPage().confirmRedeem();
        Assert.assertTrue(referenceMessage.contains("Confirm Redeem"), "Assertion on Redeem Reference message");
        logInfo("App is in " + referenceMessage);
    }

    @And("I should see the page as Redeemed history")
    public void iShouldSeeThePageAsRedeemedHistory() {
        String referenceMessage = new LoyaltyPage().filterRedeemPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(referenceMessage.contains("Redeemed"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Gained"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Expired"), "Assertion on Loyalty history");

        softAssert.assertAll();
    }

    @And("I should see the page as Gained history")
    public void iShouldSeeThePageAsGainedHistory() {
        String referenceMessage = new LoyaltyPage().filterGainedPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(referenceMessage.contains("Gained"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Redeemed"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Expired"), "Assertion on Loyalty history");

        softAssert.assertAll();
    }

    @And("I should see the page as No Data Found history")
    public void iShouldSeeThePageAsNoDataFoundHistory() {
        String referenceMessage = new LoyaltyPage().filterExpiredPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(referenceMessage.contains("No Data Found"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Redeemed"), "Assertion on Loyalty history");
        softAssert.assertFalse(referenceMessage.contains("Gained"), "Assertion on Loyalty history");

        softAssert.assertAll();
    }

    @When("I click on Confirm button")
    public void iClickOnConfirmButton() {
        new LoyaltyPage().clickConfirmButton();
    }


    @And("I set the card limit for VPC")
    public void iSetTheCardLimitForVPC() {
        customData.setCardLimit(new CardLimitPage().enterNewCardLimit());
    }

    @Then("I should see the new limit for the card got updated")
    public void iShouldSeeTheNewLimitForTheCardGotUpdated() {
        Assert.assertEquals(new CardLimitPage().getCardLimit().split(",")[0], customData.getCardLimit(),
                "Assertion on updated card limit");
    }

    @And("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String cardType) {
        new CardPage().selectCardDropdown().clickCard(cardType);
    }

    @Then("I should see the Redeem successful message {string}")
    public void iShouldSeeTheRedeemSuccessfulMessage(String message) {
        String text = String.valueOf(new LoyaltyPage().redeemSuccessMessage());
        Assert.assertTrue(text.contains(message), "Assertion in Redeem successful page");
    }

    @And("I enable the E-commerce purchase")
    public void iEnableTheECommercePurchase() {
        new CardLimitPage().clickOnEnableButton();
    }

    @When("I enter name as {string}")
    public void iEnterNameAs(String value) {
        new BeneficiaryDetailsPage().editedNickName(value);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"Next:\")]")).click();
    }

    @When("I enter address as {string}")
    public void iEnterAddressAs(String value) {
        new BeneficiaryDetailsPage().editedAddress(value);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"Next:\")]")).click();
    }
}