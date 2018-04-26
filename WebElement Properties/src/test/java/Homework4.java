import PageObjects.*;
import Singleton.WebDriverManager;
import lombok.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static constants.cons.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework4 {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverManager.getInstance();
        driver.get(startURL);
    }

    @Test
    public void test() {

        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isInitialized());

        LoginPage loginPage = mainPage.home();
        assertTrue(loginPage.isInitialized());

        Dimension loginButtonSizeBeforeMouseMove, loginButtonSizeAfterMouseMove;
        loginButtonSizeBeforeMouseMove = loginPage.getButtonSize();
        assertEquals(loginPage.mouseMoveToLoginButton(), backgroundColar);
        loginButtonSizeAfterMouseMove = loginPage.getButtonSize();
        assertEquals(loginButtonSizeAfterMouseMove,loginButtonSizeBeforeMouseMove);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}