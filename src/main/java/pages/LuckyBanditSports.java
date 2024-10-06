package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LuckyBanditSports {
    private final WebDriver driver;
    private final By loginButtonLocator = By.cssSelector("div.cl-header-user-login button[data-target='#login-guest-modal']");
    private final By enterUserLocator = By.cssSelector("input[id='login_form[username]']");
    private final By enterPassLocator = By.cssSelector("input[id='login-modal-password-input']");
    private final By submitLoginLocator = By.cssSelector("div.modal-action-bar button[type='submit']");

    public LuckyBanditSports(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToSports(){
        driver.navigate().to("https://luckybandit.club.test-delasport.com/en/sports");
    }

    public void loginUser(String userName, String password){
        getElement(loginButtonLocator).click();
        getElement(enterUserLocator).sendKeys(userName);
        getElement(enterPassLocator).sendKeys(password);
        getElement(submitLoginLocator).click();
    }

    public WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> element.isDisplayed() && element.isEnabled());
        return element;
    }
}
