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
    public API_ConfigJson APIConfigJson;
    public API_MenusJson APIMenusJson;


    public CraftWorld_01_Header_Page_LogInUser craftBet_01_header_pageLogInUser;
    public CraftWorld_01_Header_Page_LogOutUser craftWorld_01_header_page_logOutUser;
    public CraftWorld_03_Login_PopUp_Page craftWorld_03_login_popUp_page;
    public CraftWorld_02_Footer_Page craftWorld_02_footer_page;
    public CraftWorld_04_PasswordRecovery_Page craftWorld_04_passwordRecovery_page;
    public CraftWorld_05_SignUp_PopUp_Page craftWorld_05_signUp_popUp_page;
    public CraftWorld_11_Sports_Page craftWorld_11_sports_page;
    public CraftWorld_12_Life_Page craftWorld_12_life_page;
    public CraftWorld_13_AsianSport_Page craftWorld_13_asianSport_page;
    public CraftWorld_14_VirtualSport_Page craftWorld_14_virtualSport_page;
    public CraftWorld_15_Casino_Page craftWorld_15_casino_page;
    public CraftWorld_16_LifeCasino_Page craftWorld_16_lifeCasino_page;
    public CraftWorld_17_VirtualGames_Page craftWorld_17_virtualGames_page;
    public CraftWorld_18_SkillGames_Page craftWorld_18_skillGames_page;
    public CraftWorld_19_Keno_Page craftWorld_19_keno_page;
    public CraftWorld_20_HighLow_Page craftWorld_20_highLow_page;
    public CraftWorld_21_Crash_Page craftWorld_21_crash_page;
    public CraftWorld_22_Lottery_Page craftWorld_22_lottery_page;
    public CraftWorld_23_Promotions_Page craftWorld_23_promotions_page;
    public CraftWorld_24_News_Page craftWorld_24_news_page;
    public CraftWorld_25_MobileApps_Page craftWorld_25_mobileApps_page;
    public CraftWorld_06_Deposit_Page craftWorld_06_deposit_page;






    //endregion


    public BaseTest() throws AWTException {
    }

    @BeforeClass
    public void setup()  {

        logger = Logger.getLogger("craftBet");
        PropertyConfigurator.configure("Log4j.properties");

        try {
            super.initDriver(baseURL, browser, isHeadless);
            Dimension d = new Dimension(DimensionWidth, DimensionHeight);  //
            if (DimensionWidth > 1250  &&  DimensionHeight > 750){
                driver.manage().window().setSize(d);
                logger.info("Window size is: "+ DimensionWidth + " x " + DimensionHeight);
            }

        } catch (org.openqa.selenium.TimeoutException exception) {
            super.initDriver(baseURL, browser, isHeadless);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //region <Page Class Instance Initialization >
        APIConfigJson = PageFactory.initElements(this.driver, API_ConfigJson.class);
        APIMenusJson= PageFactory.initElements(this.driver, API_MenusJson.class);



        craftBet_01_header_pageLogInUser = PageFactory.initElements(this.driver, CraftWorld_01_Header_Page_LogInUser.class);
        craftWorld_01_header_page_logOutUser = PageFactory.initElements(this.driver, CraftWorld_01_Header_Page_LogOutUser.class);
        craftWorld_02_footer_page = PageFactory.initElements(this.driver, CraftWorld_02_Footer_Page.class);



        craftWorld_03_login_popUp_page = PageFactory.initElements(this.driver, CraftWorld_03_Login_PopUp_Page.class);
        craftWorld_04_passwordRecovery_page = PageFactory.initElements(this.driver, CraftWorld_04_PasswordRecovery_Page.class);
        craftWorld_05_signUp_popUp_page = PageFactory.initElements(this.driver, CraftWorld_05_SignUp_PopUp_Page.class);
        craftWorld_11_sports_page = PageFactory.initElements(this.driver, CraftWorld_11_Sports_Page.class);
        craftWorld_12_life_page = PageFactory.initElements(this.driver, CraftWorld_12_Life_Page.class);
        craftWorld_13_asianSport_page = PageFactory.initElements(this.driver, CraftWorld_13_AsianSport_Page.class);
        craftWorld_14_virtualSport_page = PageFactory.initElements(this.driver, CraftWorld_14_VirtualSport_Page.class);
        craftWorld_15_casino_page = PageFactory.initElements(this.driver, CraftWorld_15_Casino_Page.class);
        craftWorld_16_lifeCasino_page = PageFactory.initElements(this.driver, CraftWorld_16_LifeCasino_Page.class);
        craftWorld_17_virtualGames_page = PageFactory.initElements(this.driver, CraftWorld_17_VirtualGames_Page.class);
        craftWorld_18_skillGames_page = PageFactory.initElements(this.driver, CraftWorld_18_SkillGames_Page.class);
        craftWorld_19_keno_page = PageFactory.initElements(this.driver, CraftWorld_19_Keno_Page.class);
        craftWorld_20_highLow_page = PageFactory.initElements(this.driver, CraftWorld_20_HighLow_Page.class);
        craftWorld_21_crash_page = PageFactory.initElements(this.driver, CraftWorld_21_Crash_Page.class);
        craftWorld_22_lottery_page = PageFactory.initElements(this.driver, CraftWorld_22_Lottery_Page.class);
        craftWorld_23_promotions_page = PageFactory.initElements(this.driver, CraftWorld_23_Promotions_Page.class);
        craftWorld_24_news_page = PageFactory.initElements(this.driver, CraftWorld_24_News_Page.class);
        craftWorld_25_mobileApps_page = PageFactory.initElements(this.driver, CraftWorld_25_MobileApps_Page.class);
        craftWorld_06_deposit_page = PageFactory.initElements(this.driver, CraftWorld_06_Deposit_Page.class);





        logger.info("All Page elements are initialized");
        //endregion

        craftBet_01_header_pageLogInUser.setItem("lang", language);
        craftBet_01_header_pageLogInUser.navigateRefresh();
//        craftBet_header_page.selectEnglishLanguageFromDropDown();
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Test started ");
    }

    @AfterClass
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
