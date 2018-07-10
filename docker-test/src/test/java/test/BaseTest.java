package test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.EventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability();
//        LoggingPreferences logs = new LoggingPreferences();
//        logs.enable(LogType.PERFORMANCE, Level.INFO);
//        caps.setCapability(CapabilityType.LOGGING_PREFS, logs);

//        Configuration.browser = "chrome";
//        Configuration.browserCapabilities = caps;
        WebDriverManager.chromedriver().setup();

        addListener(new EventListener());
        driver = getWebDriver();
    }

    @AfterTest
    public void writeLogs() throws IOException {
        FileWriter logsFile = new FileWriter("Logs.txt", false);
        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);

        for (LogEntry entry : logEntries) {
            logsFile.write(entry.getLevel() + " " + entry.getMessage());
            logsFile.flush();
            //System.out.println(entry.getLevel()+ " " + entry.getMessage());
        }
    }
}
