package PageObjects;

import PageObjects.Base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends PageObject {

    @FindBy(css="[class='cat-name']")
    private WebElement categoryName;

    public TShirtsPage(WebDriver driver) {
        super(driver);
        currentURL = driver.getCurrentUrl();
    }
    private String currentURL;

    public boolean isInitialized() {
        return currentURL.equals("http://automationpractice.com/index.php?id_category=5&controller=category");
    }

    public String getCategoryName(){
        return categoryName.getText();
    }
}
