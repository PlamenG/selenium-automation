package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LuckyBanditSports;
import setup.BrowserManager;
import setup.ChromeBrowserManager;

public class LoginSteps {
    BrowserManager manager;
    private ChromeBrowserManager chromeBrowserManager;
    private final LuckyBanditSports luckyBanditSports;

    public LoginSteps(BrowserManager manager, ChromeBrowserManager chromeBrowserManager){
        this.manager = manager;
        this.chromeBrowserManager = chromeBrowserManager;
        WebDriver driver = chromeBrowserManager.getDriver();

        this.luckyBanditSports = new LuckyBanditSports(driver);
    }

    @When("user logs in")
    public void user_logs_in() {
        luckyBanditSports.loginUser("tu_plamen", "Pass112#");
        if(luckyBanditSports.isSportsBookModalWrapperDisplayed()){
            luckyBanditSports.closeSportsBookModal();
        }
    }
}
