import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class WindowsTabsExample {

        final static String PROJECT_PATH = System.getProperty("user.dir");

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");
            ChromeDriver driver = new ChromeDriver();

            driver.get("https://www.google.com/");

            // open a new window
            driver.switchTo().newWindow(WindowType.WINDOW);
            //navigate to a URL on newly opened window
            driver.navigate().to("https://www.youtube.com/");

            // get the window ids to switch between them
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String googleWindow = it.next();
            String youtubeWindow = it.next();
            System.out.println(driver.getTitle());

            // switch the control to the google window
            driver.switchTo().window(googleWindow);
            System.out.println(driver.getTitle());

            // open a new tabbed window
            driver.switchTo().newWindow(WindowType.TAB);
            //navigate to a URL on newly opened tabbed window
            driver.navigate().to("https://www.gmail.com/");
            System.out.println(driver.getTitle());

            driver.switchTo().window(youtubeWindow);
            System.out.println(driver.getTitle());

            driver.quit();

        }

}