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










    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel2Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy (xpath = "//div[@class='header-section_bottomPanel flex_between']//li[not (contains (@class, 'TEST_HeaderPanel2Menu_MoreMenu'))]")
    java.util.List<WebElement> bottomMenuLinks;

    public List<WebElement> bottomMenuAllLinks() {
        return bottomMenuLinks;
    }



   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel1Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<















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



