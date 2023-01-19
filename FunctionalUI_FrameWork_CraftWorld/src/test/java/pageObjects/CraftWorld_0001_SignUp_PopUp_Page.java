package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CraftWorld_0001_SignUp_PopUp_Page extends BasePage {
//    public CraftBet_SignUp_PopUp_Page( ) {
//
//    }
    private final BasePage basePage;

    public CraftWorld_0001_SignUp_PopUp_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }



    @FindBy(xpath = "//div[@class='registration-section']")
    @CacheLookup
    WebElement registrationPopUpForm;
    @FindBy(xpath = "//div[@class='register-background']")
    @CacheLookup
    WebElement BackgroundPhoto;
    @FindBy(xpath = "//div[@class='reg-prompt-text']")
    @CacheLookup
    WebElement labelPleaseFill;
    @FindBy(xpath = "//button[@data-id = 'register-type-Quick-Register']")
    @CacheLookup
    WebElement buttonQuickRegistration;
    @FindBy(xpath = "//button[@data-id = 'register-type-Full-Register']")
    @CacheLookup
    WebElement buttonFullRegistration;
    @FindBy(xpath = "//div[@class='social-register-text']")
    @CacheLookup
    WebElement labelThisSiteProtected;
    @FindBy(xpath = "//div[@class='safety-info_text']//a")
    @CacheLookup
    WebElement labelSafeAndSecure;
    @FindBy(xpath = "//a[@data-id='register-type-Quick-Register']")
    @CacheLookup
    WebElement titleQ;
    @FindBy(xpath = "//a[@data-id='register-type-Full-Register']")
    @CacheLookup
    WebElement titleF;
    @FindBy(xpath = "//a[@class='go_back']")
    @CacheLookup
    WebElement backToPreviousPageButton;
    @FindBy(xpath = "//span[@class='icon-close-modal']")
    @CacheLookup
    WebElement closeXButton;
    @FindBy(xpath = "//div[@data-id='register-item-quick-RegisterTypes']//label")
    @CacheLookup
    WebElement labelEmailMobileDropDownQ;
    @FindBy(xpath = "//div[@data-id='register-item-quick-RegisterTypes']//select")
    @CacheLookup
    WebElement emailMobileDropDownQ;
    @FindBy(xpath = "//div[@data-id='register-item-quick-Email']//label")
    @CacheLookup
    WebElement labelEmailInputQ;
    @FindBy(xpath = "//div[@data-id='register-item-quick-Email']//input")
    @CacheLookup
    WebElement emailInputQ;
    @FindBy(xpath = "//ul[@data-id='register-mobile-codes']")
    @CacheLookup
    WebElement mobileDropDownQ;
    @FindBy(xpath = "//li[@data-id='register-code-AM']")
    @CacheLookup
    WebElement mobileDropDownQAM;
    @FindBy(xpath = "//li[@data-id='register-code-RU']")
    @CacheLookup
    WebElement mobileDropDownQRU;
    @FindBy(xpath = "//li[@data-id='register-code-GB']")
    @CacheLookup
    WebElement mobileDropDownQGB;
    @FindBy(xpath = "//li[@data-id='register-code-DE']")
    @CacheLookup
    WebElement mobileDropDownQDE;
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//span")
    List<WebElement> mobileCodesTextList;
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//img")
    List<WebElement> mobileCodesImgList;
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//label")
    @CacheLookup
    WebElement labelMobileInputQ;
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//input")
    @CacheLookup
    WebElement mobileInputQ;
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//span")
    @CacheLookup
    WebElement mobileInputQErrorMessage;
    @FindBy(xpath = "//div[@data-id='register-item-quick-CurrencyId']//label")
    @CacheLookup
    WebElement labelCurrencyDropDownQ;
    @FindBy(xpath = "//div[@data-id='register-item-quick-CurrencyId']//select")
    @CacheLookup
    WebElement currencyDropDownQ;
    @FindBy(xpath = "//span[@class='reg-conditions']")
    @CacheLookup
    WebElement labelTermsConditionsQ;
    @FindBy(xpath = "//span[@class='reg-conditions']//a")
    @CacheLookup
    WebElement linkTermsConditionsQ;
    @FindBy(xpath = "//input[@id='acceptTerms']")
    @CacheLookup
    WebElement checkBoxTermsConditionsQ;
    @FindBy(xpath = "//button[@data-id='register-quick-button']")
    @CacheLookup
    WebElement buttonRegisterQ;
    @FindBy(xpath = "//div[@class='error_message register_error_message']")
    @CacheLookup
    WebElement errorMessage;
    @FindBy(xpath = "//div[@class='register_PSection_redirect']")
    @CacheLookup
    WebElement labelAlreadyHaveAnAccount;
    @FindBy(xpath = "//div[@class='register_PSection_redirect']//a")
    @CacheLookup
    WebElement linkToLogInPapUp;
    public boolean registrationPopUpFormPresence() {
        try {
            basePage.waitElementToBeVisible(registrationPopUpForm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean BackgroundPhotoPresence() {
        try {
            basePage.waitElementToBeVisible(BackgroundPhoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getTextLabelPleaseFill() {
        try {
            return basePage.getText(labelPleaseFill);
        } catch (Exception e) {
            return "Cant find element labelPleaseFill";
        }
    }
    public String getTextButtonQuickRegistration() {
        try {
            return basePage.getText(buttonQuickRegistration);
        } catch (Exception e) {
            return "Cant find element buttonQuickRegistration";
        }
    }
    public String getTextButtonFullRegistration() {
        try {
            return basePage.getText(buttonFullRegistration);
        } catch (Exception e) {
            return "Cant find element buttonFullRegistration";
        }
    }
    public void clickOnButtonFullRegistration() {
        try{
            basePage.waitElementToBeVisible(buttonFullRegistration);
            basePage.javaScriptClick(buttonFullRegistration);
        }
        catch (Exception e){
            logger.info("Cant find element buttonFullRegistration");
        }
    }
    public void clickOnButtonQuickRegistration() {
        try{
            basePage.waitElementToBeVisible(buttonQuickRegistration);
            basePage.javaScriptClick(buttonQuickRegistration);
        }
        catch (Exception e){
            logger.info("Cant find element buttonQuickRegistration");
        }
    }
    public String getTextLabelThisSiteProtected() {
        try {
            return basePage.getText(labelThisSiteProtected);
        } catch (Exception e) {
            return "Cant find element labelThisSiteProtected";
        }
    }
    public String getTextLabelSafeAndSecure() {
        try {
            return basePage.getText(labelSafeAndSecure);
        } catch (Exception e) {
            return "Cant find element labelSafeAndSecure";
        }
    }
    public String getTextTitleQ() {
        try {
            basePage.waitElementToBeVisible(titleQ);
            return basePage.getText(titleQ);
        } catch (Exception e) {
            return "Cant find element titleQ";
        }
    }
    public void clickOnButtonTitleQ() {
        try{
            basePage.waitElementToBeVisible(titleQ);
            basePage.javaScriptClick(titleQ);
        }
        catch (Exception e){
            logger.info("Cant find element titleQ");
        }
    }
    public String getTextTitleF() {
        try {
            basePage.waitElementToBeVisible(titleF);
            return basePage.getText(titleF);
        } catch (Exception e) {
            return "Cant find element titleF";
        }
    }
    public void clickOnButtonTitleF() {
        try{
            basePage.waitElementToBeVisible(titleF);
            basePage.javaScriptClick(titleF);
        }
        catch (Exception e){
            logger.info("Cant find element titleF");
        }
    }
    public void clickOnBackToPreviousPageButton() {
        try{
            basePage.waitElementToBeVisible(backToPreviousPageButton);
            basePage.javaScriptClick(backToPreviousPageButton);
        }
        catch (Exception e){
            logger.info("Cant find element backToPreviousPageButton");
        }
    }
    public boolean isBackToPreviousPageButtonVisible(){
        boolean isVisible ;
        try {
            isVisible = basePage.waitElementToBeVisibleBoolean(backToPreviousPageButton);
        }
        catch (Exception e){
            isVisible = false;
        }
        return isVisible;
    }
    public void clickOnButtonCloseXButton() {
        try{
            basePage.waitElementToBeVisible(closeXButton);
            basePage.javaScriptClick(closeXButton);
        }
        catch (Exception e){
            logger.info("Cant find element closeXButton");
        }

    }
    public boolean isCloseXButtonVisible(){
        boolean isVisible ;
        try {
            isVisible = basePage.waitElementToBeVisibleBoolean(closeXButton);
        }
        catch (Exception e){
            isVisible = false;
        }
        return isVisible;
    }
    public String getTextLabelEmailMobileDropDownQ() {
        try {
            return basePage.getText(labelEmailMobileDropDownQ);
        } catch (Exception e) {
            return "Cant find element labelEmailMobileDropDownQ";
        }
    }
    public void selectEmailMobileDropDownQ(String text) {
        try {
            basePage.waitElementToBeVisible(emailMobileDropDownQ);
            basePage.selectFromDropDownByVisibleText(emailMobileDropDownQ, text);
        } catch (Exception e) {
            logger.info("Cant find element emailMobileDropDownQ");
        }
    }
    public String getTextEmailMobileDropDownQ() {
        try {
            return basePage.getSelectedItemText(basePage.createSelectElement(emailMobileDropDownQ));
        } catch (Exception e) {
            return "Cant find element emailMobileDropDownQ";
        }
    }
    public String getTextLabelEmailInputQ() {
        try {
            return basePage.getText(labelEmailInputQ);
        } catch (Exception e) {
            return "Cant find element labelEmailInputQ";
        }
    }
    public void sendKeysEmailInputQ(String email) {
        try {
            basePage.sendKeysIfElementVisible(emailInputQ, email);
        } catch (Exception e) {
            logger.info("Cant find element emailInputQ");
        }
    }
    public void clickOnMobileDropDownQ() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQ);
            basePage.javaScriptClick(mobileDropDownQ);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQ");
        }

    }
    public void SelectFromMobileDropDownByVisibleTextQ(String text) {
        try {
            basePage.waitElementToBeVisible(mobileDropDownQ);
            basePage.selectFromDropDownByVisibleText(mobileDropDownQ, text);
        } catch (Exception e) {

        }
    }
    public void SelectFromMobileDropDownByIndexQ(int index) { //index starts from 0
        try {
            basePage.waitElementToBeVisible(mobileDropDownQ);
            basePage.selectFromDropDownByIndex(mobileDropDownQ, index);
        } catch (Exception e) {
            logger.info("SelectFromMobileDropDownByIndexQ(int index) method has an exception: " + e);
        }
    }
    public String getTextFromMobileDropDownQ() {
        try {
            return basePage.getSelectedItemText(basePage.createSelectElement(mobileDropDownQ));
        } catch (Exception e) {
            return "Cant find element currencyDropDownQ";
        }
    }
    public void clickOnMobileDropDownQAM() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQAM);
            basePage.javaScriptClick(mobileDropDownQAM);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQAM");
        }
    }
    public void clickOnMobileDropDownQRU() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQRU);
            basePage.javaScriptClick(mobileDropDownQRU);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQRU");
        }
    }
    public void clickOnMobileDropDownQGB() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQGB);
            basePage.javaScriptClick(mobileDropDownQGB);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQGB");
        }
    }
    public void clickOnMobileDropDownQDE() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQDE);
            basePage.javaScriptClick(mobileDropDownQDE);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQDE");
        }
    }
    public List<WebElement> getMobileCodesTextList() {
        try{
            return mobileCodesTextList;
        }
        catch(Exception e){
            logger.error("getMobileCodesTextList() method has an Exception: " + e);
        }
        return null;
    }
    public void getTextMobileCodText(WebElement mobileCodText) {
        try {
            basePage.waitElementToBeVisible(mobileCodText);
            basePage.javaScriptClick(mobileCodText);
        } catch (Exception e) {
            logger.error("getTextMobileCodText(WebElement mobileCodText)  method has an Exception: " + e);
        }
    }
    public List<WebElement> getMobileCodesImgList() {
        try{
            return mobileCodesImgList;
        }
        catch(Exception e){
            logger.error("getMobileCodesImgList() method has an Exception: " + e);
        }
        return null;
    }
    public String getTextLabelMobileInputQ() {
        try {
            return basePage.getText(labelMobileInputQ);
        } catch (Exception e) {
            return "Cant find element labelMobileInputQ";
        }
    }
    public void sendKeysMobileInputQ(String number) {
        try {
            basePage.sendKeysIfElementVisible(mobileInputQ, number);
        } catch (Exception e) {
            logger.info("Cant find element mobileInputQ");
        }
    }
    public String mobileInputQInputIsValid(){
        String classAttribute = null;
        try {
            classAttribute = basePage.getAttribute(mobileInputQ,"class");
        }
        catch (Exception e){
            logger.info("Cant get class Attribute mobileInputQ");
        }
        return classAttribute;
    }
    public String getErrorMobileInputQ() {
        String error = null;
        try {
            error = basePage.getText(mobileInputQ);
        } catch (Exception e) {
            logger.info("Cant get Error message mobileInputQ");
        }
        return error;
    }
    public String getTextLabelCurrencyDropDownQ() {
        try {
            return basePage.getText(labelCurrencyDropDownQ);
        } catch (Exception e) {
            return "Cant find element labelCurrencyDropDownQ";
        }
    }
    public void selectFromCurrencyDropDownByVisibleTextQ(String text) {
        try {
            basePage.waitElementToBeVisible(currencyDropDownQ);
            basePage.selectFromDropDownByVisibleText(currencyDropDownQ, text);
        } catch (Exception e) {
            logger.info("Cant find element currencyDropDownQ") ;
        }
    }
    public String getTextFromCurrencyDropDownQ() {
        try {
            return basePage.getSelectedItemText(basePage.createSelectElement(currencyDropDownQ));
        } catch (Exception e) {
            return "Cant find element currencyDropDownQ";
        }
    }
    public void clickOnCurrencyDropDownQ() {
        try {
            basePage.waitElementToBeVisible(currencyDropDownQ);
            basePage.javaScriptClick(currencyDropDownQ);
        } catch (Exception e) {
            logger.info("Cant find element currencyDropDownQ") ;
        }
    }
    public String getTextLabelTermsConditionsQ() {
        try {
            return basePage.getText(labelTermsConditionsQ);
        } catch (Exception e) {
            return "Cant find element labelTermsConditionsQ";
        }
    }
    public void clickOnLinkTermsConditionsQ() {
        try {
            basePage.waitElementToBeVisible(linkTermsConditionsQ);
            basePage.javaScriptClick(linkTermsConditionsQ);
        } catch (Exception e) {
            logger.info("Cant find element linkTermsConditionsQ");
        }
    }
    public void clickOnCheckBoxTermsConditionsQ() {
        try {
            basePage.waitElementToBeVisible(checkBoxTermsConditionsQ);
            basePage.javaScriptClick(checkBoxTermsConditionsQ);
        } catch (Exception e) {
            logger.info("Cant find element checkBoxTermsConditionsQ");
        }
    }
    public String getTextButtonRegisterQ() {
        try {
            return basePage.getText(buttonRegisterQ);
        } catch (Exception e) {
            return "Cant find element buttonRegisterQ";
        }
    }
    public void clickOnButtonRegisterQ() {
        try {
            basePage.waitElementToBeVisible(buttonRegisterQ);
            basePage.javaScriptClick(buttonRegisterQ);
        } catch (Exception e) {

        }
    }
    public String  getAttributeClassButtonRegisterQ() {
        try {
            return basePage.getAttribute(buttonRegisterQ,"class");
        } catch (Exception e) {
            return "Cant find element buttonRegisterQ";
        }
    }
    public void clickOnLinkLogIn() {
        try {
            basePage.waitElementToBeVisible(linkToLogInPapUp);
            basePage.javaScriptClick(linkToLogInPapUp);
        } catch (Exception e) {

        }
    }
    public String getTextErrorMessage() {
        try {
            return basePage.getText(errorMessage);
        } catch (Exception e) {
            return "Cant find element errorMessage";
        }
    }
    public String getTextLabelAlreadyHaveAnAccount() {
        try {
            return basePage.getText(labelAlreadyHaveAnAccount);
        } catch (Exception e) {
            return "Cant find element labelAlreadyHaveAnAccount";
        }
    }



//    @FindBy(xpath = "//a[@class='reg_item active']")  //Title
//    @CacheLookup
//    WebElement logo;

//    public boolean logoPresence() {
//        try {
//            basePage.waitElementToBeVisible(logo);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }




















    // full registration

    // first page

    @FindBy(xpath = "//select[@class='custom_dropdown_reg ng-pristine ng-valid ng-touched']")      //need to be changed
    @CacheLookup
    WebElement genderDropDownF;

    public void SelectFromGenderDropDownF(String text) {
        try {
            basePage.waitElementToBeVisible(genderDropDownF);
            basePage.selectFromDropDownByVisibleText(genderDropDownF, text);
        } catch (Exception e) {

        }
    }

    public String getPlaceHolder() {
        try {
            basePage.waitElementToBeVisible(genderDropDownF);
            return basePage.getAttribute(genderDropDownF, "placeholder");

        } catch (Exception e) {
            return "Cant find element or Attribute genderDropDownF/PlaceHolder";
        }
    }

    @FindBy(xpath = "//label[text()='First name']")      //need to be changed
    @CacheLookup
    WebElement labelFirstNameF;

    public String getTextLabelFirstName() {
        try {
            return basePage.getText(labelFirstNameF);
        } catch (Exception e) {
            return "Cant find element labelFirstName";
        }
    }

    @FindBy(xpath = "//input[@placeholder='First name']")      //need to be changed
    @CacheLookup
    WebElement inputFirstNameF;

    public void sendKeysInputFirstNameF(String firstName) {
        try {
            basePage.sendKeysIfElementVisible(inputFirstNameF, firstName);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//label[text()='Last name']")      //need to be changed
    @CacheLookup
    WebElement labelLastName;

    public String getTextLabelLastName() {
        try {
            return basePage.getText(labelLastName);
        } catch (Exception e) {
            return "Cant find element labelLastName";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Last name']")      //need to be changed
    @CacheLookup
    WebElement inputLastNameF;

    public void sendKeysInputLastNameF(String lastName) {
        try {
            basePage.sendKeysIfElementVisible(inputLastNameF, lastName);
        } catch (Exception e) {

        }
    }


    @FindBy(xpath = "//label[text()='Mobile Number']")      //need to be changed
    @CacheLookup
    WebElement labelMobileNumber;

    public String getTextLabelMobileNumber() {
        try {
            return basePage.getText(labelMobileNumber);
        } catch (Exception e) {
            return "Cant find element labelMobileNumber";
        }
    }

    @FindBy(xpath = "//div[@class='flex_between current_item']")
    @CacheLookup
    WebElement dropDownMobileNumberF;

    public void SelectFromDropDownMobileNumberByValueF(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownMobileNumberF);
            basePage.selectFromDropDownByVisibleText(dropDownMobileNumberF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownMobileNumberByIndexF(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownMobileNumberF);
            basePage.selectFromDropDownByIndex(dropDownMobileNumberF, index);
        } catch (Exception e) {

        }
    }


    @FindBy(xpath = "//input[@placeholder='00 00 00 00']")      //need to be changed
    @CacheLookup
    WebElement inputNumberF;

    public void sendKeysInputNumberF(String number) {
        try {
            basePage.sendKeysIfElementVisible(inputNumberF, number);
        } catch (Exception e) {

        }
    }

    public String getTextInputNumberF() {
        try {
            return basePage.getText(inputNumberF);
        } catch (Exception e) {
            return "Cant find element inputNumberF";
        }
    }


    @FindBy(xpath = "//label[text()='Birth Day']")      //need to be changed
    @CacheLookup
    WebElement labelBirthDayF;

    public String getTextLabelBirthDyF() {
        try {
            return basePage.getText(labelBirthDayF);
        } catch (Exception e) {
            return "Cant find element labelBirthDayF";
        }
    }



    @FindBy(xpath = "//select[@class='custom_dropdown_reg ng-pristine ng-invalid invalid-filed ng-touched']")      //need to be changed
    @CacheLookup
    WebElement dropDownYearF;

    public void SelectFromDropDownYearByVisibleTextF(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownYearF);
            basePage.selectFromDropDownByVisibleText(dropDownYearF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownYearByIndexF(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownYearF);
            basePage.selectFromDropDownByIndex(dropDownYearF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//select[@id='birth-month']")
    @CacheLookup
    WebElement dropDownMonthF;

    public void SelectFromDropDownMonthFByVisibleTextF(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownMonthF);
            basePage.selectFromDropDownByVisibleText(dropDownMonthF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownMonthFByIndexF(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownMonthF);
            basePage.selectFromDropDownByIndex(dropDownMonthF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//select[@class='disable-item ng-untouched ng-pristine ng-invalid']")      //need to be changed
    @CacheLookup
    WebElement dropDownDayF;

    public void SelectFromDropDownDayFByVisibleTextF(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownDayF);
            basePage.selectFromDropDownByVisibleText(dropDownDayF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownDayFByIndexF(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownDayF);
            basePage.selectFromDropDownByIndex(dropDownDayF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//div[@class='reg-step-navigate-buttons flex-end']//button")
    @CacheLookup
    WebElement buttonContinueFirstF;


    public void clickOnButtonContinueF() {
        try {
            basePage.waitElementToBeVisible(buttonContinueFirstF);
            basePage.javaScriptClick(buttonContinueFirstF);
        } catch (Exception e) {

        }
    }
    public  String getAttributeButtonContinueF(){
        try {
            basePage.waitElementToBeVisible(buttonContinueFirstF);
           return basePage.getAttribute(buttonContinueFirstF,"class");
        } catch (Exception e) {
            return "Cant find element/Attribute buttonContinueF";
        }
        // craft_btn next-btn not_active ---->Not Active
        // craft_btn next-btn            ---->Active
    }





// Second Page

    @FindBy(xpath = "//span[@class='icon-arrow-to-left']")
    @CacheLookup
    WebElement arrowBackLeftF;
    public void clickOnArrowBackLeftF() {
        try {
            basePage.waitElementToBeVisible(arrowBackLeftF);
            basePage.javaScriptClick(arrowBackLeftF);
        } catch (Exception e) {

        }
    }
    @FindBy(xpath = "//a[@class='reg_item active go_back']")
    @CacheLookup
    WebElement labelGoBackF;
    public String getTextLabelGoBackF() {
        try {
            return basePage.getText(labelGoBackF);
        } catch (Exception e) {
            return "Cant find element labelGoBackF";
        }
    }
    public void clickOnLabelGoBackF() {
        try {
            basePage.waitElementToBeVisible(labelGoBackF);
            basePage.javaScriptClick(labelGoBackF);
        } catch (Exception e) {

        }
    }
    @FindBy(xpath = "//div[@class='form_field form_field__Region2']//label")
    @CacheLookup
    WebElement labelDropDownCountryF;

    public String getTextLabelDropDownCountryF() {
        try {
            return basePage.getText(labelDropDownCountryF);
        } catch (Exception e) {
            return "Cant find element labelDropDownCountryF";
        }
    }

    @FindBy(xpath = "//select[@class='custom_dropdown_reg ng-pristine ng-valid ng-touched']")
    @CacheLookup
    WebElement dropDownCountryF;

    public void SelectFromDropDownDropDownCountryFByVisibleText(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownCountryF);
            basePage.selectFromDropDownByVisibleText(dropDownCountryF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownDropDownCountryFIndex(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownCountryF);
            basePage.selectFromDropDownByIndex(dropDownCountryF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//select[@class='custom_dropdown_reg disable-item ng-untouched ng-pristine ng-valid']")
    @CacheLookup
    WebElement dropDownCityF;

    public void SelectFromDropDownCityFByVisibleText(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownCityF);
            basePage.selectFromDropDownByVisibleText(dropDownCityF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownCityFIndex(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownCityF);
            basePage.selectFromDropDownByIndex(dropDownCityF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//label[text()='Address']")      //need to be changed
    @CacheLookup
    WebElement labelInputAddressF;
    public String getTextLabelInputAddressF() {
        try {
            return basePage.getText(labelInputAddressF);
        } catch (Exception e) {
            return "Cant find element labelInputAddressF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Address']")      //need to be changed
    @CacheLookup
    WebElement inputAddressF;

    public void sendKeysInputAddressF(String number) {
        try {
            basePage.sendKeysIfElementVisible(inputAddressF, number);
        } catch (Exception e) {
        }
    }



    @FindBy(xpath = "//label[text()='Document number']")      //need to be changed
    @CacheLookup
    WebElement labelDocNumberF;

    public String getTextLabelDocNumberF() {
        try {
            return basePage.getText(labelDocNumberF);
        } catch (Exception e) {
            return "Cant find element labelDocNumberF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Document number']")      //need to be changed
    @CacheLookup
    WebElement inputDocNumberF;
    public void sendKeysInputDocNumberF(String number) {
        try {
            basePage.sendKeysIfElementVisible(inputDocNumberF, number);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//label[text()='Promo Code (Optional)']")      //need to be changed
    @CacheLookup
    WebElement labelPromoCodF;

    public String getTextLabelPromoCodF() {
        try {
            return basePage.getText(labelPromoCodF);
        } catch (Exception e) {
            return "Cant find element labelPromoCodF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Promo Code (Optional)']")      //need to be changed
    @CacheLookup
    WebElement inputPromoCodF;

    public void sendKeysInputPromoCodF(String number) {
        try {
            basePage.sendKeysIfElementVisible(inputPromoCodF, number);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//div[@class='reg-step-navigate-buttons flex-between']//button")
    @CacheLookup
    WebElement buttonContinueSecondF;


    public void clickOnButtonContinueSecondF() {
        try {
            basePage.waitElementToBeVisible(buttonContinueSecondF);
            basePage.javaScriptClick(buttonContinueSecondF);
        } catch (Exception e) {

        }
    }




// The third Page

    @FindBy(xpath = "//label[text()='Username']")      //need to be changed
    @CacheLookup
    WebElement labelUsernameF;

    public String getTextLabelUsernameF() {
        try {
            return basePage.getText(labelUsernameF);
        } catch (Exception e) {
            return "Cant find element labelUsernameF";
        }
    }

    @FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-valid']")
    @CacheLookup
    WebElement inputUsernameF;

    public void sendKeysInputUsernameF(String username) {
        try {
            basePage.sendKeysIfElementVisible(inputUsernameF, username);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//label[text()='Email']")      //need to be changed
    @CacheLookup
    WebElement labelEmailF;

    public String getTextLabelEmailF() {
        try {
            return basePage.getText(labelEmailF);
        } catch (Exception e) {
            return "Cant find element labelEmailF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Email']")      //need to be changed
    @CacheLookup
    WebElement inputEmailF;

    public void sendKeysInputEmailF(String email) {
        try {
            basePage.sendKeysIfElementVisible(inputEmailF, email);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//label[text()='Currency']")      //need to be changed
    @CacheLookup
    WebElement labelCurrencyDropDownF;

    public String getTextLabelCurrencyDropDownF() {
        try {
            return basePage.getText(labelCurrencyDropDownF);
        } catch (Exception e) {
            return "Cant find element labelCurrencyDropDownF";
        }
    }

    @FindBy(xpath = "//select[@class='ng-pristine ng-valid ng-touched']")
    @CacheLookup
    WebElement dropDownCurrencyF;
    public void SelectFromDropDownCurrencyFByVisibleText(String text) {
        try {
            basePage.waitElementToBeVisible(dropDownCurrencyF);
            basePage.selectFromDropDownByVisibleText(dropDownCurrencyF, text);
        } catch (Exception e) {

        }
    }

    public void SelectFromDropDownCurrencyFIndex(int index) {
        try {
            basePage.waitElementToBeVisible(dropDownCurrencyF);
            basePage.selectFromDropDownByIndex(dropDownCurrencyF, index);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//label[text()='Password']")      //need to be changed
    @CacheLookup
    WebElement labelPasswordF;

    public String getTextLabelPasswordF() {
        try {
            return basePage.getText(labelPasswordF);
        } catch (Exception e) {
            return "Cant find element labelPasswordF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Password (8 or more characters)']")      //need to be changed
    @CacheLookup
    WebElement inputPasswordF;
    public void sendKeysInputPasswordF(String password) {
        try {
            basePage.sendKeysIfElementVisible(inputPasswordF, password);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//label[text()='Confirm Password']")      //need to be changed
    @CacheLookup
    WebElement labelConfirmPasswordF;

    public String getTextLabelConfirmPasswordF() {
        try {
            return basePage.getText(labelConfirmPasswordF);
        } catch (Exception e) {
            return "Cant find element labelConfirmPasswordF";
        }
    }

    @FindBy(xpath = "//input[@placeholder='Confirm password']")      //need to be changed
    @CacheLookup
    WebElement inputConfirmPasswordF;

    public void sendKeysInputConfirmPasswordF(String passwordConfirm) {
        try {
            basePage.sendKeysIfElementVisible(inputConfirmPasswordF, passwordConfirm);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//span[@class='reg-conditions']//span")      //need to be changed
    @CacheLookup
    WebElement labelPrivacyPolicyF;

    public String getTextLabelPrivacyPolicyF() {
        try {
            return basePage.getText(labelPrivacyPolicyF);
        } catch (Exception e) {
            return "Cant find element labelPrivacyPolicyF";
        }
    }


    @FindBy(xpath = "//a[text()='Terms & Conditions and Privacy Policy ']")      //need to be changed
    @CacheLookup
    WebElement linkPrivacyPolicyF;
    public void clickOnLinkPrivacyPolicyF() {
        try {
            basePage.waitElementToBeVisible(linkPrivacyPolicyF);
            basePage.javaScriptClick(linkPrivacyPolicyF);
        } catch (Exception e) {

        }
    }

    @FindBy(xpath = "//input[@class='reg-checkbox distans-right ng-valid ng-dirty invalid-filed ng-touched']")      //need to be changed
    @CacheLookup
    WebElement checkBoxPrivacyPolicyF;
    public void clickOnCheckBoxPrivacyPolicyF() {
        try {
            basePage.waitElementToBeVisible(checkBoxPrivacyPolicyF);
            basePage.javaScriptClick(checkBoxPrivacyPolicyF);
        } catch (Exception e) {

        }
    }
    public boolean checkBoxCheckBoxPrivacyPolicyFIsSelected(){
        basePage.waitElementToBeVisible(checkBoxPrivacyPolicyF);
        if (basePage.elementIsSelected(checkBoxPrivacyPolicyF)){
            return true;
        }
        else{
            return false;
        }
    }

    @FindBy(xpath = "//span[@class='reg-conditions' and @xpath='2']")
    @CacheLookup
    WebElement labelReceiveNewsF;

    public String getTextLabelReceiveF() {
        try {
            return basePage.getText(labelReceiveNewsF);
        } catch (Exception e) {
            return "Cant find element labelReceiveNewsF";
        }
    }

    @FindBy(xpath = "//input[@class='reg-checkbox distans-right ng-dirty ng-valid invalid-filed ng-touched']")
    @CacheLookup
    WebElement checkBoxReceiveF;
    public void clickOnCheckBoxReceiveF() {
        try {
            basePage.waitElementToBeVisible(checkBoxReceiveF);
            basePage.javaScriptClick(checkBoxReceiveF);
        } catch (Exception e) {

        }
    }
    public boolean checkBoxReceiveFIsSelected(){
            basePage.waitElementToBeVisible(checkBoxReceiveF);
            if (basePage.elementIsSelected(checkBoxReceiveF)){
                return true;
            }
            else{
                return false;
            }
    }

    @FindBy(xpath = "//button[@class='craft_btn next-btn']")
    @CacheLookup
    WebElement buttonRegisterF;

    public String getTextButtonRegisterF() {
        try {
            return basePage.getText(buttonRegisterF);
        } catch (Exception e) {
            return "Cant find element buttonRegisterF";
        }
    }

    public void clickOnButtonRegisterF() {
        try {
            basePage.waitElementToBeVisible(buttonRegisterF);
            basePage.javaScriptClick(buttonRegisterF);
        } catch (Exception e) {

        }
    }


    public Object[][] invalidSignUpData() {
        Object invalidLoginData[][] = {{basePage.generateRandomEmailInValid1()},{basePage.generateRandomEmailInValid2()},
                {basePage.generateRandomEmailInValid3()},{basePage.generateRandomEmailInValid4()},
                {basePage.generateRandomEmailInValid5()},{basePage.generateRandomEmailInValid6()}};

        return invalidLoginData;
    }

}
