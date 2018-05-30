package pages.containers;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
