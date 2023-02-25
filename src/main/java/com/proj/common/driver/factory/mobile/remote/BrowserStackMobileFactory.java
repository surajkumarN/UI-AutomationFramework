package com.proj.common.driver.factory.mobile.remote;

import com.proj.common.driver.enums.MobilePlatformType;
import com.proj.common.driver.manager.mobile.remote.browserstack.BrowserStackAndroidManager;
import com.proj.common.driver.manager.mobile.remote.browserstack.BrowserStackIosManager;
import io.appium.java_client.AppiumDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class BrowserStackMobileFactory {
    /*public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
        return mobilePlatformType == MobilePlatformType.ANDROID
                ? BrowserStackAndroidManager.getDriver()
                : BrowserStackIosManager.getDriver();
    }*/
    private static final Map<MobilePlatformType, Supplier<AppiumDriver>> MAP =
            new EnumMap<>(MobilePlatformType.class);

    static {
        MAP.put(MobilePlatformType.ANDROID, BrowserStackAndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, BrowserStackIosManager::getDriver);
    }

    private BrowserStackMobileFactory() {
    }

    public static AppiumDriver getDriver(MobilePlatformType mobilePlatformType) {
        return MAP.get(mobilePlatformType).get();
    }

}
