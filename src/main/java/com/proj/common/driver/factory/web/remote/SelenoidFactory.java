package com.proj.common.driver.factory.web.remote;

import com.proj.common.driver.enums.WebBrowserType;
import com.proj.common.driver.manager.web.remote.selenoid.SelenoidChromeManager;
import com.proj.common.driver.manager.web.remote.selenoid.SelenoidFirefoxManager;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class SelenoidFactory {
    /*public static WebDriver getDriver(WebBrowserType webBrowserType){
        return webBrowserType == WebBrowserType.CHROME
                ? SelenoidChromeManager.getDriver()
                : SelenoidFirefoxManager.getDriver();
    }*/
    private static final Map<WebBrowserType, Supplier<WebDriver>> MAP =
            new EnumMap<>(WebBrowserType.class);

    static {
        MAP.put(WebBrowserType.CHROME, SelenoidChromeManager::getDriver);
        MAP.put(WebBrowserType.FIREFOX, SelenoidFirefoxManager::getDriver);
    }

    private SelenoidFactory() {

    }

    public static WebDriver getDriver(WebBrowserType browserType) {
        return MAP.get(browserType).get();
    }
}
