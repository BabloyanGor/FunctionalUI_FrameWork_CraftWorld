package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class CraftBet_00_1_HeaderTest_UserLogedOut extends BaseTest {

    int waitTime = 3000;

    public CraftBet_00_1_HeaderTest_UserLogedOut() throws AWTException {
    }

    @BeforeMethod
    public void logIn() {
        craftBet_01_header_page_logOutUser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @Test(priority = 20, description = "Validate on HeaderMenu2 links functionality")
    @Description("Validate on HeaderMenu2 links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_page_logOutUser.headerPanel2BottomLinks();
        for (int k = 0; k<craftBet_01_header_page_logOutUser.bottomMenuAllLinks().size()-1; k++){
            try{
                if (basePage.LinkTitle.get(k).equals("Separator")){
                }
                else {
                    craftBet_01_header_page_logOutUser.javaScriptClick(craftBet_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_page_logOutUser.waitAction(2000);
                    softAssert.assertEquals(craftBet_01_header_page_logOutUser.getUrl(),craftBet_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftBet_01_header_page_logOutUser.getUrl());
                }
            }
            catch (Exception e1){
                try{
                    craftBet_01_header_page_logOutUser.actionMoveToElement(craftBet_01_header_page_logOutUser.bottomMenuAllLinks().get(k-1));
                    craftBet_01_header_page_logOutUser.javaScriptClick(craftBet_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_page_logOutUser.waitAction(2000);

                    softAssert.assertEquals(craftBet_01_header_page_logOutUser.getUrl(),craftBet_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftBet_01_header_page_logOutUser.getUrl());
                }
                catch(Exception e2){
                    craftBet_01_header_page_logOutUser.moveToMoreDropDown();
                    craftBet_01_header_page_logOutUser.javaScriptClick(craftBet_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftBet_01_header_page_logOutUser.waitAction(2000);

                    softAssert.assertEquals(craftBet_01_header_page_logOutUser.getUrl(),craftBet_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftBet_01_header_page_logOutUser.getUrl());
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
        craftBet_01_header_page_logOutUser.waitAction(1000);
        String homeUrl = craftBet_01_header_page_logOutUser.getUrl();

        craftBet_01_header_page_logOutUser.clickOnSportsLink();
        logger.info("From header Sports link was clicked");
        craftBet_01_header_page_logOutUser.waitAction(waitTime);

        softAssert.assertNotEquals(craftBet_01_header_page_logOutUser.getUrl(), homeUrl,
                "After clicking Sports link  " + craftBet_01_header_page_logOutUser.getUrl());

        craftBet_01_header_page_logOutUser.clickOnLogo();
        logger.info("From header logo was clicked");
        craftBet_01_header_page_logOutUser.waitAction(waitTime);

        softAssert.assertEquals(craftBet_01_header_page_logOutUser.getUrl(), homeUrl,
                "After clicking Logo  " + craftBet_01_header_page_logOutUser.getUrl());

        craftBet_01_header_page_logOutUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_page_logOutUser.waitAction(waitTime);

        softAssert.assertEquals(craftBet_01_header_page_logOutUser.getUrl(), homeUrl,
                "After clicking Logo then Refreshing the page  " + craftBet_01_header_page_logOutUser.getUrl());

        softAssert.assertAll();
    }


    @Test(priority = 20, description = "Validate on Header bottom Menu links functionality")
    @Description("Validate on Header Bottom Menu Links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerBottomMenuLinkFunctionalityTest() {
        for (WebElement link : craftBet_01_header_page_logOutUser.bottomMenuAllLinks()) {
            link.click();
            craftBet_01_header_page_logOutUser.waitAction(2000);
            System.out.println("Captured Link >>>>>>  " + craftBet_01_header_page_logOutUser.getUrl());
        }


    }


    //Header Menu Second Row

    @Test(priority = 30, dataProvider = "links", description = "Validate on Header Sports link functionality")
    @Description("Validate on Header Bottom Menu Links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerSportsLinkFunctionalityTest(String link) {

        String linkLastPart = null;
        WebElement linkSecMenu = null;
        switch (link) {
            case "Sports":
                logger.info("Link Sports");
                linkLastPart = "/sport/prematch";
                linkSecMenu = craftBet_01_header_page_logOutUser.getSportsLink();
                break;

            case "Live":
                logger.info("Link Live");
                linkLastPart = "/sport/live";
                linkSecMenu = craftBet_01_header_page_logOutUser.getLifeLink();
                break;

            case "Asian Sport":
                logger.info("Link Asian Sport");
                linkLastPart = "/asianweb";
                linkSecMenu = craftBet_01_header_page_logOutUser.getAsianSportLink();
                break;

            case "Virtual Sport":
                logger.info("Virtual Sport");
                linkLastPart = "/products/7346";
                linkSecMenu = craftBet_01_header_page_logOutUser.getVirtualSportLink();
                break;

            case "Casino":
                logger.info("Casino");
                linkLastPart = "/casino/all-games";
                linkSecMenu = craftBet_01_header_page_logOutUser.getCasinoLink();
                break;

            case "Life Casino":
                logger.info("Life Casino");
                linkLastPart = "/products/5";
                linkSecMenu = craftBet_01_header_page_logOutUser.getLifeCasinoLink();
                break;

            case "Virtual Games":
                logger.info("Virtual Games");
                linkLastPart = "/category/5";
                linkSecMenu = craftBet_01_header_page_logOutUser.getVirtualGamesLink();
                break;

            case "Skill Games":
                logger.info("Skill Games");
                linkLastPart = "/products/7";
                linkSecMenu = craftBet_01_header_page_logOutUser.getSkillGamesLink();
                break;

        }


        SoftAssert softAssert = new SoftAssert();
        craftBet_01_header_page_logOutUser.waitAction(1000);

        boolean linkMissing = craftBet_01_header_page_logOutUser.clickOnLink(linkSecMenu);
        if (linkMissing) {
            throw new SkipException("Link missing  " + link);
        } else {
            logger.info("From header " + link + " link was clicked");
            craftBet_01_header_page_logOutUser.waitAction(waitTime);

            softAssert.assertTrue(craftBet_01_header_page_logOutUser.getUrl().contains(baseURL + linkLastPart),
                    "After clicking " + link + " link  " + craftBet_01_header_page_logOutUser.getUrl());
            logger.info("After clicking " + link + " link  " + craftBet_01_header_page_logOutUser.getUrl());

            craftBet_01_header_page_logOutUser.clickOnLink(linkSecMenu);
            logger.info("From header " + link + " link was clicked second time");
            craftBet_01_header_page_logOutUser.waitAction(waitTime);

            softAssert.assertFalse(craftBet_01_header_page_logOutUser.getUrl().contains(baseURL + linkLastPart),
                    "After clicking " + link + "link second time  " + craftBet_01_header_page_logOutUser.getUrl());
            logger.info("After clicking " + link + "link second time  " + craftBet_01_header_page_logOutUser.getUrl());

            craftBet_01_header_page_logOutUser.navigateRefresh();
            craftBet_01_header_page_logOutUser.waitAction(waitTime);
            logger.info("Page was refreshed");
            softAssert.assertTrue(craftBet_01_header_page_logOutUser.getUrl().contains(baseURL + linkLastPart),
                    "Refreshing page After clicking " + link + " link second time  " + craftBet_01_header_page_logOutUser.getUrl());
            logger.info("Refreshing page After clicking " + link + " link second time  " + craftBet_01_header_page_logOutUser.getUrl());

            softAssert.assertAll();
        }

    }


    @DataProvider(name = "links")
    Object[][] links() throws IOException {
        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\ValidData.xlsx";
        FileInputStream file = new FileInputStream(invalidData);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Links");
        //XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRow = sheet.getLastRowNum();
        int numberOfCol = sheet.getRow(0).getLastCellNum();

        String[][] arr = new String[numberOfRow][numberOfCol];
        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 0; j < numberOfCol; j++) {
                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
                try {
                    double invalidDoubleData = Double.parseDouble(arr[i - 1][j]);
                    int invalidIntData = (int) invalidDoubleData;
                    //invalidStringData = String.valueOf(invalidIntData);
                    arr[i - 1][j] = String.valueOf(invalidIntData);
                } catch (Exception e) {
                    arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        }
        file.close();
        return arr;
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


//    @Test(priority = 30, description = "Validate on Header Time zone presence")
//
//    public void LoginWithLocalStorage() {
//        craftBet_header_page.getLocalStorage();
//    }

}
