package blazedemo;

import blazedemo.pages.ConfirmationPage;
import blazedemo.pages.HomePage;
import blazedemo.pages.PurchasePage;
import blazedemo.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import ru.yandex.qatools.allure.annotations.Step;

import static blazedemo.vars.vars.*;

@JSite(value = "http://blazedemo.com")
public class BaseSite extends WebSite {

    @JPage
    public static HomePage homePage;

    @JPage
    public static ReservePage reservePage;

    @JPage
    public static PurchasePage purchasePage;

    @JPage
    public static ConfirmationPage confirmationPage;

}
