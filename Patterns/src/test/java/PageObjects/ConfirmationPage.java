package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends PageObject {
    public ConfirmationPage(WebDriver driver) {
        super(driver);

        currentURL = driver.getCurrentUrl();
        id = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(2)"));
        status = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td:nth-child(2)"));
        amount = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(3) > td:nth-child(2)"));
        cartNumber = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(4) > td:nth-child(2)"));
        expiration = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(5) > td:nth-child(2)"));

    }

    private String currentURL;
    private WebElement id;
    private WebElement status;
    private WebElement amount;
    private WebElement cartNumber;
    private WebElement expiration;

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