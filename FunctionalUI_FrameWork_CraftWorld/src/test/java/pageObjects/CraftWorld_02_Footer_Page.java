package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftWorld_02_Footer_Page extends BasePage {
    private final BasePage basePage;

    public CraftWorld_02_Footer_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }
//*[@class='footer-column_title' or contains (@class, 'footer-column_item')]   //footer menus Titles and links

    @FindBy(xpath = "//div[contains (@class, 'footer-section_boxMenu')]//div[contains (@class, 'footer-column_title')]")
    java.util.List<WebElement> footerTitlesLinks;

    public java.util.List<WebElement> footerTitlesLinks() {
        return footerTitlesLinks;
    }


    @FindBy(xpath = "//div[@class= 'footer-section_boxMenu styleType-ft-menu-item_boxMenu' ]//a")
    java.util.List<WebElement> footerLinks;

    public java.util.List<WebElement> footerMenuLinks() {
        return footerLinks;
    }





    @FindBy(xpath = "//div[contains (@class, 'footer-open-button')]")
    @CacheLookup
    WebElement openButtonFooterLink;

    public void clickOnOpenFooterLink() {
        try {
            javaScriptClick(openButtonFooterLink);
        } catch (Exception e) {
        }
    }

    public boolean openFooterButtonIsDisplayed(){
        try{
            return elementIsDisplayed(openButtonFooterLink);
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean footerIsOpen(){
        try{
            String className = getAttribute(openButtonFooterLink,"class");
            if (className.contains("180")){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }


    }







}
