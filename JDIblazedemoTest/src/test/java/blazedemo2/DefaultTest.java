package blazedemo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class DefaultTest extends BaseTest {

    @Test
    public void flightPurchase(){
        WebDriverManager.chromedriver().setup();

        DefaultWebSite.homePage.open();
        DefaultWebSite.homePage.checkOpened();
        DefaultWebSite.homePage.reserveForm.submit();

        DefaultWebSite.reservePage.checkOpened();
    }
}
