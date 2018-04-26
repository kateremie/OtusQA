package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends PageObject {

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }
    private String currentURL;

    public boolean isInitialized() {
        return currentURL.equals("http://blazedemo.com/login");
    }

    public String mouseMoveToLoginButton() {
        Actions action = new Actions(driver);
        action.moveToElement(loginButton);
        action.perform();

        String backgroundColor = loginButton.getCssValue("background-color");

        return backgroundColor;
    }

    public Dimension getButtonSize(){
       return loginButton.getSize();
    }

}
