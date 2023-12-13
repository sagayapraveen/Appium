package com.qa.pages.capitalbank.investment;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {
    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    protected WebElement close;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Terms & Conditions']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms & Conditions']")
    protected WebElement terms;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Close']//ancestor::android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Terms\") or contains(@name,\"Fund\")]/preceding::XCUIElementTypeButton[1]")
    protected WebElement back;

    @Override
    protected void waitForAppToLoad() {
    }

    public float withDrawFrom() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        By total;
        if (getDriver() instanceof AndroidDriver)
            total = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[4]");
        else
            total = By.xpath("//XCUIElementTypeStaticText[@name=\"Withdraw From\" or contains(@name,\"Pay From\")]//following-sibling::XCUIElementTypeStaticText[2]");

        String totalValue = getAttribute(total, attribute).split(" ")[0].replaceAll(",", "");
        return Float.parseFloat(totalValue.replaceAll(",", ""));
    }

    public float withDrawFromBalance() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]", 25);
        By afterDeduction;

        if (getDriver() instanceof AndroidDriver)
            afterDeduction = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[7]");
        else
            afterDeduction = By.xpath("//XCUIElementTypeStaticText[@name=\"Withdraw From\" or contains(@name,\"Pay From\")]//following-sibling::XCUIElementTypeStaticText[5]");

        String afterDeductionValue = getAttribute(afterDeduction, attribute).split(" ")[0];
        return Float.parseFloat(afterDeductionValue.replaceAll(",", ""));
    }

    public float withDrawTo() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        By total;
        if (getDriver() instanceof AndroidDriver)
            total = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[10]");
        else
            total = By.xpath("//XCUIElementTypeStaticText[@name=\"Withdraw To\" or contains(@name,\"Pay to\")]//following-sibling::XCUIElementTypeStaticText[2]");

        String beforeCreditedValue = getAttribute(total, attribute).split(" ")[0];
        return Float.parseFloat(beforeCreditedValue.replaceAll(",", ""));
    }

    public float withDrawToBalance() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        By afterDeduction;
        if (getDriver() instanceof AndroidDriver)
            afterDeduction = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[13]");
        else
            afterDeduction = By.xpath("//XCUIElementTypeStaticText[@name=\"Withdraw To\" or contains(@name,\"Pay to\")]//following-sibling::XCUIElementTypeStaticText[5]");

        String afterCreditedValue = getAttribute(afterDeduction, attribute).split(" ")[0];
        return Float.parseFloat(afterCreditedValue.replaceAll(",", ""));
    }

    public String amount() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[15]"), attribute);
        else
            return getAttribute(By.xpath("//XCUIElementTypeStaticText[contains(@name,\"Amount\")]//following-sibling::XCUIElementTypeStaticText[1]"), attribute);
    }

    public String description() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[17]"), attribute);
        else
            return getAttribute(By.xpath("//XCUIElementTypeStaticText[@name=\"Description\"]//following-sibling::XCUIElementTypeStaticText[1]"), attribute);
    }

    public String descriptionConversion() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[21]"), attribute);
        else
            return getAttribute(By.xpath("//XCUIElementTypeStaticText[@name=\"Description\"]//following-sibling::XCUIElementTypeStaticText[1]"), attribute);
    }

    public ConfirmPage confirm() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 45);
        click(confirm, "Clicking confirm button");
        return this;
    }

    public float conversionRate() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        String value;
        if (getDriver() instanceof AndroidDriver)
            value = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[19]"), attribute);
        else
            value = getAttribute(By.xpath("//XCUIElementTypeStaticText[@name=\"Exchange Rate\"]//following-sibling::XCUIElementTypeStaticText[1]"), attribute);
        return Float.parseFloat(value.split(" ")[3]);
    }

    public String currency() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        String value;
        if (getDriver() instanceof AndroidDriver)
            value = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[14]"), attribute);
        else
            value = getAttribute(By.xpath("//XCUIElementTypeStaticText[@name=\"Exchange Rate\"]//following-sibling::XCUIElementTypeStaticText[1]"), attribute);
        return value.split(" ")[1].replaceAll("[^a-zA-Z0-9]", "");
    }

    public ConfirmPage selectTC() {
        click(terms, "Clicking Terms and conditions");
        return this;
    }

    public void clickCloseButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Close']", 20);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(close, "Clicking Close button");
    }

    public ConfirmPage backButton() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeButton";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Terms & Conditions\" or contains(@" + attribute + ",\"Fund\")]//ancestor::" + parentAttribute + "/" + parentAttribute2, 45);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeOther[contains(@name,\"Terms\") or contains(@name,\"Fund\")]/preceding::XCUIElementTypeButton[1]", 45);
        click(back, "Clicking Back button");
        return this;
    }
}