package PageObjects;

import PageObjects.Base.PageObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public @Data class MainPage extends PageObject {

    @FindBy(css = "select[name='fromPort']")
    private WebElement fromPort;

    @FindBy(css = "select[name='toPort']")
    private WebElement toPort;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "[href='home']")
    private WebElement homeButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }

    /*public void enterData(String depart, String arrive){
        fromPort.sendKeys(depart);
        toPort.sendKeys(arrive);
    }*/

    public ReservePage submit(){
        submitButton.click();
        return new ReservePage(driver);
    }

    public LoginPage home(){
        homeButton.click();
        return new LoginPage(driver);
    }
}