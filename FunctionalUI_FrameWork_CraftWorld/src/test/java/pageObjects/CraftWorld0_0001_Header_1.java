package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftWorld0_0001_Header_1 extends BasePage{
    private final BasePage basePage;


    public CraftWorld0_0001_Header_1(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);

    }

    @FindBy(xpath = "//img[@class='logo_img']")
    @CacheLookup
    WebElement Header1Logo;

    public void clickOnLogo() {
        try {
            basePage.waitElementToBeVisible(Header1Logo);
            basePage.javaScriptClick(Header1Logo);
        } catch (Exception e) {
            logger.error("clickOnLogo() method has an Exception: " + e);
        }
    }

    public boolean checkHeader1LogoVisibility() {
        try{
            basePage.waitElementToBeVisible(Header1Logo);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }


    @FindBy(xpath = "//button[contains (@class, 'global_login-btn')]")
    @CacheLookup
    WebElement Header1LoginButton;

    public void clickOnHeader1LoginButton() {
        try{
            basePage.waitElementToBeVisible(Header1LoginButton);
            basePage.clickOnElementIfClickable(Header1LoginButton);
        }
        catch(Exception e){
            logger.error("clickOnHeader1LoginButton() method has an Exception: " + e);
        }
    }


    public void clickOnHeader1LoginButtonJs() {
        try{
            javaScriptClick(Header1LoginButton);
        }
        catch (Exception e){
            logger.error("clickOnHeader1LoginButtonJs() method has an Exception: " + e);
        }
    }

    public boolean checkLoginButtonVisibility() {
        try{
            basePage.waitElementToBeVisible(Header1LoginButton);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }



    @FindBy(xpath = "//button[@class = 'button-style1-type-btn global_register-btn']")
    @CacheLookup
    WebElement Header1SignUpButton;

    public void clickOnHeader1SignUpButton() {
        try{
            basePage.waitElementToBeVisible(Header1SignUpButton);
            basePage.clickOnElementIfClickable(Header1SignUpButton);
        }
        catch (Exception e){
            logger.error("clickOnHeader1SignUpButton() method has an Exception: " + e);
        }
    }

    public void clickOnHeader1SignUpButtonJs() {
        try{
            javaScriptClick(Header1SignUpButton);
        }
        catch (Exception e){
            logger.error("clickOnHeader1SignUpButtonJs() method has an Exception: " + e);
        }
    }

    public boolean checkOnHeader1SignUpButtonVisibility() {
        try{
            basePage.waitElementToBeVisible(Header1SignUpButton);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }



    @FindBy(xpath = "//*[@class = 'dropdown-style1-type-Dpd']")
    @CacheLookup
    WebElement Header1languageDropDown;

    public void clickOnHeader1LanguageDropDown() {
        try{
            basePage.waitElementToBeVisible(Header1languageDropDown);
            basePage.clickOnElementIfClickable(Header1languageDropDown);
        }
        catch (Exception e){
            logger.error("clickOnHeader1LanguageDropDown() method has an Exception: " + e);
        }
    }

    public void clickOnHeader1LanguageDropDownJs() {
        try{
            javaScriptClick(Header1languageDropDown);
        }
        catch (Exception e){
            logger.error("clickOnHeader1LanguageDropDownJs() method has an Exception: " + e);
        }
    }

    public boolean checkOnHeader1LanguageDropDownVisibility() {
        try{
            basePage.waitElementToBeVisible(Header1languageDropDown);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }


    @FindBy(xpath = "//span[text()= 'English']")
    @CacheLookup
    WebElement EnglishLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Русский']")
    @CacheLookup
    WebElement RussianLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Հայերեն']")
    @CacheLookup
    WebElement ArmenianLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Español']")
    @CacheLookup
    WebElement SpainLanguageDropDown;

    @FindBy(xpath = "//span[text()= '日本語']")
    @CacheLookup
    WebElement JapanLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'فارسی']")
    @CacheLookup
    WebElement IranLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Français']")
    @CacheLookup
    WebElement FranceLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Italiano']")
    @CacheLookup
    WebElement ItalianLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Português']")
    @CacheLookup
    WebElement PortugalLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Türkçe']")
    @CacheLookup
    WebElement TurkeyLanguageDropDown;





    public void selectEnglishLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(EnglishLanguageDropDown);
        }
        catch (Exception e){
        }
    }
    public void selectRussianLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(RussianLanguageDropDown);
        }
        catch (Exception e){
        }
    }
    public void selectArmenianLanguageFromDropDown() {
        try{
            clickOnElementIfVisible(ArmenianLanguageDropDown);
        }
        catch (Exception e){
        }
    }
















}
