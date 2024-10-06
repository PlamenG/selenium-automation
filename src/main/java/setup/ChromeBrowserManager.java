package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChromeBrowserManager implements BrowserManager{
    private WebDriver driver;

    public ChromeBrowserManager(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));

        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeBrowser() {
        driver.close();
    }
}
