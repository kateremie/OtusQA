package blazedemo2.pages;

import blazedemo2.forms.ReserveForm;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url="/index.php")
public class HomePage extends WebPage {
    public ReserveForm reserveForm = new ReserveForm();
}
