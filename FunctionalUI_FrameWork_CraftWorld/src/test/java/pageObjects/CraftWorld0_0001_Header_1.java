package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CraftWorld0_0001_Header_1 extends BasePage {
    private final BasePage basePage;


    public CraftWorld0_0001_Header_1(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel1Elements  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy(xpath = "//div[@class='header-section_topPanel flex_between']//li[contains (@class, 'HeaderPanel1Menu')]")
    List<WebElement> Header1AllLinks;

    public List<WebElement> getHeaderPanel1MenuAllLinks() {
        try{
            return Header1AllLinks;
        }
        catch(Exception e){
            logger.error("getHeaderPanel1MenuAllLinks() method has an Exception: " + e);
        }
        return null;
    }

    public void clickOnHeader1Link(WebElement header1Link) {
        try {
            basePage.waitElementToBeVisible(header1Link);
            basePage.javaScriptClick(header1Link);
        } catch (Exception e) {
            logger.error(" clickOnHeader1Link(WebElement header1Link) method has an Exception: " + e);
        }
    }
    @FindBy(xpath = "//div[@class='header-section_topPanel flex_between']//li[contains (@class, 'HeaderPanel1Menu')]//li")
    List<WebElement> Header1MenuSubLinks;

    public List<WebElement> getHeader1MenuSubAllLinks() {
        try{
            return Header1MenuSubLinks;
        }
        catch(Exception e){
            logger.error("getHeader1MenuSubAllLinks() method has an Exception: " + e);
        }
        return null;

    }
    public void clickOnHeader1SubLink(WebElement header1SubLink) {
        try {
            basePage.waitElementToBeVisible(header1SubLink);
            basePage.javaScriptClick(header1SubLink);
        } catch (Exception e) {
            logger.error("clickOnHeader1SubLink(WebElement header1SubLink) method has an Exception: " + e);
        }
    }



    @FindBy(xpath = "//div[@id='custom_dropdown_style1']//li")
    List<WebElement> customDropDownElements;

    public List<WebElement> getHeaderPanel1CustomDropDownAllLinks() {
        try{
            return customDropDownElements;
        }
        catch(Exception e){
            logger.error("getHeaderPanel1CustomDropDownAllLinks() method has an Exception: " + e);
        }
        return null;

    }
    public void clickOnCustomDropDownJS(WebElement element) {
        try {
            basePage.waitElementToBeVisible(element);
            basePage.javaScriptClick(element);
        } catch (Exception e) {
            logger.error("clickOnCustomDropDownJS(WebElement element) method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='lang_grid']//li")
    List<WebElement> Header1Languages;

    public List<WebElement> getHeaderPanel1Languages() {
        try{
            return Header1Languages;
        }
        catch(Exception e){
            logger.error("getHeaderPanel1Languages() method has an Exception: " + e);
        }
        return null;

    }
    public void clickOnHeader1LanguagesJS(WebElement language) {
        try {
            basePage.waitElementToBeVisible(language);
            basePage.javaScriptClick(language);
        } catch (Exception e) {
            logger.error("clickOnHeader1LanguagesJS(WebElement language) method has an Exception: " + e);
        }
    }
    public void clickLanguageFromDropDown(WebElement language) {
        try {
            clickOnElementIfVisible(language);
        } catch (Exception e) {
            logger.error("clickLanguageFromDropDown(WebElement language) method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//img[@class='logo_img']")
    @CacheLookup
    WebElement Header1Logo;

    public void clickOnHeader1Logo() {
        try {
            basePage.waitElementToBeVisible(Header1Logo);
            basePage.javaScriptClick(Header1Logo);
        } catch (Exception e) {
            logger.error("clickOnHeader1Logo() method has an Exception: " + e);
        }
    }

    public boolean checkHeader1LogoVisibility() {
        try {
            basePage.waitElementToBeVisible(Header1Logo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @FindBy(xpath = "//button[contains (@class, 'global_login-btn')]")
    @CacheLookup
    WebElement Header1LoginButton;

    public void clickOnHeader1LoginButton() {
        try {
            basePage.waitElementToBeVisible(Header1LoginButton);
            basePage.clickOnElementIfClickable(Header1LoginButton);
        } catch (Exception e) {
            logger.error("clickOnHeader1LoginButton() method has an Exception: " + e);
        }
    }


    public void clickOnHeader1LoginButtonJs() {
        try {
            javaScriptClick(Header1LoginButton);
        } catch (Exception e) {
            logger.error("clickOnHeader1LoginButtonJs() method has an Exception: " + e);
        }
    }

    public boolean checkLoginButtonVisibility() {
        try {
            basePage.waitElementToBeVisible(Header1LoginButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @FindBy(xpath = "//button[@class = 'button-style1-type-btn global_register-btn']")
    @CacheLookup
    WebElement Header1SignUpButton;

    public void clickOnHeader1SignUpButton() {
        try {
            basePage.waitElementToBeVisible(Header1SignUpButton);
            basePage.clickOnElementIfClickable(Header1SignUpButton);
        } catch (Exception e) {
            logger.error("clickOnHeader1SignUpButton() method has an Exception: " + e);
        }
    }

    public void clickOnHeader1SignUpButtonJs() {
        try {
            javaScriptClick(Header1SignUpButton);
        } catch (Exception e) {
            logger.error("clickOnHeader1SignUpButtonJs() method has an Exception: " + e);
        }
    }

    public boolean checkOnHeader1SignUpButtonVisibility() {
        try {
            basePage.waitElementToBeVisible(Header1SignUpButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @FindBy(xpath = "//*[@class = 'dropdown-style1-type-Dpd']")
    @CacheLookup
    WebElement Header1languageDropDown;

    public void clickOnHeader1LanguageDropDown() {
        try {
            basePage.waitElementToBeVisible(Header1languageDropDown);
            basePage.clickOnElementIfClickable(Header1languageDropDown);
        } catch (Exception e) {
            logger.error("clickOnHeader1LanguageDropDown() method has an Exception: " + e);
        }
    }

    public void clickOnHeader1LanguageDropDownJs() {
        try {
            javaScriptClick(Header1languageDropDown);
        } catch (Exception e) {
            logger.error("clickOnHeader1LanguageDropDownJs() method has an Exception: " + e);
        }
    }

    public boolean checkOnHeader1LanguageDropDownVisibility() {
        try {
            basePage.waitElementToBeVisible(Header1languageDropDown);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @FindBy(xpath = "//span[text()= 'English']")
    @CacheLookup
    public WebElement EnglishLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Русский']")
    @CacheLookup
    public WebElement RussianLanguageDropDown;
    @FindBy(xpath = "//span[text()= 'Հայերեն']")
    @CacheLookup
    public WebElement ArmenianLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Español']")
    @CacheLookup
    public WebElement SpainLanguageDropDown;

    @FindBy(xpath = "//span[text()= '日本語']")
    @CacheLookup
    public WebElement JapanLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'فارسی']")
    @CacheLookup
    public WebElement IranLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Français']")
    @CacheLookup
    public WebElement FranceLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Italiano']")
    @CacheLookup
    public WebElement ItalianLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Português']")
    @CacheLookup
    public WebElement PortugalLanguageDropDown;

    @FindBy(xpath = "//span[text()= 'Türkçe']")
    @CacheLookup
    public WebElement TurkeyLanguageDropDown;




    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Balance']/div[@class='balance_section']/span[1]")
    @CacheLookup
    WebElement balanceLabel;

    public String getTextBalanceLabel() {
        try {
            basePage.waitElementToBeVisible(balanceLabel);
            return basePage.getText(balanceLabel);
        } catch (Exception e) {
            logger.error("getTextBalanceLabel() method has an Exception: " + e);
            return "Cant find webElement balanceLabel ";
        }
    }

    public boolean balanceLabelIsEnabled() {
        try {
            basePage.waitElementToBeVisible(balanceLabel);
            return basePage.elementIsEnable(balanceLabel);
        } catch (Exception e) {
            return false;
        }
    }


    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Balance']/div[@class='balance_section']/span[2]")
    @CacheLookup
    WebElement balance;

    public boolean balanceIsVisible() {
        try {
            return basePage.waitElementToBeVisibleBoolean(balance);
        } catch (Exception e) {
            return false;
        }
    }

    public String getBalance() {
        try {
            basePage.waitElementToBeVisible(balance);
            return basePage.getText(balance);
        } catch (Exception e) {
            logger.error("getBalance() method has an Exception: " + e);
            return "Cant find webElement balance";
        }
    }


    @FindBy(xpath = "//*[@class='user_id']/span[1]")
    @CacheLookup
    WebElement UserIdLabel;

    public boolean userIdLabelIsEnabled() {
        try {
            basePage.waitElementToBeVisible(UserIdLabel);
            return basePage.elementIsEnable(UserIdLabel);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean userIdLabelIsDisplayed() {
        try {
            return basePage.elementIsDisplayed(UserIdLabel);
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextUserIdLabel() {
        try {
            basePage.waitElementToBeVisible(UserIdLabel);
            return basePage.getText(UserIdLabel);
        } catch (Exception e) {
            logger.error("getTextUserIdLabel() method has an Exception: " + e);
            return "Cant find webElement UserIdLabel ";
        }
    }

    @FindBy(xpath = "//*[@class='user_id']/span[2]")
    @CacheLookup
    WebElement UserId;

    public boolean userIdIsEnabled() {
        try {
            basePage.waitElementToBeVisible(UserId);
            return basePage.elementIsEnable(UserId);
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextUserId() {
        try {
            basePage.waitElementToBeVisible(UserId);
            return basePage.getText(UserId);
        } catch (Exception e) {
            logger.error("getTextUserId() method has an Exception: " + e);
            return "Cant find webElement UserId ";
        }
    }


    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Bonus Balance']/div[@class='balance_section']/span[1]")
    @CacheLookup
    WebElement bonusLabel;

    public boolean bonusLabelIsEnabled() {
        try {
            basePage.waitElementToBeVisible(bonusLabel);
            return basePage.elementIsEnable(bonusLabel);
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextBonusLabel() {
        try {
            basePage.waitElementToBeVisible(bonusLabel);
            return basePage.getText(bonusLabel);
        } catch (Exception e) {
            logger.error("getTextBonusLabel() method has an Exception: " + e);
            return "Cant find webElement bonusLabel ";
        }
    }

    @FindBy(xpath = "//li[@class='text-style2 TEST_HeaderPanel1Menu_Bonus Balance']/div[@class='balance_section']/span[2]")
    @CacheLookup
    WebElement bonus;

    public boolean bonusIsEnabled() {
        try {
            basePage.waitElementToBeVisible(bonus);
            return basePage.elementIsEnable(bonus);
        } catch (Exception e) {
            return false;
        }
    }

    public String getBonus() {
        try {
            basePage.waitElementToBeVisible(bonus);
            return basePage.getText(bonus);
        } catch (Exception e) {
            logger.error("getBonus() method has an Exception: " + e);
            return "Cant find webElement bonus ";
        }
    }


    @FindBy(xpath = "//i[@class= 'icon icon-message']")
    @CacheLookup
    WebElement messageIcon;

    public void clickOnMessageIconIfVisibleJS() {
        if (userIdLabelIsEnabled()) {
            try {
                basePage.waitElementToBeVisible(messageIcon);
                basePage.javaScriptClick(messageIcon);
//                basePage.clickOnElementIfClickable(messageIcon);
                basePage.waitAction(500);
            } catch (Exception e) {
                logger.error(" clickOnMessageIconIfVisibleJS() method has an Exception: " + e);
            }
        }
    }


    @FindBy(xpath = "//li[@class='button-style3 TEST_HeaderPanel1Menu_Deposit']/div")
    @CacheLookup
    WebElement depositButton;

    public void clickOnDepositButtonJS() {
        try {
            basePage.waitElementToBeVisible(depositButton);
            basePage.waitElementTobeClickable(depositButton);
            basePage.javaScriptClick(depositButton);
            basePage.waitAction(200);
        } catch (Exception e) {
            logger.error("clickOnDepositButtonJS() method has an Exception: " + e);
        }
    }


    @FindBy(xpath = "//div[@id='custom_dropdown_style1']")
    @CacheLookup
    WebElement customDropDown;

    public void clickOnCustomDropDownJS() {
        try {
            basePage.waitElementToBeVisible(customDropDown);
            basePage.javaScriptClick(customDropDown);
        } catch (Exception e) {
            logger.error("clickOnCustomDropDownJS() method has an Exception: " + e);

        }
    }


    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Deposit list-section']")
    @CacheLookup
    WebElement customDropDownDeposit;

    public void clickOnCustomDropDownDepositJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownDeposit);
            basePage.javaScriptClick(customDropDownDeposit);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownDepositJS() method has an Exception: " + e);

        }
    }

    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Withdraw list-section']")
    @CacheLookup
    WebElement customDropDownWithdraw;
    public void clickOnCustomDropDownWithdrawJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownWithdraw);
            basePage.javaScriptClick(customDropDownWithdraw);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownWithdrawJS() method has an Exception: " + e);
        }
    }


    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Bank_Accounts list-section']")
    @CacheLookup
    WebElement customDropDownBankAccounts;
    public void clickOnCustomDropDownBankAccountsJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownBankAccounts);
            basePage.javaScriptClick(customDropDownBankAccounts);
        }
        catch (Exception e){
            logger.error(" clickOnCustomDropDownBankAccountsJS() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_My_bets list-section']")
    @CacheLookup
    WebElement customDropDownHistory;
    public void clickOnCustomDropDownHistoryJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownHistory);
            basePage.javaScriptClick(customDropDownHistory);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownHistoryJS() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Settings list-section']")
    @CacheLookup
    WebElement customDropDownSettings;
    public void clickOnCustomDropDownSettingsJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownSettings);
            basePage.javaScriptClick(customDropDownSettings);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownSettingsJS()) method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_My_tickets list-section']")
    @CacheLookup
    WebElement customDropDownMyTickets;
    public void clickOnCustomDropDownMyTicketsJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownMyTickets);
            basePage.javaScriptClick(customDropDownMyTickets);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownMyTicketsJS() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='Friends TEST_ACCOUNT_DPD_My list-section']")
    @CacheLookup
    WebElement customDropDownMyFriends;
    public void clickOnCustomDropDownMyFriendsJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownMyFriends);
            basePage.javaScriptClick(customDropDownMyFriends);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownMyFriendsJS() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//div[@class='TEST_ACCOUNT_DPD_Logout list-section']")
    @CacheLookup
    WebElement customDropDownLogOut;

    public void clickOnCustomDropDownLogOutJS() {
        try{
            basePage.waitElementToBeVisible(customDropDownLogOut);
            basePage.javaScriptClick(customDropDownLogOut);
        }
        catch (Exception e){
            logger.error("clickOnCustomDropDownLogOutJS() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//li[contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu')]")
    @CacheLookup
    WebElement more2DropDown;
    public void hoverOnMore2DropDown() {
        try {
            basePage.waitElementToBeVisible(more2DropDown);
            basePage.actionMoveToElement(more2DropDown);
        } catch (Exception e) {
            logger.error("hoverOnMore2DropDown() method has an Exception: " + e);
        }
    }

}
