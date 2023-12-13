package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProfilePage extends BasePage {
    @AndroidFindBy(accessibility = "Within CBOJ Beneficiaries")
    @iOSXCUITFindBy(accessibility = "Within CBOJ Beneficiaries")
    protected WebElement withInCboj;
    @AndroidFindBy(accessibility = "Local Bank Beneficiaries")
    @iOSXCUITFindBy(accessibility = "Local Bank Beneficiaries")
    protected WebElement localBankBeneficiaries;
    @AndroidFindBy(accessibility = "Overseas Bank Beneficiaries")
    @iOSXCUITFindBy(accessibility = "Overseas Bank Beneficiaries")
    protected WebElement overseasBeneficiaries;
    @AndroidFindBy(accessibility = "My Transfers")
    @iOSXCUITFindBy(accessibility = "My Transfers")
    protected WebElement myTransfers;
    @AndroidFindBy(accessibility = "Manage CliQ ID")
    @iOSXCUITFindBy(accessibility = "Manage CliQ ID")
    protected WebElement manageCliQId;
    @AndroidFindBy(accessibility = "Change password")
    @iOSXCUITFindBy(accessibility = "Change password")
    protected WebElement changePassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Change password\"]//ancestor::android.view.View[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter current password\"]")
    protected WebElement currentPassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Change password\"]//ancestor::android.view.View[1]/android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter new password\"]")
    protected WebElement newPassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Change password\"]//ancestor::android.view.View[1]/android.widget.EditText[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Re-Enter your password\"]")
    protected WebElement reEnterPassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"My Transfers\"]//following-sibling::android.widget.Switch[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Open Additional Account\"]/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch[1]")
    protected WebElement healthWealthToggle;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"My Transfers\"]//following-sibling::android.widget.Switch[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Open Additional Account\"]/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch[3]")
    protected WebElement sanadDigitalIdToggle;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    protected WebElement close;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Accounts\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Accounts\"]")
    protected WebElement accounts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"English\"]/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"English\"]")
    protected WebElement selectEnglishLanguage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"عربي\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"عربي\"]")
    protected WebElement selectArabicLanguage;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Apply\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Apply\"]")
    protected WebElement englishApply;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"تطبيق\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"تطبيق\"]")
    protected WebElement arabicApply;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    protected WebElement cancel;

    @Override
    protected void waitForAppToLoad() {
    }

    public void scrollToBeneficiaries() {
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute2 = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[@" + attribute + "='Change profile image']", 90);

        scroll("up", 0.5);
    }

    public void selectWithinCboj() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Within CBOJ Beneficiaries']", 30);

        click(withInCboj, "Selecting Within CBOJ ");
    }

    public void selectOverseasBank() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Overseas Bank Beneficiaries']", 30);

        click(overseasBeneficiaries, "Selecting Overseas Bank beneficiary ");
    }

    public void selectLocalBank() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Local Bank Beneficiaries']", 30);

        click(localBankBeneficiaries, "Selecting Local bank beneficiary");
    }

    public void clickOnManageCliQId() {
        waitForVisibility(myTransfers);
        Point point = myTransfers.getLocation();
        scrollWithCoordinates("up", 0.50, point.x + 100, point.y);
        waitForVisibility(manageCliQId);
        click(manageCliQId, "Clicking on Manage cliQ Id menu");
    }

    public void changePassword() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"Change profile image\"]", 15);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Change password\"]"), "up", 0.50);
        click(changePassword, "Clicking change password");
    }

    public ProfilePage enterCurrentPassword(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Change password\"]//ancestor::" + parentAttribute + "[1]/android.widget.EditText[1]", 15);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[@name=\"Change password\"]", 15);
        clickAndSendKeys(currentPassword, value, "Entering current password");
        return this;
    }

    public ProfilePage enterNewPassword(String value) {
        clickAndSendKeys(newPassword, value, "Entering new password");
        return this;
    }

    public void reEnterPassword(String value) {
        clickAndSendKeys(reEnterPassword, value, "Entering re-enter password");
    }

    public String nextButton() {
        String parentAttribute = "";
        String attribute = "";
        String data = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
            data = "clickable";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
            data = "visible";
        }

        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Next\"]"), data);
    }

    public void healthToggle() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Switch";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeSwitch";
            attribute = "name";
        }
        String xpath = "";
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"My Transfers\"]//following-sibling::" + parentAttribute2 + "[1]";
        else
            xpath = "//XCUIElementTypeOther[@name=\"Open Additional Account\"]/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch[1]";

        utils.waitForElement(getDriver(), xpath, 30);
        if (getDriver() instanceof AndroidDriver) {
            if (getAttribute(By.xpath(xpath), "checked").equals("true")) {
                click(healthWealthToggle, "disabling the toggle");
                utils.waitForElement(getDriver(), xpath, 30);
                click(healthWealthToggle, "enabling the toggle");
            } else
                click(healthWealthToggle, "enabling the toggle");
        } else {
            if (getAttribute(By.xpath(xpath), "value").equals("1")) {
                click(healthWealthToggle, "disabling the toggle");
                utils.waitForElement(getDriver(), xpath, 30);
                click(healthWealthToggle, "enabling the toggle");
            } else
                click(healthWealthToggle, "enabling the toggle");
        }
    }

    public void sanadDigitalIdToggle() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Switch";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeSwitch";
            attribute = "name";
        }
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"My Transfers\"]//following-sibling::" + parentAttribute2 + "[3]";
        else
            xpath = "//XCUIElementTypeOther[@name=\"Open Additional Account\"]/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeSwitch[3]";
        utils.waitForElement(getDriver(), xpath, 30);
        if (getDriver() instanceof AndroidDriver) {
            if (getAttribute(By.xpath(xpath), "checked").equals("true")) {
                click(sanadDigitalIdToggle, "disabling the toggle");
                utils.waitForElement(getDriver(), xpath, 30);
                click(sanadDigitalIdToggle, "enabling the toggle");
            } else
                click(sanadDigitalIdToggle, "enabling the toggle");
        } else {
            if (getAttribute(By.xpath(xpath), "value").equals("1")) {
                click(sanadDigitalIdToggle, "disabling the toggle");
                utils.waitForElement(getDriver(), xpath, 30);
                click(sanadDigitalIdToggle, "enabling the toggle");
            } else
                click(sanadDigitalIdToggle, "enabling the toggle");
        }
    }

    public void termsAndCondition(String value) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            parentAttribute2 = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[contains(@" + attribute + ",\"Join Our\")]", 30);
        scroll("up", 0.75);
        click(By.xpath(xpath), "Clicking " + value + " in terms and conditions");
    }

    public String healthMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"Health\")]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute);
    }

    public void cancellingTermsAndCondition() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Join Our\")]", 30);
        scroll("down", 0.75);
    }

    public String menuOption() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "=\"Change profile image\"]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute);
    }

    public void selectMenu(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"Change profile image\" or contains(@" + attribute + ",'تغيير لغة التطبيق')]", 30);
        scrollUntilElementPresent(By.xpath(xpath), "up", 0.25);

        if (getDriver() instanceof IOSDriver) {
            scroll("up", 0.35);
            if (value.equalsIgnoreCase("Online Banking Security Guidelines & Tips"))
                scroll("up", 0.60);

            if (value.equalsIgnoreCase("Update Mobile Number"))
                scroll("up", 0.30);
        }

        click(By.xpath(xpath), "Clicking " + value + " menu");
    }

    public void clickCloseButton() {
        click(close, "clicking close button");
    }

    public boolean accountsTab() {
        return accounts.isDisplayed();
    }

    public void clickBackButton(String value) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }

        String xpath = "";
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "='" + value + "']//ancestor::" + parentAttribute + "[1]/" + parentAttribute2;
        else
            xpath = "//XCUIElementTypeOther[@name=\"Online Banking Security\"]/preceding::XCUIElementTypeButton[1]";
        click(By.xpath(xpath), "Clicking back button");
    }

    public boolean menuValue(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        utils.waitForElement(getDriver(), xpath, 30);
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    public void selectLanguage(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Change App Language\" or @" + attribute + "=\"تغيير لغة التطبيق\"]", 30);
        if (value.equalsIgnoreCase("ENGLISH"))
            click(selectEnglishLanguage, "clicking English language");
        else
            click(selectArabicLanguage, "clicking Arabic language");
    }

    public void apply(String value) {
        if (value.equalsIgnoreCase("ENGLISH"))
            click(englishApply, "Clicking english apply button");
        else
            click(arabicApply, "Clicking arabic apply button");
    }

    public void appAssistant() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "=\"App Assistant\"]";
        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"Change profile image\"]", 15);
        scrollUntilElementPresent(By.xpath(xpath), "up", 0.50);
        click(By.xpath(xpath), "Clicking app assistant");
    }

    public void cancel() {
        click(cancel, "Clicking cancel button");
    }

    public void mobileNumber(String no) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        String xpath = "";
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"Update\")]/" + parentAttribute2;
        else
            xpath = "//XCUIElementTypeTextField[@name=\"7X XXX XXXX\"]";

        utils.waitForElement(getDriver(), xpath, 30);

        Point point = getDriver().findElement(By.xpath(xpath)).getLocation();
        tapOnPosition(point.x + 200, point.y + 10);

        new Actions(getDriver()).sendKeys(no).perform();
    }

    public String getContent(String content) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + content + "')]";
        scrollUntilElementPresent(By.xpath(xpath), "up", 0.75);
        return getAttribute(By.xpath(xpath), attribute).replaceAll("\n", " ");
    }
}