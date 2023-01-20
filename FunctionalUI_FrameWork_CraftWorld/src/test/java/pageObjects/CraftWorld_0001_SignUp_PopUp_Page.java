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


                    //Common Part
    @FindBy(xpath = "//div[@class='registration-section']")
    @CacheLookup
    WebElement registrationPopUpForm;
    public boolean registrationPopUpFormPresence() {
        try {
            basePage.waitElementToBeVisible(registrationPopUpForm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @FindBy(xpath = "//div[@class='register-background']")
    @CacheLookup
    WebElement BackgroundPhoto;
    public boolean BackgroundPhotoPresence() {
        try {
            basePage.waitElementToBeVisible(BackgroundPhoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @FindBy(xpath = "//div[@class='reg-prompt-text']")
    @CacheLookup
    WebElement labelPleaseFill;
    public String getTextLabelPleaseFill() {
        try {
            return basePage.getText(labelPleaseFill);
        } catch (Exception e) {
            return "Cant find element labelPleaseFill";
        }
    }
    @FindBy(xpath = "//div[@class='social-register-text']")
    @CacheLookup
    WebElement labelThisSiteProtected;
    public String getTextLabelThisSiteProtected() {
        try {
            return basePage.getText(labelThisSiteProtected);
        } catch (Exception e) {
            return "Cant find element labelThisSiteProtected";
        }
    }
    @FindBy(xpath = "//div[@class='safety-info_text']//a")
    @CacheLookup
    WebElement labelSafeAndSecure;
    public String getTextLabelSafeAndSecure() {
        try {
            return basePage.getText(labelSafeAndSecure);
        } catch (Exception e) {
            return "Cant find element labelSafeAndSecure";
        }
    }
    @FindBy(xpath = "//a[@class='go_back']")
    @CacheLookup
    WebElement backToPreviousPageButton;
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
    @FindBy(xpath = "//span[@class='icon-close-modal']")
    @CacheLookup
    WebElement closeXButton;
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


    //Quick Register common

    @FindBy(xpath = "//div[@class='error_message register_error_message']")
    @CacheLookup
    WebElement errorMessage;
    public String getTextErrorMessage() {
        try {
            return basePage.getText(errorMessage);
        } catch (Exception e) {
            return "Cant find element errorMessage";
        }
    }
    @FindBy(xpath = "//div[@class='register_PSection_redirect']")
    @CacheLookup
    WebElement labelAlreadyHaveAnAccount;
    public String getTextLabelAlreadyHaveAnAccount() {
        try {
            return basePage.getText(labelAlreadyHaveAnAccount);
        } catch (Exception e) {
            return "Cant find element labelAlreadyHaveAnAccount";
        }
    }
    @FindBy(xpath = "//div[@class='register_PSection_redirect']//a")
    @CacheLookup
    WebElement linkToLogInPapUp;
    public void clickOnLinkLogIn() {
        try {
            basePage.waitElementToBeVisible(linkToLogInPapUp);
            basePage.javaScriptClick(linkToLogInPapUp);
        } catch (Exception e) {

        }
    }
    @FindBy(xpath = "//button[@data-id='register-quick-button']")
    @CacheLookup
    WebElement buttonRegisterQ;
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




    @FindBy(xpath = "//button[@data-id = 'register-type-Quick-Register']")
    @CacheLookup
    WebElement buttonQuickRegistration;
    public String getTextButtonQuickRegistration() {
        try {
            return basePage.getText(buttonQuickRegistration);
        } catch (Exception e) {
            return "Cant find element buttonQuickRegistration";
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
    @FindBy(xpath = "//button[@data-id = 'register-type-Full-Register']")
    @CacheLookup
    WebElement buttonFullRegistration;
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
    @FindBy(xpath = "//a[@data-id='register-type-Quick-Register']")
    @CacheLookup
    WebElement titleQ;
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
    @FindBy(xpath = "//a[@data-id='register-type-Full-Register']")
    @CacheLookup
    WebElement titleF;
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








    //Type - DropDown (Email/Mobile)  Quick Reg
    @FindBy(xpath = "//div[@data-id='register-item-quick-RegisterTypes']//label")
    @CacheLookup
    WebElement labelEmailMobileDropDownQ;
    public String getTextLabelEmailMobileDropDownQ() {
        try {
            return basePage.getText(labelEmailMobileDropDownQ);
        } catch (Exception e) {
            return "Cant find element labelEmailMobileDropDownQ";
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-quick-RegisterTypes']//select")
    @CacheLookup
    WebElement emailMobileDropDownQ;
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



    //Type - text   Email
    @FindBy(xpath = "//div[@data-id='register-item-quick-Email']//label")
    @CacheLookup
    WebElement labelEmailInputQ;
    public String getTextLabelEmailInputQ() {
        try {
            return basePage.getText(labelEmailInputQ);
        } catch (Exception e) {
            return "Cant find element labelEmailInputQ";
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-quick-Email']//input")
    @CacheLookup
    WebElement emailInputQ;
    public void sendKeysEmailInputQ(String email) {
        try {
            basePage.sendKeysIfElementVisible(emailInputQ, email);
        } catch (Exception e) {
            logger.info("Cant find element emailInputQ");
        }
    }



    // Type - MobileData Quick_Reg
    @FindBy(xpath = "//ul[@data-id='register-mobile-codes']")
    @CacheLookup
    WebElement mobileDropDownQ;
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
    @FindBy(xpath = "//li[@data-id='register-code-AM']")
    @CacheLookup
    WebElement mobileDropDownQAM;
    public void clickOnMobileDropDownQAM() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQAM);
            basePage.javaScriptClick(mobileDropDownQAM);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQAM");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-RU']")
    @CacheLookup
    WebElement mobileDropDownQRU;
    public void clickOnMobileDropDownQRU() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQRU);
            basePage.javaScriptClick(mobileDropDownQRU);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQRU");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-GB']")
    @CacheLookup
    WebElement mobileDropDownQGB;
    public void clickOnMobileDropDownQGB() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQGB);
            basePage.javaScriptClick(mobileDropDownQGB);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQGB");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-DE']")
    @CacheLookup
    WebElement mobileDropDownQDE;
    public void clickOnMobileDropDownQDE() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownQDE);
            basePage.javaScriptClick(mobileDropDownQDE);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownQDE");
        }
    }
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//span")
    List<WebElement> mobileCodesTextList;
    public List<WebElement> getMobileCodesTextList() {
        try{
            return mobileCodesTextList;
        }
        catch(Exception e){
            logger.error("getMobileCodesTextList() method has an Exception: " + e);
        }
        return null;
    }
    public void setTextMobileCodText(WebElement mobileCodText) {
        try {
            basePage.waitElementToBeVisible(mobileCodText);
            basePage.javaScriptClick(mobileCodText);
        } catch (Exception e) {
            logger.error("getTextMobileCodText(WebElement mobileCodText)  method has an Exception: " + e);
        }
    }
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//img")
    List<WebElement> mobileCodesImgList;
    public List<WebElement> getMobileCodesImgList() {
        try{
            return mobileCodesImgList;
        }
        catch(Exception e){
            logger.error("getMobileCodesImgList() method has an Exception: " + e);
        }
        return null;
    }
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//label")
    @CacheLookup
    WebElement labelMobileInputQ;
    public String getTextLabelMobileInputQ() {
        try {
            return basePage.getText(labelMobileInputQ);
        } catch (Exception e) {
            return "Cant find element labelMobileInputQ";
        }
    }
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//input")
    @CacheLookup
    WebElement mobileInputQ;
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
    @FindBy(xpath = "//div[@class='mobileData_tabs']/following::span[@class='error-field-message']")
    @CacheLookup
    WebElement mobileInputQErrorMessage;
    public String getTextErrorMessageMobileInputQ() {
        try {
            return basePage.getText(mobileInputQErrorMessage);
        } catch (Exception e) {
            return "Cant find element mobileInputQErrorMessage";
        }
    }


    // Type Currency Quick_Reg
    @FindBy(xpath = "//div[@data-id='register-item-quick-CurrencyId']//label")
    @CacheLookup
    WebElement labelCurrencyDropDownQ;
    public String getTextLabelCurrencyDropDownQ() {
        try {
            return basePage.getText(labelCurrencyDropDownQ);
        } catch (Exception e) {
            return "Cant find element labelCurrencyDropDownQ";
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-quick-CurrencyId']//select")
    @CacheLookup
    WebElement currencyDropDownQ;
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


    // Type Currency Quick_Reg
    @FindBy(xpath = "//div[@data-id = 'register-item-Gender']//label")
    @CacheLookup
    WebElement labelGenderDropDownQ;
    public String getTextLabelGenderDropDownQ() {
        try {
            return basePage.getText(labelGenderDropDownQ);
        } catch (Exception e) {
            return "Cant find element labelGenderDropDownQ";
        }
    }
    @FindBy(xpath = "//div[@data-id = 'register-item-Gender']//select")
    @CacheLookup
    WebElement genderDropDownQ;
    public void selectFromGenderDropDownByVisibleTextQ(String text) {
        try {
            basePage.waitElementToBeVisible(genderDropDownQ);
            basePage.selectFromDropDownByVisibleText(genderDropDownQ, text);
        } catch (Exception e) {
            logger.info("Cant find element genderDropDownQ") ;
        }
    }
    public String getTextFromGenderDropDownQ() {
        try {
            return basePage.getSelectedItemText(basePage.createSelectElement(genderDropDownQ));
        } catch (Exception e) {
            return "Cant find element genderDropDownQ";
        }
    }
    public void clickOnGenderDropDownQ() {
        try {
            basePage.waitElementToBeVisible(genderDropDownQ);
            basePage.javaScriptClick(genderDropDownQ);
        } catch (Exception e) {
            logger.info("Cant find element genderDropDownQ") ;
        }
    }


    //Type - PasswordType  Password/ConfirmPassword
    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//label[1]")
    @CacheLookup
    WebElement labelPasswordInputQ;
    public String getTextLabelPasswordInputQ() {
        try {
            return basePage.getText(labelPasswordInputQ);
        } catch (Exception e) {
            return "Cant find element labelPasswordInputQ";
        }
    }
    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//input[1]")
    @CacheLookup
    WebElement passwordInputQ;
    public void sendKeysPasswordInputQ(String password) {
        try {
            basePage.sendKeysIfElementVisible(passwordInputQ, password);
        } catch (Exception e) {
            logger.info("Cant find element passwordInputQ");
        }
    }
    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//span[1]")
    @CacheLookup
    WebElement errorMessagePasswordInputQ;
    public String getTextErrorMessagePasswordInputQ() {
        try {
            return basePage.getText(errorMessagePasswordInputQ);
        } catch (Exception e) {
            return "Cant find element errorMessagePasswordInputQ";
        }
    }



    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//label[2]")
    @CacheLookup
    WebElement labelConfirmPasswordInputQ;
    public String getTextLabelConfirmPasswordInputQ() {
        try {
            return basePage.getText(labelConfirmPasswordInputQ);
        } catch (Exception e) {
            return "Cant find element labelConfirmPasswordInputQ";
        }
    }
    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//input[2]")
    @CacheLookup
    WebElement confirmPasswordInputQ;
    public void sendKeysConfirmPasswordInputQ(String confirmPassword) {
        try {
            basePage.sendKeysIfElementVisible(confirmPasswordInputQ, confirmPassword);
        } catch (Exception e) {
            logger.info("Cant find element confirmPasswordInputQ");
        }
    }
    @FindBy(xpath = "//div[@class='password_form_field_top password_form_field_top_quick']//span[2]")
    @CacheLookup
    WebElement errorMessageConfirmPasswordInputQ;
    public String getTextErrorMessageConfirmPasswordInputQ() {
        try {
            return basePage.getText(errorMessageConfirmPasswordInputQ);
        } catch (Exception e) {
            return "Cant find element errorMessagePasswordInputQ";
        }
    }




    // Type checkBox Terms Conditions
    @FindBy(xpath = "//span[@class='reg-conditions']")
    @CacheLookup
    WebElement labelTermsConditionsQ;
    public String getTextLabelTermsConditionsQ() {
        try {
            return basePage.getText(labelTermsConditionsQ);
        } catch (Exception e) {
            return "Cant find element labelTermsConditionsQ";
        }
    }
    @FindBy(xpath = "//span[@class='reg-conditions']//a")
    @CacheLookup
    WebElement linkTermsConditionsQ;
    public void clickOnLinkTermsConditionsQ() {
        try {
            basePage.waitElementToBeVisible(linkTermsConditionsQ);
            basePage.javaScriptClick(linkTermsConditionsQ);
        } catch (Exception e) {
            logger.info("Cant find element linkTermsConditionsQ");
        }
    }
    @FindBy(xpath = "//input[@id='acceptTerms']")
    @CacheLookup
    WebElement checkBoxTermsConditionsQ;
    public void clickOnCheckBoxTermsConditionsQ() {
        try {
            basePage.waitElementToBeVisible(checkBoxTermsConditionsQ);
            basePage.javaScriptClick(checkBoxTermsConditionsQ);
        } catch (Exception e) {
            logger.info("Cant find element checkBoxTermsConditionsQ");
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

//    @FindBy(xpath = "//select[@class='custom_dropdown_reg ng-pristine ng-valid ng-touched']")      //need to be changed
//    @CacheLookup
//    WebElement genderDropDownF;
//
//    public void SelectFromGenderDropDownF(String text) {
//        try {
//            basePage.waitElementToBeVisible(genderDropDownF);
//            basePage.selectFromDropDownByVisibleText(genderDropDownF, text);
//        } catch (Exception e) {
//
//        }
//    }
//
//    public String getPlaceHolder() {
//        try {
//            basePage.waitElementToBeVisible(genderDropDownF);
//            return basePage.getAttribute(genderDropDownF, "placeholder");
//
//        } catch (Exception e) {
//            return "Cant find element or Attribute genderDropDownF/PlaceHolder";
//        }
//    }


    //FirstName Full Reg
    @FindBy(xpath = "//div[@data-id='register-item-FirstName']//label")
    @CacheLookup
    WebElement labelFirstNameF;
    public String getTextLabelFirstName() {
        try {
            return basePage.getText(labelFirstNameF);
        } catch (Exception e) {
            return "Cant find element labelFirstName";
        }
    }
    public boolean labelFirstNameFIsVisible() {
        try {
            return basePage.waitElementToBeVisibleBoolean(labelFirstNameF);
        } catch (Exception e) {
            return false;
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-FirstName']//input")
    @CacheLookup
    WebElement inputFirstNameF;
    public void sendKeysInputFirstNameF(String firstName) {
        try {
            basePage.sendKeysIfElementVisible(inputFirstNameF, firstName);
        } catch (Exception e) {
            logger.info("Cant find element inputFirstNameF");
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-FirstName']//span")
    @CacheLookup
    WebElement errorMessageFirstNameF;
    public String getTextErrorMessageFirstNameF() {
        try {
            return basePage.getText(errorMessageFirstNameF);
        } catch (Exception e) {
            return "Cant find element errorMessageFirstNameF";
        }
    }
    public boolean errorMessageFirstNameFIsVisible() {
        try {
            return basePage.waitElementToBeVisibleBoolean(errorMessageFirstNameF);
        } catch (Exception e) {
            return false;
        }
    }


    //LastName Full Reg
    @FindBy(xpath = "//div[@data-id='register-item-LastName']//label")
    @CacheLookup
    WebElement labelLastName;
    public String getTextLabelLastName() {
        try {
            return basePage.getText(labelLastName);
        } catch (Exception e) {
            return "Cant find element labelLastName";
        }
    }
    public boolean labelLastNameFIsVisible() {
        try {
            return basePage.waitElementToBeVisibleBoolean(labelLastName);
        } catch (Exception e) {
            return false;
        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-LastName']//input")
    @CacheLookup
    WebElement inputLastNameF;
    public void sendKeysInputLastNameF(String lastName) {
        try {
            basePage.sendKeysIfElementVisible(inputLastNameF, lastName);
        } catch (Exception e) {

        }
    }
    @FindBy(xpath = "//div[@data-id='register-item-LastName']//span")
    @CacheLookup
    WebElement errorMessageLastNameF;
    public String getTextErrorMessageLastNameF() {
        try {
            return basePage.getText(errorMessageLastNameF);
        } catch (Exception e) {
            return "Cant find element errorMessageLastNameF";
        }
    }
    public boolean errorMessageLastNameFIsVisible() {
        try {
            return basePage.waitElementToBeVisibleBoolean(errorMessageLastNameF);
        } catch (Exception e) {
            return false;
        }
    }


    // Type - Mobile Full_Reg
    @FindBy(xpath = "//ul[@data-id='register-mobile-codes']")
    @CacheLookup
    WebElement mobileDropDownF;
    public void clickOnMobileDropDownF() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownF);
            basePage.javaScriptClick(mobileDropDownF);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownF");
        }

    }
    public void SelectFromMobileDropDownByVisibleTextF(String text) {
        try {
            basePage.waitElementToBeVisible(mobileDropDownF);
            basePage.selectFromDropDownByVisibleText(mobileDropDownF, text);
        } catch (Exception e) {
            logger.info("Cant find element mobileDropDownF");
        }
    }
    public void SelectFromMobileDropDownByIndexF(int index) { //index starts from 0
        try {
            basePage.waitElementToBeVisible(mobileDropDownF);
            basePage.selectFromDropDownByIndex(mobileDropDownF, index);
        } catch (Exception e) {
            logger.info("SelectFromMobileDropDownByIndexF(int index) method has an exception: " + e);
        }
    }
    public String getTextFromMobileDropDownF() {
        try {
            return basePage.getSelectedItemText(basePage.createSelectElement(mobileDropDownF));
        } catch (Exception e) {
            return "Cant find element currencyDropDownF";
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-AM']")
    @CacheLookup
    WebElement mobileDropDownFAM;
    public void clickOnMobileDropDownFAM() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownFAM);
            basePage.javaScriptClick(mobileDropDownFAM);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownFAM");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-RU']")
    @CacheLookup
    WebElement mobileDropDownFRU;
    public void clickOnMobileDropDownFRU() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownFRU);
            basePage.javaScriptClick(mobileDropDownFRU);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownFRU");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-GB']")
    @CacheLookup
    WebElement mobileDropDownFGB;
    public void clickOnMobileDropDownFGB() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownFGB);
            basePage.javaScriptClick(mobileDropDownFGB);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownFGB");
        }
    }
    @FindBy(xpath = "//li[@data-id='register-code-DE']")
    @CacheLookup
    WebElement mobileDropDownFDE;
    public void mobileDropDownFDE() {
        try{
            basePage.waitElementToBeVisible(mobileDropDownFDE);
            basePage.javaScriptClick(mobileDropDownFDE);
        }
        catch (Exception e){
            logger.info("Cant find element mobileDropDownFDE");
        }
    }
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//span")
    List<WebElement> mobileCodesTextListF;
    public List<WebElement> getMobileCodesTextListF() {
        try{
            return mobileCodesTextListF;
        }
        catch(Exception e){
            logger.error("getMobileCodesTextListF() method has an Exception: " + e);
        }
        return null;
    }
    @FindBy(xpath = "//*[@data-id='register-mobile-codes']//img")
    List<WebElement> mobileCodesImgListF;
    public List<WebElement> getMobileCodesImgListF() {
        try{
            return mobileCodesImgListF;
        }
        catch(Exception e){
            logger.error("getMobileCodesImgListF() method has an Exception: " + e);
        }
        return null;
    }
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//label")
    @CacheLookup
    WebElement labelMobileInputF;
    public String getTextLabelMobileInputF() {
        try {
            return basePage.getText(labelMobileInputF);
        } catch (Exception e) {
            return "Cant find element labelMobileInputF";
        }
    }
    @FindBy(xpath = "//div[@data-id='register-mobile-number']//input")
    @CacheLookup
    WebElement mobileInputF;
    public void sendKeysMobileInputF(String number) {
        try {
            basePage.sendKeysIfElementVisible(mobileInputF, number);
        } catch (Exception e) {
            logger.info("Cant find element mobileInputF");
        }
    }
    public String mobileInputFInputIsValid(){
        String classAttribute = null;
        try {
            classAttribute = basePage.getAttribute(mobileInputF,"class");
        }
        catch (Exception e){
            logger.info("Cant get class Attribute mobileInputF");
        }
        return classAttribute;
    }
    public String getErrorMobileInputF() {
        String error = null;
        try {
            error = basePage.getText(mobileInputF);
        } catch (Exception e) {
            logger.info("Cant get Error message mobileInputF");
        }
        return error;
    }
    @FindBy(xpath = "//div[@class='mobileData_tabs']/following::span[@class='error-field-message']")
    @CacheLookup
    WebElement mobileInputFErrorMessage;
    public String getTextErrorMessageMobileInputF() {
        try {
            return basePage.getText(mobileInputFErrorMessage);
        } catch (Exception e) {
            return "Cant find element mobileInputFErrorMessage";
        }
    }



    // Type - BirthDay Full_Reg





    @FindBy(xpath = "//div[@data-id='register-item-BirthDay']//select[1]")
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

    @FindBy(xpath = "//div[@data-id='register-item-BirthDay']//select[2]")
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

    @FindBy(xpath = "//div[@data-id='register-item-BirthDay']//select[3]")
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
