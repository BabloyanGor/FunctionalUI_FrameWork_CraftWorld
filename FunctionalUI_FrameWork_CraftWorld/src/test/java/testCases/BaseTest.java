package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.*;
import utilities.DriverFactory;
import utilities.ReadConfig;

import java.awt.*;
import java.time.Duration;


public class BaseTest extends DriverFactory {

    BasePage basePage = new BasePage();
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getBaseURL();
    public String translationLanguage = readConfig.getTranslationLanguage();
    public String isHeadless = readConfig.isHeadless();
    public String browser = readConfig.getBrowser();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public String language = readConfig.getLanguage();
    public int DimensionHeight = readConfig.getDimensionHeight();
    public int DimensionWidth = readConfig.getDimensionWidth();

    public static Logger logger;


    //region <Page Class Instances  >
    public API_ConfigJson api_configJson;
    public API_MenusJson api_menusJson;


    public CraftWorld_0001_Header_1 craftWorld_0001_header_1;
    public CraftWorld_0001_Header_2 craftWorld_0001_header_2;
    public CraftWorld_0000_Login_PopUp_Page craftWorld_0000_login_popUp_page;
    public CraftWorld_0001_SignUp_PopUp_Page craftWorld_0001_signUp_popUp_page;


//    public CraftWorld_101_Header_Page_LogInUser craftBet_01_header_pageLogInUser;
//    public CraftWorld_101_Header_Page_LogOutUser craftWorld_01_header_page_logOutUser;
//    public CraftWorld_02_Footer_Page craftWorld_02_footer_page;
//    public CraftWorld_04_PasswordRecovery_Page craftWorld_04_passwordRecovery_page;
//    public CraftWorld_11_Sports_Page craftWorld_11_sports_page;
//    public CraftWorld_12_Life_Page craftWorld_12_life_page;
//    public CraftWorld_13_AsianSport_Page craftWorld_13_asianSport_page;
//    public CraftWorld_14_VirtualSport_Page craftWorld_14_virtualSport_page;
//    public CraftWorld_15_Casino_Page craftWorld_15_casino_page;
//    public CraftWorld_16_LifeCasino_Page craftWorld_16_lifeCasino_page;
//    public CraftWorld_17_VirtualGames_Page craftWorld_17_virtualGames_page;
//    public CraftWorld_18_SkillGames_Page craftWorld_18_skillGames_page;
//    public CraftWorld_19_Keno_Page craftWorld_19_keno_page;
//    public CraftWorld_20_HighLow_Page craftWorld_20_highLow_page;
//    public CraftWorld_21_Crash_Page craftWorld_21_crash_page;
//    public CraftWorld_22_Lottery_Page craftWorld_22_lottery_page;
//    public CraftWorld_23_Promotions_Page craftWorld_23_promotions_page;
//    public CraftWorld_24_News_Page craftWorld_24_news_page;
//    public CraftWorld_25_MobileApps_Page craftWorld_25_mobileApps_page;
//    public CraftWorld_06_Deposit_Page craftWorld_06_deposit_page;


    //endregion


    public BaseTest() throws AWTException {
    }

    @BeforeSuite
    public void setupBeforeAll() {
        logger = Logger.getLogger("craftBet");
        PropertyConfigurator.configure("Log4j.properties");

        try {
            super.initDriver(baseURL, browser, isHeadless);
        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(baseURL, browser, isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        api_configJson = PageFactory.initElements(this.driver, API_ConfigJson.class);
        api_menusJson = PageFactory.initElements(this.driver, API_MenusJson.class);
        logger.info("manu.json and config.json Page elements are initialized");

        api_configJson.configJsonApiJsonParse();
        api_menusJson.headerPanel1Menu();
        api_menusJson.headerPanel2Menu();
        api_menusJson.headerGroup1Menu();
        api_menusJson.registration();
        api_menusJson.footerMenu();
        api_menusJson.casinoMenu();
        api_menusJson.newsMenu();
        api_menusJson.accountTabsList();
        api_menusJson.homeMenu();
        api_menusJson.assets();
        api_menusJson.liveCasinoMenu();

        api_menusJson.mobileBottomMenu();
        api_menusJson.mobileFooterMenu();
        api_menusJson.mobileCentralMenu();
        api_menusJson.mobileHomeMenu();
        api_menusJson.mobileHeaderPanel();
        api_menusJson.mobileRightSidebar();
        api_menusJson.mobileMenu();

        try {
            this.driver.quit();
            logger.info("Browser closed");
        } catch (Exception exception) {
            this.driver.quit();
            logger.info("Browser close_order has an exception");
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Test Suite started ");
    }

    @BeforeMethod
    public void setup() {
        try {
            super.initDriver(baseURL, browser, isHeadless);
            Dimension d = new Dimension(DimensionWidth, DimensionHeight);  //
            if (DimensionWidth > 1250 && DimensionHeight > 750) {
                driver.manage().window().setSize(d);
                logger.info("Window size is: " + DimensionWidth + " x " + DimensionHeight);
            }

        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(baseURL, browser, isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //region <Page Class Instance Initialization >
        api_configJson = PageFactory.initElements(this.driver, API_ConfigJson.class);
        api_menusJson = PageFactory.initElements(this.driver, API_MenusJson.class);


        craftWorld_0001_header_1 = PageFactory.initElements(this.driver, CraftWorld_0001_Header_1.class);
        craftWorld_0001_header_2 = PageFactory.initElements(this.driver, CraftWorld_0001_Header_2.class);
        craftWorld_0000_login_popUp_page = PageFactory.initElements(this.driver, CraftWorld_0000_Login_PopUp_Page.class);
        craftWorld_0001_signUp_popUp_page = PageFactory.initElements(this.driver, CraftWorld_0001_SignUp_PopUp_Page.class);


//        craftBet_01_header_pageLogInUser = PageFactory.initElements(this.driver, CraftWorld_101_Header_Page_LogInUser.class);
//        craftWorld_01_header_page_logOutUser = PageFactory.initElements(this.driver, CraftWorld_101_Header_Page_LogOutUser.class);
//        craftWorld_02_footer_page = PageFactory.initElements(this.driver, CraftWorld_02_Footer_Page.class);
//
//
//
//        craftWorld_04_passwordRecovery_page = PageFactory.initElements(this.driver, CraftWorld_04_PasswordRecovery_Page.class);
//        craftWorld_11_sports_page = PageFactory.initElements(this.driver, CraftWorld_11_Sports_Page.class);
//        craftWorld_12_life_page = PageFactory.initElements(this.driver, CraftWorld_12_Life_Page.class);
//        craftWorld_13_asianSport_page = PageFactory.initElements(this.driver, CraftWorld_13_AsianSport_Page.class);
//        craftWorld_14_virtualSport_page = PageFactory.initElements(this.driver, CraftWorld_14_VirtualSport_Page.class);
//        craftWorld_15_casino_page = PageFactory.initElements(this.driver, CraftWorld_15_Casino_Page.class);
//        craftWorld_16_lifeCasino_page = PageFactory.initElements(this.driver, CraftWorld_16_LifeCasino_Page.class);
//        craftWorld_17_virtualGames_page = PageFactory.initElements(this.driver, CraftWorld_17_VirtualGames_Page.class);
//        craftWorld_18_skillGames_page = PageFactory.initElements(this.driver, CraftWorld_18_SkillGames_Page.class);
//        craftWorld_19_keno_page = PageFactory.initElements(this.driver, CraftWorld_19_Keno_Page.class);
//        craftWorld_20_highLow_page = PageFactory.initElements(this.driver, CraftWorld_20_HighLow_Page.class);
//        craftWorld_21_crash_page = PageFactory.initElements(this.driver, CraftWorld_21_Crash_Page.class);
//        craftWorld_22_lottery_page = PageFactory.initElements(this.driver, CraftWorld_22_Lottery_Page.class);
//        craftWorld_23_promotions_page = PageFactory.initElements(this.driver, CraftWorld_23_Promotions_Page.class);
//        craftWorld_24_news_page = PageFactory.initElements(this.driver, CraftWorld_24_News_Page.class);
//        craftWorld_25_mobileApps_page = PageFactory.initElements(this.driver, CraftWorld_25_MobileApps_Page.class);
//        craftWorld_06_deposit_page = PageFactory.initElements(this.driver, CraftWorld_06_Deposit_Page.class);


        logger.info("All Page elements are initialized");
        //endregion

        craftWorld_0001_header_1.setItem("lang", language);
        craftWorld_0001_header_1.navigateRefresh();
//        craftBet_header_page.selectEnglishLanguageFromDropDown();
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Test started ");
    }

    @AfterMethod
    public void tearDown() {
        try {
            this.driver.quit();
            logger.info("Browser closed");
        } catch (Exception exception) {
            this.driver.quit();
            logger.info("Browser close_order has an exception");
        }
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Test finished ");
    }

    @AfterSuite
    public void Finish() {
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Test Suite finished  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
    }


}
