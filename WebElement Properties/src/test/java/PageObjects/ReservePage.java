package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReservePage extends PageObject {

    @FindBy(css = "table>thead>tr>th:nth-of-type(4)")
    private WebElement from;

    @FindBy(css = "table>thead>tr>th:nth-of-type(5)")
    private WebElement to;

    @FindBy(xpath = "//tr[3]/td/input")
    private WebElement chooseButton;

    @FindBy(xpath = "//tr[3]/td[2]")
    private WebElement flightNum;

    @FindBy(xpath = "//tr[3]/td[3]")
    private WebElement airline;

    @FindBy(xpath = "//tr[3]/td[6]")
    private WebElement price;


    public ReservePage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }

    private String currentURL;

    public boolean isInitialized() {
      return currentURL.equals("http://blazedemo.com/reserve.php");
    }

    public String getFrom(){
        return from.getText();
    }

    public String getTo(){
        return to.getText();
    }

    public String getFlightNum(){
        return flightNum.getText();
    }

    public String getAirline(){
        return airline.getText();
    }

    public String getPrice(){
        String priceWithout$ = price.getText().replace("$","");
        return priceWithout$;
    }

    public PurchasePage submit(){
        chooseButton.click();
        return new PurchasePage(driver);
    }
}