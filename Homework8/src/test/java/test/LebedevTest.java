package test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static pages.MainPage.enterToMainPage;

public class LebedevTest {

    public static String query = "всякое";

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void chainTest(){

        enterToMainPage()
                .clickOnToolsButton()
                .clickToMatrixButton()
                .input(query)
                .checkQueryResults(query);
    }
}
