package blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static blazedemo.vars.vars.*;

@JPage(url="/index.php")
public class HomePage extends WebPage {

    @FindBy(xpath = "//*[@name='fromPort']")
    public Selector departure;

    @FindBy(xpath = "//*[@name='toPort']")
    public Selector arrive;

    @FindBy(xpath = "//*[@type='submit']")
    public Button submit;

    @Step
    public void chooseDirection(){

        departure.select(FROM);
        arrive.select(TO);

        submit.click();
    }

}
