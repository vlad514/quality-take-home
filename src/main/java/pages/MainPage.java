package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage extends BasePage {
    @FindBy(linkText = "Create Your Own Beat")
    private WebElement beatMakerLink;

    private By acceptCookieButton = By.cssSelector("[data-qa='gdpr-cookie-banner']");

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://splice.com/");
        //checking if the cookie button exists and clicking it if it does. Otherwise the banner might intercept clicks
        try {
            WebElement gotItButton = new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
            gotItButton.click();
        } catch (Exception ignore) {
            //ignoring exception if the button doesn't exist
        }

    }

    public BeatMakerPage clickCreateYourOwnBeatLink() {
        log.debug("Clicking 'Create Your Own Beat' link");
        String currentWindowHandle = driver.getWindowHandle();
        beatMakerLink.click();
        Set<String> handles = driver.getWindowHandles();
        handles.remove(currentWindowHandle);
        driver.switchTo().window(handles.iterator().next());
        return new BeatMakerPage(driver);
    }
}
