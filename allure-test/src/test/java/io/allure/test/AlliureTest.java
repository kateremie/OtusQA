package io.allure.test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import javafx.scene.shape.Path;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class AlliureTest {

    @Test
    public void firstTest(){
        stepWithParameters(10,20);
        assertThat(2,is(2));
    }

/*    @Test
    @Issue("AC-100")
    @TmsLink("10542")
    public void throwAnExceptionTest(){
        throw new IllegalStateException("Some strange thinks happened");
    }*/

    @Test
    public void  attachmentsTest() throws IOException, URISyntaxException {
        saveAttachment();
    }

    @Attachment(value = "Simple csv test", type = "text/csv")
    public byte[] saveAttachment() throws URISyntaxException, IOException {
        return Files.readAllBytes(Paths.get(
                getClass().getClassLoader().getResource("simple.csv").toURI()));
    }

    @Step("This is a step with parameters")
    public void stepWithParameters(int firstParam, int secondParam){
        for(int i=0;i<100; i++){
            innerStep();
        }
    }

    @Step("Inner step")
    public void innerStep(){}

}
