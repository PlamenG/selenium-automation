package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeBrowserManager implements BrowserManager{
    private WebDriver driver;

    public ChromeBrowserManager(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking", "enable-automation"));

        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeBrowser() {
        driver.close();
    }
}
