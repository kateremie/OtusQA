package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementListIterator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class MatrixPage {

    @FindBy(how = How.CSS, using = "[class='input']")
    public SelenideElement InputField;

    public MatrixPage input(String query){

        //$("[class='input']").clear();
        InputField.clear();
        //$("[class='input']").setValue(query).pressEnter();
        InputField.setValue(query).pressEnter();

        return page(MatrixPage.class);
    }

    public boolean checkQueryResults(String query){

        $$("div[class='als-columns text-double-margin']>div").shouldHave(size(2));
        $("input[value='"+query+"']").should(Condition.visible);

        return true;
    }
}
