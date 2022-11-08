package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePage;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.ReportingAllure.saveTextLog;

public class UserSoftAssertion extends SoftAssert {
    BasePage basePage = new BasePage();
    ReportingAllure reportingAllure = new ReportingAllure();

    public UserSoftAssertion() throws AWTException {
    }
    public static LocalDateTime now;

    public static String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();
        String time = String.valueOf(now);
        return time;
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {

        ReportingAllure.saveTextLog("Test case failed: See screenshot below");

        BasePage basePage = null;
        try {
            basePage = new BasePage();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = basePage.getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            reportingAllure.saveScreenshotPNG(driver);
        }
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {

    }

    @Override
    public void onBeforeAssert(IAssert<?> assertCommand) {
        basePage.waitAction(500);
    }

    @Override
    public void onAfterAssert(IAssert<?> assertCommand) {
    }


}
