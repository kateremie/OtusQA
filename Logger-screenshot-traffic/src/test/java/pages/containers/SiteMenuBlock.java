package pages.containers;

import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import pages.ToolsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SiteMenuBlock extends ElementsContainer {

    private static final By TOOLS_BUTTON = By.xpath("//a[@href='/tools/']");

    public ToolsPage clickOnToolsButton() {

        $(TOOLS_BUTTON).click();
        return page(ToolsPage.class);
    }
}
