package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class CraftBet_02_Footer_Page extends BasePage {
    private final BasePage basePage;

    public CraftBet_02_Footer_Page(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

    //region <The first Footer column <<Legal>> >

    @FindBy(xpath = "//div[@class='footer-column styleType-ft-menu-item TEST_FooterMenu_LEGAL']/div")
    @CacheLookup
    WebElement legalLink;

    public void clickOnLegalLinkIfVisible() {
        try {
            javaScriptClick(legalLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'AND CONDITIONS TEST')]")
    @CacheLookup
    WebElement termsConditionsLink;

    public void clickOnTermsConditionsLinkIfVisible() {
        try {
            javaScriptClick(termsConditionsLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMING TEST')]")
    @CacheLookup
    WebElement responseGamingLink;

    public void clickOnResponseGamingLinkIfVisible() {
        try {
            javaScriptClick(responseGamingLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'EXCLUSION TEST')]")
    @CacheLookup
    WebElement selfExclusionLink;

    public void clickOnSelfExclusionLinkIfVisible() {
        try {
            javaScriptClick(selfExclusionLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'RESOLUTION TEST')]")
    @CacheLookup
    WebElement resolutionLink;

    public void clickOnResolutionLinkIfVisible() {
        try {
            javaScriptClick(resolutionLink);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//a[contains (@class, 'LEGAL_AML')]")
    @CacheLookup
    WebElement legalAMLLink;

    public void clickOnLegalAMLLinkIfVisible() {
        try {
            javaScriptClick(legalAMLLink);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//a[contains (@class, 'AND GAMING RNG')]")
    @CacheLookup
    WebElement fairGamingAMGLink;

    public void clickOnFairGamingAMGLinkIfVisible() {
        try {
            javaScriptClick(fairGamingAMGLink);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//a[contains (@class, 'POLICY TEST')]")
    @CacheLookup
    WebElement privacyPolicyLink;

    public void clickOnPrivacyPolicyLinkIfVisible() {
        try {
            javaScriptClick(privacyPolicyLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'BONUSES PAYOUTS')]")
    @CacheLookup
    WebElement accountPayOutsBonusesLink;

    public void clickOnAccountPayOutsBonusesLinkIfVisible() {
        try {
            javaScriptClick(accountPayOutsBonusesLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'AND DATA MANAGEMENT OF PERSONAL POLICIES')]")
    @CacheLookup
    WebElement KYSPoliciesLink;

    public void clickOnKYSPoliciesLinkLinkIfVisible() {
        try {
            javaScriptClick(KYSPoliciesLink);
        } catch (Exception e) {
        }
    }

    //endregion

    //region <The Second Footer column <<SportsBook>>>
    @FindBy(xpath = "//div[contains (@class, 'TEST_FooterMenu_SPORTSBOOK')]/div")
    @CacheLookup
    WebElement sportsBookLink;

    public void clickOnSportsBookLinkIfVisible() {
        try {
            javaScriptClick(sportsBookLink);
        } catch (Exception e) {
        }
    }
    @FindBy(xpath = "//a[contains (@class, 'SPORTSBOOK_PREMIER')]")
    @CacheLookup
    WebElement premierLink;

    public void clickOnPremierLinkIfVisible() {
        try {
            javaScriptClick(premierLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'SPORTSBOOK_LIGUE')]")
    @CacheLookup
    WebElement ligueOneLink;

    public void clickOnLigueOneLinkIfVisible() {
        try {
            javaScriptClick(ligueOneLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'SPORTSBOOK_BUNDESLIGA')]")
    @CacheLookup
    WebElement bundesligaLink;

    public void clickOnBundesligaLinkIfVisible() {
        try {
            javaScriptClick(bundesligaLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'SPORTSBOOK_SERIE')]")
    @CacheLookup
    WebElement serieALink;

    public void clickOnSerieALinkIfVisible() {
        try {
            javaScriptClick(serieALink);
        } catch (Exception e) {
        }
    }


    @FindBy(xpath = "//a[contains (@class, 'SPORTSBOOK_CHAMPIONS')]")
    @CacheLookup
    WebElement championsLink;

    public void clickOnChampionsLinkIfVisible() {
        try {
            javaScriptClick(championsLink);
        } catch (Exception e) {
        }
    }

    //endregion

    //region <The Third Footer column <<Casino & Life Casino>> >

    @FindBy(xpath = "//div[contains (@class, 'TEST_FooterMenu_CASINO')]/div")
    @CacheLookup
    WebElement casinoLifeCasinoLink;
    public void clickOnCasinoLifeCasinoLinkIfVisible() {
        try {
            javaScriptClick(casinoLifeCasinoLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'CASINO_EVOLUTION LIVE')]")
    @CacheLookup
    WebElement evolutionLink;
    public void clickOnEvolutionLinkIfVisible() {
        try {
            javaScriptClick(evolutionLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'CASINO_EZUGI LIVE')]")
    @CacheLookup
    WebElement ezugiLink;
    public void clickOnEzugiLinkIfVisible() {
        try {
            javaScriptClick(ezugiLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'CASINO_TOM HORN')]")
    @CacheLookup
    WebElement casinoTomHornLink;
    public void clickOnCasinoTomHornLinkIfVisible() {
        try {
            javaScriptClick(casinoTomHornLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'CASINO_ZEYS LIVE')]")
    @CacheLookup
    WebElement casinoZeysLink;
    public void clickOnCasinoZeysLinkLinkIfVisible() {
        try {
            javaScriptClick(casinoZeysLink);
        } catch (Exception e) {
        }
    }


    //endregion

    //region <The Fourth Footer column <<Casino & Life Casino>> >

    @FindBy(xpath = "//div[contains (@class, 'TEST_FooterMenu_VIRTUAL GAMES')]/div")
    @CacheLookup
    WebElement virtualGamesLink;

    public void clickOnVirtualGamesLinkIfVisible() {
        try {
            javaScriptClick(virtualGamesLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, '37 GAMES_BINGO')]")
    @CacheLookup
    WebElement Bingo37Link;

    public void clickOnBingo37LinkIfVisible() {
        try {
            javaScriptClick(Bingo37Link);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_KENO TEST')]")
    @CacheLookup
    WebElement KenoLink;

    public void clickOnKenoLinkIfVisible() {
        try {
            javaScriptClick(KenoLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_CRASH TEST')]")
    @CacheLookup
    WebElement crashLink;

    public void clickOnCrashLinkIfVisible() {
        try {
            javaScriptClick(crashLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_HIGH LOW TEST')]")
    @CacheLookup
    WebElement HighLowLink;

    public void clickOnHighLowLinkIfVisible() {
        try {
            javaScriptClick(HighLowLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_BET ON RACING TEST')]")
    @CacheLookup
    WebElement betOnRacingLink;

    public void clickOnBetOnRacingLinkIfVisible() {
        try {
            javaScriptClick(betOnRacingLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_BET ON POKER TEST')]")
    @CacheLookup
    WebElement betOnPokerLink;

    public void clickOnBetOnPokerLinkIfVisible() {
        try {
            javaScriptClick(betOnPokerLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, '47 GAMES_BINGO TEST')]")
    @CacheLookup
    WebElement bingo47Link;

    public void clickOnBingo47LinkIfVisible() {
        try {
            javaScriptClick(bingo47Link);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_COLORS TEST')]")
    @CacheLookup
    WebElement colorsLink;
    public void clickOnColorsLinkIfVisible() {
        try {
            javaScriptClick(colorsLink);
        } catch (Exception e) {
        }
    }

    @FindBy(xpath = "//a[contains (@class, 'GAMES_MINESWEEPER TEST')]")
    @CacheLookup
    WebElement minesweeperLink;
    public void clickOnMinesweeperLinkIfVisible() {
        try {
            javaScriptClick(minesweeperLink);
        } catch (Exception e) {
        }
    }








    //endregion













}
