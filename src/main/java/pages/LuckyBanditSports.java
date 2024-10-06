package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LuckyBanditSports {
    private final WebDriver driver;
    private final By loginButtonLocator = By.cssSelector("div.cl-header-user-login button[data-target='#login-guest-modal']");
    private final By enterUserLocator = By.cssSelector("input[id='login_form[username]']");
    private final By enterPassLocator = By.cssSelector("input[id='login-modal-password-input']");
    private final By submitLoginLocator = By.cssSelector("div.modal-action-bar button[type='submit']");
    private final By sportsBookModalWrapperLocator = By.id("sportsbookModal");
    private final By sportsBookModalCloseButtonLocator = By.cssSelector("#sportsbookModal button[aria-label='Close']");
    private final By userPersonalSportCasinoBalancesLocator = By.cssSelector("li.user-balance-item");

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

    public List<WebElement> getElements(By locator){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> !driver.findElements(locator).isEmpty());
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement el : elements){
            wait.until(d -> el.isDisplayed() && el.isEnabled());
        }
        return elements;
    }

    public Boolean isSportsBookModalWrapperDisplayed(){
        return !getElements(sportsBookModalWrapperLocator).isEmpty();
    }

    public void closeSportsBookModal(){
        getElement(sportsBookModalCloseButtonLocator).click();
    }

    public float getMemberBalance(){
        List<WebElement> balances = getElements(userPersonalSportCasinoBalancesLocator);
        String memberBalance = "";
        for(WebElement balance : balances){
            var text = balance.getText();
            if(balance.getText().contains("BALANCE")){
                memberBalance = balance.getText();
            }
        }

        return Float.parseFloat(memberBalance.replaceAll("[^\\d.]+|\\.(?!\\d)", "")) ;
    }
}
