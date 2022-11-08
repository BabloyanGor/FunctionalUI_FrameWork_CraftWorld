package testCases;


import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.BasePage;
import utilities.UserSoftAssertion;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;


//@Listeners ({ReportingAllure.class})

public class CraftWorld_00_HeaderTest_UserLogedIn extends BaseTest {
    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 1000;

    //Header Menu First Row


    public CraftWorld_00_HeaderTest_UserLogedIn() throws AWTException {
    }

    @BeforeClass
    public void logIn() {
        craftBet_01_header_pageLogInUser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (firstTime) {
            craftBet_01_header_pageLogInUser.setItem("CraftBet-user", user);
            craftBet_01_header_pageLogInUser.setItem("token", token);
            logger.info("UserName and token was passed");
            craftBet_01_header_pageLogInUser.navigateRefresh();
            logger.info("Page refreshed");
        } else {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            craftWorld_01_header_page_logOutUser.clickOnLogInButtonIfVisible();
            craftWorld_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(username);
            logger.info("username passed");
            craftWorld_03_login_popUp_page.loginPopUpPasswordSendKeys(password);
            logger.info("password passed");
            craftWorld_03_login_popUp_page.clickLoginPopUpLogInButton();
            logger.info("Log In Button was clicked");
            if (craftBet_01_header_pageLogInUser.userIdLabelIsEnabled()) {
                user = craftBet_01_header_pageLogInUser.getItem("CraftBet-user");
                token = craftBet_01_header_pageLogInUser.getItem("token");
                firstTime = true;
            }
        }
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
    }






    @Test(priority = 20, description = "Validate on HeaderMenu2 links Href presence")
    @Description("Validate on HeaderMenu2 links Href presence")
    @Severity(SeverityLevel.BLOCKER)
    public void emptyHref() throws AWTException {
        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
        logger.info("Validate on HeaderMenu2 links Href presence");

        for (int i = 0; i<BasePage.LinkHrefPath.size(); i++){
            String path = BasePage.LinkHrefPath.get(i);
            if (path.isEmpty()){
                userSoftAssertion.fail(BasePage.LinkTitle.get(i) + "  Has no url path");
                logger.info(BasePage.LinkTitle.get(i) + "  Has no url path");
            }
            else {
                userSoftAssertion.assertTrue(true);
                logger.info(BasePage.LinkTitle.get(i) + "  Pass");
            }
        }
        userSoftAssertion.assertAll();
    }



    @Test(priority = 21, description = "Validate on HeaderMenu2 links functionality LoggedIn")
    @Description("Validate on HeaderMenu2 links functionality LoggedIn")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException, AWTException {

        logger.info("Validate on HeaderMenu2 links functionality LoggedIn");
        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
//        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.headerPanel2BottomLinks();

//        System.out.println("captured links size  >>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
//        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkTitle.size());
//        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkStyleType.size());
        logger.info("HeaderMenu2 links Size is  " + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
        for (int k = 0; k < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size(); k++) {
//            for (int k = 0; k < 16; k++) {


//            logger.info(k + "  " + BasePage.LinkTitle.get(k) + "   OpenInRouting  "+BasePage.LinkOpenInRouting.get(k)  + "StyleType  " +BasePage.LinkStyleType.get(k));

            if (BasePage.LinkStyleType.get(k).contains("always") || BasePage.LinkStyleType.get(k).contains("loggedIn") || BasePage.LinkStyleType.get(k).equals("")){

//            logger.info(BasePage.LinkStyleType.get(k));


                if (BasePage.LinkTitle.get(k).equals("Separator") || BasePage.LinkTitle.get(k).equals("Seperator") || BasePage.LinkTitle.get(k).equals("Time")) {
                    logger.info("Separator or Time");
                    if (BasePage.LinkHref.get(k).equals(baseURL) || BasePage.LinkHref.get(k).equals(baseURL+"/")|| BasePage.LinkHref.get(k).equals(baseURL+"/home")){
                        userSoftAssertion.assertTrue(true,"Link Title: " + BasePage.LinkTitle.get(k) + "   Href: " + BasePage.LinkHref.get(k));
                    }
                    else{
                        userSoftAssertion.fail("Link Title: " + BasePage.LinkTitle.get(k) + "   Href: " + BasePage.LinkHref.get(k));
                    }
//                softAssert.assertEquals(BasePage.LinkHref.get(k), baseURL + "/",
//                        "Link Title: " + BasePage.LinkTitle.get(k) + "   Href: " + BasePage.LinkHref.get(k));
            } else {
                try {
                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_pageLogInUser.waitAction(waitTime);


                    if (BasePage.LinkOpenInRouting.get(k).equals("true") || !BasePage.LinkHrefPath.get(k).contains(baseURL)) {
                        logger.info(BasePage.LinkTitle.get(k) + "  This link should open in same tab");

                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());

                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                    } else {
                        logger.info(BasePage.LinkTitle.get(k) + "  This link should open in new tab");

                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.getDriver().close();
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.getDriver().close();
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                    }


                } catch (Exception e1) {
                    try {
                        logger.info(BasePage.LinkTitle.get(k) + "  >>>>>>>>>>>>>>>>   First exception");
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k - 1));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);

                        if (BasePage.LinkOpenInRouting.get(k).equals("true") || !BasePage.LinkHrefPath.contains(baseURL)) {
                            logger.info(BasePage.LinkTitle.get(k) + "  This link should open in same tab");
                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                        } else {
                            logger.info(BasePage.LinkTitle.get(k) + "  This link should open in new tab");
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                        }

                    } catch (Exception e2) {
                        try {
                            logger.info(BasePage.LinkTitle.get(k) + "  >>>>>>>>>>>>>>>>   Second exception");
                            craftBet_01_header_pageLogInUser.hoverOnMore2DropDown();
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);

                            if (BasePage.LinkOpenInRouting.get(k).equals("true") || !BasePage.LinkHrefPath.contains(baseURL)) {
                                logger.info(BasePage.LinkTitle.get(k) + "  This link should open in same tab");
                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                            } else {
                                logger.info(BasePage.LinkTitle.get(k) + "  This link should open in new tab");
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                            }

                        } catch (Exception e3) {
                            userSoftAssertion.fail("We have Exception On Link Title: " + BasePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        }
                    }
                }
            }
        }
        }
        userSoftAssertion.assertAll();
    }




















}






