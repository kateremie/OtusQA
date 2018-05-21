package sputnik.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.sputnik.ru/")
public class SearchPage extends PageObject {

    @FindBy(id = "js-search-input")
    WebElementFacade searchInput;

    @FindBy(css = "[type = 'submit']")
    WebElementFacade searchButton;

    public void search(String query) {
        searchInput.type(query);
        searchButton.click();
    }
}