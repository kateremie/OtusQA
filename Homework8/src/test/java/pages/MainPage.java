package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage<MainPage>{

    public static final String URL = "https://www.artlebedev.ru/";

    @FindBy (how = How.XPATH, using = "//a[@href='/tools/']")
    public SelenideElement ToolsButton;

    public static MainPage enterToMainPage() {
        open(URL);
        return page(MainPage.class);
    }

    public ToolsPage clickOnToolsButton(){
        //$x("//a[@href='/tools/']").click();
        ToolsButton.click();
        return page(ToolsPage.class);
    }
}
