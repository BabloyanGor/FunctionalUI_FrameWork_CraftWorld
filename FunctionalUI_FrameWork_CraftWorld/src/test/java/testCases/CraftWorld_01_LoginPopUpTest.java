package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class

CraftWorld_01_LoginPopUpTest extends BaseTest {
    int wait = 1000;

    public CraftWorld_01_LoginPopUpTest() throws AWTException {
    }

    @BeforeMethod
    public void goToLoginPopUp() {
        craftWorld_01_header_page_logOutUser.clickOnLogInButtonIfVisible();
    }


    @Test(priority = 1, description = "Validate on Log_in Pop Up Header, Email/mobile or username, Password, Remember me," +
            " You can Sign in with, Don't have an account? Sign Up, Don't have an account? Sign Up, Safe and Secure labels, Login Buttons text")
    @Description("Validate on Log_in Pop Up Header, Email/mobile or username, Password, Remember me," +
            " You can Sign in with, Don't have an account? Sign Up, Don't have an account? Sign Up, Safe and Secure labels, Login Buttons text")
    @Severity(SeverityLevel.MINOR)
    public void loginPopUpLabelsPresenceVerification_Test() {
        SoftAssert softAssert = new SoftAssert();
        String actHeader = craftWorld_03_login_popUp_page.getLoginPopUpHeader();
        logger.info("Header Captured:  " + craftWorld_03_login_popUp_page.getLoginPopUpHeader());

        String actualEmailLabel = craftWorld_03_login_popUp_page.getLoginPopUpEmailOrUsernameLabel();
        logger.info("Username label captured:  " +  craftWorld_03_login_popUp_page.getLoginPopUpEmailOrUsernameLabel());

        String actualPasswordLabel = craftWorld_03_login_popUp_page.getLoginPopUpPasswordLabel();
        logger.info("Password label captured:  " + craftWorld_03_login_popUp_page.getLoginPopUpPasswordLabel());

        String actualRememberMyLabel = craftWorld_03_login_popUp_page.loginPopUpRememberMeLabelGetText();
        logger.info("Remember me label Captured:  " +  craftWorld_03_login_popUp_page.loginPopUpRememberMeLabelGetText());

        String actualYouCanSignUpWithLabel = craftWorld_03_login_popUp_page.loginPopUpYouCanSignUpWithLabelGetText();
        logger.info("You can Sign in with label Captured:  " + craftWorld_03_login_popUp_page.loginPopUpYouCanSignUpWithLabelGetText());

        String actualDontHaveAnAccountLabel = craftWorld_03_login_popUp_page.loginPopUpDoNotHaveAccountLabelGetText();
        logger.info("Don't have an account? label Captured:  ");

        String actualSaveAndSecureLabel = craftWorld_03_login_popUp_page.loginPopUpSaveAndSecureLabelGetText();
        logger.info("Safe and secure label Captured:  " +  craftWorld_03_login_popUp_page.loginPopUpDoNotHaveAccountLabelGetText());

        craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys("g.babloyan@iqsoft.am");
        logger.info("Username passed");

        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys("12345678");
        logger.info("Password passed");

        String actualLoginButtonText = craftWorld_03_login_popUp_page.loginPopUpLoginButtonGetText();
        logger.info("Login buttons label Captured");

        String expectedHeader = "Log In";
        String expectedEmailLabel = "Email/mobile or username";
        String expectedPasswordLabel = "Password";
        String expectedRememberMyLabel = "Remember me";
        String expectedYouCanSignUpWithLabel = "You can Sign in with";
        String expectedDontHaveAnAccountLabel = "Don't have an account? Sign Up";
        String expectedSaveAndSecureLabel = "Safe and Secure";
        String expectedLoginButtonText = "Log In";


        softAssert.assertEquals(actHeader, expectedHeader);
        logger.info("Header label checked");
        softAssert.assertEquals(actualEmailLabel, expectedEmailLabel);
        logger.info("username label checked");
        softAssert.assertEquals(actualPasswordLabel, expectedPasswordLabel);
        logger.info("password label checked");
        softAssert.assertEquals(actualRememberMyLabel, expectedRememberMyLabel);
        logger.info("Remember me label checked");
        softAssert.assertEquals(actualYouCanSignUpWithLabel, expectedYouCanSignUpWithLabel);
        logger.info("You can Sign in with label checked");
        softAssert.assertEquals(actualDontHaveAnAccountLabel, expectedDontHaveAnAccountLabel);
        logger.info("Don't have an account? Sign Up");
        softAssert.assertEquals(actualSaveAndSecureLabel, expectedSaveAndSecureLabel);
        logger.info("Safe and secure label checked");
        softAssert.assertEquals(actualLoginButtonText, expectedLoginButtonText);
        logger.info("Login Button label checked");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Validate on Log_in Pop Up Logo Presence")
    @Description("Validate on Log_in Pop Up Logo Presence")
    @Severity(SeverityLevel.MINOR)
    public void loginPopUpLogoPresenceVerification_Test() {
        Assert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpLogoPresence(), true);
        logger.info("Logo presence checked");
    }

    @Test(priority = 3, description = "Validate on Log_in Pop Up Close (X) button functionality")
    @Description("Validate on Log_in Pop Up Close (X) button functionality")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpCloseButtonFunctionality_Test() {
        craftWorld_03_login_popUp_page.clickOnLoginPopUpCloseButton();
        logger.info("close (X) button was clicked");
        Assert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpLogoPresence(), false);
        logger.info("Logo presence was checked");
    }

    @Test(priority = 4, description = "Validate on Log_in Pop Up eye functionality")
    @Description("Validate on Log_in Pop Up eye functionality")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpEyeButtonFunctionality_Test() {
        SoftAssert softAssert = new SoftAssert();
        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys("123456");
        logger.info("password passed");
        craftWorld_03_login_popUp_page.clickLoginPopUpEyeShowPassword();
        logger.info("Eye icon clicked");
        String typeText = craftWorld_03_login_popUp_page.getPasswordInputTypeAttribute();
        softAssert.assertEquals(typeText, "text");
        logger.info("Passwords visibility was checked");
        craftWorld_03_login_popUp_page.clickLoginPopUpEyeShowPassword();
        logger.info("Eye icon click again");
        String typePassword = craftWorld_03_login_popUp_page.getPasswordInputTypeAttribute();
        softAssert.assertEquals(typePassword, "password");
        logger.info("Passwords visibility was checked");
        softAssert.assertAll();
    }


    @Test(priority = 5, description = "Validate on Log_in Pop Up Remember me label click-ability")
    @Description("Validate on Log_in Pop Up Remember me label click-ability")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpRememberMeLabelClickAbility_Test() {
        SoftAssert softAssert = new SoftAssert();
        craftWorld_03_login_popUp_page.clickLoginPopUpRememberMeLabel();
        logger.info("Remember me label clicked");
        softAssert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpRememberMeCheckboxIsSelected(), true);
        craftWorld_03_login_popUp_page.clickLoginPopUpRememberMeLabel();
        logger.info("Remember me label clicked again");
        softAssert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpRememberMeCheckboxIsSelected(), false);
        softAssert.assertAll();
    }

    @Test(priority = 6, description = "Validate on Log_in Pop Up checkBox functionality")
    @Description("Validate on Log_in Pop checkBox functionality")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpCheckBoxClickAbility_Test() {
        SoftAssert softAssert = new SoftAssert();
        craftWorld_03_login_popUp_page.clickLoginPopUpRememberMeCheckbox();
        logger.info("checkbox clicked");
        softAssert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpRememberMeCheckboxIsSelected(), true);
        craftWorld_03_login_popUp_page.clickLoginPopUpRememberMeCheckbox();
        logger.info("checkbox clicked again");
        softAssert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpRememberMeCheckboxIsSelected(), false);
        softAssert.assertAll();
    }

    @Test(priority = 7, description = "Validate on Log_in Pop Up Forgot password link functionality")
    @Description("Validate on Log_in Pop Up Forgot password link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void loginPopUpForgotPasswordLink_Test() {
        craftWorld_03_login_popUp_page.clickLoginPopUpForgotPassword();
        logger.info("ForgotPassword link clicked");
        String url = craftWorld_03_login_popUp_page.getUrl();
        logger.info("Url captured");
        Assert.assertEquals(url, "https://craftbet.com/forgot-password");

    }


    // facebook, google, Telegram, Instagram ......test
    @Test(priority = 8, description = "Validate on Log_in Pop Up SignUp link functionality")
    @Description("Validate on Log_in Pop Up SignUp link functionality")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpSignUpLink_Test() {
        craftWorld_03_login_popUp_page.clickLoginPopUpSignUpLink();
        logger.info("SignUp link clicked");
        try {
            craftWorld_05_signUp_popUp_page.getTitleQ();
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 10, description = "Validate on Log_in Pop Up Log_In functionality with valid credentials")
    @Description("Validate on Log_in Pop Up Log_In functionality with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void loginPopUpLogInPositiveTest() {
        craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(username);
        logger.info("username passed");
        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys(password);
        logger.info("password passed");
        craftWorld_03_login_popUp_page.clickLoginPopUpLogInButton();
        logger.info("Log In Button was clicked");
        Assert.assertEquals(craftBet_01_header_pageLogInUser.userIdLabelIsEnabled(), true);

    }

    @Test(priority = 9, dataProvider = "invalidLoginData", description = "Validate on Log_in Pop Up Log_In functionality with invalid data")
    @Description("Validate on Log_in Pop Up Log_In functionality with invalid data")
    @Severity(SeverityLevel.BLOCKER)
    public void loginPopUpLogInNegativeTest(String dataUsername, String dataPassword) {

        craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(dataUsername);
        logger.info("username passed -->" + dataUsername + "<--");
        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys(dataPassword);
        logger.info("password passed -->" + dataPassword + "<--");

        try {
            craftWorld_03_login_popUp_page.clickLoginPopUpLogInButton();
            logger.info("Log In Button was clicked");
        } catch (Exception e) {
            logger.info("Log In Button isn't active    " + e);
        }
        if (craftWorld_03_login_popUp_page.loginPopUpErrorMessageGetText().equals("There is no loginPopUpErrorMessage element")){
            craftWorld_03_login_popUp_page.waitAction(500);
            Assert.assertTrue(false, "There is no loginPopUpErrorMessage element");
        }
        else{
            logger.info("Error message is: --> " + craftWorld_03_login_popUp_page.loginPopUpErrorMessageGetText());
            Assert.assertTrue(true, craftWorld_03_login_popUp_page.loginPopUpErrorMessageGetText());
        }
    }

    //    @DataProvider(name = "invalidLoginData")
//    public Object[][] loginData() {
//        Object invalidLoginData[][] = {{"U1630370", "N3 HU3"}, {"U1630370", "N3HU3 "}, {"U1630370", " N3HU3"}, {"U1630370", "     "}, {"U1630370", "?N3HU3"},
//                {"U1630370 ", "N3HU3"}, {"U163 0370", "N3HU3"}, {" U1630370", "N3HU3"}, {"        ", "N3HU3"}, {"?U1630370", "N3HU3"}};
//        return invalidLoginData;
//    }
    @DataProvider(name = "invalidLoginData")
    Object[][] loginDataInvalid() throws IOException {
        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\InvalidData.xlsx";
        FileInputStream file = new FileInputStream(invalidData);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("LoginInvalidData");
        //XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRow = sheet.getLastRowNum();
        int numberOfCol = sheet.getRow(0).getLastCellNum();

        String[][] arr = new String[numberOfRow][numberOfCol];
        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 0; j < numberOfCol; j++) {
                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
                try {
                    double invalidDoubleDataUsername = Double.parseDouble(arr[i - 1][j]);
                    int invalidIntDataUsername = (int) invalidDoubleDataUsername;
                    arr[i - 1][j] = String.valueOf(invalidIntDataUsername);
                } catch (Exception e) {
                    arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0

                }
            }
        }
        file.close();
        return arr;
    }


    @Test(priority = 11, description = "Validate on Log_in Pop Up Error message with invalid password")
    @Description("Validate on Log_in Pop Up error message with invalid password")
    @Severity(SeverityLevel.MINOR)
    public void loginPopUpErrorMessageValidationInvalidUsername() throws InterruptedException {
        craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(username);
        logger.info("username passed");
        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys("1234");
        logger.info("password passed");
        craftWorld_03_login_popUp_page.clickLoginPopUpLogInButton();
        logger.info("log in button was clicked");
        craftWorld_03_login_popUp_page.waitAction(wait);
        Assert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpErrorMessageGetText(), "Username or Password is incorrect. Please try again.");
    }


    @Test(priority = 12, description = "Validate on Log_in Pop Up error message with invalid username")
    @Description("Validate on Log_in Pop Up error message with invalid username")
    @Severity(SeverityLevel.MINOR)
    public void loginPopUpErrorMessageValidationInvalidPassword() throws InterruptedException {
        craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys("1234");
        logger.info("username passed");
        craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys(password);
        logger.info("password passed");
        craftWorld_03_login_popUp_page.clickLoginPopUpLogInButton();
        logger.info("log in button was clicked");
        craftWorld_03_login_popUp_page.waitAction(wait);
        Assert.assertEquals(craftWorld_03_login_popUp_page.loginPopUpErrorMessageGetText(), "Username or Password is incorrect. Please try again.");
    }

}
