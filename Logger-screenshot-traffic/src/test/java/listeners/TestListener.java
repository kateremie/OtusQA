package listeners;

import com.sun.istack.internal.logging.Logger;
import logger.ScreenShot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.LebedevTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("LebedevTest starts");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test succeed");
    }

    public void onTestFailure(ITestResult iTestResult) {

        ScreenShot testFailScreen = new ScreenShot();
        testFailScreen.takeScreenShot(LebedevTest.driver);
        Date failedTime = new Date(iTestResult.getEndMillis());
        logger.info("---------------------------------------------\n Test failed: "+ failedTime + iTestResult.getTestClass());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable cause = iTestResult.getThrowable();
        cause.printStackTrace(printWriter);
        logger.info("----------------------------------------------\n Cause: "+ stringWriter.getBuffer().toString());
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
