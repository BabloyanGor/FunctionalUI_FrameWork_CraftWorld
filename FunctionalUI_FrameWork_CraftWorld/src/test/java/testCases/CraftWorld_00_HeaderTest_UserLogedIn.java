package testCases;


import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.BeforeClass;
import pageObjects.BasePage;

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
    public void logIn() throws UnirestException, IOException {
        craftWorld_0001_header_1.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (firstTime) {
            craftWorld_0001_header_1.setItem("CraftBet-user", user);
            craftWorld_0001_header_1.setItem("token", token);
            logger.info("UserName and token was passed");
            craftWorld_0001_header_1.navigateRefresh();
            logger.info("Page refreshed");
        } else {

            craftWorld_0001_header_1.headerPanel1BottomLinks();
            for (int i = 0; i< BasePage.HeaderPanel1Title.size(); i++){
                String title = BasePage.HeaderPanel1Title.get(i);

                if (title.equals("Login Button")){
                    String type = BasePage.HeaderPanel1Type.get(i);
                    if (type.equals("loginBtn_button")){
                        craftWorld_0001_header_1.clickOnHeader1LoginButton();
                    }
//                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpEmailInputField(username);
//                    craftWorld_0000_login_popUp_page.sendKeysLoginPopUpPasswordInputField(password);
//                    craftWorld_0000_login_popUp_page.clickOnLLoginPopUpLoginButtonOnPopUp();
                }
            }
            logger.info("Log In Button was clicked");
            if (craftWorld_0001_header_1.balanceIsVisible()) {
                user = craftWorld_0001_header_1.getItem("CraftBet-user");
                token = craftWorld_0001_header_1.getItem("token");
                firstTime = true;
            }
        }
        craftWorld_0001_header_1.waitAction(waitTime);
    }






//    @Test(priority = 20, description = "Validate on HeaderPanel2 links Href presence")
//    @Description("Validate on HeaderPanel2 links Href presence")
//    @Severity(SeverityLevel.BLOCKER)
//    public void emptyHref() throws AWTException {
//        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
//        logger.info("Validate on HeaderMenu2 links Href presence");
//
//        for (int i = 0; i<BasePage.LinkHrefPathHeaderPanel2.size(); i++){
//            String path = BasePage.LinkHrefPathHeaderPanel2.get(i);
//            if (path.isEmpty()){
//                userSoftAssertion.fail(BasePage.LinkTitleHeaderPanel2.get(i) + "  Has no url path");
//                logger.info(BasePage.LinkTitleHeaderPanel2.get(i) + "  Has no url path");
//            }
//            else {
//                userSoftAssertion.assertTrue(true);
//                logger.info(BasePage.LinkTitleHeaderPanel2.get(i) + "  Pass");
//            }
//        }
//        userSoftAssertion.assertAll();
//    }
//
//
//
//    @Test(priority = 21, description = "Validate on HeaderPanel2 links functionality LoggedIn")
//    @Description("Validate on HeaderPanel2 links functionality LoggedIn")
//    @Severity(SeverityLevel.BLOCKER)
//    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException, AWTException {
//
//        logger.info("Validate on HeaderPanel2 links functionality LoggedIn");
//        UserSoftAssertion userSoftAssertion = new UserSoftAssertion();
////        SoftAssert softAssert = new SoftAssert();
//        craftWorld_0001_header_1.headerPanel2BottomLinks();
//
////        System.out.println("captured links size  >>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
////        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkTitle.size());
////        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkStyleType.size());
//        logger.info("HeaderMenu2 links Size is  " + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
//        for (int k = 0; k < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size(); k++) {
////            for (int k = 0; k < 16; k++) {
//
//
////            logger.info(k + "  " + BasePage.LinkTitle.get(k) + "   OpenInRouting  "+BasePage.LinkOpenInRouting.get(k)  + "StyleType  " +BasePage.LinkStyleType.get(k));
//
//            if (BasePage.LinkStyleTypeHeaderPanel2.get(k).contains("always") || BasePage.LinkStyleTypeHeaderPanel2.get(k).contains("loggedIn") || BasePage.LinkStyleTypeHeaderPanel2.get(k).equals("")){
//
////            logger.info(BasePage.LinkStyleType.get(k));
//
//
//                if (BasePage.LinkTitleHeaderPanel2.get(k).equals("Separator") || BasePage.LinkTitleHeaderPanel2.get(k).equals("Seperator") || BasePage.LinkTitleHeaderPanel2.get(k).equals("Time")) {
//                    logger.info("Separator or Time");
//                    if (BasePage.LinkHrefHeaderPanel2.get(k).equals(baseURL) || BasePage.LinkHrefHeaderPanel2.get(k).equals(baseURL+"/")|| BasePage.LinkHrefHeaderPanel2.get(k).equals(baseURL+"/home")){
//                        userSoftAssertion.assertTrue(true,"Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   Href: " + BasePage.LinkHrefHeaderPanel2.get(k));
//                    }
//                    else{
//                        userSoftAssertion.fail("Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   Href: " + BasePage.LinkHrefHeaderPanel2.get(k));
//                    }
////                softAssert.assertEquals(BasePage.LinkHref.get(k), baseURL + "/",
////                        "Link Title: " + BasePage.LinkTitle.get(k) + "   Href: " + BasePage.LinkHref.get(k));
//            } else {
//                try {
//                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                    craftBet_01_header_pageLogInUser.waitAction(waitTime);
//
//
//                    if (BasePage.LinkOpenInRoutingHeaderPanel2.get(k).equals("true") || !BasePage.LinkHrefPathHeaderPanel2.get(k).contains(baseURL)) {
//                        logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in same tab");
//
//                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//
//                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//
//                    } else {
//                        logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in new tab");
//
//                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                        craftBet_01_header_pageLogInUser.getDriver().close();
//                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//
//                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                        userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                        craftBet_01_header_pageLogInUser.getDriver().close();
//                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//                    }
//
//
//                } catch (Exception e1) {
//                    try {
//                        logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  >>>>>>>>>>>>>>>>   First exception");
//                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k - 1));
//                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
//
//                        if (BasePage.LinkOpenInRoutingHeaderPanel2.get(k).equals("true") || !BasePage.LinkHrefPathHeaderPanel2.contains(baseURL)) {
//                            logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in same tab");
//                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                    "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                    "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//
//                        } else {
//                            logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in new tab");
//                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                    "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                            craftBet_01_header_pageLogInUser.getDriver().close();
//                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//
//                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                            userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                    "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                            craftBet_01_header_pageLogInUser.getDriver().close();
//                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//                        }
//
//                    } catch (Exception e2) {
//                        try {
//                            logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  >>>>>>>>>>>>>>>>   Second exception");
//                            craftBet_01_header_pageLogInUser.hoverOnMore2DropDown();
//                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
//
//                            if (BasePage.LinkOpenInRoutingHeaderPanel2.get(k).equals("true") || !BasePage.LinkHrefPathHeaderPanel2.contains(baseURL)) {
//                                logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in same tab");
//                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                        "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                        "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//
//                            } else {
//                                logger.info(BasePage.LinkTitleHeaderPanel2.get(k) + "  This link should open in new tab");
//                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                        "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                                craftBet_01_header_pageLogInUser.getDriver().close();
//                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//
//                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
//                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
//                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
//                                userSoftAssertion.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHrefHeaderPanel2.get(k),
//                                        "Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                                craftBet_01_header_pageLogInUser.getDriver().close();
//                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
//                            }
//
//                        } catch (Exception e3) {
//                            userSoftAssertion.fail("We have Exception On Link Title: " + BasePage.LinkTitleHeaderPanel2.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
//                        }
//                    }
//                }
//            }
//        }
//        }
//        userSoftAssertion.assertAll();
//    }
//
//
//
//
//
//
//
}






