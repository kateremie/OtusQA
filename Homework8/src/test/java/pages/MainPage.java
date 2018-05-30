package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.containers.SiteMenuBlock;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage<MainPage>{

    public static final String URL = "https://www.artlebedev.ru/";
    private SiteMenuBlock menuBlock;

    public static MainPage enterToMainPage() {
        open(URL);
        return page(MainPage.class);
    }

    public ToolsPage goOnToolsPage(){

        return menuBlock.clickOnToolsButton();
    }
}
