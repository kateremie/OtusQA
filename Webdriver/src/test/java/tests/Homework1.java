package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework1 {

   protected WebDriver chromeDriver;
   protected WebDriverWait webDriverWait;
   int timeout = 10;

   @BeforeClass
   public void beforeClass() {

      chromeDriver = new ChromeDriver();
      chromeDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
      webDriverWait = new WebDriverWait(chromeDriver,timeout);
      chromeDriver.get("http://blazedemo.com/");

   }

    @Test
    public void test(){

       //задаём параметры поиска
       String depart = new String("Boston");
       String arrive = new String("London");

       //закидываем соответствующий параметр в поле departure city
       WebElement fromPort = chromeDriver.findElement(By.cssSelector("select[name='fromPort']"));
       fromPort.sendKeys(depart);

       //закидываем соответствующий параметр в поле destination city
       WebElement toPort = chromeDriver.findElement(By.cssSelector("select[name='toPort']"));
       toPort.sendKeys(arrive);

       //нажимаем кнопку Find Flights
        chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();

       //сравниваем параметр поиска Depart с полем Departs: из шапки таблицы с результатами
       String departFromTable = new String(chromeDriver.findElement(By.cssSelector("table>thead>tr>th:nth-of-type(4)")).getText());
       assertTrue(departFromTable.contains(depart));

       //сравниваем параметр поиска Arrive с полем Arrives: из шапки таблицы с результатами
       String arriveFromTable = new String(chromeDriver.findElement(By.cssSelector("table>thead>tr>th:nth-of-type(5)")).getText());
       assertTrue(arriveFromTable.contains(arrive));

       //получение данных о рейсе для проверки
       String flightNum = new String(chromeDriver.findElement(By.xpath("//tr[3]/td[2]")).getText());
       String airline = new String(chromeDriver.findElement(By.xpath("//tr[3]/td[3]")).getText());
       String price = new String(chromeDriver.findElement(By.xpath("//tr[3]/td[6]")).getText());

       //выбор рейса
       chromeDriver.findElement(By.xpath("//tr[3]/td/input")).click();

       //проверка авиакомпании
       String airlineReserved = new String(chromeDriver.findElement(By.cssSelector("div.container > p:nth-child(2)")).getText());
       assertTrue(airlineReserved.contains(airline));

       //проверка номера рейсаа
       String flightNumReserved = new String(chromeDriver.findElement(By.cssSelector("div.container > p:nth-child(3)")).getText());
       assertTrue(flightNumReserved.contains(flightNum));

       //проверка стоимости
       String PriceReserved = new String(chromeDriver.findElement(By.cssSelector("div.container > p:nth-child(4)")).getText());
       Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
       Matcher matcher=pat.matcher(price);
       String priceForAssert = new String();
       while (matcher.find()) {priceForAssert = matcher.group();}
       assertTrue(PriceReserved.contains(priceForAssert));

       //проверка конечной цены
        float totalCost = Float.parseFloat(chromeDriver.findElement(By.cssSelector("div.container >p>em")).getText());
        Pattern pat1=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher1=pat1.matcher(chromeDriver.findElement(By.cssSelector("div.container > p:nth-child(5)")).getText());
        String AFaTForCheck = new String();
        while (matcher1.find()) {AFaTForCheck = matcher1.group();}
        float AFaT = Float.parseFloat(AFaTForCheck);
        float priceForSumm = Float.parseFloat(priceForAssert);
        assertEquals(totalCost, AFaT + priceForSumm);

        //заполнение полей данными
        chromeDriver.findElement(By.xpath("//*[@id=\"inputName\"]")).sendKeys("Kate Remie");
        chromeDriver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Test address");
        chromeDriver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Moscow");
        chromeDriver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Central");
        chromeDriver.findElement(By.xpath("//*[@id=\"zipCode\"]")).sendKeys("654321");
        String creditCardNumber = "3821 2918 9381 4321";
        chromeDriver.findElement(By.xpath("//*[@id=\"creditCardNumber\"]")).sendKeys(creditCardNumber);
        String creditCardMonth = "9";
        chromeDriver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).clear();
        chromeDriver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).sendKeys(creditCardMonth);
        String creditCardYear = "2021";
        chromeDriver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).clear();
        chromeDriver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).sendKeys(creditCardYear);
        chromeDriver.findElement(By.xpath("//*[@id=\"nameOnCard\"]")).sendKeys("Kate Remie");

        //нажать на кнопку Purchase Flight
        chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();

        //есть ID
        String id = chromeDriver.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
        assertTrue(id.length()>0);

        //eсть Status
        String status = chromeDriver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        assertEquals("PendingCapture", status);

        //есть Amount
        String amount = chromeDriver.findElement(By.cssSelector("table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
        assertTrue(amount.contains("USD"));

        //совпадают последние 4 цифры creditCardNumber
        String cardNumber = chromeDriver.findElement(By.cssSelector("table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
        String lastFourNum[] = cardNumber.split("xxxxxxxxxxxx");
        assertTrue(creditCardNumber.contains(lastFourNum[1]));

        //совпадает Expiration карты
        String expirationDate = chromeDriver.findElement(By.cssSelector("table > tbody > tr:nth-child(5) > td:nth-child(2)")).getText();
        assertEquals(creditCardMonth + " /" + creditCardYear, expirationDate);

    }

    @AfterClass
    public void afterClass(){

        chromeDriver.quit();

    }

}
