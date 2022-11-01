package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import testCases.BaseTest;

import java.awt.*;
import java.util.List;

public class CraftWorld_01_Header_Page_LogOutUser extends BasePage {
    private final BasePage basePage;
    BaseTest baseTest = new BaseTest();
    Logger logger = baseTest.logger;

    public CraftWorld_01_Header_Page_LogOutUser(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    //    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel1Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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







    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel2Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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













}




