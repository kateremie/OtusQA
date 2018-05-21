package sputnik.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class ResultPage extends PageObject {

    @FindBy(css="[class='b-result-list js-result-list']")
    WebElementFacade results;

    @FindBy(css="[name='q']")
    WebElementFacade searchBar;

    public boolean resultsAreDisplayed() {
        results.waitUntilVisible();
        return results.isDisplayed();
    }

    public String searchBarGetText() {
        return searchBar.getValue();
    }
}
