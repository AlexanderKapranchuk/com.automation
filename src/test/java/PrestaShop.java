import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PrestaShop {

    @Test
    public void signUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/uk/");

        WebElement input = driver.findElement(By.id("search_query_top"));
        input.sendKeys("dress");
        input.submit();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage("Do not find the element")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".center_column")));

        WebElement product = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line']"));

        WebElement productLink = driver.findElement(By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/uk/home/7-printed-chiffon-dress.html?search_query=dress&results=34']"));


        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofSeconds(3)).click(productLink)
                .build().perform();

        driver.quit();
    }
}