import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class aboutMeSite {


    @Test
    public void signUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://about.me/");

        WebElement login = driver.findElement(By.xpath("//a[@class='login']"));
        login.click();

        WebDriverWait LoginWait = new WebDriverWait(driver, 5);
        LoginWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".title")));

        WebElement ForgotPass = driver.findElement(By.xpath("//a[@class='forgotpassword-link']"));
        ForgotPass.click();


        WebElement InputPass = driver.findElement(By.xpath("//input[@type='text']"));
        InputPass.click();
        InputPass.sendKeys("test@gmail.com");

        WebElement SearchGmail = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        SearchGmail.click();

        WebDriverWait FindAccountWait = new WebDriverWait(driver, 5);
        FindAccountWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dialog-title")));


        WebElement Cancel = driver.findElement(By.cssSelector(".button large light tertiary fullwidth cancel-button"));



    }
}

