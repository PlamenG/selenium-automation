package steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LuckyBanditSports;
import requests.Balance;
import setup.BrowserManager;
import setup.ChromeBrowserManager;

import java.io.IOException;
import java.util.List;

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
    public void browser_is_opened() throws IOException {
        luckyBanditSports.navigateToSports();
        luckyBanditSports.loginUser("tu_plamen", "Pass112#");
        if(luckyBanditSports.isSportsBookModalWrapperDisplayed()){
            luckyBanditSports.closeSportsBookModal();
        }

        var memberBalance = luckyBanditSports.getMemberBalance();

        var balance = new Balance(chromeBrowserManager.getDriver());
        String apiResponse = balance.getMemberBalance();

        List<String> memberBalance2 = JsonPath.read(apiResponse, "$..info[?(@.key=='balance')].['raw_amount']");

        Assert.assertEquals(memberBalance, Float.parseFloat(memberBalance2.get(0)), "UI member balance is different from API value");
    }
}
