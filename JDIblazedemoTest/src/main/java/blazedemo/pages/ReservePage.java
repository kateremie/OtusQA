package blazedemo.pages;

import blazedemo.entities.FlightInfo;
import blazedemo.entities.FlightRecord;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static blazedemo.vars.vars.*;

@JPage(url="/reserve.php")
public class ReservePage extends WebPage {

    @FindBy(xpath = "//h3")
    public WebElement header;

    @JTable(
            root = @FindBy(css = ".table"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]"),
            header = {"Choose", "FlightNum", "Airline", "Departs", "Arrives", "Price"})
    public EntityTable<FlightInfo, FlightRecord> resultTable;

    @Step
    public void headerCheck(){
       Assert.contains(header.getText(),FROM);
       Assert.contains(header.getText(),TO);
    }

    @Step
    public FlightInfo getFlightInfo(){

        return resultTable.entity(3);
    }

    @Step
    public void chooseFlight(){

        resultTable.row(3).get("Choose").click();
    }
}
