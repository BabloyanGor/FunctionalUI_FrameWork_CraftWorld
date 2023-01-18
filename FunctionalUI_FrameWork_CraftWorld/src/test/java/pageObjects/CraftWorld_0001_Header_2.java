package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CraftWorld_0001_Header_2 extends BasePage{
    private final BasePage basePage;


    public CraftWorld_0001_Header_2(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   HeaderPanel2Menu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @FindBy (xpath = "//div[@class='header-section_bottomPanel flex_between']//li[not (contains (@data-id, 'header-panel2-menu-more-menu'))]")
    List<WebElement> Header2AllLinks;

    public List<WebElement> getHeader2AllLinks() {
        try{
            return Header2AllLinks;
        }
        catch(Exception e){
            logger.error("getHeader2AllLinks() method has an Exception: " + e);
        }
        return null;
    }


    @FindBy(xpath = "//li[contains (@data-id, 'header-panel2-menu-more-menu')]")
    @CacheLookup
    WebElement moreDropDownHeader2;
    public void moveToMoreDropDownHeader2() {
        try {
            basePage.actionMoveToElement(moreDropDownHeader2);
        }
        catch (Exception e) {
            logger.error("moveToMoreDropDownHeader2() method has an Exception: " + e);
        }

    }

    public boolean checkMoreDropDownHeader2Visibility() {
        try {
            basePage.waitElementToBeVisible(moreDropDownHeader2);
            return true;
        } catch (Exception e) {
            return false;
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
