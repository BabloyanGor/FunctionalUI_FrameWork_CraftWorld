package testCases;


import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;


//@Listeners ({ReportingAllure.class})

public class CraftBet_00_2_HeaderTest_UserLogedIn extends BaseTest {
    BaseTest baseTest = new BaseTest();
    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 500;
    WebElement link;
    String linksClassName;
    int i;


    //Header Menu First Row
    String urlAfterFirstDoubleClick;

    public CraftBet_00_2_HeaderTest_UserLogedIn() throws AWTException {
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
            craftBet_01_header_page_logOutUser.clickOnLogInButtonIfVisible();
            craftBet_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(username);
            logger.info("username passed");
            craftBet_03_login_popUp_page.loginPopUpPasswordSendKeys(password);
            logger.info("password passed");
            craftBet_03_login_popUp_page.clickLoginPopUpLogInButton();
            logger.info("Log In Button was clicked");
            if (craftBet_01_header_pageLogInUser.userIdLabelIsEnabled()) {
                user = craftBet_01_header_pageLogInUser.getItem("CraftBet-user");
                token = craftBet_01_header_pageLogInUser.getItem("token");
                firstTime = true;
            }
        }
//        craftBet_01_header_pageLogInUser.waitAction(waitTime);
    }

    @Test(priority = 20, description = "Validate on HeaderMenu2 links functionality")
    @Description("Validate on HeaderMenu2 links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();


        craftBet_01_header_pageLogInUser.headerPanel2BottomLinks();
        System.out.println("captured links size  >>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
        System.out.println("links Titles size  >>>>>>>>>>>>>" + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());

        for (int k = 0; k < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size()-1; k++) {
            System.out.println(k + "  "+  basePage.LinkTitle.get(k));


            try {
                if (basePage.LinkTitle.get(k).equals("Separator") || basePage.LinkTitle.get(k).equals("Time")) {
                    System.out.println();
                } else {
                    try {
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(2000);
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    }
                    catch (Exception e0){
                        craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(2000);
                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    }

                }
            } catch (Exception e1) {
                try {
                    craftBet_01_header_pageLogInUser.actionMoveToElement(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k - 1));
                    craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_pageLogInUser.waitAction(2000);

                    softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                            "Link Title: " + basePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                } catch (Exception e2) {
                    try {
                        System.out.println("Title  >>>>>>>" + basePage.LinkTitle.get(k));
                        craftBet_01_header_pageLogInUser.moveToMoreDropDown();
                        craftBet_01_header_pageLogInUser.javaScriptClick(craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(k));
                        craftBet_01_header_pageLogInUser.waitAction(2000);

                        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), craftBet_01_header_pageLogInUser.LinkHref.get(k),
                                "Link Title: " + basePage.LinkTitle.get(k) + "   Url: " + craftBet_01_header_pageLogInUser.getUrl());
                    } catch (Exception e3) {

                        System.out.println();
                    }
                }
            }
        }
        softAssert.assertAll();

    }

    @Test(priority = 10, description = "Validate on Header Logo click functionality")
    @Description("Validate on Header Logo click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void headerLogoClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnSportsLink();
        logger.info("From header Sports link was clicked");
        craftBet_01_header_pageLogInUser.clickOnLogo();
        logger.info("From header logo was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        softAssert.assertAll();
    }

    @Test(priority = 11, description = "Validate on Header UserIDLabel, UserID, BalanceLabel, Balance,BonusLabel, Bonus presence")
    @Description("Validate on Header UserIDLabel, UserID, BalanceLabel, Balance,BonusLabel, Bonus presence")
    @Severity(SeverityLevel.NORMAL)
    public void headerUserIDBalanceBonusPresenceTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.userIdLabelIsEnabled(), true);
        logger.info("UserId label presence wsa checked:  " + craftBet_01_header_pageLogInUser.userIdLabelIsEnabled());
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.userIdIsEnabled(), true);
        logger.info("UserId presence wsa checked:  " + craftBet_01_header_pageLogInUser.userIdIsEnabled());
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.balanceLabelIsEnabled(), true);
        logger.info("Balance label presence wsa checked:  " + craftBet_01_header_pageLogInUser.balanceLabelIsEnabled());
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.balanceIsEnabled(), true);
        logger.info("Balance presence was checked:  " + craftBet_01_header_pageLogInUser.balanceIsEnabled());
//        softAssert.assertEquals(craftBet_01_header_pageLogInUser.bonusLabelIsEnabled(),true);
//        logger.info("Bonus label presence wsa checked:  " + craftBet_01_header_pageLogInUser.bonusLabelIsEnabled());
//        softAssert.assertEquals(craftBet_01_header_pageLogInUser.bonusIsEnabled(),true);
//        logger.info("Bonus presence wsa checked:  " + craftBet_01_header_pageLogInUser.bonusIsEnabled());
        softAssert.assertAll();
    }

    @Test(priority = 12, description = "Validate on Header Message button click functionality")
    @Description("Validate on Header Message button click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void headerMessageButtonClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnMessageIconIfVisible();
        logger.info("From header Message button was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/user/1/tickets");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/user/1/tickets");
        softAssert.assertAll();

    }

    @Test(priority = 13, description = "Validate on Header Deposit button click functionality")
    @Description("Validate on Header Deposit button click functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerDepositButtonClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnDepositButton();
        logger.info("From header Deposit button was clicked");

        try {
            craftBet_06_deposit_page.confirmButtonIsEnabled();
            boolean isUrlContains = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/deposit");
            softAssert.assertTrue(isUrlContains);
        } catch (Exception e) {
            boolean isUrlContains = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/deposit");
            softAssert.assertTrue(isUrlContains);
        }


        craftBet_01_header_pageLogInUser.navigateRefresh();

        try {
            craftBet_06_deposit_page.confirmButtonIsEnabled();
            boolean isUrlContains = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/deposit");
            softAssert.assertTrue(isUrlContains);
        } catch (Exception e) {
            boolean isUrlContains = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/deposit");
            softAssert.assertTrue(isUrlContains);
        }
        softAssert.assertAll();
    }

    @Test(priority = 14, description = "Validate on Header Customer drop down Deposit link functionality ")
    @Description("Validate on Header Customer drop down Deposit link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownDepositLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownDeposit();
        logger.info("From  Customer DropDown Deposit link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(2000);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/deposit");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }

    @Test(priority = 15, description = "Validate on Header Customer drop down Withdraw link functionality ")
    @Description("Validate on Header Customer drop down Withdraw link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownWithdrawLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownWithdraw();
        logger.info("From  Customer DropDown Withdraw link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(2000);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/withdraw");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }

    @Test(priority = 16, description = "Validate on Header Customer drop down Bank Accounts link functionality ")
    @Description("Validate on Header Customer drop down Bank Accounts link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownBankAccountsLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownBankAccounts();
        logger.info("From  Customer DropDown Bank Accounts link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(2000);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/bankAccounts");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }

    @Test(priority = 17, description = "Validate on Header Customer drop down History link functionality ")
    @Description("Validate on Header Customer drop down History link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownHistoryLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownHistory();
        logger.info("From  Customer DropDown History link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/history");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }


    //Header Menu Second Row

    @Test(priority = 18, description = "Validate on Header Customer drop down Settings link functionality ")
    @Description("Validate on Header Customer drop down Settings link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownSettingsLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownSettings();
        logger.info("From  Customer DropDown Settings link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(2000);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/settings");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }

    @Test(priority = 19, description = "Validate on Header Customer drop down MyTickets link functionality ")
    @Description("Validate on Header Customer drop down MyTickets link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownMyTicketsLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownMyTickets();
        logger.info("From  Customer DropDown MyTickets link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        boolean depositPageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/tickets");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(depositPageIsOpened, craftBet_01_header_pageLogInUser.getUrl());

    }

    @Test(priority = 20, description = "Validate on Header Customer drop down MyFriends link functionality ")
    @Description("Validate on Header Customer drop down MyFriends link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownMyFriendsLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownMyFriends();
        logger.info("From  Customer DropDown MyFriends link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        boolean PageIsOpened = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/user/1/friends");
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertTrue(PageIsOpened, craftBet_01_header_pageLogInUser.getUrl());
    }

    @Test(priority = 200, description = "Validate on Header Customer drop down LogOut link functionality ")
    @Description("Validate on Header Customer drop down LogOut link functionality ")
    @Severity(SeverityLevel.BLOCKER)
    public void customerDropDownLogOutLinkFunctionalityTest() {
        craftBet_01_header_pageLogInUser.clickOnCustomDropDown();
        logger.info("From header Customer Icon was clicked");
        craftBet_01_header_pageLogInUser.clickOnCustomDropDownLogOut();
        logger.info("From  Customer DropDown LogOut link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        craftBet_01_header_page_logOutUser.clickOnSignUp();
        logger.info(craftBet_01_header_pageLogInUser.getUrl());
        Assert.assertEquals(craftBet_05_signUp_popUp_page.getTitleQ(), "Step 1");
    }

    @Test(priority = 30, description = "Validate on Header Sports link functionality")
    @Description("Validate on Header Sports link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerSportsLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnSportsLink();
        logger.info("From header Sports link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("Page was refreshed");
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch");
        softAssert.assertAll();
    }

    @Test(priority = 31, description = "Validate on Header Life link functionality")
    @Description("Validate on Header Life link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerLifeLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnLifeLink();
        logger.info("From header Life link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/live");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/live");
        softAssert.assertAll();
    }

    @Test(priority = 32, description = "Validate on Header Asian Sport link functionality")
    @Description("Validate on Header Asian Sport link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerAsianSportLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnAsianSportLink();
        logger.info("From header Asian Sport link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/asianweb");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/asianweb");
        softAssert.assertAll();
    }

    @Test(priority = 33, description = "Validate on Header Virtual Sport link functionality")
    @Description("Validate on Header Virtual Sport link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerVirtualSportLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnVirtualSportLink();
        logger.info("From header Virtual Sport link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/7346");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/7346");
        softAssert.assertAll();
    }

    @Test(priority = 34, description = "Validate on Header Casino link functionality")
    @Description("Validate on Header Casino link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerCasinoLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnCasinoLink();
        logger.info("From header casino link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/casino/all-games");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/casino/all-games");
        softAssert.assertAll();
    }

    @Test(priority = 35, description = "Validate on Header Life Casino link functionality")
    @Description("Validate on Header Life Casino link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerLifeCasinoLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnLifeCasinoLink();
        logger.info("From header Life Casino link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/5");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/5");
        softAssert.assertAll();
    }

    @Test(priority = 36, description = "Validate on Header Virtual Games link functionality")
    @Description("Validate on Header Virtual Games link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerVirtualGamesLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnVirtualGamesLink();
        logger.info("From header Virtual Games link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5");
        softAssert.assertAll();
    }

    @Test(priority = 37, description = "Validate on Header Skill Games link functionality")
    @Description("Validate on Header Skill Games link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerSkillGamesLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnSkillGamesLink();
        logger.info("From header Skill Games link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/7");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/7");
        softAssert.assertAll();
    }

    @Test(priority = 38, description = "Validate on Header Keno Game link functionality")
    @Description("Validate on Header Keno Game link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerKenoGameLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnKenoGameLink();
        logger.info("From header Keno Game link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1004/real/1");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1004/real/1");
        softAssert.assertAll();
    }

    @Test(priority = 39, description = "Validate on Header High Low Game link functionality")
    @Description("Validate on Header High Low Game link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerHighLowGameLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnHighLowGameLink();
        logger.info("From header High Low Game link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1007/real/1");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1007/real/1");
        softAssert.assertAll();
    }

    @Test(priority = 40, description = "Validate on Header Crash Game link functionality")
    @Description("Validate on Header Crash link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerCrashGameLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnCrashGameLink();
        logger.info("From header Crash Game link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1008/real/1");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/product/1008/real/1");
        softAssert.assertAll();
    }

    @Test(priority = 41, description = "Validate on Header Lottery Game link functionality")
    @Description("Validate on Header Lottery link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerLotteryGameLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnLotteryGameLink();
        logger.info("From header Lottery Game link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        boolean urlContains = craftBet_01_header_pageLogInUser.getUrl().contains("https://craftbet.com/product/1009/real");
        softAssert.assertTrue(urlContains, craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertTrue(urlContains, craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


//    @Test(priority = 30, description = "Validate on Header Time zone presence")
//
//    public void LoginWithLocalStorage() {
//        craftBet_header_page.getLocalStorage();
//    }

    @Test(priority = 42, description = "Validate on Header Promotions link functionality")
    @Description("Validate on Header Promotions link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerPromotionsLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnPromotionsLink();
        logger.info("From header Promotions link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/promotions");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/promotions");
        softAssert.assertAll();
    }

    @Test(priority = 43, description = "Validate on Header News link functionality")
    @Description("Validate on Header News link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerNewsLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnNewsLink();
        logger.info("From header News link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        softAssert.assertAll();
    }

    @Test(priority = 44, description = "Validate on Header Mobile Apps link functionality")
    @Description("Validate on Header Mobile Apps link functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMobileAppsLinkFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_pageLogInUser.clickOnMobileApps();
        logger.info("From header Mobile Apps link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/apps");
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/apps");
        softAssert.assertAll();
    }

    @Test(priority = 45, description = "Validate on Header Time zone presence")
    @Description("Validate on Header Time zone presence")
    @Severity(SeverityLevel.NORMAL)
    public void headerTimeZoneVisibilityTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(craftBet_01_header_pageLogInUser.isVisibleIconTimeZone());
        softAssert.assertTrue(craftBet_01_header_pageLogInUser.isVisibleTimeTimeZone());
        softAssert.assertTrue(craftBet_01_header_pageLogInUser.isVisibleCurrentTimeTimeZone());
        softAssert.assertAll();
    }

    @Test(priority = 20, description = "Validate on Header bottom Menu links functionality")
    @Description("Validate on Header Bottom Menu Links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerBottomMenuLinkFunctionalityTest() {
        logger.info("Links size is  " + craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size());
        SoftAssert softAssert = new SoftAssert();

        for (i = 0; i < craftBet_01_header_pageLogInUser.bottomMenuAllLinks().size(); i++) {

            link = craftBet_01_header_pageLogInUser.bottomMenuAllLinks().get(i);
            linksClassName = link.getAttribute("class");

            if (linksClassName.contains("HeaderPanel2Menu_Separator") || linksClassName.contains("header-menu-more") || linksClassName.contains("Time active")) {
                logger.info("More/Separator is running " + linksClassName);
            } else {
                try {
                    craftBet_01_header_pageLogInUser.actionDoubleClick(link);
                } catch (Exception e1) {
                    try {
                        craftBet_01_header_pageLogInUser.hoverOnMore2DropDown();
                        craftBet_01_header_pageLogInUser.waitAction(500);
                        craftBet_01_header_pageLogInUser.actionDoubleClick(link);

                    } catch (Exception e2) {
//                        try {
//                            craftBet_01_header_page_logOutUser.actionMoveToElement(craftBet_01_header_page_logOutUser.bottomMenuAllLinks().get(i - 1));
//                            craftBet_01_header_page_logOutUser.waitAction(500);
//                            craftBet_01_header_page_logOutUser.actionDoubleClick(link);
//                        } catch (Exception e3) {
//                            logger.info("Exception:  " + linksClassName);
//                        }
                    }
                }
                craftBet_01_header_pageLogInUser.waitAction(1000);
                urlAfterFirstDoubleClick = craftBet_01_header_pageLogInUser.getUrl();
                logger.info(i + "  Captured Link After click  " + link.getText() + "  >>>>>>  " + urlAfterFirstDoubleClick);


                if (urlAfterFirstDoubleClick.contains(baseURL + "/sport/prematch")) {                                    //Sport
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Sport onlyMenuItem");

                } else if (urlAfterFirstDoubleClick.contains(baseURL + "/sport/live")) {                                //Life
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_In-Play onlyMenuItem");

                } else if (urlAfterFirstDoubleClick.contains(baseURL + "/asianweb")) {                                   //Asian Sport
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Asian Sport onlyMenuItem");

                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/7346")) {                                //Virtual Sport
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Virtual Sport onlyMenuItem");

                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/7346/60001/real")) {                     //Virtual Sport _ Kiron ----------------------------
                    softAssert.assertTrue(link.getText().contains("Kiron"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/casino/all-games")) {                              //Casino
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Casino onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5")) {                                    //Life Casino
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Live Casino onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/54230/real")) {                         //Life Casino Pragmatic Play ----------------------------
                    softAssert.assertTrue(link.getText().contains("PragmaticPlay"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/21000/real")) {                         //Life Casino Evolution ----------------------------
                    softAssert.assertTrue(link.getText().contains("Evolution"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/5001/real")) {                          //Life Casino Ezugi ----------------------------
                    softAssert.assertTrue(link.getText().contains("Ezugi"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/22001/real?scroll=yes")) {              //Life Casino TVBet ----------------------------
                    softAssert.assertTrue(link.getText().contains("TVBet"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/66470/real")) {                         //Life Casino SAGaming ----------------------------
                    softAssert.assertTrue(link.getText().contains("SAGaming"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/75697/real")) {                         //Life Casino VivoGaming ----------------------------
                    softAssert.assertTrue(link.getText().contains("VivoGaming"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/5/74000/real")) {                         //Life Casino VisionaryiGaming ----------------------------
                    softAssert.assertTrue(link.getText().contains("VisionaryiGaming"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/category/5")) {                                    //Virtual Games
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Virtual Games onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/7")) {                                    //Skill Games
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Skill Games onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.contains(baseURL + "/products/7/1202")) {                             //Skill Games Backgammon ----------------------------
                    softAssert.assertTrue(link.getText().contains("Backgammon"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/7/9001/real")) {                          //Skill Games Poker ----------------------------
                    softAssert.assertTrue(link.getText().contains("Poker"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/products/7/1201/real")) {                          //Skill Games Okey ----------------------------
                    softAssert.assertTrue(link.getText().contains("Okey"),
                            "urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "Text  " + link.getText());
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/product/1004/real/1")) {                           //Keno
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Keno onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/product/1007/real/1")) {                           //High Low
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_High Low onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/product/1008/real/1")) {                           //Crash
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Crash onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.contains(baseURL + "/product/1009/real/1") && !urlAfterFirstDoubleClick.contains("promotions")) { //Lottery
                    softAssert.assertEquals(linksClassName, "general-menu_item dynamic-item header-menu-item-style1 TEST_HeaderPanel2Menu_Lottery new-icon onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.contains(baseURL + "/promotions")) {                                   //Promotions
                    softAssert.assertEquals(linksClassName, "general-menu_item header-menu-item-style1 TEST_HeaderPanel2Menu_Promotions onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/info/privacy")) {                                  //News  --------------------------------
                    softAssert.assertEquals(linksClassName, "general-menu_item header-menu-item-style1 TEST_HeaderPanel2Menu_News onlyMenuItem");
                } else if (urlAfterFirstDoubleClick.equals(baseURL + "/info/apps")) {                                     //MobileApps
                    softAssert.assertEquals(linksClassName, "general-menu_item header-menu-item-style1 TEST_HeaderPanel2Menu_MobileApps onlyMenuItem");
                } else {
                    logger.error("This link is new to us  urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "   ClassAttribute  " + linksClassName);
                    softAssert.assertTrue(false, link.getText() + "   This link is new to us  urlAfterFirstDoubleClick  " + urlAfterFirstDoubleClick + "   ClassAttribute  " + linksClassName);
                }
            }
        }
        softAssert.assertAll();
    }


}






