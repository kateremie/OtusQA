package blazedemo.entities;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class PurchaseForm extends Form<PersonalInfo> {

    @FindBy(id = "inputName")
    public TextField myName;

    @FindBy(id = "address")
    public TextField myAddress;

    @FindBy(id = "city")
    public TextField myCity;

    @FindBy(id = "state")
    public TextField myState;

    @FindBy(id = "zipCode")
    public TextField myZipCode;

    @FindBy(id = "creditCardNumber")
    public TextField myCardNumber;

    @FindBy(id = "creditCardMonth")
    public TextField myCardMonth;

    @FindBy(id = "creditCardYear")
    public TextField myCardYear;

    @FindBy(id = "nameOnCard")
    public TextField myNameOnCard;

    @FindBy(css = "[type='submit']")
    public Button submit;

    public void submit() {
        this.submit(new PersonalInfo());
    }
}