package com.qa.pages.capitalbank.beneficiary;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class BeneficiariesPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'SUCCESS')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'SUCCESS')]")
    protected WebElement successMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Delete this beneficiary']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete this beneficiary']")
    protected WebElement deleteBeneficiary;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Beneficiaries')]//..//../android.widget.ImageView)[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Beneficiaries\")]//ancestor::XCUIElementTypeOther[2]/XCUIElementTypeButton")
    protected WebElement clickAddBeneficiary;

    @Override
    protected void waitForAppToLoad() {
    }

    public void selectExistingBeneficiaries(String beneficiaryType, String beneficiaryName) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + beneficiaryType + " Beneficiaries']", 90);
        scroll("up");
        By xpath = By.xpath("//*[contains(@" + attribute + ", '" + beneficiaryName + "')]");

        scrollUntilElementPresent(xpath, "up", 0.5);

        click(xpath, "Selecting existing beneficiary " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public String selectBeneficiariesWithName(String beneficiaryName) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + beneficiaryName + "')]");
        scroll("up");
        scrollUntilElementPresent(xpath, "up", 0.5);

        String name = getAttribute(xpath, attribute);

        click(xpath, "Selecting existing beneficiary " + getAttribute(xpath, attribute).replaceAll("\n", " "));
        return name;
    }

    public String getSuccessMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(successMessage, attribute);
    }

    public boolean isValuePresent(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        int matches = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + value + "')]")).size();

        boolean result = false;

        if (matches == 1) {
            logInfo("Value '" + value + "' is present in the list");
            result = true;
        } else if (matches == 0)
            logInfo("Value '" + value + "' is not present in the list");

        return result;
    }

    public boolean isValueNotPresent(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        if (value.contains(" "))
            value = value.split(" ")[1].replaceAll("\n", " ");

        boolean result = false;

        int count = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + value + "')]")).size();

        if (count == 0) {
            result = true;
            logInfo("Value '" + value.replaceAll("\n", " ") + "' is not present in the list");
        } else
            logInfo("Value '" + value.replaceAll("\n", " ") + "' is present in the list");

        return result;
    }

    public BeneficiariesPage deleteBeneficiary() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        scroll("up", 0.75);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute2 + "[@" + attribute + "='Delete this beneficiary']"), "up", 0.5);
        click(deleteBeneficiary, "Clicking delete beneficiary");
        return this;
    }

    public void confirm() {
        click(confirm, "Clicking confirm");
    }

    public void addBeneficiary() {
        click(clickAddBeneficiary, "Clicking add beneficiary");
    }
}
