import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    Logger log = Logger.getRootLogger();

    @BeforeSuite
    public void setupDriver() {
        String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //setting up console logger
        ConsoleAppender console = new ConsoleAppender();
        console.setLayout(new PatternLayout("%d [%p|%C{1}] %m%n"));
        console.activateOptions();
        //setting up file logger. Log will be saved to selenium.log file
        FileAppender fa = new FileAppender();
        fa.setName("SeleniumLogger");
        fa.setFile("selenium.log");
        fa.setLayout(new PatternLayout("%d [%p|%C{1}] %m%n"));
        fa.activateOptions();
        log.addAppender(console);
        log.addAppender(fa);
    }

    @AfterMethod
    public void cleanUp() {
        //close all other tabs or windows
        while (driver.getWindowHandles().size() > 1) {
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
