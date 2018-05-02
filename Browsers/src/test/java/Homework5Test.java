import PageObjects.AutomationpracticeMainPage;
import PageObjects.TShirtsPage;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import lombok.*;

import static constants.cons.startURL;
import static org.testng.Assert.assertTrue;

public class Homework5Test {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) {
        driver = WebDriverManager.getInstance(browser);
        driver.get(startURL);
    }

    @Test
    public void test() {
        AutomationpracticeMainPage mainPage = new AutomationpracticeMainPage(driver);
        assertTrue(mainPage.isInitialized());
        mainPage.mouseMoveToWomenMenue();

        mainPage.waitTShirtsButtonIsDisplayed();
        mainPage.getTShirtsButton().click();

        TShirtsPage tShirtsPage = new TShirtsPage(driver);
        assertTrue(tShirtsPage.isInitialized());
        assertTrue(tShirtsPage.getCategoryName().contains("T-SHIRTS"));
    }

    @AfterClass
    public void afterClass(){
        if(driver != null)
            driver.quit();
    }
}