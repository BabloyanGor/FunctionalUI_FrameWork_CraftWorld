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

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class CraftWorld_00_HeaderTest_UserLogedOut extends BaseTest {

    int waitTime = 3000;

    public CraftWorld_00_HeaderTest_UserLogedOut() throws AWTException {
    }

    @BeforeClass
    public void setUp() {
        craftWorld_01_header_page_logOutUser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }



    @Test(priority = 20, description = "Validate on HeaderMenu2 links functionality LoggedOut")
    @Description("Validate on HeaderMenu2 links functionality LoggedOut")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.headerPanel2BottomLinks();

//        System.out.println("captured links size  >>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
//        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkTitle.size());
//        System.out.println("links Titles size  >>>>>>>>>>>>>" + BasePage.LinkStyleType.size());

        for (int k = 0; k < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size(); k++) {
//            logger.info(k + "  " + BasePage.LinkTitle.get(k) + "   OpenInRouting  "+BasePage.LinkOpenInRouting.get(k)  + "  StyleType  " +BasePage.LinkStyleType.get(k));

            if (BasePage.LinkStyleType.get(k).contains("loggedOut")){


//                logger.info(BasePage.LinkStyleType.get(k));


                if (BasePage.LinkTitle.get(k).equals("Separator") || BasePage.LinkTitle.get(k).equals("Seperator") || BasePage.LinkTitle.get(k).equals("Time")) {
                    softAssert.assertEquals(BasePage.LinkHref.get(k), baseURL + "/",
                            "Link Title: " + BasePage.LinkTitle.get(k) + "   Href: " + BasePage.LinkHref.get(k));
                } else {
                    try {
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(waitTime);


                        if (BasePage.LinkOpenInRouting.get(k).equals("true")) {
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());

                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                        } else {
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                            softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                    "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            craftBet_01_header_pageLogInUser.getDriver().close();
                            craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                        }


                    } catch (Exception e1) {
                        try {
                            craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k - 1));
                            craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                            craftBet_01_header_pageLogInUser.waitAction(waitTime);

                            if (BasePage.LinkOpenInRouting.get(k).equals("true")) {
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                            } else {
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                                craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                        "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                craftBet_01_header_pageLogInUser.getDriver().close();
                                craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                            }

                        } catch (Exception e2) {
                            try {

                                craftBet_01_header_pageLogInUser.hoverOnMore2DropDown();
                                craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                craftBet_01_header_pageLogInUser.waitAction(waitTime);

                                if (BasePage.LinkOpenInRouting.get(k).equals("true")) {
                                    softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                            "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                    craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                    softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                            "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));

                                } else {
                                    craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                    craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                    softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                            "Link Title: " + BasePage.LinkTitle.get(k) + "   After first click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                    craftBet_01_header_pageLogInUser.getDriver().close();
                                    craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);

                                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                                    craftBet_01_header_pageLogInUser.waitAction(waitTime);
                                    craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(1);
                                    softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), BasePage.LinkHref.get(k),
                                            "Link Title: " + BasePage.LinkTitle.get(k) + "   After second click  " + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                                    craftBet_01_header_pageLogInUser.getDriver().close();
                                    craftBet_01_header_pageLogInUser.handleWindowsWithArrayList(0);
                                }

                            } catch (Exception e3) {
                                softAssert.fail("We have Exception On Link Title: " + BasePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                            }
                        }
                    }
                }
            }
        }
        softAssert.assertAll();
    }




















}
