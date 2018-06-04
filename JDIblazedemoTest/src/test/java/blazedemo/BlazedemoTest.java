package blazedemo;

import blazedemo.entities.FlightInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static blazedemo.BaseSite.*;
import static blazedemo.pages.HomePage.*;

public class BlazedemoTest extends BaseTest {

    @Test
    public void flightPurchase(){
        WebDriverManager.chromedriver().setup();

        homePage.open();
        homePage.checkOpened();
        homePage.chooseDirection();

        reservePage.checkOpened();
        reservePage.headerCheck();
        FlightInfo info = reservePage.getFlightInfo();
        reservePage.chooseFlight();

        purchasePage.checkOpened();
        purchasePage.flightInfoCheck(info);
        purchasePage.priceCheck(info);
        purchasePage.purchaseConfirm();

        confirmationPage.checkOpened();
        confirmationPage.checkPurchaseInfo();
        confirmationPage.checkCreditCardInfo();
    }
}
