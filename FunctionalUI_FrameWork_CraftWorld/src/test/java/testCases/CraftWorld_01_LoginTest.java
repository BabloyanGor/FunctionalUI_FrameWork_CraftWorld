package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BasePage;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class

CraftWorld_01_LoginTest extends BaseTest {
    int waitTime = 1000;

    public CraftWorld_01_LoginTest() throws AWTException {
    }

    @BeforeMethod
    public void goToLoginPopUp() throws UnirestException, IOException {

        craftWorld_0000_login_popUp_page.headerPanel1BottomLinks();
        craftWorld_0000_login_popUp_page.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }




    @Test(priority = 20, description = "Validate LogIn functionality Positive test")
    @Description("Validate LogIn functionality Positive test")
    @Severity(SeverityLevel.BLOCKER)
    public void loginFunctionalityTest()  {
        for (int i = 0; i< BasePage.HeaderPanel1Title.size(); i++){
            String title = BasePage.HeaderPanel1Title.get(i);

            if (title.equals("Login Button")){
                String type = BasePage.HeaderPanel1Type.get(i);

                if (type.equals("loginBtn_button")){
                    craftWorld_0001_header_1.clickOnHeader1LoginButton();
                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpEmailInputField(username);
                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpPasswordInputField(password);
                    craftWorld_0000_login_popUp_page.clickOnLLoginPopUpLoginButtonOnPopUp();
                    craftWorld_0000_login_popUp_page.waitAction(waitTime);
                    craftWorld_0000_login_popUp_page.navigateRefresh();
                    Assert.assertTrue(craftWorld_0001_header_1.balanceIsVisible());

                } else if (type.equals("loginScn_section")) {
                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpEmailInputField(username);
                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpPasswordInputField(password);
                    craftWorld_0000_login_popUp_page.clickOnLLoginPopUpLoginButtonOnPopUp();
                    craftWorld_0000_login_popUp_page.waitAction(waitTime);
                    craftWorld_0000_login_popUp_page.navigateRefresh();
                    Assert.assertTrue(craftWorld_0001_header_1.balanceIsVisible());
                }
                else {
                    Assert.fail("Unknown Login button style");
                }
            }
        }
    }











}
