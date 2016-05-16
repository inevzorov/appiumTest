package com.example.igor.myapplication;

/**
 * Created by Igor on 13.05.2016.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class FirstAppiumTest {
    private static AndroidDriver wd;
    private static final String TESTDROID_SERVER = "http://127.0.0.1";
    public static String app = "/Users/igor/test/bellringer.app";
    public static String appPackage = "com.itcraft.ringer.ui";
    public static String activity = "activity.SplashActivity_";
    public static String udid = "127.0.0.1:5554";
    public static String device = "Android";
    public static String deviceName = "emulator-5554";
    public static String platformVersion = "4.4";
    public static String platformName = "Android";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", device);
        dc.setCapability("deviceName", deviceName);
        dc.setCapability("platformVersion", platformVersion);
        dc.setCapability("platformName", platformName);
        dc.setCapability("app", app);
        dc.setCapability("app-package", appPackage);
        dc.setCapability("app-activity", activity);
        dc.setCapability("udid", udid);

        wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testThatClickingTheMotorSectionLeadsToSubSection() {
        wd.findElement(By.id("com.itcraft.ringer:id/activity_password_edit_text")).sendKeys("0000");
        wd.findElement(By.id("com.itcraft.ringer:id/activity_password_login_button")).click();
        Assert.assertNotNull(wd.getContext());
    }

    @After
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }

    }
}

