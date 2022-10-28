package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftBet_06_Deposit_Page extends BasePage {

    private final BasePage basePage;

    public CraftBet_06_Deposit_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }


    @FindBy(xpath = "//span[@class='payment-btn__span']")
    @CacheLookup
    WebElement confirmButtonLabel;

    public void confirmButtonIsEnabled() {
          basePage.waitElementToBeVisible(confirmButtonLabel);

    }
    @FindBy(xpath = "//ul[@class= 'user-left-panel_topList']/li[1]")
    @CacheLookup
    WebElement depositDropDown;

    public void depositDropDownIsEnabled() {
        basePage.elementIsEnable(confirmButtonLabel);
    }

















}