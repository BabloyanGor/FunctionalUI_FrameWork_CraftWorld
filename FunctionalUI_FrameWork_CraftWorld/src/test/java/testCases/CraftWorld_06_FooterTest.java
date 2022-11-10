package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePage;
import utilities.UserSoftAssertion;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

import static pageObjects.BasePage.menuSubFooterOpenInRouting;

public class CraftWorld_06_FooterTest extends BaseTest {
    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 500;

    public CraftWorld_06_FooterTest() throws AWTException {
    }

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
        craftWorld_02_footer_page.footerMenuLinksAPI();
    }




    @Test(priority = 20, description = "Validate on Footer Social Links presence")
    @Description("Validate on Footer Social Links presence")
    @Severity(SeverityLevel.NORMAL)
    public void footerSocialLinksPresenceTest() {
        SoftAssert softAssert = new SoftAssert();
        logger.info("Social footer size is  " + BasePage.socialFooterTitle.size());
        for (int i = 0; i < BasePage.socialFooterHref.size(); i++) {
            if (BasePage.socialFooterHref.get(i).equals("")) {
                softAssert.fail(BasePage.socialFooterTitle.get(i) + "  Has no url path");
                logger.info("Footer Link  " + BasePage.socialFooterTitle.get(i) + "  Has no url path");

            } else {
                softAssert.assertTrue(true);
            }
        }
        softAssert.assertAll();
    }


    @Test(priority = 21, description = "Validate on Footer Social Links Icons presence")
    @Description("Validate on Footer Social Links Icons presence")
    @Severity(SeverityLevel.NORMAL)
    public void footerSocialLinksIconsPresenceTest()  {

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < BasePage.socialFooterIcon.size(); i++) {

            if (BasePage.socialFooterType.get(i).equals("3")) {
                if (BasePage.socialFooterIcon.get(i).equals("")) {
                    softAssert.fail(BasePage.socialFooterTitle.get(i) + "  Has no Icon");
                } else {
                    softAssert.assertTrue(true);
                }
            }

        }
        softAssert.assertAll();
    }








    @Test(priority = 22, description = "Validate on Footer Menu Links presence")
    @Description("Validate on Footer Menu Links presence")
    @Severity(SeverityLevel.NORMAL)
    public void footerMenusLinksPresenceTest() {

        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < BasePage.menuSubFooterPath.size(); i++) {

            if (BasePage.menuSubFooterPath.get(i).equals("")) {
                softAssert.fail(BasePage.manuSubFooterTitle.get(i) + "  Has no url path");
            } else {
                softAssert.assertTrue(true);
            }
        }
        softAssert.assertAll();
    }


    @Test(priority = 23, description = "Validate on Footer Menu Titles Links API response StatusCod check")
    @Description("Validate on Footer Menu Titles Links API response StatusCod check")
    @Severity(SeverityLevel.NORMAL)
    public void footerMenusLinksTitlesAPICheckTest() throws AWTException {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < BasePage.menuFooterHref.size(); i++) {

            if (BasePage.checkConnectionUrlResponseCod(BasePage.menuFooterHref.get(i))) {
                softAssert.assertTrue(true);
            } else {
                softAssert.fail(BasePage.manuSubFooterTitle.get(i) + "  Has no valid Status cod ");
            }
        }
        softAssert.assertAll();
    }



    @Test(priority = 24, description = "Validate on Footer Menu Links API response StatusCod check")
    @Description("Validate on Footer Menu Links API response StatusCod check")
    @Severity(SeverityLevel.NORMAL)
    public void footerMenusLinksAPICheckTest() throws AWTException {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < BasePage.menuSubFooterHref.size(); i++) {

            if (BasePage.checkConnectionUrlResponseCod(BasePage.menuSubFooterHref.get(i))) {
                softAssert.assertTrue(true);
            } else {
                softAssert.fail(BasePage.manuSubFooterTitle.get(i) + "  Has no valid Status cod ");
            }
        }
        softAssert.assertAll();
    }





    @Test(priority = 25, description = "Validate on Footer Menu Title Links Real paths")
    @Description("Validate on Footer Menu Title Links Real paths")
    @Severity(SeverityLevel.NORMAL)
    public void footerMenusTitlesLinksRealPathTest() throws AWTException {
       // SoftAssert softAssert = new SoftAssert();
        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
        for (int i = 0; i < craftWorld_02_footer_page.footerTitlesLinks().size(); i++) {

            if (craftWorld_02_footer_page.openFooterButtonIsDisplayed() && !craftWorld_02_footer_page.footerIsOpen()) {
                craftWorld_02_footer_page.clickOnOpenFooterLink();
            }

            if (!BasePage.menuFooterPath.get(i).equals("")) {

                logger.info("Title: " + BasePage.menuFooterTitle.get(i) + "  Href: " + BasePage.menuFooterHref.get(i));
                try {
                    WebElement footerTitleLink = craftWorld_02_footer_page.footerTitlesLinks().get(i);
                    craftWorld_02_footer_page.waitAction(waitTime);
//                craftWorld_02_footer_page.scrollPageDown();
                    craftWorld_02_footer_page.actionMoveToElement(footerTitleLink);
                    craftWorld_02_footer_page.waitAction(waitTime);
                    craftWorld_02_footer_page.javaScriptClick(footerTitleLink);
                    craftWorld_02_footer_page.waitAction(waitTime);


                    if (BasePage.menuFooterPath.get(i).contains("https://")|| BasePage.menuFooterOpenInRouting.get(i).equals("false")) {

                        craftWorld_02_footer_page.handleWindowsWithArrayList(1);
                        craftWorld_02_footer_page.waitAction(waitTime);
                        userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuFooterHref.get(i),
                                "Link Title: " + BasePage.menuFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftWorld_02_footer_page.getDriver().close();
                        craftWorld_02_footer_page.handleWindowsWithArrayList(0);

                    } else {
                        userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuFooterHref.get(i),
                                "Link Title: " + BasePage.menuFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    }


                } catch (Exception e) {
                    try {
                        if (craftWorld_02_footer_page.openFooterButtonIsDisplayed() && !craftWorld_02_footer_page.footerIsOpen()){
                            craftWorld_02_footer_page.clickOnOpenFooterLink();
                        }
                        WebElement footerTitleLink = craftWorld_02_footer_page.footerTitlesLinks().get(i);
                        craftWorld_02_footer_page.waitAction(waitTime);
//                craftWorld_02_footer_page.scrollPageDown();
                        craftWorld_02_footer_page.actionMoveToElement(footerTitleLink);
                        craftWorld_02_footer_page.waitAction(waitTime);
                        craftWorld_02_footer_page.javaScriptClick(footerTitleLink);
                        craftWorld_02_footer_page.waitAction(waitTime);

                        if (BasePage.menuFooterPath.get(i).contains("https://")|| BasePage.menuFooterOpenInRouting.get(i).equals("false")) {

                            craftWorld_02_footer_page.handleWindowsWithArrayList(1);
                            craftWorld_02_footer_page.waitAction(waitTime);
                            userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuFooterHref.get(i),
                                    "Link Title: " + BasePage.menuFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftWorld_02_footer_page.getDriver().close();
                            craftWorld_02_footer_page.handleWindowsWithArrayList(0);

                        } else {
                            userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuFooterHref.get(i),
                                    "Link Title: " + BasePage.menuFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        }

                    }
                    catch (Exception e1){
                        userSoftAssertion.fail(BasePage.menuFooterTitle.get(i) + "  Has an exception");
                    }

            }
            }

            userSoftAssertion.assertAll();
        }
    }


    @Test(priority = 26, description = "Validate on Footer Menu Links Real paths")
    @Description("Validate on Footer Menu Links Real paths")
    @Severity(SeverityLevel.NORMAL)
    public void footerMenusLinksRealPathTest() throws AWTException {
        //SoftAssert softAssert = new SoftAssert();
        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
        for (int i = 0; i < craftWorld_02_footer_page.footerMenuLinks().size(); i++) {
            try {
                if (craftWorld_02_footer_page.openFooterButtonIsDisplayed() && !craftWorld_02_footer_page.footerIsOpen()){
                    craftWorld_02_footer_page.clickOnOpenFooterLink();
                }
                WebElement footerLink = craftWorld_02_footer_page.footerMenuLinks().get(i);
                craftWorld_02_footer_page.waitAction(waitTime);
//                craftWorld_02_footer_page.scrollPageDown();
                craftWorld_02_footer_page.actionMoveToElement(footerLink);
                craftWorld_02_footer_page.waitAction(waitTime);
                craftWorld_02_footer_page.javaScriptClick(footerLink);
                craftWorld_02_footer_page.waitAction(waitTime);

                if (BasePage.menuSubFooterPath.get(i).contains("https://")||menuSubFooterOpenInRouting.get(i).equals("false")) {

                    craftWorld_02_footer_page.handleWindowsWithArrayList(1);
                    craftWorld_02_footer_page.waitAction(waitTime);
                    userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuSubFooterHref.get(i),
                            "Link Title: " + BasePage.manuSubFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    craftWorld_02_footer_page.getDriver().close();
                    craftWorld_02_footer_page.handleWindowsWithArrayList(0);

                } else {
                    userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuSubFooterHref.get(i),
                            "Link Title: " + BasePage.manuSubFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                }


            } catch (Exception e) {
                try {
                    if (craftWorld_02_footer_page.openFooterButtonIsDisplayed() && !craftWorld_02_footer_page.footerIsOpen()){
                        craftWorld_02_footer_page.clickOnOpenFooterLink();
                    }
                    WebElement footerLink = craftWorld_02_footer_page.footerMenuLinks().get(i);
                    craftWorld_02_footer_page.waitAction(waitTime);
                    craftWorld_02_footer_page.scrollPageDown();
                    craftWorld_02_footer_page.actionMoveToElement(footerLink);
                    craftWorld_02_footer_page.waitAction(waitTime);
                    craftWorld_02_footer_page.clickOnElementIfClickable(footerLink);
                    craftWorld_02_footer_page.waitAction(waitTime);

                    if (BasePage.menuSubFooterPath.get(i).contains("https://")||menuSubFooterOpenInRouting.get(i).equals("false")) {

                        craftWorld_02_footer_page.handleWindowsWithArrayList(1);
                        craftWorld_02_footer_page.waitAction(waitTime);
                        userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuSubFooterHref.get(i),
                                "Link Title: " + BasePage.manuSubFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftWorld_02_footer_page.getDriver().close();
                        craftWorld_02_footer_page.handleWindowsWithArrayList(0);

                    } else {
                        userSoftAssertion.assertEquals(craftWorld_02_footer_page.getUrl(), BasePage.menuSubFooterHref.get(i),
                                "Link Title: " + BasePage.manuSubFooterTitle.get(i) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    }

                }
                catch (Exception e1){
                    userSoftAssertion.fail(BasePage.manuSubFooterTitle.get(i) + "  Has an exception");
                }
            }
        }
        userSoftAssertion.assertAll();
    }
















}
