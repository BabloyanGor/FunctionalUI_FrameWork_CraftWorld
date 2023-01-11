package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftWorld_0000_Login_PopUp_Page extends BasePage {
    private final BasePage basePage;

    public CraftWorld_0000_Login_PopUp_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }


    @FindBy(xpath = "//div[contains (@class, 'email')]//input")
    @CacheLookup
    WebElement loginEmailInputField;

    public boolean isVisibleLoginPopUpEmailInputField() {
        try {
            return waitElementToBeVisibleBoolean(loginEmailInputField);
        } catch (Exception e) {
            return false;
        }

    }

    public void sendKeysLoginEmailInputField(String keys) {
        try {
            sendKeysIfElementVisible(loginEmailInputField, keys);
        } catch (Exception e) {
            logger.error("sendKeysLoginEmailInputField(String keys) method has an Exception: " + e);
        }
    }

    public String getAttributePlaceHolderLoginEmailInputField() {
        try {
            return getAttribute(loginEmailInputField, "placeholder");
        } catch (Exception e) {
            logger.error("Login Email field: There is no placeholder attribute: getAttributePlaceHolderLoginEmailInputField()" + e);
            return "Login Email field: There is no placeholder attribute";
        }
    }

    public String getAttributeTypeEmailInput() {
        try {
            return basePage.getAttribute(loginEmailInputField, "type");
        } catch (Exception e) {
            logger.error("Login Email field: There is no type attribute: getAttributeTypeEmailInput()" + e);
            return "Login Email field: There is no type attribute";
        }
    }


    @FindBy(xpath = "//div[contains (@class, 'password')]//input")
    @CacheLookup
    WebElement loginPasswordInputField;

    public boolean isVisibleLoginPasswordInputField() {
        try {
            return waitElementToBeVisibleBoolean(loginPasswordInputField);
        } catch (Exception e) {
            return false;
        }
    }

    public void sendKeysLoginPasswordInputField(String keys) {
        try {
            sendKeysIfElementVisible(loginPasswordInputField, keys);
        } catch (Exception e) {
            logger.error("sendKeysLoginPasswordInputField(String keys) method has an Exception: " + e);
        }
    }

    public String getAttributePlaceHolderLoginPasswordInputField() {
        try {
            return getAttribute(loginPasswordInputField, "placeholder");
        } catch (Exception e) {
            logger.error("Login Email field: There is no placeholder attribute: getAttributePlaceHolderLoginPasswordInputField()" + e);
            return "There is no placeholder attribute";
        }
    }

    public String getAttributeTypePasswordInput() {
        try {
            return basePage.getAttribute(loginPasswordInputField, "type");
        } catch (Exception e) {
            logger.error("Login Password field: There is no type attribute: getAttributeTypePasswordInput()" + e);
            return "Login Password field: There is no type attribute";
        }
    }


    @FindBy(xpath = "//button[contains (@class, 'login_btn')]")
    @CacheLookup
    WebElement LoginButton;

    public void clickOnLLoginButton() {
        try {
            basePage.waitElementToBeVisible(LoginButton);
            basePage.clickOnElementIfClickable(LoginButton);
        } catch (Exception e) {
            logger.error("clickOnLLoginButton()  method has an Exception: " + e);

        }
    }

    public void clickOnLoginButtonJS() {
        try {
            basePage.waitElementToBeVisible(LoginButton);
            basePage.javaScriptClick(LoginButton);
        } catch (Exception e) {
            logger.error("clickOnLoginButtonJS() method has an Exception: " + e);

        }
    }


    @FindBy(xpath = "//*[@class='login-title']")
    @CacheLookup
    WebElement loginPopUpHeader;

    public String getLoginPopUpHeader() {
        try {
            return basePage.getText(loginPopUpHeader);
        } catch (Exception e) {
            logger.error("Login Header : There is no Header element:getLoginPopUpHeader()" + e);
            return "Login Header : There is no Header element:getLoginPopUpHeader()" + e;
        }
    }

    @FindBy(xpath = "//*[@class='icon-close-modal']")
    @CacheLookup
    WebElement loginPopUpCloseButton;

    public boolean checkLoginPopUpCloseButtonVisibility() {
        try {
            basePage.waitElementToBeVisible(loginPopUpCloseButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnLoginPopUpCloseButton() {
        try {
            basePage.waitElementToBeVisible(loginPopUpCloseButton);
            basePage.clickOnElementIfClickable(loginPopUpCloseButton);
        } catch (Exception e) {
            logger.error("clickOnLoginPopUpCloseButton() method has an Exception: " + e);
        }
    }

    @FindBy(xpath = "//img[@class='login-logo']")
    @CacheLookup
    WebElement loginPopUpLogo;

    public boolean loginPopUpLogoPresence() {
        try {
            return basePage.waitElementToBeVisibleBoolean(loginPopUpLogo);
        } catch (Exception e) {
            return false;
        }
    }


    @FindBy(xpath = "//span[@class='icon-eye-password-close']")
    @CacheLookup
    WebElement loginEyeShowPassword;

    public boolean checkLoginEyeButtonVisibility() {
        try {
            basePage.waitElementToBeVisible(loginEyeShowPassword);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLoginEyeShowPassword() {
        try {
            basePage.waitElementToBeVisible(loginEyeShowPassword);
            basePage.clickOnElementIfClickable(loginEyeShowPassword);
        } catch (Exception e) {
            logger.error("clickLoginPopUpEyeShowPassword() method has an Exception: " + e);
        }
    }


    @FindBy(xpath = "//a[@class='forgot_password login-section-forgot_password']")
    @CacheLookup
    WebElement loginForgotPasswordLink;

    public boolean checkLoginForgotPasswordLinkVisibility() {
        try {
            basePage.waitElementToBeVisible(loginForgotPasswordLink);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLoginForgotPasswordLink() {
        try {
            basePage.waitElementToBeVisible(loginForgotPasswordLink);
            basePage.clickOnElementIfClickable(loginForgotPasswordLink);
        } catch (Exception e) {
            logger.error("clickLoginPopUpForgotPassword() method has an Exception: " + e);

        }
    }

    @FindBy(xpath = "//div[@class='login_PSection_redirect']//child::a")
    @CacheLookup
    WebElement loginPopUpSignUpLink;

    public boolean checkLoginPopUpSignUpLinkVisibility() {
        try {
            basePage.waitElementToBeVisible(loginPopUpSignUpLink);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLoginPopUpSignUpLink() {
        try {
            basePage.waitElementToBeVisible(loginPopUpSignUpLink);
            basePage.clickOnElementIfClickable(loginPopUpSignUpLink);
        } catch (Exception e) {
            logger.error("clickLoginPopUpSignUpLink() method has an Exception: " + e);

        }
    }

    @FindBy(xpath = "//*[@class='error_message']")
    @CacheLookup
    WebElement loginErrorMessage;

    public String loginErrorMessageGetText() {
        try {
            return basePage.getText(loginErrorMessage);
        } catch (Exception e) {
            return "There is no loginErrorMessage element";
        }
    }

    public boolean LoginErrorMessageTextIsNotEmpty() {
        try {
            basePage.waitElementToBeVisible(loginErrorMessage);
            if (basePage.getText(loginErrorMessage).isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            logger.error("checkLoginErrorMessageVisibility() method has an Exception: " + e);
            return false;
        }
    }



//    @FindBy(xpath = "//input[@id='remeberMe']")
//    @CacheLookup
//    WebElement loginPopUpRememberMeCheckbox;
//    @FindBy(xpath = "//label[@class='reg-conditions']")
//    @CacheLookup
//    WebElement loginPopUpRememberMeLabel;
//    @FindBy(xpath = "//*[@class='social-login-text']")
//    @CacheLookup
//    WebElement loginPopUpYouCanSignUpWithLabel;
//    @FindBy(xpath = "/html/body/app-root/simple-modal-holder/simple-modal-wrapper/div/app-app-confirm/div/div[2]/div/app-login/div/form/ul/li[2]")
//    @CacheLookup
//    WebElement loginPopUpYouCanSignUpWithGoogle;
//    @FindBy(xpath = "/html/body/app-root/simple-modal-holder/simple-modal-wrapper/div/app-app-confirm/div/div[2]/div/app-login/div/form/ul/li[1]")
//    @CacheLookup
//    WebElement loginPopUpYouCanSignUpWithFaceBook;
//    @FindBy(xpath = "/html/body/app-root/simple-modal-holder/simple-modal-wrapper/div/app-app-confirm/div/div[2]/div/app-login/div/form/ul/li[3]")
//    @CacheLookup
//    WebElement loginPopUpYouCanSignUpWithTelegram;
//    @FindBy(xpath = "/html/body/app-root/simple-modal-holder/simple-modal-wrapper/div/app-app-confirm/div/div[2]/div/app-login/div/form/ul/li[4]")
//    @CacheLookup
//    WebElement loginPopUpYouCanSignUpWithInstagram;

//    @FindBy(xpath = "//*[@class = 'login_PSection_redirect']//child::div")
//    @CacheLookup
//    WebElement loginPopUpDoNotHaveAccountLabel;


//    @FindBy(xpath = "//span[@class='login-safety-text']")
//    @CacheLookup
//    WebElement loginPopUpSaveAndSecureLabel;


//    public boolean loginPopUpRememberMeCheckboxIsSelected() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpRememberMeCheckbox);
//            return basePage.elementIsSelected(loginPopUpRememberMeCheckbox);
//        }
//        catch(Exception e){
//            return basePage.elementIsSelected(loginPopUpRememberMeCheckbox);
//        }
//    }
//
//    public void clickLoginPopUpRememberMeLabel() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpRememberMeLabel);
//            basePage.clickOnElementIfClickable(loginPopUpRememberMeLabel);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public String loginPopUpRememberMeLabelGetText() {
//        try{
//            return basePage.getText(loginPopUpRememberMeLabel);
//        }
//        catch(Exception e){
//            return "There is no loginPopUpRememberMeLabel element";
//        }
//    }
//
//
//    public String loginPopUpYouCanSignUpWithLabelGetText() {
//        try{
//            return basePage.getText(loginPopUpYouCanSignUpWithLabel);
//        }
//        catch(Exception e){
//            return "There is no loginPopUpYouCanSignUpWithLabel element";
//        }
//    }
//
//    public void clickLoginPopUpYouCanSignUpWithGoogle() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpYouCanSignUpWithGoogle);
//            basePage.clickOnElementIfClickable(loginPopUpYouCanSignUpWithGoogle);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public void clickLoginPopUpYouCanSignUpWithFaceBook() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpYouCanSignUpWithFaceBook);
//            basePage.clickOnElementIfClickable(loginPopUpYouCanSignUpWithFaceBook);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public void clickLoginPopUpYouCanSignUpWithTelegram() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpYouCanSignUpWithTelegram);
//            basePage.clickOnElementIfClickable(loginPopUpYouCanSignUpWithTelegram);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public void clickLoginPopUpYouCanSignUpWithInstagram() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpYouCanSignUpWithInstagram);
//            basePage.clickOnElementIfClickable(loginPopUpYouCanSignUpWithInstagram);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public void clickLoginPopUpLogInButton() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpLogInButton);
//            basePage.clickOnElementIfClickable(loginPopUpLogInButton);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public boolean isClickableLoginPopUpLogInButton() {
//        try{
//            if (basePage.elementIsEnable(loginPopUpLogInButton)) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        catch (Exception e){
//            if (basePage.elementIsEnable(loginPopUpLogInButton)) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
//
//
//    public String loginPopUpLoginButtonGetText() {
//        try{
//            return basePage.getText(loginPopUpLogInButton);
//        }
//        catch(Exception e){
//            return "There is no loginPopUpLogInButton element";
//        }
//    }
//
//
//    public String loginPopUpDoNotHaveAccountLabelGetText() {
//        try{
//            return basePage.getText(loginPopUpDoNotHaveAccountLabel);
//        }
//        catch(Exception e){
//            return "There is no loginPopUpDoNotHaveAccountLabel element";
//        }
//    }
//
//    public void clickLoginPopUpSignUpLink() {
//        try{
//            basePage.waitElementToBeVisible(loginPopUpSignUpLink);
//            basePage.clickOnElementIfClickable(loginPopUpSignUpLink);
//        }
//        catch(Exception e){
//        }
//    }
//
//    public String loginPopUpSaveAndSecureLabelGetText() {
//        try{
//            return basePage.getText(loginPopUpSaveAndSecureLabel);
//        }
//        catch(Exception e){
//            return "There is no loginPopUpSaveAndSecureLabel element";
//        }
//    }


}
