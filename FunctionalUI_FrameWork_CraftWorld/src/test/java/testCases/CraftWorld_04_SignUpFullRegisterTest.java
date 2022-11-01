package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class CraftWorld_04_SignUpFullRegisterTest extends BaseTest{


    public CraftWorld_04_SignUpFullRegisterTest() throws AWTException {
    }

    @BeforeMethod
    public void goToLoginPopUp() {
        craftWorld_01_header_page_logOutUser.clickOnSignUp();
        craftWorld_05_signUp_popUp_page.clickOnButtonFullRegistration();
    }



    @Test(priority = 1, description = "" +
            " ")
    @Description("" +
            " ")
    @Severity(SeverityLevel.MINOR)
    public void SignUpPopUpQuickRegisterLabelsPresenceVerification_Test() {
        SoftAssert softAssert = new SoftAssert();

        String actTitle = craftWorld_05_signUp_popUp_page.getTitleF();
        logger.info("Title Captured: " + actTitle);

        String expectedTitle = "Full Register";
        logger.info("Title expected: " + expectedTitle);

        softAssert.assertEquals(actTitle, expectedTitle);
        logger.info("Title checked");

        softAssert.assertAll();
    }
}
