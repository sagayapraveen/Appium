package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class TransactionHistoryPage extends BasePage {
    @Override
    protected void waitForAppToLoad() {

    }

    public Set<String> getTransactionWithDate(String date) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        Instant timeout = Instant.now().plusSeconds(240);
        Set<String> transactionEntries = new HashSet<>();

        do {
            int size = getDriver().findElements(By.xpath("(//" + parentAttribute + "[@" + attribute + "='20 March']/" + parentAttribute + "/" + parentAttribute + "/" + parentAttribute + ")/" + parentAttribute)).size();

            for (int i = 1; i <= size; i++) {
                transactionEntries.add(getDriver().findElement(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + date + "']/" + parentAttribute + "/" + parentAttribute + "/" + parentAttribute + ")/" + parentAttribute + "[" + i + "]"))
                        .getAttribute("content-desc"));
            }

            scroll("Up", 0.65);

            if (getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + date + "']/" + parentAttribute)).size() == 0)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException();
        } while (getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + date + "']/" + parentAttribute)).size() == 1);


        return transactionEntries;
    }
}
