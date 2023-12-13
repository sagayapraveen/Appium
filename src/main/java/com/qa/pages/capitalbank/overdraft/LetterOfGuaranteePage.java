package com.qa.pages.capitalbank.overdraft;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LetterOfGuaranteePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Letter of Guarantee')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Letter of Guarantee')]")
    protected WebElement letterOfGuaranteeDetails;

    @Override
    protected void waitForAppToLoad() {
    }

    public String fetchDetailsInLetterOfGuarantee() {
        waitForVisibility(letterOfGuaranteeDetails);
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(letterOfGuaranteeDetails, attribute);
    }
}
