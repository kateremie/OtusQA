package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageObject {
    public MainPage(WebDriver driver) {
        super(driver);

        // TODO: переделать на @FindBy как на видео
        fromPort = driver.findElement(By.cssSelector("select[name='fromPort']"));
        toPort = driver.findElement(By.cssSelector("select[name='toPort']"));
        submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
    }

    private WebElement fromPort;
    private WebElement toPort;
    private WebElement submitButton;

    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }

    public void enterData(String depart, String arrive){
        fromPort.sendKeys(depart);
        toPort.sendKeys(arrive);
    }

    public ReservePage submit(){
        submitButton.click();
        return new ReservePage(driver);
    }
}