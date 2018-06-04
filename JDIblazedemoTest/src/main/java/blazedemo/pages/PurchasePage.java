package blazedemo.pages;

import blazedemo.entities.FlightInfo;
import blazedemo.entities.PersonalInfo;
import blazedemo.entities.PurchaseForm;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage (url = "/purchase.php")
public class PurchasePage extends WebPage {

    @FindBy(css = "div>p:nth-of-type(1)")
    public Label airline;

    @FindBy(css = "div>p:nth-of-type(2)")
    public Label flightNumber;

    @FindBy(css = "div>p:nth-of-type(3)")
    public Label price;

    @FindBy(css = "div>p:nth-of-type(4)")
    public Label feesAndTaxes;

    @FindBy(css = "div>p :first-child")
    public Label totalCost;

    public PurchaseForm purchaseForm;

    @Step
    public boolean flightInfoCheck(FlightInfo flightInfo){

        String temp = flightInfo.Price.replace("$","");
        assert (price.getText().contains(temp));
        assert(airline.getText().contains(flightInfo.Airline));
        return (flightNumber.getText().contains(flightInfo.FlightNum));
    }

    @Step
    public boolean priceCheck(FlightInfo flightInfo){
        String tempPrice = price.getText().replace("Price: ","");
        String tempTaxes = feesAndTaxes.getText().replace("Arbitrary Fees and Taxes: ","");
        float tempPrice1 = Float.parseFloat(tempPrice);
        float tempTaxes1 = Float.parseFloat(tempTaxes);
        float tempCost = Float.parseFloat(totalCost.getText());
        return (tempCost==tempPrice1+ tempTaxes1);
    }

    @Step
    public void purchaseConfirm(){

        purchaseForm.submit();
    }
}
