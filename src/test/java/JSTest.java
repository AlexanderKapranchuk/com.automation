import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JSTest {

    public static void main(String[] args) {

        WebDriver driver = DriverManager.getConfiguredDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/uk/");

        /*Logger log = Logger.getLogger(JSTest.class.getName());*/

        WebElement block = driver.findElement(By.cssSelector(".homeslider-description"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String innerHtml = (String) js.executeScript("return arguments[0].innerHTML;", block);
        System.out.println(innerHtml); // виводимо значення стрінгове

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        /*boolean scrollResult = (boolean) jsExecutor.executeScript(
                "var scrollBefore = $(window).scrollTop();" + "window.scrollTo(scrollBefore," +
                        " document.body.scrollHeight);" + "return $(window). scrolltop() > scrollVefore;");*/

        WebElement futer = driver.findElement(By.xpath("//section[@class='bottom-footer col-xs-12']"));

        JavascriptExecutor JSFuter = (JavascriptExecutor) driver;
        JSFuter.executeScript("arguments[0].scrollIntoView();", futer);

        driver.quit();

    }
}
