package blazedemo.pages;

import blazedemo.entities.PersonalInfo;
import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/confirmation.php")
public class ConfirmationPage extends WebPage {

    @FindBy(css = "tr:nth-of-type(1)>td:nth-of-type(2)")
    public Label id;

    @FindBy(css = "tr:nth-of-type(2)>td:nth-of-type(2)")
    public Label status;

    @FindBy(css = "tr:nth-of-type(3)>td:nth-of-type(2)")
    public Label amount;

    @FindBy(css = "tr:nth-of-type(4)>td:nth-of-type(2)")
    public Label lastNums;

    @FindBy(css = "tr:nth-of-type(5)>td:nth-of-type(2)")
    public Label expDate;

    @Step
    public boolean checkPurchaseInfo(){
        id.should(Condition.visible);
        status.should(Condition.matchText("PendingCapture"));
        return (amount.getText().contains("USD"));
    }

    @Step
    public boolean checkCreditCardInfo(){

        PersonalInfo personalInfo = new PersonalInfo();
        String last4Nums = lastNums.getText().replace("xxxxxxxxxxxx","");
        expDate.should(Condition.exactText(personalInfo.myCardMonth + " /" + personalInfo.myCardYear));
        return (personalInfo.myCardNumber.contains(last4Nums));
    }

}
