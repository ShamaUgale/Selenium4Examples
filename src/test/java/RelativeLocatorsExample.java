import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocatorsExample {

    final static String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH+ "/src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://automationbookstore.dev/");
//        String id =driver.findElement(
//                withTagName("li").toLeftOf(By.id("pid6"))
//                        .below(By.id("pid1")))
//                .getAttribute("id");
//        System.out.println(id);


        driver.get("https://www.netflix.com/in/");


        WebElement emailTxtBox= driver.findElement(By.id("id_email_hero_fuji"));
        emailTxtBox.sendKeys("some_email@id.com");
        driver.findElement(withTagName("div").toLeftOf(emailTxtBox)).click();

        String data =driver.findElement( withTagName("li").above(By.xpath("//li[@placeholder='footer_responsive_link_help_item']")).below(By.xpath("//li[@placeholder='footer_responsive_link_help_item']")))
                    .getText();
        System.out.println(data);


    }
}