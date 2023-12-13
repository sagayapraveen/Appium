package com.qa.pages.capitalbank.myTransfers;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class MyTransfersPage extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='My Transfers']//..//../android.widget.ImageView)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='My Transfers']//preceding::XCUIElementTypeButton[1]")
    protected WebElement backButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='My Transfers']//..//../android.widget.ImageView)[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Capital Bank\"]//ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    protected WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search Filter']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Search Filter']")
    protected WebElement searchFilterPage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Account')]/android.view.View[1]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Account')]//ancestor::XCUIElementTypeOther[1]//XCUIElementTypeOther//XCUIElementTypeButton[2]")
    protected WebElement shareButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Customer ID')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Customer ID')]")
    protected WebElement profileMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View Swift Image\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View Swift Image\"]")
    protected WebElement viewSwiftImage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Beneficiary Name')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Beneficiary Name')]")
    protected WebElement transactionDetails;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Account')]//android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Account')]/ancestor::XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    protected WebElement backFromTransactionPage;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnBackButton() {
        waitForVisibility(backButton);
        click(backButton, "Clicking ob back button");
    }

    public String profileMenu() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getTextWithAttribute(profileMenu, attribute);
    }

    public void selectTab(String tab) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'My')]", 60);

        By xpath = By.xpath("//*[contains(@" + attribute + ",'" + tab.substring(4) + "')]");
        tapOnPosition(getDriver().findElement(xpath).getLocation().x + 50, getDriver().findElement(xpath).getLocation().y + 10);
    }

    public void clickOnSearchIcon() {
        click(searchIcon, "Clicking on search icon");
    }

    public String searchFilterPage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(searchFilterPage);
        return getTextWithAttribute(searchFilterPage, attribute);
    }

    public void selectTransactionDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Sent')][1]", 60);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Sent')][1]"), "Clicking on transfer details to share");
    }

    public boolean sharePage() {
        waitForVisibility(shareButton);
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(shareButton, "clickable"));
        else
            return Boolean.parseBoolean(getTextWithAttribute(shareButton, "enabled"));
    }

    public String fetchTransactionDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(transactionDetails, attribute);
    }

    public void selectTransaction(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        By type = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + name.substring(2) + "')]");
        scrollUntilElementPresent(type, "up", 0.40);
        String value = getAttribute(type, attribute);

        if (value.contains(name))
            click(type, "Clicking " + name + " card");
        else {
            logInfo("Transaction is not found for this Customer");
            throw new RuntimeException();
        }
    }

    public boolean viewSwiftImage() {
        waitForVisibility(viewSwiftImage);
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(viewSwiftImage, "clickable"));
        else
            return Boolean.parseBoolean(getTextWithAttribute(viewSwiftImage, "enabled"));
    }

    public MyTransfersPage clickOnBackButtonFromTransactionPage() {
        click(backFromTransactionPage);
        return this;
    }

    public void scrollToTop() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        By type = By.xpath("//" + parentAttribute + "[@" + attribute + "='Overseas']");
        scrollUntilElementPresent(type, "down", 0.30);
    }
}
