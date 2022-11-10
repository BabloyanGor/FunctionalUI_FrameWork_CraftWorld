package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CraftWorld_01_Header_Page_LogInUser extends BasePage {
    private final BasePage basePage;

    public CraftWorld_01_Header_Page_LogInUser(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }



    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel1Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy (xpath = "//div[@class='header-section_topPanel flex_between']//li[contains (@class, 'HeaderPanel1Menu')]")
    java.util.List<WebElement> Header1MenuLinks;

    public List<WebElement> HeaderPanel1MenuAllLinks() {
        return Header1MenuLinks;
    }

    @FindBy (xpath = "//div[@class='header-section_topPanel flex_between']//li[contains (@class, 'HeaderPanel1Menu')]//li")
    java.util.List<WebElement> Header1MenuSubLinks;

    public List<WebElement> Header1MenuSubAllLinks() {
        return Header1MenuSubLinks;
    }

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

    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Balance']/div[@class='balance_section']/span[1]")
    @CacheLookup
    WebElement balanceLabel;

    public String getTextBalanceLabel() {
        try{
            basePage.waitElementToBeVisible(balanceLabel);
            return basePage.getText(balanceLabel);
        }
        catch (Exception e){
            return  "Cant find webElement balanceLabel ";
        }
    }

    public boolean balanceLabelIsEnabled() {
        try{
            basePage.waitElementToBeVisible(balanceLabel);
            return basePage.elementIsEnable(balanceLabel);
        }
        catch (Exception e){
            return  false;
        }
    }

    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Balance']/div[@class='balance_section']/span[2]")
    @CacheLookup
    WebElement balance;

    public boolean balanceIsVisible() {
        try{
            return basePage.waitElementToBeVisibleBoolean(balance);
        }
        catch (Exception e){
            return  false;
        }
    }

    public String getTextBalance() {
        try{
            basePage.waitElementToBeVisible(balanceLabel);
            return basePage.getText(balanceLabel);
        }
        catch (Exception e){
            return  "Cant find webElement balanceLabel ";
        }
    }




    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel2Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy (xpath = "//div[@class='header-section_bottomPanel flex_between']//li[not (contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu'))]")
    java.util.List<WebElement> bottomMenuLinks;

    public List<WebElement> bottomMenuAllLinks() {
        return bottomMenuLinks;
    }



   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////































    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel1Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




//    @FindBy(xpath = "//*[@class='user_id']/span[1]")
//    @CacheLookup
//    WebElement UserIdLabel;
//
//    public boolean userIdLabelIsEnabled() {
//        try{
//            basePage.waitElementToBeVisible(UserIdLabel);
//            return basePage.elementIsEnable(UserIdLabel);
//        }
//        catch (Exception e){
//            return  false;
//        }
//    }
//
//    public boolean userIdLabelIsDisplayed() {
//        try{
//            return basePage.elementIsDisplayed(UserIdLabel);
//        }
//        catch (Exception e){
//            return false;
//        }
//    }
//
//    public String getTextUserIdLabel() {
//        try{
//            basePage.waitElementToBeVisible(UserIdLabel);
//            return basePage.getText(UserIdLabel);
//        }
//        catch (Exception e){
//            return  "Cant find webElement UserIdLabel ";
//        }
//    }
//
//    @FindBy(xpath = "//*[@class='user_id']/span[2]")
//    @CacheLookup
//    WebElement UserId;
//
//    public boolean userIdIsEnabled() {
//        try{
//            basePage.waitElementToBeVisible(UserId);
//            return basePage.elementIsEnable(UserId);
//        }
//        catch (Exception e){
//            return  false;
//        }
//    }
//
//    public String getTextUserId() {
//        try{
//            basePage.waitElementToBeVisible(UserId);
//            return basePage.getText(UserId);
//        }
//        catch (Exception e){
//            return  "Cant find webElement UserId ";
//        }
//    }
//
//
//
//
//    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Bonus Balance']/div[@class='balance_section']/span[1]")
//    @CacheLookup
//    WebElement bonusLabel;
//
//    public boolean bonusLabelIsEnabled() {
//        try{
//            basePage.waitElementToBeVisible(bonusLabel);
//            return basePage.elementIsEnable(bonusLabel);
//        }
//        catch (Exception e){
//            return  false;
//        }
//    }
//
//    public String getTextBonusLabel() {
//        try{
//            basePage.waitElementToBeVisible(bonusLabel);
//            return basePage.getText(bonusLabel);
//        }
//        catch (Exception e){
//            return  "Cant find webElement bonusLabel ";
//        }
//    }
//
//    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Bonus Balance']/div[@class='balance_section']/span[2]")
//    @CacheLookup
//    WebElement bonus;
//
//    public boolean bonusIsEnabled() {
//        try{
//            basePage.waitElementToBeVisible(bonus);
//            return basePage.elementIsEnable(bonus);
//        }
//        catch (Exception e){
//            return  false;
//        }
//    }
//
//    public String getTextBonus() {
//        try{
//            basePage.waitElementToBeVisible(bonus);
//            return basePage.getText(bonus);
//        }
//        catch (Exception e){
//            return  "Cant find webElement bonus ";
//        }
//    }
//
//
//    @FindBy(xpath = "//i[@class= 'icon icon-message']")
//    @CacheLookup
//    WebElement messageIcon;
//
//    public void clickOnMessageIconIfVisible() {
//        if(userIdLabelIsEnabled()) {
//            try {
//                basePage.waitElementToBeVisible(messageIcon);
//                basePage.javaScriptClick(messageIcon);
//                basePage.clickOnElementIfClickable(messageIcon);
//                basePage.waitAction(500);
//            } catch (Exception e) {
//            }
//        }
//    }
//
//
//    @FindBy(xpath = "//*[@class = 'dropdown-style1-type-Dpd']")
//    @CacheLookup
//    WebElement languageDropDown;
//    @FindBy(xpath = "//span[text()= 'English']")
//    @CacheLookup
//    WebElement EnglishLanguageDropDown;
//
//    @FindBy(xpath = "//span[text()= 'Русский']")
//    @CacheLookup
//    WebElement RussianLanguageDropDown;
//
//    @FindBy(xpath = "//span[text()= 'Հայերեն']")
//    @CacheLookup
//    WebElement ArmenianLanguageDropDown;
//
//    public void selectEnglishLanguageFromDropDown() {
//        try{
//            clickOnElementIfVisible(languageDropDown);
//            clickOnElementIfVisible(EnglishLanguageDropDown);
//        }
//        catch (Exception e){
//        }
//    }
//    public void selectRussianLanguageFromDropDown() {
//        try{
//            clickOnElementIfVisible(languageDropDown);
//            clickOnElementIfVisible(RussianLanguageDropDown);
//        }
//        catch (Exception e){
//        }
//    }
//    public void selectArmenianLanguageFromDropDown() {
//        try{
//            clickOnElementIfVisible(languageDropDown);
//            clickOnElementIfVisible(ArmenianLanguageDropDown);
//        }
//        catch (Exception e){
//        }
//    }
//
//
//
//
//
//
//    @FindBy(xpath = "//li[@class='button-style3 TEST_HeaderPanel1Menu_Deposit']/div")
//    @CacheLookup
//    WebElement depositButton;
//    public void clickOnDepositButton() {
//        try{
//            basePage.waitElementToBeVisible(depositButton);
//            basePage.waitElementTobeClickable(depositButton);
//            basePage.javaScriptClick(depositButton);
//            basePage.waitAction(200);
//        }
//        catch (Exception e){
//        }
//    }
//
//
//    @FindBy(xpath = "//div[@id='custom_dropdown_style1']")
//    @CacheLookup
//    WebElement customDropDown;
//    public void clickOnCustomDropDown() {
//        try{
//            basePage.waitElementToBeVisible(customDropDown);
//            basePage.javaScriptClick(customDropDown);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Deposit list-section']")
//    @CacheLookup
//    WebElement customDropDownDeposit;
//
//    public void clickOnCustomDropDownDeposit() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownDeposit);
//            basePage.javaScriptClick(customDropDownDeposit);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Withdraw list-section']")
//    @CacheLookup
//    WebElement customDropDownWithdraw;
//    public void clickOnCustomDropDownWithdraw() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownWithdraw);
//            basePage.clickOnElementIfClickable(customDropDownWithdraw);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Bank_Accounts list-section']")
//    @CacheLookup
//    WebElement customDropDownBankAccounts;
//    public void clickOnCustomDropDownBankAccounts() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownBankAccounts);
//            basePage.javaScriptClick(customDropDownBankAccounts);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_My_bets list-section']")
//    @CacheLookup
//    WebElement customDropDownHistory;
//    public void clickOnCustomDropDownHistory() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownHistory);
//            basePage.clickOnElementIfClickable(customDropDownHistory);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Settings list-section']")
//    @CacheLookup
//    WebElement customDropDownSettings;
//    public void clickOnCustomDropDownSettings() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownSettings);
//            basePage.clickOnElementIfClickable(customDropDownSettings);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_My_tickets list-section']")
//    @CacheLookup
//    WebElement customDropDownMyTickets;
//    public void clickOnCustomDropDownMyTickets() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownMyTickets);
//            basePage.clickOnElementIfClickable(customDropDownMyTickets);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='Friends TEST_ACCOUNT_DPD_My list-section']")
//    @CacheLookup
//    WebElement customDropDownMyFriends;
//    public void clickOnCustomDropDownMyFriends() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownMyFriends);
//            basePage.clickOnElementIfClickable(customDropDownMyFriends);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Logout list-section']")
//    @CacheLookup
//    WebElement customDropDownLogOut;
//
//    public void clickOnCustomDropDownLogOut() {
//        try{
//            basePage.waitElementToBeVisible(customDropDownLogOut);
//            basePage.clickOnElementIfClickable(customDropDownLogOut);
//        }
//        catch (Exception e){
//
//        }
//    }
//
//
//
//
//
//

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



    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu')]")
    @CacheLookup
    WebElement more2DropDown;
    public void hoverOnMore2DropDown() {
        if(balanceIsVisible()) {
            try {
                basePage.waitElementToBeVisible(more2DropDown);
                basePage.actionMoveToElement(more2DropDown);
            } catch (Exception e) {
            }
        }
    }

//
//
//
//
//
//
//
//
//
//
//
//
//
//    @FindBy(xpath = "//span[@class='icon-timezone']")
//    @CacheLookup
//    WebElement iconTimeZone;
//    public boolean isVisibleIconTimeZone(){
//        try{
//            basePage.waitElementToBeVisible(iconTimeZone);
//            return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='timezone']/span[2]")
//    @CacheLookup
//    WebElement timeTimeZone;
//    public boolean isVisibleTimeTimeZone(){
//        try{
//            basePage.waitElementToBeVisible(timeTimeZone);
//            return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }
//
//    @FindBy(xpath = "//div[@class='timezone']/span[3]")
//    @CacheLookup
//    WebElement currentTimeTimeZone;
//    public boolean isVisibleCurrentTimeTimeZone(){
//        try{
//            basePage.waitElementToBeVisible(currentTimeTimeZone);
//            return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }




























}



