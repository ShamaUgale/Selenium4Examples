package com.devtools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.model.ConnectionType;

import java.util.HashMap;
import java.util.Map;

public class SetNetwork {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver");

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();
        devTools = driver.getDevTools();
        devTools.createSession();
        Map networkConditions = new HashMap()
        {{
            put("offline", false);
            put("latency", 20);
            put("downloadThroughput", 20);
            put("uploadThroughput", 50);
            put("connectionType",ConnectionType.CELLULAR4G);
        }};
        driver.executeCdpCommand("Network.emulateNetworkConditions", networkConditions);
        driver.get("https://www.google.com");
    }
}
