package com.devtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.ScreenOrientation.*;
import org.openqa.selenium.devtools.emulation.model.ScreenOrientation;

public class SetDeviceMode {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();

        devTools = driver.getDevTools();
        devTools.createSession();
        Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://www.youtube.com");

    }
}
