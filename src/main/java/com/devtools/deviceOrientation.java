package com.devtools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.deviceorientation.DeviceOrientation;
import org.openqa.selenium.devtools.emulation.Emulation;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;

import java.util.Optional;

public class deviceOrientation {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver");

        DevTools devTools;
        ChromeDriver driver;

        driver = new ChromeDriver();

        devTools = driver.getDevTools();
        devTools.createSession();

        //driver.get("https://www.google.com");

        //https://www.tutorialspoint.com/java8/java8_optional_class.htm
        Optional<ConnectionType> connectType3G= Optional.of(ConnectionType.CELLULAR3G);

        Command networkSimulation = Network.emulateNetworkConditions(false, 20 , 20,20, connectType3G);

        Optional<Number> scale = Optional.of(1);
        Optional<Integer> screenWidth = Optional.of(400);
        Optional<Integer> screenHeight = Optional.of(640);
        Optional<Boolean> dontSetVisibleSize = Optional.of(true);

        Command deviceMode= Emulation.setDeviceMetricsOverride(400, 800,
                50,
                true,
                scale,
                screenWidth,
                screenHeight,
                Optional.empty(),
                Optional.empty(),
                dontSetVisibleSize,
                Optional.empty(),
                Optional.empty());

        String iPhone5 = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53";
        Command userAgent = Emulation.setUserAgentOverride(iPhone5, Optional.empty(), Optional.empty());
        Command deviceCmd = DeviceOrientation.setDeviceOrientationOverride(20,20,5);

        devTools.send(userAgent);

        //devTools.send(deviceMode);
        devTools.send(deviceCmd);

        driver.get("https://www.facebook.com");

    }
}
