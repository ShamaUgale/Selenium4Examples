package com.devtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;

import java.util.Optional;

public class SetUserAgent {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();

        devTools = driver.getDevTools();
        devTools.createSession();

        String iPhone5 = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53";
        Command userAgent = Emulation.setUserAgentOverride(iPhone5, Optional.empty(), Optional.empty());

        devTools.send(userAgent);

        driver.get("https://www.facebook.com");

    }
}
