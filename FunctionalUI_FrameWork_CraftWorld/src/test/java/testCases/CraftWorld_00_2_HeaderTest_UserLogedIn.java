package testCases;


import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;


//@Listeners ({ReportingAllure.class})

public class CraftWorld_00_2_HeaderTest_UserLogedIn extends BaseTest {
    BaseTest baseTest = new BaseTest();
    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 500;

    //Header Menu First Row


    public CraftWorld_00_2_HeaderTest_UserLogedIn() throws AWTException {
    }

    @BeforeMethod
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


    @Test(priority = 20, description = "Validate on HeaderMenu2 links functionality")
    @Description("Validate on HeaderMenu2 links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.headerPanel2BottomLinks();

        System.out.println("captured links size  >>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
        System.out.println("links Titles size  >>>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.LinkTitle.size());

        for (int k = 0; k < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size(); k++) {
            logger.info(k + "  " + basePage.LinkTitle.get(k) + "   OpenInRouting  "+craftBet_01_header_pageLogInUser.LinkOpenInRouting.get(k));

            if (basePage.LinkTitle.get(k).equals("Separator") || basePage.LinkTitle.get(k).equals("Seperator") || basePage.LinkTitle.get(k).equals("Time")) {
                softAssert.assertEquals(craftBet_01_header_pageLogInUser.LinkHref.get(k), baseURL + "/",
                        "Link Title: " + basePage.LinkTitle.get(k) + "   Href: " + craftBet_01_header_pageLogInUser.LinkHref.get(k));
            } else {
                try {
                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_pageLogInUser.waitAction(waitTime);


                    if (craftBet_01_header_pageLogInUser.LinkOpenInRouting.get(k).equals("true")) {
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());

                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                    } else {
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.getDriver().close();
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        craftBet_01_header_pageLogInUser.getDriver().close();
                        craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                    }


                } catch (Exception e1) {
                    try {
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k - 1));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);

                        if (craftBet_01_header_pageLogInUser.LinkOpenInRouting.get(k).equals("true")) {
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                    "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                    "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                        } else {
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                    "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                    "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                        }

                    } catch (Exception e2) {
                        try {

                            craftBet_01_header_pageLogInUser.hoverOnMore2DropDown();
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);

                            if (craftBet_01_header_pageLogInUser.LinkOpenInRouting.get(k).equals("true")) {
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                        "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                        "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                            } else {
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                        "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                        "Link Title: " + basePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                            }

                        } catch (Exception e3) {
                            softAssert.fail("We have Exception On Link Title: " + basePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }
}






