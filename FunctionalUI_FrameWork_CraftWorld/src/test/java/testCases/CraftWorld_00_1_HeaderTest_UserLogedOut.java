package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class CraftWorld_00_1_HeaderTest_UserLogedOut extends BaseTest {

    int waitTime = 3000;

    public CraftWorld_00_1_HeaderTest_UserLogedOut() throws AWTException {
    }

    @BeforeMethod
    public void logIn() {
        craftWorld_01_header_page_logOutUser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @Test(priority = 20, description = "Validate on HeaderMenu2 links functionality")
    @Description("Validate on HeaderMenu2 links functionality")
    @Severity(SeverityLevel.BLOCKER)
    public void headerMenu2LinksFunctionalityTest() throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();
        craftWorld_01_header_page_logOutUser.headerPanel2BottomLinks();
        for (int k = 0; k< craftWorld_01_header_page_logOutUser.bottomMenuAllLinks().size()-1; k++){
            try{
                if (basePage.LinkTitle.get(k).equals("Separator")){
                }
                else {
                    craftWorld_01_header_page_logOutUser.javaScriptClick(craftWorld_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftWorld_01_header_page_logOutUser.waitAction(2000);
                    softAssert.assertEquals(craftWorld_01_header_page_logOutUser.getUrl(), craftWorld_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftWorld_01_header_page_logOutUser.getUrl());
                }
            }
            catch (Exception e1){
                try{
                    craftWorld_01_header_page_logOutUser.actionMoveToElement(craftWorld_01_header_page_logOutUser.bottomMenuAllLinks().get(k-1));
                    craftWorld_01_header_page_logOutUser.javaScriptClick(craftWorld_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftWorld_01_header_page_logOutUser.waitAction(2000);

                    softAssert.assertEquals(craftWorld_01_header_page_logOutUser.getUrl(), craftWorld_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftWorld_01_header_page_logOutUser.getUrl());
                }
                catch(Exception e2){
                    craftWorld_01_header_page_logOutUser.moveToMoreDropDown();
                    craftWorld_01_header_page_logOutUser.javaScriptClick(craftWorld_01_header_page_logOutUser.bottomMenuAllLinks().get(k));
                    craftWorld_01_header_page_logOutUser.waitAction(2000);

                    softAssert.assertEquals(craftWorld_01_header_page_logOutUser.getUrl(), craftWorld_01_header_page_logOutUser.LinkHref.get(k),
                            "Link Title: "+basePage.LinkTitle.get(k) + "Url: " + craftWorld_01_header_page_logOutUser.getUrl());
                }

            }


        }
        softAssert.assertAll();

    }



















}
