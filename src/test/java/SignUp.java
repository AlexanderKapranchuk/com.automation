import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SignUp {

    @Test
    public void signUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver86.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://influential.co/");

        WebElement navigatbar = driver.findElement(By.id("navbar"));
        navigatbar.findElement(By.cssSelector("[href=\"contact\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-connect")));

        driver.findElement(By.id("name")).sendKeys("Auto");
        driver.findElement(By.id("company")).sendKeys("Test");

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String email = "AutoTest" + n + "@gmail.com";

        System.out.println(email);

        driver.findElement(By.id("email")).sendKeys(email);
        //генеруємо 10 значний номер телефону

        Random random1 = new Random();
        int phone = random.nextInt(900000000) + 100000000;

        String newphone = "+" + phone;

        System.out.println(phone);

        driver.findElement(By.id("phone_number")).sendKeys(newphone);

        driver.findElement(By.id("message")).sendKeys("TestMessage");


        Thread.sleep(3000);

        driver.quit();
    }
}
