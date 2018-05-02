package PageObjects;

import PageObjects.Base.PageObject;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationpracticeMainPage extends PageObject {

    @FindBy(css = "a[title='Women']")
    private WebElement womenMenue;

    @FindBy(css="li>ul>li>a[title='T-shirts']")
    @Getter
    private WebElement tShirtsButton;

    public AutomationpracticeMainPage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }

    private String currentURL;

    public boolean isInitialized() {
        return currentURL.equals("http://automationpractice.com/index.php");
    }

    public void mouseMoveToWomenMenue() {
        Actions action = new Actions(driver);
        action.moveToElement(womenMenue);
        action.perform();
        return;
    }

    public void waitTShirtsButtonIsDisplayed(){
        new WebDriverWait(driver, getTimeout()).until(
                ExpectedConditions.visibilityOf(tShirtsButton));
    }


}
