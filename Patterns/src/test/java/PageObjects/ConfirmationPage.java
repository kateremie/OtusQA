package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageObject {

    @FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(2)")
    private WebElement id;

    @FindBy(css = "table > tbody > tr:nth-child(2) > td:nth-child(2)")
    private WebElement status;

    @FindBy(css = "table > tbody > tr:nth-child(3) > td:nth-child(2)")
    private WebElement amount;

    @FindBy(css = "table > tbody > tr:nth-child(4) > td:nth-child(2)")
    private WebElement cartNumber;

    @FindBy(css = "table > tbody > tr:nth-child(5) > td:nth-child(2)")
    private WebElement expiration;


    public ConfirmationPage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }

    private String currentURL;

    public boolean isInitialized() {
        return currentURL.equals("http://blazedemo.com/confirmation.php");
    }

    public String id(){
        return id.getText();
    }

    public String status(){
        return status.getText();
    }

    public String amount(){
        return amount.getText();
    }

    public String lastFourNum(){
        String lastNum = cartNumber.getText().replace("xxxxxxxxxxxx","");
        return lastNum;
    }

    public String expiration(){
        return expiration.getText();
    }
}