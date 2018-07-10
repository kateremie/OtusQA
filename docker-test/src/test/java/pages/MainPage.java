package pages;

import pages.containers.SiteMenuBlock;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage> {

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
