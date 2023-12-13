package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Instant;

public class LoyaltyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Redeem now']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Redeem now']")
    protected WebElement redeemNowButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'loyalty points')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'loyalty points')]")
    protected WebElement loyaltyPointsText;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Loyalty Points']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Loyalty Points']")
    protected WebElement loyaltyPoints;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='View Details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View Details']")
    protected WebElement viewDetails;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Redeem']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Redeem']")
    protected WebElement redeemButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Loyalty')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Loyalty')]")
    protected WebElement pointsCollectedExpiryDetails;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Confirm Redeem']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Confirm Redeem']")
    protected WebElement confirmRedeem;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']")
    protected WebElement confirmButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='HISTORY']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='HISTORY']")
    protected WebElement historyTab;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Redeem\")]//ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    protected WebElement searchIcon;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='You have successfully redeemed points!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You have successfully redeemed points!']")
    protected WebElement successMessage;

    @Override
    protected void waitForAppToLoad() {
    }

    public String redeemNowButtonVisibility() {
        waitForVisibility(redeemNowButton);
        String attribute = "";
        if (getDriver() instanceof AndroidDriver)
            attribute = "content-desc";
        else
            attribute = "name";
        return getTextWithAttribute(redeemNowButton, attribute);
    }

    public String loyaltyPointsText() {
        return getTextWithAttribute(loyaltyPointsText, "content-desc");
    }

    public void clickingRedeemNowButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        if (getDriver() instanceof IOSDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Redeem now']", 60);
        else
            waitForVisibility(redeemNowButton);
        click(redeemNowButton, "Clicking RedeemNow button");
    }

    public String getLoyaltyPage() {
        String parentAttribute = "";
        String parentAttribute3 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute3 = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute3 = "XCUIElementTypeButton";
            attribute = "name";
        }

        By xpath = By.xpath("//*[@text='Allow Capital Bank to access your physical activity?']");

        Instant timeout = Instant.now().plusSeconds(90);
        while (getDriver().findElements(xpath).size() > 0) {
            if (getDriver().findElements(xpath).size() > 0) {
                if (getDriver() instanceof AndroidDriver)
                    getDriver().findElement(By.xpath("//" + parentAttribute3 + "[@text='DENY']")).click();
                else
                    getDriver().findElement(By.xpath("//" + parentAttribute3 + "[@name='Don’t Allow']")).click();
                break;
            }
            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Element '" + xpath + "' is not found in the App.");
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Loyalty Points')]", 60);
        return getTextWithAttribute(loyaltyPoints, attribute);
    }

    public boolean isViewDetailsDisplayed() {
        return viewDetails.isDisplayed();
    }

    public boolean isRedeemDisplayed() {
        return redeemButton.isDisplayed();
    }

    public void clickViewDetails() {
        click(viewDetails, "Clicking View Details Link");
    }

    public String pointsCollectedAndExpiryDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Loyalty')]", 90);
        return getTextWithAttribute(pointsCollectedExpiryDetails, attribute);
    }

    public void clickingRedeemButton() {
        waitForVisibility(redeemButton);
        click(redeemButton, "clicking Redeem button");
    }

    public LoyaltyPage enteringRedeemAmount(String amount) {
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
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Redeem']//../following-sibling::" + parentAttribute2 + ")[10]"));
                else if (c == '.')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Redeem']//../following-sibling::" + parentAttribute2 + ")[9]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Redeem']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Redeem Reward Points to Account\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Redeem Reward Points to Account\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[10]"));
                else
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Redeem Reward Points to Account\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[" + c + "]"));
            }
        }
        return this;
    }

    public void clickOnTab() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeOther";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Redeem']//../following-sibling::" + parentAttribute2 + ")[11]"), "clicking tab");
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Redeem Reward Points to Account\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[12]")).click();
    }

    public String confirmRedeem() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Confirm Redeem')]", 90);
        return getTextWithAttribute(confirmRedeem, attribute);
    }

    public void clickingHistoryTab() {
        waitForVisibility(historyTab);
        click(historyTab, "Clicking History tab");
    }

    public void clickOnSearch() {
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute2 = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute2 = "XCUIElementTypeOther";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[@index='2']", 30);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[contains(@name,\"Redeem\")]//ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton", 30);
        click(searchIcon, "Click on Search Icon");
    }

    public void filterBy(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + value + "')]", 60);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + value + "')]"), "Clicking on SearchCategory " + value);
    }

    public String filterRedeemPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Redeemed')]", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Redeemed')]"), attribute);
    }

    public String filterGainedPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Gained')]", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Gained')]"), attribute);
    }

    public String filterExpiredPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'No Data Found')]", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'No Data Found')]"), attribute);
    }

    public void clickConfirmButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 10);
        click(confirmButton, "Clicking Confirm button");
    }

    public String redeemSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='You have successfully redeemed points!']", 60);
        return getTextWithAttribute(successMessage, attribute);
    }
}