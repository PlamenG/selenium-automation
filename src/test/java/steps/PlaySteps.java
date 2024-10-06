package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LuckyBanditSports;
import requests.Balance;
import setup.BrowserManager;
import setup.ChromeBrowserManager;

import java.net.MalformedURLException;

public class PlaySteps {

    BrowserManager manager;
    private ChromeBrowserManager chromeBrowserManager;
    private final LuckyBanditSports luckyBanditSports;

    public PlaySteps(BrowserManager manager, ChromeBrowserManager chromeBrowserManager){
        this.manager = manager;
        this.chromeBrowserManager = chromeBrowserManager;
        WebDriver driver = chromeBrowserManager.getDriver();

        this.luckyBanditSports = new LuckyBanditSports(driver);
    }

    @Given("browser is opened")
    public void browser_is_opened() throws MalformedURLException {
        luckyBanditSports.navigateToSports();
        luckyBanditSports.loginUser("tu_plamen", "Pass112#");
        if(luckyBanditSports.isSportsBookModalWrapperDisplayed()){
            luckyBanditSports.closeSportsBookModal();
        }

        var memberBalance = luckyBanditSports.getMemberBalance();

        var balance = new Balance(chromeBrowserManager.getDriver());
        var api = balance.getMemberBalance();
        var sdad = "asdas";
    }
}
