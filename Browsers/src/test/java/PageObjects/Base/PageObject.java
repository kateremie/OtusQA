package PageObjects.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyReader;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static int getTimeout(){
        return Integer.parseInt(PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));
    }

}