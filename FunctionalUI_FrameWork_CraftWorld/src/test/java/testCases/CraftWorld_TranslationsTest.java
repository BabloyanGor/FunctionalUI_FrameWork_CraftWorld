package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePage;

import java.awt.*;
import java.io.IOException;

public class CraftWorld_TranslationsTest extends BaseTest{

    public CraftWorld_TranslationsTest() throws AWTException {
    }

    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 500;

    @BeforeClass
    public void logIn() throws UnirestException, IOException {
        if (firstTime) {
            craftBet_01_header_pageLogInUser.setItem("CraftBet-user", user);
            logger.info("user info passed to Local storage");
            craftBet_01_header_pageLogInUser.setItem("token", token);
            logger.info("user token passed to Local storage");
            craftBet_01_header_pageLogInUser.navigateRefresh();
            logger.info("page was refreshed");
        } else {
            craftWorld_03_login_popUp_page.headerPanel1BottomLinks();
            for (int i = 0; i< BasePage.HeaderPanel1Title.size(); i++){
                String title = BasePage.HeaderPanel1Title.get(i);
                if (title.equals("Login Button")){
                    String type = BasePage.HeaderPanel1Type.get(i);
                    if (type.equals("loginBtn_button")){
                        craftWorld_01_header_page_logOutUser.clickOnHeader1LoginButton();
                    }
                    craftWorld_03_login_popUp_page.sendKeysLoginPopUpEmailInputField(username);
                    craftWorld_03_login_popUp_page.sendKeysLoginPopUpPasswordInputField(password);
                    craftWorld_03_login_popUp_page.clickOnLLoginPopUpLoginButtonOnPopUp();
                }
            }
            logger.info("Log In Button was clicked");
            if (craftBet_01_header_pageLogInUser.balanceIsVisible()) {
                user = craftBet_01_header_pageLogInUser.getItem("CraftBet-user");
                token = craftBet_01_header_pageLogInUser.getItem("token");
                firstTime = true;
            }
        }
//        craftWorld_02_footer_page.footerMenuLinksAPI();
    }



    @Test(priority = 20, description = "Validate on Footer Social Links presence")
    @Description("Validate on Footer Social Links presence")
    @Severity(SeverityLevel.NORMAL)
    public void translationTest() throws UnirestException, IOException {
//        logger.info(craftBet_01_header_pageLogInUser.versionJSCorePlatform());
//        logger.info(craftBet_01_header_pageLogInUser.versionJSSportsBook());
//        craftBet_01_header_pageLogInUser.getLanguages();
        craftBet_01_header_pageLogInUser.catchTranslation(readConfig.getTranslationLanguage());
    }






}
