package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftWorld_07_Message_Page extends BasePage{
    private final BasePage basePage;

    public CraftWorld_07_Message_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    @FindBy(xpath = "//button[@class='craft_btn']")
    @CacheLookup
    WebElement newMessageButtonLabel;

    public void newMessageButtonLabelIsEnabled() {
        basePage.waitElementToBeVisible(newMessageButtonLabel);

    }


}
