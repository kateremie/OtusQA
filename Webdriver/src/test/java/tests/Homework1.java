package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework1 {
   @Test

    public void test()throws InterruptedException{
       WebDriver driver = new ChromeDriver();
       //1. Открыть страницу BlazeDemo.com
       driver.get("http://blazedemo.com/");
       //задаём параметры поиска
       String Depart = new String("Boston");
       String Arrive = new String("London");
       //закидываем соответствующий параметр в поле departure city
       WebElement fromPort = driver.findElement(By.cssSelector("select[name='fromPort']"));
       fromPort.sendKeys(Depart);
       //закидываем соответствующий параметр в поле destination city
       WebElement toPort = driver.findElement(By.cssSelector("select[name='toPort']"));
       toPort.sendKeys(Arrive);
       //нажимаем кнопку Find Flights
       driver.findElement(By.cssSelector("input[type='submit']")).click();
       //сравниваем параметр поиска Depart с соответствующим параметром поисковой выдачи
       String DepartFromTable = new String(driver.findElement(By.cssSelector("div>input[name='fromPort']")).getAttribute("value"));
       Assertions.assertEquals(Depart,DepartFromTable);
       //сравниваем параметр поиска Arrive с соответствующим параметром поисковой выдачи
       String ArriveFromTable = new String(driver.findElement(By.cssSelector("div>input[name='toPort']")).getAttribute("value"));
       Assertions.assertEquals(Arrive,ArriveFromTable);
       //проверяем, что результат поиска не пуст - отображается кнопка Choose This Flight
       WebElement ChooseFlightButton = driver.findElement(By.cssSelector("input[type=submit]"));
       assertTrue(ChooseFlightButton.isDisplayed());

       Thread.sleep(5000);
       driver.quit();
    }
}
