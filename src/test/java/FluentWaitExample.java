import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitExample {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");

        ChromeDriver driver = new ChromeDriver();

        FluentWait wait = new FluentWait(driver)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofSeconds(60));

    }
}
