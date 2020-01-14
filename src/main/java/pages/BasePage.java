package pages;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    Logger log = Logger.getRootLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {
        log.debug("Getting current URL");
        return driver.getCurrentUrl();
    }
}
