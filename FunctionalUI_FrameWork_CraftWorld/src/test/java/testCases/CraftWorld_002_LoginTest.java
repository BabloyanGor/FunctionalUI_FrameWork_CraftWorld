package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.API_MenusJson;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class

CraftWorld_002_LoginTest extends BaseTest {
    public CraftWorld_002_LoginTest() throws AWTException {
    }


    int waitTime = 1000;
    int isLoginHasPopUp = 0;   // 1-PopUp , 2-InPage, 0-UnknownType

    @BeforeMethod
    public void goToLoginPopUp() throws UnirestException, IOException {
//        api_menusJson.headerPanel1Menu();
        if (API_MenusJson.loginPageType.equals("loginBtn_button")) {
            isLoginHasPopUp = 1;
        } else if (API_MenusJson.loginPageType.equals("loginScn_section")) {
            isLoginHasPopUp = 2;
        } else {
            logger.error("Login button has unknown Type");
        }

        craftWorld_0000_login_popUp_page.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test(priority = 20, description = "Validate LogIn functionality Positive test")
    @Description("Validate LogIn functionality Positive test")
    @Severity(SeverityLevel.BLOCKER)
    public void loginFunctionalityPositiveTest() {

        if (isLoginHasPopUp == 1) {                                                       //Check login page have PopUp or Not
            craftWorld_0001_header_1.clickOnHeader1LoginButton();
            craftWorld_0000_login_popUp_page.sendKeysLoginEmailInputField(username);
            craftWorld_0000_login_popUp_page.sendKeysLoginPasswordInputField(password);
            craftWorld_0000_login_popUp_page.clickOnLLoginButton();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            craftWorld_0000_login_popUp_page.navigateRefresh();
            Assert.assertTrue(craftWorld_0001_header_1.balanceIsVisible(),
                    "Username: [" + username + "] Password: [" + password + "]");

        } else if (isLoginHasPopUp == 2) {
            craftWorld_0000_login_popUp_page.sendKeysLoginEmailInputField(username);
            craftWorld_0000_login_popUp_page.sendKeysLoginPasswordInputField(password);
            craftWorld_0000_login_popUp_page.clickOnLLoginButton();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            craftWorld_0000_login_popUp_page.navigateRefresh();
            Assert.assertTrue(craftWorld_0001_header_1.balanceIsVisible(),
                    "Username: [" + username + "] Password: [" + password + "]");
        } else {
            Assert.fail("Unknown Login button style" + API_MenusJson.loginPageType);
        }
    }


    @Test(dataProvider = "invalidLoginData", priority = 21, description = "Validate LogIn functionality Negative test")
    @Description("Validate LogIn functionality Negative test")
    @Severity(SeverityLevel.BLOCKER)
    public void loginFunctionalityNegativeTest(String invalidUsername, String invalidPassword) {

        if (isLoginHasPopUp == 1) {                                                      //Check login page have PopUp or Not
            craftWorld_0001_header_1.clickOnHeader1LoginButton();
            craftWorld_0000_login_popUp_page.sendKeysLoginEmailInputField(invalidUsername);
            craftWorld_0000_login_popUp_page.sendKeysLoginPasswordInputField(invalidPassword);
            craftWorld_0000_login_popUp_page.clickOnLLoginButton();
            craftWorld_0000_login_popUp_page.waitAction(2500);
            Assert.assertTrue(craftWorld_0000_login_popUp_page.LoginErrorMessageTextIsNotEmpty(),
                    "Error Message: " + craftWorld_0000_login_popUp_page.loginErrorMessageGetText());

        } else if (isLoginHasPopUp == 2) {
            craftWorld_0000_login_popUp_page.sendKeysLoginEmailInputField(invalidUsername);
            craftWorld_0000_login_popUp_page.sendKeysLoginPasswordInputField(invalidPassword);
            craftWorld_0000_login_popUp_page.clickOnLLoginButton();
            craftWorld_0000_login_popUp_page.waitAction(2500);
            Assert.assertTrue(craftWorld_0000_login_popUp_page.LoginErrorMessageTextIsNotEmpty(),
                    "Error Message: " + craftWorld_0000_login_popUp_page.loginErrorMessageGetText());
        } else {
            Assert.fail("Unknown Login button style");
        }
        craftWorld_0000_login_popUp_page.waitAction(5000);
    }


    @DataProvider(name = "invalidLoginData")
    Object[][] invalidLoginData() {
        String[][] arr = {{username + "a", password}, {username, password + "a"}, {"1", "1"}, {username, password + "   "}, {username, "   " + password}};
        return arr;
    }


    @Test(priority = 22, description = "Validate forgot password link functionality")
    @Description("Validate forgot password link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void ForgotPasswordLinkTest() {

        if (isLoginHasPopUp == 1) {
            craftWorld_0001_header_1.clickOnHeader1LoginButton();
            craftWorld_0000_login_popUp_page.clickLoginForgotPasswordLink();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            String url = craftWorld_0000_login_popUp_page.getUrl();
            Assert.assertEquals(url, baseURL + "/forgot-password",
                    "Forgot Password Url: " + url);

        } else if (isLoginHasPopUp == 2) {
            craftWorld_0000_login_popUp_page.clickLoginForgotPasswordLink();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            String url = craftWorld_0000_login_popUp_page.getUrl();
            Assert.assertEquals(url, baseURL + "/forgot-password",
                    "Forgot Password Url: " + url);
        } else {
            Assert.fail("Unknown Login button style" + API_MenusJson.loginPageType);
        }
    }


    @Test(priority = 24, description = "Validate eye icon (if exist) functionality ")
    @Description("Validate eye icon (if exist) functionality ")
    @Severity(SeverityLevel.NORMAL)
    public void eyeIconFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        if (isLoginHasPopUp == 1) {
            craftWorld_0001_header_1.clickOnHeader1LoginButton();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            if (craftWorld_0000_login_popUp_page.checkLoginEyeButtonVisibility()) {
                String passwordTypeAttributeBeforeEyeClick = craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput();
                softAssert.assertEquals(passwordTypeAttributeBeforeEyeClick, "password",
                        "Password input type attribute is: " + craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput());
                craftWorld_0000_login_popUp_page.clickLoginEyeShowPassword();
                craftWorld_0000_login_popUp_page.waitAction(waitTime);
                String passwordTypeAttributeAfterEyeClick = craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput();
                softAssert.assertEquals(passwordTypeAttributeAfterEyeClick, "text",
                        "Password input type attribute is: " + craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput());
            } else {
                softAssert.assertTrue(true);
            }

        } else if (isLoginHasPopUp == 2) {
            if (craftWorld_0000_login_popUp_page.checkLoginEyeButtonVisibility()) {
                String passwordTypeAttributeBeforeEyeClick = craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput();
                softAssert.assertEquals(passwordTypeAttributeBeforeEyeClick, "password",
                        "Password input type attribute is: " + craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput());
                craftWorld_0000_login_popUp_page.clickLoginEyeShowPassword();
                craftWorld_0000_login_popUp_page.waitAction(waitTime);
                String passwordTypeAttributeAfterEyeClick = craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput();
                softAssert.assertEquals(passwordTypeAttributeAfterEyeClick, "text",
                        "Password input type attribute is: " + craftWorld_0000_login_popUp_page.getAttributeTypePasswordInput());
            } else {
                softAssert.assertTrue(true);
            }
        } else {
            Assert.fail("Unknown Login button style" + API_MenusJson.loginPageType);
        }

        softAssert.assertAll();
    }


    @Test(priority = 25, description = "Validate In LogIn PopUp page SignUp link functionality")
    @Description("Validate In LogIn PopUp page SignUp link functionality")
    @Severity(SeverityLevel.NORMAL)
    public void loginPopUpSignUpLinkTest() {
        if (isLoginHasPopUp == 1) {
            craftWorld_0001_header_1.clickOnHeader1LoginButton();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            craftWorld_0000_login_popUp_page.clickLoginPopUpSignUpLink();
            craftWorld_0000_login_popUp_page.waitAction(waitTime);
            boolean regFormIsVisible = craftWorld_0001_signUp_popUp_page.registrationPopUpFormPresence();

            Assert.assertTrue(regFormIsVisible,"After clicking SignUp link on Login PopUp Registration form isn't visible");

        } else if (isLoginHasPopUp == 2) {
               Assert.assertTrue(true);
        } else {
            Assert.fail("Unknown Login button style" + API_MenusJson.loginPageType);
        }
    }









}


//    @DataProvider(name = "invalidLoginData")
//    Object[][] invalidLoginData() throws IOException {
//        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\InvalidData.xlsx";
//        FileInputStream file = new FileInputStream(invalidData);
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheet("SignUpQuickInvalidEmail");
//        //XSSFSheet sheet = workbook.getSheetAt(0);
//        int numberOfRow = sheet.getLastRowNum();
//        int numberOfCol = sheet.getRow(0).getLastCellNum();
//
//        String[][] arr = new String[numberOfRow][numberOfCol];
//        for (int i = 1; i <= numberOfRow; i++) {
//            for (int j = 0; j < numberOfCol; j++) {
//                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
//            }
//        }
//        file.close();
//        return arr;
//    }