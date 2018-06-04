package blazedemo2;

import blazedemo2.pages.HomePage;
import blazedemo2.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite(value = "http://blazedemo.com")
public class DefaultWebSite extends WebSite {
    public static HomePage homePage;
    public static ReservePage reservePage;
}
