
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

public class CapabilitiesExample {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        ChromeDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://www.youtube.com");
        chromeDriver.quit();


        System.setProperty("webdriver.edge.driver", PROJECT_PATH+ "/src/main/resources/EdgeDriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setAcceptInsecureCerts(true);

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://www.google.com");


        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setAcceptInsecureCerts(true);

        SafariDriver safariDriver = new SafariDriver(safariOptions);
        safariDriver.get("https://www.google.com");

        FirefoxOptions op = new FirefoxOptions();
        FirefoxDriver d = new FirefoxDriver(op);

        InternetExplorerOptions ops = new InternetExplorerOptions();
        ops.setAcceptInsecureCerts(true);

        InternetExplorerDriver ie = new InternetExplorerDriver(ops);
        ie.get("https://www.gmail.com");

    }
}

