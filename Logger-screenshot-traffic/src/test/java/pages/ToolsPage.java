package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ToolsPage {

    @FindBy(how = How.CSS, using = "#item-matrix")
    public SelenideElement MatrixButton;

    public MatrixPage clickToMatrixButton(){

        //$("#item-matrix").click();
        MatrixButton.click();
        return page(MatrixPage.class);
    }
}
