package com.devtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.model.ConnectionType;

import java.util.HashMap;
import java.util.Map;

public class GeoMocking {



    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();
        devTools = driver.getDevTools();
        devTools.createSession();
        Map geoLocation = new HashMap()
        {{
            put("latitude", 35.8235);
            put("longitude", -78.8256);
            put("accuracy", 100);
        }};
        driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);
        driver.get("https://mycurrentlocation.net/");
    }
}
