package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeatMakerPage extends BasePage {

    @FindBy(css = ".nav-profile")
    private WebElement profileDropdown;

    private String partialSequencerStepCss = ".sequencer-step-%s-%s";


    public BeatMakerPage(WebDriver driver) {
        super(driver);
    }

    public String getProfileText() {
        log.debug("Getting text from Profile Dropdown");
        return profileDropdown.findElement(By.cssSelector("div>p")).getText();
    }

    public BeatMakerPage clickSequencerStep(int row, int column) {
        log.debug("Clicking Sequencer button at " + row + "-" + column);
        driver.findElement(By.cssSelector(String.format(partialSequencerStepCss, row, column)))
                .click();
        return this;
    }
}
