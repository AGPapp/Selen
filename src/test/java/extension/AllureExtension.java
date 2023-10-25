package extension;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testframe.managers.DriverMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllureExtension implements TestWatcher, AfterAllCallback {

    private List<TestResultStatus> testResultStatuses = new ArrayList<>();

    private  enum TestResultStatus{
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreen();
        testResultStatuses.add(TestResultStatus.FAILED);
        TestWatcher.super.testFailed(context, cause);
    }
    @Attachment(type = "image/png", value ="Screenshot")
    public static byte[] takeScreen() {
        return ((TakesScreenshot) DriverMan.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
