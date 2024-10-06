package steps;

import io.cucumber.java.en.Given;
import setup.BrowserManager;
import setup.ChromeBrowserManager;


public class PlaySteps {

    BrowserManager manager;
    private ChromeBrowserManager chromeBrowserManager;

    public PlaySteps(BrowserManager manager, ChromeBrowserManager chromeBrowserManager){
        this.manager = manager;
        this.chromeBrowserManager = chromeBrowserManager;
    }

    @Given("browser is opened")
    public void browser_is_opened() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
