package test;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import static pages.MainPage.enterToMainPage;

@Listeners(TestListener.class)
public class LebedevTest extends BaseTest{

    public static String query = "всякое";

    @Test
    public void chainTest() throws IOException {

        enterToMainPage()
                .goOnToolsPage()
                .clickToMatrixButton()
                .input(query)
                .checkQueryResults("Test Failure logs test");
                //.checkQueryResults(query);
    }
}
