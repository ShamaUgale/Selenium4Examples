package com.devtools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.deviceorientation.DeviceOrientation;

public class SetDeviceOrientation {
    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver");

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();

        devTools = driver.getDevTools();
        devTools.createSession();

        Command deviceOrientationCmd = DeviceOrientation.setDeviceOrientationOverride(20,20,5);

        devTools.send(deviceOrientationCmd);

        driver.get("https://www.facebook.com");

    }
}
