package com.devtools;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.util.HashMap;
import java.util.Map;

public class SetAuthHeader {

    private static ChromeDriver driver;
    private static DevTools chromeDevTools;
    private static Map<String, Object> params = new HashMap<>();
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver");

        driver = new ChromeDriver();
        chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();

                driver.get("https://jigsaw.w3.org/HTTP/");
                driver.executeCdpCommand("Network.enable", params);

                Map<String, String> headers = new HashMap<>();
                Base64 base64 = new Base64();
                headers.put("Authorization",
                        "Basic " + new String(base64.encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes())));
                 params = new HashMap<>();
                 params.put("headers", headers);
                driver.executeCdpCommand("Network.setExtraHTTPHeaders", params);

            WebElement element = driver.findElement(By.cssSelector("table td> a[href=\"Basic/\"]"));
                element.click();

                String loginSuccessMsg = driver.findElement(By.tagName("html")).getText();
                if(loginSuccessMsg.contains("Your browser made it!")){
                    System.out.println("Login successful");
                }else{
                    System.out.println("Login failed");
                }
    }
}
