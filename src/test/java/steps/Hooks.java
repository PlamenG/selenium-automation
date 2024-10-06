package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseSteps {
    private WebDriver driver;

    @Before()
    public void startChrome() {
        driver = getChromeBrowserManager().getDriver();
    }

    @After()
    public void cleanUp() {
        driver.close();
    }
}
