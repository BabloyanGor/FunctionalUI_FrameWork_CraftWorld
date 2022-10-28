package pageObjects;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import testCases.BaseTest;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CraftBet_01_Header_Page_LogOutUser extends BasePage {
    private final BasePage basePage;
    BaseTest baseTest = new BaseTest();
    Logger logger = baseTest.logger;

    public CraftBet_01_Header_Page_LogOutUser(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Top menu <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy(xpath = "//img[@class='logo_img']")
    @CacheLookup
    WebElement logo;

    public void clickOnLogo() {
        try {
            basePage.waitElementToBeVisible(logo);
            basePage.javaScriptClick(logo);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//i[@class= 'icon icon-message']")
    @CacheLookup
    WebElement messageIcon;

    public void clickOnMessageIconIfVisible() {
            try {
                basePage.waitElementToBeVisible(messageIcon);
                basePage.javaScriptClick(messageIcon);
                basePage.clickOnElementIfClickable(messageIcon);
                basePage.waitAction(500);
            } catch (Exception e) {
            }
    }
    @FindBy(xpath = "//*[@class = 'dropdown-style1-type-Dpd']")
    @CacheLookup
    WebElement languageDropDown;
    @FindBy(xpath = "//span[text()= 'English']")
    @CacheLookup
    WebElement EnglishLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Русский']")
    @CacheLookup
    WebElement RussianLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Հայերեն']")
    @CacheLookup
    WebElement ArmenianLanguageDropDown;

    public void selectEnglishLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(languageDropDown);
            clickOnElementIfVisible(EnglishLanguageDropDown);
        }
        catch (Exception e){
        }
    }
    public void selectRussianLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(languageDropDown);
            clickOnElementIfVisible(RussianLanguageDropDown);
        }
        catch (Exception e){
        }
    }
    public void selectArmenianLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(languageDropDown);
            clickOnElementIfVisible(ArmenianLanguageDropDown);
        }
        catch (Exception e){
        }
    }

    @FindBy(xpath = "//button[@class = 'button-style2-type-btn global_login-btn pointer']")
    @CacheLookup
    WebElement logInButton;

    public void clickOnLogInButtonIfVisible() {
        try{
            javaScriptClick(logInButton);
        }
        catch (Exception e){
        }
    }

    public boolean checkLoginButtonVisibility() {
        try{
            basePage.waitElementToBeVisible(logInButton);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

    @FindBy(xpath = "//button[@class = 'button-style1-type-btn global_register-btn']")
    @CacheLookup
    WebElement signUp;

    public void clickOnSignUp() {
        try{
            basePage.waitElementToBeVisible(signUp);
            basePage.clickOnElementIfClickable(signUp);
        }
        catch (Exception e){

        }
    }







    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Bottom menu <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//    @FindAll({@FindBy (xpath = "//div[@class='header-section_bottomPanel flex_between']//li") })
//    List<WebElement> bottomMenuLinks;

    @FindBy (xpath = "//div[@class='header-section_bottomPanel flex_between']//li")
    List<WebElement> bottomMenuLinks;

    public List<WebElement> bottomMenuAllLinks() {
        return bottomMenuLinks;
    }


    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu')]")
    @CacheLookup
    WebElement moreDropDown;
    public void moveToMoreDropDown() {
        try {
            basePage.actionMoveToElement(moreDropDown);
        }
        catch (Exception e) {
        }

    }


    public String urlAfterFirstClick = null;
    public String urlAfterRefresh = null;
    public String urlAfterSecondClick = null;
    int i = 0;
    public void clickOnLinksRefreshClick() throws UnirestException, IOException {
        headerPanel2BottomLinks();
        for (i = 0; i < bottomMenuLinks.size(); i++) {
            try {
                basePage.javaScriptClick(bottomMenuLinks.get(i));
                waitAction(1500);
                urlAfterFirstClick = basePage.getUrl();

                basePage.navigateRefresh();
                waitAction(1500);
                urlAfterRefresh = basePage.getUrl();

                basePage.javaScriptClick(bottomMenuLinks.get(i));
                waitAction(1500);
                urlAfterSecondClick = basePage.getUrl();
            }
            catch (Exception e){
                logger.info("Exception" + e);

            }


        }
    }























































    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Sport')]")
    @CacheLookup
    WebElement sportsLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_In-Play')]")
    @CacheLookup
    WebElement lifeLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Asian')]")
    @CacheLookup
    WebElement asianSportLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Virtual Sport ')]")
    @CacheLookup
    WebElement virtualSportLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu')]")
    @CacheLookup
    WebElement more2DropDown;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Casino ')]")
    @CacheLookup
    WebElement casinoLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Live Casino ')]")
    @CacheLookup
    WebElement lifeCasinoLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Virtual Games')]")
    @CacheLookup
    WebElement virtualGamesLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Skill')]")
    @CacheLookup
    WebElement skillGamesLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Keno ')]")
    @CacheLookup
    WebElement kenoGameLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_High Low')]")
    @CacheLookup
    WebElement highLowGameLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Crash')]")
    @CacheLookup
    WebElement crashGameLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Lottery ')]")
    @CacheLookup
    WebElement lotteryGameLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_Promotions')]")
    @CacheLookup
    WebElement promotionsLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_News ')]")
    @CacheLookup
    WebElement newsLink;
    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_MobileApps')]")
    @CacheLookup
    WebElement mobileAppsLink;

    public boolean clickOnLink(WebElement linkBottomMenu ) {
    boolean skip = false;
        try {
            basePage.javaScriptClick(linkBottomMenu);
        } catch (Exception e) {
            skip = true;
        }
        return skip;
    }





















    public void clickOnSportsLink() {
            try {
                basePage.waitElementToBeVisible(sportsLink);
                basePage.javaScriptClick(sportsLink);
            } catch (Exception e) {
            }
        }



    public void clickOnLifeLink() {

            try {
                basePage.waitElementToBeVisible(lifeLink);
                basePage.javaScriptClick(lifeLink);
            } catch (Exception e) {
            }
        }




    public void clickOnAsianSportLink() {

            try {
                basePage.waitElementToBeVisible(asianSportLink);
                basePage.javaScriptClick(asianSportLink);
            } catch (Exception e) {
            }
        }






//    @FindBy(xpath = "//div[@class='header-section_bottomPanel flex_between']//a[text()='More']")
//    @CacheLookup
//    WebElement moreDropDown;
//    public void clickOnVirtualSportLink() {
//
//            try {
//                basePage.waitElementToBeVisible(virtualSportLink);
//                basePage.javaScriptClick(virtualSportLink);
//            } catch (Exception e) {
//            }
//        }




    public void hoverOnMore2DropDown() {

            try {
                basePage.waitElementToBeVisible(more2DropDown);
                basePage.actionMoveToElement(more2DropDown);
            } catch (Exception e) {
                System.out.println();
            }
        }




    public void clickOnCasinoLink() {

            try {
                basePage.waitElementToBeVisible(casinoLink);
                basePage.javaScriptClick(casinoLink);
            } catch (Exception e) {
//                try {
//                    hoverOnMore2DropDown();
//                    basePage.waitElementToBeVisible(casinoLink);
//                    basePage.javaScriptClick(casinoLink);
//                }
//                catch (Exception e2){
//                }
            }
        }
    public void clickOnLifeCasinoLink() {

            try {
                basePage.waitElementToBeVisible(lifeCasinoLink);
                basePage.javaScriptClick(lifeCasinoLink);
            } catch (Exception e) {
            }
        }
    public void clickOnVirtualGamesLink() {

            try {
                basePage.waitElementToBeVisible(virtualGamesLink);
                basePage.javaScriptClick(virtualGamesLink);
            } catch (Exception e) {
            }
        }
    public void clickOnSkillGamesLink() {

            try {
                basePage.waitElementToBeVisible(skillGamesLink);
                basePage.javaScriptClick(skillGamesLink);
            } catch (Exception e) {
            }
        }
    public void clickOnKenoGameLink() {

            try {
                basePage.waitElementToBeVisible(kenoGameLink);
                basePage.javaScriptClick(kenoGameLink);
            } catch (Exception e) {
            }
        }
    public void clickOnHighLowGameLink() {

            try {
                basePage.waitElementToBeVisible(highLowGameLink);
                basePage.javaScriptClick(highLowGameLink);
            } catch (Exception e) {
            }
        }
    public void clickOnCrashGameLink() {

            try {
                basePage.waitElementToBeVisible(crashGameLink);
                basePage.javaScriptClick(crashGameLink);
            } catch (Exception e) {
            }
        }
    public void clickOnLotteryGameLink() {

            try {
                basePage.waitElementToBeVisible(lotteryGameLink);
                basePage.javaScriptClick(lotteryGameLink);
            } catch (Exception e) {
            }
        }
    public void clickOnPromotionsLink() {

            try {
                basePage.waitElementToBeVisible(promotionsLink);
                basePage.javaScriptClick(promotionsLink);
                basePage.waitAction(500);
            } catch (Exception e) {

            }
        }
    public void clickOnNewsLink() {

            try {
                basePage.waitElementToBeVisible(newsLink);
                basePage.javaScriptClick(newsLink);
            } catch (Exception e) {
            }
        }
    public void clickOnMobileApps() {

            try {
                basePage.waitElementToBeVisible(mobileAppsLink);
                basePage.javaScriptClick(mobileAppsLink);
            } catch (Exception e) {
            }
        }
    public void moveToMoveDropDown(){
        basePage.waitElementToBeVisible(moreDropDown);
        basePage.actionMoveToElementClick(moreDropDown);
    }















    public WebElement getLogo() {
        return logo;
    }

    public WebElement getMessageIcon() {
        return messageIcon;
    }

    public WebElement getLanguageDropDown() {
        return languageDropDown;
    }

    public WebElement getEnglishLanguageDropDown() {
        return EnglishLanguageDropDown;
    }

    public WebElement getRussianLanguageDropDown() {
        return RussianLanguageDropDown;
    }

    public WebElement getArmenianLanguageDropDown() {
        return ArmenianLanguageDropDown;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getSignUp() {
        return signUp;
    }

    public WebElement getSportsLink() {
        return sportsLink;
    }

    public WebElement getLifeLink() {
        return lifeLink;
    }

    public WebElement getAsianSportLink() {
        return asianSportLink;
    }

    public WebElement getVirtualSportLink() {
        return virtualSportLink;
    }

    public WebElement getMore2DropDown() {
        return more2DropDown;
    }

    public WebElement getCasinoLink() {
        return casinoLink;
    }

    public WebElement getLifeCasinoLink() {
        return lifeCasinoLink;
    }

    public WebElement getVirtualGamesLink() {
        return virtualGamesLink;
    }

    public WebElement getSkillGamesLink() {
        return skillGamesLink;
    }

    public WebElement getKenoGameLink() {
        return kenoGameLink;
    }

    public WebElement getHighLowGameLink() {
        return highLowGameLink;
    }

    public WebElement getCrashGameLink() {
        return crashGameLink;
    }

    public WebElement getLotteryGameLink() {
        return lotteryGameLink;
    }

    public WebElement getPromotionsLink() {
        return promotionsLink;
    }

    public WebElement getNewsLink() {
        return newsLink;
    }

    public WebElement getMobileAppsLink() {
        return mobileAppsLink;
    }

    public WebElement getMoreDropDown() {
        return moreDropDown;
    }



}




