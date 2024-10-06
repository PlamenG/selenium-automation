package steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LuckyBanditSports;
import requests.Balance;
import setup.BrowserManager;
import setup.ChromeBrowserManager;

import java.io.IOException;
import java.util.List;

public class MemberBalanceSteps {

    BrowserManager manager;
    private ChromeBrowserManager chromeBrowserManager;
    private final LuckyBanditSports luckyBanditSports;

    public MemberBalanceSteps(BrowserManager manager, ChromeBrowserManager chromeBrowserManager){
        this.manager = manager;
        this.chromeBrowserManager = chromeBrowserManager;
        WebDriver driver = chromeBrowserManager.getDriver();

        this.luckyBanditSports = new LuckyBanditSports(driver);
    }

    @Given("user navigates to Lucky Bandit Sports section")
    public void user_navigates_to_lucky_bandit_sports_section() {
        luckyBanditSports.navigateToSports();
    }

    @Then("user member balance is the same both on the Page and in the API")
    public void user_member_balance_is_the_same_both_on_the_page_and_in_the_api() throws IOException {
        var memberBalance = luckyBanditSports.getMemberBalance();

        var uiBalance = new Balance(chromeBrowserManager.getDriver());
        String apiResponse = uiBalance.getMemberBalance();

        List<String> apiBalance = JsonPath.read(apiResponse, "$..info[?(@.key=='uiBalance')].['raw_amount']");

        Assert.assertEquals(memberBalance, Float.parseFloat(apiBalance.getFirst()), "UI member uiBalance is different from API value");
    }
}
