package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftWorld_11_Sports_Page extends BasePage{
    private final BasePage basePage;

    public CraftWorld_11_Sports_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    @FindBy(xpath = "//iframe[@id='main-game-iframe']")
    @CacheLookup
    WebElement mainGameIframe;

    public boolean mainGameIframeIsVisible() {
        try{
            basePage.waitFrameToBeAvailable(mainGameIframe);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }
















}
