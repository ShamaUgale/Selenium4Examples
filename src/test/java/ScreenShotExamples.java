import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class ScreenShotExamples {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com");
        WebElement logo= driver.findElement(By.id("hplogo"));
        File file=logo.getScreenshotAs(OutputType.FILE);
        File destFile =new File("logo.png");
        FileUtils.copyFile(file,destFile);

        System.setProperty("webdriver.gecko.driver", PROJECT_PATH+ "/src/main/resources/geckodriver");

        FirefoxDriver ff = new FirefoxDriver();
        ff.get("https://www.youtube.com");
        File src = ff.getFullPageScreenshotAs(OutputType.FILE);
        File destFile1 =new File("logo1.png");
        FileUtils.copyFile(src,destFile1);

        File videoDownloaderExt = new File(PROJECT_PATH+"/src/main/resources/video_downloadhelper-7.3.5-an+fx.xpi");
        ff.installExtension(videoDownloaderExt.toPath());


        //ff.uninstallExtension();


    }
}
