import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");

        WebElement searchInput = driver.findElement(By.id("sb_form_q"));
        searchInput.sendKeys("find something");

        WebElement searchButton = driver.findElement(By.name("q"));
        searchButton.submit();

        System.out.println("Page titel is "+ driver.getTitle());

        Thread.sleep(3000);

        driver.quit();

            }
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//resources//chromedriver.exe");
    return new ChromeDriver();
    }

}
