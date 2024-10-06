package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseSteps {

    @Before()
    public void startChrome() {
        WebDriver dr = getChromeBrowserManager().getDriver();
    }

    @After()
    public void cleanUp() {
        getChromeBrowserManager().closeBrowser();
    }
}
