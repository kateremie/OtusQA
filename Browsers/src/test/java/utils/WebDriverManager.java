package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.Parameters;

public class WebDriverManager {
   private static WebDriver driver;

   @Parameters("browser")
   public static WebDriver getInstance(String browser){
           if(browser.equals("chrome")) {
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--headless");
               driver = new ChromeDriver(options);
           }
           else if(browser.equals("opera")) {
               io.github.bonigarcia.wdm.WebDriverManager.operadriver().setup();
               OperaOptions optionsOP = new OperaOptions();
               optionsOP.setBinary("C:/Program Files/Opera/launcher.exe");
               driver = new OperaDriver(optionsOP);
           }
       return driver;
   }
}