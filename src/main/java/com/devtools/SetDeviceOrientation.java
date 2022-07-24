package com.devtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.deviceorientation.DeviceOrientation;

public class SetDeviceOrientation {
    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

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
