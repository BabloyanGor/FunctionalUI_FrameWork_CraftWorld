package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;

public class CraftBet_06_FooterTest extends BaseTest{
    boolean firstTime = false;
    String user ;
    String token;
    int waitTime = 10;

    public CraftBet_06_FooterTest() throws AWTException {
    }

    @BeforeMethod
    public void logIn(){
        if (firstTime){
            craftBet_01_header_pageLogInUser.setItem("CraftBet-user",user);
            logger.info("user info passed to Local storage");
            craftBet_01_header_pageLogInUser.setItem("token",token);
            logger.info("user token passed to Local storage");
            craftBet_01_header_pageLogInUser.navigateRefresh();
            logger.info("page was refreshed");
        }
        else{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            craftBet_01_header_page_logOutUser.clickOnLogInButtonIfVisible();
            craftBet_03_login_popUp_page.loginPopUpEmailOrUsernameSendKeys(username);
            logger.info("username passed");
            craftBet_03_login_popUp_page.loginPopUpPasswordSendKeys(password);
            logger.info("password passed");
            craftBet_03_login_popUp_page.clickLoginPopUpLogInButton();
            logger.info("Log In Button was clicked");
            if (craftBet_01_header_pageLogInUser.userIdLabelIsEnabled()){
                user = craftBet_01_header_pageLogInUser.getItem("CraftBet-user");
                token = craftBet_01_header_pageLogInUser.getItem("token");
                firstTime=true;
            }

        }
    }






    //region <The first Footer column <<Legal>> >


    @Test(priority = 10, description = "Validate on Footer LEGAL Link click functionality")
    @Description("Validate on Footer LEGAL Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerLEGALLinkClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnLegalLinkIfVisible();
        logger.info("From footer LEGAL link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/legal");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/legal");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 11, description = "Validate on Footer TERMS AND CONDITIONS Link click functionality")
    @Description("Validate on Footer TERMS AND CONDITIONS Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerTERMSANDCONDITIONSLinkClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnTermsConditionsLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer TERMS AND CONDITIONS link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/terms");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/terms");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 12, description = "Validate on Footer RESPONSIBLE GAMING Link click functionality")
    @Description("Validate on Footer RESPONSIBLE GAMING Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerRESPONSIBLEGAMINGLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnResponseGamingLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer ResponsibleGame link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/faq");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/faq");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 13, description = "Validate on Footer SELF EXCLUSION Link click functionality")
    @Description("Validate on Footer SELF EXCLUSION Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerSELFEXCLUSIONLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnSelfExclusionLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer SELF EXCLUSION link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/self");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/self");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 14, description = "Validate on Footer DISPUTE RESOLUTION Link click functionality")
    @Description("Validate on Footer DISPUTE RESOLUTION Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerDISPUTERESOLUTIONLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnResolutionLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer DISPUTE RESOLUTION link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/dispute");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/dispute");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 15, description = "Validate on Footer AML Link click functionality")
    @Description("Validate on Footer AML Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerAMLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnLegalAMLLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer AML link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/aml");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/aml");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 16, description = "Validate on Footer FAIR GAMING AND RNG Link click functionality")
    @Description("Validate on Footer FAIR GAMING AND RNG Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerFAIRGAMINGANDRNGLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnFairGamingAMGLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer FAIR GAMING AND RNG link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/fairgaming");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/fairgaming");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 17, description = "Validate on Footer PRIVACY POLICY Link click functionality")
    @Description("Validate on Footer PRIVACY POLICY Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerPRIVACYPOLICYLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnPrivacyPolicyLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer PRIVACY POLICY link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/privacy");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/privacy");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 18, description = "Validate on Footer ACCOUNT, PAYOUTS, BONUSES Link click functionality")
    @Description("Validate on Footer ACCOUNT, PAYOUTS, BONUSES Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerACCOUNTPAYOUTSBONUSESLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnAccountPayOutsBonusesLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer ACCOUNT, PAYOUTS, BONUSES link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/aboutus");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/aboutus");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 19, description = "Validate on Footer KYC POLICIES Link click functionality")
    @Description("Validate on FooterKYC POLICIES Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerKYCPOLICIESLinkClickFunctionalityTest1() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnKYSPoliciesLinkLinkIfVisible();
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        logger.info("From footer KYC POLICIES link was clicked");
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/kyc");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/kyc");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }

    //endregion



    //region <The Second Footer column <<SPORTSBOOK>> >


    @Test(priority = 40, description = "Validate on Footer SPORTSBOOK Link click functionality")
    @Description("Validate on Footer SPORTSBOOK Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerSPORTSBOOKClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnSportsBookLinkIfVisible();
        logger.info("From footer SPORTSBOOK link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/sportsbook");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/sportsbook");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 41, description = "Validate on Footer PREMIER LEAGUE Link click functionality")
    @Description("Validate on Footer PREMIER LEAGUE Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerPREMIERLEAGUEClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnPremierLinkIfVisible();
        logger.info("From footer PREMIER LEAGUE link was clicked");
        craftBet_02_footer_page.handleWindowsWithArrayList(1);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10186");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10186");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 42, description = "Validate on Footer LIGUE 1 Link click functionality")
    @Description("Validate on Footer LIGUE 1 Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerLIGUE1ClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnLigueOneLinkIfVisible();
        logger.info("From footer LIGUE 1 link was clicked");
        craftBet_02_footer_page.handleWindowsWithArrayList(1);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=9312");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=9312");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 43, description = "Validate on Footer BUNDESLIGA Link click functionality")
    @Description("Validate on Footer BUNDESLIGA Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerBUNDESLIGAClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnBundesligaLinkIfVisible();
        logger.info("From footer BUNDESLIGA link was clicked");
        craftBet_02_footer_page.handleWindowsWithArrayList(1);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=15577");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=15577");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 44, description = "Validate on Footer SERIE A Link click functionality")
    @Description("Validate on Footer SERIE A Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerSERIEAClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnSerieALinkIfVisible();
        logger.info("From footer SERIE A link was clicked");
        craftBet_02_footer_page.handleWindowsWithArrayList(1);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=11270");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=11270");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 45, description = "Validate on Footer CHAMPIONS LEAGUE Link click functionality")
    @Description("Validate on Footer CHAMPIONS LEAGUE Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerCHAMPIONSLEAGUEClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnChampionsLinkIfVisible();
        logger.info("From footer CHAMPIONS LEAGUE link was clicked");
        craftBet_02_footer_page.handleWindowsWithArrayList(1);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10055");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/sport/prematch#/prematch/competitions?sport=1&competitions=10055");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    //endregion


    //region <The Third Footer column <<CASINO & LIVE CASINO>> >


    @Test(priority = 60, description = "Validate on Footer CASINO & LIVE CASINO Link click functionality")
    @Description("Validate on Footer CASINO & LIVE CASINO Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerCASINOLIVECASINOClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnCasinoLifeCasinoLinkIfVisible();
        logger.info("From footer CASINO & LIVE CASINO link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/casinoandlivecasino");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/casinoandlivecasino");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 61, description = "Validate on Footer EVOLUTION Link click functionality")
    @Description("Validate on Footer EVOLUTION Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerEVOLUTIONClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnEvolutionLinkIfVisible();
        logger.info("From footer EVOLUTION link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/products/5/21000/real");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/5/21000/real");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 62, description = "Validate on Footer EZUGI Link click functionality")
    @Description("Validate on Footer EZUGI Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerEZUGIClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnEzugiLinkIfVisible();
        logger.info("From footer EZUGI link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/products/5/5001/real");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/products/5/5001/real");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 63, description = "Validate on Footer TOM HORN Link click functionality")
    @Description("Validate on Footer TOM HORN Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerTOMHORNClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnCasinoTomHornLinkIfVisible();
        logger.info("From footer TOM HORN link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/home");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 63, description = "Validate on Footer ZEYS PLAY Link click functionality")
    @Description("Validate on Footer ZEYS PLAY Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerZEYSPLAYClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnCasinoZeysLinkLinkIfVisible();
        logger.info("From footer ZEYS PLAY link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/home");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertNotEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/home");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    //endregion


    //region <The Forth Footer column <<Virtual Games>> >

    @Test(priority = 80, description = "Validate on Footer Virtual Games Link click functionality")
    @Description("Validate on Footer Virtual Games Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerVirtualGamesClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnVirtualGamesLinkIfVisible();
        logger.info("From footer Virtual Games link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/info/virtualgames");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/info/virtualgames");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 81, description = "Validate on Footer BINGO 37 Link click functionality")
    @Description("Validate on Footer BINGO 37 Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerBINGO37ClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnBingo37LinkIfVisible();
        logger.info("From footer BINGO 37 link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1001/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1001/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 82, description = "Validate on Footer KENO Link click functionality")
    @Description("Validate on Footer KENO Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerKENOClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnKenoLinkIfVisible();
        logger.info("From footer KENO link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1004/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1004/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }



    @Test(priority = 83, description = "Validate on Footer CRASH Link click functionality")
    @Description("Validate on Footer CRASH Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerCRASHClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnCrashLinkIfVisible();
        logger.info("From footer CRASH link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1008/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1008/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 84, description = "Validate on Footer HIGH LOW Link click functionality")
    @Description("Validate on Footer HIGH LOW Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerHIGHLOWClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnHighLowLinkIfVisible();
        logger.info("From footer HIGH LOW link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1007/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1007/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 85, description = "Validate on Footer BET ON RACING Link click functionality")
    @Description("Validate on Footer BET ON RACING Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerBETONRACINGClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnBetOnRacingLinkIfVisible();
        logger.info("From footer BET ON RACING link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1006/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1006/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 86, description = "Validate on Footer BET ON POKER Link click functionality")
    @Description("Validate on Footer BET ON POKER Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerBETONPOKERClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnBetOnPokerLinkIfVisible();
        logger.info("From footer BET ON POKER link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1005/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1005/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 87, description = "Validate on Footer BINGO 47 Link click functionality")
    @Description("Validate on Footer BINGO 47 Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerBINGO47ClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnBingo47LinkIfVisible();
        logger.info("From footer BINGO 47 link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1003/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1003/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }


    @Test(priority = 88, description = "Validate on Footer COLORS Link click functionality")
    @Description("Validate on Footer COLORS Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerCOLORSClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnColorsLinkIfVisible();
        logger.info("From footer COLORS link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1002/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1002/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }



    @Test(priority = 89, description = "Validate on Footer MINESWEEPER Link click functionality")
    @Description("Validate on Footer MINESWEEPER Link click functionality")
    @Severity(SeverityLevel.NORMAL)
    public void footerMINESWEEPERClickFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        craftBet_02_footer_page.clickOnMinesweeperLinkIfVisible();
        logger.info("From footer MINESWEEPER link was clicked");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_02_footer_page.getUrl(), "https://craftbet.com/category/5/1010/real/1");
        logger.info("URL was checked: "+ craftBet_01_header_pageLogInUser.getUrl());
        craftBet_01_header_pageLogInUser.navigateRefresh();
        logger.info("Page was refreshed");
        craftBet_01_header_pageLogInUser.waitAction(waitTime);
        softAssert.assertEquals(craftBet_01_header_pageLogInUser.getUrl(), "https://craftbet.com/category/5/1010/real/1");
        logger.info("URL was double checked:  " + craftBet_01_header_pageLogInUser.getUrl());
        softAssert.assertAll();
    }
    //endregion



}
