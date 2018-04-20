import PageObjects.ConfirmationPage;
import PageObjects.MainPage;
import PageObjects.PurchasePage;
import PageObjects.ReservePage;
import Singleton.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework3 {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverManager.getInstance();
        driver.get("http://blazedemo.com/");
    }

    @Test
    public void test(){

        String depart = "Boston";
        String arrive = "London";

        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isInitialized());

        mainPage.enterData(depart, arrive);

        ReservePage reservePage = mainPage.submit();
        assertTrue(reservePage.isInitialized());

        assertTrue(reservePage.getFrom().contains(depart));
        assertTrue(reservePage.getTo().contains(arrive));

        String flightNum = reservePage.getFlightNum();
        String airline = reservePage.getAirline();
        String price = reservePage.getPrice();

        PurchasePage purchasePage = reservePage.submit();
        assertTrue(purchasePage.isInitialized());

        assertEquals(purchasePage.airlineCheck(),airline);
        assertEquals(purchasePage.flightNum(),flightNum);
        assertEquals(purchasePage.priceCheck(),price);
        assertEquals(purchasePage.deltaPrice(),Double.parseDouble(price));

        String creditCardNumber = "3821 2918 9381 4321";
        String creditCardMonth = "9";
        String creditCardYear = "2021";
        purchasePage.personInformation(creditCardNumber, creditCardMonth, creditCardYear);

        ConfirmationPage confirmationPage = purchasePage.submit();
        assertTrue(confirmationPage.isInitialized());

        assertTrue(confirmationPage.id().length()>0);
        assertEquals("PendingCapture", confirmationPage.status());
        assertTrue(confirmationPage.amount().contains("USD"));
        assertTrue(creditCardNumber.contains(confirmationPage.lastFourNum()));
        assertEquals(creditCardMonth + " /" + creditCardYear, confirmationPage.expiration());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}