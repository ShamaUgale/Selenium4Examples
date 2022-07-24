import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Addon {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();

        Path path = Paths.get(PROJECT_PATH+"/src/main/resources/video_downloadhelper-7.3.5-an+fx.xpi");
        String addon_id= driver.installExtension(path);
        driver.uninstallExtension(addon_id);


    }
}
