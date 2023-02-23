package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.API_ConfigJson;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CraftWorld_03_SignUpQuickRegisterTest extends BaseTest {


    public CraftWorld_03_SignUpQuickRegisterTest() throws AWTException {
    }


    int k = 10;
    private JSONArray jsonArraySubmenu1 = null;
    private JSONArray jsonArraySubmenu2 = null;

    private String Icon = null;
    private String Title = null;
    private String Type = null;
    private String Href = null;
    private String hrefSize  = null;
    private String hrefMandatory = null;
    private String hrefHasLabel = null;
    private boolean OpenInRouting = false;
    private int Order = 0;
//    private String StyleType = null;

//    private String Icon2 = null;
//    private String Title2 = null;
//    private String Type2 = null;
//    private String Href2 = null;
//    private boolean OpenInRouting2 = false;
//    private int Order2 = 0;
//    private String StyleType2 = null;

    private int regType1SubmenusCount = 0;
    private int regType2SubmenusCount = 0;

    private void parseRegisterSubmenuItem(int submenuNum) {
        String jsonSubmenu = String.valueOf(jsonArraySubmenu1.get(submenuNum));
        JSONObject jsonObject = new JSONObject(jsonSubmenu);
        Icon = jsonObject.getString("Icon");
        Title = jsonObject.getString("Title");
        Type = jsonObject.getString("Type");
        Href = jsonObject.getString("Href");
        JSONObject jsonObjectHref =new JSONObject(Href);
        hrefSize = jsonObjectHref.getString("size");
        hrefMandatory = jsonObjectHref.getString("mandatory");
        hrefHasLabel = jsonObjectHref.getString("hasLabel");


        OpenInRouting = jsonObject.getBoolean("OpenInRouting");
        Order = jsonObject.getInt("Order");
    }


    @BeforeMethod
    public void goToRegistrationPopUp() {
        try{
            api_menusJson.registration();

            craftWorld_0001_header_1.clickOnHeader1SignUpButton();

            if (API_ConfigJson.getRegistrationTypesCount() == 1) {
                String jsonObjectString = String.valueOf(api_menusJson.getJsonArrayRegistration().get(0));
                JSONObject jsonObject = new JSONObject(jsonObjectString);
                jsonArraySubmenu1 = jsonObject.getJSONArray("SubMenu"); // jsonArraySubmenu1 _ Array list all submenus firstRegForm
                regType1SubmenusCount = jsonArraySubmenu1.length();  // regType1SubmenusCount _ how many fields have firstRegForm


            } else if (API_ConfigJson.getRegistrationTypesCount() == 2) {
                String jsonObjectString = String.valueOf(api_menusJson.getJsonArrayRegistration().get(0));
                JSONObject jsonObject = new JSONObject(jsonObjectString);
                jsonArraySubmenu1 = jsonObject.getJSONArray("SubMenu"); // jsonArraySubmenu1 _ Array list all submenus firstRegForm
                regType1SubmenusCount = jsonArraySubmenu1.length();   // regType1SubmenusCount _ how many fields have firstRegForm


                String jsonObjectString1 = String.valueOf(api_menusJson.getJsonArrayRegistration().get(1));
                JSONObject jsonObject1 = new JSONObject(jsonObjectString1);
                jsonArraySubmenu2 = jsonObject1.getJSONArray("SubMenu"); // jsonArraySubmenu2 _ Array list all submenus secondRegForm
                regType2SubmenusCount = jsonArraySubmenu2.length();  // regType2SubmenusCount _ how many fields have secondRegForm

            } else {
                logger.info("Reg form has a additional reg form implemented");
            }
            regTypesCount = API_ConfigJson.getRegistrationTypesCount();
            firstRegFormNameByOrder = API_ConfigJson.getRegistrationTypesFirstRegFormName();
            secondRegFormNameByOrder = API_ConfigJson.getRegistrationTypesSecondRegFormName();
            firstRegAutologinIsTrue = API_ConfigJson.isRegistrationTypeFirstIsAutologinOn();
            secondRegAutologinIsTrue = API_ConfigJson.isRegistrationTypeSecondIsAutologinOn();
            currencies = API_ConfigJson.getCurrenciesArrayList();
        }
        catch(Exception e){
            logger.error("Registration  @BeforeMethod has an exception");
        }

    }

    private int regTypesCount;
    private String firstRegFormNameByOrder;
    private String secondRegFormNameByOrder;
    private boolean firstRegAutologinIsTrue;
    private boolean secondRegAutologinIsTrue;
    private ArrayList currencies;


    @Test(priority = 1, description = "")
    @Description("")
    @Severity(SeverityLevel.BLOCKER)
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        API_ConfigJson.getCurrenciesArrayList();

//        for (String i : api_configJson.getMobileTitlesCodesArrayList()){
//            System.out.println(i);
//        }
//        for (int j : API_ConfigJson.getMobileMaskCountArrayList()){
//            System.out.println(j);
//        }



        if (regTypesCount == 1 && firstRegFormNameByOrder.equals("Quick-Register"))
        {
            for (int i = 0; i < regType1SubmenusCount; i++) {
                parseRegisterSubmenuItem(i);
                switch (Type) {
                    case "info": {
                        logger.info("RegForm input field num: " + i + "  Type is info");

                        break;
                    }
                    case "dropdown": {
                        logger.info("RegForm input field num: " + i + "  Type is dropdown");
                        if (Title.equals("RegisterTypes")){                                 //  "Email" /  "Mobile"

                        }
                        else{
                            logger.warn("regForm Unknown dropdown: " + Title);
                        }




                            System.out.println(Icon + Title + Type + Href + OpenInRouting + Order);

                        break;
                    }
                    case "Email": {
                        logger.info("RegForm input field num: " + i + "  Type is Email");

                        break;
                    }

                    case "MobileData": {
                        logger.info("RegForm input field num: " + i + "  Type is MobileData");

                        break;
                    }
                    case "Currency": {
                        logger.info("RegForm input field num: " + i + "  Type is Currency");

                        break;
                    }
                    case "checkbox": {
                        logger.info("RegForm input field num: " + i + "  Type is checkbox");

                        break;
                    }
                    case "Gender": {
                        logger.info("RegForm input field num: " + i + "  Type is Gender");

                        break;
                    }
                    case "text": {
                        logger.info("RegForm input field num: " + i + "  Type is text");

                        break;
                    }
                    case "BirthDate": {
                        logger.info("RegForm input field num: " + i + "  Type is BirthDate");

                        break;
                    }
                    case "Region2": {
                        logger.info("RegForm input field num: " + i + "  Type is Region2");

                        break;
                    }
                    case "Region3": {
                        logger.info("RegForm input field num: " + i + "  Type is Region3");

                        break;
                    }
                    case "password": {
                        logger.info("RegForm input field num: " + i + "  Type is password");

                        break;
                    }
                    case "verify-sms": {
                        logger.info("RegForm input field num: " + i + "  Type is verify-sms");

                        break;
                    }
                    case "verify-email": {
                        logger.info("RegForm input field num: " + i + "  Type is verify-email");

                        break;
                    }
                    case "security-questions": {
                        logger.info("RegForm input field num: " + i + "  Type is security-questions");

                        break;
                    }
                    case "file": {
                        logger.info("RegForm input field num: " + i + "  Type is file");

                        break;
                    }
                    case "select": {
                        logger.info("RegForm input field num: " + i + "  Type is select");

                        break;
                    }
                    default: {
                    }

                }


            }

        }

        else if (regTypesCount == 1 && firstRegFormNameByOrder.equals("Full-Register")) {


        } else if (regTypesCount == 2 && firstRegFormNameByOrder.equals("Quick-Register")) {


        } else if (regTypesCount == 2 && firstRegFormNameByOrder.equals("Full-Register")) {


        }

        parseRegisterSubmenuItem( 0);
        System.out.println("<<<<<  " + Icon + "  <<<<<  " + Title + "  <<<<<  " + Type + "  <<<<<  " + Href + "  <<<<<  " + OpenInRouting + "  <<<<<  " + Order);
    }


//    @Test(priority = 1, description = "Validate SignUp PopUps labels")
//    @Description("Validate SignUp PopUps labels")
//    @Severity(SeverityLevel.MINOR)
//    public void SignUpPopUpQuickRegisterLabelsPresenceVerification_Test() {
//        SoftAssert softAssert = new SoftAssert();
//        String actTitle = craftWorld_05_signUp_popUp_page.getTitleQ();
//        logger.info("Title Captured: --->" + actTitle);
//        String expectedTitle = "Quick Register";
//        logger.info("Title expected: --->" + expectedTitle);
//        String actEmailDropDownLabel = craftWorld_05_signUp_popUp_page.getTextLabelEmailMobileDropDownQ();
//        logger.info("actEmailDropDownLabel Captured: --->" + actEmailDropDownLabel);
//        String expectedEmailDropDownLabel = "Register By";
//        logger.info("Email Drop Down expected label: --->" + expectedEmailDropDownLabel);
//        String actEmailInputLabel = craftWorld_05_signUp_popUp_page.getTextLabelEmailInputQ();
//        logger.info("actEmailInputLabel Captured: --->" + actEmailInputLabel);
//        String expectedEmailInputLabel = "Email";
//        logger.info("Email input expected label: --->" + expectedEmailInputLabel);
//        String actCurrencyLabel = craftWorld_05_signUp_popUp_page.getTextLabelCurrencyDropDownQ();
//        logger.info("actCurrencyLabel Captured: --->" + actCurrencyLabel);
//        String expectedCurrencyLabel = "Currency";
//        logger.info("Currency drop down expected label: --->" + expectedCurrencyLabel);
//        String actTermsLabel = craftWorld_05_signUp_popUp_page.getTextLabelTermsConditionsQ();
//        logger.info("actTermsLabel Captured: --->" + actTermsLabel);
//        String expectedTermsLabel = "I have read and accept the Terms & Conditions and Privacy Policy and I agree that I am at least 21 years of age.";
//        logger.info("Terms and Conditions expected label: --->" + expectedTermsLabel);
//        String actRegisterButtonText = craftWorld_05_signUp_popUp_page.getTextButtonRegisterQ();
//        logger.info("actRegisterButtonText Captured: --->" + actRegisterButtonText);
//        String expectedRegisterButtonText = "REGISTER";
//        logger.info("RegisterButton expected label: --->" + expectedRegisterButtonText);
//        String actAlreadyHaveAccount = craftWorld_05_signUp_popUp_page.getTextLabelAlreadyHaveAnAccount();
//        logger.info("actAlreadyHaveAccount Captured: --->" + actAlreadyHaveAccount);
//        String expectedAlreadyHaveAccount = "Already have an account? Log In";
//        logger.info("AlreadyHaveAccount expected label: --->" + expectedAlreadyHaveAccount);
//        String actPleaseFillLabel = craftWorld_05_signUp_popUp_page.getTextLabelPleaseFill();
//        logger.info("actPleaseFillLabel Captured: --->" + actPleaseFillLabel);
//        String expectedPleaseFillLabel = "Please fill in all fields of this form.";
//        logger.info("Please fill expected label: --->" + expectedPleaseFillLabel);
////        String actSwitchButtonLabel = craftBet_signUp_popUp_page.getTextButtonSwitchQuickFullRegistration();
////        logger.info("actSwitchButtonLabel Captured: --->" + actSwitchButtonLabel);
////        String expectedSwitchButtonLabel = "Full Register";
////        logger.info("Please fill expected label: --->" + expectedSwitchButtonLabel);
//        String actThisSiteProtected = craftWorld_05_signUp_popUp_page.getTextLabelThisSiteProtected();
//        logger.info("actThisSiteProtected Captured: --->" + actThisSiteProtected);
//        String expectedThisSiteProtected = "This site is protected by recaptcha and the Google Privacy Policy and Terms of Service apply. Select a social network and permit the use of your profile info for Craftbet registration";
//        logger.info("expectedThisSiteProtected: --->" + expectedThisSiteProtected);
//        String actSafeAndSecureLabel = craftWorld_05_signUp_popUp_page.getTextLabelSafeAndSecure();
//        logger.info("actSafeAndSecureLabel Captured: --->" + actSafeAndSecureLabel);
//        String expectedSafeAndSecureLabel = "Safe and Secure";
//        logger.info("expectedSafeAndSecureLabel: --->" + expectedSafeAndSecureLabel);
//
//
//        softAssert.assertEquals(actTitle, expectedTitle);
//        logger.info("Title checked");
//        softAssert.assertEquals(actEmailDropDownLabel, expectedEmailDropDownLabel);
//        logger.info("Email DropDown label checked");
//        softAssert.assertEquals(actEmailInputLabel, expectedEmailInputLabel);
//        logger.info("Email input label checked");
//        softAssert.assertEquals(actCurrencyLabel, expectedCurrencyLabel);
//        logger.info("Currency drop down label checked");
//        softAssert.assertEquals(actTermsLabel, expectedTermsLabel);
//        logger.info("Terms and Conditions input label checked");
//        softAssert.assertEquals(actRegisterButtonText, expectedRegisterButtonText);
//        logger.info("Register button label checked");
//        softAssert.assertEquals(actAlreadyHaveAccount, expectedAlreadyHaveAccount);
//        logger.info("AlreadyHaveAccount label checked");
//        softAssert.assertEquals(actPleaseFillLabel, expectedPleaseFillLabel);
//        logger.info("PleaseFillLabel label checked");
////        softAssert.assertEquals(actSwitchButtonLabel, expectedSwitchButtonLabel);
////        logger.info("SwitchButtonLabel label checked");
//        softAssert.assertEquals(actThisSiteProtected, expectedThisSiteProtected);
//        logger.info("ThisSiteProtected label checked");
//        softAssert.assertEquals(actSafeAndSecureLabel, expectedSafeAndSecureLabel);
//        logger.info("SafeAndSecureLabel label checked");
//
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 2, description = "Validate on Sign Up Pop Up Logo Presence")
//    @Description("Validate on Sign Up Pop Up Logo Presence")
//    @Severity(SeverityLevel.MINOR)
//    public void SignUpPopUpQuickRegisterLogoPresenceVerification_Test() {
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.BackgroundPhotoPresence(), true);
//        logger.info("Background photo existence checked");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.logoPresence(), true);
//        logger.info("Logo existence checked");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 3, description = "Validate on Sign Up Pop Up Email/Mobile Drop down functionality")
//    @Description("Validate on Sign Up Pop Up Email/Mobile Drop down functionality")
//    @Severity(SeverityLevel.NORMAL)
//    public void SignUpPopUpQuickRegisterRegisterByDropDownVerification_Test() {
//        SoftAssert softAssert = new SoftAssert();
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Email");
//        logger.info("From Email/Mobile DropDown select Email");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextLabelEmailInputQ(), "Email");
//        logger.info("From Email Input get text");
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Mobile");
//        logger.info("From Email/Mobile DropDown select Mobile");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextLabelMobileInputQ(), "Mobile");
//        logger.info("From Mobile Input get text");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 4, description = "Validate on Sign Up Pop Up Currency Drop down functionality")
//    @Description("Validate on Sign Up Pop Up Currency Drop down functionality")
//    @Severity(SeverityLevel.NORMAL)
//    public void SignUpPopUpQuickRegisterCurrencyDropDownVerification_Test() {
//        SoftAssert softAssert = new SoftAssert();
//        craftWorld_05_signUp_popUp_page.selectFromCurrencyDropDownByVisibleTextQ("AMD");
//        logger.info("From Currency DropDown select AMD");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextFromCurrencyDropDownQ(), "AMD");
//        logger.info("From Currency DropDown getting text");
//        craftWorld_05_signUp_popUp_page.selectFromCurrencyDropDownByVisibleTextQ("EUR");
//        logger.info("From Currency DropDown select EUR");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextFromCurrencyDropDownQ(), "EUR");
//        logger.info("From Currency DropDown getting text");
//        craftWorld_05_signUp_popUp_page.selectFromCurrencyDropDownByVisibleTextQ("USD");
//        logger.info("From Currency DropDown select USD");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextFromCurrencyDropDownQ(), "USD");
//        logger.info("From Currency DropDown getting text");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 5, description = "Validate on Sign Up Pop Up Terms  and conditions check box need to be checked")
//    @Description("Validate on Sign Up Pop Up Terms  and conditions check box need to be checked")
//    @Severity(SeverityLevel.NORMAL)
//    public void SignUpPopUpQuickRegisterRegisterPrivacyPolicy() {
//        SoftAssert softAssert = new SoftAssert();
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Email");
//        logger.info("Email was selected From Email/Mobile DropDown ");
//        craftWorld_05_signUp_popUp_page.sendKeysEmailInputQ(craftWorld_05_signUp_popUp_page.generateRandomEmailValid());
//        logger.info("valid email was generated and passed ");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getAttributeClassButtonRegisterQ(), "craft_btn reg_btn active-item not_active");
//        logger.info("Register button activity checked without clicking on TermsAndConditions checkbox ");
//        craftWorld_05_signUp_popUp_page.clickOnCheckBoxTermsConditionsQ();
//        logger.info("Terms and conditions checkbox was selected");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getAttributeClassButtonRegisterQ(), "craft_btn reg_btn active-item");
//        logger.info("Register button activity checked with clicking on TermsAndConditions checkbox");
//        softAssert.assertAll();
//
//    }
//
//
//    @Test(priority = 5, description = "Validate on Sign Up Pop Up close(X) button functionality")
//    @Description("Validate on Sign Up Pop Up close(X) button functionality")
//    @Severity(SeverityLevel.NORMAL)
//    public void SignUpPopUpCloseButtonFunctionality() {
//        craftWorld_05_signUp_popUp_page.clickOnButtonCloseXButton();
//        logger.info("Close (X) button was clicked");
//        Assert.assertEquals(craftWorld_05_signUp_popUp_page.logoPresence(), false);
//    }
//
//    @Test(priority = 6, description = "Validate on Sign Up Pop Up Terms and conditions link functionality")
//    @Description("Validate on Sign Up Pop Up Terms and conditions link functionality")
//    @Severity(SeverityLevel.NORMAL)
//    public void SignUpPopUpTermsAndConditionsLinkFunctionality() {
//        craftWorld_05_signUp_popUp_page.clickOnLinkTermsConditionsQ();
//        logger.info("Terms and conditions link was clicked");
//        Assert.assertEquals(craftWorld_05_signUp_popUp_page.getUrl(), "https://craftbet.com/terms");
//    }
//
//
////    @Test(priority = 7, description = "Validate on Sign Up Pop Up LogIn link functionality")
////    @Description("Validate on Sign Up Pop Up LogIn link functionality")
////    @Severity(SeverityLevel.NORMAL)
////    public void SignUpPopUpLogInLinkFunctionality() {
////        craftWorld_05_signUp_popUp_page.clickOnLinkLogIn();
////        logger.info("LogIn  link was clicked");
////        Assert.assertEquals(craftWorld_0000_login_popUp_page.loginPopUpLogoPresence(), true);
////    }
//
//    @Test(priority = 8, description = "Validate on Sign Up Pop Up Quick/Full Register button functionality")
//    @Description("Validate on Sign Up Pop Up Quick/Full Register button functionality")
//    @Severity(SeverityLevel.BLOCKER)
//    public void SignUpPopUpQuickFullRegistrationButtonFunctionality() throws InterruptedException {
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTitleQ(), "Quick Register");
//        logger.info("Quick Register Title was captured");
//        craftWorld_05_signUp_popUp_page.clickOnButtonFullRegistration();
//        logger.info("Full Registration button was clicked");
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextLabelFirstName(), "First name");
//        logger.info("Full Register First Name label was captured");
//        craftWorld_05_signUp_popUp_page.clickOnButtonQuickRegistration();
//        softAssert.assertEquals(craftWorld_05_signUp_popUp_page.getTextLabelEmailInputQ(), "Email");
//
//        softAssert.assertAll();
//    }
//
//
//    @Test(priority = 20, description = "Validate on Sign Up Pop Up sign up with valid Email")
//    @Description("Validate on Sign Up Pop Up sign up with valid Email")
//    @Severity(SeverityLevel.BLOCKER)
//    public void SignUpPopUpQuickRegisterWithEmailPositiveTest() {
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Email");
//        logger.info("Email was selected From Email/Mobile DropDown ");
//        craftWorld_05_signUp_popUp_page.sendKeysEmailInputQ(craftWorld_05_signUp_popUp_page.generateRandomEmailValid());
//        logger.info("Valid random email was created and passed");
//        craftWorld_05_signUp_popUp_page.clickOnCheckBoxTermsConditionsQ();
//        logger.info("Terms and Conditions checkbox was selected");
//        craftWorld_05_signUp_popUp_page.clickOnButtonRegisterQ();
//        logger.info("Register button was clicked");
//        Assert.assertEquals(craftBet_01_header_pageLogInUser.balanceIsVisible(), true);
//
//    }
//
//    @Test(priority = 21, dataProvider = "invalidData", description = "Validate on Sign Up Pop Up sign up with valid Email")
//    @Description("Validate on Sign Up Pop Up sign up with valid Email")
//    @Severity(SeverityLevel.BLOCKER)
//    public void SignUpPopUpQuickRegisterWithEmailNegativeTest(String invalidEmail) {
//        try {
//            double invalidDoubleData = Double.parseDouble(invalidEmail);
//            int invalidIntData = (int) invalidDoubleData;
//            //invalidStringData = String.valueOf(invalidIntData);
//            invalidEmail = String.valueOf(invalidIntData);
//        } catch (Exception e) {
//            //invalidStringData = data;
//        }
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Email");
//        logger.info("Chosen Email from drop down");
//        craftWorld_05_signUp_popUp_page.sendKeysEmailInputQ(invalidEmail);
//        logger.info("invalid Email sent: -->" + invalidEmail);
//        craftWorld_05_signUp_popUp_page.clickOnCheckBoxTermsConditionsQ();
//        logger.info("Terms and conditions checkbox clicked");
//        craftWorld_05_signUp_popUp_page.clickOnButtonRegisterQ();
//        logger.info("Register button clicked");
//        String errorMessage = craftWorld_05_signUp_popUp_page.getTextErrorMessage();
//        logger.info("Error message captured");
//        Assert.assertEquals(errorMessage, "Invalid email address");
//    }

    @DataProvider(name = "invalidData")
    Object[][] invalidSignUpDataEmail() throws IOException {
        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\InvalidData.xlsx";
        FileInputStream file = new FileInputStream(invalidData);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("SignUpQuickInvalidEmail");
        //XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRow = sheet.getLastRowNum();
        int numberOfCol = sheet.getRow(0).getLastCellNum();

        String[][] arr = new String[numberOfRow][numberOfCol];
        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 0; j < numberOfCol; j++) {
                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
            }
        }
        file.close();
        return arr;
    }

//    @DataProvider(name = "invalidData")
//    public Object[][] invalidSignUpDataEmail() {
//
//            Object invalidLoginData[][] = {{generateRandomEmailInValid1()},{generateRandomEmailInValid2()},
//                                           {generateRandomEmailInValid3()},{generateRandomEmailInValid4()},
//                                           {generateRandomEmailInValid5()},{generateRandomEmailInValid6()}};
//            return invalidLoginData;
//    }


//    @Test(priority = 30, description = "Validate on Sign Up Pop Up sign up with valid Phone number")
//    @Description("Validate on Sign Up Pop Up sign up with valid Phone number")
//    @Severity(SeverityLevel.BLOCKER)
//    public void SignUpPopUpQuickRegisterWithMobilePositiveTest() {
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Mobile");
//        logger.info("Mobile was selected From Email/Mobile DropDown ");
////        craftWorld_05_signUp_popUp_page.clickOnMobileDropDownQ();
////        craftWorld_05_signUp_popUp_page.clickOnMobileArmQ();
////        logger.info("Am+374 was selected From Email/Mobile DropDown ");
//        craftWorld_05_signUp_popUp_page.sendKeysMobileInputQ(craftWorld_05_signUp_popUp_page.generateRandomMobileNumberValid());
//        logger.info("Valid random number was created and passed");
//        craftWorld_05_signUp_popUp_page.clickOnCheckBoxTermsConditionsQ();
//        logger.info("Terms and Conditions checkbox was selected");
//        craftWorld_05_signUp_popUp_page.clickOnButtonRegisterQ();
//        logger.info("Register button was clicked");
//        Assert.assertEquals(craftBet_01_header_pageLogInUser.balanceIsVisible(), true);
//
//    }
//
//    @Test(priority = 31, dataProvider = "invalidMobileData", description = "Validate on Sign Up Pop Up sign up with Invalid Phone number")
//    @Description("Validate on Sign Up Pop Up sign up with Invalid Phone number")
//    @Severity(SeverityLevel.BLOCKER)
//    public void SignUpPopUpQuickRegisterWithMobileNegativeTest(String number) throws InterruptedException {
//        craftWorld_05_signUp_popUp_page.selectEmailMobileDropDownQ("Mobile");
//        logger.info("Mobile was selected From Email/Mobile DropDown ");
////        craftWorld_05_signUp_popUp_page.clickOnMobileDropDownQ();
////        craftWorld_05_signUp_popUp_page.clickOnMobileArmQ();
////        logger.info("Am+374 was selected From Email/Mobile DropDown ");
//        craftWorld_05_signUp_popUp_page.sendKeysMobileInputQ(number);
//        logger.info("InValid number was created and passed -->" + number + "<--");
//        craftWorld_05_signUp_popUp_page.clickOnCheckBoxTermsConditionsQ();
//        logger.info("Terms and Conditions checkbox was selected");
//        craftWorld_05_signUp_popUp_page.waitAction(1000);
//        Assert.assertEquals(craftWorld_05_signUp_popUp_page.getAttributeClassButtonRegisterQ(), "craft_btn reg_btn not_active");
//        //softAssert.assertEquals(craftBet_signUp_popUp_page.getAttributeClassButtonRegisterQ(), "craft_btn reg_btn active-item");
//    }

    @DataProvider(name = "invalidMobileData")
    Object[][] invalidSignUpDataMobile() throws IOException {
        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\InvalidData.xlsx";
        FileInputStream file = new FileInputStream(invalidData);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("SignUpQuickInvalidNumber");
        //XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRow = sheet.getLastRowNum();
        int numberOfCol = sheet.getRow(0).getLastCellNum();

        String[][] arr = new String[numberOfRow][numberOfCol];
        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 0; j < numberOfCol; j++) {
                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
                try {
                    double invalidDoubleData = Double.parseDouble(arr[i - 1][j]);
                    int invalidIntData = (int) invalidDoubleData;
                    //invalidStringData = String.valueOf(invalidIntData);
                    arr[i - 1][j] = String.valueOf(invalidIntData);
                } catch (Exception e) {
                    arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        }
        file.close();
        return arr;
    }

//    @DataProvider(name = "invalidMobileData")
//    public Object[][] invalidSignUpDataMobile() {
//
//        Object invalidLoginData[][] = {{"123 45 6"},{"123/45/6"},{"123456  "},
//                                       {"123+45-6"},{"123456"},  {" 1 2 3 4 5 6 7 "}};
//        return invalidLoginData;
//    }


    //Abc.example.com no @ character
    public String generateRandomEmailInValid1() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + ".gmail.com";
        return randomEmail;
    }

    //A@b@c@example.com   only one @ is allowed outside quotation marks
    public String generateRandomEmailInValid2() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(5);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(5);
        randomEmail = generatedString1 + "@" + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    //a"b(c)d,e:f;g<h>i[j\k]l@example.com    ( "  none of the special characters in this local-part are allowed outside quotation marks )
    public String generateRandomEmailInValid3() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\\" + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    // just"not"right@example.com (quoted strings must be dot separated or the only element making up the local-part)
    public String generateRandomEmailInValid4() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\"" + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    //this is"not\allowed@example.com (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
    public String generateRandomEmailInValid5() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + " " + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    //i_like_underscore@but_its_not_allowed_in_this_part.example.com (Underscore is not allowed in domain part)
    public String generateRandomEmailInValid6() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "_" + generatedString2 + "@gmail.com";
        return randomEmail;
    }
}



