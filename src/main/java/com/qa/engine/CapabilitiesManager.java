package com.qa.engine;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class CapabilitiesManager extends ProjectBase {

    public DesiredCapabilities getCapabilities(String app) throws IOException {
        GlobalParams params = new GlobalParams();

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, params.getPlatformVersion());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());
            caps.setCapability("shouldTerminateApp", true);
            caps.setCapability("unicodeKeyboard", true);
            caps.setCapability("resetKeyboard", true);
            caps.setCapability("appWaitDuration ", 30000);
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("autoAcceptAlerts", true);

            if (properties.getProperty("fullReset").equalsIgnoreCase("true"))
                caps.setCapability(MobileCapabilityType.FULL_RESET, true);
            else caps.setCapability(MobileCapabilityType.NO_RESET, true);

            switch (params.getPlatformName()) {
                case "Android" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName"));
//                    caps.setCapability("systemPort", params.getSystemPort());
//                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());

                    if (app.equalsIgnoreCase(BLINK)) {
                        caps.setCapability("appPackage", properties.getProperty("blink.appPackage"));
                        caps.setCapability("appActivity", properties.getProperty("blink.appActivity"));
                        caps.setCapability("app", properties.getProperty("app.blink.apk"));
                    } else if (app.equalsIgnoreCase(CAPITAL_BANK)) {
                        caps.setCapability("app", properties.getProperty("app.capital.apk"));
                        caps.setCapability("appPackage", properties.getProperty("capitalBank.appPackage"));
                        caps.setCapability("appActivity", properties.getProperty("capitalBank.appActivity"));
                    }
                }
                case "iOS" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("iOSAutomationName"));

                    if (app.equalsIgnoreCase(BLINK)) {
                        caps.setCapability("app", properties.getProperty("app.blink.ipa"));
                        caps.setCapability("appPackage", properties.getProperty("blink.appPackage"));
                        caps.setCapability("appActivity", properties.getProperty("blink.appActivity"));
                    } else if (app.equalsIgnoreCase(CAPITAL_BANK)) {
                        caps.setCapability("app", properties.getProperty("app.capital.ipa"));
                        caps.setCapability("appPackage", properties.getProperty("capitalBank.appPackage"));
                        caps.setCapability("appActivity", properties.getProperty("capitalBank.appActivity"));
                    }
                }
            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            log().fatal("Failed to load capabilities.");
            throw e;
        }
    }
}
