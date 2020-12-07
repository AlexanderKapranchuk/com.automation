import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    public static WebDriver getDriver(String browser) {
        switch (browser) {

            case "firefox":
                System.setProperty("webriver.gecko.driver", new File(DriverManager.class.getResource("/gecodriver.exe").getFile()).getPath());
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        new File(DriverManager.class.getResource("resources/chromedriver86.exe").getFile()).getPath());


        }
        return new ChromeDriver();
    }

    public static EventFiringWebDriver getConfiguredDriver(String browser) {
        EventFiringWebDriver driver = new EventFiringWebDriver(getDriver(browser));
        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}