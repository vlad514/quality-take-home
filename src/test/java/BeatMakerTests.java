import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BeatMakerPage;
import pages.MainPage;

public class BeatMakerTests extends BaseTest {

    @Test(description = "Verifying link to Beat Maker", priority = 1)
    public void testNavigatingToBeatMaker() {
        BeatMakerPage page = new MainPage(driver)
                .clickCreateYourOwnBeatLink();
        String URL = page.getCurrentUrl();
        Assert.assertEquals(URL, "https://splice.com/sounds/beatmaker", "Invalid URL");
    }

    @Test(description = "Verify Profile changes to custom after editing", priority = 2)
    public void testProfileChangesToCustom() {
        BeatMakerPage page = new MainPage(driver)
                .clickCreateYourOwnBeatLink();
        String profileText = page.getProfileText();
        Assert.assertEquals(profileText, "KRNE", "Profile doesn't have default value: KRNE");
        page.clickSequencerStep(0, 0);
        profileText = page.getProfileText();
        Assert.assertEquals(profileText, "YOUR CUSTOM BEAT", "Profile didn't switch to CUSTOM BEAT after editing");
    }
}
