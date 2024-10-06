package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LuckyBanditSports;
import setup.BrowserManager;
import setup.ChromeBrowserManager;


public class PlaySteps {

    BrowserManager manager;
    private ChromeBrowserManager chromeBrowserManager;
    private WebDriver driver;
    private LuckyBanditSports luckyBanditSports;

    public PlaySteps(BrowserManager manager, ChromeBrowserManager chromeBrowserManager){
        this.manager = manager;
        this.chromeBrowserManager = chromeBrowserManager;
        this.driver = chromeBrowserManager.getDriver();

        this.luckyBanditSports = new LuckyBanditSports(driver);
    }

    @Given("browser is opened")
    public void browser_is_opened() {
        // Write code here that turns the phrase above into concrete actions
        luckyBanditSports.navigateToSports();
        luckyBanditSports.loginUser("tu_plamen", "Pass112#");
        var sdad = "asdas";
    }
}
