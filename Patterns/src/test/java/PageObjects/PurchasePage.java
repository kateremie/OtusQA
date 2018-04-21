package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PurchasePage extends PageObject {

    @FindBy(css = "input[type='submit']")
    private WebElement purchaseButton;

    @FindBy(css = "div.container > p:nth-child(2)")
    private WebElement airline;

    @FindBy(css = "div.container > p:nth-child(3)")
    private WebElement flightNum;

    @FindBy(css = "div.container > p:nth-child(4)")
    private WebElement price;

    @FindBy(css = "div.container >p>em")
    private WebElement totalCost;

    @FindBy(css = "div.container > p:nth-child(5)")
    private WebElement arbitraryFeesandTaxes;


    public PurchasePage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }

    private String currentURL;

    public boolean isInitialized() {
        return currentURL.equals("http://blazedemo.com/purchase.php");
    }

    public String airlineCheck(){
        String airlineName = airline.getText().replace("Airline: ","");
        return airlineName;
    }

    public String flightNum(){
        String flight = flightNum.getText().replace("Flight Number: ","");
        return flight;
    }

    public String priceCheck(){
       String priceShort = price.getText().replace("Price: ","");
       return priceShort;
    }

    public double deltaPrice(){
        String AFAT = arbitraryFeesandTaxes.getText().replace("Arbitrary Fees and Taxes: ","");
        String total = totalCost.getText().replace(" ","");
        double delta = Double.parseDouble(total)-Double.parseDouble(AFAT);
       // BigDecimal.valueOf(delta).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double delta1 = new BigDecimal(delta).setScale(2, RoundingMode.DOWN).doubleValue();
        return delta1;
    }

    public void personInformation(String creditCardNumber, String creditCardMonth, String creditCardYear){
        driver.findElement(By.xpath("//*[@id=\"inputName\"]")).sendKeys("Kate Remie");
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Test address");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Moscow");
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Central");
        driver.findElement(By.xpath("//*[@id=\"zipCode\"]")).sendKeys("654321");
        driver.findElement(By.xpath("//*[@id=\"creditCardNumber\"]")).sendKeys(creditCardNumber);
        driver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).sendKeys(creditCardMonth);
        driver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).sendKeys(creditCardYear);
        driver.findElement(By.xpath("//*[@id=\"nameOnCard\"]")).sendKeys("Kate Remie");
    }

    public ConfirmationPage submit(){
        purchaseButton.click();
        return new ConfirmationPage(driver);
    }
}