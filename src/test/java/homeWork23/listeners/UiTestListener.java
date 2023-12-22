package homeWork23.listeners;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

public class UiTestListener extends TestListener {
    private static final Logger logger = LoggerFactory.getLogger(UiTestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            String screenshotPath = Selenide.screenshot("failure-" + result.getMethod().getMethodName());
            logger.error("Screenshot captured for failed test: " + screenshotPath);
        }
    }
}

