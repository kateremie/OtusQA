package otustest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutomationpracticeSteps {
    private WebDriver driver;

    @Before
    public void beforeScenario(){
        if (driver == null) {
            driver = utils.WebDriverManager.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @Given("I am on the automationpractice.com page")
    public void i_am_on_the_automationpractice_page(){
        driver.get("http://automationpractice.com/index.php");
    }

    @When("I move mouse to Women button")
    public void i_move_mouse_to_Women_button(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("a[title='Women']")));
        action.perform();
    }

    @When("I click T-shirts button")
    public void i_click_Tshirts_button(){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("li>ul>li>a[title='T-shirts']"))));
       driver.findElement(By.cssSelector("li>ul>li>a[title='T-shirts']")).click();
    }

    @Then("The category name contains (.*)")
    public void the_category_name_contains_Tshirts(String text){
        WebElement categoryName = driver.findElement(By.cssSelector("[class='cat-name']"));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(categoryName));
        Assert.assertTrue(categoryName.getText().contains(text));
    }
}
