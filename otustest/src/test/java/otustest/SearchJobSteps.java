package otustest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchJobSteps {
    private WebDriver driver;

    @Before
    public void beforeScenario(){
        if (driver == null) {
            driver = utils.WebDriverManager.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @Given("I am on the hh.ru main page")
    public void i_am_on_the_hh_main_page(){
        driver.get("https://hh.ru");
    }

    @When("I search for (.*)")
    public void i_search_for(String query){
        driver.findElement(By.cssSelector("[data-qa=vacancy-serp__query]")).sendKeys(query);
        driver.findElement(By.cssSelector("[data-qa=vacancy-serp__query]")).sendKeys(Keys.ENTER);
    }

    @Then("The page title contains (.*)")
    public void the_page_title_contains(String searchresults){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[data-qa=page-title]"))));
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-qa=page-title]")).getText().contains(searchresults));
    }
}