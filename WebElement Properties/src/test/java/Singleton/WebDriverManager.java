package Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
   private static WebDriver driver;
   public static WebDriver getInstance(){
       if(driver == null){
           driver = new ChromeDriver();
       }
       return driver;
   }
}
