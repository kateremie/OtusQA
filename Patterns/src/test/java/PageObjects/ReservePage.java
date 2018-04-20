package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReservePage extends PageObject {
    public ReservePage(WebDriver driver) {
        super(driver);

        from = driver.findElement(By.cssSelector("table>thead>tr>th:nth-of-type(4)"));
        to = driver.findElement(By.cssSelector("table>thead>tr>th:nth-of-type(5)"));
        currentURL = driver.getCurrentUrl();
        chooseButton = driver.findElement(By.xpath("//tr[3]/td/input"));
        flightNum = driver.findElement(By.xpath("//tr[3]/td[2]"));
        airline = driver.findElement(By.xpath("//tr[3]/td[3]"));
        price = driver.findElement(By.xpath("//tr[3]/td[6]"));
    }

    private WebElement from;
    private WebElement to;
    private WebElement chooseButton;
    private String currentURL;
    private WebElement flightNum;
    private WebElement airline;
    private WebElement price;

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