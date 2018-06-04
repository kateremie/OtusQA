package blazedemo2.forms;

import blazedemo2.models.ReserveModel;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class ReserveForm extends Form<ReserveModel> {
    @FindBy(xpath="//*[@name='fromPort']")
    public Dropdown fromPort;

    @FindBy(xpath="//*[@name='toPort']")
    public Dropdown toPort;

    @FindBy(xpath="//*[@type='submit']")
    public Button submit;

    public void submit() {
        this.submit(new ReserveModel());
    }
}
