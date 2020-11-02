import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotExamples {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com");

        // take screenshot of an element
        WebElement logo= driver.findElement(By.id("hplogo"));
        File file=logo.getScreenshotAs(OutputType.FILE);
        File destFile =new File("logo.png");
        FileUtils.copyFile(file,destFile);


        System.setProperty("webdriver.gecko.driver", PROJECT_PATH+ "/src/main/resources/geckodriver");
        FirefoxDriver ff = new FirefoxDriver();
        ff.get("https://www.youtube.com");

        // take full page screenshot - available for firefox driver
        File src = ff.getFullPageScreenshotAs(OutputType.FILE);
        File destFile1 =new File("ytFLandingPage.png");
        FileUtils.copyFile(src,destFile1);

        Path path = Paths.get(PROJECT_PATH+"/src/main/resources/video_downloadhelper-7.3.5-an+fx.xpi");

        String addon_id= ff.installExtension(path);

        Thread.sleep(10000);

        ff.uninstallExtension(addon_id);


    }
}
