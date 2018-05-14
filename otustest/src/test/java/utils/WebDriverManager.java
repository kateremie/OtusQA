package utils;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    static WebDriver driver;

    private static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    public static WebDriver getDriver(){

        if(driver == null){
            //String browser =  "chrome";
            String browser = getParameter("browser");

            switch (browser){
                case "chrome": {
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "remotewebdriver": {
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    try {
                        driver = new RemoteWebDriver(new URL("http://192.168.55.93:4444/wd/hub"), DesiredCapabilities.chrome());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return driver;
    }
}
