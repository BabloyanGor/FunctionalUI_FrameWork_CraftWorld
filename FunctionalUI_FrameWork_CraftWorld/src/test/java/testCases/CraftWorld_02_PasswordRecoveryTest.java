//package testCases;
//
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.awt.*;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class CraftWorld_02_PasswordRecoveryTest extends BaseTest{
//
//
//    public CraftWorld_02_PasswordRecoveryTest() throws AWTException {
//    }
//
//    @BeforeMethod
//    public void goToLoginPopUp() {
//        craftWorld_01_header_page_logOutUser.clickOnLogInButtonIfVisible();
////        craftWorld_0000_login_popUp_page.clickLoginPopUpForgotPassword();
//    }
//
//
//
//
//    @Test(priority = 1, description = "Validate on Password Recovery PopUp Title, Email/mobile or username input Label, Info Message," +
//                                      " Help message, Text on Send Me Recovery Button")
//    @Description("Validate on Password Recovery PopUp Title, Email/mobile or username input Label, Info Message," +
//                  " Help message, Text on Send Me Recovery Button")
//    @Severity(SeverityLevel.MINOR)
//    public void RecoveryPopUpLabelsPresenceVerification_Test() {
//        SoftAssert softAssert = new SoftAssert();
//        String actTitle = craftWorld_04_passwordRecovery_page.getTitleText();
//        logger.info("Title Captured");
//        String actEmailInputLabel = craftWorld_04_passwordRecovery_page.getEmailInputsLabel();
//        logger.info("Emails label Captured");
//        String actFormLabelInfo = craftWorld_04_passwordRecovery_page.getFormLabelInfo();
//        logger.info("Info message Captured");
//        String actHelpMessageLabel = craftWorld_04_passwordRecovery_page.getHelpMessageLabel();
//        logger.info("Help message Captured");
//        String actTextOnSendMeRecoveryButton = craftWorld_04_passwordRecovery_page.getTextOnSendMeRecoveryButton();
//        logger.info("Text on Send Me Recovery Button Captured");
//
//        String expectedTitle = "Password recovery";
//        String expectedEmailInputLabel = "E-mail / Phone number";
//        String expectedFormLabelInfo = "Number format: +country code (area code) (phone number). Example: +7 212 533 39 09";
//        String expectedHelpMessageLabel = "We can help you reset your password using your mobile number or the email address linked to your account.";
//        String expectedTextOnSendMeRecoveryButton = "Send Me Recovery Link";
//
//        softAssert.assertEquals(actTitle, expectedTitle);
//        logger.info("Title checked");
//        softAssert.assertEquals(actEmailInputLabel, expectedEmailInputLabel);
//        logger.info("Email Input Label checked");
//        softAssert.assertEquals(actFormLabelInfo, expectedFormLabelInfo);
//        logger.info("Form Label Info checked");
//        softAssert.assertEquals(actHelpMessageLabel, expectedHelpMessageLabel);
//        logger.info("Help Message checked");
//        softAssert.assertEquals(actTextOnSendMeRecoveryButton, expectedTextOnSendMeRecoveryButton);
//        logger.info("Text on Send Me Recovery Link button checked");
//
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 2, description = "Validate on Password Recovery Pop Up Logo Presence")
//    @Description("Validate on Password Recovery Pop Up Logo Presence")
//    @Severity(SeverityLevel.MINOR)
//    public void RecoveryPopUpLogoPresenceVerification_Test() {
//        Assert.assertEquals(craftWorld_04_passwordRecovery_page.logoExistenceVerification(), true);
//        logger.info("logo existence checked");
//    }
//
//
//    @Test(priority = 3, description = "Validate on Password Recovery Pop Up Support link")
//    @Description("Validate on Password Recovery Pop Up Support link")
//    @Severity(SeverityLevel.MINOR)
//    public void RecoveryPopUpSupportLink_Test() {
//        String RecoveryUrl = craftWorld_04_passwordRecovery_page.getUrl();
//        logger.info("Password recovery page url captured");
//        craftWorld_04_passwordRecovery_page.clickOnSupportLink();
//        logger.info("Password recovery page support link clicked");
//        String supportUrl = craftWorld_04_passwordRecovery_page.getUrl();
//        logger.info("Support page url captured");
//        Assert.assertNotEquals(RecoveryUrl, supportUrl);
//    }
//
//
//    @Test(priority = 4, description = "Validate on Password recovery pop up functionality of Recovery with valid credentials")
//    @Description("Validate on Password recovery pop up functionality of Recovery with valid credentials")
//    @Severity(SeverityLevel.BLOCKER)
//    public void RecoveryPopUpPositiveTest() {
//        craftWorld_04_passwordRecovery_page.sendKeysToEmailPhoneInput("g.babloyan@iqsoft.am");
//        logger.info("email passed");
//        craftWorld_04_passwordRecovery_page.clickOnSendMeRecoveryButton();
//        logger.info("Send me password Recovery Button was clicked");
//        String actSuccessMessage = craftWorld_04_passwordRecovery_page.getSuccessMessage();
//
//        if (actSuccessMessage.contains("successfully sent")){
//            Assert.assertTrue(true, actSuccessMessage);
//        }
//        else{
//            Assert.assertTrue(false, actSuccessMessage);
//        }
//    }
//
//
//
//
//    @Test(priority = 5, dataProvider = "invalidRecoveryData", description = "Validate on Password recovery pop up functionality of Recovery with invalid credentials")
//    @Description("Validate on Password recovery pop up functionality of Recovery with invalid credentials")
//    @Severity(SeverityLevel.BLOCKER)
//    public void RecoveryPopUpNegativeTest(String data) {
//
//        craftWorld_04_passwordRecovery_page.sendKeysToEmailPhoneInput(data);
//        logger.info("password recovery input passed: --->" + data + "<---");
//        craftWorld_04_passwordRecovery_page.clickOnSendMeRecoveryButton();
//        logger.info("Send me password Recovery Button was clicked");
//
//
//        if ( craftWorld_04_passwordRecovery_page.getErrorMessage().equals("Wrong recovery input") ) {
////            logger.info("Success message: --->" + craftWorld_04_passwordRecovery_page.getMailSuccessMessage() + "<---");
////            logger.info("Error message: --->" + craftWorld_04_passwordRecovery_page.getErrorMessage() + "<---");
//            Assert.assertTrue(true);
//            logger.info("Wrong recovery input error message received");
//        } else {
//            Assert.assertTrue(false);
////            logger.info("Success message: --->" + craftWorld_04_passwordRecovery_page.getMailSuccessMessage() + "<---");
////            logger.info("Error message: --->" + craftWorld_04_passwordRecovery_page.getErrorMessage() + "<---");
//            logger.info("Wrong recovery input error message not received");
//        }
//    }
//
//    @DataProvider(name = "invalidRecoveryData")
//    Object[][] RecoveryInvalidData() throws IOException {
//        String invalidData = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\InvalidData.xlsx";
//        FileInputStream file = new FileInputStream(invalidData);
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheet("PasswordRecoveryInvalidData");
//        //XSSFSheet sheet = workbook.getSheetAt(0);
//        int numberOfRow = sheet.getLastRowNum();
//        int numberOfCol = sheet.getRow(0).getLastCellNum();
//
//        String[][] arr = new String[numberOfRow][numberOfCol];
//        for (int i = 1; i <= numberOfRow; i++) {
//            for (int j = 0; j < numberOfCol; j++) {
//                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
//                try {
//                    double invalidDoubleData = Double.parseDouble(arr[i - 1][j]);
//                    int invalidIntData = (int) invalidDoubleData;
//                    //invalidStringData = String.valueOf(invalidIntData);
//                    arr[i - 1][j] = String.valueOf(invalidIntData);
//                } catch (Exception e) {
//                    //invalidStringData = data;
//                }
//            }
//        }
//        file.close();
//        return arr;
//    }
////    @DataProvider(name = "invalidRecoveryData")
////    public Object[][] RecoveryInvalidData() {
////        Object invalidRecoveryData[][] = {{" g.babloyan@iqsoft.am"}, {"g.babloyan@iqsoft.am "}, {"g .babloyan@iqsoft.am"},
////                                          {"g. babloyan@iqsoft.am"}, {"g.babloyan @iqsoft.am"},{"g.babloyan@iqsoft.a m"}};
////        return invalidRecoveryData;
////    }
//
//
//
//
//
//
//
//}
